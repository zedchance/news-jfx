import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import java.io.IOException;

/**
 * GUI for NewsAPI
 *
 * @author Zed Chance
 */
public class ArticleGUI extends Application
{
   /*
    * Controls
    */
   @FXML
   TextField tfSearch;

   @FXML
   Button btnFetch;

   @FXML
   Accordion accordion;

   @FXML
   TitledPane tp1, tp2, tp3, tp4, tp5;

   @FXML
   Label lblTitle1, lblTitle2, lblTitle3, lblTitle4, lblTitle5,
         lblAuthor1, lblAuthor2, lblAuthor3, lblAuthor4, lblAuthor5,
         lblContent1, lblContent2, lblContent3, lblContent4, lblContent5,
         lblPub1, lblPub2, lblPub3, lblPub4, lblPub5;

   @FXML
   Hyperlink hl1, hl2, hl3, hl4, hl5;

   @FXML
   ImageView iv1, iv2, iv3, iv4, iv5;

   /*
    * Fields
    */
   String link1, link2, link3, link4, link5;

   /**
    * Start window and canvas
    * @param window
    * @throws IOException
    */
   public void start(Stage window) throws IOException
   {
      Parent root = FXMLLoader.load(getClass().getResource("article-gui.fxml"));
      window.setTitle("Article-GUI");
      window.setScene(new Scene(root));
      window.show();
   }

   /**
    * Handles the fetch button
    */
   public void handleFetch(ActionEvent ae)
   {
      accordion.setVisible(false);

      // Fetch article object
      FetchArticle f = new FetchArticle(tfSearch.getText());

      // Set articles
      tp1.setText(f.getTitle(0));
      lblTitle1.setText(f.getTitle(0));
      lblAuthor1.setText(f.getAuthor(0));
      lblPub1.setText(f.getPublishedAt(0));
      lblContent1.setText(f.getDescription(0));
      Image i1 = new Image(f.getUrlToImage(0));
      iv1.setImage(i1);
      hl1.setText(f.getSource(0));
      link1 = f.getUrl(0);

      tp2.setText(f.getTitle(1));
      lblTitle2.setText(f.getTitle(1));
      lblAuthor2.setText(f.getAuthor(1));
      lblPub2.setText(f.getPublishedAt(1));
      lblContent2.setText(f.getDescription(1));
      Image i2 = new Image(f.getUrlToImage(1));
      iv2.setImage(i2);
      hl2.setText(f.getSource(1));
      link2 = f.getUrl(1);

      tp3.setText(f.getTitle(2));
      lblTitle3.setText(f.getTitle(2));
      lblAuthor3.setText(f.getAuthor(2));
      lblPub3.setText(f.getPublishedAt(2));
      lblContent3.setText(f.getDescription(2));
      Image i3 = new Image(f.getUrlToImage(2));
      iv3.setImage(i3);
      hl3.setText(f.getSource(2));
      link3 = f.getUrl(2);

      tp4.setText(f.getTitle(3));
      lblTitle4.setText(f.getTitle(3));
      lblAuthor4.setText(f.getAuthor(3));
      lblPub4.setText(f.getPublishedAt(3));
      lblContent4.setText(f.getDescription(3));
      Image i4 = new Image(f.getUrlToImage(3));
      iv4.setImage(i4);
      hl4.setText(f.getSource(3));
      link4 = f.getUrl(3);

      tp5.setText(f.getTitle(4));
      lblTitle5.setText(f.getTitle(4));
      lblAuthor5.setText(f.getAuthor(4));
      lblPub5.setText(f.getPublishedAt(4));
      lblContent5.setText(f.getDescription(4));
      Image i5 = new Image(f.getUrlToImage(4));
      iv5.setImage(i5);
      hl5.setText(f.getSource(4));
      link5 = f.getUrl(4);

      accordion.setVisible(true);
      tp1.setExpanded(true);
   }

   /**
    * Handles link 1
    */
   public void handleLink1(ActionEvent ae)
   {
      getHostServices().showDocument(link1);
   }

   /**
    * Handles link 2
    */
   public void handleLink2(ActionEvent ae)
   {
      getHostServices().showDocument(link2);
   }

   /**
    * Handles link 3
    */
   public void handleLink3(ActionEvent ae)
   {
      getHostServices().showDocument(link3);
   }

   /**
    * Handles link 4
    */
   public void handleLink4(ActionEvent ae)
   {
      getHostServices().showDocument(link4);
   }

   /**
    * Handles link 5
    */
   public void handleLink5(ActionEvent ae)
   {
      getHostServices().showDocument(link5);
   }
}
