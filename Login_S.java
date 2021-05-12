import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

//import after_login.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;

public class Login_S extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_S frame = new Login_S();
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
	public Login_S() {
		JFrame frame=new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 500);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOrganBankLogin = new JLabel("Organ Bank Login");
		lblOrganBankLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrganBankLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblOrganBankLogin.setBounds(209, 28, 305, 40);
		contentPane.add(lblOrganBankLogin);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 102, 0));
		panel.setBounds(0, 0, 677, 68);
		contentPane.add(panel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBackground(Color.WHITE);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(126, 149, 103, 21);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(126, 237, 91, 21);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(270, 151, 244, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(270, 239, 244, 20);
		contentPane.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(135, 206, 250));
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String password=txtPassword.getText();
				String username=txtUsername.getText();
				if(password.contains("nikhil") && username.contains("EWIT")) 
				{
					JOptionPane.showMessageDialog(null, "Login Successfull !!");
					txtPassword.setText(null);
					txtUsername.setText(null);
					
					contentPane.setVisible(false);
					dispose();
					
					/* Creating an object for the 2nd frame (Register)  */
					After_login after_login = new After_login();
					after_login.setVisible(true);

				}
				else
				{
					
						JOptionPane.showMessageDialog(null,"Invalid login Details", "Login Error",JOptionPane.ERROR_MESSAGE);
						txtPassword.setText(null);
						txtUsername.setText(null);
						return;
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.setBounds(58, 361, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(0, 0, 0));
		btnReset.setBackground(new Color(135, 206, 235));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				txtUsername.setText(null);
				txtPassword.setText(null);

			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset.setBounds(266, 361, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(0, 0, 0));
		btnExit.setBackground(new Color(169, 169, 169));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frmDonor_Login = new JFrame("Exit");
				
				
				
				if(JOptionPane.showConfirmDialog(frmDonor_Login,"Confirm if u want to exit","Donor_Logins",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExit.setBounds(478, 361, 89, 23);
		contentPane.add(btnExit);
	}
}