package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class ViewController {
	
	@FXML
	private Button btn;
	
	@FXML
	public void onBtnAction() {
		Alerts .showAlert("Titulo", null, "Hello World!", AlertType.ERROR);
	}
}
