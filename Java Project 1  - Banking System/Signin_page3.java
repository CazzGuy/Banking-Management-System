import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Signin_page3 extends JFrame implements ActionListener {
    String formno;
    String pin_no;
    JRadioButton sa,ca,fda,rda;
    JCheckBox ac,mb,cb,ib,es, est ,dec;
    JButton submit,cancel;

    Signin_page3(String formno){
        this.formno = formno;
        JLabel l1 = new JLabel("Page 3: Accounting Details");
        l1.setFont(new Font("Arial",Font.BOLD,35));
        l1.setBounds(180,80,600,70);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setBounds(80,160,400,50);
        type.setFont(new Font("Arial",Font.BOLD,25));
        add(type);


        sa = new JRadioButton("Savings Account");
        sa.setBounds(300,200,200,40);
        sa.setBackground(Color.WHITE);
        add(sa);

        ca = new JRadioButton("Current  Account");
        ca.setBounds(110,200,190,40);
        ca.setBackground(Color.WHITE);
        add(ca);

        fda = new JRadioButton("Fixed Deposit Account");
        fda.setBounds(110,230,190,40);
        fda.setBackground(Color.WHITE);
        add(fda);

        rda = new JRadioButton("Recurring Deposit Account");
        rda.setBounds(300,230,200,40);
        rda.setBackground(Color.WHITE);
        add(rda);

        JLabel card = new JLabel("Card Number : ");
        card.setBounds(80 ,300,400,40);
        card.setFont(new Font("Arial",Font.BOLD,25));
        add(card);

        JLabel s1 = new JLabel("Your 16 digit Card Number");
        s1.setBounds(80,330,400,20);
        s1.setFont(new Font("Arial",Font.BOLD,12));
        add(s1);

        JLabel dumy = new JLabel("XXXX-XXXX-XXXX-4334");
        dumy.setBounds(260,300,400,40);
        dumy.setFont(new Font("Arial",Font.BOLD,25));
        add(dumy);

        JLabel pin = new JLabel("Pin : ");
        pin.setFont(new Font("Arial",Font.BOLD,25));
        pin.setBounds(80,350,400,50);
        add(pin);

        JLabel s2 = new JLabel("Your 4 Digit Password");
        s2.setBounds(80,385,400,20);
        s2.setFont(new Font("Arial",Font.BOLD,12));
        add(s2);

        JLabel dumy2 = new JLabel("XXXX");
        dumy2.setBounds(260,350,400,40);
        dumy2.setFont(new Font("Arial",Font.BOLD,25));
        add(dumy2);


        JLabel l2 = new JLabel("Services Available");
        l2.setFont(new Font("Arial",Font.BOLD,25));
        l2.setBounds(80,440,400,20);
        add(l2);

        ac = new JCheckBox("Atm Card");
        ac.setBounds(90, 470,200,40);
        ac.setFont(new Font("Arial",Font.BOLD,15));
        ac.setBackground(Color.WHITE);
        add(ac);

        mb = new JCheckBox("Mobile Banking");
        mb.setBounds(90,500,200,40);
        mb.setFont(new Font("Arial",Font.BOLD,15));
        mb.setBackground(Color.WHITE);
        add(mb);

        cb = new JCheckBox("Cheque Book");
        cb.setBounds(90,530,200,40);
        cb.setFont(new Font("Arial",Font.BOLD,15));
        cb.setBackground(Color.WHITE);
        add(cb);


        ib = new JCheckBox("Internet Banking");
        ib.setBounds(320,470,200,40);
        ib.setFont(new Font("Arial",Font.BOLD,15));
        ib.setBackground(Color.WHITE);
        add(ib);


        es = new JCheckBox("Email & SMS Alerts");
        es.setBounds(320,500,200,40);
        es.setFont(new Font("Arial",Font.BOLD,15));
        es.setBackground(Color.WHITE);
        add(es);


        est = new JCheckBox("E-Statements");
        est.setBounds(320,530,200,40);
        est.setFont(new Font("Arial",Font.BOLD,15));
        est.setBackground(Color.WHITE);
        add(est);


        dec = new JCheckBox("I hereby declare that the above details are correct to the best of my knowledge");
        dec.setBounds(90,590,600,40);
        dec.setFont(new Font("Arial",Font.BOLD,14));
        dec.setBackground(Color.WHITE);
        add(dec);

        submit = new JButton("Submit");
        submit.setBounds(170,660,80,30);
        submit.setFont(new Font("Arial",Font.BOLD,10));
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(370,660,80,30);
        cancel.setFont(new Font("Arial",Font.BOLD,10));
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);

        setLayout(null);

        getContentPane().setBackground(Color.WHITE);
        setSize(800,900);
        setLocation(350,100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accType= null;
            if(sa.isSelected()){
                accType = "Savings Account";
            } else if (ca.isSelected()) {
                accType = "Current Account";
            } else if (fda.isSelected()) {
                accType = "Fixed Deposit Account";
            } else if (rda.isSelected()) {
                accType = "Recurring Deposit Account";
            }

            Random r = new Random();
            String card_no = " " + Math.abs((r.nextLong() % 9000000000000000l) + 509067950000000l);
             pin_no = "" + Math.abs((r.nextLong() % 9000l) + 1000l);


            String facility = "";
            if(ac.isSelected()){
                facility = facility + "ATM Card";
            } else if (mb.isSelected()) {
                facility = facility + "Mobile Banking";
            } else if (cb.isSelected()) {
                facility = facility + "Cheque Book";
            } else if (ib.isSelected()) {
                facility = facility +"Internet Banking";
            } else if (es.isSelected()) {
                facility = facility + "Emaail & SMS Alerts";
            } else if (est.isSelected()) {
                facility = facility + "E-Statement";
            }

            try {
                if (accType==null){
                    JOptionPane.showMessageDialog(null , "Account Type Required");
                }else {
                    Conn conn = new Conn();
                    String query1 = "insert into  Signin_page3 values('"+formno+"','"+accType+"','"+facility+"','"+card_no+"','"+pin_no+"')";
                    String query2 = "insert into  login values('"+formno+"','"+card_no+"','"+pin_no+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Your Card number is "+card_no+"\nYour Pin number is "+pin_no);
                }
            }catch (Exception e){
                e.printStackTrace();

            }


        } else if (ae.getSource()==cancel) {

        }
    }

    public static void main(String[] args) {
        new Signin_page3("");



    }
}

