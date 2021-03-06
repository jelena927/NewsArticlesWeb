package util;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

public class URIGenerator {

	public static <T extends domain.Thing> URI generate(T resource) throws URISyntaxException{
		String uri = Constants.NS + 
				resource.getClass().getSimpleName() + 
				"/" + UUID.randomUUID();
		return new URI(uri);
	}
}
