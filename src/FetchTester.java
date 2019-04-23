public class FetchTester
{
   public static void main(String[] args)
   {
      // Create FetchArticle object
      FetchArticle f = new FetchArticle("Apple");
      System.out.println(f.toString());

      // Test article data
      int articleNumber = 5;
      System.out.println("Data for article " + articleNumber);
      System.out.println("Source: " + f.getSource(articleNumber));
      System.out.println("ID: " + f.getId(articleNumber));
      System.out.println("Author: " + f.getAuthor(articleNumber));
      System.out.println("Title: " + f.getTitle(articleNumber));
      System.out.println("Description: " + f.getDescription(articleNumber));
      System.out.println("URL: " + f.getUrl(articleNumber));
      System.out.println("URL to image: " + f.getUrlToImage(articleNumber));
      System.out.println("Published at: " + f.getPublishedAt(articleNumber));
      System.out.println("Content: " + f.getContent(articleNumber));
   }
}
