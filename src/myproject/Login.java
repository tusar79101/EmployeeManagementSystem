package myproject;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener {
    
    JTextField usernameField,passFieldd;
    
    
    
    
    //constructor
    Login(){
        
        ////Make Login frame
        setSize(600,300);      // Set login frame length and weight. but not seen.by default hidden
        setLocation(450,200);    //Set login frame locatin in x-axis and y-axis
        
        
        getContentPane().setBackground(Color.white);  // Login Frame  colour change
        
        
        
        //Set component above  frame
        setLayout(null);   //Not to use by default.For use mine own way
        
        
        // Take 2 information from user.username and password
        //username
        JLabel lblusername = new JLabel("Username");  // optionn name usernme           
        lblusername.setBounds(40,40,100,30);   // set username properly in frame 
        add(lblusername); // show username in frame
                                
        
        
        usernameField = new JTextField();       //Box set(textfiled)
        usernameField.setBounds(160, 40, 160, 30);
        add(usernameField);

      
         
        
        //password 
        JLabel lblpassword = new JLabel("Password");     // optionn name password          
        lblpassword.setBounds(40,70,100,30);   //set password(name) properly in frame...change y axis for avoid overlap
        add(lblpassword); // show password(name) in frame
        
        
        
        passFieldd = new JTextField();
        passFieldd.setBounds(160, 70, 160, 30);
        add(passFieldd);

        
        
         
        
        
        
        // button add  login er
        JButton login= new JButton("LOGIN");  // login here button make
        login.setBounds(165,140,150,30);     //set place in frame  and own size
        add(login);    // akon show korbe
         
        login.setBackground(Color.BLACK);  // background colour
        login.setForeground(Color.WHITE);   // login here button colour
        
        
        // click event work
        login.addActionListener(this);   //now a new interface  add up to the login here button.
        
        
        setVisible(true);      // now seen Login frame.not hidden               
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        try {
        
        String username = usernameField.getText();  //gettext - return textfield value
        String password = passFieldd.getText();
        
        
         Conn c = new Conn();   // execute my query
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
        
            
             ResultSet rs = c.s.executeQuery(query);   //execute kora.return value store in Resulset(rs)
            if (rs.next()) {   //kon value ase oita check kora
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");  // for popup - JoptionPane
                setVisible(false);
         }
            
            
            
    }catch(Exception e){
        
        e.printStackTrace();
        
    }
    }
    
    
    
    public static void main(String[] args) {
        new Login();    // Create  anonymous object
    }
}




