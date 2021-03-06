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
# Description:
#
##########################################################################################################################
##########################################################################################################################
#
# iMakerStub.pl
#
# Test stub for iMaker plugin JUnit tests.
#
# This stub is used by IMakerWrapperTest and runs one iMaker call at the time.
# File must be placed to C:\tests\ directory.
#
#
##########################################################################################################################
##########################################################################################################################


$time = localtime;
open OUTFILE, ">>out_iMakerStub.txt";
print OUTFILE "iMakerStub.pl called at $time\n";

$numArgs = $#ARGV + 1;
print OUTFILE "Number of arguments: $numArgs\n";
$testCase = $ARGV[0];
print OUTFILE "Test case: $testCase\n";

print OUTFILE "Arguments:\n";
foreach $argnum (0 .. $#ARGV) {
   print OUTFILE "\t$ARGV[$argnum]\n";
}

if($numArgs eq 0) {
print "
iMaker 10.03.01, 07-Sep-2009.

Print help data on documented iMaker API items; targets and variables.
Wildcards *, ? and [..] can be used with % patterns.

help                  : Print this message.
help-%                : Print help on help items matching the pattern.
help-%-list           : Print a list of help items matching the pattern.

help-target           : Print help on all targets (same as help-target-*).
help-target-%         : Print help on targets matching the pattern.
help-target-%-wiki    : Print wiki-formatted help on targets matching the patter
n.
help-target-%-list    : Print a list of targets matching the pattern.

help-variable         : Print help on all variables (same as help-variable-*).
help-variable-%       : Print help on variables matching the pattern.
help-variable-%-all   : Print full help on variables matching the pattern.
help-variable-%-wiki  : Print wiki-formatted help on variables matching the patt
ern.
help-variable-%-list  : Print a list of variables matching the pattern.
help-variable-%-value : Print a list of variables with values matching the patte
rn.

help-config           : Print a list of available configurations in the current
working environment.

menu                  : Run interactive menu.
version               : Print the iMaker version number.

For more info: http://configurationtools/imaker
";
exit(0);
}

#@options = @ARGV;
#shift @options;

# Printing simulated imaker output to wrapper


##########################################################################################################################
##########################################################################################################################
#
# Test Case: testGetConfigurationsNoConfigs
# help-config
#
##########################################################################################################################
##########################################################################################################################
if( $testCase eq "test_case=testGetConfigurationsNoConfigs" ) {
print OUTFILE "Running help, no results\n";
print "
Testing new API


Total duration: 00:01
";

exit(0); # Just to ensure that no other results are returned

}





##########################################################################################################################
##########################################################################################################################
#
# Test Case: all test cases except testGetConfigurationsNoConfigs
# help-config
#
##########################################################################################################################
##########################################################################################################################
if($ARGV[0] eq "help-config") {
print OUTFILE "Running help-config, full results\n";
print "
iMaker 09.37.01, 07-Sep-2009.
Finding available configuration file(s):
/epoc32/rom/config/ncp77/filippa/image_conf_filippa.mk
";

}


##########################################################################################################################
##########################################################################################################################
#
# Test Case: all test cases except testGetConfigurationsNoTargets
# help-target
#
##########################################################################################################################
##########################################################################################################################
if(($numArgs eq 3) and ($ARGV[2] =~ /filippa/ ) 
    and ($ARGV[0] eq "help-target")) {
print OUTFILE "Running help-target, full results\n";
print "
iMaker 09.37.01, 07-Sep-2009.
----------------------------------------
all
Type       : Target
Description: Create all image sections and symbol files.
----------------------------------------
clean
Type       : Target
Description: Clean all target files.
----------------------------------------
core
Type       : Target
Description: Create Core (ROM & ROFS1) image.
----------------------------------------
core-dir
Type       : Target
Description: Create directory structure for Core (ROM & ROFS1) creation.
----------------------------------------
core-i2file
Type       : Target
Description: Extract all files from Core (ROM & ROFS1) image.
----------------------------------------
core-image
Type       : Target
Description: Create Core (ROM & ROFS1) image (.img) file(s).
----------------------------------------
core-pre
Type       : Target
Description: Run pre-step, create files etc. for Core (ROM & ROFS1) creation.
----------------------------------------
core-symbol
Type       : Target
Description: Create Core (ROM & ROFS1) symbol file(s).
----------------------------------------
default
Type       : Target
Description: Default target, uses variable TARGET_DEFAULT to get actual target(s), current default = core.
----------------------------------------
e2flash
Type       : Target
Description: Create the elf2flash (flash) file.
----------------------------------------
f2image
Type       : Target
Description: Revert the Symbian image file (.img) from the elf2flash (flash) file.(See CORE_FLASH,ROFS2_FLASH,ROFS3_FLASH)
----------------------------------------
flash
Type       : Target
Description: Create all image sections files. Not any symbol files.
----------------------------------------
flash-all
Type       : Target
Description: Create all image sections and symbol files.
----------------------------------------
fota
Type       : Target
Description: Create the FOTA sub-image.
----------------------------------------
help
Type       : Target
Description: Print help on help targets.
----------------------------------------
help-%
Type       : Target
Description: Print help on help items matching the pattern.
----------------------------------------
help-%-list
Type       : Target
Description: Print a list of help items matching the pattern.
----------------------------------------
help-config
Type       : Target
Description: Print a list of available configurations in the current working environment.
----------------------------------------
help-target
Type       : Target
Description: Print help on all targets (same as help-target-*).
----------------------------------------
help-target-%
Type       : Target
Description: Print help on targets matching the pattern.
----------------------------------------
help-target-%-list
Type       : Target
Description: Print a list of targets matching the pattern.
----------------------------------------
help-target-%-wiki
Type       : Target
Description: Print wiki-formatted help on targets matching the pattern.
----------------------------------------
help-variable
Type       : Target
Description: Print help on all variables (same as help-variable-*).
----------------------------------------
help-variable-%
Type       : Target
Description: Print help on variables matching the pattern.
----------------------------------------
help-variable-%-all
Type       : Target
Description: Print full help on variables matching the pattern.
----------------------------------------
help-variable-%-list
Type       : Target
Description: Print a list of variables matching the pattern.
----------------------------------------
help-variable-%-value
Type       : Target
Description: Print a list of variables with values matching the pattern.
----------------------------------------
help-variable-%-wiki
Type       : Target
Description: Print wiki-formatted help on variables matching the pattern.
----------------------------------------
image
Type       : Target
Description: Create only the image file(s) (*.img)
----------------------------------------
langpack_all
Type       : Target
Description: Create all language packages.
----------------------------------------
langpack_china
Type       : Target
Description: Create language packages that belong to China region.
----------------------------------------
langpack_japan
Type       : Target
Description: Create language packages that belong to Japan region.
----------------------------------------
langpack_western
Type       : Target
Description: Create language packages that belong to Western region.
----------------------------------------
mmc
Type       : Target
Description: Create MMC/SD image.
----------------------------------------
mmc-dir
Type       : Target
Description: Create directory structure for MMC/SD creation.
----------------------------------------
mmc-image
Type       : Target
Description: Create MMC/SD image (.img) file.
----------------------------------------
mmc-pre
Type       : Target
Description: Run pre-step, create files etc. for MMC/SD creation.
----------------------------------------
print-%
Type       : Target
Description: Print the value(s) of the given variable(s). Wildcards *, ? and [..] can be used in variable names.
----------------------------------------
resignsubcon
Type       : Target
Description: Create re-signed security binaries for subcon image creation.
----------------------------------------
rofs2
Type       : Target
Description: Create ROFS2 image.
----------------------------------------
rofs2-dir
Type       : Target
Description: Create directory structure for ROFS2 creation.
----------------------------------------
rofs2-i2file
Type       : Target
Description: Extract all files from ROFS2 image.
----------------------------------------
rofs2-image
Type       : Target
Description: Create ROFS2 image (.img) file.
----------------------------------------
rofs2-pre
Type       : Target
Description: Run pre-step, create files etc. for ROFS2 creation.
----------------------------------------
rofs2-symbol
Type       : Target
Description: Create ROFS2 symbol file.
----------------------------------------
rofs3
Type       : Target
Description: Create ROFS3 image.
----------------------------------------
rofs3-dir
Type       : Target
Description: Create directory structure for ROFS3 creation.
----------------------------------------
rofs3-i2file
Type       : Target
Description: Extract all files from ROFS3 image.
----------------------------------------
rofs3-image
Type       : Target
Description: Create ROFS3 image (.img) file.
----------------------------------------
rofs3-pre
Type       : Target
Description: Run pre-step, create files etc. for ROFS3 creation.
----------------------------------------
rofs3-symbol
Type       : Target
Description: Create ROFS3 symbol file.
----------------------------------------
rofs4
Type       : Target
Description: Create DCC ROFS4 image.
----------------------------------------
rofs4-dir
Type       : Target
Description: Create directory structure for DCC ROFS4 creation.
----------------------------------------
rofs4-i2file
Type       : Target
Description: Extract all files from DCC ROFS4 image.
----------------------------------------
rofs4-image
Type       : Target
Description: Create DCC ROFS4 image (.img) file.
----------------------------------------
rofs4-pre
Type       : Target
Description: Run pre-step, create files etc. for DCC ROFS4 creation.
----------------------------------------
rofs4-symbol
Type       : Target
Description: Create DCC ROFS4 symbol file.
----------------------------------------
romsymbol
Type       : Target
Description: Create the rom symbol file
----------------------------------------
step-%
Type       : Target
Description: Generic target to execute any step inside the iMaker configuration. Any step (e.g. BUILD_*,CLEAN_*) can be executed with step-STEPNAME. Example: step-ROFS2PRE executes the CLEAN_ROFS2PRE and BUILD_ROFS2PRE commands.
----------------------------------------
toolinfo
Type       : Target
Description: Print info about the tool
----------------------------------------
uda
Type       : Target
Description: Create UDA image.
----------------------------------------
uda-dir
Type       : Target
Description: Create directory structure for UDA creation.
----------------------------------------
uda-image
Type       : Target
Description: Create UDA image (.img) file.
----------------------------------------
uda-pre
Type       : Target
Description: Run pre-step, create files etc. for UDA creation.
----------------------------------------
udaerase
Type       : Target
Description: Create the flashable UDA erase image.
----------------------------------------
variant
Type       : Target
Description: Create the variant image (rofs2,rofs3)
----------------------------------------
variant-image
Type       : Target
Description: Create the variant image files (rofs2.img, rofs3.img)
----------------------------------------
variantmmc
Type       : Target
Description: Create MMC/SD image from a variant directory. Be sure to define the VARIANT_DIR.
----------------------------------------
variantrofs2
Type       : Target
Description: Create ROFS2 image from a variant directory. Be sure to define the VARIANT_DIR.
----------------------------------------
variantrofs3
Type       : Target
Description: Create ROFS3 image from a variant directory. Be sure to define the VARIANT_DIR.
----------------------------------------
variantuda
Type       : Target
Description: Create UDA image from a variant directory. Be sure to define the VARIANT_DIR.
----------------------------------------
version
Type       : Target
Description: Print the version information
";

}

##########################################################################################################################
##########################################################################################################################
#
# Test Case: all test cases except testGetConfigurationsNoConfigElements
# help-variable-*-all
#
###########################################################################################################################
##########################################################################################################################
if(($numArgs eq 3) and ($ARGV[2] =~ /filippa/ ) 
    and ($ARGV[0] eq "help-variable-*-all")) {
print OUTFILE "Running help-variable-*-all, giving full list\n";
print "
iMaker 09.37.01, 07-Sep-2009.
----------------------------------------
BLDROBY = `'
Type       : Variable
Description: For passing extra oby files (from command line) to the buildrom.pl
Values     : (string)
----------------------------------------
BLDROM_OPT = `-loglevel1  -v -nosymbols   -DFEATUREVARIANT=filippa   -D__FEATURE_IBY__  -D_IMAGE_TYPE_RND'
Type       : Variable
Description: The default buildrom.pl options
Values     : (string)
----------------------------------------
BLDROPT = `'
Type       : Variable
Description: For passing extra parameters (from command line) to the buildrom.pl
Values     : (string)
----------------------------------------
CONFIGROOT = `/epoc32/rom/config'
Type       : Variable
Description: Define the default configuration root directory.
Values     : (string)
----------------------------------------
CORE_CDPROMFILE = `/epoc32/rombuild/odpcoderomfiles.txt'
Type       : Variable
Description: The name of the core Code Demand Paging rom file (Code paging).
Values     : (string)
----------------------------------------
CORE_DIR = `/epoc32/rombuild/filippa/core'
Type       : Variable
Description: The working directory, when creating core image
Values     : (string)
----------------------------------------
CORE_FLASH = `/epoc32/rombuild/filippa/filippa_0010_rnd.fpsx'
Type       : Variable
Description: The name of the flashable core image.
Values     : (string)
----------------------------------------
CORE_FWIDFILE = `/epoc32/rombuild/filippa/core/filippa_0010_rnd_core_fwid.txt'
Type       : Variable
Description: The (generated) _core_fwid.txt file name.
Values     : (string)
----------------------------------------
CORE_IMEISVFILE = `/epoc32/rombuild/filippa/core/filippa_0010_rnd_core_imeisv.txt'
Type       : Variable
Description: The (generated) _core_imeisv.txt file name.
Values     : (string)
----------------------------------------
CORE_IMEISVINFO = `00'
Type       : Variable
Description: The content string for the imeisv.txt file.
Values     : (string)
----------------------------------------
CORE_MODELFILE = `/epoc32/rombuild/filippa/core/filippa_0010_rnd_core_model.txt'
Type       : Variable
Description: The (generated) _core_model.txt file name.
Values     : (string)
----------------------------------------
CORE_MODELINFO = `S60'
Type       : Variable
Description: The content string for the model.txt file.
Values     : (string)
----------------------------------------
CORE_MSTOBY = `/epoc32/rombuild/filippa/core/filippa_0010_rnd_core_master.oby'
Type       : Variable
Description: The generated master oby file name, which includes the CORE_OBY files
Values     : (string)
----------------------------------------
CORE_NAME = `/epoc32/rombuild/filippa/core/filippa_0010_rnd'
Type       : Variable
Description: The name of the core image
Values     : (string)
----------------------------------------
CORE_NDPROMFILE = `/epoc32/rombuild/romfiles.txt'
Type       : Variable
Description: The name of the core Non Demand Paging rom file.
Values     : (string)
----------------------------------------
CORE_OBY = `/epoc32/rom/ncp.oby'
Type       : Variable
Description: The oby file(s) included to the core image creation
Values     : (string)
----------------------------------------
CORE_ODPROMFILE = `/epoc32/rombuild/odpromfiles.txt'
Type       : Variable
Description: The name of the core On Demand Paging rom file (Rom paging).
Values     : (string)
----------------------------------------
CORE_OPT = `-loglevel1  -v -nosymbols   -DFEATUREVARIANT=filippa   -D__FEATURE_IBY__  -D_IMAGE_TYPE_RND -D_EABI=ARMV5    -DFILIPPA  -D_IMAGE_TYPE_NCP -DLCD_SHELL -DBSW_USE_TEXTSHELL_UPDATER'
Type       : Variable
Description: The core specific buildrom options
Values     : (string)
----------------------------------------
CORE_PLATFILE = `/epoc32/rombuild/filippa/core/filippa_0010_rnd_core_platform.txt'
Type       : Variable
Description: The (generated) _core_platform.txt file name.
Values     : (string)
----------------------------------------
CORE_PLATINFO = `SymbianOSMajorVersion=9\nSymbianOSMinorVersion=5\n'
Type       : Variable
Description: The content string for the fwid.txt file.
Values     : (string)
----------------------------------------
CORE_PRODFILE = `/epoc32/rombuild/filippa/core/filippa_0010_rnd_core_product.txt'
Type       : Variable
Description: The (generated) _core_product.txt file name.
Values     : (string)
----------------------------------------
CORE_ROFSFILE = `/epoc32/rombuild/odprofsfiles.txt'
Type       : Variable
Description: The name of the core rofs file.
Values     : (string)
----------------------------------------
CORE_ROMVER = `0.01(0)'
Type       : Variable
Description: The rom version parameter passed to the version.iby
Values     : (string)
----------------------------------------
CORE_SWVERFILE = `/epoc32/rombuild/filippa/core/filippa_0010_rnd_core_sw.txt'
Type       : Variable
Description: The (generated) _core_sw.txt version file name. This generated file is included in the CORE_VERIBY file.
Values     : (string)
----------------------------------------
CORE_SWVERINFO = `V 77.52.2009.24.0610_RC RND\n10-09-09\nRM-601\n(c) Nokia'
Type       : Variable
Description: The content string for the sw.txt file.
Values     : (string)
----------------------------------------
CORE_TIME = `10/09/2009'
Type       : Variable
Description: The time defined to the core image
Values     : (string)
----------------------------------------
CORE_UDEBFILE = `/epoc32/rombuild/mytraces.txt'
Type       : Variable
Description: The name of the core udeb file. See USE_UDEB.
Values     : (string)
----------------------------------------
CORE_VERIBY = `/epoc32/rombuild/filippa/core/filippa_0010_rnd_core_version.iby'
Type       : Variable
Description: The name of the generated core *version.iby, which included version files and info
Values     : (string)
----------------------------------------
CORE_VERSION = `V 77.52.2009.24.0610_RC RND'
Type       : Variable
Description: The version of the core. Used in sw.txt generation.
Values     : (string)
----------------------------------------
COREPLAT_NAME = `ncp77'
Type       : Variable
Description: Name of the core platform
Values     : (string)
----------------------------------------
CUSTVARIANT_COMPLP = `'
Type       : Variable
Description: Compatible language variant.
Values     : (string)
----------------------------------------
CUSTVARIANT_DIR = `/epoc32/rom/config/ncp77/filippa/customer/'
Type       : Variable
Description: Overrides the VARIANT_DIR for customer variant, see the instructions of VARIANT_CONFCP for details.
Values     : (string)
----------------------------------------
FLASH_EXT = `.fpsx'
Type       : Variable
Description: The flash file extension.
Values     : (string)
----------------------------------------
HWID = `0010'
Type       : Variable
Description: Hardware Id
Values     : ([0-9]4)
----------------------------------------
HWID_LIST = `0010 0020 0100 0110 0120 0130 0140 0200 0220'
Type       : Variable
Description: Possible Hardware Ids of the product.
Values     : ([0-9]4)*
----------------------------------------
KEEPTEMP = `0'
Type       : Variable
Description: Keep the buildrom.pl temp files (copied to the WORKDIR). E.g. tmp1.oby tmp2.oby..tmp9.oby
Values     : ([0|1])
----------------------------------------
LABEL = `'
Type       : Variable
Description: A label to the NAME of the image
Values     : (string)
----------------------------------------
LANGPACK_CONFCP = `7752 filippa '
Type       : Variable
Description: Overrides the VARIANT_CONFCP for language pack, see the instructions of VARIANT_CONFCP for details.
Values     : (string)
----------------------------------------
LANGPACK_CONFML = `/epoc32/rom/config/ncp77/filippa/filippa.confml'
Type       : Variable
Description: Overrides the VARIANT_CONFML for language pack, see the instructions of VARIANT_CONFML for details.
Values     : (string)
----------------------------------------
LANGPACK_DEFAULTLANG = `English'
Type       : Variable
Description: Default language is the language where the device will boot to (SIM language overrides this selection)
Values     : (string)
----------------------------------------
LANGPACK_DIR = `/epoc32/rom/config/ncp77/filippa/language/'
Type       : Variable
Description: Overrides the VARIANT_DIR for language pack, see the instructions of VARIANT_CONFCP for details.
Values     : (string)
----------------------------------------
LANGPACK_ID = `01'
Type       : Variable
Description: Language id used in the lang.txt generation
Values     : (string)
----------------------------------------
LANGPACK_LANGS = `English'
Type       : Variable
Description: Languages are the languages that are taken to the image (SC language is is defaulting to 01 in languages.txt)
Values     : (string)
----------------------------------------
NAME = `filippa_0010_rnd'
Type       : Variable
Description: The name of the image
Values     : (string)
----------------------------------------
OPERATOR_OBY = `/epoc32/rombuild/filippa/rofs3/filippa_0010_rnd_rofs3_operator.oby'
Type       : Variable
Description: The name for generated operator oby, which is a file generated based on an operator specific content.
Values     : (string)
----------------------------------------
OPERATOR_OBYGEN = `geniby | /epoc32/rombuild/filippa/rofs3/filippa_0010_rnd_rofs3_operator.oby | /epoc32/rom/include/operator | *.iby | #include \"%3\" | end'
Type       : Variable
Description: The name, path, rule for collecting content to the operator specific oby (E.g. operator.oby | /epoc32/rom/include/operator | *.iby collects all iby files from operator folder).
Values     : (string)|(string)|(string)
----------------------------------------
PRODUCT_MODEL = `N00'
Type       : Variable
Description: The model of the product
Values     : (string)
----------------------------------------
PRODUCT_NAME = `filippa'
Type       : Variable
Description: Name of the product
Values     : (string)
----------------------------------------
PRODUCT_REVISION = `01'
Type       : Variable
Description: The revision of the product.
Values     : (string)
----------------------------------------
PRODVARIANT_CONFCP = `7752 filippa'
Type       : Variable
Description: Overrides the VARIANT_CONFCP for product variant, see the instructions of VARIANT_CONFCP for details.
Values     : (string)
----------------------------------------
PRODVARIANT_CONFML = `/epoc32/rom/config/ncp77/filippa/filippa.confml'
Type       : Variable
Description: Overrides the VARIANT_CONFML for product variant, see the instructions of VARIANT_CONFML for details.
Values     : (string)
----------------------------------------
PRODVARIANT_DIR = `/epoc32/rom/config/ncp77/filippa'
Type       : Variable
Description: Overrides the VARIANT_DIR for product variant, see the instructions of VARIANT_CONFCP for details.
Values     : (string)
----------------------------------------
ROFS2_DIR = `/epoc32/rombuild/filippa/rofs2'
Type       : Variable
Description: The working directory, when creating the rofs2 image
Values     : (string)
----------------------------------------
ROFS2_FLASH = `/epoc32/rombuild/filippa/rofs2/filippa_0010_rnd.rofs2.fpsx'
Type       : Variable
Description: The name of the flashable rofs2 image.
Values     : (string)
----------------------------------------
ROFS2_FOOTER = `'
Type       : Variable
Description: This variable can contain a footer section for the rofs2 master oby.
Values     : (string)
----------------------------------------
ROFS2_FWIDFILE = `/epoc32/rombuild/filippa/rofs2/filippa_0010_rnd_rofs2_fwid.txt'
Type       : Variable
Description: The (generated) _rofs2_fwid.txt file name.
Values     : (string)
----------------------------------------
ROFS2_FWIDINFO = `id=language\nversion=01\n'
Type       : Variable
Description: The content string for the fwid2.txt file.
Values     : (string)
----------------------------------------
ROFS2_HEADER = `'
Type       : Variable
Description: This variable can contain a header section for the rofs2 master oby.
Values     : (string)
----------------------------------------
ROFS2_MSTOBY = `/epoc32/rombuild/filippa/rofs2/filippa_0010_rnd_rofs2_master.oby'
Type       : Variable
Description: The (generated) rofs2 master oby file name. This file includes the ROFS2_OBY files and other parameters
Values     : (string)
----------------------------------------
ROFS2_NAME = `/epoc32/rombuild/filippa/rofs2/filippa_0010_rnd'
Type       : Variable
Description: The name of the rofs2 image
Values     : (string)
----------------------------------------
ROFS2_OBY = `'
Type       : Variable
Description: The oby file(s) included to the rofs2 image creation
Values     : (string)
----------------------------------------
ROFS2_OPT = `'
Type       : Variable
Description: The rofs2 specific buildrom options
Values     : (string)
----------------------------------------
ROFS2_ROMVER = `0.01(0)'
Type       : Variable
Description: The rofs2 ROM version string
Values     : (string)
----------------------------------------
ROFS2_TIME = `10/09/2009'
Type       : Variable
Description: The time defined to the rofs2 image.
Values     : (string)
----------------------------------------
ROFS2_VERIBY = `/epoc32/rombuild/filippa/rofs2/filippa_0010_rnd_rofs2_version.iby'
Type       : Variable
Description: The (generated) version iby file name for the rofs2 image. This file included the version text files and other version parameters.
Values     : (string)
----------------------------------------
ROFS3_CUSTSWFILE = `/epoc32/rombuild/filippa/rofs3/filippa_0010_rnd_rofs3_customersw.txt'
Type       : Variable
Description: The (generated) source file name for customersw.txt.
Values     : (string)
----------------------------------------
ROFS3_CUSTSWINFO = `V 77.52.2009.24.0610_RC RND\n10-09-09'
Type       : Variable
Description: The content string for the customersw.txt.
Values     : (string)
----------------------------------------
ROFS3_DIR = `/epoc32/rombuild/filippa/rofs3'
Type       : Variable
Description: The working directory, when creating the rofs3 image
Values     : (string)
----------------------------------------
ROFS3_FLASH = `/epoc32/rombuild/filippa/rofs3/filippa_0010_rnd.rofs3.fpsx'
Type       : Variable
Description: The name of the flashable rofs3 image.
Values     : (string)
----------------------------------------
ROFS3_FOOTER = `'
Type       : Variable
Description: This variable can contain a footer section for the rofs3 master oby.
Values     : (string)
----------------------------------------
ROFS3_FWIDFILE = `/epoc32/rombuild/filippa/rofs3/filippa_0010_rnd_rofs3_fwid.txt'
Type       : Variable
Description: The (generated) _rofs3_fwid.txt file name.
Values     : (string)
----------------------------------------
ROFS3_FWIDINFO = `id=customer\nversion=V 77.52.2009.24.0610_RC RND Customer\n'
Type       : Variable
Description: The content string for the fwid3.txt file.
Values     : (string)
----------------------------------------
ROFS3_HEADER = `'
Type       : Variable
Description: This variable can contain a header section for the rofs3 master oby.
Values     : (string)
----------------------------------------
ROFS3_MSTOBY = `/epoc32/rombuild/filippa/rofs3/filippa_0010_rnd_rofs3_master.oby'
Type       : Variable
Description: The (generated) version iby file name for the rofs3 image. This file included the version text files and other version parameters.
Values     : (string)
----------------------------------------
ROFS3_NAME = `/epoc32/rombuild/filippa/rofs3/filippa_0010_rnd'
Type       : Variable
Description: The name of the rofs3 image
Values     : (string)
----------------------------------------
ROFS3_OBY = `/epoc32/rombuild/filippa/rofs3/filippa_0010_rnd_rofs3_operator.oby'
Type       : Variable
Description: The oby file(s) included to the rofs3 image creation
Values     : (string)
----------------------------------------
ROFS3_OPT = `'
Type       : Variable
Description: The rofs3 specific buildrom options
Values     : (string)
----------------------------------------
ROFS3_ROMVER = `0.01(0)'
Type       : Variable
Description: The rofs3 ROM version string
Values     : (string)
----------------------------------------
ROFS3_TIME = `10/09/2009'
Type       : Variable
Description: The time defined to the rofs3 image.
Values     : (string)
----------------------------------------
ROFS3_VERIBY = `/epoc32/rombuild/filippa/rofs3/filippa_0010_rnd_rofs3_version.iby'
Type       : Variable
Description: The (generated) version iby file name for the rofs3 image. This file included the version text files and other version parameters.
Values     : (string)
----------------------------------------
SOS_VERSION = `9.5'
Type       : Variable
Description: Symbian OS version number. The value is used in the version info generation (platform.txt).(see USE_VERGEN)
Values     : ([0-9]+.[0-9]+)
----------------------------------------
SWUPD_EXT = `.swupd'
Type       : Variable
Description: The software update file extension.
Values     : (string)
----------------------------------------
TARGET_DEFAULT = `core'
Type       : Variable
Description: Configure actual target(s) for target default.
Values     : (string)
----------------------------------------
TYPE = `rnd'
Type       : Variable
Description: Defines the image type.
Values     : (rnd|prd|subcon)
----------------------------------------
USE_OVERRIDE = `1'
Type       : Variable
Description: Define whether the override.pm Buildrom.pl plugin is used.
Values     : ([0|1])
----------------------------------------
USE_PAGING = `rom'
Type       : Variable
Description: Define the usage of On Demand Pagin (ODP). (E.g. 0,rom,code).
Values     : ((0|rom|code[:[(1|2|3)]+]?))
----------------------------------------
USE_PLATSIM = `0'
Type       : Variable
Description: Define that the configuration is a PlatSim configuration.
Values     : (string)
----------------------------------------
USE_ROFS = `1'
Type       : Variable
Description: Define the rofs sections in use. A comma separated list can be given of possible values. (E.g. 1,2,3).
Values     : ([[dummy|]0..6][,[dummy|]0..6]*)
----------------------------------------
USE_ROMFILE = `1'
Type       : Variable
Description: Define whether the \epoc32\rombuild\romfiles.txt is used. Files in romfiles are automatically moved to ROM, everything else in core is moved to ROFS1.
Values     : ([0|1])
----------------------------------------
USE_SYMGEN = `0'
Type       : Variable
Description: Generate the rom symbol file. 0=Do not generate, 1=Generate
Values     : ([0|1])
----------------------------------------
USE_UDEB = `0'
Type       : Variable
Description: Include the usage of the debug binary *.txt to define the list of binaries that are taken from udeb folder instead of the urel.
Values     : ([0|1|full])
----------------------------------------
USE_VERGEN = `1'
Type       : Variable
Description: Use iMaker version info generation
Values     : ([0|1])
----------------------------------------
VARIANT_CONFCP = `7752 filippa'
Type       : Variable
Description: Configure which ConfigurationTool generated configurations dirs are copied to output.
Values     : (string)
----------------------------------------
VARIANT_CONFML = `/epoc32/rom/config/ncp77/filippa/filippa.confml'
Type       : Variable
Description: Configure what is the ConfigurationTool input confml file, when configuration tool is ran.
Values     : (string)
----------------------------------------
VARIANT_DIR = `/epoc32/rom/config/ncp77/filippa'
Type       : Variable
Description: Configure the directory where to included the customer variant content. By default all content under  is included to the image as it exists in the folder.
Values     : (string)
----------------------------------------
WORKDIR = `/epoc32/rombuild/filippa'
Type       : Variable
Description: The working directory for the image creation
Values     : (string)
";
}


##########################################################################################################################
##########################################################################################################################
#
# Test Case: testGetConfigurationsNoConfigElements
# help-variable-*-all
#
###########################################################################################################################
##########################################################################################################################
if(($testCase eq "test_case=testGetConfigurationsNoConfigElements") 
    and ($ARGV[1] eq "help-variable-*-all")) {
print OUTFILE "Running help-variable-*-all, no results\n";
print "
Testing new API
----------------------------------------

Total duration: 00:01

";
}

##########################################################################################################################
##########################################################################################################################
#
# Test Case: testBuildImage
# 
###########################################################################################################################
##########################################################################################################################
if( $testCase eq "test_case=testBuildImage" ) {
print OUTFILE "Running build image, returning builder result\n";

print "
Testing new API
Generating oby for Variant ROFS2 image creation
Generating ROFS2 version file(s)
Creating Variant ROFS2 SOS image
Generating Variant ROFS2 Elf2flash configuration
Adding BB5 Common Header(s) to Variant ROFS2
Creating flashable Variant ROFS2 image

Total duration: 01:13

";
}

##########################################################################################################################
##########################################################################################################################
#
# Test Case: testBuildImageFailed
# 
###########################################################################################################################
##########################################################################################################################
if( $testCase eq "test_case=testBuildImageFailed" ) {
print OUTFILE "Running build image, returning builder result with errors\n";

print "
Testing new API
Generating oby for Variant ROFS2 image creation
Generating ROFS2 version file(s)
Creating Variant ROFS2 SOS image
Generating Variant ROFS2 Elf2flash configuration
Adding BB5 Common Header(s) to Variant ROFS2
Creating flashable Variant ROFS2 image
error: something went wrong


";
}

if(($numArgs eq 3) and ($ARGV[2] eq "flash")) {
print "
iMaker 09.37.01, 07-Sep-2009.
Variant target             USE_VARIANTBLD = `1'
Variant directory          VARIANT_DIR    = `/epoc32/rom/config/ncp77/filippa'
Variant config makefile    VARIANT_MK     = -
Variant include directory  VARIANT_INCDIR = -
Variant confml file        VARIANT_CONFML = `/epoc32/rom/config/ncp77/filippa/filippa.confml'
Variant CenRep configs     VARIANT_CONFCP = `7752 filippa'
Variant SIS directory      VARIANT_SISDIR = -
Variant operator cache dir VARIANT_OPCDIR = -
Variant widget preinst dir VARIANT_WGZDIR = -
Variant zip content dir    VARIANT_ZIPDIR = -
Variant copy content dir   VARIANT_CPDIR  = -
Variant output directory   VARIANT_OUTDIR = `/epoc32/rombuild/filippa/core/variant'
Calling S60 Configuration Tool
Generating Feature manager file(s)
Generating file(s) for Core (ROM & ROFS1) image creation
Creating Core (ROM & ROFS1) SOS image

Missing file(s):
1) \epoc32\rombuild\filippa\core\filippa_0010_rnd_core_master.oby(95): Missing file: '\epoc32\release\ARMV5\urel\BTRACEX_LDD' in statement 'data='

Warning(s):
1) WARNING: /epoc32/include/s60features.xml doesn't exist
2) WARNING: /epoc32/include/s60regionalfeatures.xml doesn't exist
3) WARNING: /epoc32/include/s60customswfeatures.xml doesn't exist

Error(s):
1) ERROR: Invalid patchable value at \"power_resources.dll\@KHwDrvMMC_CorePinNo     None \"
2) ERROR: Invalid patchable value at \"power_resources.dll\@KHwDrvMMC_IOPinNo       None \"
Generating Boot Block Elf2flash configuration
Creating flashable Boot Block image
Creating GenIO Initialization subimage
Adding BB5 Common Header(s) to GenIO Initialization image
Generating SOS (Core) Elf2flash configuration
Adding BB5 Common Header(s) to SOS (Core) image
Creating flashable SOS (Core) image
Generating Core Elf2flash configuration
Creating flashable Core image
Generating UDA Erase Elf2flash configuration
Creating flashable UDA Erase image
";
}


####################
END {
print OUTFILE "---------------------------------------------------------------\n";
close OUTFILE;
}


#EOF
