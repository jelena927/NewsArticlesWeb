package main;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;

import parser.WebCrawler;
import persistence.RDFModel;
import domain.NewsArticle;

public class Main {

	public static void main(String[] args) {
		try {
			List<NewsArticle> list = WebCrawler.craw();
			NewsArticle article = list.get(0);
			for (NewsArticle newsArticle : list) {
				RDFModel.getInstance().save(newsArticle);
			}
			RDFModel.getInstance().close();

			RDFModel.getInstance().printOut();

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
	}
	
}
