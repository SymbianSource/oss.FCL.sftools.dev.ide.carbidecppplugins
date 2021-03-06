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

package com.nokia.s60tools.hticonnection.services.applicationcontrolservice;

import com.nokia.HTI.BaseService;
import com.nokia.HTI.HTIMessage;
import com.nokia.HTI.IService;
import com.nokia.s60tools.hticonnection.core.AbstractRequest;
import com.nokia.s60tools.hticonnection.core.RequestResult;

/**
 * Callable object that can be used to wait for request to complete.
 */
public class StartCommandByNameRequest extends AbstractRequest{
	
	/**
	 * Name used for request.
	 */
	private static final String REQUEST_NAME = "Start command with name"; //$NON-NLS-1$
	
	// Settings for start application request
	private final String programName;
	private final String parameters;
	private final long timeout;
	
	/**
	 * Start application
	 * @param programName Application name (with full path if necessary)
	 * @param parameters passed to the started application
	 * @param timeout Timeout for request
	 */
	public StartCommandByNameRequest(String programName, String parameters, long timeout){
		super(REQUEST_NAME);
		this.programName = programName;
		this.parameters = parameters;
		this.timeout = timeout;
	}

	/* (non-Javadoc)
	 * @see com.nokia.s60tools.hticonnection.core.AbstractRequest#createService()
	 */
	public BaseService createService(){
		return new com.nokia.HTI.ApplicationControlService.ApplicationControlService();
		}
	
	/* (non-Javadoc)
	 * @see com.nokia.s60tools.hticonnection.core.AbstractRequest#invokeService(com.nokia.HTI.IService)
	 */
	public RequestResult invokeService(IService service) throws Exception{
		HTIMessage result = ((com.nokia.HTI.ApplicationControlService.ApplicationControlService)service)
						.startProcess(programName, parameters, timeout);
		return new RequestResult(result);
    }
}
