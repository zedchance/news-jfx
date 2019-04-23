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
    * Query for search
    */
   String query;

   /**
    * JsonElement which contains all results from query
    */
   JsonElement results;

   /**
    * Constructs a FetchArticle object containing a query
    * @param q query to search
    */
   public FetchArticle(String q)
   {
      query = q;

      // Build url
      String urlString = "https://newsapi.org/v2/everything?q=" + q + "&apiKey=" + API_KEY;

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
    * Returns total results from query
    * @return total results as int
    */
   public int getTotalResults()
   {
      return results.getAsJsonObject().get("totalResults").getAsInt();
   }

   /**
    * Gets title of article from query at current index
    * @param index
    * @return title
    */
   public String getTitle(int index)
   {
      return results.getAsJsonObject().get("articles").getAsJsonArray().get(index)
                    .getAsJsonObject().get("title").getAsString();
   }

   public String toString()
   {
      return "Query: " + query + " (" + getTotalResults() + " total results)";
   }
}
