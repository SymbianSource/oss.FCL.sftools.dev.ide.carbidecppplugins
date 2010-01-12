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

package com.nokia.s60tools.remotecontrol.ftp.ui.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;

import com.nokia.s60tools.remotecontrol.resources.ImageKeys;
import com.nokia.s60tools.remotecontrol.resources.ImageResourceManager;
import com.nokia.s60tools.remotecontrol.resources.Messages;
import com.nokia.s60tools.remotecontrol.ui.AbstractUiFractionComposite;

/**
 * Composite for displaying and editing current file path.
 */
public class PathComposite extends AbstractUiFractionComposite
			implements KeyListener, SelectionListener {

	/**
	 * Editable text field containing path.
	 */
	private Text pathText;

	/**
	 * Button for going to current path.
	 */
	private Button goPathButton;

	/**
	 * Owner of this component.
	 */
	private final FtpView ftpView;
	
	/**
	 * Constructor.
	 * @param parentComposite Parent composite for the created composite.
	 * @param ftpView Owner of this composite.
	 */
	public PathComposite(Composite parentComposite, FtpView ftpView) {
		super(parentComposite, SWT.NONE);
		this.ftpView = ftpView;
	}

	/* (non-Javadoc)
	 * @see com.nokia.s60tools.remotecontrol.ui.AbstractUiFractionComposite#createControls()
	 */
	protected void createControls() {
		// Path label.
		Label pathLabel = new Label(this, SWT.HORIZONTAL);		
		pathLabel.setText(Messages.getString("PathComposite.directoryPath_LabelText")); //$NON-NLS-1$
		
		// Text field containing path.
		final int textFieldStyleBits = SWT.LEFT | SWT.SINGLE | SWT.BACKGROUND | SWT.BORDER;
		pathText = new Text(this, textFieldStyleBits);
		pathText.setEditable(true);
		pathText.setLayoutData((new GridData(GridData.FILL_HORIZONTAL)));
		
		// Go button.
		goPathButton = new Button(this, SWT.NONE);
		goPathButton.setImage(ImageResourceManager.getImage(ImageKeys.IMG_GO_TO_DIRECTORY));
		goPathButton.setToolTipText(Messages.getString("PathComposite.goButton_TooltipText")); //$NON-NLS-1$
		
		// Adding listeners.
		pathText.addKeyListener(this);
		goPathButton.addSelectionListener(this);
		
		goPathButton.setEnabled(false);
		pathText.setEnabled(false);
	}

	/* (non-Javadoc)
	 * @see com.nokia.s60tools.remotecontrol.ui.AbstractUiFractionComposite#createLayout()
	 */
	protected Layout createLayout() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		gridLayout.makeColumnsEqualWidth = false;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		return gridLayout;
	}

	/* (non-Javadoc)
	 * @see com.nokia.s60tools.remotecontrol.ui.AbstractUiFractionComposite#createLayoutData()
	 */
	protected Object createLayoutData() {
		return new GridData(GridData.FILL_HORIZONTAL);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	public void dispose() {
		super.dispose();
		pathText.removeKeyListener(this);
		goPathButton.removeSelectionListener(this);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Composite#setFocus()
	 */
	@Override
	public boolean setFocus() {
		return pathText.setFocus();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.KeyListener#keyPressed(org.eclipse.swt.events.KeyEvent)
	 */
	public void keyPressed(KeyEvent e) {
		if(e.keyCode == SWT.CR) {
			// Updating directory listing when Return is pressed.
			e.doit = false;
			ftpView.updatePathThenRefresh(pathText.getText());
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.KeyListener#keyReleased(org.eclipse.swt.events.KeyEvent)
	 */
	public void keyReleased(KeyEvent e) {
		// Not implemented.
	}

	/**
	 * Changes text in text field to path.
	 * @param path New path.
	 */
	public void setPath(String path) {
		pathText.setText(path);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		// Not implemented.
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		if(e.widget == goPathButton) {
			ftpView.updatePathThenRefresh(pathText.getText());
		}
	}

	/**
	 * Changes controls to enabled/disabled based on connection status.
	 * @param connected True if connection is up, false if connection is down.
	 */
	public void setConnected(boolean connected) {
		goPathButton.setEnabled(connected);
		pathText.setEnabled(connected);
	}
}
