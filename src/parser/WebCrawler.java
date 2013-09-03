package parser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import domain.NewsArticle;

public class WebCrawler {

	public static List<NewsArticle> craw() throws IOException,
			URISyntaxException, ParseException {
		List<String> parsirani = new ArrayList<>();
		List<NewsArticle> list = new ArrayList<>();
		String url = "http://query.nytimes.com/svc/cse/v2/sitesearch.json?pt=article&sort=newest&page=";
		HttpClient httpClient = new DefaultHttpClient();
		String stringResponse = null;
		HttpResponse response = null;
		for (int i = 0; i < 10; i++) {
			HttpGet httpGet = new HttpGet(url + i);
			response = httpClient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				try {
					response.getEntity().writeTo(out);
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				stringResponse = out.toString();
				JsonParser parser = new JsonParser();
				JsonArray searchResults = (((JsonObject) parser
						.parse(stringResponse)).get("results")
						.getAsJsonObject()).get("results").getAsJsonArray();

				for (JsonElement jsonElement : searchResults) {
					
					String articleUrl = jsonElement.getAsJsonObject().get("url").getAsString();
					try {
						if(!parsirani.contains(articleUrl)){
							NewsArticle article = NewsArticleParser.parse(articleUrl);
							list.add(article);
							parsirani.add(articleUrl);
						}
					} catch (Exception e) {
						
					}
				}

			}
		}
		return list;
	}
}
