# ============================================================================
#  Name        : icons_extra.mk
#  Part of     : ?Subsystem_name / ?Module_name
#  Description : extra icons makefile for project ?myapp
#  Version     : %version: %
#
#  Copyright � ?year-?year ?Company_copyright. 
#  All rights reserved.
#  This component and the accompanying materials are made available
#  under the terms of the License "?License"
#  which accompanies this distribution, and is available
#  at the URL "?LicenseUrl".
#
#  Initial Contributors:
#  ?Company_name - initial contribution.
#
#  Contributors:
#  ?Company_name
# ============================================================================
# Template version: 4.1.1

*** INSTRUCTIONS TO THE TEMPLATE USER:

*** REMEMBER TO CHANGE THIS TEMPLATE FILE NAME TO BE UNIQUE WITHIN
*** ARCHITECTURE DOMAIN. 
*** DO NOT USE THE DEFAULT NAME

*** This template follows the Symbian Foundation coding conventions.
*** Remove all unneeded declarations and definitions before checking 
*** the file in!  Also remove the template's usage instructions, that is, 
*** everything that begins with "***".

*** The copyright years should be < the year of the file's creation >
*** - < the year of the file's latest update >.

*** Words that begin with "?" are for you to replace with your own
*** identifiers, filenames, or comments.

*** Filenames and pathnames must be completely in lowercase.

*** Commands must be preceded by exactly one tab character.  Commands
*** can continue to the next line if the last character on the line is
*** \.


ifeq (WINS,$(findstring WINS, $(PLATFORM)))
ZDIR=$(EPOCROOT)epoc32\release\$(PLATFORM)\$(CFG)\z
else
ZDIR=$(EPOCROOT)epoc32\data\z
endif

TARGETDIR=$(ZDIR)\resource\apps
ICONTARGETFILENAME=$(TARGETDIR)\?smallmyapp_extraicons.mif

HEADERDIR=\epoc32\include
HEADERFILENAME=$(HEADERDIR)\?smallmyapp_extraicons.mbg


do_nothing :
	@rem do_nothing

MAKMAKE : do_nothing

BLD : do_nothing

CLEAN :
	@if exist $(ICONTARGETFILENAME) erase $(ICONTARGETFILENAME)
	@if exist $(HEADERFILENAME) erase $(HEADERFILENAME)

LIB : do_nothing

CLEANLIB : do_nothing

RESOURCE : $(ICONTARGETFILENAME)

$(ICONTARGETFILENAME) (HEADERFILENAME) : qgn_?smallmyapp_icon_1.svg qgn_?smallmyapp_icon_2.svg
	mifconv $(ICONTARGETFILENAME) /h$(HEADERFILENAME) \
		/c8,8 qgn_?smallmyapp_icon_1.svg \
		/c8,8 qgn_?smallmyapp_icon_2.svg

FREEZE : do_nothing

SAVESPACE : do_nothing

RELEASABLES :
	@echo $(HEADERFILENAME) && \
	@echo $(ICONTARGETFILENAME)

FINAL : do_nothing