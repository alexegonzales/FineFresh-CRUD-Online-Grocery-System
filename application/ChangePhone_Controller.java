package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChangePhone_Controller {
	
    @FXML
    private Button backBTN;

	@FXML
	private Stage stageB;
	private Scene sceneB;
	private Parent rootB;
	
    @FXML
    void backtoHome(ActionEvent event) throws IOException {
    	
    	FXMLLoader loaderB = new FXMLLoader(getClass().getResource("ManageAccount.fxml"));
		
		rootB = loaderB.load();
		stageB = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneB = new Scene(rootB);
		stageB.setScene(sceneB);
		stageB.show();
    }
    
    PreparedStatement pst;
    Connection con;
    
    @FXML
    Button confirmChanges;

    @FXML
    PasswordField conPassField;

    @FXML
    Label lrtMsg;
    
   
    
    @FXML
    public void confirm(ActionEvent event) throws IOException {
    	
    	try {
    			String passW = conPassField.getText();
    			
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			con = DriverManager.getConnection("jdbc:mysql://localhost/loginsignup", "root", "");
        	 
    			pst = con.prepareStatement("select phone from loginsignuppage where password = ?");
    			pst.setString(1, passW);
                    		
    			ResultSet rs = pst.executeQuery();
        		
    			if(passW.equals("")) {
    				lrtMsg.setText("Invalid Password!");
                 	lrtMsg.setTextFill(Color.RED);
    			}
    			
    			if(rs.next())
    				{
    					lrtMsg.setText("Confirmed!");
    					lrtMsg.setTextFill(Color.GREEN);
    				}
                 	else
                 	{
                 		lrtMsg.setText("Invalid Password!");
                 		lrtMsg.setTextFill(Color.RED);
                    }
         } catch (SQLException | ClassNotFoundException e) {
        		// TODO Auto-generated catch block
        	 e.printStackTrace();
         }
    }
    
    @FXML
    Button saveChanges;
    
    @FXML
    TextField editPhoneField;
    
    @FXML
    Label userMSG;
    
    public void saveNew(ActionEvent event) throws IOException {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/loginsignup", "root", "");
    		
    		String phoneN = editPhoneField.getText();
    		String passW = conPassField.getText();
    		
    		pst = con.prepareStatement("update loginsignuppage set phone = ? where password = ?");
    		pst.setString(1, phoneN);
    		pst.setString(2, passW);
	 
    		int stat = pst.executeUpdate();
    		if(stat == 1) {
    			
    			userMSG.setText("Phone Number Updated!");
    			userMSG.setTextFill(Color.GREEN);
    		
    			//lrtMsg.setText("Enter password for confirmation");
    			//lrtMsg.setTextFill(Color.rgb(104, 104, 104));
	 
    			editPhoneField.setText("");
    			editPhoneField.requestFocus();
    			conPassField.setText("");
    		}
    		else {
    			 
    			userMSG.setText("Check your password!");
    			userMSG.setTextFill(Color.RED);	
    		}
    	}
    	catch (SQLException | ClassNotFoundException e1)
    	{
    		e1.printStackTrace();

    	}
    }
}
