package domain;

import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import thewebsemantic.Namespace;
import thewebsemantic.RdfProperty;
import thewebsemantic.RdfType;
import util.Constants;

@Namespace(Constants.SCHEMA)
@RdfType("NewsArticle")
public class NewsArticle extends Thing {

	@RdfProperty(Constants.SCHEMA + "headline")
	private String headline;
	@RdfProperty(Constants.SCHEMA + "alternativeHeadline")
	private String alternativeHeadline;
	@RdfProperty(Constants.SCHEMA + "inLanguage")
	private String inLanguage;
	@RdfProperty(Constants.SCHEMA + "datePublished")
	private Date datePublished;
	@RdfProperty(Constants.SCHEMA + "dateModified")
	private Date dateModified;
	@RdfProperty(Constants.SCHEMA + "description")
	private String description;
	@RdfProperty(Constants.SCHEMA + "genre")
	private String genre;
	@RdfProperty(Constants.SCHEMA + "articleSection")
	private String articleSection;
	@RdfProperty(Constants.SCHEMA + "thumbnailUrl")
	private String thumbnailUrl;
	@RdfProperty(Constants.NS + "has_identifier")
	private String identifier;
	@RdfProperty(Constants.SCHEMA + "url")
	private URI url;
	@RdfProperty(Constants.SCHEMA + "author")
	private Person author;
	@RdfProperty(Constants.SCHEMA + "provider")
	private Organisation provider;
	@RdfProperty(Constants.SCHEMA + "associatedMedia")
	private ImageObject associatedMedia;
	@RdfProperty(Constants.SCHEMA + "about")
	private List<Thing> about;
	
	public NewsArticle() {
		about = new ArrayList<>();
	}
	
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getAlternativeHeadline() {
		return alternativeHeadline;
	}
	public void setAlternativeHeadline(String alternativeHeadline) {
		this.alternativeHeadline = alternativeHeadline;
	}
	public String getInLanguage() {
		return inLanguage;
	}
	public void setInLanguage(String inLanguage) {
		this.inLanguage = inLanguage;
	}
	public Date getDatePublished() {
		return datePublished;
	}
	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
	}
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getArticleSection() {
		return articleSection;
	}
	public void setArticleSection(String articleSection) {
		this.articleSection = articleSection;
	}
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public URI getUrl() {
		return url;
	}

	public void setUrl(URI url) {
		this.url = url;
	}

	public Person getAuthor() {
		return author;
	}
	public void setAuthor(Person author) {
		this.author = author;
	}
	public Organisation getProvider() {
		return provider;
	}
	public void setProvider(Organisation provider) {
		this.provider = provider;
	}
	public ImageObject getAssociatedMedia() {
		return associatedMedia;
	}
	public void setAssociatedMedia(ImageObject associatedMedia) {
		this.associatedMedia = associatedMedia;
	}
	public List<Thing> getAbout() {
		return about;
	}
	public void addAbout(Thing about) {
		this.about.add(about);
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return super.toString() + "\nHeadline: " + headline + "\nalternativeHeadline: " + alternativeHeadline + 
				"\nidentifier: " + identifier + "\narticleSection: " + articleSection + 
				"\ndescription: " + description + "\ngenre: " + genre + 
				"\ninLanguage: " + inLanguage + "\nabout: " + about + "\nassociatedMedia: " + associatedMedia + 
				"\nauthor: " + author + "\ndateModified: " + sdf.format(dateModified) + 
				"\ndatePublished: " + sdf.format(datePublished) + 
				"\nprovider: " + provider + "\nthumbnailUrl: " + thumbnailUrl + "\nurl: " + url;
	}
}
