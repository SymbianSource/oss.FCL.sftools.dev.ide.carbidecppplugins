/*
* ============================================================================
*  Name        : ?filename.cpp
*  Part of     : ?Subsystem_name / ?Module_name
*  Description : ?Description
*  Version     : %version: %
*
*  Copyright � ?year-?year ?Company_copyright.
*  All rights reserved.
*  This component and the accompanying materials are made available
*  under the terms of the License "?License"
*  which accompanies this distribution, and is available
*  at the URL "?LicenseUrl".
*
*  Initial Contributors:
*  ?Company_name - initial contribution.
*
*  Contributors:
*  ?Company_name
* ============================================================================
* Template version: 4.1
*/

*** INSTRUCTIONS TO THE TEMPLATE USER:

*** This template follows the Symbian Foundation coding conventions.
*** Remove all unneeded declarations and definitions before checking 
*** the file in!  Also remove the template's usage instructions, that is, 
*** everything that begins with "***".

*** The copyright years should be < the year of the file's creation >
*** - < the year of the file's latest update >.

*** Words that begin with "?" are for you to replace with your own
*** identifiers, filenames, comments, or code.  ?EXPORT_C means either
*** the EXPORT_C visibility directive, or nothing, depending on whether
*** the function is to be exported or not.

*** To support building on Linux, use only forward slashes in include
*** directives.  Also, all filenames and pathnames must be completely
*** in lowercase.

*** Indent four spaces per step, using spaces, not tabs, to display
*** the code consistently across different editors.


*** Implement only one class in one file.


*** system include files go here:

#include <?include_file>

*** user include files go here:

#include "?include_file"

*** external function prototypes go here:

extern ?external_function( ?arg_type, ?arg_type );

*** local constants go here:

const ?type ?constant_var = ?constant;


// ======== LOCAL FUNCTIONS ========

// ---------------------------------------------------------------------------
// ?description
// ---------------------------------------------------------------------------
//
?type ?function_name( ?arg_type ?arg,
                      ?arg_type ?arg )
    {
    ?code  // ?implementation comment on this line
    // ?implementation comment on the following statement or block:
    ?code
    }


// ======== MEMBER FUNCTIONS ========

*** In the same order as defined in the header file.

*** The first function includes examples of correct tabulation of some
*** commonly used statements, and some suggested places to put
*** implementation comments, if needed.

// ---------------------------------------------------------------------------
// ?description_if_needed
// ---------------------------------------------------------------------------
//
?classname::?classname()
    {
    if ( ?condition )
        {
        // ?implementation_comment
        ?code
        }
    else
        {
        // ?implementation_comment
        ?code
        }

    // ?implementation_comment
    while ( ?condition )
        {
        ?code
        }

    // ?implementation_comment
    for ( ?for_init_statement; ?condition; ?expression )
        {
        ?code
        }

    // ?implementation_comment
    switch ( ?condition )
        {
        case ?constant:
            ?code
            break;
        case ?constant:
            ?code
            // fall-through intended here
        case ?constant:
            ?code
            break;
        default:
            ?code
            break;
        }
    }


// ---------------------------------------------------------------------------
// ?description_if_needed
// ---------------------------------------------------------------------------
//
void ?classname::ConstructL()
    {
    ?code
    }


// ---------------------------------------------------------------------------
// ?description_if_needed
// ---------------------------------------------------------------------------
//
EXPORT_C ?classname* ?classname::NewL()
    {
    ?classname* self = ?classname::NewLC();
    CleanupStack::Pop( self );
    return self;
    }


// ---------------------------------------------------------------------------
// ?description_if_needed
// ---------------------------------------------------------------------------
//
EXPORT_C ?classname* ?classname::NewLC()
    {
    ?classname* self = new( ELeave ) ?classname;
    CleanupStack::PushL( self );
    self->ConstructL();
    return self;
    }


// ---------------------------------------------------------------------------
// ?description_if_needed
// ---------------------------------------------------------------------------
//
?classname::~?classname()
    {
    ?code
    }


*** Non-derived function:

// ---------------------------------------------------------------------------
// ?implementation_description
// ---------------------------------------------------------------------------
//
?EXPORT_C ?type ?classname::?member_function(
    ?really_really_really_really_long_arg_type_1 ?really_really_long_arg_1,
    ?really_really_really_really_long_arg_type_2 ?really_really_long_arg_2 )
    {
    ?code
    }


*** Derived function:

// ---------------------------------------------------------------------------
// From class ?base_class.
// ?implementation_description
// ---------------------------------------------------------------------------
//
?EXPORT_C ?type ?function_name( ?arg_type_1 ?arg_1, ?arg_type_2 ?arg_2 )
    {
    ?code
    }


// ======== GLOBAL FUNCTIONS ========

*** For an application's UiApp class, functions NewApplication and E32Main
*** should go here:

// ---------------------------------------------------------------------------
// Constructs and returns an application object.
// ---------------------------------------------------------------------------
//
EXPORT_C CApaApplication* NewApplication()
    {
    return new ?CMyApplication;
    }


// ---------------------------------------------------------------------------
// Main function of the application executable.
// ---------------------------------------------------------------------------
//
GLDEF_C TInt E32Main()
    {
    return EikStart::RunApplication( NewApplication );
    }
