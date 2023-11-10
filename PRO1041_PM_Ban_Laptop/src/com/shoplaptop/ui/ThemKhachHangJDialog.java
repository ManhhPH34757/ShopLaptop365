package com.shoplaptop.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.shoplaptop.dao.KhachHangDAO;
import com.shoplaptop.entity.KhachHang;
import com.shoplaptop.utils.XDate;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThemKhachHangJDialog extends JDialog {
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtNgaySinh;
	private JTextField txtEmail;
	private JRadioButton rdoNam;
	private JRadioButton rdoNu;
	private JTextArea txtDiaChi;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ThemKhachHangJDialog dialog = new ThemKhachHangJDialog();
//					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//					dialog.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the dialog.
	 */
	public ThemKhachHangJDialog() {
		setBounds(100, 100, 732, 469);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÊM KHÁCH HÀNG");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(255, 128, 192));
		lblNewLabel.setBounds(10, 11, 239, 20);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 42, 699, 333);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin khách hàng");
		lblNewLabel_1.setBounds(0, 0, 134, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên khách hàng :");
		lblNewLabel_2.setBounds(0, 86, 134, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mã khách hàng :");
		lblNewLabel_2_1.setBounds(0, 35, 134, 14);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Số điện thoại :");
		lblNewLabel_2_2.setBounds(0, 143, 134, 14);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Địa chỉ :");
		lblNewLabel_2_3.setBounds(0, 207, 134, 14);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Ngày sinh :");
		lblNewLabel_2_4.setBounds(351, 35, 134, 14);
		panel.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Email :");
		lblNewLabel_2_5.setBounds(351, 86, 134, 14);
		panel.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("Giới tính :");
		lblNewLabel_2_6.setBounds(351, 143, 134, 14);
		panel.add(lblNewLabel_2_6);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(0, 55, 288, 20);
		panel.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(0, 111, 288, 20);
		panel.add(txtTenKH);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(0, 168, 288, 20);
		panel.add(txtSDT);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(351, 55, 288, 20);
		panel.add(txtNgaySinh);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(351, 111, 288, 20);
		panel.add(txtEmail);
		
		rdoNam = new JRadioButton("Nam");
		rdoNam.setBounds(351, 167, 109, 23);
		panel.add(rdoNam);
		
		rdoNu = new JRadioButton("Nữ");
		rdoNu.setBounds(530, 167, 109, 23);
		panel.add(rdoNu);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoNam);
		buttonGroup.add(rdoNu);
		
		txtDiaChi = new JTextArea();
		txtDiaChi.setBounds(0, 232, 288, 72);
		panel.add(txtDiaChi);
		
		JButton btnLuuKH = new JButton("Lưu");
		btnLuuKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(getContentPane(), new KhachHangDAO().insert(getForm()));
				new KhachHangJDialog().setVisible(true);;
				dispose();
			}
		});
		btnLuuKH.setBounds(496, 386, 89, 23);
		getContentPane().add(btnLuuKH);
		
		JButton btnHuyLuuKH = new JButton("Hủy");
		btnHuyLuuKH.setBounds(620, 386, 89, 23);
		getContentPane().add(btnHuyLuuKH);

	}
	public void setForm(KhachHang khachHang) {
		txtMaKH.setText(khachHang.getMaKH());
		txtTenKH.setText(khachHang.getHoTen());
		txtSDT.setText(khachHang.getSoDienThoai());
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
	public void addKH() {
		KhachHang khachHang = getForm();
		JOptionPane.showMessageDialog(getContentPane(), new KhachHangDAO().insert(khachHang));
		
		
	}

}
