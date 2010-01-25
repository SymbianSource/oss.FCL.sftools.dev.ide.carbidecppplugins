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

package com.nokia.s60tools.imaker.internal.impmodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Override Files</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.s60tools.imaker.internal.impmodel.OverrideFiles#getEntries <em>Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.s60tools.imaker.internal.impmodel.ImpmodelPackage#getOverrideFiles()
 * @model
 * @generated
 */
public interface OverrideFiles extends LineNumberContainer, CommentContainer {
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.s60tools.imaker.internal.impmodel.FileListEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' containment reference list.
	 * @see com.nokia.s60tools.imaker.internal.impmodel.ImpmodelPackage#getOverrideFiles_Entries()
	 * @model containment="true"
	 * @generated
	 */
	EList<FileListEntry> getEntries();

} // OverrideFiles
