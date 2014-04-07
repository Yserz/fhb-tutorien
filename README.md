We Love Coding — Web App
==========
This is an attempt to make **www.welovecoding.com** a better place...

![](http://93.180.157.228:8080/buildStatus/icon?job=WeLoveCoding_Test)

## Configuration: ##

**MySQL**

- Database: welovecoding
- User: welovecoding
- Password: 123456
- Host: localhost

**LESS preprocessor**

Istallation

1. [Install NodeJS](http://nodejs.org/)
2. On command line: 
**npm install -g less**
3. Add **lessc.cmd** (for Windows) to the LESS path in NetBeans:
**C:\Users\username\AppData\Roaming\npm\lessc.cmd**

Project configuration:

- **Input:** /WEB-INF/frontend/less
- **Output:** ../resources/META-INF/resources/css/generated

[Disable debug info](https://netbeans.org/bugzilla/show_bug.cgi?id=237855#c1) 

**CoffeeScript**

[CoffeeScript in NetBeans](https://blogs.oracle.com/geertjan/entry/coffeescript_rocks_in_netbeans_ide)

## Useful resources: ##

**Java**

- [Generating a JavaServer Faces 2.x CRUD Application from a Database](https://netbeans.org/kb/docs/web/jsf20-crud.html)
- [From database to RESTful web service to HTML5 in FIVE minutes](http://jaxenter.com/from-database-to-restful-web-service-to-html5-in-five-minutes-48908.html)
- [How to use a JEE Filter to secure JSF 2 application resources](http://www.itcuties.com/j2ee/jsf-2-login-filter-example/)
- [Composite Components In JSF 2.0](http://www.mkyong.com/jsf2/composite-components-in-jsf-2-0/)
- [GZip Compression for JEE Web Application](http://hirenscafe.blogspot.de/2010/02/gzip-compression-for-web-application.html)

**Mobile Web Apps**

- [Best Practices for Developing Web Apps](https://developer.amazon.com/sdk/webapps/Best-Practices.html)

**Rules & Conventions**

- [Apache Maven: Guide to naming conventions](http://maven.apache.org/guides/mini/guide-naming-conventions.html)
- [Should package names be singular or plural?](http://programmers.stackexchange.com/a/75929)
- [Which XHTML files do I need to put in /WEB-INF and which not?](http://stackoverflow.com/a/9033567/451634)
- [New JSF 2.2 namespaces](http://jsflive.wordpress.com/2013/05/16/jsf22-namespaces/) <- At the moment we should use THE OLD namespaces ([reason](http://stackoverflow.com/questions/17361528/uirepeat-in-jsf-2-2-is-working-but-rendered))
- [How to Write Doc Comments for the Javadoc Tool](http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html)

**UI & UX**

- [A Good User Interface](http://www.goodui.org/)

## Reference: ##
- [Bean Scopes](http://stackoverflow.com/a/17683041/451634)
- [Managed Bean types](http://stackoverflow.com/a/1030196/451634)
- [Communication in JSF 2.0](http://balusc.blogspot.de/2011/09/communication-in-jsf-20.html)
- [Maven Default Lifecycle Phases](http://www.avajava.com/tutorials/lessons/what-are-the-phases-of-the-maven-default-lifecycle.html)

##Cool projects:##
- [Apache Isis™](http://isis.apache.org/)
- [Pebble - A lightweight, open source, Java EE blogging tool](https://github.com/pebbleblog/pebble)
- [Project Lombok](http://projectlombok.org/), [Project Lombok & JEE](http://javalabor.blogspot.de/2012/01/java-verbosity-jee-and-lombok.html)
- [Pure CSS modules](http://purecss.io/)

##Website Analyzer:##
- [SEO tools](http://www.feedthebot.com/tools/)
- [http://developers.google.com/speed/pagespeed/insights/?url=wwww.welovecoding.com&tab=desktop](http://developers.google.com/speed/pagespeed/insights/?url=wwww.welovecoding.com&tab=desktop)
- [http://validator.w3.org/check?uri=wwww.welovecoding.com](http://validator.w3.org/check?uri=wwww.welovecoding.com)
- [http://tools.quicksprout.com/analyze/www.welovecoding.com](http://tools.quicksprout.com/analyze/www.welovecoding.com)
- [Load testing from the cloud (free credits)](https://www.blitz.io/bKjFTlt40QR0nr7aXHFJ0Y)

##REST service##
- [http://localhost:8080/wlc_webapp/rest/fhb/v1/categories](http://localhost:8080/wlc_webapp/rest/fhb/v1/categories)

##Lessons learned##

- Avoid using component bindings to a bean that has session scope
- Never assign FacesContext as instance variable of a view/session/application scoped managed bean, because the FacesContext instance is request scoped 
