import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class StatusCode {
    
    private Connection.Response response = null;
    public int statusCode;

    public StatusCode(String url, String userAgent) {
        try {
            response = Jsoup.connect(url)
                .userAgent(userAgent)
                .timeout(10000)
                .execute();
            statusCode = returnStatusCode();
        } 
        catch (Exception err) {
            err.printStackTrace();
        }
    }

    public int returnStatusCode() {
        statusCode = response.statusCode();
        return statusCode;
    }
}
