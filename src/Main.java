import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
    
    private static String url = "https://www.imdb.com/title/tt0185937/?ref_=tt_sims_tti";
    private static String userAgent = "Mozilla/5.0";

    public static void main(String[] args) {
        try {
            System.out.println("Running...\n");

            Document doc = Jsoup.connect(url)
                .userAgent(userAgent)
                .timeout(10000)
                .get();

            // Check first if the status code is good or accepted
            StatusCode code = new StatusCode(url, userAgent);
            
            if (code.statusCode == 200 || code.statusCode == 202) {
                System.out.println("Title:\n" + doc.title());
                System.out.println();
    
                getProduction(doc);
                getGenre(doc);
                getCasts(doc);
            }
            else {
                System.out.println("Status Code: " + code.statusCode);
            }
        }
        catch (Exception err) {
            System.out.println("An error ocurred while running the program...");
            System.out.println(err);
        }
    }

    private static void getProduction(Document doc) {
        System.out.println("Production Company:");
        Elements production = doc.select("#titleDetails > div:nth-child(19) > a");

        for (Element element : production) {
            System.out.println(element.text());
        }
        System.out.println();
    }

    private static void getGenre(Document doc) {
        System.out.println("Genre:");
        Elements genre = doc.select("#titleStoryLine > div:nth-child(10)");

        for (Element element : genre) {
            System.out.println(element.select("a").text());
        }
        System.out.println();
    }

    private static void getCasts(Document doc) {
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
        System.out.println();
    }
}
