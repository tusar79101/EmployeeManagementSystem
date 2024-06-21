package myproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.util.*;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField iddd, ido, idds, iddw, idde;
    JLabel jid;
    JButton add, back;

    Random ran = new Random();
    int number = ran.nextInt(999999);

    AddEmployee() {

        setSize(900, 700);
        setLocation(300, 50);

        getContentPane().setBackground(Color.GRAY);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        
        
        JLabel id = new JLabel("Employee Id");
        id.setBounds(50, 150, 150, 30);
        add(id);
        id.setFont(new Font("serif", Font.PLAIN, 20));

        //
        jid = new JLabel("" + number);
        jid.setBounds(200, 150, 150, 30);
        add(jid);

        JLabel name = new JLabel("Enter Name");
        name.setBounds(50, 200, 150, 30);
        add(name);
        name.setFont(new Font("serif", Font.PLAIN, 20));

        iddd = new JTextField();
        iddd.setBounds(200, 200, 150, 30);
        add(iddd);

        JLabel age = new JLabel("Enter Age");
        age.setBounds(50, 250, 150, 30);
        add(age);
        age.setFont(new Font("serif", Font.PLAIN, 20));

        ido = new JTextField();
        ido.setBounds(200, 250, 150, 30);
        add(ido);

        JLabel desi = new JLabel("Enter Designation");
        desi.setBounds(50, 300, 150, 30);
        add(desi);
        desi.setFont(new Font("serif", Font.PLAIN, 20));

        idds = new JTextField();
        idds.setBounds(200, 300, 150, 30);
        add(idds);

        JLabel dep = new JLabel("Enter Department");
        dep.setBounds(50, 350, 150, 30);
        add(dep);
        dep.setFont(new Font("serif", Font.PLAIN, 20));

        iddw = new JTextField();
        iddw.setBounds(200, 350, 150, 30);
        add(iddw);

        JLabel sal = new JLabel("Enter Sallery");
        sal.setBounds(50, 400, 150, 30);
        add(sal);
        sal.setFont(new Font("serif", Font.PLAIN, 20));

        idde = new JTextField();
        idde.setBounds(200, 400, 150, 30);
        add(idde);
        

        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add) {
            String Id = jid.getText();
            String Name = iddd.getText();
            String Age = ido.getText();
            String Desi = idds.getText();
            String Dep = iddw.getText();
            String Sal = idde.getText();

            
            // store in data base
            try {

                Conn conn = new Conn();

                String query = "insert into employ values('" + Id + "', '" + Name + "', '" + Age + "', '" + Desi + "', '" + Dep + "', '" + Sal + "')";

                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");  //null: Indicates no parent component, so the dialog is centered on the screen.
                setVisible(false);
                new Home();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
