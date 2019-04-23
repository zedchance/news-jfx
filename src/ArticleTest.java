public class ArticleTest
{
   public static void main(String[] args)
   {
      Article a = new Article("Google", 5);
      System.out.println(a.title);
      System.out.println(a.author);
      System.out.println(a.publishedAt);
      System.out.println(a.description);
      System.out.println(a.url);
   }
}
