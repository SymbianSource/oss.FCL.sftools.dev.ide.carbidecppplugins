/*
* Copyright (c) 2007 Nokia Corporation and/or its subsidiary(-ies). 
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
 
 
package com.nokia.s60tools.creator.dialogs;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.nokia.s60tools.creator.components.AbstractComponent;
import com.nokia.s60tools.creator.components.AbstractValue;
import com.nokia.s60tools.creator.components.AbstractValue.ModeTypes;
import com.nokia.s60tools.creator.components.connectionmethod.ConnectionMethod;
import com.nokia.s60tools.creator.components.connectionmethod.ConnectionMethodValue;
import com.nokia.s60tools.creator.components.connectionmethod.ConnectionMethodVariables;
import com.nokia.s60tools.creator.editors.IComponentProvider;


/**
 *
 */
public class ConnectionMethodDialog extends AbstractDialog {

	
	public ConnectionMethodDialog(Shell sh, IComponentProvider provider) {
		super(sh, provider);
		init();
	}

	/**
	 * Initialize, creates Contact object
	 */
	private void init(){
		if(getComponent() == null){
			AbstractComponent comp = new ConnectionMethod(AbstractComponent.NULL_ID);
			setComponent(comp);
		}		
	}
  
    
	
	protected ConnectionMethod createNewComponent(){
		return new ConnectionMethod(AbstractComponent.NULL_ID);
	}
	
	
	protected ConnectionMethodValue createNewValue(String type, String value, String random, String amount) {

		int amout_ = 0;
		ModeTypes random_ = ModeTypes.RandomTypeNotRandom;
		String value_ = value;
		
		//If amount is set
		if(amount != null && amount.trim().length() > 0){
			amout_ = Integer.parseInt(amount);
		}
		
		//if random is selected
		if(random != null && random.trim().length() > 0 && !random.equals(AbstractValue.EMPTY_STRING)){
			random_ = AbstractValue.getModeTypeByText(random);
			if(random_ != ModeTypes.RandomTypeNotRandom){
				value_ = AbstractValue.RANDOM_TEXT;
			}
		}
		return new ConnectionMethodValue(value_, random_, amout_);
	}

	
	/* (non-Javadoc)
	 * @see com.nokia.s60tools.creator.dialogs.AbstractDialog#getItemValueAsString()
	 */
	protected String[] getItemTypesAsString() {
		return ConnectionMethodVariables.getInstance().getItemValuesAsString();
	}

	/* 
	 * (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createDialogArea(Composite parent) {
		
		Composite composite = createDialogAreaComposite(parent);
		//Create Amount area
		createAmountArea(composite);
		//Create table area
		createTableArea(composite);		
		
		if(isAmountFieldsEnabled() ){
			addInformation(composite, AMOUNT_FIELD_INFO_TEXT);
		}
		
		if(wasErrors()){
			showErrorDialog("Errors occured when dialog opened", getErrors());
		}
		
		return composite;
	}	
	
}
