doc-viewer
==========

@author: harshadura | @license: GPL-v3

Tools: Java 1.6, MySQL, Maven with Jetty plugin/Tomcat

How to RUN
----------

1. First run the SQL queries under (DB_with_sampleData.sql): Default DB name: doc

2. Change the username, password (if needed) under the (doc.properties) file

3. Fire:  mvn clean install jetty:run

4. Login the system with default user: harsha, pass: 123 

5. Logs will be created at (UserHome/doc-viewer-AppLog.log)

Assignment Spec
----------------

Write a web application which enables searching and viewing a list of documents, by providing a set of tags as search criteria. A document would consist of following fields:

ID - A unique identifier for document (UUID)
Content - The content of the document (assume this is a String)
Tags- A list of tags (Strings) associated with the document.

The web application should provide a pagination facility. UI should consist of a grid which shows the matches, a search criteria box where the tags (one or more) can be specified. Documents are to be stored in a database (saving functionality is out of scope for this assignment. But you are required to design the tables, and write a small SQL script to populate with dummy data to simulate pagination etc).
Consider UI/UX aspects such as summarizing the content in the grid so that it will not overflow the grid if a document with a large content is returned, etc.

The application should include a small login facility (with a fixed username / password) and users who are not logged in should not be able to view the document search page.
If possible, consider sorting the documents based on the relevancy to the search tags with a scoring system. For example,  if a document matches all of the tags given for search, it should appear before a document which matches only one of the tags.

Evaluation Notes:

Standard criteria for code-quality and adherence to standards, accuracy, robustness, code comments and self-documented code.

Database Skills - Schema Design, Correct use of DB access APIs / tools, SQL

HTML / Javascript skills - Use of available open source libraries where applicable

Analytical skills - If a scoring is implemented

Build Scripting (If used)- Maven / Ant - Cleanness and adherence to best practices for the tools.


