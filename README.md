# aas-copy-template-fields

## Introduction

This Java-based command-line tool provides a simple method to copy fields from one template to another.

This tool provides similar behaviour to that available through the Acrobat Sign web interface, as described at:

+ [Transfer fields to a new library template](https://helpx.adobe.com/sign/using/transfer-fields-to-new-template.html)

However, this tool incorporates one important adjustment to this behaviour. If it finds that the new library template has a smaller number of pages, it does not report the error:

  ![Copy Fields Error](/images/copy-fields-error-snippet.png)

but simply copies as many of the original fields as it can following the logic below:

+ If the original field has a negative value for width, height, or coordinate then it is skipped
+ If the original field is located on a higher page number than the new library template contains it is skipped
+ Otherwise, all fields are copied by mirroring their source properties

This is especially useful when a library document with many fields exists, and the text of the document needs to be changed such that one or more trailing pages are removed. 

## Set-Up Instructions

+ Download the latest release of the `aas-copy-template-fields-<version>.jar` from the [Releases](https://git.corp.adobe.com/sign-acs/aas-copy-template-fields/releases) page
+ [Download Java 1.8](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html), if you don't already have it installed on your machine
+ [IP Addresses to add to your allow list](https://helpx.adobe.com/sign/system-requirements.html#IPs), if needed

As the tool makes use of the [Adobe Sign REST API](https://secure.adobesign.com/public/docs/restapi/v6), it is necessary to [provide an integration key](https://helpx.adobe.com/sign/kb/how-to-create-an-integration-key.html) for your account.

To do this, follow the steps below (for each account):

1. Log in to your Acrobat Sign account (as an Administrator)
2. Click **Group** or **Account**, whichever you see at the top
3. Type "Access tokens" in the search field on the left side of the screen
4. Press the "+" icon on the right side
5. Create a key with the `library_read` and `library_write` scopes for your account
6. Double-click the key you just created and copy the FULL text (it goes off-screen to the right so make sure you get it all)
7. Store the `Integration Key` for later use

## Usage

+ Open a command prompt in the directory where you have the JAR file downloaded
+ Execute the following command, replacing:
  + `<version>` with the appropriate value for the release, such as `1.0.0`
  + `<integrationKey>` with your saved value from above
  + `<sourceTemplateId>` with the ID of the template from which field definitions will be copied
  + `<targetTemplateId>` with the ID of the template which will have field definitions added

```sh
java -jar aas-copy-template-fields-<version>.jar <integrationKey> <sourceTemplateId> <targetTemplateId>
```

Assuming you have specified the required parameters correctly, then you should see output similar to that below:

![Sample Output](/images/example-usage.png)

## Building

If you would like to build a release package locally, you should have the following software installed:

+ OS: Linux, macOS, Windows
+ Java JDK: version 1.8 or above
+ Apache Maven

The tool makes use of the [Adobe Sign Java SDK](https://opensource.adobe.com/acrobat-sign/sdks/java.html), so you will first need to clone the [acrobat-sign repository](https://github.com/adobe/acrobat-sign) and install the package into your Maven repository by issuing the following commands:

```sh
cd <location-of-cloned-acrobat-sign-repo>/sdks/AcrobatSign_JAVA_SDK
mvn clean install
```

Once this has completed, clone this repository and build the package by issuing:

```sh
cd <location-of-cloned-tool-repo>
mvn clean package
```
