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
 
 
package com.nokia.s60tools.creator.common;

/**
 * This class stores product information such as product name, 
 * version, console view name etc.  
 * The idea is to have the product information in one place.
 */
public class ProductInfoRegistry {

	private static final String PRODUCT_NAME = Product.getString("ProductInfoRegistry.Product_Name"); //$NON-NLS-1$
	private static final String CONSOLE_WINDOW_NAME = PRODUCT_NAME + " " + Product.getString("ProductInfoRegistry.Console_Window_Name_Postfix");	 //$NON-NLS-1$ //$NON-NLS-2$
	private static final String IMAGES_DIRECTORY = Product.getString("ProductInfoRegistry.Images_Directory");	 //$NON-NLS-1$
	private static final String RESOURCES_RELATIVE_PATH = Product.getString("ProductInfoRegistry.Resources_Relative_Path");	 //$NON-NLS-1$
	private static final String DATA_DIRECTORY = Product.getString("ProductInfoRegistry.Data_Directory");	 //$NON-NLS-1$
	private static final String PROPERTIES_FILE_NAME = Product.getString("ProductInfoRegistry.Properties_File_Name");	 //$NON-NLS-1$
	private static final String CREATOR_TEMPLATE_FILE_NAME = Product.getString("ProductInfoRegistry.Creator_Template_File_Name");	 //$NON-NLS-1$
	
	
	/**
	 * @return Returns the CONSOLE_WINDOW_NAME.
	 */
	public static String getConsoleWindowName() {
		return CONSOLE_WINDOW_NAME;
	}
	/**
	 * @return Returns the PRODUCT_NAME.
	 */
	public static String getProductName() {
		return PRODUCT_NAME;
	}
	
	/**
	 * @return Returns the IMAGES_DIRECTORY.
	 */
	public static String getImagesDirectoryName() {
		return IMAGES_DIRECTORY;
	}
	/**
	 * @return Returns the RESOURCES_RELATIVE_PATH.
	 */
	public static String getResourcesRelativePath() {
		return RESOURCES_RELATIVE_PATH;
	}
	
	/**
	 * @return Returns the CREATOR_TEMPLATE_FILE_NAME.
	 */
	public static String getCreatorTemplateFileName() {
		return CREATOR_TEMPLATE_FILE_NAME;
	}	
		
	/**
	 * @return Returns the DATA_DIRECTORY.
	 */
	public static String getDataDirectoryName() {
		return DATA_DIRECTORY;
	}	
	/**
	 * @return Returns the PROPERTIES_FILE_NAME.
	 */
	public static String getPropertiesFileName() {
		return PROPERTIES_FILE_NAME;
	}		
	/**
	 * @return Returns the Creator Symbian executable name.
	 */
	public static String getCreatorSymbianExcecutableName() {
		return Product.getString("ProductInfoRegistry.CreatorSymbianExecutableName"); //$NON-NLS-1$;
	}	
	
	
}
