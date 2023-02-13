import java.io.IOException;
import java.net.*;

public class Information {
    String getDomain(URL url) {
        return url.getHost();
    }

    String getScheme(String address) throws URISyntaxException {
        URI uri = new URI(address);
        return uri.getScheme();
    }

    String getPath(URL url) {
        return url.getPath();
    }

    String getSort(String address) throws IOException {
        URL url = new URL(address);
        URLConnection uc = url.openConnection();
        URL resource = getClass().getClassLoader().getResource(address);
        return uc.getContentType();
    }
}
