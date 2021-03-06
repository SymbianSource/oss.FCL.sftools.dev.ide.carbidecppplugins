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

import java.io.File;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import com.nokia.s60tools.symbianfoundationtemplates.SymbianFoundationTemplates;
import com.nokia.s60tools.symbianfoundationtemplates.engine.OriginalTemplate;
import com.nokia.s60tools.symbianfoundationtemplates.engine.s60.S60TransformKeys;
import com.nokia.s60tools.symbianfoundationtemplates.resources.HelpContextIDs;
import com.nokia.s60tools.symbianfoundationtemplates.resources.LastUsedData;
import com.nokia.s60tools.symbianfoundationtemplates.resources.Messages;
import com.nokia.s60tools.symbianfoundationtemplates.resources.PreferenceConstants;
import com.nokia.s60tools.symbianfoundationtemplates.ui.wizards.s60.FolderSelectionControl;
import com.nokia.s60tools.symbianfoundationtemplates.ui.wizards.s60.S60TemplatePageType;
import com.nokia.s60tools.symbianfoundationtemplates.ui.wizards.s60.S60TemplateWizardPage;
import com.nokia.s60tools.symbianfoundationtemplates.util.Util;

/**
 * Build info page. 
 */
public class BuildInfoPage extends S60TemplateWizardPage {
	private FolderSelectionControl folderSelectionControl;
	
	private Text subSystemText;
	private Text moduleText;
	private Text appNameText;
	private Text copyrightText;
	private Combo licenseText;
	private Combo companyNameText;
	private Combo copyrightString;
	private Button cleanBtn;

	private Composite topLevel;
	
	public BuildInfoPage(S60TemplatePageType pageType) {
		super(pageType);
		setTitle(pageType.getTitle());
	}
	
	public void createControl(Composite parent) {
		topLevel = new Composite(parent, SWT.NONE);
		// Layout manager
		topLevel.setLayout(new GridLayout(1, false));
		topLevel.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		
		Composite selection = new Composite(topLevel, SWT.NONE);
		selection.setLayout(new GridLayout(3, false));
		selection.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		
		// Folder selection control
		folderSelectionControl = new FolderSelectionControl(selection, this, "Group Folder:");
		
		// Separator
		Label separator = new Label(topLevel, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		
		// Info control
		Composite info = new Composite(topLevel, SWT.NONE);
		info.setLayout(new GridLayout(2, false));
		info.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
	
		new Label(info, SWT.NONE).setText(Messages.getString("WizardPageSubSystemLabel")); //$NON-NLS-1$
		subSystemText = new Text(info, SWT.BORDER);
		subSystemText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		
		new Label(info, SWT.NONE).setText(Messages.getString("WizardPageModuleLabel")); //$NON-NLS-1$
		moduleText = new Text(info, SWT.BORDER);
		moduleText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		
		new Label(info, SWT.NONE).setText(Messages.getString("WizardPageApplicationLabel")); //$NON-NLS-1$
		appNameText = new Text(info, SWT.BORDER);
		appNameText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
				
		new Label(info, SWT.NONE).setText(Messages.getString("WizardPageCopyrightLabel")); //$NON-NLS-1$
		copyrightText = new Text(info, SWT.BORDER);
		copyrightText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));

		new Label(info, SWT.NONE).setText(Messages.getString("WizardPageLicenseLabel")); //$NON-NLS-1$
		licenseText = new Combo(info, SWT.BORDER|SWT.READ_ONLY);
		licenseText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		
		new Label(info, SWT.NONE).setText(Messages.getString("WizardPageCompanyLabel")); //$NON-NLS-1$
		companyNameText = new Combo(info, SWT.BORDER);
		companyNameText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		
		new Label(info, SWT.NONE).setText(Messages.getString("WizardPageCopyrightStringLabel"));
		copyrightString = new Combo(info, SWT.BORDER);// | SWT.V_SCROLL | SWT.MULTI | SWT.WRAP);
		copyrightString.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		
		GridData data=new GridData(GridData.FILL_HORIZONTAL);
		data.heightHint=30;
		cleanBtn=new Button(topLevel,SWT.CHECK);
		cleanBtn.setText(Messages.getString("WizardPageIncludeInstructionsLabel"));
		cleanBtn.setSelection(true);
		cleanBtn.setLayoutData(data);
		
		setControl(topLevel);
		//setPageComplete(true);
		
		copyrightText.setText(new Integer(Util.getCopyrightYear()).toString());
		licenseText.setItems(Util.getDefaultLicence());
		licenseText.select(0);

		LastUsedData previousData = new LastUsedData();
		String[] values = previousData.getPreviousValues(LastUsedData.ValueTypes.NAME);
		if(values!=null)
		{
			companyNameText.setItems(values);
			companyNameText.select(0);
		}
		else
		{
			companyNameText.setText(Util.getDefaultCompanyName());
			previousData.saveValues(LastUsedData.ValueTypes.NAME, companyNameText.getText());
		}
		
		values = previousData.getPreviousValues(LastUsedData.ValueTypes.COPYRIGHT);
		if(values !=null)
		{
			copyrightString.setItems(values);
			copyrightString.select(0);
		}
		else
		{
			copyrightString.setText(Util.getDefaultCompanyCopyright());
			previousData.saveValues(LastUsedData.ValueTypes.COPYRIGHT, copyrightString.getText());
		}
	

		setPreferencesFromStore();
		performHelp();
		//updateStatus();
		topLevel.setFocus();
	}

	public void performHelp() {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(topLevel,
				HelpContextIDs.SF_TEMPLATES_RESOURCE_WIZARD_PAGE);
	}
	
	@Override
	public AbstractList<OriginalTemplate> getTemplates() {
		AbstractList<OriginalTemplate> templates = new ArrayList<OriginalTemplate>();
		
		String[] templateFiles = pageType.getTemplateFiles().split(";");
		String fileName = templateFiles[0];
		//To return the empty template file name
		if(!cleanBtn.getSelection())
			fileName = templateFiles[1];
		
		templates.add(new OriginalTemplate(SymbianFoundationTemplates.getDefault().getTemplatesPath() + File.separator + fileName, getSelectedFile(), getTransformRules()));
		
		return templates;
	}
	
	@Override
	protected AbstractList<IStatus> getStatuses() {
		AbstractList<IStatus> statuses = new ArrayList<IStatus>();
		
		statuses.add(Util.getFolderNameStatus(folderSelectionControl.getSelectedFolder(), "Group folder")); //$NON-NLS-1$
				
		return statuses;
	}

	@Override
	protected void updateFields() {
		moduleText.setText(Util.getModuleName(folderSelectionControl.getSelectedFolder()));
		subSystemText.setText(Util.getSubSystemName(folderSelectionControl.getSelectedFolder()));
	}

	@Override
	protected void savePreferencesToStore() {
		preferenceStore.setValue(PreferenceConstants.S60_BUILD_INFO_PAGE_DIRECTORY, folderSelectionControl.getSelectedFolder());
		preferenceStore.setValue(PreferenceConstants.S60_BUILD_INFO_PAGE_MODULE, moduleText.getText());
		preferenceStore.setValue(PreferenceConstants.S60_BUILD_INFO_PAGE_SUBSYSTEM, subSystemText.getText());
		preferenceStore.setValue(PreferenceConstants.S60_BUILD_INFO_PAGE_APPNAME, appNameText.getText());
		preferenceStore.setValue(PreferenceConstants.SF_LICENSE_INDEX, licenseText.getSelectionIndex());
		LastUsedData saveData = new LastUsedData();
		saveData.saveValues(LastUsedData.ValueTypes.NAME, companyNameText.getText());
		saveData.saveValues(LastUsedData.ValueTypes.COPYRIGHT, copyrightString.getText());
	}
	
	private IFile getSelectedFile() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path(folderSelectionControl.getSelectedFolder() 
						+ File.separator 
						+ "bld.inf"));
	}
	
	private Map<String, String> getTransformRules() {
		Map<String, String> transformRules = new HashMap<String, String>();
		
		transformRules.put(S60TransformKeys.getString("key_module"), moduleText.getText()); //$NON-NLS-1$
		transformRules.put(S60TransformKeys.getString("key_subsystem"), subSystemText.getText()); //$NON-NLS-1$
		transformRules.put(S60TransformKeys.getString("key_copyright"), copyrightText.getText()); //$NON-NLS-1$
		transformRules.put(S60TransformKeys.getString("key_appname"), appNameText.getText()); //$NON-NLS-1$
		transformRules.put(S60TransformKeys.getString("key_license"), licenseText.getText()); //$NON-NLS-1$		
		transformRules.put(S60TransformKeys.getString("key_companyname"), companyNameText.getText()); //$NON-NLS-1$
		transformRules.put(S60TransformKeys.getString("key_companycopyright"), copyrightString.getText());
		
		if(licenseText.getText().equalsIgnoreCase("Symbian Foundation License v1.0"))
			transformRules.put(S60TransformKeys.getString("key_licenseurl"), "http://www.symbianfoundation.org/legal/sfl-v10.html");
		else if(licenseText.getText().equalsIgnoreCase("Eclipse Public License v1.0"))
			transformRules.put(S60TransformKeys.getString("key_licenseurl"), "http://www.eclipse.org/legal/epl-v10.html");
		return transformRules;
	}
	
	private void setPreferencesFromStore() {
		if(preferenceStore.getString(PreferenceConstants.S60_BUILD_INFO_PAGE_DIRECTORY)!="")
			folderSelectionControl.setSelectedFolder(preferenceStore.getString(PreferenceConstants.S60_BUILD_INFO_PAGE_DIRECTORY));
		moduleText.setText(preferenceStore.getString(PreferenceConstants.S60_BUILD_INFO_PAGE_MODULE));
		subSystemText.setText(preferenceStore.getString(PreferenceConstants.S60_BUILD_INFO_PAGE_SUBSYSTEM));
		appNameText.setText(preferenceStore.getString(PreferenceConstants.S60_BUILD_INFO_PAGE_APPNAME));
		licenseText.select(preferenceStore.getInt(PreferenceConstants.SF_LICENSE_INDEX));
	}
	
}
