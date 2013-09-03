package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import persistence.QueryExecutor;
import persistence.RDFModel;

import util.Constants;

import com.hp.hpl.jena.rdf.model.Model;

import domain.NewsArticle;

public class QueryService {
	
	private QueryExecutor queryExecutor = new QueryExecutor();
	
	public Model describeAllNewsArticles() {
		String query = 
			"PREFIX schema: <"+Constants.SCHEMA+"> " + 
			"PREFIX xsd: <"+Constants.XSD+"> " + 
			"DESCRIBE ?article " +
			"WHERE { " +
				"?article a schema:NewsArticle. " +
			"}";
		
		return queryExecutor
				.executeDescribeSparqlQuery(query,
						RDFModel.getInstance().getModel());
	}
	
	public List<NewsArticle> getAllNewsArticles() {
		String query = 
			"PREFIX schema: <"+Constants.SCHEMA+"> " + 
			"PREFIX xsd: <"+Constants.XSD+"> " + 
			"SELECT ?article " +
			"WHERE { " +
				"?article a schema:NewsArticle . " +
			"}";

		Collection<String> result = queryExecutor
				.executeOneVariableSelectSparqlQuery(query, "article",
						RDFModel.getInstance().getModel());
		List<NewsArticle> articles = new ArrayList<>();
		if (result != null && !result.isEmpty()) {
			for (String string : result) {
				NewsArticle a = (NewsArticle) RDFModel.getInstance().load(string);
				articles.add(a);
			}
			return articles;
		}
		
		return new ArrayList<NewsArticle>();
	}
}
