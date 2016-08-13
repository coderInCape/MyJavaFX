package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculatorV3 extends Application implements EventHandler<ActionEvent>{

	private String firstInput;
	private boolean firstInputFlag;
	private String secondInput;
	private String operation;

	private Button btn0 ;
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private Button btn7;
	private Button btn8;
	private Button btn9;
	private Button add;
	private Button subtract;
	private Button multiply;
	private Button divide;
	private Button equal;
	private Button clear;
	private Label label; 
	private Region spacer;
	private TextField console;
	private TextField numberField;


	public void start(Stage stage)
	{
		firstInput = "";
		secondInput = "";
		firstInputFlag = false;
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();

	}
	public void build(Stage stage)
	{
		// Define controls and layout
		VBox root = new VBox();
		
		HBox numbersBox = new HBox();
		numbersBox.setId("numbersBox");
		HBox operationsBox = new HBox();
		operationsBox.setId("operationsBox");
		
		// To add elements:
		label = new Label("Calculator");
		
		numberField = new TextField();
		numberField.setEditable(false);
		numberField.setId("numberField");
		
		btn0 = new Button("0");
		btn1 = new Button("1");
		btn2 = new Button("2");
		btn3 = new Button("3");
		btn4 = new Button("4");
		btn5 = new Button("5");
		btn6 = new Button("6");
		btn7 = new Button("7");
		btn8 = new Button("8");
		btn9 = new Button("9");
		
		numbersBox.getChildren().addAll(
				btn0,
				btn1, 
				btn2,
				btn3,
				btn4,
				btn5,
				btn6,
				btn7,
				btn8,
				btn9);
		
		add = new Button("+");
		subtract = new Button("-");
		multiply = new Button("*");
		divide = new Button("/");
		equal = new Button("=");
		clear = new Button("C");
		
		operationsBox.getChildren().addAll(
				add,
				subtract,
				multiply,
				divide,
				equal,
				clear);
		
		spacer = new Region();
		root.setVgrow(spacer, Priority.ALWAYS);

		console = new TextField();
		console.setEditable(false);
		//root.getChildren().addAll(element1, element2, );
		root.getChildren().addAll(
				label,
				numberField,
				numbersBox,
				operationsBox,
				spacer, 
				console
				);


		Scene scene = new Scene(root, 400, 500);
		scene.getStylesheets().add(getClass().getResource("application1.css").toExternalForm());
		stage.setScene(scene);


		//interactions
		btn0.setOnAction(this);
		btn1.setOnAction(this);
		btn2.setOnAction(this);
		btn3.setOnAction(this);
		btn4.setOnAction(this);
		btn5.setOnAction(this);
		btn6.setOnAction(this);
		btn7.setOnAction(this);
		btn8.setOnAction(this);
		btn9.setOnAction(this);
		add.setOnAction(this);
		subtract.setOnAction(this);
		multiply.setOnAction(this);
		divide.setOnAction(this);
		equal.setOnAction(this);
		clear.setOnAction(this);

	}
	
	
	private String calculate(String firstInput, String secondInput, String operation) {
		String result;
		switch(operation){
		case "+":
			result = String.valueOf(Float.parseFloat(firstInput) + Float.parseFloat(secondInput));
			break;
		case "-":
			result = String.valueOf(Float.parseFloat(firstInput) - Float.parseFloat(secondInput));
			break;
		case "*":
			result = String.valueOf(Float.parseFloat(firstInput) * Float.parseFloat(secondInput));
			break;
		case "/":
			result = String.valueOf(Float.parseFloat(firstInput) / Float.parseFloat(secondInput));
			break;
		default:
			result = "Error";
		}
		return result;
	}
	
	
	
	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == btn0				//if a numbers button pressed
				|| event.getSource() == btn1
				|| event.getSource() == btn2
				|| event.getSource() == btn3
				|| event.getSource() == btn4
				|| event.getSource() == btn5
				|| event.getSource() == btn6
				|| event.getSource() == btn7
				|| event.getSource() == btn8
				|| event.getSource() == btn9){
			if(firstInputFlag == false){		//first number
				firstInput += ((Button) event.getSource()).getText();
				numberField.appendText(((Button) event.getSource()).getText());
				console.appendText(((Button) event.getSource()).getText());
			}
			else if(operation != null){			//second number
				secondInput += ((Button) event.getSource()).getText();
				numberField.appendText(((Button) event.getSource()).getText());
				console.appendText(((Button) event.getSource()).getText());
			}
		}else if(event.getSource() == add			//if operation button pressed
				|| event.getSource() == subtract
				|| event.getSource() == multiply
				|| event.getSource() == divide){
			if(!firstInput.equals("") && operation == null){
				firstInputFlag = true;
				numberField.setText("");
				operation = ((Button) event.getSource()).getText();
				console.appendText(((Button) event.getSource()).getText());
			}else{							
				console.appendText(((Button) event.getSource()).getText() + "Error");
			}
		}else if(event.getSource() == equal){    //if equal pressed
			if(firstInputFlag == true && !secondInput.equals(""))
			{
				firstInput = calculate(firstInput, secondInput, operation);
				operation = null;
				secondInput = "";
				numberField.setText("");
				console.appendText(((Button) event.getSource()).getText() + firstInput);
			}else{		//equal errors
				console.appendText(((Button) event.getSource()).getText() + "Error");
				operation = "";
			}
		}else if(event.getSource() == clear){
			numberField.setText("");
			firstInput = "";
			secondInput = "";
			console.setText("");
			firstInputFlag = false;
			operation = null;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
