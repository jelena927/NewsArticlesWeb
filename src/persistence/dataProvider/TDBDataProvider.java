package persistence.dataProvider;

import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.tdb.TDBFactory;

public class TDBDataProvider implements DataProvider {

	private static final String directory = "tdb";
	private Dataset dataset;

	public TDBDataProvider() {
		dataset = TDBFactory.createDataset(directory);
	}

	@Override
	public Model getDataModel() {
		return dataset.getDefaultModel();
	}
	
	@Override
	public void close() {
		dataset.close();
	}

}
