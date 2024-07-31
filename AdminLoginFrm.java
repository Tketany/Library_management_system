package libSys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginFrm extends JFrame implements ActionListener {
	JFrame f;
	
	JTextField tf1;
	JPasswordField pf1;
	JButton b;
	
	public AdminLoginFrm() {
		initComponents();
		
	}
	
	
	public void initComponents() {
		JLabel l1=new JLabel("Admin Login Form");
		l1.setBounds(140, 50, 200, 30);
		f=new JFrame("Admin login");
		
		
		JLabel l2=new JLabel("Enter a name:");
		l2.setBounds(30,100, 200, 30 );
		tf1=new JTextField();
		tf1.setBounds(150, 103, 150,25);
		JLabel l3=new JLabel("Enter a password:");
		l3.setBounds(30,150, 150, 30 );
		pf1=new JPasswordField();
		pf1.setBounds(150,153,150,25);
		
		b=new JButton("Login");
		b.setBounds(140, 200,100, 40);
		b.addActionListener(this);
		
		f.add(l1);f.add(l2);f.add(l3);f.add(tf1);f.add(pf1); f.add(b);
		
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
	}
	
public static void main(String[] args) {
		
		new AdminLoginFrm();
	}


@Override
public void actionPerformed(ActionEvent e) {
	String t1=tf1.getText();
	String pw=new String(pf1.getPassword());
	
	if (t1.equals("admin") && pw.equals("admin123")) {
		new Admin_section();
		JOptionPane.showMessageDialog(null, "Welcome Admin");
		f.dispose();
	}
	else if (t1.equals("") || pw.equals("")){
		JOptionPane.showMessageDialog(null, "Please fill out the empty fields");
	}
	else {
		JOptionPane.showMessageDialog(null, "Wrong Username or Password");
	}
	
}

}
