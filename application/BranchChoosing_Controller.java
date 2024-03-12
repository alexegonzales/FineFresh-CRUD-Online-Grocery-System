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

public class BranchChoosing_Controller {

    @FXML
    private Button cabiaoBTN;

    @FXML
	private Stage stageCaba;
	private Scene sceneCaba;
	private Parent rootCaba;
	
    @FXML
    void gotohome1(ActionEvent event) throws IOException {
    	
    	FXMLLoader loaderCaba = new FXMLLoader(getClass().getResource("Home_Screen.fxml"));
		
		rootCaba = loaderCaba.load();
		stageCaba = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneCaba = new Scene(rootCaba,335,600);
		stageCaba.setScene(sceneCaba);
		stageCaba.show();
    }

    @FXML
    private Button gapanBTN;
    
    @FXML
	private Stage stageGap;
	private Scene sceneGap;
	private Parent rootGap;
	
    @FXML
    void gotohome2(ActionEvent event) throws IOException {
    	
    	FXMLLoader loaderGap = new FXMLLoader(getClass().getResource("Home_Screen.fxml"));
		
		rootGap = loaderGap.load();
		stageGap = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneGap = new Scene(rootGap,335,600);
		stageGap.setScene(sceneGap);
		stageGap.show();
    }

    @FXML
    private Button cabanatuanBTN;
    
    @FXML
   	private Stage stageCab;
   	private Scene sceneCab;
   	private Parent rootCab;
   	
    @FXML
    void gotohome3(ActionEvent event) throws IOException {

    	FXMLLoader loaderCab = new FXMLLoader(getClass().getResource("Home_Screen.fxml"));
		
		rootCab = loaderCab.load();
		stageCab = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneCab = new Scene(rootCab,335,600);
		stageCab.setScene(sceneCab);
		stageCab.show();
    }
}
