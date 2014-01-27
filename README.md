# JavaEE in Tomcat

**Disclaimer:** By JavaEE, I'm meaning only CDI (using Weld), JSF, and JAX-RS.

This application is a demo of the blog post found at http://nerdwin15.com/2014/01/using-weld-cdi-jsf-and-jax-rs-in-tomcat/, which describes how to develop a CDI/JSF/JAX-RS application that can deploy in Tomcat and Wildfly without any change to the built WAR file.

## Pre-requisites

Read the blog post, as extra jars are needed in your Tomcat's lib folder.  This application has been tested on Tomcat 7.50 and 8.0.0.RC10.

## Building the application

To build the application, simply run

```
mvn clean install
```

and drop the war file into the webapps folder in your Tomcat directory.

## Running the Application

- Open your browser to http://localhost:8080/javaee-in-tomcat-1.0.0-SNAPSHOT/ (unless you renamed the war file when dropping it into your webapps folder)
- Fill out and submit the form:
  - When submitting the form without the "Use Ajax" button checked, the normal JSF action is called, exercising the backing bean and JSF.
  - When submitting the form with the "Use Ajax" button checked, jQuery is used to get the greeting from the REST (JAX-RS) endpoint.
