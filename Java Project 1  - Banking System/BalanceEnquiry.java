import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pinno;
    JLabel l1;
    JButton b1;
    int bal;
    BalanceEnquiry(String pinno){

        this.pinno = pinno;
        ImageIcon i1 = new ImageIcon("icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon ima = new ImageIcon(i2);
        JLabel image = new JLabel(ima);
        image.setBounds(0,0,900,900);
        add(image);

        b1 = new JButton("Back");
        b1.setBounds(410,565,100,30);
        b1.setFont(new Font("Ariel",Font.BOLD,16));
        b1.addActionListener(this);
        image.add(b1);

        Conn c = new Conn();
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where Pin_no = '" + pinno + "'");
            bal = 0;
            while (rs.next()) {
                if (rs.getString("Type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("Amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("Amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        l1 = new JLabel("Your current balance is Rs "+bal);
        l1.setBounds(200,310,400,40);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Ariel",Font.CENTER_BASELINE,16));
        image.add(l1);



        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }




    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinno).setVisible(true);

    }


    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

}
