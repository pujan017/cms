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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Student extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static String username;
	private JLabel lblNewLabel_4_1;
	private JLabel lblNewLabel_4_1_1;
	private JLabel lblNewLabel_6_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student(username);
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
	public Student(String username) {
		this.username = username;
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
		
		JLabel lblNewLabel = new JLabel("Welcome, Student");
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
		
		JLabel lblNewLabel_1 = new JLabel("Your Details:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(349, 159, 200, 30);
		panel.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new LineBorder(new Color(100, 149, 237), 3));
		panel_3.setBounds(349, 229, 618, 315);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
//		JLabel lblNewLabel_5 = new JLabel("");
//		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 25));
//		lblNewLabel_5.setBounds(234, 177, 203, 25);
//		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6_1 = new JLabel("");
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_6_1.setBounds(189, 227, 125, 25);
		panel_3.add(lblNewLabel_6_1);
		
//		JLabel lblNewLabel_4 = new JLabel("");
//		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
//		lblNewLabel_4.setBounds(234, 52, 203, 25);
//		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_4_1.setBounds(201, 102, 203, 25);
		panel_3.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("");
		lblNewLabel_4_1_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_4_1_1.setBounds(201, 165, 203, 25);
		panel_3.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Student Name:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(54, 102, 138, 25);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(54, 165, 138, 25);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Module Name:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(54, 227, 138, 25);
		panel_3.add(lblNewLabel_4);
		
//		JLabel lblNewLabel_4_1_2 = new JLabel("");
//		lblNewLabel_4_1_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
//		lblNewLabel_4_1_2.setBounds(234, 239, 203, 25);
//		panel_3.add(lblNewLabel_4_1_2);
		
		
	
	
		try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root",
                    "");

            String query = "SELECT Username, phone_number, Course FROM signup WHERE Username = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("Username");
                String phoneNumber = resultSet.getString("phone_number");
                String module = resultSet.getString("Course");

                lblNewLabel_4_1.setText(name);
                lblNewLabel_4_1_1.setText(phoneNumber);
                lblNewLabel_6_1.setText(module);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
