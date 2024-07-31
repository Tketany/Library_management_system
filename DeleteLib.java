package libSys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DeleteLib implements ActionListener{
	
	static JFrame f;
	static JTextField tf;
	static JButton del, back;
	static Connect cx=new Connect();
	
	public DeleteLib() {
		initComponents();

	}
	
	public void initComponents() {
		f=new JFrame("delete Librarian");
		JLabel l1=new JLabel("Enter id");
		l1.setBounds(50, 95, 100,30);
		
		tf=new JTextField();
		tf.setBounds(150, 100, 200, 20);
		
		del=new JButton("DELETE");
		del.setBounds(200, 150, 100, 40 );
		del.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(10,10, 70, 30);
		
		f.add(l1); f.add(tf); f.add(del); f.add(back);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
		
		
	}


	public static void main(String[] args) {
		new DeleteLib();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s1=tf.getText();
		
		if (e.getSource()==back) {
			new Admin_section();
			f.dispose();
		}
		else if (e.getSource()==del) {
			int a=Integer.parseInt(s1);
			cx.deleteFromDB(a);
		}
	}

}
