package services.rest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import parser.NewsArticleParser;
import parser.WebCrawler;
import persistence.RDFModel;

import services.QueryService;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

import domain.NewsArticle;

@Path("/newsArticles")
public class NewsArticlesRestService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllMovies() {

		QueryService queryService = new QueryService();
		JsonObject jsonObject = new JsonObject();
		JsonArray jsonArray = new JsonArray();

		Model articles = queryService.describeAllNewsArticles();
		ResIterator i = articles.listSubjects();
		while (i.hasNext()) {
			Resource s = i.next();
			if (s.toString().contains("/NewsArticle/")) {
				for (StmtIterator j = s.listProperties(); j.hasNext();) {
					Statement t = j.next();
					if (t.getPredicate().toString().contains("url")) {
						try {
							jsonArray.add(NewsArticleParser
									.serialize(NewsArticleParser.parse(t
											.getObject().toString())));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				
			}
		}
		RDFModel.getInstance().closeModel();
		jsonObject.add("items", jsonArray);
		JsonObject jsonArticle = new JsonObject();
		jsonArticle.addProperty("pluralLabel", "News Articles");
		jsonArticle.addProperty("uri", "http://schema.org/NewsArticle");
		JsonObject jsonTypes = new JsonObject();
		jsonTypes.add("NewsArticle", jsonArticle);
		jsonObject.add("types", jsonTypes);
		return jsonObject.toString();

	}
}
