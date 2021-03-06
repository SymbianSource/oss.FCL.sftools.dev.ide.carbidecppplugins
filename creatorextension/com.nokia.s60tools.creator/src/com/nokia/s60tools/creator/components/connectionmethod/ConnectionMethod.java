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
 
package com.nokia.s60tools.creator.components.connectionmethod;


import com.nokia.s60tools.creator.components.AbstractComponent;
import com.nokia.s60tools.creator.components.AbstractVariables;
import com.nokia.s60tools.creator.core.CreatorEditorSettings;


/**
 * Class representing Connection method 
 */
public class ConnectionMethod extends AbstractComponent {


	public ConnectionMethod(int id) {
		super(id);
	}	
	
	

	/* (non-Javadoc)
	 * @see com.nokia.s60tools.creator.components.config.AbstractComponent#getType()
	 */
	public String getType() {
		return CreatorEditorSettings.TYPE_CONNECTION_METHOD;
	}

	
	/* (non-Javadoc)
	 * @see com.nokia.s60tools.creator.components.AbstractComponent#isValid()
	 */
	public boolean isValid() {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.nokia.s60tools.creator.components.AbstractComponent#getIdByValue(java.lang.String)
	 */
	public String getIdByValue(String value) {		
		return ConnectionMethodVariables.getInstance().getIdByValue(value);
	}



	
	/* (non-Javadoc)
	 * @see com.nokia.s60tools.creator.components.AbstractComponent#getValueById(java.lang.String)
	 */
	public String getValueById(String id) {		
		return ConnectionMethodVariables.getInstance().getValueById(id);
	}



	
	/* (non-Javadoc)
	 * @see com.nokia.s60tools.creator.components.AbstractComponent#getXMLElementName()
	 */
	public String getXMLElementName() {
		return CreatorEditorSettings.TYPE_CONNECTION_METHOD_XML_ELEMENT;
	}
	
	/* (non-Javadoc)
	 * @see com.nokia.s60tools.creator.components.AbstractComponent#getValuesForItemType(java.lang.String)
	 */
	public String[] getValuesForItemType(String itemType) {
		//If there is not this type of item at all
		String idByValue = getIdByValue(itemType);
		if(idByValue == null){
			return null;
		}
		return ConnectionMethodVariables.getInstance().getValuesForItemType(idByValue);

	}

	/* (non-Javadoc)
	 * @see com.nokia.s60tools.creator.components.AbstractComponent#itemMaxOccur(java.lang.String)
	 */
	public int itemMaxOccur(String itemName) {		
		return ConnectionMethodVariables.getInstance().itemMaxOccur(itemName);
	}
	
	/* (non-Javadoc)
	 * @see com.nokia.s60tools.creator.components.AbstractComponent#getVariables()
	 */
	public AbstractVariables getVariables(){
		return ConnectionMethodVariables.getInstance();
	}	
}
