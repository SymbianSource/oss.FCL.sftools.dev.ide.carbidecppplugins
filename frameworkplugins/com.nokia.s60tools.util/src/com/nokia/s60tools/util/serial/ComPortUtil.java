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

package com.nokia.s60tools.util.serial;

import com.freescale.cdt.debug.cw.core.ComPortHelper;

/**
 * Class for getting information of serial ports from OS.
 */
public class ComPortUtil {
	
	private static final String COM_PORT_PREFIX = "COM"; //$NON-NLS-1$
	private static final int COM_PORT_NUMBER = 256;

	/**
	 * Gets array of COM ports. Shows names for registered ports.
	 * In case of failure returns anyway all ports as array without
	 * additional information from OS.
	 * @return Array of COM ports
	 */
	static public String[] getComPortNames() {
		String[] comPortNames = null;
		boolean excOccured = false; 
		
		try {
			comPortNames = ComPortHelper.getComPortNames();
		} catch (Exception e) {
			excOccured = true;
		}
		
		if (excOccured || comPortNames == null || !comPortNames[0].startsWith(COM_PORT_PREFIX + 1)) {
			// Failed to get port names from ComPortHelper
			// Generate list of COM ports
			comPortNames = new String[COM_PORT_NUMBER];
			for (int i = 0; i < comPortNames.length; i++)
			{
				comPortNames[i] = COM_PORT_PREFIX + (i+1); 
			}
		}
		
		return comPortNames;
	}
}
	