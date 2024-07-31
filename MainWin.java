package libSys;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MainWin extends JFrame implements ActionListener {
	
	public static Connection c=null;
	public static PreparedStatement pst;
	private final static String url="jdbc:postgresql://localhost:5432/School_management";
	private final static String user="postgres";
	private final static String password="Ketamine";
	
	public static JFrame f;
	public static JButton admin_login;
	public static JButton librarian_login;
	
	
	public MainWin() {
		initComponents();
	}
	
	public void initComponents() {
		f=new JFrame("Library Management");
		
		JLabel l1=new JLabel("Library Management System");
		l1.setBounds(100,0,200,100);
		
		admin_login=new JButton("Admin Login");
		admin_login.setBounds(100, 100, 150, 50);
		admin_login.addActionListener(this);
		
		librarian_login=new JButton("Librarian Login");
		librarian_login.setBounds(100, 170, 150, 50);
		librarian_login.addActionListener(this);
		
		f.add(admin_login); f.add(l1); f.add(librarian_login);
		
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==admin_login) {
		 new AdminLoginFrm();
         f.dispose(); // Hide or dispose of the main window
		}
		else if (e.getSource()==librarian_login) {
			new LibLogin();
			f.dispose();
		}
		
	}
	
	public static void main(String[] args) {
		new MainWin();
	}
	
	
}
