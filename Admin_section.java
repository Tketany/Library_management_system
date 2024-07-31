package libSys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_section extends JFrame implements ActionListener {
	
	static JFrame f;
	static JButton add, view, del, logout;
	
	public Admin_section() {
		initComponents();
	}
	
	public void initComponents() {
		
		f=new JFrame("Admin Section");
		JLabel l1=new JLabel("Admin Section");
		l1.setBounds(150,30, 150, 30);
		
		add=new JButton("Add Librarian");
		add.setBounds(120, 80, 150, 50);
		add.addActionListener(this);
		
		view=new JButton("View Librarian");
		view.setBounds(120, 150, 150, 50);
		view.addActionListener(this);
		
		del=new JButton("Delete Librarian");
		del.setBounds(120, 220, 150, 50);
		del.addActionListener(this);
		
		logout=new JButton("Logout");
		logout.setBounds(120, 290, 150, 50);
		logout.addActionListener(this);
		
		f.add(l1); f.add(add); f.add(del); f.add(logout); f.add(view);
		
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
		
	}
	public static void main(String[] args) {
		new Admin_section();
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==add) {
			new AddLib();
			dispose();
			
		}
		else if (e.getSource()==view) {
			
		}
		else if(e.getSource()==del) {
			new DeleteLib();
			dispose();
			
		}
		else if (e.getSource()==logout) {
			new MainWin();
			f.dispose();
			
		}
	}

}
