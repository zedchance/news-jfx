import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Fetches article and related data from NewsAPI
 *
 * @author Zed Chance
 */
public class FetchArticle
{
   /**
    * API key for NewsAPI.org
    */
   private final String API_KEY = "b0de17f6ecae47eca5f8ced26a4026dc";

   /**
    * JsonElement which contains all results from query
    */
   JsonElement results;

   /**
    * Constructs a FetchArticle object containing a query
    * @param query
    */
   public FetchArticle(String query)
   {
      // Build url
      String urlString = "https://newsapi.org/v2/everything?q=" + query + "&API_KEY=" + API_KEY;

      // Fetch articles
      try
      {
         URL url = new URL(urlString);

         // Open stream readers for incoming data
         InputStream is = url.openStream();
         InputStreamReader isr = new InputStreamReader(is);
         BufferedReader br = new BufferedReader(isr);

         // Parse JSON
         JsonParser parser = new JsonParser();
         results = parser.parse(br);
      }
      catch (MalformedURLException e)
      {
         e.printStackTrace();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }

   }

   /**
    * Gets title of article from current index
    * @param index
    * @return title
    */
   public String getTitle(int index)
   {
      return results.getAsJsonObject().get("articles").getAsJsonArray().get(index)
                    .getAsJsonObject().get("title").getAsString();
   }
}
