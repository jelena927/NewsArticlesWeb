package services.rest;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import parser.NewsArticleParser;
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

@Path("/newsArticles")
public class NewsArticlesRestService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllMovies(){
//		JsonParser parser = new JsonParser();
//		try {
//			JsonObject json = (JsonObject) parser.parse(new FileReader("C:\\Users\\Jelena\\Desktop\\exhibit-master\\scripted\\demos\\senate\\senate-committees.js"));
//			return json.toString();
//			
//		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		throw new WebApplicationException(Response.Status.NO_CONTENT);
		
		QueryService queryService = new QueryService();
		JsonArray jsonArray = new JsonArray();
		Model articles = queryService.describeAllNewsArticles();
		
		
		
		return "";
		
	}
}
