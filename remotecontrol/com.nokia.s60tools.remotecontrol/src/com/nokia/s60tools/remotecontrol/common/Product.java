/*
* Copyright (c) 2008 Nokia Corporation and/or its subsidiary(-ies). 
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

package com.nokia.s60tools.remotecontrol.common;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Class for getting properties from product.properties file, located in same package.
 */
public class Product {
	private static final String BUNDLE_NAME = "com.nokia.s60tools.remotecontrol.common.Product"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	/**
	 * Constructor
	 */
	private Product() {
	}

	/**
	 * Get string from product.properties
	 * @param key to product.properties -file
	 * @return a String from product.properties -file
	 */
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
