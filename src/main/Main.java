package main;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.RDFNode;

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
		articles.write(System.out, "TURTLE");
		
		RDFModel.getInstance().closeModel();
	}
	
}
