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

package com.nokia.s60tools.remotecontrol.ftp.ui.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.TableViewer;

import com.nokia.s60tools.remotecontrol.ftp.ui.view.FtpUtils;
import com.nokia.s60tools.remotecontrol.ftp.ui.view.ViewContentProvider;
import com.nokia.s60tools.remotecontrol.resources.ImageKeys;
import com.nokia.s60tools.remotecontrol.resources.ImageResourceManager;
import com.nokia.s60tools.remotecontrol.resources.Messages;
import com.nokia.s60tools.ui.actions.S60ToolsBaseAction;

/**
 * Action for creating directory to device
 */
public class MakeDirAction extends S60ToolsBaseAction {

	/**
	 * Viewer that is target for action.
	 */
	private TableViewer viewer;

	/**
	 * Content provider
	 */
	private ViewContentProvider contentProvider;

	/**
	 * Constructor
	 * 
	 * @param viewer Viewer that is target for action.
	 * @param contentProvider Content provider
	 */
	public MakeDirAction(TableViewer viewer,
			ViewContentProvider contentProvider) {
		super(Messages.getString("MakeDirAction.Action_Name"),  //$NON-NLS-1$
				Messages.getString("MakeDirAction.Tooltip_Name"),  //$NON-NLS-1$
				IAction.AS_PUSH_BUTTON,
				ImageResourceManager.getImageDescriptor(ImageKeys.IMG_NEW_FOLDER));
		this.viewer = viewer;
		this.contentProvider = contentProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		FtpUtils.makeDir(viewer, contentProvider);
	}
}
