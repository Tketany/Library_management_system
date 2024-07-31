package libSys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Connect {
	PreparedStatement pst;
    private static final String URL = "jdbc:postgresql://localhost:5432/Library_management";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Ketamine";

    private Connection connection = null;
    
    private JTable table;

    public Connect() {
        connectToDB();
    }

    private void connectToDB() {
        try {
            
            Class.forName("org.postgresql.Driver");

            
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);

//            JOptionPane.showMessageDialog(null, "Opened Database Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Driver not found: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Unknown Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                JOptionPane.showMessageDialog(null, "Connection Closed", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to close connection: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void deleteFromDB(int id) {
    	try {
			String sql="DELETE FROM librarians WHERE lib_id= ? ";
			pst=connection.prepareStatement(sql);
	        pst.setInt(1, id); // Set the phone number
	        
	        int rowsInserted = pst.executeUpdate();
	        if (rowsInserted > 0) {
	            JOptionPane.showMessageDialog(null,"Student deleted successfully!" ,"message" , JOptionPane.INFORMATION_MESSAGE);
	        }
	        else {
	            JOptionPane.showMessageDialog(null, "No student found with the provided name.", "message", JOptionPane.INFORMATION_MESSAGE);
	        }

	        // Commit the transaction
	        connection.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, this, "Error deleting data: " + ex.getMessage(), id);
		}
		finally {
			 try {
		            // Close the PreparedStatement
		            if (pst != null) pst.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		}
    }
    
   
    public void insertIntoDB(String n, String p, String e, String a, String c, String cn ) {
    	
		try {
			String sql="INSERT INTO librarians(lib_name, lib_password, lib_email, lib_address, lib_city, lib_contact)"+
					"values(?,?,?,?,?,?)";
			pst=connection.prepareStatement(sql);
			pst.setString(1, n); // Set the name
	        pst.setString(2, p); // Set the pass
	        pst.setString(3, e); // set email
	        pst.setString(4, a); // Set the address
	        pst.setString(5, c); // Set the city
	        pst.setString(6, cn);// set contact number
	        
	        
	        int rowsInserted = pst.executeUpdate();
	        if (rowsInserted > 0) {
	            JOptionPane.showMessageDialog(null, "A new student has been inserted successfully!", "message" , JOptionPane.INFORMATION_MESSAGE);
	        }

	        // Commit the transaction
	        connection.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, this, "Error inserting data: " + ex.getMessage(), 0);
		}
		finally {
			 try {
		            
		            if (pst != null) pst.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		}
    }
    

    public static void main(String[] args) {
//        Connect connect = new Connect();
        // Perform database operations
        //connect.closeConnection();
    }
}
