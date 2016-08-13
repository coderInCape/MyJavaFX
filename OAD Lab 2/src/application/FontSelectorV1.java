package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FontSelectorV1 extends Application {

	public void start(Stage stage)
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}

	public void build(Stage stage)
	{
		VBox root = new VBox();
		
		RadioButton sansSerif = new RadioButton("Sans Serif");
		sansSerif.setId("sans-serif");
		RadioButton serif = new RadioButton("Serif");
		serif.setId("serif");
		RadioButton monospaced = new RadioButton("Monospaced");
		monospaced.setId("monospace");
		ToggleGroup fontsGroup = new ToggleGroup();
		sansSerif.setSelected(true);
		sansSerif.setToggleGroup(fontsGroup);
		serif.setToggleGroup(fontsGroup);
		monospaced.setToggleGroup(fontsGroup);
		
		HBox radioButtonDiv = new HBox(sansSerif, serif, monospaced);
		radioButtonDiv.setId("radioButtonDiv");
		
		CheckBox boldCB = new CheckBox("Bold");
		CheckBox italicCB = new CheckBox("Italic");
		
		
		ComboBox<Integer> fontSizeComboB = new ComboBox<Integer>();
		Integer[] sizes = new Integer[9];
		for(int i = 0; i < sizes.length; i++)
			sizes[i] = new Integer(10 + (5 * i));
		fontSizeComboB.getItems().addAll(sizes);
		fontSizeComboB.setValue(20);
		
		Button displayBtn = new Button("Display");
		
		Label label = new Label("Welcome to FX");
		label.setId("label");
		
		
		root.getChildren().addAll(radioButtonDiv, boldCB, italicCB, fontSizeComboB, displayBtn, label);
		
		
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		stage.setScene(scene);
		
		displayBtn.setOnAction(e -> {
			label.setStyle(
						"-fx-font-size: " + fontSizeComboB.getValue() + ";"
						+ "-fx-font-family: " + ((RadioButton)fontsGroup.getSelectedToggle()).getId() + ";"
						+ "-fx-font-style: " + (italicCB.isSelected()? "italic": "normal") + ";"
						+ "-fx-font-weight: " + (boldCB.isSelected()? "bold": "normal") + ";"
					);
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
