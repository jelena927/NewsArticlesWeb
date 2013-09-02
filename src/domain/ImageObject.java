package domain;

import java.net.URL;

import thewebsemantic.Namespace;
import thewebsemantic.RdfProperty;
import thewebsemantic.RdfType;
import util.Constants;

@Namespace(Constants.SCHEMA)
@RdfType("ImageObject")
public class ImageObject extends Thing {
	
	@RdfProperty(Constants.SCHEMA + "copyrightHolder")
	private String copyrightHolder;
	@RdfProperty(Constants.SCHEMA + "width")
	private double width;
	@RdfProperty(Constants.SCHEMA + "height")
	private double height;
	@RdfProperty(Constants.SCHEMA + "description")
	private String description;
	@RdfProperty(Constants.SCHEMA + "url")
	private String url;
	
	public String getCopyrightHolder() {
		return copyrightHolder;
	}
	public void setCopyrightHolder(String copyrightHolder) {
		this.copyrightHolder = copyrightHolder;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return super.toString() + ", copyrightHolder: " + copyrightHolder + ", description: " + description +
				", width: " + width + ", height: " + height + ", url: " + url;
	}
}
