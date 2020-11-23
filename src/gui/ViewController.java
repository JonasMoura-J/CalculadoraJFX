package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Operacao;

public class ViewController implements Initializable {
	@FXML
	private TextField txtNumero1;
	
	@FXML
	private TextField txtNumero2;
	
	@FXML
	private ComboBox<Operacao> cbOperacao;
	
	private ObservableList<Operacao> obsList;
	
	@FXML
	private Label lblResult;
	
	@FXML
	private Button btnCalc;
	
	@FXML
	public Operacao onCbOperacaoAction() {
		Operacao op = cbOperacao.getSelectionModel().getSelectedItem();
		return op;
	}
	
	@FXML
	public void onBtnCalcAction() {
		try {
			Locale.setDefault(Locale.US);
			double num1 = Double.parseDouble(txtNumero1.getText());
			double num2 = Double.parseDouble(txtNumero2.getText());
			double result = 0;
			
			switch(onCbOperacaoAction().toString()) {
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
				case "^":
					result = Math.pow(num1, num2);
					break;
				case "sqrt":
					result = Math.pow (num1, 1.0 / num2);
					break;
			}
			lblResult.setText(String.format("%.2f", result));
		}catch(NumberFormatException e) {
			Alerts.showAlert("Error", null, e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		List<Operacao> list = new ArrayList<>();
		list.add(new Operacao("+"));
		list.add(new Operacao("-"));
		list.add(new Operacao("*"));
		list.add(new Operacao("/"));
		list.add(new Operacao("^"));
		list.add(new Operacao("sqrt"));
		
		obsList = FXCollections.observableArrayList(list);
		cbOperacao.setItems(obsList);
		
		Constraints.setTextFieldDouble(txtNumero1);
		Constraints.setTextFieldDouble(txtNumero2);
	}
}
