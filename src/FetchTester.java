public class FetchTester
{
   public static void main(String[] args)
   {
      // Create FetchArticle object
      FetchArticle f = new FetchArticle("Apple");

      // Test toString() (also tests getTotalResults())
      System.out.println(f.toString());

      // Test getTitle()
      for (int i = 0; i < 10; i++)
      {
         System.out.println("" + i + " " + f.getTitle(i));
      }
   }
}
