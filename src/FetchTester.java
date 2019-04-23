public class FetchTester
{
   public static void main(String[] args)
   {
      FetchArticle f = new FetchArticle("Apple");
      for (int i = 0; i < 10; i++)
      {
         System.out.println("" + i + " " + f.getTitle(i));
      }
   }
}
