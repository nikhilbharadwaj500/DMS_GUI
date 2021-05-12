import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class Register_Sys extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtFatherName;
	private JTextField txtPhone;
	private JTextField txtAge;
	private JTextField txtEmail;
	private JTextField txtAddress;
	
	// Variable to keep the count of records
		public static int Did_count = 1;
		private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_Sys frame = new Register_Sys();
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
	public Register_Sys() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 500);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Donor Registration");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(201, 31, 323, 34);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 102, 0));
		panel.setBounds(0, 0, 917, 67);
		contentPane.add(panel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setBackground(Color.WHITE);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setBounds(10, 84, 86, 14);
		contentPane.add(lblName);
		
		JLabel lblName1 = new JLabel("Id");
		lblName1.setForeground(Color.WHITE);
		lblName1.setBackground(Color.WHITE);
		lblName1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName1.setBounds(418, 84, 86, 14);
		contentPane.add(lblName1);
		
		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setForeground(Color.WHITE);
		lblFatherName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFatherName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFatherName.setBounds(10, 128, 86, 14);
		contentPane.add(lblFatherName);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGender.setBounds(10, 175, 78, 14);
		contentPane.add(lblGender);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(Color.WHITE);
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAge.setBounds(215, 172, 56, 20);
		contentPane.add(lblAge);
		
		JLabel lblLifeStatus = new JLabel("Life Status");
		lblLifeStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblLifeStatus.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLifeStatus.setForeground(Color.WHITE);
		lblLifeStatus.setBounds(392, 175, 86, 14);
		contentPane.add(lblLifeStatus);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setForeground(Color.WHITE);
		lblBloodGroup.setHorizontalAlignment(SwingConstants.CENTER);
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBloodGroup.setBounds(0, 216, 96, 14);
		contentPane.add(lblBloodGroup);
		
		JLabel lblOrganType = new JLabel("Organ Type");
		lblOrganType.setForeground(Color.WHITE);
		lblOrganType.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrganType.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOrganType.setBounds(236, 213, 86, 20);
		contentPane.add(lblOrganType);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhone.setBounds(10, 264, 56, 14);
		contentPane.add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(10, 309, 56, 14);
		contentPane.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress.setBounds(10, 352, 70, 14);
		contentPane.add(lblAddress);
		
		txtName = new JTextField();
		txtName.setBounds(125, 83, 208, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtId = new JTextField();
		txtId.setBounds(542, 83, 96, 19);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		
		txtFatherName = new JTextField();
		txtFatherName.setBounds(125, 122, 208, 20);
		contentPane.add(txtFatherName);
		txtFatherName.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(127, 173, 78, 20);
		contentPane.add(comboBox);
		comboBox.addItem("");
		comboBox.addItem("MALE");
		comboBox.addItem("FEMALE");
		
		
		txtAge = new JTextField();
		txtAge.setBounds(290, 173, 78, 20);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(503, 173, 70, 20);
		contentPane.add(comboBox_3);
		comboBox_3.addItem("");
		comboBox_3.addItem("Alive");
		comboBox_3.addItem("Dead");
		
		
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(125, 214, 56, 20);
		contentPane.add(comboBox_1);
		comboBox_1.addItem("");
		comboBox_1.addItem("A+");
		comboBox_1.addItem("A-");
		comboBox_1.addItem("B+");
		comboBox_1.addItem("B-");
		comboBox_1.addItem("O+");
		comboBox_1.addItem("O-");
		comboBox_1.addItem("AB+");
		comboBox_1.addItem("AB-");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(348, 214, 95, 20);
		contentPane.add(comboBox_2);
		comboBox_2.addItem("");
		comboBox_2.addItem("Kidney");
		comboBox_2.addItem("Heart");
		comboBox_2.addItem("Lungs");
		comboBox_2.addItem("Liver");
		comboBox_2.addItem("Eyes");
		
		txtPhone = new JTextField();
		txtPhone.setBounds(125, 262, 208, 20);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(125, 307, 208, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(123, 352, 230, 39);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		btnRegister.setBackground(new Color(135, 206, 250));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Name=txtName.getText();
				String Id=txtId.getText();
				String FatherName=txtFatherName.getText();
				String Gender = (String) comboBox.getSelectedItem();
				String Age= txtAge.getText();
				String LifeStatus = (String) comboBox_3.getSelectedItem();
				String BloodGrp = (String) comboBox_1.getSelectedItem();
				String OrganType = (String) comboBox_2.getSelectedItem();
				String Phone=txtPhone.getText();
				String Email=txtEmail.getText();
				String Address=txtAddress.getText();
				
				if(Name.isEmpty()||Id.isEmpty()||FatherName.isEmpty()||Gender.isEmpty()|| Age.isEmpty() ||LifeStatus.isEmpty()  ||BloodGrp.isEmpty() || OrganType.isEmpty() || Phone.isEmpty()||Email.isEmpty()|| Address.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Fields Empty !!", "Registration Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				else
				{
					/* Converting from String to Integer */
					int age_int = Integer.parseInt(Age);

					/* Age should be above or equal to 18. */
					if ( age_int <= 18 )
					{
						JOptionPane.showMessageDialog(null,"Age should be above 18!!", "Registration Not possible",JOptionPane.ERROR_MESSAGE);
						txtAge.setText(null);
						return;
					}

					/* Phone number should be 10 digit */
					if ( Phone.length() < 10 )
					{
						JOptionPane.showMessageDialog(null,"Phone Number Not Proper!!", "Registration Not possible",JOptionPane.ERROR_MESSAGE);
						txtPhone.setText(null);
						return;
					}
					else
						JOptionPane.showMessageDialog(null, " Donor Registered!!");
				}
				
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
		            
		            /* Check the available organs entry table for number of entries
				     * If the number of entries is 0, then id_count should be set to 1
				     * So that the next num_id will start afresh from 1     */
					
		            
					
				if((String) comboBox_3.getSelectedItem() == "Alive")
				{
					String query1 = "insert into registered_donor(id,name,f_name,Gender,Age,Live_Status,Blood_group,Organ_type,phone,email,address) values (?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst1 = con.prepareStatement(query1);
					pst1.setString(1, txtId.getText());
					pst1.setString(2, txtName.getText());
					pst1.setString(3, txtFatherName.getText());
					pst1.setString(4, (String) comboBox.getSelectedItem());
					pst1.setString(5, txtAge.getText());
					pst1.setString(6, (String) comboBox_3.getSelectedItem());
					pst1.setString(7, (String) comboBox_1.getSelectedItem());
					pst1.setString(8, (String) comboBox_2.getSelectedItem());
					pst1.setString(9, txtPhone.getText());
					pst1.setString(10, txtEmail.getText());
					pst1.setString(11, txtAddress.getText());
					pst1.execute();
				}
				else
				{
					String query2 = "insert into available_organs(id,Donor_name,Blood_Grp,Organ_Type) values (?,?,?,?)";
					PreparedStatement pst2 = con.prepareStatement(query2);
					pst2.setString(1, txtId.getText());
					pst2.setString(2, txtName.getText());
					pst2.setString(3, (String) comboBox_1.getSelectedItem());
					pst2.setString(4, (String) comboBox_2.getSelectedItem());
					pst2.execute();					
				}
				con.close();
				
		}
			catch(Exception E)
			{
				E.printStackTrace();
			}
					
				  
				contentPane.setVisible(false);
				dispose();
				
				
				
				/* Creating an object for the 2nd frame (Register)  */
				After_login after_login = new After_login();
				after_login.setVisible(true);


			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegister.setBounds(56, 427, 89, 23);
		contentPane.add(btnRegister);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(UIManager.getColor("SplitPane.darkShadow"));
		btnClear.setForeground(Color.BLACK);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtName.setText(null);
				txtFatherName.setText(null);
				comboBox.setSelectedItem(null);
				txtAge.setText(null);
				comboBox_3.setSelectedItem(null);
				comboBox_1.setSelectedItem(null);
				comboBox_2.setSelectedItem(null);
				txtPhone.setText(null);
				txtEmail.setText(null);
				txtAddress.setText(null);

			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.setBounds(290, 427, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(UIManager.getColor("ComboBox.buttonDarkShadow"));
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				contentPane.setVisible(false);
				dispose();
				
					
				After_login After = new After_login();
				After.setVisible(true);

			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(510, 427, 89, 23);
		contentPane.add(btnBack);
		
		
	}
}