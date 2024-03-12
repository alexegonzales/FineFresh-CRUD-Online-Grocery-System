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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChangePass_Controller {

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
    
    @FXML
    Button confirmChanges;

    @FXML
    PasswordField conPassField;

    @FXML
    Label lrtMsg;
    
    PreparedStatement pst;
    Connection con;
    
    @FXML
    public void confirm(ActionEvent event) throws IOException {
    	
    	try {
    			String passW = conPassField.getText();
    			
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			con = DriverManager.getConnection("jdbc:mysql://localhost/loginsignup", "root", "");
        	 
    			pst = con.prepareStatement("select password from loginsignuppage where password = ?");
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
    PasswordField editPassField;
    
    @FXML
     PasswordField newConPassField;
    
    @FXML
    Label newConPass;
    
    @FXML
    Label userMSG;
    
    public void saveNew(ActionEvent event) throws IOException {
    	
    	String passF = editPassField.getText();
		String cpassF = newConPassField.getText();
    	String  passW = conPassField.getText();
		
    	if(!cpassF.equals(passF))
    	{
    		newConPass.setText("Password doesn' t match!");
    		newConPass.setTextFill(Color.RED);
    	}
    	else {
    			try {
    					Class.forName("com.mysql.cj.jdbc.Driver");
    					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/loginsignup", "root", "");
    		
    					pst = con.prepareStatement("update loginsignuppage set password = ? where password = ?");
    					pst.setString(1, passF);
    					pst.setString(2, passW);
	 
    					int stat = pst.executeUpdate();
    		    		if(stat == 1) {
    				
    		    			userMSG.setText("Password Updated!");
    		    			userMSG.setTextFill(Color.GREEN);
    					
    		    			newConPass.setText("Confirm new password");
    		    			newConPass.setTextFill(Color.rgb(104, 104, 104));
    					
    		    			//lrtMsg.setText("Enter password for confirmation");
    		    			//lrtMsg.setTextFill(Color.rgb(104, 104, 104));
	 
    		    			editPassField.setText("");
    		    			editPassField.requestFocus();
    		    			conPassField.setText("");
    		    			newConPassField.setText("");
    		    		}
    		    		else {
    		    			
    		    			userMSG.setText("Check your password!");
    		    			userMSG.setTextFill(Color.RED);	
    		    		}
	         
    			} catch (SQLException | ClassNotFoundException e1) {
    				
    				e1.printStackTrace();
    			}
    		}
   		}	
}
