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
package com.nokia.s60tools.imaker.internal.tests;


import java.util.List;

import org.eclipse.core.resources.IFile;

import com.nokia.s60tools.imaker.IMakerKeyConstants;
import com.nokia.s60tools.imaker.internal.model.ImakerProperties;

public class ImakerPropertiesTest extends ProjectBuilder {

	private String FIELD_NAME = "NAME";
	private String FIELD_VALUE = "FIELD_VALUE";

	public void setUp() throws Exception {
		createDefaultProject();
		assertTrue(project.isAccessible());
	}
	
    public void tearDown() throws Exception {
        closeAndDeleteDefaultProject();
    }
	
	public void testImakerProperties() throws Exception {
		IFile[] ifiles = addImakerImpFiles();
		for (int i = 0; i < ifiles.length; i++) {
			IFile file = ifiles[i];
			ImakerProperties ip = ImakerProperties.createFromFile(file);
			String field = (String) ip.get(IMakerKeyConstants.PRODUCT);
			assertTrue(!field.equals(""));
			field = (String) ip.get(IMakerKeyConstants.TYPE);
			assertTrue(!field.equals(""));
			
			ip.put(FIELD_NAME, FIELD_VALUE);
			
			ip.saveToFile(file);
			ip = ImakerProperties.createFromFile(file);
			assertEquals(FIELD_VALUE, ip.get(FIELD_NAME));
			
			String mk = (String) ip.get(IMakerKeyConstants.MAKEFILE);
			List<String> command = ip.parseImakerCommand(project, project.getLocation());
			assertTrue("Expected command not correct! command="+command,command.indexOf(mk)!=-1);			
		}
	}
}

