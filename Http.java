import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class Http {
    static long requestTime;
    static long responseTime;
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
            URL url = new URL(address);
            URLConnection connection = url.openConnection();
            long startTime = System.currentTimeMillis();
            connection.connect();
            long endTime = System.currentTimeMillis();
            requestTime = endTime - startTime;

            startTime = System.currentTimeMillis();
            InputStream inputStream = connection.getInputStream();
            endTime = System.currentTimeMillis();
            responseTime = endTime - startTime;

            startTime = System.currentTimeMillis();
            inputStream.read();
            endTime = System.currentTimeMillis();
            downloadedTime = endTime - startTime;

            output.printInfo(url, address);
        }
    }
}