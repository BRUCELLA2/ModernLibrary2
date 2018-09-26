# Modern Library

The Modern Library application currently consists of 3 main parts.

A Web Service part, Modern Library Web Services, provides a set of webservices that will be 
consumed by third-party applications. This is the heart of the Modern Library application.

A Web Application part, Modern Library Clients, is intended for the library's clients. This 
application must allow clients, among other things, to search for works, to extend its loans, 
to consult the outstanding loans....

A Batch part, Modern Library Batch, which allows the sending of a reminder email to users 
not having returned the works for which the loan period has ended.

In the future, two additional parts will be added in a future issue.

A Mobile part, Modern Library Mobile, which will be the interface for users on a device 
mobile.

A Management part, Modern Library Management, which will be the interface for 
library for management purposes.

Full documentation are in document.pdf in documentation folder.

## Requirement

This project needs :
* Apache Maven 3.5.3
* Tomcat 9.0.10
* Java JDK 8 version 162
* PostgreSQL 10.4
* Spring Framework 4.3.11.RELEASE
* Apache Struts 2.5.16
* Apache CXF 3.2.5
* Apache Log4j 2.11.0
* Bootstrap 4.1.3
* Docker (lastest version)

For production requirement details for each server look at document.pdf in documentation folder.

## Set-up
### Database

Scripts for database and data creation are in Database folder. 
Database user configuration is set in the docker-compose.yml. if you change this configuration, don't forgot to change it in the context.xml in META-INF for the Modern Library Web Services application.

In the Docker folder use this command :
* docker-compose -p modernlibrary up -d database

In database server, change port configuration in postgresql.conf. Set it to :
port = 5436	

### Modern Library Web Services

In the Docker folder use this command :
* docker-compose -p modernlibrary up -d web-service

### Modern Library Clients

In the Docker folder use this command :
* docker-compose -p modernlibrary up -d clients

### Modern Library Batch

In the Docker folder use this commands :

cd ~/library-batch
docker build -t modernlibbatch .

cd ..
docker-compose -p modernlibrary up -d batch

## Running Modern Library

Modern Library Clients will be running on : http://0.0.0.0:8081/library-clients/

Modern Library Web Services wsdls can be view here : http://0.0.0.0:8080/library-ws-services/services