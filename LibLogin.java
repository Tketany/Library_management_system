package libSys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LibLogin {
	JFrame f=new JFrame("Librarian Login Form");
	JButton login;
	JTextField tf1;
	JPasswordField pw;
	
	public LibLogin() {
		initComponents();
	}
	
	public void initComponents() {
		JLabel lb1=new JLabel("Enter Name:");
		JLabel lb2=new JLabel("Enter password:");
		JLabel lb3=new JLabel("LIBRARIAN LOGIN FORM");
		
		lb1.setBounds(50, 100, 100, 20);
		lb2.setBounds(50,150,100,20);
		lb3.setBounds(130,50,150,20);
		
		tf1=new JTextField();
		tf1.setBounds(150, 100, 150,25);
		
		pw=new JPasswordField();
		pw.setBounds(150, 150, 150,25);
		login=new JButton("LOGIN");
		login.setBounds(150,200, 80, 40);
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name=tf1.getText();
				String p=new String(pw.getPassword());
				
				
				
			}
		});
		
		f.add(lb2); f.add(lb1); f.add(lb3); f.add(tf1); f.add(pw);
		f.add(login);
		
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new LibLogin();

	}

}
