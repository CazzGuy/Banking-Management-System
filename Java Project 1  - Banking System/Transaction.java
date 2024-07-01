import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JLabel ima,l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pinno;
    Transaction(String pinno){
        this.pinno = pinno;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        ima = new JLabel(i3);
        ima.setBounds(0,0,900,900);
        add(ima);

        l1 = new JLabel("Please enter a transaction");
        l1.setBounds(230,310,400,40);
        l1.setFont(new Font("Arial",Font.CENTER_BASELINE,16));
        l1.setForeground(Color.WHITE);
        ima.add(l1);

        b1 = new JButton("Deposits");
        b1.setBounds(170,445,140,35);
        b1.addActionListener(this);
        ima.add(b1);

        b2 = new JButton("Cash Withdraw");
        b2.setBounds(370,445,140,35);
        b2.addActionListener(this);
        ima.add(b2);


        b3 = new JButton("Fast Cash");
        b3.setBounds(170,485,140,35);
        b3.addActionListener(this);
        ima.add(b3);

        b4 = new JButton("Mini Statement");
        b4.setBounds(370,485,140,35);
        b4.addActionListener(this);
        ima.add(b4);

        b5 = new JButton("Pin Change");
        b5.setBounds(170,525,140,35);
        b5.addActionListener(this);
        ima.add(b5);

        b6 = new JButton("Balance Enquiry");
        b6.setBounds(370,525,140,35);
        b6.addActionListener(this);
        ima.add(b6);

        b7 = new JButton("Exit");
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
            System.exit(0);
        } else if (ae.getSource()==b1) {
            setVisible(false);
            new Deposits(pinno).setVisible(true);
        } else if (ae.getSource()==b2) {
            setVisible(false);
            new Withdraw(pinno).setVisible(true);

        } else if (ae.getSource()==b3) {
            setVisible(false);
            new FastCash(pinno).setVisible(true);
        } else if (ae.getSource()==b5) {
            setVisible(false);

            new PinChange(pinno).setVisible(true);

        } else if (ae.getSource()==b6) {
            setVisible(false);
            new BalanceEnquiry(pinno).setVisible(true);
        } else if (ae.getSource()==b4) {
            new MiniStatement(pinno).setVisible(true);

        }


    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
