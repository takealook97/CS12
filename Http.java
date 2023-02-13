import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

public class Http {
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
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            Information info = new Information();
            output.printInfo(url, address);
        }
    }
}
