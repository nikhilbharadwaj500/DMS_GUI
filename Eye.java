

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.UIManager;

public class Eye extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eye frame = new Eye();
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
	public Eye() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 500);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEyes = new JLabel("Eyes List");
		lblEyes.setHorizontalAlignment(SwingConstants.CENTER);
		lblEyes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblEyes.setBounds(221, 35, 235, 43);
		contentPane.add(lblEyes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 150, 558, 209);
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

		String query = "select * from eye";
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
			public void mouseClicked(MouseEvent e) {
				
				contentPane.setVisible(false);
				dispose();
				
				Patient list = new Patient();
				list.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(559, 427, 89, 23);
		contentPane.add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 102, 0));
		panel.setBounds(0, 0, 677, 85);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 85, 677, 376);
		contentPane.add(panel_1);
	}
}