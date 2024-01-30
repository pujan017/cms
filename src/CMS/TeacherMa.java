package CMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.DefaultComboBoxModel;

public class TeacherMa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	  private JComboBox<String> comboBoxModule;
	    private JComboBox<String> comboBoxStudentID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherMa frame = new TeacherMa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    private void issueMarks() {
        String module = (String) comboBoxModule.getSelectedItem();
        String studentID = (String) comboBoxStudentID.getSelectedItem();
        String marks = textField.getText();

        // Update the addstudent table with the entered marks
        boolean success = updateMarksToDatabase(studentID, module, marks);

        if (success) {
            JOptionPane.showMessageDialog(contentPane, "Marks issued successfully!");
        } else {
            JOptionPane.showMessageDialog(contentPane, "Failed to issue marks. Please try again.");
        }
    }
	public TeacherMa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1034, 690);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 289, 664);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TeacherDa().setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton.setBounds(60, 82, 205, 25);
		btnNewButton.setBorderPainted(false); 
		btnNewButton.setContentAreaFilled(false); 
		btnNewButton.setFocusPainted(false); 
		btnNewButton.setOpaque(false);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Assignement");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TeacherAs().setVisible(true);
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_2.setBounds(74, 165, 205, 33);
		btnNewButton_2.setBorderPainted(false); 
		btnNewButton_2.setContentAreaFilled(false); 
		btnNewButton_2.setFocusPainted(false); 
		btnNewButton_2.setOpaque(false);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Marking");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TeacherMa().setVisible(true);
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_3.setBounds(47, 244, 205, 33);
		btnNewButton_3.setBorderPainted(false); 
		btnNewButton_3.setContentAreaFilled(false); 
		btnNewButton_3.setFocusPainted(false); 
		btnNewButton_3.setOpaque(false);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Log Out");
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
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_4.setBounds(47, 573, 205, 33);
		btnNewButton_4.setBorderPainted(false); 
		btnNewButton_4.setContentAreaFilled(false); 
		btnNewButton_4.setFocusPainted(false); 
		btnNewButton_4.setOpaque(false);
		panel.add(btnNewButton_4);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(Teacher.class.getResource("/CMS/icon/dashboard (1).png")));
		lblNewLabel_7.setBounds(34, 60, 45, 47);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon(Teacher.class.getResource("/CMS/icon/assignment (1).png")));
		lblNewLabel_9.setBounds(34, 160, 45, 38);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon(Teacher.class.getResource("/CMS/icon/report (1).png")));
		lblNewLabel_10.setBounds(34, 242, 45, 47);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setIcon(new ImageIcon(Teacher.class.getResource("/CMS/icon/logout2 (1).png")));
		lblNewLabel_11.setBounds(34, 559, 45, 47);
		panel.add(lblNewLabel_11);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(287, 0, 733, 112);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblWelcomeBijayKumar = new JLabel("Issue Marks");
		lblWelcomeBijayKumar.setBounds(52, 41, 391, 42);
		lblWelcomeBijayKumar.setFont(new Font("Times New Roman", Font.BOLD, 35));
		panel_1.add(lblWelcomeBijayKumar);
		
		JLabel lblNewLabel_1 = new JLabel("Issue Marks For:");
		lblNewLabel_1.setBounds(332, 151, 226, 35);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JLabel lblNewLabel = new JLabel("Student ID:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(334, 269, 108, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Marks:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(332, 418, 123, 20);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(100, 149, 237)));
		textField.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textField.setBounds(472, 420, 274, 25);
		contentPane.add(textField);
		textField.setColumns(10);

		
		
        // Initialize JComboBox for module selection
        comboBoxModule = new JComboBox<>();
        comboBoxModule.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(100, 149, 237)));
        comboBoxModule.setBackground(new Color(255, 255, 255));
        comboBoxModule.setFont(new Font("Times New Roman", Font.BOLD, 15));
        comboBoxModule.setModel(new DefaultComboBoxModel<>(new String[]{"L4M1", "L4M2", "L4M3", "L5M1", "L5M2", "L5M3", "L6M1", "L6M2", "L6M3"}));
        comboBoxModule.setBounds(568, 162, 274, 25);
        contentPane.add(comboBoxModule);

        // Initialize JComboBox for student ID selection
        comboBoxStudentID = new JComboBox<>();
        comboBoxStudentID.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
        comboBoxStudentID.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(100, 149, 237)));
        comboBoxStudentID.setBackground(new Color(255, 255, 255));
        comboBoxStudentID.setFont(new Font("Times New Roman", Font.BOLD, 15));
        comboBoxStudentID.setBounds(472, 269, 274, 25);
        contentPane.add(comboBoxStudentID);

        JButton btnNewButton_5 = new JButton("Issue Marks");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                issueMarks();
            }
        });
		btnNewButton_5.setBorder(null);
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(100, 149, 237));
		btnNewButton_5.setBounds(737, 542, 200, 45);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_4 = new JLabel("Module Name:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(332, 344, 132, 20);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(100, 149, 237)));
		comboBox_2.setBackground(new Color(255, 255, 255));
		comboBox_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"BCS", "BIBM"}));
		comboBox_2.setBounds(472, 344, 274, 25);
		contentPane.add(comboBox_2);
	}
	
	private boolean updateMarksToDatabase(String studentID, String module, String marks) {
	    String url = "jdbc:mysql://localhost:3306/cms";
	    String username = "root";
	    String password = "";

	    try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        // Construct the SQL query based on the selected module
	        String updateQuery = "UPDATE addstudent SET " + module + " = ? WHERE id = ?";
	        
	        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
	            statement.setString(1, marks);
	            statement.setString(2, studentID);

	            int rowsUpdated = statement.executeUpdate();

	            return rowsUpdated > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
}
