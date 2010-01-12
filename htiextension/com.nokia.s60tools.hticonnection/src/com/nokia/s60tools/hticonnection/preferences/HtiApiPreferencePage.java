/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description:
*
*/

package com.nokia.s60tools.hticonnection.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;

import com.nokia.carbide.remoteconnections.RemoteConnectionsActivator;
import com.nokia.carbide.remoteconnections.interfaces.IClientServiceSiteUI;
import com.nokia.carbide.remoteconnections.interfaces.IConnection;
import com.nokia.carbide.remoteconnections.interfaces.IService;
import com.nokia.s60tools.hticonnection.HtiApiActivator;
import com.nokia.s60tools.hticonnection.HtiConnectionHelpContextIDs;
import com.nokia.s60tools.hticonnection.common.ProductInfoRegistry;
import com.nokia.s60tools.hticonnection.connection.HTIService;
import com.nokia.s60tools.hticonnection.core.HtiConnection;
import com.nokia.s60tools.hticonnection.core.HtiConnection.ConnectionStatus;
import com.nokia.s60tools.hticonnection.resources.Messages;

/**
 * Reference page for HTI API
 */
public class HtiApiPreferencePage extends PreferencePage implements
		IWorkbenchPreferencePage {
	/**
	 * Contains preference page components.
	 */
	private Composite container;

	/**
	 * UI component for configuring connection.
	 */
	private IClientServiceSiteUI clientSiteUI;
	
	/**
	 * Keeps information about if preferences page is created and open currently.
	 */
	private static boolean isCreated = false;
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.DialogPage#dispose()
	 */
	public void dispose() {
		super.dispose();
		isCreated = false;
	}

	/**
	 * Constructor
	 */
	public HtiApiPreferencePage() {
		super(ProductInfoRegistry.getProductName() + Messages.getString("HtiApiPreferencePage.Preferences_Postfix")); //$NON-NLS-1$
		isCreated = true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createContents(Composite parent) {
		
		container = new Composite(parent, SWT.SIMPLE);
		container.setLayout(new GridLayout(1, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		// Client Site UI for creating and selecting connection.
		IService service = RemoteConnectionsActivator.getConnectionTypeProvider().findServiceByID(HTIService.ID);
		clientSiteUI = RemoteConnectionsActivator.getConnectionsManager().getClientSiteUI(service);
		clientSiteUI.createComposite(container);
		
		// Current connection needs to be selected or first in the list is selected.
		IConnection currentConnection = HtiApiActivator.getPreferences().getCurrentConnection();
		if(currentConnection != null) {
			clientSiteUI.selectConnection(currentConnection);
		}

		setHelps(parent);
		
		return container;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
		// Not needed
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#performOk()
	 */
	public boolean performOk() {
		doApply();
		return super.performOk();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#performApply()
	 */
	public void performApply() {
		doApply();
	}
	
	/**
	 * Apply settings
	 */
	private void doApply(){
		savePrefStoreValues();
		
		// Getting needed variables.
		HtiConnection htiConnection = HtiConnection.getInstance();
		IConnection currentConnection = clientSiteUI.getSelectedConnection();

		// Restart datagateway if connection has been changed
		
		boolean isConnected = htiConnection.getConnectionStatus() != ConnectionStatus.SHUTDOWN;
		boolean isNewConnection = (currentConnection != null) && !(currentConnection.equals(htiConnection.getCurrentConnection())); 

		if (isConnected && isNewConnection) {
			// Connection has been changed when connection is started.
			restartDataGateway(currentConnection, false);
		}
		else if(!isConnected || currentConnection == null) {
			// Connection isn't active or connections have been deleted. New connection can be set. 
			HtiConnection.getInstance().setCurrentConnection(currentConnection, false);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
	 */
	protected void performDefaults() {
		super.performDefaults();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.PreferencePage#performCancel()
	 */
	public boolean performCancel() {
		return super.performCancel();
	}
	
	/**
	 * Saves values to prefstore
	 * @return True if saved successfully, else false
	 */
	private void savePrefStoreValues() {
		IConnection currentConnection = clientSiteUI.getSelectedConnection();
		String connectionID = (currentConnection == null) ? HtiApiPreferenceConstants.DEFAULT_CONNECTION_ID 
														: currentConnection.getIdentifier();
		if (!connectionID.equals(HtiApiActivator.getPreferences().getConnectionID())) {
			HtiApiActivator.getPreferences().setConnectionID(connectionID);
		}
	}

	/**
	 * Restarts Datagateway with settings from preference store.
	 * @param isTesting True if testing connection and not trying to establish permanent connection.
	 */
	private boolean restartDataGateway(IConnection conn, boolean isTesting) {
		HtiConnection htiConn = HtiConnection.getInstance();
		htiConn.stopConnection();
		htiConn.setCurrentConnection(conn, false);
		return htiConn.startConnection(isTesting);
	}

	/**
	 * Returns true if preferences page is created and open.
	 * @return True if page is created.
	 */
	public static boolean isCreated() {
		return isCreated;
	}
	
	/**
	 * Sets this page's context sensitive helps.
	 * @param helpContainer Container for which help is set.
	 */
	private void setHelps(Composite helpContainer) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(helpContainer,
										HtiConnectionHelpContextIDs.HTI_CONNECTION_PREFERENCES);
	}
}
