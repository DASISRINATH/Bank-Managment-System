package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    JButton login, sinup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setLayout(null);
        setTitle("AUTOMATED TELLER MACHINE");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        setSize(800,480);
        setVisible(true);
        setLocation(300,120);
        getContentPane().setBackground(Color.white);
        
        JLabel text=new JLabel("Welcome To ATM");
        text.setBounds(200, 40, 400, 40);
        text.setFont(new Font("Osward", Font.BOLD, 38));
        add(text);
        
        JLabel cardNo=new JLabel("Card No:");
        cardNo.setBounds(120, 150, 150, 30);
        cardNo.setFont(new Font("raleway", Font.BOLD, 28));
        add(cardNo);
        
        cardTextField=new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        JLabel pin=new JLabel("PIN:");
        pin.setBounds(120, 220, 250, 30);
        pin.setFont(new Font("raleway", Font.BOLD, 28));
        add(pin);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        login = new JButton("SIGN");
        login.setBounds(300, 300, 100, 30);
        login.addActionListener(this);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.addActionListener(this);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        add(clear);
        
        sinup = new JButton("SINUP");
        sinup.setBounds(300, 350, 230, 30);
        sinup.addActionListener(this);
        sinup.setBackground(Color.black);
        sinup.setForeground(Color.white);
        add(sinup);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if (ae.getSource() == login)
        {
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card number and Pin");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == sinup)
        {
            setVisible(false);
            new SinupOne().setVisible(true);
        }
        
    }
    public static void main(String[] args) {
        new Login();
    }
    
}