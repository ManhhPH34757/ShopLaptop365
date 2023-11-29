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
import javax.swing.JScrollPane;


public class ThemKhachHangJDialog extends JDialog {
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JRadioButton rdoNam;
	private JRadioButton rdoNu;
	private JDateChooser dateChooser;
	private QuanLyKhachHang quanLyKhachHang;
	private KhachHangDAO dao = new KhachHangDAO();
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
	public ThemKhachHangJDialog(QuanLyKhachHang quanLyKhachHang) {
		this.quanLyKhachHang = quanLyKhachHang;
		setTitle("Quản lý khách hàng");
		setBounds(100, 100, 975, 675);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		   
		
		JLabel lblNewLabel = new JLabel("THÊM KHÁCH HÀNG");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setForeground(new Color(255, 128, 128));
		lblNewLabel.setBounds(0, 12, 612, 33);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(128, 255, 255)));
		panel.setBounds(0, 55, 963, 573);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin khách hàng");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(10, 11, 319, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên khách hàng :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 150, 134, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mã khách hàng :");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(10, 77, 134, 14);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Số điện thoại :");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(10, 236, 134, 20);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Địa chỉ :");
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_3.setBounds(10, 327, 134, 20);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Ngày sinh :");
		lblNewLabel_2_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_4.setBounds(527, 74, 134, 20);
		panel.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Email :");
		lblNewLabel_2_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_5.setBounds(527, 155, 134, 14);
		panel.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("Giới tính :");
		lblNewLabel_2_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_6.setBounds(527, 241, 134, 14);
		panel.add(lblNewLabel_2_6);
		
		txtMaKH = new JTextField();
		txtMaKH.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMaKH.setToolTipText("");
		txtMaKH.setForeground(new Color(0, 0, 0));
		txtMaKH.setBounds(10, 102, 377, 37);
		panel.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTenKH.setForeground(new Color(0, 0, 0));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(10, 181, 377, 37);
		panel.add(txtTenKH);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSDT.setForeground(new Color(0, 0, 0));
		txtSDT.setColumns(10);
		txtSDT.setBounds(10, 267, 377, 37);
		panel.add(txtSDT);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtEmail.setForeground(new Color(0, 0, 0));
		txtEmail.setColumns(10);
		txtEmail.setBounds(527, 181, 352, 37);
		panel.add(txtEmail);
		
		rdoNam = new JRadioButton("Nam");
		rdoNam.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdoNam.setBounds(527, 267, 61, 37);
		panel.add(rdoNam);
		
		rdoNu = new JRadioButton("Nữ");
		rdoNu.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdoNu.setBounds(655, 268, 54, 36);
		panel.add(rdoNu);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoNam);
		buttonGroup.add(rdoNu);
		
		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser.setBounds(527, 102, 352, 37);
		panel.add(dateChooser);
		
		JButton btnHuyLuuKH = new JButton("Hủy");
		btnHuyLuuKH.setBounds(856, 510, 97, 37);
		panel.add(btnHuyLuuKH);
		btnHuyLuuKH.setBackground(Color.PINK);
		btnHuyLuuKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHuyLuuKH.setForeground(new Color(0, 128, 255));
		btnHuyLuuKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnHuyLuuKH.setIcon(new ImageIcon(ThemKhachHangJDialog.class.getResource("/com/shoplaptop/icon/Refresh.png")));
		
		JButton btnLuuKH = new JButton("Lưu");
		btnLuuKH.setBounds(738, 510, 89, 37);
		panel.add(btnLuuKH);
		btnLuuKH.setBackground(Color.PINK);
		btnLuuKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLuuKH.setForeground(new Color(0, 128, 255));
		btnLuuKH.setIcon(new ImageIcon(ThemKhachHangJDialog.class.getResource("/com/shoplaptop/icon/Save as.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 357, 929, 143);
		panel.add(scrollPane);
		
		txtDiaChi = new JTextArea();
		scrollPane.setViewportView(txtDiaChi);
		btnLuuKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(getContentPane(), new KhachHangDAO().insert(getForm()));
				dao.insert(getForm());
				dispose();
				ThemKhachHangJDialog.this.quanLyKhachHang.fillTable(new KhachHangDAO().selectAll());
				ThemKhachHangJDialog.this.quanLyKhachHang.list = new KhachHangDAO().selectAll();
			}
		});

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
