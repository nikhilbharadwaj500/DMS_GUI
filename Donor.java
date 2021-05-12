

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;



public class Donor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	// Variable to keep the count of records
	public static int id_count = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Donor frame = new Donor();
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
	public Donor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 500);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegisterDonors = new JLabel("Registered Donors");
		lblRegisterDonors.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterDonors.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblRegisterDonors.setBounds(185, 32, 303, 32);
		contentPane.add(lblRegisterDonors);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 102, 0));
		panel.setBounds(0, 0, 677, 80);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 638, 240);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		String url       = "jdbc:mysql://localhost:3306/";
		String user      = "root";
		String passwd    = "";
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(url, user, passwd);
			

            Statement stt = con.createStatement();
            
            /**
             * Create and select a database for use. 
             */
            stt.execute("CREATE DATABASE IF NOT EXISTS donor_management");
            stt.execute("USE donor_management");

		String query = "select Id,Name,Blood_Group,Organ_Type from registered_donor";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
				
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
		pst.close();
		}
		
		catch(Exception E)
		{
			E.printStackTrace();
		}
			
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				contentPane.setVisible(false);
				dispose();
				
				After_login after_login = new After_login();
				after_login.setVisible(true);
			}
		});
		btnBack.setBackground(UIManager.getColor("SplitPane.darkShadow"));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(546, 416, 89, 23);
		contentPane.add(btnBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 79, 677, 382);
		contentPane.add(panel_1);
	}
}