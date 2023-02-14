import org.jsoup.Jsoup;

import javax.swing.text.Document;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class Http {
    static long waitingTime;
    static long downloadedTime;
    public static void main(String[] args) throws IOException, URISyntaxException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Output output = new Output();
        while (true) {
            System.out.print("> ");
            String address = br.readLine();
            if (!address.startsWith("http")) {
                address = "https://" + address;
            }
            Document doc = (Document) Jsoup.connect(address).get();
            



            URL url = new URL(address);
            URLConnection connection = url.openConnection();

            long requestTime = System.currentTimeMillis();
            connection.connect();
            long responseTime = System.currentTimeMillis();
            waitingTime = responseTime - requestTime;
            downloadedTime = waitingTime + connection.getContentLength() / 1024;


//            connection.setDefaultUseCaches(true);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            output.printInfo(url, address);
        }
    }
}