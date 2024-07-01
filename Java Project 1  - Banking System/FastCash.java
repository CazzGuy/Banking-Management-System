import javax.swing.*;
import javax.xml.crypto.Data;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {
    JLabel ima,l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pinno;
    FastCash(String pinno){
        this.pinno = pinno;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        ima = new JLabel(i3);
        ima.setBounds(0,0,900,900);
        add(ima);

        l1 = new JLabel("Select a withdrawal amount ");
        l1.setBounds(230,310,400,40);
        l1.setFont(new Font("Arial",Font.CENTER_BASELINE,16));
        l1.setForeground(Color.WHITE);
        ima.add(l1);

        b1 = new JButton("Rs 100");
        b1.setBounds(170,445,140,35);
        b1.addActionListener(this);
        ima.add(b1);

        b2 = new JButton("Rs 500");
        b2.setBounds(370,445,140,35);
        b2.addActionListener(this);
        ima.add(b2);


        b3 = new JButton("Rs 1000");
        b3.setBounds(170,485,140,35);
        b3.addActionListener(this);
        ima.add(b3);

        b4 = new JButton("Rs 2000");
        b4.setBounds(370,485,140,35);
        b4.addActionListener(this);
        ima.add(b4);

        b5 = new JButton("Rs 5000");
        b5.setBounds(170,525,140,35);
        b5.addActionListener(this);
        ima.add(b5);

        b6 = new JButton("Rs 10000");
        b6.setBounds(370,525,140,35);
        b6.addActionListener(this);
        ima.add(b6);

        b7 = new JButton("Back");
        b7.setBounds(370,565,140,35);
        b7.addActionListener(this);
        ima.add(b7);


        setSize(900,900);
        setLocation(350,00);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b7){
            setVisible(false);
            new Transaction(pinno).setVisible(true);
        } else{
            String amt = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where Pin_No = '"+pinno+"'");
                int bal = 0;
                while (rs.next()){
                    if(rs.getString("Type").equals("Deposit")){
                        bal += Integer.parseInt(rs.getString("Amount"));
                    }else {
                        bal -= Integer.parseInt(rs.getString("Amount"));
                    }
                }
                if(ae.getSource()!=b7 && bal < Integer.parseInt(amt)){
                    JOptionPane.showMessageDialog(null,"Insufficient Amount");
                    return;
                }
                Date d = new Date();
                String query = "insert into bank values('"+pinno+"','"+d+"','Withdrawal','"+amt+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amt+" is debited successfully.");
                setVisible(false);
                new Transaction(pinno).setVisible(true);
            }catch (Exception e){
                System.out.println(e);
            }

        }


    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
