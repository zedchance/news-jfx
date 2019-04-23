public class FetchTester
{
   public static void main(String[] args)
   {
      // Create FetchArticle object
      FetchArticle f = new FetchArticle("Apple");
      System.out.println(f.toString());

      // Test article data
      System.out.println("Data for article 0");
      System.out.println("Source: " + f.getSource(0));
      System.out.println("ID: " + f.getId(0));
      System.out.println("Author: " + f.getAuthor(0));
      System.out.println("Title: " + f.getTitle(0));
      System.out.println("Description: " + f.getDescription(0));
      System.out.println("URL: " + f.getUrl(0));
      System.out.println("URL to image: " + f.getUrlToImage(0));
      System.out.println("Published at: " + f.getPublishedAt(0));
      System.out.println("Content: " + f.getContent(0));


   }
}
