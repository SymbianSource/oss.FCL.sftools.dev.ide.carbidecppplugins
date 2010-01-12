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


package com.nokia.s60tools.imaker.internal.providers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TableViewer;

import com.nokia.s60tools.imaker.internal.model.iContent.IbyEntry;
import com.nokia.s60tools.imaker.internal.viewers.DebugTab;

public class CheckBoxEditingSupport extends IbyEntryEditingSupport {
	private final static int ENABLE_COLUMN_ID = 1;
	public CheckBoxEditingSupport(ColumnViewer viewer, int column) {
		super(viewer, column);
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		TableViewer tv = (TableViewer) getViewer();
		CheckboxCellEditor cellEditor = new CheckboxCellEditor(tv.getTable());
		return cellEditor;
	}

	@Override
	protected Object getValue(Object element) {
		Boolean ret = (column==ENABLE_COLUMN_ID)?new Boolean(getEntry(element).isEnabled()):new Boolean(getEntry(element).isDebug());
		return ret;
	}

	@Override
	protected void setValue(Object element, Object value) {
		Boolean newValue = (Boolean)value;
		IbyEntry entry = getEntry(element);
		if(column==ENABLE_COLUMN_ID) {
			entry.setEnabled(newValue);
		} else {
			String dPath = getDebugVersion(entry.getFile(),newValue);
			if(!dPath.equals(entry.getFile())) {
				entry.setFile(dPath);
				entry.setDebug(newValue);
			} else {
				return;
			}
		}
		updateWarning(element);
		getViewer().update(element, null);
	}

	private String getDebugVersion(String path, Boolean value) {
		String pattern;
		if(value) {
			pattern = DebugTab.REL_PATTERN;
		} else {
			pattern = DebugTab.DEBUG_PATTERN;			
		}
		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(path);
		if (matcher.find()) {
			int start = matcher.start(1);
			int end = matcher.end(1);
			String newPath;
			if(value) {
				newPath = path.substring(0, start) + "udeb" + path.substring(end);
			} else {
				newPath = path.substring(0, start) + "urel" + path.substring(end);
			}
			return newPath;
		} else {
			return path;
		}
	}
}
