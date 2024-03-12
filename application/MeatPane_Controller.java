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

public class MeatPane_Controller{
   
    @FXML
    private Button prodBTN;
    
    @FXML
   	private Stage stagePP;
   	private Scene scenePP;
   	private Parent rootPP;
   	
    @FXML
    void gotoProd(ActionEvent event) throws IOException {

    	FXMLLoader loaderPP = new FXMLLoader(getClass().getResource("ProdPane.fxml"));
		
		rootPP = loaderPP.load();
		stagePP = (Stage)((Node)event.getSource()).getScene().getWindow();
		scenePP = new Scene(rootPP,335,600);
		stagePP.setScene(scenePP);
		stagePP.show();
    }
    
    @FXML
    private Button seaBTN;
    
    @FXML
   	private Stage stageSP;
   	private Scene sceneSP;
   	private Parent rootSP;
   	
    @FXML
    void gotoSea(ActionEvent event) throws IOException {

    	FXMLLoader loaderSP = new FXMLLoader(getClass().getResource("SeaPane.fxml"));
		
		rootSP = loaderSP.load();
		stageSP = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneSP = new Scene(rootSP,335,600);
		stageSP.setScene(sceneSP);
		stageSP.show();
    }
    
    @FXML
    private Button breast;
    
    @FXML
	private Stage stageBr;
	private Scene sceneBr;
	private Parent rootBr;
    
    @FXML
    void gotoBreast(ActionEvent event) throws IOException {

    	FXMLLoader loaderBr = new FXMLLoader(getClass().getResource("breast.fxml"));
		
		rootBr = loaderBr.load();
		stageBr = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneBr = new Scene(rootBr,335,600);
		stageBr.setScene(sceneBr);
		stageBr.show();
    }
    

	    @FXML
    private Button flank;
    
    @FXML
	private Stage stageFl;
	private Scene sceneFl;
	private Parent rootFl;
	
    @FXML
    void gotoFlank(ActionEvent event) throws IOException {

    	FXMLLoader loaderPC = new FXMLLoader(getClass().getResource("flank.fxml"));
		
		rootPC = loaderPC.load();
		stagePC = (Stage)((Node)event.getSource()).getScene().getWindow();
		scenePC = new Scene(rootPC,335,600);
		stagePC.setScene(scenePC);
		stagePC.show();
    }
    
    @FXML
    private Button porkchop;
    
    @FXML
	private Stage stagePC;
	private Scene scenePC;
	private Parent rootPC;

    @FXML
    void gotoPorkChop(ActionEvent event) throws IOException {

    	FXMLLoader loaderFl = new FXMLLoader(getClass().getResource("porkchop.fxml"));
		
		rootFl = loaderFl.load();
		stageFl = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneFl = new Scene(rootFl,335,600);
		stageFl.setScene(sceneFl);
		stageFl.show();
    }
    
    @FXML
    private Button ribs;
    
    @FXML
	private Stage stageRi;
	private Scene sceneRi;
	private Parent rootRi;
	
    @FXML
    void gotoRibs(ActionEvent event) throws IOException {

    	FXMLLoader loaderRi = new FXMLLoader(getClass().getResource("ribs.fxml"));
		
		rootRi = loaderRi.load();
		stageRi = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneRi = new Scene(rootRi,335,600);
		stageRi.setScene(sceneRi);
		stageRi.show();
    }
    
	@FXML
    private Button tBone;
    
    @FXML
	private Stage stageTB;
	private Scene sceneTB;
	private Parent rootTB;
    @FXML
    void gotoTBone(ActionEvent event) throws IOException {

    	FXMLLoader loaderWi = new FXMLLoader(getClass().getResource("tbone.fxml"));
		
		rootWi = loaderWi.load();
		stageWi = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneWi = new Scene(rootWi,335,600);
		stageWi.setScene(sceneWi);
		stageWi.show();
    }
    
    @FXML
    private Button wings;
    
    @FXML
	private Stage stageWi;
	private Scene sceneWi;
	private Parent rootWi;
	
    @FXML
    void gotoWings(ActionEvent event) throws IOException {

    	FXMLLoader loaderTB = new FXMLLoader(getClass().getResource("wings.fxml"));
		
		rootTB = loaderTB.load();
		stageTB = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneTB = new Scene(rootTB,335,600);
		stageTB.setScene(sceneTB);
		stageTB.show();
    }

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
}
