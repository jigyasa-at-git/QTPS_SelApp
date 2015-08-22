//http://qtpselenium.com/applet/test.html

import java.applet.Applet;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class My_Test_Applet extends Applet  implements ActionListener{
	
	Label welcomeMsg = new Label("Welcome User");
	TextField username = new TextField("Enter name here",20);
	Choice city = new Choice();
	Button okButton = new Button("OK");
	
	
	public void init(){
		add(welcomeMsg);
		add(username);
		city.add("NY");
		city.add("Delhi");
		city.add("London");
		
		add(city);
		add(okButton);
		okButton.addActionListener(this);
		
	}
	
	
	
	// exposed the controlling functions
	public void setWelcomeMessage(String newMessage){
		welcomeMsg.setText(newMessage);
	}
	
	public String getWelcomeMessage(){
		return welcomeMsg.getText();
	}
	
	public void setTextMessage(String msg){
		username.setText(msg);
	}
	
	public String getTextMessage(){
		return username.getText();
	}
	
	
	public void selectCity(String cityName){
		city.select(cityName);
	}
	
	
	public String getSelectedCity(){
		return city.getSelectedItem();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		submitForm();
	
	}
	
	public void submitForm(){
		welcomeMsg.setText("Submitting Form");
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {	}
		welcomeMsg.setText("Form Submitted");

	}
	
	
	
	
	
	
	

}
