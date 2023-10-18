
package bank.managment.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SinupOne extends JFrame implements ActionListener{

    long random;
    JTextField nametextField, fnametextField,mailtextField,addtextField,citytextField,statetextField,pintextField;
    JButton next;
    JRadioButton male,female,others,married,unmarried;
    JDateChooser dateChooser;
    
    
    SinupOne(){
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        
        Random ran=new Random();
        random = Math.abs(ran.nextLong() % 9000L) + 1000L;
        JLabel formNo = new JLabel("APPLICATION FORM NO. "+random);
        formNo.setBounds(140, 20, 600, 40);
        formNo.setFont(new Font("Raleway",Font.BOLD, 38));
        add(formNo);
        
        JLabel personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setBounds(290, 80, 400, 30);
        personalDetails.setFont(new Font("Raleway",Font.BOLD, 22));
        add(personalDetails);
        
        JLabel name = new JLabel("Name:");
        name.setBounds(100, 140, 100, 30);
        name.setFont(new Font("Raleway",Font.BOLD, 20));
        add(name);
        
        nametextField = new JTextField();
        nametextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nametextField.setBounds(300, 140, 400, 30);
        add(nametextField);
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(100, 190, 200, 30);
        fname.setFont(new Font("Raleway",Font.BOLD, 20));
        add(fname);
        
        fnametextField = new JTextField();
        fnametextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnametextField.setBounds(300, 190, 400, 30);
        add(fnametextField);
        
        JLabel dob = new JLabel("Date Of Birth:");
        dob.setBounds(100, 240, 200, 30);
        dob.setFont(new Font("Raleway",Font.BOLD, 20));
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender:");
        gender.setBounds(100, 290, 200, 30);
        gender.setFont(new Font("Raleway",Font.BOLD, 20));
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBackground(Color.white);
        male.setBounds(300, 290, 60, 30);
        add(male);
        
        
        female = new JRadioButton("Female");
        female.setBackground(Color.white);
        female.setBounds(450, 290, 120, 30);
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        JLabel mail = new JLabel("Email:");
        mail.setBounds(100, 340, 200, 30);
        mail.setFont(new Font("Raleway",Font.BOLD, 20));
        add(mail);
        
        mailtextField = new JTextField();
        mailtextField.setFont(new Font("Raleway", Font.BOLD, 14));
        mailtextField.setBounds(300, 340, 400, 30);
        add(mailtextField);
        
        JLabel maritual = new JLabel("Maritual Status:");
        maritual.setBounds(100, 390, 200, 30);
        maritual.setFont(new Font("Raleway",Font.BOLD, 20));
        add(maritual);
        
        married = new JRadioButton("Married");
        married.setBackground(Color.white);
        married.setBounds(300, 390, 100, 30);
        add(married);
        
        
        unmarried = new JRadioButton("UnMarried");
        unmarried.setBackground(Color.white);
        unmarried.setBounds(450, 390, 100, 30);
        add(unmarried);
        
        others = new JRadioButton("Other");
        others.setBackground(Color.white);
        others.setBounds(630, 390, 100, 30);
        add(others);
        
        ButtonGroup mariedGroup = new ButtonGroup();
        mariedGroup.add(married);
        mariedGroup.add(unmarried);
        mariedGroup.add(others);
        
        JLabel address = new JLabel("Address:");
        address.setBounds(100, 440, 200, 30);
        address.setFont(new Font("Raleway",Font.BOLD, 20));
        add(address);
        
        addtextField = new JTextField();
        addtextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addtextField.setBounds(300, 440, 400, 30);
        add(addtextField);
        
        JLabel city = new JLabel("City:");
        city.setBounds(100, 490, 200, 30);
        city.setFont(new Font("Raleway",Font.BOLD, 20));
        add(city);
        
        citytextField = new JTextField();
        citytextField.setFont(new Font("Raleway", Font.BOLD, 14));
        citytextField.setBounds(300, 490, 400, 30);
        add(citytextField);
        
        JLabel state = new JLabel("State:");
        state.setBounds(100, 540, 200, 30);
        state.setFont(new Font("Raleway",Font.BOLD, 20));
        add(state);
        
        statetextField = new JTextField();
        statetextField.setFont(new Font("Raleway", Font.BOLD, 14));
        statetextField.setBounds(300, 540, 400, 30);
        add(statetextField);
        
        JLabel pincode = new JLabel("PinCode:");
        pincode.setBounds(100, 590, 200, 30);
        pincode.setFont(new Font("Raleway",Font.BOLD, 20));
        add(pincode);
        
        pintextField = new JTextField();
        pintextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pintextField.setBounds(300, 590, 400, 30);
        add(pintextField);
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        next.setBounds(620,660,80,30);
        add(next);
   
    }
    
    public void actionPerformed(ActionEvent e){
        String formno=""+random;
        String name = nametextField.getText();
        String fname = fnametextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected())
        {
            gender = "male";
        }
        else{
            gender = "female";
        }
        String email = mailtextField.getText();
        String maritual = null;
        if(married.isSelected())
        {
            maritual = "married";
        }
        else if(unmarried.isSelected())
                {
                    maritual = "unmarried";
                }
                else
                    {
                       maritual = "others";
                    }
        String address = addtextField.getText();
        String city = citytextField.getText();
        String state = statetextField.getText();
        String pin = pintextField.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else{
                Conn c =new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"','"+dob+"', '"+gender+"', '"+email+"', '"+maritual+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Signup2(formno).setVisible(true);
            }
        }
        catch (Exception a)
        {
            System.out.println(a);
        }
        
    }

    public static void main(String[] args) {
        new SinupOne();
    }
    
}
