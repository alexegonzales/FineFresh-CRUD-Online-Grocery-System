package application;


import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class LoginSignUp_Controller {


    @FXML
    Button LoginBTN;
    
	@FXML
	private Stage stageLog;
	private Scene sceneLog;
	private Parent rootLog;
    
    @FXML
    public void gotologin(ActionEvent event) throws IOException {
    	
    	FXMLLoader loaderLog = new FXMLLoader(getClass().getResource("Login.fxml"));
			
		rootLog = loaderLog.load();
		stageLog = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneLog = new Scene(rootLog);
		stageLog.setScene(sceneLog);
		stageLog.show();
	} 
    
    @FXML
    Button SignUpBTN;
    
	@FXML
	private Stage stageSin;
	private Scene sceneSin;
	private Parent rootSin;
	
    @FXML
    public void gotosignup(ActionEvent event) throws IOException {

    	FXMLLoader loaderSin = new FXMLLoader(getClass().getResource("Registration.fxml"));
		
		rootSin = loaderSin.load();
		stageSin = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneSin = new Scene(rootSin);
		stageSin.setScene(sceneSin);
		stageSin.show();
    }
}

