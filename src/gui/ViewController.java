package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController implements Initializable {
	@FXML
	private TextField txtNumero1;
	
	@FXML
	private TextField txtNumero2;
	
	@FXML
	private TextField txtOperacao;
	@FXML
	private Label lblResult;
	
	@FXML
	private Button btnCalc;
	
	@FXML
	public void onBtnCalcAction() {
		try {
			Locale.setDefault(Locale.US);
			double num1 = Double.parseDouble(txtNumero1.getText());
			double num2 = Double.parseDouble(txtNumero2.getText());
			double result = 0;
			
			switch(txtOperacao.getText()) {
				case "+":
					result = num1 + num2;
					break;
				case "-":
					result = num1 - num2;
					break;
				case "*":
					result = num1 * num2;
					break;
				case "/":
					result = num1 / num2;
					break;
			}
			lblResult.setText(String.format("%.2f", result));
		}catch(NumberFormatException e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Constraints.setTextFieldDouble(txtNumero1);
		Constraints.setTextFieldDouble(txtNumero2);
	}
}
