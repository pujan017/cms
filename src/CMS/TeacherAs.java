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
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class TeacherAs extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherAs frame = new TeacherAs();
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
	public TeacherAs() {
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
		btnNewButton_2.setBounds(74, 173, 205, 33);
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
		btnNewButton_3.setBounds(60, 261, 192, 33);
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
		lblNewLabel_9.setBounds(34, 168, 45, 38);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon(Teacher.class.getResource("/CMS/icon/report (1).png")));
		lblNewLabel_10.setBounds(34, 247, 45, 47);
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
		
		JLabel lblWelcomeBijayKumar = new JLabel("Manage Assignment");
		lblWelcomeBijayKumar.setBounds(52, 41, 391, 42);
		lblWelcomeBijayKumar.setFont(new Font("Times New Roman", Font.BOLD, 35));
		panel_1.add(lblWelcomeBijayKumar);
		
		JLabel lblNewLabel = new JLabel("Issuing Assignment for OOPS:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(352, 168, 414, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblQuestion = new JLabel("Question 1:");
		lblQuestion.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblQuestion.setBounds(352, 270, 109, 20);
		contentPane.add(lblQuestion);
		
		JLabel lblNewLabel_1 = new JLabel("What is Inheritance?");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(352, 311, 200, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Question 2:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(352, 398, 200, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("What is Polymorphism?");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(352, 446, 241, 20);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_5 = new JButton("Upload Assignment");
		btnNewButton_5.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(100, 149, 237)));
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_5.setIcon(new ImageIcon(TeacherAs.class.getResource("/CMS/icon/upload (1).png")));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBounds(332, 548, 231, 50);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Close Portal");
		btnNewButton_6.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(100, 149, 237)));
		btnNewButton_6.setBackground(new Color(255, 255, 255));
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_6.setIcon(new ImageIcon(TeacherAs.class.getResource("/CMS/icon/close (1).png")));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_6.setBounds(746, 550, 200, 50);
		contentPane.add(btnNewButton_6);
	}

}
