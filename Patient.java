
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Patient extends JFrame {

	private JPanel contentPane;
	private final JPanel panel_1 = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient frame = new Patient();
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
	public Patient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 500);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPatientsList = new JLabel("Patients List");
		lblPatientsList.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientsList.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblPatientsList.setBounds(220, 43, 193, 36);
		contentPane.add(lblPatientsList);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 102, 0));
		panel.setBounds(0, 0, 677, 82);
		contentPane.add(panel);
		
		JButton btnKidney = new JButton("Kidney List");
		btnKidney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnKidney.setBackground(Color.CYAN);
		btnKidney.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				contentPane.setVisible(false);
				dispose();
				
				Kidney list = new Kidney();
				list.setVisible(true);
			}
		});
		btnKidney.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnKidney.setBounds(85, 173, 123, 36);
		contentPane.add(btnKidney);
		
		JButton btnLungs = new JButton("Lungs List");
		btnLungs.setBackground(Color.CYAN);
		btnLungs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.setVisible(false);
				dispose();
				
				Lung list = new Lung();
				list.setVisible(true);
			}
		});
		btnLungs.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLungs.setBounds(413, 173, 123, 36);
		contentPane.add(btnLungs);
		
		JButton btnLiver = new JButton("Liver List");
		btnLiver.setBackground(Color.CYAN);
		btnLiver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				contentPane.setVisible(false);
				dispose();
				
				Liver list = new Liver();
				list.setVisible(true);
			}
		});
		btnLiver.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLiver.setBounds(57, 316, 123, 36);
		contentPane.add(btnLiver);
		
		JButton btnHeart = new JButton("Heart List");
		btnHeart.setBackground(Color.CYAN);
		btnHeart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				contentPane.setVisible(false);
				dispose();
				
				Heart list = new Heart();
				list.setVisible(true);
			}
		});
		btnHeart.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHeart.setBounds(259, 316, 123, 36);
		contentPane.add(btnHeart);
		
		JButton btnEyes = new JButton("Eyes List");
		btnEyes.setBackground(Color.CYAN);
		btnEyes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				contentPane.setVisible(false);
				dispose();
				
				Eye list = new Eye();
				list.setVisible(true);
			}
		});
		btnEyes.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEyes.setBounds(489, 316, 115, 36);
		contentPane.add(btnEyes);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				contentPane.setVisible(false);
				dispose();
				
				After_login after_login = new After_login();
				after_login.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(545, 427, 89, 23);
		contentPane.add(btnBack);
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 82, 677, 379);
		contentPane.add(panel_1);
	}
}