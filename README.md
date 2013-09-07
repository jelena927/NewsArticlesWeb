NewsArticlesWeb
===============
# 1. About the project
The idea of this project is to create  an application for advanced news search using extracted metadata about news articles. The metadata is extracted from the website [New York Times](http://www.nytimes.com/). 
Metadata is inserted in site's webpages in a structured format using [Microdata standard](http://dev.w3.org/html5/md/), specifically using [Schema.org](http://schema.org/) vocabulary. After the metadata is extracted, it is transformed to RDF format and stored into RDF repository. Access to the extracted data is enabled through RESTful service. News search is enabled through filter based search.

Application workflow consists of the following phases:
- A web crawler parses news articles webpages from [New York Times](http://www.nytimes.com/) website and extracts news article metadata.
- Extracted data is transformed into RDF triplets based on [Schema.org](http://schema.org/) vocabulary.
- Data is persisted into RDF repository.
- Access to the data is enabled through RESTful service.
- Search of news articles is enabled by facet browsing enabled interface.

# 2. Domain model
Webpages of news articles from the New York Times website are analyzed in order to determine which classes and properties from the Schema.org vocabulary are supported. Based on that analysis, domain model is created and it is depicted in Picture 1.

![Picture 1 - Domain model](https://raw.github.com/jelena927/NewsArticlesWeb/master/model.png)

Picture 1 - Domain model

Class *NewsArticle* contains basic information about a news article. Those are: headline, alternativeHeadline, inLanguage, description, dateModified, datePublished, genre, articleSection, thumbnailUrl, has_Identifier, url. It has reference to its author (class Person), its provider (class Organization), associated media (class ImageObject) and its theme (class Thing).

Class *Person* contains authors's name.

Class *Organisation* contains basic information of a news article provider such as provider's name, tickerSymbol and url address.

Class *ImageObject* contains basic information of news article associated media such as image url, copyright holder, width, height, description.

# 3. The solution
Application collects metadata about news Articles from the webpage [New York Times](http://www.nytimes.com/). The data is extracted by the crawler and is used to create domain objects of the application that are persisted into the RDF repository. The application allows access to that data via RESTful service.

Application contains one REST service.
* **api/newsArticles** - returns all news articles in JSON format

Faceted search enabled interface fetches the data about news article from this REST service and uses the data to display results.

# 4. Technical realisation
This application is written in programming language Java.

[Jsoup library](http://jsoup.org/) is used for analyzing and collecting data from the web pages. It provides a very convenient API for extracting and manipulating data, using the best of DOM, CSS, and jquery-like methods.

This application also uses [Jenabean library](https://code.google.com/p/jenabean/) for mapping Java objects into RDF triplets using annotations. Jenabean provides explicit binding between an object property and a particular RDF property.

[Jena TDB](http://jena.apache.org/documentation/tdb/) is used for data storage in the RDF repository. TDB is a component of Jena for RDF storage and query. It support the full range of Jena APIs.

Implementation of the RESTful web service is supported by [Jersey](https://jersey.java.net/) framework. Jersey is the open source JAX-RS Reference Implementation for building RESTful Web services. It uses annotations which define type of the HTTP requests (GET, POST ...) and also the path to the requested resource.

For filter based browsing is used [Exibit](http://www.simile-widgets.org/exhibit/).  Exibit enables complex databases to be searched and browsed using faceted browsing.

# 5. Running the application

# 6. Acknowledgements
This application has been developed as a part of the project assignment for the subject [Intelligent Systems](http://is.fon.rs) at the Faculty of Organization Sciences, University of Belgrade, Serbia.

# 7. Licence
This software is licensed under the [MIT License](http://opensource.org/licenses/MIT).

The MIT License (MIT)

Copyright (c) 2013 Jelena Đorđević - jelena927@gmail.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
