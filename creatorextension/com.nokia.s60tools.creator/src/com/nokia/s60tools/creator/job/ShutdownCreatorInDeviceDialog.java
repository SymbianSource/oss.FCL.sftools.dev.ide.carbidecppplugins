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


package com.nokia.s60tools.creator.job;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.nokia.s60tools.creator.common.ProductInfoRegistry;
import com.nokia.s60tools.creator.preferences.CreatorPreferences;
import com.nokia.s60tools.creator.resources.Messages;

/**
 * Dialog for asking confirmation for file replace from user
 */
public class ShutdownCreatorInDeviceDialog extends Dialog {
	
	
	// Selected button
	private int selection = 0;
	
	// UI components
	private Button dontShowAgainBtn = null;
	
	/**
	 * Constructor
	 * @param parentShell Shell
	 * @param destFileName Name of the script file
	 */
	public ShutdownCreatorInDeviceDialog(Shell parentShell) {
		super(parentShell);
	}
	
    /* (non-Javadoc)
     * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
     */
    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        shell.setText(ProductInfoRegistry.getProductName());
    } 	
	
	/* (non-Javadoc)
     * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
     */
    protected void createButtonsForButtonBar(Composite parent) {
    	GridLayout gdl = new GridLayout(1, false);
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		parent.setLayout(gdl);
		parent.setLayoutData(gd);
		
    	createButton(parent, IDialogConstants.YES_ID, IDialogConstants.YES_LABEL, true);
    	createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, true);    	
    }
    
    /* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createDialogArea(Composite parent) {
		Composite dialogAreaComposite = (Composite) super.createDialogArea(parent);		
		Label label = new Label(dialogAreaComposite,SWT.NONE);
		String txt = Messages.getString("ShutdownCreatorInDeviceDialog.Msg");//$NON-NLS-1$

		label.setText(txt); 
		 
		// "Don't ask again" check box
		dontShowAgainBtn  = new Button(dialogAreaComposite, SWT.CHECK);
		dontShowAgainBtn.setText(Messages.getString("ShutdownCreatorInDeviceDialog.DontAskAgain_Txt")); //$NON-NLS-1$
		dontShowAgainBtn.setSelection(CreatorPreferences.getDontAskShutdownCreator());
		return dialogAreaComposite;
	}    
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#buttonPressed(int)
	 */
	protected void buttonPressed(int buttonId) {
		// Save pressed button id
		selection = buttonId;
		
		if (buttonId != IDialogConstants.CANCEL_ID) {
			// Save "Don't ask again" state
			CreatorPreferences.setDontAskShutdownCreator(dontShowAgainBtn
							.getSelection());
		}
		super.close();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.window.Window#open()
	 */
	public int open(){
		return super.open();
	}
	
	/**
	 * Returns id of selected button
	 * @return Id of selected button
	 */
	public int getSelection() {
		return selection;
	}
}
