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
package com.nokia.s60tools.symbianfoundationtemplates.ui.wizards.s60.projectwizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;

import com.nokia.s60tools.symbianfoundationtemplates.ui.wizards.s60.S60TemplatePageType;
import com.nokia.s60tools.symbianfoundationtemplates.ui.wizards.s60.S60TemplateWizard;

/**
 * Build info wizard 
 */
public class BuildInfoWizard extends S60TemplateWizard {
	private final static S60TemplatePageType pageType = S60TemplatePageType.BUILD_INFO_PAGE;
	
	public BuildInfoWizard() {
		super(pageType.getImage());
	}
	
	@Override
	public void addPages() {
		addPage(new BuildInfoPage(pageType));
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle(pageType.getTitle());
	}
}