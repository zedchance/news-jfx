import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Fetches article and related data from NewsAPI
 *
 * @author Zed Chance
 */
public class FetchArticle
{
   /**
    * Query for search
    */
   private String query;

   /**
    * JsonElement which contains all results from query
    */
   private JsonElement results;

   /**
    * Constructs a FetchArticle object containing a query
    * @param q query to search
    */
   public FetchArticle(String q)
   {
      try
      {
         query = URLEncoder.encode(q, "UTF-8");
      }
      catch (UnsupportedEncodingException e)
      {
         e.printStackTrace();
      }

      // Build url
      final String API_KEY = "b0de17f6ecae47eca5f8ced26a4026dc";
      String urlString = "https://newsapi.org/v2/everything?q=" + query + "&apiKey=" + API_KEY;

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

   public String getStatus()
   {
      return results.getAsJsonObject().get("status").getAsString();
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
    * Gets id of article from query at current index
    * @param index of article
    * @return id
    */
   public String getId(int index)
   {
      return results.getAsJsonObject().get("articles").getAsJsonArray().get(index)
                    .getAsJsonObject().get("source").getAsJsonObject().get("id").getAsString();
   }

   /**
    * Gets source of article from query at current index
    * @param index of article
    * @return source
    */
   public String getSource(int index)
   {
      return results.getAsJsonObject().get("articles").getAsJsonArray().get(index)
                    .getAsJsonObject().get("source").getAsJsonObject().get("name").getAsString();
   }

   /**
    * Gets author of article from query at current index
    * @param index of article
    * @return author
    */
   public String getAuthor(int index)
   {
      return results.getAsJsonObject().get("articles").getAsJsonArray().get(index)
                    .getAsJsonObject().get("author").getAsString();
   }

   /**
    * Gets title of article from query at current index
    * @param index of article
    * @return title
    */
   public String getTitle(int index)
   {
      return results.getAsJsonObject().get("articles").getAsJsonArray().get(index)
                    .getAsJsonObject().get("title").getAsString();
   }

   /**
    * Gets description of article from query at current index
    * @param index of article
    * @return description
    */
   public String getDescription(int index)
   {
      return results.getAsJsonObject().get("articles").getAsJsonArray().get(index)
                    .getAsJsonObject().get("description").getAsString();
   }

   /**
    * Gets url of article from query at current index
    * @param index of article
    * @return url
    */
   public String getUrl(int index)
   {
      return results.getAsJsonObject().get("articles").getAsJsonArray().get(index)
                    .getAsJsonObject().get("url").getAsString();
   }

   /**
    * Gets urlToImage of article from query at current index
    * @param index of article
    * @return urlToImage
    */
   public String getUrlToImage(int index)
   {
      return results.getAsJsonObject().get("articles").getAsJsonArray().get(index)
                    .getAsJsonObject().get("urlToImage").getAsString();
   }

   /**
    * Gets publishedAt of article from query at current index
    * @param index of article
    * @return publishedAt
    */
   public String getPublishedAt(int index)
   {
      return results.getAsJsonObject().get("articles").getAsJsonArray().get(index)
                    .getAsJsonObject().get("publishedAt").getAsString();
   }

   /**
    * Gets content of article from query at current index
    * @param index of article
    * @return content
    */
   public String getContent(int index)
   {
      return results.getAsJsonObject().get("articles").getAsJsonArray().get(index)
                    .getAsJsonObject().get("content").getAsString();
   }

   public String toString()
   {
      return "Status: " + getStatus() + ", " + "Query: " + query +
             " (" + getTotalResults() + " total results)";
   }
}
