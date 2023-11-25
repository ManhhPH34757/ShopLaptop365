package com.shoplaptop.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;

import javax.management.modelmbean.ModelMBean;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.shoplaptop.dao.KhachHangDAO;
import com.shoplaptop.entity.KhachHang;
import com.shoplaptop.entity.NhanVien;
import com.shoplaptop.utils.XDate;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KhachHangJDialog extends JDialog {
	private JTextField txtTimKiem;
	private JTable tblKhachHang;
	private DefaultTableModel model;
	private ArrayList<KhachHang> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHangJDialog dialog = new KhachHangJDialog();
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
	public KhachHangJDialog() {
		
		setBounds(100, 100, 769, 592);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH KHÁCH HÀNG");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 364, 32);
		getContentPane().add(lblNewLabel);
		
		JButton btnThemKH = new JButton("+ Thêm khách hàng");
		btnThemKH.setBounds(563, 50, 153, 23);
		getContentPane().add(btnThemKH);
		
		btnThemKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ThemKhachHangJDialog().setVisible(true);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm khách hàng");
		lblNewLabel_1.setBounds(10, 104, 236, 14);
		getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 129, 724, 45);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(10, 11, 563, 20);
		panel.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTimKiem.setForeground(new Color(255, 0, 0));
		btnTimKiem.setBounds(601, 10, 89, 23);
		panel.add(btnTimKiem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 185, 737, 263);
		getContentPane().add(scrollPane);
		
		model = new DefaultTableModel();
		String[] cols = {"Mã KH","Họ tên","Số điện thoại","Địa chỉ"};
		model.setColumnIdentifiers(cols);
		
		
		tblKhachHang = new JTable(model);
		tblKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tblKhachHang.getSelectedRow();
				KhachHang khachHang = list.get(index);
				new ChiTietKhachHang().setVisible(true);
				setForm(khachHang);
				
			}
		});
		tblKhachHang.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblKhachHang);
		fillTable();

	}
	public void fillTable() {
		model.setRowCount(0);
		list = (ArrayList<KhachHang>) new KhachHangDAO().selectAll();
		for (KhachHang khachHang : list) {
			Object[] rows = new Object[] {
					khachHang.getMaKH(),
					khachHang.getHoTen(),
					khachHang.getSoDienThoai(),
					khachHang.getDiaChi()
			};
			model.addRow(rows);
			
		}
		
		
	}
	
	public void setForm(KhachHang khachHang) {
		ChiTietKhachHang.txtMaKH.setText(khachHang.getMaKH());
		ChiTietKhachHang.txtTenKH.setText(khachHang.getHoTen());
		ChiTietKhachHang.txtSDT.setText(khachHang.getSoDienThoai());
		ChiTietKhachHang.txtNgaySinh.setText(XDate.toString(khachHang.getNgaySinh(),"YYYY-MM-dd"));
		ChiTietKhachHang.rdoNam.setSelected(khachHang.isGioiTinh());
		ChiTietKhachHang.rdoNu.setSelected(!khachHang.isGioiTinh());
		ChiTietKhachHang.txtEmail.setText(khachHang.getEmail());
		ChiTietKhachHang.txtDiaChi.setText(khachHang.getDiaChi());	
	}
	
}