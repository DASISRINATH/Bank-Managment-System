
package bank.managment.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Signup2 extends JFrame implements ActionListener{
    
    JTextField pan,adhar ;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,occupation,education,income;
    String formno;
    
    Signup2(String formno){
    this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE 2");
      
        getContentPane().setBackground(Color.white);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        
        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setBounds(290, 80, 400, 30);
        additionalDetails.setFont(new Font("Raleway",Font.BOLD, 22));
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion:");
        name.setBounds(100, 140, 100, 30);
        name.setFont(new Font("Raleway",Font.BOLD, 20));
        add(name);
        
        String valReligion[]={"Hindu", "Muslim", "Sick", "Christian", "Others"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);
           
        JLabel fname = new JLabel("Category:");
        fname.setBounds(100, 190, 200, 30);
        fname.setFont(new Font("Raleway",Font.BOLD, 20));
        add(fname);
        
        String valCategory[]={"General", "OBC", "SC", "ST", "Others"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);
        
        JLabel dob = new JLabel("Income:");
        dob.setBounds(100, 240, 200, 30);
        dob.setFont(new Font("Raleway",Font.BOLD, 20));
        add(dob);
        
        String valIncome[]={"Null", "< 1,50,000", "> 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);
        
        JLabel gender = new JLabel("Education");
        gender.setBounds(100, 290, 200, 30);
        gender.setFont(new Font("Raleway",Font.BOLD, 20));
        add(gender);
        
        
        JLabel mail = new JLabel("Qualification:");
        mail.setBounds(100, 315, 200, 30);
        mail.setFont(new Font("Raleway",Font.BOLD, 20));
        add(mail);
        
        String valEducation[]={"Non Graduate", "Graduation", "Post Graduation", "Doctrate", "Others"};
        education = new JComboBox(valEducation);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.white);
        add(education);
        
        JLabel maritual = new JLabel("Occupation:");
        maritual.setBounds(100, 390, 200, 30);
        maritual.setFont(new Font("Raleway",Font.BOLD, 20));
        add(maritual);
        
        String valOccupation[]={"Salaried", "Self Employed", "Bussiness", "Student", "Retired", "Others"};
        occupation = new JComboBox(valOccupation);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);
        
        JLabel address = new JLabel("Pan No:");
        address.setBounds(100, 440, 200, 30);
        address.setFont(new Font("Raleway",Font.BOLD, 20));
        add(address);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        JLabel city = new JLabel("Aadhar No:");
        city.setBounds(100, 490, 200, 30);
        city.setFont(new Font("Raleway",Font.BOLD, 20));
        add(city);
        
        adhar = new JTextField();
        adhar.setFont(new Font("Raleway", Font.BOLD, 14));
        adhar.setBounds(300, 490, 400, 30);
        add(adhar);
        
        JLabel state = new JLabel("Senior Citizen:");
        state.setBounds(100, 540, 200, 30);
        state.setFont(new Font("Raleway",Font.BOLD, 20));
        add(state);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno); 
      
        ButtonGroup maritualGroup = new ButtonGroup();
        maritualGroup.add(syes);
        maritualGroup.add(sno);
        
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setBounds(100, 590, 200, 30);
        pincode.setFont(new Font("Raleway",Font.BOLD, 20));
        add(pincode);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup eGroup = new ButtonGroup();
        eGroup.add(eyes);
        eGroup.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        next.setBounds(620,660,80,30);
        add(next);
   
    }
    
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String)religion.getSelectedItem(); 
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        
        String span = pan.getText();
        String saadhar = adhar.getText();
        
        String scitizen = "";
        if(syes.isSelected()){ 
            scitizen = "Yes";
        }
        else if(sno.isSelected()){ 
            scitizen = "No";
        }
           
        String eaccount = "";
        if(eyes.isSelected()){ 
            eaccount = "Yes";
        }else if(eno.isSelected()){ 
            eaccount = "No";
        }
        
        try{
                Conn c =new Conn();
                String query = "insert into sinuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+scitizen+"','"+eaccount+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        catch(Exception ex){
             System.out.print(ex);
        }
    
               
    }
    
    
    public static void main(String[] args){
        new Signup2("");
    }
}