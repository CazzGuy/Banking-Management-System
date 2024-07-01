import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposits extends JFrame implements ActionListener {
     JLabel ima,l1;
     JTextField t1;
     JButton b1,b2;
     String pinno;
    Deposits(String pinno){
        this.pinno = pinno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        ima = new JLabel(i3);
        ima.setBounds(0,0,900,900);
        add(ima);


        l1 = new JLabel("Please enter the amount you want to deposit");
        l1.setBounds(160,290,400,40);
        l1.setFont(new Font("Arial",Font.BOLD,15));
        l1.setForeground(Color.white);
        ima.add(l1);

        t1 = new JTextField();
        t1.setBounds(160,370,250,30);
        t1.setBackground(Color.WHITE);
        ima.add(t1);

        b1 = new JButton("Deposit");
        b1.setBounds(400,500,100,30);
        b1.addActionListener(this);
        ima.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(400,540,100,30);
        b2.addActionListener(this);
        ima.add(b2);

        setSize(900,900);
        setLocation(350,00);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try {
                Date d = new Date();
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter a amount");
                } else  {
                    Conn c = new Conn();
                    String query = "insert into bank values('"+pinno+"','"+d+"','Deposit','"+t1.getText()+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+t1.getText()+" is deposited.");
                    setVisible(false);
                    new Transaction(pinno).setVisible(true);
                }
            }catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource()==b2) {
            setVisible(false);
            new Transaction(pinno).setVisible(true);

        }
    }

    public static void main(String[] args) {
        new Deposits("");
    }

}
