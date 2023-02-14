import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

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
        return uc.getContentType();
    }

    String getSize(String address) throws IOException {
        URL url = new URL(address);
        URLConnection uc = url.openConnection();
        int size = uc.getContentLength() / 1024;
        return size + "KB";
    }

    String getWaitingTime(URL url){
        return Http.responseTime - Http.requestTime + "ms";
    }


    String getDownloadTime(URL url) {
        return Http.downloadedTime - Http.responseTime + "ms";
    }

}