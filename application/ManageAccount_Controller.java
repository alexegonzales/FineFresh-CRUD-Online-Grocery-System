package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ManageAccount_Controller{

	@FXML
    private Button cUser;
	
	@FXML
	private Stage stageUs;
	private Scene sceneUs;
	private Parent rootUs;
	
	@FXML
    void editUser(ActionEvent event) throws IOException {

		FXMLLoader loaderUs = new FXMLLoader(getClass().getResource("EditUser.fxml"));
		
		rootUs = loaderUs.load();
		stageUs = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneUs = new Scene(rootUs);
		stageUs.setScene(sceneUs);
		stageUs.show();
		
    }
	
	@FXML
    private Button cEmail;
    
	@FXML
	private Stage stageEm;
	private Scene sceneEm;
	private Parent rootEm;
	
    @FXML
    void changeEmail(ActionEvent event) throws IOException {


    	FXMLLoader loaderEm = new FXMLLoader(getClass().getResource("EditEmail.fxml"));
		
		rootEm = loaderEm.load();
		stageEm = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneEm = new Scene(rootEm);
		stageEm.setScene(sceneEm);
		stageEm.show();
    }
    
    @FXML
    private Button cPass;
    
    @FXML
	private Stage stagePW;
	private Scene scenePW;
	private Parent rootPW;
	
    @FXML
    void changePass(ActionEvent event) throws IOException {

    	FXMLLoader loaderPW = new FXMLLoader(getClass().getResource("EditPassword.fxml"));
		
		rootPW = loaderPW.load();
		stagePW = (Stage)((Node)event.getSource()).getScene().getWindow();
		scenePW = new Scene(rootPW);
		stagePW.setScene(scenePW);
		stagePW.show();
    }
    
    @FXML
    private Button cPhone;
    
    @FXML
	private Stage stagePh;
	private Scene scenePh;
	private Parent rootPh;
	
    @FXML
    void changePhone(ActionEvent event) throws IOException {

    	FXMLLoader loaderPh = new FXMLLoader(getClass().getResource("EditPhone.fxml"));
		
		rootPh = loaderPh.load();
		stagePh = (Stage)((Node)event.getSource()).getScene().getWindow();
		scenePh = new Scene(rootPh);
		stagePh.setScene(scenePh);
		stagePh.show();
    }
    
    @FXML
    private Button cAdd;
    
	@FXML
	private Stage stageAdd;
	private Scene sceneAdd;
	private Parent rootAdd;
	
    @FXML
    void changeAdd(ActionEvent event) throws IOException {

    	FXMLLoader loaderAdd = new FXMLLoader(getClass().getResource("EditAddress.fxml"));
		
		rootAdd = loaderAdd.load();
		stageAdd = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneAdd = new Scene(rootAdd);
		stageAdd.setScene(sceneAdd);
		stageAdd.show();
    }
    
    @FXML
    private Button backBTN;

	@FXML
	private Stage stageB;
	private Scene sceneB;
	private Parent rootB;
	
    @FXML
    void backtoHome(ActionEvent event) throws IOException {
    	
    	FXMLLoader loaderB = new FXMLLoader(getClass().getResource("Home_Screen.fxml"));
		
		rootB = loaderB.load();
		stageB = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneB = new Scene(rootB);
		stageB.setScene(sceneB);
		stageB.show();
    }
}
