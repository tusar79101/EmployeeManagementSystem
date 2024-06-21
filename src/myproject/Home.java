package myproject;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Home extends JFrame implements ActionListener {

     
    
    JButton add, view, update, delet, viewall, exit;

    Home() {
        Point homeButtonLayout = new Point(120,80);
        setResizable(false);  //frame cannot be resized by the user.
        setSize(EmployeeConstants.WIDTH, EmployeeConstants.HEIGHT);  //size of the frame to the width and height
        setMaximumSize(new Dimension(EmployeeConstants.WIDTH, EmployeeConstants.HEIGHT));  //maximum size that the frame can be resized to.
        setLocation(EmployeeConstants.SCENE_X_POSITION, EmployeeConstants.SCENE_Y_POSITION);
        setLayout(null);

       
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(100, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        add(heading);

        // button gula banano add,delet agula
        add = new JButton("Add Employee");
        add.setBounds(homeButtonLayout.getX(), homeButtonLayout.getY(), 150, 40);
        add.addActionListener(this);   // option a button add kora
        add(add);

        view = new JButton("View Employees");
        view.setBounds(homeButtonLayout.getX(), homeButtonLayout.shiftYAxis(40).getY(), 150, 40);
        view.addActionListener(this);
        add(view);

        update = new JButton("Update Employee");
        update.setBounds(homeButtonLayout.getX(), homeButtonLayout.shiftYAxis(40).getY(), 150, 40);
        update.addActionListener(this);
        add(update);

        delet = new JButton("Delet Employee");
        delet.setBounds(homeButtonLayout.getX(), homeButtonLayout.shiftYAxis(40).getY(), 150, 40);
        delet.addActionListener(this);
        add(delet);

        
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add) {      
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new ViewEmployee();
        } else {
            setVisible(false);
            new RemoveEmployee();
        }

    }

    public static void main(String[] args) {
        new Home();
    }

}
  

