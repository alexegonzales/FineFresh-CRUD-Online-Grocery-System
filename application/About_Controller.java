package application;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class About_Controller{

    @FXML
    private JFXButton homeBTN;
    
    @FXML
   	private Stage stageHm;
   	private Scene sceneHm;
   	private Parent rootHm;
   	
    @FXML
    void gotoHome(ActionEvent event) throws IOException {

    	FXMLLoader loaderHm = new FXMLLoader(getClass().getResource("Home_Screen.fxml"));
		
		rootHm = loaderHm.load();
		stageHm = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneHm = new Scene(rootHm,335,600);
		stageHm.setScene(sceneHm);
		stageHm.show();
    }
    
    @FXML
    private JFXButton basBTN;
    
    @FXML
   	private Stage stageBsk;
   	private Scene sceneBsk;
   	private Parent rootBsk;
   	
    @FXML
    void gotoBas(ActionEvent event) throws IOException {
    	
    	FXMLLoader loaderBsk = new FXMLLoader(getClass().getResource("Basket.fxml"));
		
		rootBsk = loaderBsk.load();
		stageBsk = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneBsk = new Scene(rootBsk);
		stageBsk.setScene(sceneBsk);
		stageBsk.show();
    }
    
    @FXML
    private JFXButton notBTN;
    
    @FXML
   	private Stage stageNot;
   	private Scene sceneNot;
   	private Parent rootNot;
   	
    @FXML
    void gotoNot(ActionEvent event) throws IOException {
    	
    	FXMLLoader loaderNot = new FXMLLoader(getClass().getResource("Notifications.fxml"));
		
		rootNot = loaderNot.load();
		stageNot = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneNot = new Scene(rootNot);
		stageNot.setScene(sceneNot);
		stageNot.show();
    }
    
    @FXML
    private Button catBTN;
    
    @FXML
   	private Stage stageCat;
   	private Scene sceneCat;
   	private Parent rootCat;
   	
    @FXML
    void seeCat(ActionEvent event) throws IOException {

    	FXMLLoader loaderCat = new FXMLLoader(getClass().getResource("Categories.fxml"));
		
		rootCat = loaderCat.load();
		stageCat = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneCat = new Scene(rootCat);
		stageCat.setScene(sceneCat);
		stageCat.show();
    }
}
