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

package com.nokia.s60tools.hticonnection.services.ftpservice;

import com.nokia.HTI.BaseService;
import com.nokia.HTI.HTIMessage;
import com.nokia.HTI.IService;
import com.nokia.s60tools.hticonnection.core.AbstractRequest;
import com.nokia.s60tools.hticonnection.core.RequestResult;

/**
 * Callable object that can be used to wait for request to complete.
 */
public class CopyFileDirRequest extends AbstractRequest{
	
	/**
	 * Name used for request.
	 */
	private static final String REQUEST_NAME = "Copy file or dir"; //$NON-NLS-1$
	
	// Settings for copy request
	private final String originalPath;
	private final String copyPath;
	private final long timeout;
	
	/**
	 * Copies file or directory.
	 * @param originalPath File/folder to be copied.
	 * @param copyPath File/folder where original file/folder is copied.
	 * @param timeout Timeout for request.
	 */
	public CopyFileDirRequest(String originalPath, String copyPath, long timeout){
		super(REQUEST_NAME);
		this.originalPath = originalPath;
		this.copyPath = copyPath;
		this.timeout = timeout;
	}

	/* (non-Javadoc)
	 * @see com.nokia.s60tools.hticonnection.core.AbstractRequest#createService()
	 */
	public BaseService createService(){
		return new com.nokia.HTI.FTPService.FTPService();
	}
	
	/* (non-Javadoc)
	 * @see com.nokia.s60tools.hticonnection.core.AbstractRequest#invokeService(com.nokia.HTI.IService)
	 */
	public RequestResult invokeService(IService service) throws Exception{
		HTIMessage result = ((com.nokia.HTI.FTPService.FTPService)service)
						.copyFileFolder(originalPath, copyPath, timeout);
		return new RequestResult(result);
    }
}
