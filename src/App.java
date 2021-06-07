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
            
            Elements castList = doc.select("div.article");
            System.out.println(castList);

            for (Element cast : castList) {
                System.out.println(cast.getElementsByTag("td"));
            }
        }
        catch (Exception err) {
            System.out.println("An error ocurred while running the program...");
            System.out.println(err);
        }
    }
}
