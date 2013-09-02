package services;

import java.util.ArrayList;
import java.util.Collection;

import persistence.QueryExecutor;
import persistence.RDFModel;

import util.Constants;

import com.hp.hpl.jena.rdf.model.Model;

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
	
}
