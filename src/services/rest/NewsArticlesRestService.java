package services.rest;


import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

@Path("/newsArticles")
public class NewsArticlesRestService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllMovies(){
		JsonParser parser = new JsonParser();
		try {
			JsonObject json = (JsonObject) parser.parse(new FileReader("C:\\Users\\Jelena\\Desktop\\exhibit-master\\scripted\\demos\\senate\\senate-committees.js"));
			return json.toString();
			
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new WebApplicationException(Response.Status.NO_CONTENT);
	}
}
