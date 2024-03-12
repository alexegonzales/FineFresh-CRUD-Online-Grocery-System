package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
//import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Basket_Controller implements Initializable{

    @FXML
    private TableView<ModelTable> basketTable;
    
    @FXML
    private TableColumn<ModelTable, String> id_Col;

    @FXML
    private TableColumn<ModelTable, String> item_Col;

    @FXML
    private TableColumn<ModelTable, String> price_Col;

    @FXML
    private TableColumn<ModelTable, String> qty_Col;
    
    @FXML
    private TableColumn<ModelTable, String> subT_Col;
    
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
    private Button calculate;

    @FXML
    private TextField totalField;

    PreparedStatement pst;
    Connection con;
    ResultSet rs;
    ModelTable item = null;
    String query = null;
    
    @FXML
    void calculate(ActionEvent event) {
    	
    	try {
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			con = DriverManager.getConnection("jdbc:mysql://localhost/basket", "root", "");
			
    			pst = con.prepareStatement("SELECT SUM(subtotal) AS total FROM itemlist ");
    		
            	rs = pst.executeQuery();
            	
            		while (rs.next())
            		{
            			int total = rs.getInt((1));
            			totalField.setText(Integer.toString(total));
            		}
        		} catch (SQLException | ClassNotFoundException e) {
        			
                    Logger.getLogger(Basket_Controller.class.getName()).log(Level.SEVERE, null, e);
        		}
    		}
    
    @FXML
    private Button refresh;
    
    @FXML
    void refreshTable() {
    	try {
    		
    		itmlist.clear();
    		con = DriverManager.getConnection("jdbc:mysql://localhost/basket", "root", "");
			pst = con.prepareStatement("SELECT * FROM itemlist");
    		rs = pst.executeQuery();
    		
    		while (rs.next()){
    			itmlist.add(new  ModelTable(
    					rs.getInt("id"),
    					rs.getInt("price"),
    					rs.getInt("quantity"),
    					rs.getInt("subtotal"),
    					rs.getString("item")));
            
    			basketTable.setItems(itmlist);
    		}
    	}  catch (SQLException e) {
			
            Logger.getLogger(Basket_Controller.class.getName()).log(Level.SEVERE, null, e);
    	}
    }
    
    @FXML
    private Button update;
    
    @FXML
	private Stage stageUd;
	private Scene sceneUd;
	private Parent rootUd;
	
    @FXML
    void update(MouseEvent event) {

    	 try {
    		 	FXMLLoader loaderUd = new FXMLLoader(getClass().getResource("UpdateQty.fxml"));
    			
    			rootUd = loaderUd.load();
    			//stageUd = (Stage)((Node)event.getSource()).getScene().getWindow();
    			sceneUd = new Scene(rootUd);
    			stageUd = new Stage();
    			stageUd.setScene(sceneUd);
    			stageUd.initStyle(StageStyle.UTILITY);
    			stageUd.show();
    			
         } catch (IOException ex) {
             Logger.getLogger(Basket_Controller.class.getName()).log(Level.SEVERE, null, ex);
         }
         
     }
  
    @FXML
    private Button delete;
    
    @FXML
    void deleteItem(ActionEvent event) {
    	
    	try {
            item = basketTable.getSelectionModel().getSelectedItem();
            query = "DELETE FROM `itemlist` WHERE id  ="+item.getId();
            con = BasketDBConnect.getConnect();
            pst = con.prepareStatement(query);
            pst.execute();
            refreshTable();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Basket_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private Button checkout;
    
    @FXML
    private Label complete;
    
    @FXML
    void checkOut(ActionEvent event) {

    	String totalf = totalField.getText();
    	
    	if(totalf.isEmpty()) {
    		
    		complete.setText("Invalid Transaction!");
    		complete.setTextFill(Color.RED);
    	}
    	else {
    		
    		complete.setText("Transaction Complete!");
    		complete.setTextFill(Color.GREEN);
    	}
    }
    
    ObservableList<ModelTable> itmlist = FXCollections.observableArrayList();
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try { 
			Connection con = BasketDBConnect.getConnect();
		
			ResultSet rs = con.createStatement().executeQuery("select * from itemlist");
			
			while (rs.next()) {
				
				itmlist.add( new ModelTable(rs.getInt("id"), rs.getInt("price"), rs.getInt("quantity"), rs.getInt("subtotal"), rs.getString("item")));
			}
			
		} catch (SQLException |ClassNotFoundException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(Basket_Controller.class.getName()).log(Level.SEVERE, null, e);
		} 
			
			id_Col.setCellValueFactory( new PropertyValueFactory<>("id"));
			item_Col.setCellValueFactory( new PropertyValueFactory<>("item"));
			price_Col.setCellValueFactory( new PropertyValueFactory<>("price"));
			qty_Col.setCellValueFactory( new PropertyValueFactory<>("quantity"));
			subT_Col.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
			
			basketTable.setItems(itmlist);
			
		}
}
