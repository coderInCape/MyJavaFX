/*
 * Class Name:    SampleFX
 *
 * Author:        Your Name
 * Creation Date: Wednesday, August 03 2016, 11:12 
 * Last Modified: Wednesday, August 03 2016, 12:47
 * 
 * Class Description:
 *
 */

   import javafx.application.Application;
   import javafx.stage.Stage;
   import javafx.scene.Scene;
   import javafx.scene.control.*;
   import javafx.scene.layout.*;
   import java.util.Random;
   public class ClickMe extends Application
   {
      public void start(Stage stage)
      {
         build(stage);
         stage.setTitle(getClass().getName());
         stage.show();
      }
      public void build(Stage stage)
      {
         // Define controls and layout
         VBox root = new VBox();
         // To add elements:
         //root.getChildren().addAll(element1, element2, );
         Button btn = new Button("Click Me to Change Color");
         root.getChildren().addAll(btn);

         //Set scene and stage
         Scene scene = new Scene(root, 400, 300);
         stage.setScene(scene);

         java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
         stage.setWidth(screenSize.getWidth() / 2);
         stage.setHeight(screenSize.getHeight() / 2);


         root.setStyle("-fx-alignment: center;");
         btn.setStyle("-fx-alignment: left; -fx-font-size: 50px; -fx-text-fill: blue");

         btn.setOnAction(e ->
            {
               Random rand = new Random();
               int r = rand.nextInt(255);
               int g = rand.nextInt(255);
               int b = rand.nextInt(255);
               btn.setStyle("-fx-text-fill: rgb(" + r + "," + g + "," + b + "); -fx-font-size: 50;");
            }
         );


            btn.setStyle("-fx-font-size: 50");

       }
   }


