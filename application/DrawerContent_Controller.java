package application;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DrawerContent_Controller {
	
    @FXML
    private JFXButton manAcc;
    
    @FXML
   	private Stage stageMA;
   	private Scene sceneMA;
   	private Parent rootMA;
  
   	
    @FXML
    void gotomanAcc(ActionEvent event) throws IOException {

    	FXMLLoader loaderMA = new FXMLLoader(getClass().getResource("ManageAccount.fxml"));
		
		rootMA = loaderMA.load();
		stageMA = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneMA = new Scene(rootMA);
		stageMA.setScene(sceneMA);
		stageMA.show();
    }
    
    @FXML
    private JFXButton about;
    
    @FXML
   	private Stage stageAbt;
   	private Scene sceneAbt;
   	private Parent rootAbt;
   	
    @FXML
    void gottoabt(ActionEvent event) throws IOException {

    	FXMLLoader loaderAbt = new FXMLLoader(getClass().getResource("About.fxml"));
		
		rootAbt = loaderAbt.load();
		stageAbt = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneAbt = new Scene(rootAbt);
		stageAbt.setScene(sceneAbt);
		stageAbt.show();
    }
    
    @FXML
    private JFXButton logout;

    @FXML
	private Stage stageLOut;
	private Scene sceneLOut;
	private Parent rootLOut;
	
    @FXML
    void gonnalogout(ActionEvent event) throws IOException {
    	
    	FXMLLoader loaderLOut = new FXMLLoader(getClass().getResource("Login_SignUp.fxml"));
		
		rootLOut = loaderLOut.load();
		stageLOut = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneLOut = new Scene(rootLOut);
		stageLOut.setScene(sceneLOut);
		stageLOut.show();
    }
}
