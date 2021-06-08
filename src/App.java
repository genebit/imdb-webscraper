import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App {

    public static void main(String[] args) {
        try {
            System.out.println("Running...");
            String url = "https://www.imdb.com/title/tt1179904/";
            Document doc = Jsoup.connect(url).get();
            
            System.out.println(doc.title());
            
            Elements article = doc.select("div.article");
            Elements table = article.select("table");

            for (Element el : table) {
                Elements casts = el.select("tr");
                System.out.println(casts.text());
            }    
        }
        catch (Exception err) {
            System.out.println("An error ocurred while running the program...");
            System.out.println(err);
        }
    }
}
