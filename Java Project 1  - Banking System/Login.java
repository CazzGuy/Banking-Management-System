import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    private int height;
    private int width;
    JButton loginin,signup,clear;
    JTextField text;
    JPasswordField num;

    Login(int h ,int w){
        setLayout(null);
        height = h;
        width = w;
        setTitle("Automated Teller Machine");
        ImageIcon ig1 = new ImageIcon("icons/logo.jpg");
        Image i = ig1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon atm_logo = new ImageIcon(i);
        JLabel label = new JLabel(atm_logo);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel welcome_msg = new JLabel("Welcome to Atm");
        welcome_msg.setBounds(170,50,400,40);
        welcome_msg.setFont(new Font("Times New Roman",Font.BOLD | Font.ITALIC,40));
        add(welcome_msg);

        JLabel card = new JLabel("Card No : ");
        card.setBounds(170,150,400,40);
        card.setFont(new Font("Courier",Font.BOLD | Font.ITALIC,29));
        add(card);

        text = new JTextField();
        text.setBounds(320,160,225,30);
        add(text);

        JLabel pin = new JLabel("Pin NO : ");
        pin.setBounds(170,200,400,40);
        pin.setFont(new Font("Courier",Font.BOLD | Font.ITALIC,29));
        add(pin);

        num = new JPasswordField();
        num.setBounds(320,210,225,30);
        add(num);

        loginin = new JButton("Sign in");
        loginin.setBounds(320,270,90,30);
        loginin.setBackground(Color.BLACK);
        loginin.addActionListener(this);
        loginin.setForeground(Color.white);
        add(loginin);

        clear = new JButton("Clear");
        clear.setBounds(450,270,90,30);
        clear.setBackground(Color.BLACK);
        clear.addActionListener(this);
        clear.setForeground(Color.white);
        add(clear);

        signup = new JButton("Sign Up");
        signup.setBounds(320,320,220,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);


        getContentPane().setBackground(Color.WHITE);
        setSize(h,w);
        setLocation(350,200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==clear){
            text.setText("");
            num.setText("");
        } else if (ae.getSource()==loginin) {
            Conn c = new Conn();
            String cardno = text.getText();
            String pinno = num.getText();
            String query = "select * from login where Card_no = '"+cardno+"' and Pin_no = '"+pinno+"'";
            try {
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinno).setVisible(true);
                }else {
                 JOptionPane.showMessageDialog(null,"Incorrect Card number or pin");
                }
            }catch (Exception e){
                System.out.println(e);
            }
            
        } else if (ae.getSource()==signup) {
            setVisible(false);
            new Signin ().setVisible(true);
            
        }

    }



    public static void main(String[] args) {
        Login lg = new Login(800,480);

    }
}
