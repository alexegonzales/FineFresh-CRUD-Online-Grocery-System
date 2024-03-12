package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class Login_Controller {
    
    @FXML
    private TextField userField;
    
    @FXML
    private PasswordField passField;
    
    @FXML
    private Text valid;
    
    Connection con;
    PreparedStatement pst;
    
    @FXML
    private Button backBTNlog;

	@FXML
	private Stage stageBLog;
	private Scene sceneBLog;
	private Parent rootBLog;
	
    @FXML
    void backtolog(ActionEvent event) throws IOException {

    	FXMLLoader loaderBLog = new FXMLLoader(getClass().getResource("Login_SignUp.fxml"));
		
		rootBLog = loaderBLog.load();
		stageBLog = (Stage)((Node)event.getSource()).getScene().getWindow();
		sceneBLog = new Scene(rootBLog);
		stageBLog.setScene(sceneBLog);
		stageBLog.show();
	} 
    
    @FXML
    private Button loginBTN;
    
    @FXML
	private Stage stageGLog;
	private Scene sceneGLog;
	private Parent rootGLog;
    
    @FXML
    void gonnalogin(ActionEvent event) throws IOException {

    	String uName = userField.getText();
    	String pass = passField.getText();
    	
    	if(uName.equals("") && pass.equals("")) 
    	{
			valid.setText("Please enter username and password!");
    		valid.setFill(Color.RED);
    	}
    	else
    	{
    		try {
    				Class.forName("com.mysql.cj.jdbc.Driver");
    				con = DriverManager.getConnection("jdbc:mysql://localhost/loginsignup", "root", "");
    				
    				pst = con.prepareStatement("select * from loginsignuppage where username=? and password=?");

    				pst.setString(1, uName);
    				pst.setString(2, pass);

    				ResultSet rs = pst.executeQuery();
    			
    				if(rs.next())
    				{
    					FXMLLoader loaderGLog = new FXMLLoader(getClass().getResource("BranchChoosing.fxml"));
    				
    					rootGLog = loaderGLog.load();
    					stageGLog = (Stage)((Node)event.getSource()).getScene().getWindow();
    					sceneGLog = new Scene(rootGLog);
    					stageGLog.setScene(sceneGLog);
    					stageGLog.show();
    				}
    				else
    				{
    					valid.setText("Wrong username or password!");
    					valid.setFill(Color.RED);
    					userField.setText("");
    					passField.setText("");
    					userField.requestFocus();
    				}

    			} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    			
    			} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    			}
    	}
    }
}

