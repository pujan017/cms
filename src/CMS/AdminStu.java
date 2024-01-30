package CMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;


public class AdminStu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	String Username = "root";
	String Passwords = "";
	String url = "jdbc:mysql://localhost:3306/cms";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminStu frame = new AdminStu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminStu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1034, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 4, 4, (Color) new Color(100, 149, 237)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1030, 664);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(-18, -22, 307, 675);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_6 = new JButton("Dashboard");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminDa().setVisible(true);
			}
		});
		btnNewButton_6.setBounds(72, 80, 205, 30);
		btnNewButton_6.setOpaque(false);
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_6.setFocusPainted(false);
		btnNewButton_6.setContentAreaFilled(false);
		btnNewButton_6.setBorderPainted(false);
		panel_1.add(btnNewButton_6);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(229, 25, 1, 1);
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(100, 149, 237));
		panel_1.add(panel_1_1);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(22, 54, 45, 41);
		panel_1_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(22, 118, 45, 41);
		panel_1_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(22, 187, 45, 41);
		panel_1_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(22, 261, 45, 41);
		panel_1_1.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.setOpaque(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(46, 54, 205, 30);
		panel_1_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Teachers");
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(33, 129, 205, 30);
		panel_1_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modules");
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBounds(33, 198, 205, 30);
		panel_1_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Assignment");
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBounds(46, 272, 205, 30);
		panel_1_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Log Out");
		btnNewButton_4.setOpaque(false);
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_4.setFocusPainted(false);
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBounds(33, 549, 205, 30);
		panel_1_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Marks");
		btnNewButton_5.setOpaque(false);
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_5.setFocusPainted(false);
		btnNewButton_5.setContentAreaFilled(false);
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setBounds(22, 350, 205, 30);
		panel_1_1.add(btnNewButton_5);
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setBounds(22, 339, 45, 41);
		panel_1_1.add(lblNewLabel_15);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setBounds(22, 538, 41, 41);
		panel_1_1.add(lblNewLabel_10);
		
		JButton btnNewButton_1_1 = new JButton("Teachers");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminTe().setVisible(true);
			}
		});
		btnNewButton_1_1.setOpaque(false);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_1_1.setFocusPainted(false);
		btnNewButton_1_1.setContentAreaFilled(false);
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBounds(60, 157, 205, 30);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_4_1 = new JButton("Log Out");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_4_1) {
					int a=JOptionPane.showConfirmDialog(contentPane,"Are you sure?");
				    if(a==JOptionPane.YES_OPTION) {
				    	dispose();
				    	Login obj=new Login();
				    	obj.setVisible(true);
				    }
				
				}
			}
		});
		btnNewButton_4_1.setOpaque(false);
		btnNewButton_4_1.setForeground(Color.WHITE);
		btnNewButton_4_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_4_1.setFocusPainted(false);
		btnNewButton_4_1.setContentAreaFilled(false);
		btnNewButton_4_1.setBorderPainted(false);
		btnNewButton_4_1.setBounds(60, 579, 205, 30);
		panel_1.add(btnNewButton_4_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("New label");
		lblNewLabel_6_1.setIcon(new ImageIcon(Admin.class.getResource("/CMS/icon/dashboard (1).png")));
		lblNewLabel_6_1.setBounds(42, 63, 45, 41);
		panel_1.add(lblNewLabel_6_1);
		
		JButton btnNewButton_7 = new JButton("Students");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminStu().setVisible(true);
			}
		});
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_7.setBounds(60, 231, 205, 30);
		btnNewButton_7.setBorderPainted(false); 
		btnNewButton_7.setContentAreaFilled(false); 
        btnNewButton_7.setFocusPainted(false); 
        btnNewButton_7.setOpaque(false);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Courses");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminCo().setVisible(true);
			}
		});
		btnNewButton_8.setForeground(new Color(255, 255, 255));
		btnNewButton_8.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_8.setBounds(60, 301, 205, 30);
		btnNewButton_8.setBorderPainted(false); 
		btnNewButton_8.setContentAreaFilled(false); 
        btnNewButton_8.setFocusPainted(false); 
        btnNewButton_8.setOpaque(false);
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Report");
		btnNewButton_9.setForeground(new Color(255, 255, 255));
		btnNewButton_9.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_9.setBorderPainted(false); 
		btnNewButton_9.setContentAreaFilled(false); 
        btnNewButton_9.setFocusPainted(false); 
        btnNewButton_9.setOpaque(false);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminRe().setVisible(true);
			}
		});
		btnNewButton_9.setBounds(49, 366, 205, 30);
		panel_1.add(btnNewButton_9);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Admin.class.getResource("/CMS/icon/teachers-day (1).png")));
		lblNewLabel.setBounds(42, 143, 45, 44);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Admin.class.getResource("/CMS/icon/graduated (1).png")));
		lblNewLabel_1.setBounds(42, 217, 45, 44);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Admin.class.getResource("/CMS/icon/homework (1).png")));
		lblNewLabel_2.setBounds(42, 286, 45, 41);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Admin.class.getResource("/CMS/icon/report (1).png")));
		lblNewLabel_3.setBounds(42, 352, 45, 45);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Admin.class.getResource("/CMS/icon/logout2 (1).png")));
		lblNewLabel_5.setBounds(42, 568, 45, 41);
		panel_1.add(lblNewLabel_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(289, 0, 731, 112);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblWelcomeAdmin = new JLabel("Manage Students");
		lblWelcomeAdmin.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblWelcomeAdmin.setBounds(67, 26, 351, 51);
		panel_2.add(lblWelcomeAdmin);
		
		JButton btnNewButton_10 = new JButton("Add");
		btnNewButton_10.setBorder(new MatteBorder(1, 1, 4, 4, (Color) new Color(100, 149, 237)));
		btnNewButton_10.setBackground(new Color(255, 255, 255));
		btnNewButton_10.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_10.setIcon(new ImageIcon(AdminTe.class.getResource("/CMS/icon/add-button (1).png")));
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AdminAddStu().setVisible(true);
				
			}
		});
		btnNewButton_10.setBounds(371, 168, 170, 46);
		panel.add(btnNewButton_10);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(255, 255, 255));
		editorPane.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
		editorPane.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		editorPane.setBounds(680, 272, 106, 46);
		panel.add(editorPane);
		
		JButton btnNewButton_11 = new JButton("Search");
		btnNewButton_11.setBorder(new MatteBorder(1, 1, 4, 4, (Color) new Color(100, 149, 237)));
		btnNewButton_11.setBackground(new Color(255, 255, 255));
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11.setIcon(new ImageIcon(AdminTe.class.getResource("/CMS/icon/search (1).png")));
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchTerm = editorPane.getText().trim();
		        if (!searchTerm.isEmpty()) {
		            searchTable(searchTerm);
		        } else {
		            // If the search term is empty, reload the entire table
		            populateTable();
		        }
				
			}
		});
		btnNewButton_11.setBounds(788, 272, 144, 46);
		panel.add(btnNewButton_11);
		
		
		
		JButton btnNewButton_12 = new JButton("Update");
		btnNewButton_12.setBorder(new MatteBorder(1, 1, 4, 4, (Color) new Color(100, 149, 237)));
		btnNewButton_12.setBackground(new Color(255, 255, 255));
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_12.setIcon(new ImageIcon(AdminTe.class.getResource("/CMS/icon/system-update (1).png")));
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AdminUpStu().setVisible(true);
			}
		});
		btnNewButton_12.setBounds(371, 272, 170, 46);
		panel.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("Delete");
		btnNewButton_13.setBorder(new MatteBorder(1, 1, 4, 4, (Color) new Color(100, 149, 237)));
		btnNewButton_13.setBackground(new Color(255, 255, 255));
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_13.setIcon(new ImageIcon(AdminTe.class.getResource("/CMS/icon/delete-document (1).png")));
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminDelStu().setVisible(true);
			}
		});
		btnNewButton_13.setBounds(712, 168, 170, 46);
		panel.add(btnNewButton_13);
		
		
	       
	       JScrollPane scrollPane = new JScrollPane();
	       scrollPane.setBounds(334, 370, 622, 244);
	       panel.add(scrollPane);
	       scrollPane.setOpaque(false);
		
	       table = new JTable();
	       scrollPane.setViewportView(table);
	       table.setOpaque(false);

	        // Populate the table with data from the database
	        populateTable();
	}
	
	
	 private void populateTable() {
	        try (Connection con = DriverManager.getConnection(url, Username, Passwords)) {
	            String selectQuery = "SELECT `id`, `Email`, `Student Name` , `Phone Number`, `Module Name` FROM addstudent";

	            try (PreparedStatement pst = con.prepareStatement(selectQuery);
	                 ResultSet rs = pst.executeQuery()) {

	                // Create a DefaultTableModel to store the data
	                DefaultTableModel model = new DefaultTableModel();

	                // Get the metadata of the result set
	                ResultSetMetaData rsmd = rs.getMetaData();

	                // Get the number of columns in the result set
	                int columnCount = rsmd.getColumnCount();

	                // Add column names to the model
	                for (int i = 1; i <= columnCount; i++) {
	                    model.addColumn(rsmd.getColumnName(i));
	                }

	                // Add rows to the model
	                while (rs.next()) {
	                    Object[] row = new Object[columnCount];
	                    for (int i = 1; i <= columnCount; i++) {
	                        row[i - 1] = rs.getObject(i);
	                    }
	                    model.addRow(row);
	                }

	                // Set the model to the JTable
	                table.setModel(model);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 private void searchTable(String searchTerm) {
		    try (Connection con = DriverManager.getConnection(url, Username, Passwords)) {
		    	String selectQuery = "SELECT `id`, `Email`, `Student Name`, `Phone Number`, `Module Name` FROM addstudent WHERE `Student Name` LIKE ?";


		        try (PreparedStatement pst = con.prepareStatement(selectQuery)) {
		            // Use "%" to match any characters before and after the search term
		        	 pst.setString(1, searchTerm + "%");

		            try (ResultSet rs = pst.executeQuery()) {
		                // Create a DefaultTableModel to store the data
		                DefaultTableModel model = new DefaultTableModel();

		                // Get the metadata of the result set
		                ResultSetMetaData rsmd = rs.getMetaData();

		                // Get the number of columns in the result set
		                int columnCount = rsmd.getColumnCount();

		                // Add column names to the model
		                for (int i = 1; i <= columnCount; i++) {
		                    model.addColumn(rsmd.getColumnName(i));
		                }

		                // Add rows to the model
		                while (rs.next()) {
		                    Object[] row = new Object[columnCount];
		                    for (int i = 1; i <= columnCount; i++) {
		                        row[i - 1] = rs.getObject(i);
		                    }
		                    model.addRow(row);
		                }

		                // Set the model to the JTable
		                table.setModel(model);
		            }
		        }

		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		}
	}

	

