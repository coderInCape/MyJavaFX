



   import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.application.Application;
   import javafx.stage.Stage;
   import javafx.scene.Scene;
   import javafx.scene.control.*;
   import javafx.scene.layout.*;
   public class WordApp extends Application
   {
	   PrintWriter out;
	   
      public void start(Stage stage) throws IOException
      {
    	 out = new PrintWriter(new FileWriter("Text.txt",true), true);
   
         build(stage);
         stage.setTitle(getClass().getName());
         stage.show();
         stage.setOnCloseRequest(e ->
	         {
	        	 out.close();
	         }
         );
      }
      public void build(Stage stage) throws IOException
      {
         // Define controls and layout
         VBox root = new VBox();
         // To add elements:
         //root.getChildren().addAll(element1, element2, );
         TextArea textArea = new TextArea();
         
        
        	 textArea.setPromptText("Enter Text Here");
 
     
         textArea.setFocusTraversable(false);
         
         Button btn = new Button("Save");
         btn.setTooltip(new Tooltip("Append Text to the file"));
         btn.setOnAction(e -> 
	         {
	        	 if(textArea.getText() == null)
	        		 out.print("");
	        	 else
	        		 out.print(textArea.getText());
	         }
         );
         
         root.getChildren().addAll(textArea, btn);

         //Set scene and stage
         Scene scene = new Scene(root, 400, 300);
         scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
         stage.setScene(scene);

         java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
         stage.setWidth(screenSize.getWidth() / 2);
         stage.setHeight(screenSize.getHeight() / 2);

       }
   }

