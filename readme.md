# DNS Discover Service

## Project description

Discover Service is using DNS (https://en.wikipedia.org/wiki/Domain_Name_System), reading Zone Files (https://en.wikipedia.org/wiki/Zone_file) which define content of DNS domain.

Project is developing with cooperation of TeskaLabs (https://www.teskalabs.com/). They are using basic setup for that right now. BIND9 server reads Zone Files from HDD.

Our goal is to extend current solution, connect it with PostgreSQL database, build web application which will allow to edit zone files (exactly the zone information stored in database) and build REST API for easy integration with other services.

Whole project is open-source.

## API

On the top of Java app is built an API for easily extension and communication with other systems.

### End-points

#### General

* POST Login user
* GET Logout
* (POST password/reset, POST password/email, GET password/reset/{token}, GET password/reseted)

#### Role
* POST Grant user access to project
* POST Revoke user access to project

#### DNS_Record

* GET List of DNS Records
* GET List of DNS Records related to specific project
* GET Detail of DNS Record
* POST Create a new DNS Record
* PUT Edit existing DNS Record
* DELETE Delete selected DNS Record

#### Project

* GET List of Projects
* GET Detail of Project
* POST Create a new Project
* PUT Edit existing Project
* DELETE Delete selected Project

#### User

* GET List of users
* GET Detail of user
* POST Create a new user
* PUT Edit existing user
* DELETE Delete existing user

...

## User-Project Management

### Roles

* **Watcher** - Can view records related to project
* **Editor** - Can view, edit and delete records related to project
* **Manager** - Can view, edit and delete records related to project. Add and delete another users (watchers and editors) related to project. Create and delete projects.
* **Admin** - Can view, edit and delete all records in app. Add and delete another users (watchers, editors and managers) across whole app. Create and delete all projects.

## Built With

* Spring Framework
* PostgreSQL
* Maven

## Authors

* **Marek Dlugos** - *Database, API, Frontend App* - [Marek's web site](http://mareks.space)
* **Jakub Lecbych** - *Tests, Frontend App* - [Jakub's e-mail](mailto:lecbyjak@fel.cvut.cz)