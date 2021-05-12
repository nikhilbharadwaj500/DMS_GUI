

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
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.UIManager;

public class Kidney extends JFrame {

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
					Kidney frame = new Kidney();
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
	public Kidney() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 500);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKidneyPatientsList = new JLabel(" Kidney List");
		lblKidneyPatientsList.setHorizontalAlignment(SwingConstants.CENTER);
		lblKidneyPatientsList.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblKidneyPatientsList.setBounds(195, 40, 266, 37);
		contentPane.add(lblKidneyPatientsList);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 102, 0));
		panel.setBounds(0, 0, 677, 77);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 134, 574, 228);
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

		String query = "select * from kidney";
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
		btnBack.setBackground(UIManager.getColor("ComboBox.buttonDarkShadow"));
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				contentPane.setVisible(false);
				dispose();
				
				Patient list = new Patient();
				list.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(550, 427, 89, 23);
		contentPane.add(btnBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 76, 677, 385);
		contentPane.add(panel_1);
	}
}