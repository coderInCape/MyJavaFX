/*
 * Class Name:    SampleFX
 *
 * Author:        Waleed Mohammad
 * Creation Date: Wednesday, August 03 2016, 11:12 
 * Last Modified: Wednesday, August 03 2016, 12:04
 * 
 * Class Description:
 *
 */

   import javafx.application.Application;
   import javafx.stage.Stage;
   import javafx.scene.Scene;
   import javafx.scene.control.*;
   import javafx.scene.layout.*;
   public class HelloFX extends Application
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
         Label label = new Label("Hello JavaFX!");
         root.getChildren().addAll(label);

         //Set scene and stage
         Scene scene = new Scene(root, 400, 300);
         stage.setScene(scene);

         java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
         stage.setWidth(screenSize.getWidth() / 2);
         stage.setHeight(screenSize.getHeight() / 2);


         root.setStyle("-fx-alignment: center;");
         label.setStyle("-fx-alignment: left; -fx-font-size: 50px; -fx-text-fill: blue");

       }
   }


