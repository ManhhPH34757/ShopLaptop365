package com.shoplaptop.ui;

import java.awt.EventQueue;
import java.util.Date;

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
import com.toedter.calendar.JDateChooser;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;


public class ThemKhachHangJDialog extends JDialog {
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JRadioButton rdoNam;
	private JRadioButton rdoNu;
	private JTextArea txtDiaChi;
	private JDateChooser dateChooser;
	private QuanLyKhachHang quanLyKhachHang;
	private KhachHangDAO dao = new KhachHangDAO();

	

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
	public ThemKhachHangJDialog(QuanLyKhachHang quanLyKhachHang) {
		this.quanLyKhachHang = quanLyKhachHang;
		setTitle("Quản lý khách hàng");
		setBounds(100, 100, 732, 469);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		   
		
		JLabel lblNewLabel = new JLabel("THÊM KHÁCH HÀNG");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setForeground(new Color(255, 128, 192));
		lblNewLabel.setBounds(10, 0, 239, 31);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBorder(new LineBorder(new Color(128, 255, 255)));
		panel.setBounds(10, 42, 709, 333);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin khách hàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1.setBounds(0, 0, 134, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên khách hàng :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(0, 86, 134, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mã khách hàng :");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(0, 35, 134, 14);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Số điện thoại :");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(0, 143, 134, 14);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Địa chỉ :");
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_3.setBounds(0, 207, 134, 14);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Ngày sinh :");
		lblNewLabel_2_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_4.setBounds(351, 35, 134, 14);
		panel.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Email :");
		lblNewLabel_2_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_5.setBounds(351, 86, 134, 14);
		panel.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("Giới tính :");
		lblNewLabel_2_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_6.setBounds(351, 143, 134, 14);
		panel.add(lblNewLabel_2_6);
		
		txtMaKH = new JTextField();
		txtMaKH.setToolTipText("");
		txtMaKH.setForeground(new Color(0, 0, 0));
		txtMaKH.setBounds(0, 55, 288, 20);
		panel.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setForeground(new Color(0, 0, 0));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(0, 111, 288, 20);
		panel.add(txtTenKH);
		
		txtSDT = new JTextField();
		txtSDT.setForeground(new Color(0, 0, 0));
		txtSDT.setColumns(10);
		txtSDT.setBounds(0, 168, 288, 20);
		panel.add(txtSDT);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(0, 0, 0));
		txtEmail.setColumns(10);
		txtEmail.setBounds(351, 111, 200, 20);
		panel.add(txtEmail);
		
		rdoNam = new JRadioButton("Nam");
		rdoNam.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdoNam.setBounds(351, 167, 74, 23);
		panel.add(rdoNam);
		
		rdoNu = new JRadioButton("Nữ");
		rdoNu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdoNu.setBounds(496, 167, 56, 23);
		panel.add(rdoNu);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoNam);
		buttonGroup.add(rdoNu);
		
		txtDiaChi = new JTextArea();
		txtDiaChi.setForeground(new Color(0, 0, 0));
		txtDiaChi.setBounds(0, 232, 425, 72);
		panel.add(txtDiaChi);
		
		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser.setBounds(351, 55, 200, 20);
		panel.add(dateChooser);
		
		JButton btnLuuKH = new JButton("Lưu");
		btnLuuKH.setBackground(Color.PINK);
		btnLuuKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLuuKH.setForeground(new Color(0, 128, 255));
		btnLuuKH.setIcon(new ImageIcon(ThemKhachHangJDialog.class.getResource("/com/shoplaptop/icon/Save as.png")));
		btnLuuKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(getContentPane(), new KhachHangDAO().insert(getForm()));
				dao.insert(getForm());
				dispose();
				quanLyKhachHang.fillTable(new KhachHangDAO().selectAll());
				quanLyKhachHang.list = new KhachHangDAO().selectAll();
			}
		});
		btnLuuKH.setBounds(477, 386, 89, 37);
		getContentPane().add(btnLuuKH);
		
		JButton btnHuyLuuKH = new JButton("Hủy");
		btnHuyLuuKH.setBackground(Color.PINK);
		btnHuyLuuKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHuyLuuKH.setForeground(new Color(0, 128, 255));
		btnHuyLuuKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnHuyLuuKH.setIcon(new ImageIcon(ThemKhachHangJDialog.class.getResource("/com/shoplaptop/icon/Refresh.png")));
		btnHuyLuuKH.setBounds(612, 386, 97, 37);
		getContentPane().add(btnHuyLuuKH);

	}
	public void setForm(KhachHang khachHang) {
		txtMaKH.setText(khachHang.getMaKH());
		txtTenKH.setText(khachHang.getHoTen());
		txtSDT.setText(khachHang.getSoDienThoai());
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
//		khachHang.setNgaySinh(XDate.toDate(txtNgaySinh.getText(), "yyyy-MM-dd"));
		khachHang.setNgaySinh(dateChooser.getDate());
		khachHang.setGioiTinh(rdoNam.isSelected());
		khachHang.setEmail(txtEmail.getText());
		khachHang.setDiaChi(txtDiaChi.getText());
		return khachHang;
		
	}
	public void addKH() {
		KhachHang khachHang = getForm();
		JOptionPane.showMessageDialog(getContentPane(), new KhachHangDAO().insert(khachHang));
		
		
		
	}
	public void clearForm() {
		txtMaKH.setText(null);
		txtTenKH.setText(null);
		txtSDT.setText(null);
//		txtNgaySinh.setText(null);
		dateChooser.setDate(null);
		rdoNam.setSelected(rdoNam.isSelected());
		
		txtEmail.setText(null);
		
		txtDiaChi.setText(null);
	}
}
