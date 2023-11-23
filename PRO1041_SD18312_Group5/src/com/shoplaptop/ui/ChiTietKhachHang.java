package com.shoplaptop.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JTextField;

import com.shoplaptop.dao.KhachHangDAO;
import com.shoplaptop.entity.KhachHang;
import com.shoplaptop.utils.MsgBox;
import com.shoplaptop.utils.XDate;
import com.toedter.calendar.JDateChooser;

import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ChiTietKhachHang extends JDialog {
	
	public static JTextField txtMaKH;
	public static JTextField txtTenKH;
	public static JTextField txtSDT;
	public static JTextField txtEmail;
	public static JTextArea txtDiaChi;
	public static JRadioButton rdoNam;
	public static JRadioButton rdoNu;
	public static Object txtHoTen;
	private QuanLyKhachHang quanLyKhachHang;
	public static KhachHangDAO khachHangDAO;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChiTietKhachHang dialog = new ChiTietKhachHang();
//					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//					dialog.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	private Object model;
	public static JDateChooser dateChooser;


	/**
	 * Create the dialog.
	 */
	public ChiTietKhachHang(QuanLyKhachHang quanLyKhachHang) {
		this.quanLyKhachHang = quanLyKhachHang;
		getContentPane().setBackground(new Color(245, 255, 250));
		setTitle("Quản lý khách hàng");
		setForeground(new Color(51, 204, 204));
		getContentPane().setForeground(new Color(0, 128, 192));
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
		txtMaKH.setForeground(new Color(0, 0, 0));
		txtMaKH.setBounds(10, 65, 267, 20);
		getContentPane().add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setForeground(new Color(0, 0, 0));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(10, 119, 267, 20);
		getContentPane().add(txtTenKH);
		
		txtSDT = new JTextField();
		txtSDT.setForeground(new Color(0, 0, 0));
		txtSDT.setText("\r\n");
		txtSDT.setColumns(10);
		txtSDT.setBounds(10, 191, 267, 20);
		getContentPane().add(txtSDT);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(0, 0, 0));
		txtEmail.setColumns(10);
		txtEmail.setBounds(370, 119, 267, 20);
		getContentPane().add(txtEmail);
		
		txtDiaChi = new JTextArea();
		txtDiaChi.setForeground(new Color(0, 0, 0));
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
		btnSuaKH.setBackground(Color.PINK);
		btnSuaKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSuaKH.setForeground(new Color(30, 144, 255));
		btnSuaKH.setIcon(new ImageIcon(ChiTietKhachHang.class.getResource("/com/shoplaptop/icon/Edit.png")));
		btnSuaKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				quanLyKhachHang.updateKH(getForm());
				quanLyKhachHang.fillTable(new KhachHangDAO().selectAll());
				
				dispose();
				
				
			}
		});
		btnSuaKH.setBounds(400, 395, 109, 41);
		getContentPane().add(btnSuaKH);
		
		JButton btnXoaKH = new JButton("Xóa");
		btnXoaKH.setBackground(Color.PINK);
		btnXoaKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoaKH.setForeground(new Color(0, 128, 255));
		btnXoaKH.setIcon(new ImageIcon(ChiTietKhachHang.class.getResource("/com/shoplaptop/icon/Delete.png")));
		btnXoaKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(getContentPane(), "Xác nhận xóa")==JOptionPane.YES_NO_OPTION) {
					deleteKH();
					quanLyKhachHang.fillTable(new KhachHangDAO().selectAll());
					
				}
				dispose();
				
			//	new KhachHangJDialog().setVisible(true);
			}
		});
		btnXoaKH.setBounds(535, 395, 102, 41);
		getContentPane().add(btnXoaKH);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(370, 65, 267, 20);
		getContentPane().add(dateChooser);
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

	}

		
		
	
	public void setForm(KhachHang khachHang) {
		txtMaKH.setText(khachHang.getMaKH());
		txtTenKH.setText(khachHang.getHoTen());
		txtSDT.setText(khachHang.getSoDienThoai()+"");
//		txtNgaySinh.setText(XDate.toString(khachHang.getNgaySinh(),"yyyy-MM-dd"));
		dateChooser.setDate(khachHang.getNgaySinh());
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
		khachHang.setNgaySinh(dateChooser.getDate());
//		khachHang.setNgaySinh(XDate.toDate(txtNgaySinh.getText(), "yyyy-MM-dd"));
		khachHang.setGioiTinh(rdoNam.isSelected());
		khachHang.setEmail(txtEmail.getText());
		khachHang.setDiaChi(txtDiaChi.getText());
		return khachHang;
		
	}
	
	public void deleteKH() {
		KhachHang khachHang = getForm();
		JOptionPane.showMessageDialog(getContentPane(), new KhachHangDAO().delete(khachHang.getMaKH()));
	}

}
