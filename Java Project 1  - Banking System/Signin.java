import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;

import com.toedter.calendar.*;

public class Signin extends JFrame implements ActionListener {
    long ran;
    JTextField nameTextFeld, fnameTextFeld , addTextFeld, emailTextFeld, cityTextFeld, pinTextFeld, stateTextFeld;
    JRadioButton male, female, married, unmarried, others;
    JButton next;
    JDateChooser dateChooser;


    Signin(){
        Random random = new Random();
        ran = Math.abs(random.nextInt()%200 + 1000L);
        setTitle("Signin Details");
        setLayout(null);
        JLabel formno = new JLabel("Application Page : "+ran);
        formno.setBounds(220,30,950,50);
        formno.setFont(new Font("Times New Roman",Font.BOLD,40));
        add(formno);

        JLabel personalDetails = new JLabel("Page 1 Personal Details ");
        personalDetails.setBounds(250,80,400,50);
        personalDetails.setFont(new Font("Times New Roman",Font.BOLD,30));
        add(personalDetails);

        JLabel name = new JLabel("Name : ");
        name.setBounds(150,120,400,50);
        name.setFont(new Font("Times New Roman",Font.BOLD,25));

        add(name);

        nameTextFeld = new JTextField();
        nameTextFeld.setBounds(340 ,132,225,30);
        add(nameTextFeld);

        JLabel fname = new JLabel("Father's name : ");
        fname.setBounds(150,170,400,50);
        fname.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(fname);

        fnameTextFeld = new JTextField();
        fnameTextFeld.setBounds(340 ,182,225,30);
        add(fnameTextFeld);

        JLabel dob = new JLabel("Date of Birth : ");
        dob.setBounds(150,220,400,50);
        dob.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(230,105,100));
        dateChooser.setBounds(340,230,250,30);
        add(dateChooser);

        JLabel gender = new JLabel("Gender : ");
        gender.setBounds(150,270,400,50);
        gender.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(gender);

        male =  new JRadioButton("Male");
        male.setFont(new Font("Arial",Font.PLAIN,20));
        male.setBounds(340,280,80,30);
        male.setBackground(Color.WHITE);
        add(male);

        female =  new JRadioButton("Female");
        female.setBounds(430,280,100,30);
        female.setFont(new Font("Arial",Font.PLAIN,20));
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email :  ");
        email.setBounds(150,320,400,50);
        email.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(email);

        emailTextFeld = new JTextField();
        emailTextFeld.setBounds(340 ,332,225,30);
        add(emailTextFeld);

        JLabel mar = new JLabel("Marital Status  ");
        mar.setBounds(150,370,400,50);
        mar.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(mar);

        married =  new JRadioButton("Married");
        married.setFont(new Font("Arial",Font.PLAIN,20));
        married.setBounds(340,382,100,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried =  new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Arial",Font.PLAIN,20));
        unmarried.setBounds(450,382,120,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        others =  new JRadioButton("Others");
        others.setFont(new Font("Arial",Font.PLAIN,20));
        others.setBounds(580,382,100,30);
        others.setBackground(Color.WHITE);
        add(others);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(others);

        JLabel add = new JLabel("Address :  ");
        add.setBounds(150,420,400,50);
        add.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(add);

        addTextFeld = new JTextField();
        addTextFeld.setBounds(340 ,432,225,30);
        add(addTextFeld);

        JLabel city = new JLabel("City Name :  ");
        city.setBounds(150,470,400,50);
        city.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(city);

        cityTextFeld = new JTextField();
        cityTextFeld.setBounds(340 ,482,225,30);
        add(cityTextFeld);

        JLabel state = new JLabel("State Name :  ");
        state.setBounds(150,520,400,50);
        state.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(state);

        stateTextFeld = new JTextField();
        stateTextFeld.setBounds(340 ,532,225,30);
        add(stateTextFeld);

        JLabel pin = new JLabel("Pin Code :  ");
        pin.setBounds(150,570,400,50);
        pin.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(pin);

        pinTextFeld = new JTextField();
        pinTextFeld.setBounds(340 ,582,225,30);
        add(pinTextFeld);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,20));
        next.setBounds(620,680,80,50);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(800,900);
        setLocation(350,100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = " "+ ran;
        String name = nameTextFeld.getText();
        String fname = fnameTextFeld.getText();
        String add = addTextFeld.getText();
        String email = emailTextFeld.getText();
        String city = cityTextFeld.getText();
        String pin = pinTextFeld.getText();
        String state = stateTextFeld.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";

        } else if (female.isSelected()) {
            gender = "Female";
        }

        String marital  = null;
        if(married.isSelected()){
            marital = "married";
        } else if (unmarried.isSelected()) {
            marital = "unmarried";

        } else if (others.isSelected()) {
            marital = "Others";
        }


        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required.");
            }
            if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father's name is required.");
            }
            if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"Date of Birth name is required.");
            }
            if(gender.equals("")){
                JOptionPane.showMessageDialog(null,"Please provide your Gender.");
            }
            if(email.equals("")){
                JOptionPane.showMessageDialog(null,"Please provide your Email IDs.");
            }
            if(marital.equals("")){
                JOptionPane.showMessageDialog(null,"Please provide your marital status.");
            }
            if(add.equals("")){
                JOptionPane.showMessageDialog(null,"Address is required.");
            }
            if(city.equals("")){
                JOptionPane.showMessageDialog(null,"City's name is required.");
            }
            if(state.equals("")){
                JOptionPane.showMessageDialog(null,"State's name is required.");
            }
            if(pin.equals("")){
                JOptionPane.showMessageDialog(null,"Pin-Code  is required.");
            }
            else {
                Conn c = new Conn();
                String query = "insert into Signin values('"+formno+"','"+name+"','"+fname+"','"+add+"','"+email+"','"+city+"','"+pin+"','"+state+"','"+marital+"','"+dob+"','"+gender+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new Signin_page2(formno).setVisible(true);
            }

        }catch (Exception ae){
            System.out.println(ae);
        }

    }
    public static void main(String[] args) {
        new Signin();
    }

}