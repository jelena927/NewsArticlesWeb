NewsArticlesWeb
===============
1. About the project
The idea of this project is to create  an application for advanced news search using extracted metadata about news articles. The metadata is extracted from the website New York Times. Metadata is inserted in site's webpages in a structured format using Microdata standard, specifically using Schema.org vocabulary. After the metadata is extracted, it is transformed to RDF format and stored into RDF repository. Access to the extracted data is enabled through RESTful services. News search is enabled through filter based search.

Application workflow consists of the following phases
 - A web crawler parses news articles webpages from New York Times website and extracts news article metadata.
- Extracted data is transformed into RDF triplets based on Schema.org vocabulary.
- Data is persisted into an RDF repository.
- Access to the data is enabled through RESTful services.
- Search news articles using filters so-called facet browsing.

2. Domain model
Webpages of news articles from the New York Times website are analyzed in order to determine which classes and properties form the Schema.org vocabulary are supported. Based on that analysis, domain model is created and it is depicted in Picture 1.

![Alt text](https://raw.github.com/jelena927/NewsArticlesWeb/blob/master/model.png "Domain model picture")

Class NewsArticle contains basic information about a news article, such as: headline, ... It has reference to its author (class Person), its provider (class Organization), associated media (class ImageObject) and its theme (class Thing).

Class Person

Class Organisation

Class ImageObject 

3. The solution


4. Technical realisation
This application is written in programming language Java.

Jsoup library is used for analyzing and collecting data from the web pages. It provides a very convenient API for extracting and manipulating data, using the best of DOM, CSS, and jquery-like methods.

This application also uses Jenabean library for mapping Java objects into RDF triplets using annotations. Jenabean provides explicit binding between an object property and a particular RDF property.

Jena TDB library is used for data storage in the RDF repository. TDB is a component of Jena for RDF storage and query. It support the full range of Jena APIs.

Implementation of the RESTful web service is supported by Jersey framework. Jersey is the open source JAX-RS Reference Implementation for building RESTful Web services. It uses annotations which define type of the HTTP requests (GET, POST ...) and also the path to the requested resource.

For filter based browsing is used Exibit.  Exibit enables complex databases to be searched and browsed using faceted browsing.

5. Acknowledgements
This application has been developed as a part of the project assignment for the subject Intelligent Systems at the Faculty of Organization Sciences, University of Belgrade, Serbia.

6. Licence
This software is licensed under the MIT License.

The MIT License (MIT)

Copyright (c) 2013 Jelena Đorđević - jelena927@gmail.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
