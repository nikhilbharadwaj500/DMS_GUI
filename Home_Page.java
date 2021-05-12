import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class Home_Page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_Page frame = new Home_Page();
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
	public Home_Page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 500);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDonorManagementSystem = new JLabel("Donor Management System");
		lblDonorManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonorManagementSystem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblDonorManagementSystem.setBounds(145, 24, 404, 59);
		contentPane.add(lblDonorManagementSystem);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(0, 0, 677, 83);
		contentPane.add(panel);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setForeground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				contentPane.setVisible(false);
				dispose();
				
				/* Creating an object for the 2nd frame (Login )  */
				
				Login_S Login = new Login_S();
				Login.setVisible(true);
			}
		});
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSignIn.setBounds(10, 430, 89, 23);
		contentPane.add(btnSignIn);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\NIKHIL BHARADWAJ\\Downloads\\frontEdited.jpg"));
		//lblNewLabel.setIcon(new ImageIcon(Home_Page.class.getResource("frontEdited.jpg")));
		lblNewLabel.setBounds(0, 75, 677, 386);
		contentPane.add(lblNewLabel);
	}
}