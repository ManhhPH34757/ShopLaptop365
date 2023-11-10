package com.shoplaptop.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import com.shoplaptop.dao.KhachHangDAO;
import com.shoplaptop.entity.KhachHang;
import com.shoplaptop.utils.XDate;

import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChiTietKhachHang extends JDialog {
	
	public static JTextField txtMaKH;
	public static JTextField txtTenKH;
	public static JTextField txtSDT;
	public static JTextField txtNgaySinh;
	public static JTextField txtEmail;
	public static JTextArea txtDiaChi;
	public static JRadioButton rdoNam;
	public static JRadioButton rdoNu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietKhachHang dialog = new ChiTietKhachHang();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public ChiTietKhachHang() {
		setBounds(100, 100, 696, 517);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHI TIẾT THÔNG TIN KHÁCH HÀNG");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setForeground(new Color(255, 128, 192));
		lblNewLabel.setBounds(0, 0, 311, 29);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng :");
		lblNewLabel_1.setBounds(10, 40, 174, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên khách hàng :");
		lblNewLabel_1_1.setBounds(10, 94, 174, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số điện thoại :");
		lblNewLabel_1_2.setBounds(10, 160, 174, 14);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Địa chỉ :");
		lblNewLabel_1_3.setBounds(10, 236, 174, 14);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ngày sinh :");
		lblNewLabel_1_4.setBounds(370, 40, 174, 14);
		getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Email :");
		lblNewLabel_1_5.setBounds(370, 94, 174, 14);
		getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Giới tính :");
		lblNewLabel_1_6.setBounds(370, 160, 174, 14);
		getContentPane().add(lblNewLabel_1_6);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(10, 65, 267, 20);
		getContentPane().add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(10, 119, 267, 20);
		getContentPane().add(txtTenKH);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(10, 191, 267, 20);
		getContentPane().add(txtSDT);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(370, 65, 267, 20);
		getContentPane().add(txtNgaySinh);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(370, 119, 267, 20);
		getContentPane().add(txtEmail);
		
		txtDiaChi = new JTextArea();
		txtDiaChi.setBounds(10, 266, 267, 88);
		getContentPane().add(txtDiaChi);
		
		rdoNam = new JRadioButton("Nam");
		rdoNam.setBounds(370, 190, 109, 23);
		getContentPane().add(rdoNam);
		
		rdoNu = new JRadioButton("Nữ");
		rdoNu.setBounds(524, 190, 109, 23);
		getContentPane().add(rdoNu);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoNam);
		buttonGroup.add(rdoNu);
		
		JButton btnSuaKH = new JButton("Sửa");
		btnSuaKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(getContentPane(), new KhachHangDAO().update(getForm()));
			}
		});
		btnSuaKH.setBounds(400, 395, 89, 23);
		getContentPane().add(btnSuaKH);
		
		JButton btnXoaKH = new JButton("Xóa");
		btnXoaKH.setBounds(548, 395, 89, 23);
		getContentPane().add(btnXoaKH);

	}
	public void setForm(KhachHang khachHang) {
		txtMaKH.setText(khachHang.getMaKH());
		txtTenKH.setText(khachHang.getHoTen());
		txtSDT.setText(khachHang.getSoDienThoai()+"");
		txtNgaySinh.setText(XDate.toString(khachHang.getNgaySinh(),"YYYY-MM-dd"));
		rdoNam.setSelected(khachHang.isGioiTinh());
		rdoNu.setSelected(!khachHang.isGioiTinh());
		txtEmail.setText(khachHang.getEmail());
		txtDiaChi.setText(khachHang.getDiaChi());	
	}
	public KhachHang getForm() {
		KhachHang khachHang = new KhachHang();
		khachHang.setMaKH(txtMaKH.getText());
		khachHang.setHoTen(txtTenKH.getText());
		khachHang.setSoDienThoai(txtSDT.getText());
		khachHang.setNgaySinh(XDate.toDate(txtNgaySinh.getText(), "YYYY-MM-dd"));
		khachHang.setGioiTinh(rdoNam.isSelected());
		khachHang.setEmail(txtEmail.getText());
		khachHang.setDiaChi(txtDiaChi.getText());
		return khachHang;
		
	}
	public void updateKH() {
		KhachHang khachHang = getForm();
		JOptionPane.showMessageDialog(getContentPane(), new KhachHangDAO().update(khachHang));
		
		
	}

}
