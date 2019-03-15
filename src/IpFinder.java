import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

public class IpFinder implements ActionListener {

    private JButton b;
    private JTextField tf;
    private JLabel l;
    private JFrame f;
    private InetAddress ip;


    IpFinder()
    {
        f = new JFrame("IpFinder");

        l = new JLabel("Enter Url ");
        l.setBounds(40,40,100,30);

        tf = new JTextField();
        tf.setBounds(40,75,180,30);

        b = new JButton("submit");
        b.setBounds(40,140,100,30);

        b.addActionListener(this);

        f.add(l);    f.add(tf);  f.add(b);

        f.setSize(300,300);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setResizable(false);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
            try
            {
                Process process = java.lang.Runtime.getRuntime().exec("ping www.geeksforgeeks.org");
                int x = process.waitFor();
                if (x == 1)  JOptionPane.showMessageDialog(f, "connect to Intenet");
                else
                {
                    ip = InetAddress.getByName(tf.getText());

                    if(tf.getText().equals(""))   throw new Exception();
                    else             JOptionPane.showMessageDialog(f, ip.getHostAddress());
                }
            }
            catch (Exception e1)
            {
                JOptionPane.showMessageDialog(f, "enter valid address");
            }

    }

    public static void main(String[] args){
        new IpFinder();
    }
}
