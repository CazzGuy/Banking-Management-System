import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
JLabel bank,card,mini,balance;
int bal = 0;
    MiniStatement(String pinno){

        mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);


        bank = new JLabel("State Bank of India");
        bank.setForeground(Color.BLACK);
        bank.setBounds(150,20,400,30);
        bank.setFont(new Font("Ariel",Font.CENTER_BASELINE,25));
        add(bank);

        card = new JLabel();
        card.setFont(new Font("Ariel",Font.BOLD,15));
        card.setBounds(20,90,400,40);
        add(card);

        balance = new JLabel();
        balance.setBounds(20,190,400,200);
        add(balance);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where Pin_no = '"+pinno+"'");
            while (rs.next()){
                card.setText("Card_No =  "+ rs.getString("Card_No").substring(0,5)+"-XXXX-XXXX-"+rs.getString("Card_No").substring(13));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where Pin_no ='"+pinno+"'");
            while (rs.next()){
                mini.setText(mini.getText() +"<html>"+ rs.getString("Date") +" " + rs.getString("Type") +" "+rs.getString("Amount")+"<br><br><html>");
            }

        }catch (Exception e){
            System.out.println(e);
        }

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where Pin_No = '"+pinno+"'");
            while (rs.next()){
                if(rs.getString("Type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("Amount"));
                }else {
                    bal -= Integer.parseInt(rs.getString("Amount"));
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }

        balance.setText("Your Current Balance is " + bal);

        setTitle("Mini Statement");
        setLayout(null);
        setSize(500,500);
        setLocation(0,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);



    }

    public void actionPerformed(ActionEvent ae){

    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
