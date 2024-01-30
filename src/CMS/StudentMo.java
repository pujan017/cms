package CMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class StudentMo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMo frame = new StudentMo();
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
	public StudentMo() {
		setTitle("Student Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1034, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1034, 690);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modules Available");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel.setBounds(349, 28, 351, 51);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(0, 0, 289, 659);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(Student.class.getResource("/CMS/icon/dashboard (1).png")));
		lblNewLabel_6.setBounds(22, 54, 45, 41);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(Student.class.getResource("/CMS/icon/teachers-day (1).png")));
		lblNewLabel_7.setBounds(22, 118, 45, 41);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Student.class.getResource("/CMS/icon/training (1).png")));
		lblNewLabel_8.setBounds(22, 187, 45, 41);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon(Student.class.getResource("/CMS/icon/assignment (1).png")));
		lblNewLabel_9.setBounds(22, 261, 45, 41);
		panel_1.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton.setBorderPainted(false); 
		btnNewButton.setContentAreaFilled(false); 
        btnNewButton.setFocusPainted(false); 
        btnNewButton.setOpaque(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new StudentDa().setVisible(true);
			    
			}
		});
		btnNewButton.setBounds(46, 54, 205, 30);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Teachers");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_1.setBorderPainted(false); 
		btnNewButton_1.setContentAreaFilled(false); 
        btnNewButton_1.setFocusPainted(false); 
        btnNewButton_1.setOpaque(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new StudentTe().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(33, 129, 205, 30);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modules");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_2.setBorderPainted(false); 
		btnNewButton_2.setContentAreaFilled(false); 
        btnNewButton_2.setFocusPainted(false); 
        btnNewButton_2.setOpaque(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new StudentMo().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(33, 198, 205, 30);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Assignment");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_3.setBorderPainted(false); 
		btnNewButton_3.setContentAreaFilled(false); 
        btnNewButton_3.setFocusPainted(false); 
        btnNewButton_3.setOpaque(false);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new StudentAs().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(46, 272, 205, 30);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Log Out");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBorderPainted(false); 
		btnNewButton_4.setContentAreaFilled(false); 
        btnNewButton_4.setFocusPainted(false); 
        btnNewButton_4.setOpaque(false);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_4) {
					int a=JOptionPane.showConfirmDialog(contentPane,"Are you sure?");
				    if(a==JOptionPane.YES_OPTION) {
				    	dispose();
				    	Login obj=new Login();
				    	obj.setVisible(true);
				    }
				
				}
				
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_4.setBounds(33, 549, 205, 30);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Marks");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new StudentMa().setVisible(true);
			}
		});
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_5.setBorderPainted(false); 
		btnNewButton_5.setContentAreaFilled(false); 
        btnNewButton_5.setFocusPainted(false); 
        btnNewButton_5.setOpaque(false);
		btnNewButton_5.setBounds(22, 350, 205, 30);
		panel_1.add(btnNewButton_5);
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setIcon(new ImageIcon(Student.class.getResource("/CMS/icon/training (1).png")));
		lblNewLabel_15.setBounds(22, 339, 45, 41);
		panel_1.add(lblNewLabel_15);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(Student.class.getResource("/CMS/icon/logout2 (1).png")));
		lblNewLabel_10.setBounds(22, 538, 41, 41);
		panel_1.add(lblNewLabel_10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(288, 0, 736, 112);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(288, 110, 736, 549);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		table = new JTable();
		table.setBounds(368, 5, 0, 0);
		panel_3.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBorder(new LineBorder(new Color(100, 149, 237), 3));
		scrollPane.setBounds(10, 45, 691, 221);
		panel_3.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JButton btnNewButton_6 = new JButton("Update");
		btnNewButton_6.setForeground(new Color(0, 0, 0));
		btnNewButton_6.setBackground(new Color(100, 149, 237));
		btnNewButton_6.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_6.setIcon(new ImageIcon(StudentMo.class.getResource("/CMS/icon/system-update (1).png")));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				String Username = "root";
				String Passwords = "";
				String url = "jdbc:mysql://localhost:3306/cms";
				
				try {
					// making the connections
					con = DriverManager.getConnection(url, Username, Passwords);
					Statement st = (Statement) con.createStatement();
					String selectQuery = "SELECT * FROM addcourse";
//					ResultSet rs = ((java.sql.Statement) st).executeQuery(selectQuery);
					ResultSet rs = st.executeQuery(selectQuery);
					// method for getData form the database.
					ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
					
					//created a DefaultTable object
					DefaultTableModel mode  = new DefaultTableModel();
					int columnCount = rsmd.getColumnCount();
					//using for loop to add the columns and rows
					for(int i = 1; i<=columnCount; i++) {
						mode.addColumn(rsmd.getColumnName(i));
					}
					while (rs.next()) {
						Object[]row = new Object[columnCount];
						// for loop to count the rows
						for(int i=1; i<=columnCount; i++) {
							row[i-1] = rs.getObject(i);
						}
						mode.addRow(row);
					}
					table_1.setModel(mode);
					con.close();
					
				}
				catch(SQLException e1) {
					System.out.println(e1);
				}
			}
				
				
			
		});
		btnNewButton_6.setBounds(457, 307, 218, 51);
		panel_3.add(btnNewButton_6);
	}
}
