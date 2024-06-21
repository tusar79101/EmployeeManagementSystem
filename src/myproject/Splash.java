package myproject;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Splash extends JFrame implements ActionListener {
         
    //constructor
    Splash(){
        
     Point splashButtonLayout = new Point(80,30);
        
        //Make basic frame
        setSize(800,400);        // Set frame length and weight. but not seen.by default hidden
        setLocation(350,200);   //Set frame locatin in x-axis and y-axis
    
        
        getContentPane().setBackground(Color.GRAY);   /// Frame  colour change . getContentPane()---> frame access.

        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");   //Set project name into frame
        Component add = add(heading);    //Now haeding seen
        
        
        //Set component above  frame 
        setLayout(null);   //Not to use by default.For use my own layout(setBounds use)
        heading.setBounds(splashButtonLayout.getX(),splashButtonLayout.getY(),1200,60);   //Layout set in frame               
        heading.setFont(new Font("serif", Font.PLAIN, 35));   //Set project name(font size)
        heading.setForeground(Color.BLACK);   //project name(e m p) colour change
          
        
         // Button add 
         JButton clickhere= new JButton("CLICK HERE TO CONTINUE");  // click here button make
         clickhere.setBounds(splashButtonLayout.shiftXAxis(125).getX(),splashButtonLayout.shiftYAxis(100).getY(),300,50);  // set place in frame  and own size
         add(clickhere);    // akon show korbe
         
        clickhere.setBackground(Color.BLACK);  // background colour
        clickhere.setForeground(Color.WHITE);   // click here button colour
       
          
        
        //Go Login screen make.Now work click here button
        clickhere.addActionListener(this);   //now a new interface (login) add up to the click here button. 
        
        
        setVisible(true); // now seen Frame.not hidden
        
    }
    

    
    
    @Override
     public void actionPerformed(ActionEvent ae) {
        setVisible(false);  // close click here frame.close current frame
        new Login();     //open login frame
    }
    
    
    

    public static void main(String args[]){
              new Splash();           // Create  anonymous object 

}
}

