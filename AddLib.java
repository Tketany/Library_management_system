package libSys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AddLib implements ActionListener {
	
	JFrame f;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	JButton addLib, back;
	
	Connect cx=new Connect();
	
	public AddLib() {
		
		initComponents();
		
		
	}

	private void initComponents() {
		f=new JFrame("Add Librarian");
		JLabel l1=new JLabel("ADD LIBRARIAN");
		l1.setBounds(200, 0, 100, 40);
		
		JLabel l2=new JLabel("NAME:");
		l2.setBounds(50, 50, 100, 20);
		
		tf1=new JTextField();
		tf1.setBounds(150, 50, 200,20);
		
		JLabel l3=new JLabel("PASSWORD:");
		l3.setBounds(50, 100, 100, 20);
		
		tf2=new JTextField();
		tf2.setBounds(150, 100, 200,20);
		
		JLabel l4=new JLabel("EMAIL:");
		l4.setBounds(50, 150, 100, 20);
		
		tf3=new JTextField();
		tf3.setBounds(150, 150, 200,20);
		
		JLabel l5=new JLabel("ADDRESS:");
		l5.setBounds(50, 200, 100, 20);
		
		tf4=new JTextField();
		tf4.setBounds(150, 200, 200,20);
		
		JLabel l6=new JLabel("CITY:");
		l6.setBounds(50, 250, 100, 20);
		
		tf5=new JTextField();
		tf5.setBounds(150, 250, 200,20);
		
		JLabel l7=new JLabel("CONTACT NO:");
		l7.setBounds(50, 300, 100, 20);
		
		tf6=new JTextField();
		tf6.setBounds(150, 300, 200,20);
		
		
		addLib=new JButton("Add Librarian");
		addLib.setBounds(170, 350, 130, 40);
		addLib.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(195, 400, 80,40);
		back.addActionListener(this);
		
		
		f.add(l1); f.add(l2); f.add(l3); f.add(l4); f.add(l5); f.add(l6); f.add(l7);
		f.add(tf1); f.add(tf2); f.add(tf3); f.add(tf4); f.add(tf5); f.add(tf6);
		f.add(addLib); f.add(back);
		
		f.setSize(500,500);
		f.setLayout(null);
		f.setVisible(true);
		
	}

	public static void main(String[] args) {
		new AddLib();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==back) {
			new Admin_section();
			f.dispose();
			
		}
		else if(e.getSource()==addLib) {
			String name=tf1.getText();
			String pass=tf2.getText();
			String em=tf3.getText();
			String ad=tf4.getText();
			String city=tf5.getText();
			String contact= tf6.getText();
			
			cx.insertIntoDB(name, pass, em, ad, city, contact);
			
		}
		
	}

}
