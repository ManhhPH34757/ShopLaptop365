package com.shoplaptop.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class PhanLoaiManager extends JDialog {
	
	private CreateLaptop createLaptop;
	private JTextField txtMaLoai;
	private JTextField txtTenLoai;
	private JTextField txtMoTa;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					PhanLoaiManager dialog = new PhanLoaiManager(CreateLaptop.this);
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
	public PhanLoaiManager(CreateLaptop createLaptop) {
		this.createLaptop = createLaptop;
		setBounds(100, 100, 760, 505);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 251, 723, 207);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Phân Loại");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(293, 10, 153, 33);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã loại");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 62, 127, 33);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên loại");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 121, 127, 33);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mô tả");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(10, 179, 127, 33);
		getContentPane().add(lblNewLabel_1_2);
		
		txtMaLoai = new JTextField();
		txtMaLoai.setBounds(167, 62, 254, 33);
		getContentPane().add(txtMaLoai);
		txtMaLoai.setColumns(10);
		
		txtTenLoai = new JTextField();
		txtTenLoai.setColumns(10);
		txtTenLoai.setBounds(167, 121, 254, 33);
		getContentPane().add(txtTenLoai);
		
		txtMoTa = new JTextField();
		txtMoTa.setColumns(10);
		txtMoTa.setBounds(167, 179, 254, 33);
		getContentPane().add(txtMoTa);

	}
}
