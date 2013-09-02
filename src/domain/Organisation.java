package domain;

import java.net.URL;

import thewebsemantic.Namespace;
import thewebsemantic.RdfProperty;
import thewebsemantic.RdfType;
import util.Constants;

@Namespace(Constants.SCHEMA)
@RdfType("Organization")
public class Organisation extends Thing {
	
	@RdfProperty(Constants.SCHEMA + "name")
	private String name;
//	@RdfProperty(Constants.NS + "has_id")
//	private String id;
	@RdfProperty(Constants.SCHEMA + "url")
	private String url;
	@RdfProperty(Constants.SCHEMA + "tickerSymbol")
	private String tickerSymbol;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTickerSymbol() {
		return tickerSymbol;
	}
	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}

	@Override
	public String toString() {
		return super.toString() + ", name: " + name + ", tickerSymbol: " + tickerSymbol + ", url: " + url;
	}
}
