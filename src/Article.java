/**
 * Article class that contains data fetched from NewsAPI
 *
 * @author Zed Chance
 */
public class Article
{
   String source;
   String author;
   String title;
   String description;
   String url;
   String urlToImage;
   String publishedAt;
   String content;

   /**
    * Constructs default Article to blank fields
    */
   public Article()
   {
      source = "";
      author = "";
      title = "";
      description = "";
      url = "";
      urlToImage = "";
      publishedAt = "";
      content = "";
   }

   /**
    * Constructs Article object from query and index of query
    * @param query
    * @param index
    */
   public Article(String query, int index)
   {
      FetchArticle f = new FetchArticle(query);

      source = f.getSource(index);
      author = f.getAuthor(index);
      title = f.getTitle(index);
      description = f.getDescription(index);
      url = f.getUrl(index);
      urlToImage = f.getUrlToImage(index);
      publishedAt = f.getPublishedAt(index);
      content = f.getContent(index);
   }
}
