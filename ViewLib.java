package libSys;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewLib {
	Connect cx=new Connect();
	JFrame f=new JFrame("View data");
	private JTable table;
    private JScrollPane scrollPane;

    public ViewLib() {
    	initComponents();
    }
    
    public void initComponents() {
    	table = new JTable();
        scrollPane = new JScrollPane(table);
        f.add(scrollPane, BorderLayout.CENTER);

        // Load data from the database and set it to the table
        
    }
	public static void main(String[] args) {
		new ViewLib();

	}

}
