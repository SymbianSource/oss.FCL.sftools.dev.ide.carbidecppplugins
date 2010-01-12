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
package com.nokia.s60tools.imaker.internal.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

import com.nokia.s60tools.imaker.IMakerKeyConstants;
import com.nokia.s60tools.imaker.IMakerUtils;
import com.nokia.s60tools.imaker.Messages;
import com.nokia.s60tools.imaker.UIVariable;
import com.nokia.s60tools.imaker.internal.managers.ProjectManager;
import com.nokia.s60tools.imaker.internal.model.iContent.IContentFactory;
import com.nokia.s60tools.imaker.internal.model.iContent.IbyEntry;
import com.nokia.s60tools.imaker.internal.wrapper.IMakerWrapperPreferences;
import com.nokia.s60tools.imaker.internal.wrapper.PlatsimManager;

public class ImakerProperties extends Properties {
	public static final String SEPARATOR			  = ":;";
	public static final String GENERATED_FILES_FOLDER = "imakerplugin";
	private static final long serialVersionUID = 1L;
	private List<UIVariable> variables=null;
	private String activeFile = null;
	private boolean used = false;

	/**
	 * Create imaker properties from file
	 * @param file
	 * @return
	 */
	public static ImakerProperties createFromFile(IFile file) {
		ImakerProperties imakerPreference = new ImakerProperties();

		if(file!=null) {
			try {
				imakerPreference.load(file.getContents());
			} catch (FileNotFoundException e) {
				imakerPreference = null;
			} catch (IOException e) {
				imakerPreference = null;
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

		return imakerPreference;
	}

	/**
	 * Create imaker properties from file
	 * @param file
	 * @return
	 */
	public void saveToFile(IFile file) {		
		if(file!=null) {
			InputStream input = getAsInputStream();
			try {
				file.setContents(input, true, false,null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ImakerProperties() {}

	public InputStream getAsInputStream() {
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		try {
			store(bao, "iMaker properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
		ByteArrayInputStream bs = new ByteArrayInputStream(bao.toString().getBytes());
		return bs;
	}
	
	/**
	 * Parse the contents of this properties file and create imaker command that is executable
	 * @param selectedProject
	 * @param workdir Place where the temporary iby/mk files will be placed
	 * @return
	 */
	public List<String> parseImakerCommand(IProject selectedProject, IPath workdir) {
		String drive = IMakerUtils.getProjectRootLocation(selectedProject);
		ArrayList<String> command = new ArrayList<String>();

		String makefile = (String) get(IMakerKeyConstants.MAKEFILE);
		if(makefile!=null) {
			appendCommand(command,IMakerWrapperPreferences.ARG_FETCH_CONFIGURATION);
			appendCommand(command,makefile);
		}
		addAdditionalParameters(command,(String) get(IMakerKeyConstants.TARGET_LIST)," ");
		String platsim = (String) get(IMakerKeyConstants.PLATSIM_INSTANCE);
		if(platsim!=null) {
			command.add(IMakerKeyConstants.PLATSIM_INSTANCE +"="+parse(platsim,drive));
			String run = (String)get(IMakerKeyConstants.PLATSIM_RUN);
			if(run!=null&&run.equals("true")) {
				command.add(IMakerKeyConstants.PLATSIM_RUN +"=1");		
			}
		}
		addAdditionalParameters(command,(String) get(IMakerKeyConstants.ADDITIONAL_PARAMETERS),SEPARATOR);
		addAdditionalParameters(command, (String) get(IMakerKeyConstants.MODIFIED_SETTINGS),SEPARATOR);
		String type = (String) get(IMakerKeyConstants.TYPE);
		command.add(IMakerWrapperPreferences.TYPE+"="+type);
		String verb = (String) get(IMakerKeyConstants.VERBOSE);
		if(verb!=null) {
			command.add(Messages.getString("Flashmenu.9"));
		}
		
		// parse iby files and makefile
		String str = (String)get(IMakerKeyConstants.DEBUGFILES);
		if(str!=null&&!str.equals("")) {
			List<IbyEntry> entries = new ArrayList<IbyEntry>();
			String[] entriesStr = str.split(ImakerProperties.SEPARATOR);
			for (int i = 0; i < entriesStr.length; i++) {
				String entryStr = entriesStr[i];
				if(entryStr!=null&&!entryStr.equals("")) {
					IbyEntry entry = IContentFactory.eINSTANCE.createEntryFromString(entryStr);
					if(entry.isEnabled()) {
						entries.add(entry);						
					}
				}
			}
			ProjectManager pm = new ProjectManager(selectedProject);
			IPath mkfile = IMakerUtils.createIbyFiles(entries, pm, workdir);
			if(mkfile!=null) {
				appendCommand(command,IMakerWrapperPreferences.ARG_FETCH_CONFIGURATION);
				appendCommand(command,"\""+mkfile.toOSString()+"\"");
			}
		}

		return command;
	}

	private String parse(String instance, String env) {
		if(instance==null) {
			instance="1";
		}
		if(instance.equals(Messages.getString("PlatsimTab.0"))) {
			PlatsimManager pm = new PlatsimManager(env);
			int max = 1;
			List<String> instances = pm.getInstances();
			for (String ins : instances) {
				int intIns = Integer.parseInt(ins);
				if(intIns>max) max = intIns;
			}
			return String.valueOf(max+1);
		}
		return instance;
	}

	private void addAdditionalParameters(ArrayList<String> command,
			String adds, String sep) {
		if(adds==null||adds.equals("")) { //$NON-NLS-1$
			return;
		}
		String[] parts = adds.split(sep); //$NON-NLS-1$
		for (int i = 0; i < parts.length; i++) {
			String part = parts[i];
			if(!part.equals("")) { //$NON-NLS-1$
				appendCommand(command, part);
			}
		}
	}

	private void appendCommand(ArrayList<String> command, String value) {
		if((value!=null)&&!(value.equals(""))) { //$NON-NLS-1$
			command.add(value.trim());
		}
	}
	
	private void updateVariables() {
		if(variables==null) {
			return;
		}
		List<UIVariable> includeVariables = IMakerUtils.getCommandlineIncludeVariables(variables);
		List<String> variablesToStrings = IMakerUtils.convertVariablesToStrings(includeVariables);

		StringBuilder settings = new StringBuilder();

		for (Iterator<String> iterator = variablesToStrings.iterator(); iterator
		.hasNext();) {
			String setting = iterator.next();
			settings.append(setting+SEPARATOR); //$NON-NLS-1$
		}

		String string = settings.toString();
		if(!string.equals("")) { //$NON-NLS-1$
			put(IMakerKeyConstants.MODIFIED_SETTINGS, string);
		}
	}

	public void setVariables(List<UIVariable> variables) {
		this.variables = variables;
		updateVariables();
	}

	public void setActiveFile(String path) {
		this.activeFile = path;
	}

	public String getActiveFile() {
		return activeFile;
	}

	public void setUsed(boolean b) {
		this.used  = b;
	}
	
	public boolean isUsed() {
		return this.used;
	}
}
