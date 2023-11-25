package com.shoplaptop.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.shoplaptop.dao.KhachHangDAO;
import com.shoplaptop.entity.KhachHang;
import com.shoplaptop.utils.MsgBox;
import com.shoplaptop.utils.XDate;


public class QuanLyKhachHang extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyKhachHang dialog = new QuanLyKhachHang();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTextField txtTimKiem;
	private DefaultTableModel model;
	private JTable tblKhachHang;
	public List<KhachHang> list = new KhachHangDAO().selectAll();
	private KhachHangDAO dao = new KhachHangDAO();
	private int index =1;
	String selectBySDT = "SELECT * FROM KhachHang WHERE SoDienThoai like ? OR MaKH like ? ";
	private JLabel lblSau;
	private JLabel lblTo;
	private JLabel lblTruoc;
	private JButton btnSau;
	/**
	 * Create the dialog.
	 */
	public QuanLyKhachHang() {
		getContentPane().setBackground(new Color(240, 255, 240));
		setTitle("Quản lý khách hàng");
		
		setBounds(100, 100, 769, 592);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH KHÁCH HÀNG");
		lblNewLabel.setForeground(new Color(255, 128, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 0, 364, 32);
		getContentPane().add(lblNewLabel);
		
		JButton btnThemKH = new JButton("Thêm khách hàng");
		btnThemKH.setIcon(new ImageIcon(QuanLyKhachHang.class.getResource("/com/shoplaptop/icon/Add.png")));
		btnThemKH.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThemKH.setForeground(new Color(0, 128, 255));
		btnThemKH.setBounds(561, 50, 174, 33);
		getContentPane().add(btnThemKH);
		
		btnThemKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ThemKhachHangJDialog(QuanLyKhachHang.this).setVisible(true);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm khách hàng");
		lblNewLabel_1.setBounds(10, 77, 236, 14);
		getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(10, 94, 724, 45);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(10, 11, 563, 20);
		panel.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(Color.PINK);
		btnTimKiem.setIcon(new ImageIcon(QuanLyKhachHang.class.getResource("/com/shoplaptop/icon/Search.png")));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findSDT();
				
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTimKiem.setForeground(new Color(255, 0, 0));
		btnTimKiem.setBounds(583, 4, 131, 35);
		panel.add(btnTimKiem);
		
		model = new DefaultTableModel();
		String[] cols = {"Mã KH","Họ tên","Số điện thoại","Địa chỉ"};
		model.setColumnIdentifiers(cols);
		
		JLabel lblNewLabel_1_1 = new JLabel("Danh sách khách hàng");
		lblNewLabel_1_1.setBounds(10, 150, 236, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 195, 724, 279);
		getContentPane().add(scrollPane);
		
		tblKhachHang = new JTable(model);
		tblKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tblKhachHang.getSelectedRow();
				KhachHang khachHang = list.get(index);
				new ChiTietKhachHang(QuanLyKhachHang.this).setVisible(true);
				setForm(khachHang);
			}
		});
		tblKhachHang.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblKhachHang);
		
		
		lblTruoc = new JLabel("1");
		lblTruoc.setBounds(330, 489, 17, 14);
		getContentPane().add(lblTruoc);
		
		
		fillTable(dao.sellectAllKhachHang(index));
		double size = (double) dao.selectAll().size()/5;
		int rows = (int) Math.ceil(size);
		lblTruoc.setText("1");
		
		
		
		JButton btnTruoc = new JButton("");
		btnTruoc.setIcon(new ImageIcon(QuanLyKhachHang.class.getResource("/com/shoplaptop/icon/sau.png")));
		btnTruoc.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTruoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index > 1) {
					--index;
					lblTruoc.setText(index+"");
					fillTable(dao.sellectAllKhachHang((index-1)*5+1));
					
					
				}
			}
		});
		btnTruoc.setBounds(263, 485, 57, 23);
		getContentPane().add(btnTruoc);

		btnSau = new JButton("");
		btnSau.setIcon(new ImageIcon(QuanLyKhachHang.class.getResource("/com/shoplaptop/icon/truoc.png")));
		btnSau.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSau.setBackground(new Color(240, 240, 240));
		
		
		btnSau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index < rows) {
					++index;
					lblTruoc.setText(index+"");
					fillTable(dao.sellectAllKhachHang((index-1)*5+1));
					
					
				}
			}
		});
		btnSau.setBounds(408, 485, 51, 23);
		getContentPane().add(btnSau);
		
		
		lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTo.setBounds(357, 489, 17, 14);
		getContentPane().add(lblTo);
		
		lblSau = new JLabel("-");
		lblSau.setBounds(383, 489, 27, 14);
		getContentPane().add(lblSau);
		lblSau.setText(rows+"");
		fillTable(new KhachHangDAO().sellectAllKhachHang(1));

	}
	public void fillTable(List<KhachHang> list) {
		model.setRowCount(0);
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
		ChiTietKhachHang.dateChooser.setDate(khachHang.getNgaySinh());
		ChiTietKhachHang.rdoNam.setSelected(khachHang.isGioiTinh());
		ChiTietKhachHang.rdoNu.setSelected(!khachHang.isGioiTinh());
		ChiTietKhachHang.txtEmail.setText(khachHang.getEmail());
		ChiTietKhachHang.txtDiaChi.setText(khachHang.getDiaChi());	
	}
	public void findSDT() {
		String soDienThoai =  txtTimKiem.getText();
		if (soDienThoai.trim().isEmpty()) {
			soDienThoai="%%";
		}
		list = dao.selectBySQL(selectBySDT, "%" + soDienThoai+"%" , "%" + soDienThoai+"%");
		fillTable(list);
		lblSau.setText("1");
		
	}
//	public void findMaKH() {
//		String maKH =  txtTimKiem.getText();
//		if (maKH.trim().isEmpty()) {
//			maKH="";
//		}
//		ArrayList<KhachHang> listKH = new ArrayList<>();
//		listKH.add(new KhachHangDAO().selectById(maKH));
//		model.setRowCount(0);
//		for (KhachHang khachHang : listKH) {
//			Object[] rows = new Object[] {
//					khachHang.getMaKH(),
//					khachHang.getHoTen(),
//					khachHang.getSoDienThoai(),
//					khachHang.getDiaChi()
//			};
//			model.addRow(rows);
//			
//		}
//		fillTable();
//		
//	}
	
	public void updateKH(KhachHang khachHang) {

		try {
			MsgBox.alert(getContentPane(),new KhachHangDAO().update(khachHang) );
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	

	}


