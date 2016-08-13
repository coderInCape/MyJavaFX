package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FontSelectorV2 extends Application implements ChangeListener{
	private VBox root;
	private RadioButton sansSerif;
	private RadioButton serif;
	private RadioButton monospaced;
	private ToggleGroup fontsGroup;
	private HBox radioButtonDiv;
	private CheckBox boldCB;
	private CheckBox italicCB;
	private Label label;
	private ComboBox<Integer> fontSizeComboB;

	public void start(Stage stage)
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}

	public void build(Stage stage)
	{
		root = new VBox();
		
		sansSerif = new RadioButton("Sans Serif");
		sansSerif.setId("sans-serif");
		serif = new RadioButton("Serif");
		serif.setId("serif");
		monospaced = new RadioButton("Monospaced");
		monospaced.setId("monospace");
		fontsGroup = new ToggleGroup();
		sansSerif.setSelected(true);
		sansSerif.setToggleGroup(fontsGroup);
		serif.setToggleGroup(fontsGroup);
		monospaced.setToggleGroup(fontsGroup);
		
		radioButtonDiv = new HBox(sansSerif, serif, monospaced);
		radioButtonDiv.setId("radioButtonDiv");
		
		boldCB = new CheckBox("Bold");
		italicCB = new CheckBox("Italic");
		
		
		fontSizeComboB = new ComboBox<Integer>();
		Integer[] sizes = new Integer[9];
		for(int i = 0; i < sizes.length; i++)
			sizes[i] = new Integer(10 + (5 * i));
		fontSizeComboB.getItems().addAll(sizes);
		fontSizeComboB.setValue(20);
		
		
		label = new Label("Welcome to FX");
		label.setId("label");
		
		
		root.getChildren().addAll(radioButtonDiv, boldCB, italicCB, fontSizeComboB, label);
		
		
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		stage.setScene(scene);
		
		
		sansSerif.selectedProperty().addListener(this);
		serif.selectedProperty().addListener(this);
		monospaced.selectedProperty().addListener(this);
		boldCB.selectedProperty().addListener(this);
		italicCB.selectedProperty().addListener(this);
		fontSizeComboB.valueProperty().addListener(this);
		
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void changed(ObservableValue observable, Object oldValue, Object newValue) {
		label.setStyle(
				"-fx-font-size: " + fontSizeComboB.getValue() + ";"
				+ "-fx-font-family: " + ((RadioButton)fontsGroup.getSelectedToggle()).getId() + ";"
				+ "-fx-font-style: " + (italicCB.isSelected()? "italic": "normal") + ";"
				+ "-fx-font-weight: " + (boldCB.isSelected()? "bold": "normal") + ";"
			);
	}
}
