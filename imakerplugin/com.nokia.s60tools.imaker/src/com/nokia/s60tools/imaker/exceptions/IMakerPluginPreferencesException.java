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
package com.nokia.s60tools.imaker.exceptions;

public class IMakerPluginPreferencesException extends Exception {
	public IMakerPluginPreferencesException() {
		super("iMaker plugin preferences doesn't contain valid information");
	}
	public IMakerPluginPreferencesException(String message) {
		super(message);
	}
}
