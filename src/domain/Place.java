package domain;

import java.net.URL;

import thewebsemantic.Namespace;
import thewebsemantic.RdfProperty;
import thewebsemantic.RdfType;
import util.Constants;

@Namespace(Constants.SCHEMA)
@RdfType("Place")
public class Place extends Thing{

	@RdfProperty(Constants.SCHEMA + "name")
	private String name;
	@RdfProperty(Constants.SCHEMA + "url")
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return super.toString() + ", name: " + name + ", url: " + url;
	}
}
