package com.shoplaptop.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class DongLaptopManager extends JDialog {
	
	private CreateLaptop createLaptop;
	private JTextField txtMaDong;
	private JTextField txtTenDong;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					DongLaptopManager dialog = new DongLaptopManager();
//					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DongLaptopManager(CreateLaptop createLaptop) {
		this.createLaptop = createLaptop;
		setBounds(100, 100, 760, 505);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 251, 723, 207);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblDngLaptop = new JLabel("Dòng Laptop");
		lblDngLaptop.setHorizontalAlignment(SwingConstants.CENTER);
		lblDngLaptop.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblDngLaptop.setBounds(293, 10, 153, 33);
		getContentPane().add(lblDngLaptop);
		
		JLabel lblNewLabel_1 = new JLabel("Hãng");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 62, 147, 33);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã dòng Laptop");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 121, 147, 33);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên dòng Laptop");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(10, 179, 147, 33);
		getContentPane().add(lblNewLabel_1_2);
		
		txtMaDong = new JTextField();
		txtMaDong.setColumns(10);
		txtMaDong.setBounds(167, 121, 254, 33);
		getContentPane().add(txtMaDong);
		
		txtTenDong = new JTextField();
		txtTenDong.setColumns(10);
		txtTenDong.setBounds(167, 179, 254, 33);
		getContentPane().add(txtTenDong);
		
		JComboBox cboHang = new JComboBox();
		cboHang.setBounds(167, 62, 254, 33);
		getContentPane().add(cboHang);

	}
}
