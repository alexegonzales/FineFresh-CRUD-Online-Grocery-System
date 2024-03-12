package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeScreen_Controller implements Initializable{
	
    @FXML
    private Button meatBTN;

    @FXML
   	private Stage stageMP;
   	private Scene sceneMP;
   	private Parent rootMP;
   	
    @FXML
    void gotoMeat(ActionEvent event) throws IOException {
    
    	FXMLLoader loaderMP = new FXMLLoader(getClass().getResource("MeatPane.fxml"));
		
		rootMP = loaderMP.load();
		stageMP = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneMP = new Scene(rootMP,335,600);
		stageMP.setScene(sceneMP);
		stageMP.show();
    }

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
    private JFXHamburger burger;

    @FXML
    private JFXDrawer drawer;

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
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
				VBox box = FXMLLoader.load(getClass().getResource("HomeDrawer.fxml"));
				drawer.setSidePane(box);
	
				HamburgerBasicCloseTransition burgerTask = new HamburgerBasicCloseTransition(burger);
				burgerTask.setRate(-1);
				burger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) ->{
					burgerTask.setRate(burgerTask.getRate() * -1);
					burgerTask.play();
			
					if (drawer.isOpened()) {
						drawer.close();
						drawer.setDisable(true);
					} else {
						drawer.open();
						//itemsDrawer.setVisible(true);
						drawer.setDisable(false);
					}
				});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
