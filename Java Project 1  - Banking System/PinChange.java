import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener {
    String pinno;
    JLabel l1,npin,rpin;
    JPasswordField t1,t2;
    JButton b1,b2;
    PinChange(String pinno){
        this.pinno = pinno;
        ImageIcon i1 = new ImageIcon("icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel ima = new JLabel(i3);
        ima.setBounds(0,0,900,900);
        add(ima);

        l1 = new JLabel("Please enter your new pin");
        l1.setBounds(190,320,400,40);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
        ima.add(l1);

        npin = new JLabel("New Pin");
        npin.setBounds(170,380,400,30);
        npin.setForeground(Color.white);
        npin.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
        ima.add(npin);

        rpin = new JLabel("Re-Enter New Pin");
        rpin.setBounds(170,420,400,30);
        rpin.setForeground(Color.white);
        rpin.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
        ima.add(rpin);

        t1 = new JPasswordField();
        t1.setBounds(380,380,100,30);
        t1.setFont(new Font("Times New Roman",Font.BOLD,20));
        ima.add(t1);

        t2 = new JPasswordField();
        t2.setBounds(380,420,100,30);
        t2.setFont(new Font("Times New Roman",Font.BOLD,20));
        ima.add(t2);

        b1 = new JButton("Change");
        b1.addActionListener(this);
        b1.setBounds(420,490,100,30);
        ima.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBounds(420,520,100,30);
        ima.add(b2);

        setLayout(null);
        setSize(900,900);
        setLocation(350,0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b2){
            setVisible(true);
            new Transaction(pinno).setVisible(true);
        }else {
            String newpin = t1.getText();
            String repin  = t2.getText();
            try {
                if(newpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter new pin");
                    return;
                } else if (repin.equals("")) {
                    JOptionPane.showMessageDialog(null,"Re-Enter new pin");
                    return;
                } else if (!newpin.equals(repin)) {
                    JOptionPane.showMessageDialog(null,"Please enter same pin");
                    return;


                } else {
                    Conn c = new Conn();
                    String query1 = "update bank set Pin_no = '"+repin+"' where Pin_no = '"+pinno+"'";
                    String query2 = "update login set Pin_no = '"+repin+"' where Pin_no = '"+pinno+"'";
                    String query3 = "update Signin_page3 set Pin_no = '"+repin+"' where Pin_no = '"+pinno+"'";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null,"Pin is successfully changed");
                    setVisible(false);
                    new Transaction(pinno).setVisible(true);
                }


            }catch (Exception e){
                System.out.println(e);
            }
        }

    }










    public static void main(String[] args) {
        new PinChange("");

    }
}
