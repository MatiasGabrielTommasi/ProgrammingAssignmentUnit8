package application.tools;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Util {
	public static ButtonType displayMessage(String title, String message, Alert.AlertType type) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(message);
        return alert.showAndWait().orElse(ButtonType.CANCEL);
	}
}