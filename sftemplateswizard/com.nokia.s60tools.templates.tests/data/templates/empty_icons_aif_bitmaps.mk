#
# Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies).
# All rights reserved.
# This component and the accompanying materials are made available
# under the terms of "Eclipse Public License v1.0"
# which accompanies this distribution, and is available
# at the URL "http://www.eclipse.org/legal/epl-v10.html".
#
# Initial Contributors:
# Nokia Corporation - initial contribution.
#
# Contributors:
#
# Description:  scalable icons makefile for project ?myapp
#

ifeq (WINS,$(findstring WINS,$(PLATFORM)))
ZDIR=$(EPOCROOT)epoc32\release\$(PLATFORM)\$(CFG)\z
else
ZDIR=$(EPOCROOT)epoc32\data\z
endif

TARGETDIR=$(ZDIR)\resource\apps
ICONTARGETFILENAME=$(TARGETDIR)\?myapp_aif.mbm

MAKMAKE : 
	mifconv $(ICONTARGETFILENAME) \
		/c8,8 qgn_myapp_lst.bmp \
		/c8,8 qgn_myapp_cxt.bmp

BLD : ;

CLEAN : ;

LIB : ;

CLEANLIB : ;

RESOURCE : ;

FREEZE : ;

SAVESPACE : ;

RELEASABLES :
	@echo $(ICONTARGETFILENAME)

FINAL : ;
