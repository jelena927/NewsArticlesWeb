package main;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;

import org.codehaus.jackson.map.ser.PropertyBuilder;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

import parser.NewsArticleParser;
import parser.WebCrawler;
import persistence.RDFModel;
import services.QueryService;
import domain.NewsArticle;

public class Main {

	public static void main(String[] args) {
		try {
			List<NewsArticle> list = WebCrawler.craw();
			for (NewsArticle newsArticle : list) {
				RDFModel.getInstance().save(newsArticle);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//		QueryService queryService = new QueryService();
//		
//		Collection<NewsArticle> kolekcija = queryService.getAllNewsArticles();
//		for (NewsArticle newsArticle : kolekcija) {
//			System.out.println(newsArticle.getAuthor());
//		}
//		System.out.println(kolekcija.size());
		RDFModel.getInstance().closeModel();
	}
	
}
