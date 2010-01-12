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

package com.nokia.s60tools.imaker;

/**
 * IDs for context sensitive help.
 * @see contexts.xml -file IDs links to <code> <context id="<ID>"> </code>
 */
public class ImageFlasherHelpContextIDs {

	/**
     * The plug-in ID. Copy from ImageFlasherHelpActivator.PLUGIN_ID
     * to here to avoid runtime dependency to help project 
     */	 
    private static final String IMAKERPLUGIN_HELP_PROJECT_PLUGIN_ID = 
                                        "com.nokia.s60tools.imaker.help";
	
    public static final String IMAKERPLUGIN_HELP_PRODUCT = 
    	IMAKERPLUGIN_HELP_PROJECT_PLUGIN_ID +".IMAKERPLUGIN_HELP_PRODUCT";


    public static final String IMAKERPLUGIN_HELP_TARGETS = 
    	IMAKERPLUGIN_HELP_PROJECT_PLUGIN_ID +".IMAKERPLUGIN_HELP_TARGETS";
    
    public static final String IMAKERPLUGIN_HELP_SELECTED_TARGETS = 
    	IMAKERPLUGIN_HELP_PROJECT_PLUGIN_ID +".IMAKERPLUGIN_HELP_TARGET_LIST";
    
    public static final String IMAKERPLUGIN_HELP_IMAGE_TYPE = 
    	IMAKERPLUGIN_HELP_PROJECT_PLUGIN_ID +".IMAKERPLUGIN_HELP_IMAGE_TYPE";
    
    public static final String IMAKERPLUGIN_HELP_FLAGS = 
    	IMAKERPLUGIN_HELP_PROJECT_PLUGIN_ID +".IMAKERPLUGIN_HELP_FLAGS";
    
    public static final String IMAKERPLUGIN_HELP_ADDITIONAL_PARAMS = 
    	IMAKERPLUGIN_HELP_PROJECT_PLUGIN_ID +".IMAKERPLUGIN_HELP_ADDITIONAL_PARAMS";
    
    public static final String IMAKERPLUGIN_HELP_PREFERENCES_MANAGEMENT = 
    	IMAKERPLUGIN_HELP_PROJECT_PLUGIN_ID +".IMAKERPLUGIN_HELP_PREFERENCES_MANAGEMENT";
    
    public static final String IMAKERPLUGIN_HELP = 
    	IMAKERPLUGIN_HELP_PROJECT_PLUGIN_ID +".IMAKERPLUGIN_HELP";
    
}
