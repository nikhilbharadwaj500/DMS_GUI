
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
//import Organs_Available.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import Donor_list.Donor;
//import Register_Sys.*;
//import Patients.*;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Color;


public class After_login extends JFrame 
{
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					After_login frame = new After_login();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public After_login() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 500);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeXyz = new JLabel("Welcome EWIT,");
		lblWelcomeXyz.setFont(new Font("Arial Black", Font.BOLD, 24));
		lblWelcomeXyz.setBounds(21, 35, 325, 35);
		contentPane.add(lblWelcomeXyz);
		
		JButton btnNewRegister = new JButton("New Donor  Register");
		btnNewRegister.setBackground(new Color(102, 255, 255));
		btnNewRegister.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewRegister.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				
				contentPane.setVisible(false);
				dispose();
				
				/* Creating an object for the 2nd frame (Register)  */
				
				Register_Sys Regsiter = new Register_Sys();
				Regsiter.setVisible(true);

			}
		});
		btnNewRegister.setBounds(71, 166, 220, 54);
		contentPane.add(btnNewRegister);
		
		JButton btnPatients = new JButton("Patients List");
		btnPatients.setBackground(new Color(0, 255, 255));
		btnPatients.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				
				
				contentPane.setVisible(false);
				dispose();
				
				/* Creating an object for the 2nd frame (Register)  */
				
				Patient  list = new Patient();
				list.setVisible(true);	
			}
		});
		btnPatients.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPatients.setBounds(362, 166, 265, 54);
		contentPane.add(btnPatients);
		
		JButton btnViewAvailableOrgans = new JButton("View Available Organs");
		btnViewAvailableOrgans.setBackground(new Color(0, 255, 255));
		btnViewAvailableOrgans.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				contentPane.setVisible(false);
				dispose();
				
				/* Creating an object for the 2nd frame (Register)  */
				
				Organs view = new Organs();
				view.setVisible(true);	
				
			}
		});
		btnViewAvailableOrgans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnViewAvailableOrgans.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewAvailableOrgans.setBounds(71, 305, 221, 54);
		contentPane.add(btnViewAvailableOrgans);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 102, 0));
		panel.setBounds(0, 0, 677, 80);
		contentPane.add(panel);
		
		JButton btnViewDonorList = new JButton("View Registered Donor List");
		btnViewDonorList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				contentPane.setVisible(false);
				dispose();
				
							
				Donor donor = new Donor();
				donor.setVisible(true);	
				
			}
		});
		btnViewDonorList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnViewDonorList.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewDonorList.setBackground(Color.CYAN);
		btnViewDonorList.setBounds(362, 305, 265, 59);
		contentPane.add(btnViewDonorList);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 80, 677, 370);
		contentPane.add(panel_1);
	}
}