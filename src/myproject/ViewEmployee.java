
package myproject;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import net.proteanit.sql.DbUtils;


public class ViewEmployee extends JFrame implements ActionListener {
    
    
    
    JTable table;
    Choice cemployeeId;
    JButton search, update, back;
    
    ViewEmployee(){
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        cemployeeId = new Choice();
        cemployeeId.setBounds(180,20,150,20);
        add(cemployeeId);
        
        
        
        
        //drop down a id asbe
        try{
            
             Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employ");
            
          
            
            while(rs.next()) {
                cemployeeId.add(rs.getString("ID"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        table = new JTable();
        
        
        try{
            
             Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employ");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));//jar file ka class
            
            
                        while(rs.next()) {
                cemployeeId.add(rs.getString("ID"));
            }

            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        
         JScrollPane jsp = new JScrollPane(table);    //scroll korar jonno
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        
        
        
        
        JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        
        
        
         
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        
        
        update = new JButton("Update");
        update.setBounds(120, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(220, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
       
        
        
    }
    
    
    
    
  public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            
            
            String query = "select * from employ where Id = '"+cemployeeId.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }

                         

        }  else if (ae.getSource() == update) {
            
            
           setVisible(false);
           new UpdateEmployee1(cemployeeId.getSelectedItem());
        } else {
            setVisible(false);
            new Home();
        }
    }
    
    
    public static void main(String[] args) {
        new ViewEmployee();
    }
}
