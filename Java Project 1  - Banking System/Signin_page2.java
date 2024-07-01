import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.*;

public class Signin_page2 extends JFrame implements ActionListener{
    long ran;
    String formno;
    JTextField panTextFeld, add_numTextFeld;
    JRadioButton male,female,married,unmarried,others,sC_yes, sC_no, yes, no;
    JButton next;
    JDateChooser dateChooser;
    JComboBox rel,cat,edu,inc,occp;


    Signin_page2(String formno){
        this.formno = formno;
        Random random = new Random();
        ran = Math.abs(random.nextInt()%200 + 1000L);
        setTitle("Signin Details");
        setLayout(null);

        JLabel AdditionalDetails = new JLabel("Page 2 Additional Details ");
        AdditionalDetails.setBounds(230,40,600,70);
        AdditionalDetails.setFont(new Font("Times New Roman",Font.BOLD,35));
        add(AdditionalDetails);

        JLabel religion = new JLabel("Religion : ");
        religion.setBounds(150,120,400,50);
        religion.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(religion);

        rel = new JComboBox<>(new String[]{"Hindu","Muslim","Christian", "Sikhs", "Others"});
        rel.setBounds(340 ,132,250,30);
        rel.setBackground(Color.WHITE);
        add(rel);



        JLabel category = new JLabel("Category  : ");
        category.setBounds(150,170,400,50);
        category.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(category);

        cat = new JComboBox<>(new String[]{"General","Sc/St","OBC","Others"});
        cat.setBounds(340 ,182,250,30);
        cat.setBackground(Color.WHITE);
        add(cat);

        JLabel income = new JLabel("Income : ");
        income.setBounds(150,220,400,50);
        income.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(income);

        inc = new JComboBox<>(new String[]{"null","<1,50,000","<5,00,000"," upto 10,00,000"});
        inc.setBackground(Color.WHITE);
        inc.setBounds(340,230,250,30);
        add(inc);

        JLabel educational = new JLabel("Educational  ");
        educational.setBounds(150,270,400,50);
        educational.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(educational);

        JLabel qualification = new JLabel("Qualification ");
        qualification.setBounds(150,290,400,50);
        qualification.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(qualification);

        edu = new JComboBox<>(new String[]{"Graduate","Post Graduate","Doctorate","Others"});
        edu.setBounds(340,290,250,30);
        edu.setBackground(Color.WHITE);
        add(edu);

        JLabel occ = new JLabel("Occupation  ");
        occ.setBounds(150,370,400,50);
        occ.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(occ);

        occp = new JComboBox<>(new String[]{"Salaried","Business","Student","Self-Employed","Others"});
        occp.setBounds(340,380,250,30);
        occp.setBackground(Color.WHITE);
        add(occp);

        JLabel pan_number = new JLabel("Pan Number  ");
        pan_number.setBounds(150,420,400,50);
        pan_number.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(pan_number);

        panTextFeld = new JTextField();
        panTextFeld.setBounds(340 ,432,225,30);
        add(panTextFeld);

        JLabel add_number = new JLabel("Addhar Number");
        add_number.setBounds(150,470,400,50);
        add_number.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(add_number);

        add_numTextFeld = new JTextField();
        add_numTextFeld.setBounds(340 ,482,225,30);
        add(add_numTextFeld);

        JLabel sc = new JLabel("Senior Citizem :  ");
        sc.setBounds(150,520,400,50);
        sc.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(sc);

         sC_yes  = new JRadioButton("Yes");
         sC_yes.setBounds(340,530,80,40);
         sC_yes.setBackground(Color.WHITE);
         add(sC_yes);

        sC_no  = new JRadioButton("No");
        sC_no.setBounds(420,530,80,40);
        sC_no.setBackground(Color.WHITE);
        add(sC_no);

        ButtonGroup sC = new ButtonGroup();
        sC.add(sC_yes);
        sC.add(sC_no);


        JLabel exist = new JLabel("Existing Account :  ");
        exist.setBounds(150,570,400,50);
        exist.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(exist);

        yes = new JRadioButton("Yes");
        yes.setBounds(360 ,582,60,30);
        yes.setBackground(Color.WHITE);
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(430 ,582,80,30);
        no.setBackground(Color.WHITE);
        add(no);

        ButtonGroup ea = new ButtonGroup();
        ea.add(yes);
        ea.add(no);

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
        String sreligion = (String)rel.getSelectedItem();
        String scat = (String) cat.getSelectedItem();
        String sedu = (String) edu.getSelectedItem();
        String sinc = (String) inc.getSelectedItem();
        String soccp = (String) occp.getSelectedItem();
        String span = panTextFeld.getText();
        String saddhar = add_numTextFeld.getText();
        String seniorcitizen = null;
        if(sC_no.isSelected()){
            seniorcitizen = "No";

        } else if (sC_yes.isSelected()) {
            seniorcitizen = "Yes";
        }

        String exsistingacc  = null;
        if(yes.isSelected()){
            exsistingacc = "yes";
        } else if (no.isSelected()) {
            exsistingacc = "No";

        }


        try{
            if(panTextFeld.equals("")){
                JOptionPane.showMessageDialog(null,"Pan Number is required.");
            }
            if(add_numTextFeld.equals("")){
                JOptionPane.showMessageDialog(null,"Aadhar Number  is required.");
            }

            else {
                Conn c = new Conn();
                String query = "insert into Signin_page2 values('"+formno+"','"+sreligion+"','"+scat+"','"+sedu+"','"+sinc+"','"+soccp+"','"+span+"','"+saddhar+"','"+exsistingacc+"','"+seniorcitizen+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new Signin_page3(formno);
            }



        }catch (Exception ae){
            System.out.println(ae);
        }

    }
    public static void main(String[] args) {
        new Signin_page2("");
    }

}


