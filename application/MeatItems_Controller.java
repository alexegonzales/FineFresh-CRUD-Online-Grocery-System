package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

public class MeatItems_Controller implements Initializable{

    @FXML
    private Button backBTNlog;

	@FXML
	private Stage stageBLog;
	private Scene sceneBLog;
	private Parent rootBLog;
	
    @FXML
    void backtolog(ActionEvent event) throws IOException {

    	FXMLLoader loaderBLog = new FXMLLoader(getClass().getResource("MeatPane.fxml"));
		
		rootBLog = loaderBLog.load();
		stageBLog = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneBLog = new Scene(rootBLog);
		stageBLog.setScene(sceneBLog);
		stageBLog.show();
	}

	@FXML
    private Spinner<Integer> quantitySPN;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		SpinnerValueFactory<Integer> itemQuantity = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99);
		itemQuantity.setValue(0);
		quantitySPN.setValueFactory(itemQuantity);	
	} 
}
