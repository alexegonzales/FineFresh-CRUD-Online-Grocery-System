package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Eggplant_Controller implements Initializable{

	@FXML
    private Button backBTNlog;

	@FXML
	private Stage stageBLog;
	private Scene sceneBLog;
	private Parent rootBLog;
	
    @FXML
    void backtolog(ActionEvent event) throws IOException {

    	FXMLLoader loaderBLog = new FXMLLoader(getClass().getResource("ProdPane.fxml"));
		
		rootBLog = loaderBLog.load();
		stageBLog = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneBLog = new Scene(rootBLog);
		stageBLog.setScene(sceneBLog);
		stageBLog.show();
	}

    PreparedStatement pst, ps;
    Connection con;
    
	@FXML
    private Spinner<Integer> quantitySPN;
	final int INITIAL_VALUE = 0;
	SpinnerValueFactory<Integer> itemQuantity = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 99, INITIAL_VALUE);
	
    @FXML
    private Button addtoBasket;
    
    @FXML
    private Label added;
    
    @FXML
    void gotoBasket(ActionEvent event) {

    	try {
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			con = DriverManager.getConnection("jdbc:mysql://localhost/basket", "root", "");
    		
    			int qty = quantitySPN.getValue();
    		
    			pst = con.prepareStatement("INSERT INTO `itemlist`(`id`, `item`, `price`, `quantity`, `subtotal`) VALUES (6,'Eggplant', 30, ?, price*quantity)");
    			
    			pst.setInt(1, qty);
	 
    			pst.executeUpdate();
	    
    			added.setText("Added to basket!");
    			added.setTextFill(Color.GREEN);
    			
    	} catch (SQLException | ClassNotFoundException e1) {
    		
    			e1.printStackTrace();
    		}
    	}
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		quantitySPN.setValueFactory(itemQuantity);	
	} 

}
