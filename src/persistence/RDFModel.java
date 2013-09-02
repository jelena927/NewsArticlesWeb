package persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import persistence.dataProvider.DataProvider;
import persistence.dataProvider.TDBDataProvider;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import thewebsemantic.Bean2RDF;
import thewebsemantic.RDF2Bean;
import util.Constants;

public class RDFModel {

	DataProvider dataProvider;
	Model graph;
	Bean2RDF writer;
	RDF2Bean reader;
	
	private static RDFModel INSTANCE;
	
	private RDFModel (){
		dataProvider = new TDBDataProvider();
		graph = getModel();
		graph.setNsPrefix("schema", Constants.SCHEMA);
		graph.setNsPrefix("xsd", Constants.XSD);
		
		writer = new Bean2RDF(getModel());
		reader = new RDF2Bean(getModel());
	}
	
	public static RDFModel getInstance(){
		if (INSTANCE == null) {
			INSTANCE = new RDFModel();
		}
		
		return INSTANCE;
	}
	
	public Model getModel(){
		return dataProvider.getDataModel();
	}
	
	public void save(Object o) {
		writer.save(o);
	}
	
	public void close(){
		dataProvider.close();
	}
	
	public Object load(String uri) {
		return reader.load(uri);
	}
	
	public void printOut(){
		graph.write(System.out, "RDF/XML");
	}
	
//	public void readData(String filename, String syntax) throws FileNotFoundException {
//		System.out.println("Importing data");
//		getModel().read(new FileInputStream(filename), syntax);
//		System.out.println("Import finished");
//	}
}
