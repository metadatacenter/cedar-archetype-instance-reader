CEDAR Archetype Instance Reader
===============================

Minimal Java project that uses [jsonschema2pojo](https://github.com/joelittlejohn/jsonschema2pojo) to generate Java classes 
that can read instances of CEDAR templates.

The ```./src/main/resources/json-schema``` directory contains an example JSON Schema-based CEDAR template.

The ```./src/main/resources/json``` directory contains an example JSON-based template instance corresponding to that template.

The main class ```org.metadatacenter.archetype.TemplateInstanceReader``` contains an example of reading a template instance 
using a jsonschema2pojo-generated Java class and printing out its contents.

#### Building and Running

To build this library you must have the following items installed:

+ [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
+ A tool for checking out a [Git](http://git-scm.com/) repository.
+ Apache's [Maven](http://maven.apache.org/index.html).

First build the [CEDAR parent project](https://github.com/metadatacenter/cedar-parent).

Get a copy of the latest code:

    git clone https://github.com/metadatacenter/cedar-archetype-instance-reader.git

Change into the cedar-archetype-instance-reader directory:

    cd cedar-archetype-instance-reader 

Then build it with Maven:

    mvn clean install

To run:

    mvn exec:java

