package parser;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import util.URIGenerator;

import domain.AboutThing;
import domain.ImageObject;
import domain.NewsArticle;
import domain.Organisation;
import domain.Person;
import domain.Thing;

public class NewsArticleParser {

	static public NewsArticle parse(String url) throws IOException, URISyntaxException, ParseException {

		NewsArticle article = new NewsArticle();
		
		Document doc = Jsoup.connect(url).get();
		
		Element el = doc.getElementsByAttributeValue("itemtype", "http://schema.org/NewsArticle").first();
		article.setUrl(new URI(el.attributes().get("itemid")));
		article.setUri(URIGenerator.generate(article));
		
		Elements elements = doc.getElementsByAttribute("itemprop");	
		for (Element element : elements) {
			String itemprop = element.attributes().get("itemprop");
			String content = element.attributes().get("content");
			switch (itemprop) {
			case "inLanguage":
				article.setInLanguage(content);
				break;
			case "description":
				if (article.getDescription() != null) break;
				article.setDescription(content);
				break;
			case "dateModified":
				Date dateModified = new SimpleDateFormat("yyyy-MM-dd").parse(content);
				article.setDateModified(dateModified);
				break;
			case "datePublished":
				Date datePublished = new SimpleDateFormat("yyyy-MM-dd").parse(content);
				article.setDatePublished(datePublished);
				break;
			case "alternativeHeadline":
				article.setAlternativeHeadline(content);
				break;
			case "genre":
				article.setGenre(content);
				break;
			case "articleSection":
				article.setArticleSection(content);
				break;
			case "identifier":
				if (article.getIdentifier() != null) break;
				article.setIdentifier(content);
				break;
			case "thumbnailUrl":
				article.setThumbnailUrl(content);
				break;
			case "associatedMedia":
				ImageObject media = new ImageObject();
				Elements children = element.getElementsByAttribute("itemprop");
				for (Element element2 : children) {
					itemprop = element2.attributes().get("itemprop");
					content = element2.attributes().get("content");
					switch (itemprop) {
					case "url":
						media.setUrl(element2.attributes().get("src"));
						break;
					case "description":
						media.setDescription(content);
						break;
					case "width":
						media.setWidth(Double.parseDouble(content));
						break;
					case "height":
						media.setHeight(Double.parseDouble(content));
						break;
					case "copyrightHolder":
						media.setCopyrightHolder(element.text());
						break;
					default:
						break;
					}
				}
				media.setUri(URIGenerator.generate(media));
				article.setAssociatedMedia(media);
				break;
			case "author creator":
				Person author = new Person();
				children = element.getElementsByAttribute("itemprop");
				for (Element element2 : children) {
					itemprop = element2.attributes().get("itemprop");
					content = element2.attributes().get("content");
					switch (itemprop) {
					case "name":
						author.setName(element2.text());
						break;
					default:
						break;
					}
				}
				author.setUri(URIGenerator.generate(author));
				article.setAuthor(author);
				break;
			case "copyrightHolder provider sourceOrganization":
				Organisation provider = new Organisation();
				children = element.getElementsByAttribute("itemprop");
				for (Element element2 : children) {
					itemprop = element2.attributes().get("itemprop");
					content = element2.attributes().get("content");
					switch (itemprop) {
					case "name":
						provider.setName(content);
						break;
					case "url":
						provider.setUrl(content);
						break;
					case "tickerSymbol":
						provider.setTickerSymbol(content);
						break;
					default:
						break;
					}
				}
				provider.setUri(URIGenerator.generate(provider));
				article.setProvider(provider);
				break;
			case "about":
				AboutThing about = new AboutThing();
				about.setName(element.text());
				about.setUri(URIGenerator.generate(about));
				article.addAbout(about);
				break;
			case "headline":
				article.setHeadline(element.text());
				break;
			default:
				break;
			}
		}
		return article;
	}
	
	public static JsonObject serialize(NewsArticle newsArticle){
		JsonObject newsArticleJson = new JsonObject();
		
		newsArticleJson.addProperty("headline", newsArticle.getHeadline());
		newsArticleJson.addProperty("datePublished", newsArticle.getDatePublished().toString());
		String about = "";
		for (Thing a : newsArticle.getAbout()) {
			about += ((AboutThing)a).getName() + " ";
		}
		newsArticleJson.addProperty("author", newsArticle.getAuthor().getName());
		newsArticleJson.addProperty("about", about);
		newsArticleJson.addProperty("inLanguage", newsArticle.getInLanguage());
		newsArticleJson.addProperty("genre", newsArticle.getGenre());
		newsArticleJson.addProperty("provider", newsArticle.getProvider().getName());
		newsArticleJson.addProperty("type", "newsArticle");
		
		return newsArticleJson;
	}
}
