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
//		try {
//			List<NewsArticle> list = WebCrawler.craw();
//			NewsArticle article = list.get(0);
//			for (NewsArticle newsArticle : list) {
//				RDFModel.getInstance().save(newsArticle);
//			}
//			RDFModel.getInstance().printOut();
//			RDFModel.getInstance().closeModel();
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		QueryService queryService = new QueryService();
		Model articles = queryService.describeAllNewsArticles();
		ResIterator i = articles.listSubjects();
		while (i.hasNext()) {
		  Resource s = i.next();
		  System.out.println( "Graph contains subject " + s );
		  if (s.toString().contains("NewsArticle")) {
			  for (StmtIterator j = s.listProperties(); j.hasNext(); ) {
				    Statement t = j.next();
				    System.out.println( "   with property " + t.getPredicate() + 
				                        " ---> " + t.getObject() );
				    if (t.getPredicate().toString().contains("url")) {
						
					}
		  }
		  }}
		RDFModel.getInstance().closeModel();
	}
	
}
