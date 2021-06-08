import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App {

    public static void main(String[] args) {
        try {
            System.out.println("Running...\n");
            String url = "https://www.imdb.com/title/tt1179904/";
            
            Document doc = Jsoup.connect(url).timeout(10000).get();
            System.out.println("Title:\n" + doc.title());
            
            Elements prod = doc.select("div.txt-block");
            Elements productionCompany = new Elements();
            
            for (Element el : prod) {
                productionCompany = el.select("a");
            }
            System.out.println("Production:\n" + productionCompany.text());

            Elements article = doc.select("div.article");
            Elements table = article.select("table");
            Elements casts = new Elements();
            
            for (Element el : table) {
                casts = el.select("tr");
            } 

            System.out.println("Cast:");
            for (int i = 1; i < casts.size(); i++) {
                System.out.println(casts.get(i).text());
            }
        }
        catch (Exception err) {
            System.out.println("An error ocurred while running the program...");
            System.out.println(err);
        }
    }
}
