package com.shoplaptop.ui;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.File;
import java.io.StreamCorruptedException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.shoplaptop.dao.NhanVienService;
import com.shoplaptop.dao.TaiKhoanDAO;
import com.shoplaptop.entity.NhanVien;
import com.shoplaptop.entity.TaiKhoan;
import com.shoplaptop.utils.Auth;
import com.shoplaptop.utils.MsgBox;
import com.shoplaptop.utils.XDate;
import com.shoplaptop.utils.XImage;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class QLNhanVien extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField txtmanhanvien;
	private JTextField txttennhanvien;
	private JTextField txtdiachi;
	private JTextField txtemail;
	private JTextField txtngaysinh;
	private JTextField txttendangnhap;
	private JTextField txtsodienthoai;
	private JTable tblquanlynhanvien;
	private ButtonGroup buttonGroup;
	private DefaultTableModel model;
	private List<NhanVien> list = new ArrayList<>();
	private List<TaiKhoan> list2;
	private JRadioButton rdonam;
	private JRadioButton rdonu;
	private JLabel lblimage;
	private NhanVienService service = new NhanVienService();
	private JRadioButton rdonhanvien;
//	private XDate xDate;
	private JRadioButton rdoquanly;
	
	
	private ButtonGroup buttonGroup_1;
	private JPasswordField txtmatkhau;
	private TaiKhoanDAO dao = new TaiKhoanDAO();
	private JTextField txttimkiem;
	private LS_NhanVien ls_NhanVien = new LS_NhanVien(QLNhanVien.this);
	private int index = 1;
	
	
	
	String selectSQl_PhânTrang = "SELECT * FROM\r\n"
			+ "    (SELECT ROW_NUMBER() OVER (ORDER BY MaNV) AS rownum,  * FROM dbo.NhanVien)\r\n"
			+ "    AS temp\r\n"
			+ "    WHERE rownum BETWEEN 1 AND 3";
	String SelectById_SQL = "SELECT NhanVien.MaNV,HoTen,SoDienThoai,NgaySinh,GioiTinh,Email,Hinh,DiaChi,VaiTro FROM dbo.NhanVien JOIN dbo.TaiKhoan ON TaiKhoan.MaNV = NhanVien.MaNV Where NhanVien.MaNV like ? OR HoTen LIKE ? OR SoDienThoai LIKE ? ";
	private JLabel lbldem;
	private JLabel lblTo;
	private JLabel lblTo_1;
	private double size;
	private int rows;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLNhanVien dialog = new QLNhanVien();
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
	public QLNhanVien() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(QLNhanVien.class.getResource("/com/shoplaptop/icon/365_1.png")));
		setTitle("ShopLapTop365");
		setBounds(100, 100, 1050, 605);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản lý nhân viên ");
		lblNewLabel.setIcon(new ImageIcon(QLNhanVien.class.getResource("/com/shoplaptop/icon/User.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(385, 10, 245, 44);
		getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 64, 1016, 2);
		getContentPane().add(separator);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 178, 143, 169);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblimage = new JLabel("          ChooseImage");
		lblimage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chooseImage();
			}
		});
		lblimage.setBounds(0, 0, 143, 188);
		panel.add(lblimage);
		
		JLabel lblNewLabel_2 = new JLabel("Mã nhân viên ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(163, 194, 90, 13);
		getContentPane().add(lblNewLabel_2);
		
		txtmanhanvien = new JTextField();
		txtmanhanvien.setBounds(274, 193, 154, 19);
		getContentPane().add(txtmanhanvien);
		txtmanhanvien.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên nhân viên ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(163, 247, 101, 13);
		getContentPane().add(lblNewLabel_2_1);
		
		txttennhanvien = new JTextField();
		txttennhanvien.setColumns(10);
		txttennhanvien.setBounds(274, 241, 154, 19);
		getContentPane().add(txttennhanvien);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Địa Chỉ ");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(163, 291, 90, 13);
		getContentPane().add(lblNewLabel_2_1_1);
		
		txtdiachi = new JTextField();
		txtdiachi.setColumns(10);
		txtdiachi.setBounds(274, 290, 154, 19);
		getContentPane().add(txtdiachi);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Email");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2.setBounds(459, 194, 90, 13);
		getContentPane().add(lblNewLabel_2_1_2);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(553, 193, 154, 19);
		getContentPane().add(txtemail);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Ngày sinh");
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2_1.setBounds(459, 245, 90, 17);
		getContentPane().add(lblNewLabel_2_1_2_1);
		
		txtngaysinh = new JTextField();
		txtngaysinh.setColumns(10);
		txtngaysinh.setBounds(553, 241, 154, 19);
		getContentPane().add(txtngaysinh);
		
		JLabel lblNewLabel_2_1_2_1_1 = new JLabel("Giới tính ");
		lblNewLabel_2_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2_1_1.setBounds(459, 291, 90, 13);
		getContentPane().add(lblNewLabel_2_1_2_1_1);
		
		rdonam = new JRadioButton("Nam ");
		rdonam.setBounds(542, 289, 72, 21);
		getContentPane().add(rdonam);
		
		rdonu = new JRadioButton("Nữ ");
		rdonu.setBounds(643, 289, 72, 21);
		getContentPane().add(rdonu);
		
		JLabel lblNewLabel_2_1_2_2 = new JLabel("Tên đăng nhập ");
		lblNewLabel_2_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2_2.setBounds(746, 191, 101, 19);
		getContentPane().add(lblNewLabel_2_1_2_2);
		
		txttendangnhap = new JTextField();
		txttendangnhap.setColumns(10);
		txttendangnhap.setBounds(857, 193, 154, 19);
		getContentPane().add(txttendangnhap);
		
		JLabel lblNewLabel_2_1_2_3 = new JLabel("Mật khẩu ");
		lblNewLabel_2_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2_3.setBounds(746, 244, 90, 18);
		getContentPane().add(lblNewLabel_2_1_2_3);
		
		JLabel lblNewLabel_2_1_2_4 = new JLabel("Số điện thoại ");
		lblNewLabel_2_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2_4.setBounds(746, 291, 90, 13);
		getContentPane().add(lblNewLabel_2_1_2_4);
		
		txtsodienthoai = new JTextField();
		txtsodienthoai.setColumns(10);
		txtsodienthoai.setBounds(856, 285, 154, 19);
		getContentPane().add(txtsodienthoai);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 370, 1000, 156);
		getContentPane().add(scrollPane);
		
		model = new DefaultTableModel();
		String[] colums = new String[] {"Mã nhân viên","Tên nhân viên","Địa chỉ","Email","Ngày Sinh","Giới tính","Số điện thoại","Hình","Vai Trò"};
		model.setColumnIdentifiers(colums);
		
		
		tblquanlynhanvien = new JTable(model);
		tblquanlynhanvien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean check = true;
				int index = tblquanlynhanvien.getSelectedRow();
				try {
					if (index == -1) {
						check = false;	
					}
				} catch (Exception e2) {
					MsgBox.alert(contentPanel, "Vui lòng chọn nhân viên");
					check = false;
				}
				if (check) {
					new LS_NhanVien(QLNhanVien.this).setVisible(true);
					setFormChiTiet(new NhanVienService().selectById(String.valueOf(tblquanlynhanvien.getValueAt(index, 0))));
				}
			}
		});
		scrollPane.setViewportView(tblquanlynhanvien);
		filltable(service.sellectAllNhanVien(1));
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdonu);
		buttonGroup.add(rdonam);
		
		JButton btnthemmoi = new JButton("Thêm mới ");
		btnthemmoi.setIcon(new ImageIcon(QLNhanVien.class.getResource("/com/shoplaptop/icon/Add.png")));
		btnthemmoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (vali()) {
					int insert = JOptionPane.showConfirmDialog(contentPanel, "Bạn có muốn thêm không");
					if (insert == JOptionPane.YES_OPTION) {
						insert();
					}
				}
			}
		});
		btnthemmoi.setBounds(869, 100, 122, 34);
		getContentPane().add(btnthemmoi);
		
		JButton btntimkiem = new JButton("Tìm kiếm ");
		btntimkiem.setIcon(new ImageIcon(QLNhanVien.class.getResource("/com/shoplaptop/icon/Search.png")));
		btntimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String manv = txtmanhanvien.getText();
//				if (findbyid(manv)== null) {
//					JOptionPane.showMessageDialog(contentPanel, "Không tìm thấy");
//				}else {
//					setForm(findbyid(manv));
//					setForm_1(findbyid_1(manv));
//				}
				FindMaNV();
//				FindTenNV();
			}
		});
		btntimkiem.setBounds(703, 100, 120, 34);
		getContentPane().add(btntimkiem);
		
		JLabel lblNewLabel_2_1_2_1_1_1 = new JLabel("Vai trò");
		lblNewLabel_2_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2_1_1_1.setBounds(163, 334, 90, 13);
		getContentPane().add(lblNewLabel_2_1_2_1_1_1);
		
		rdonhanvien = new JRadioButton("Nhân Viên ");
		rdonhanvien.setBounds(259, 326, 90, 21);
		getContentPane().add(rdonhanvien);
		
		rdoquanly = new JRadioButton("Quản Lý");
		rdoquanly.setBounds(368, 326, 72, 21);
		getContentPane().add(rdoquanly);
		
		buttonGroup_1 = new ButtonGroup();
		
		buttonGroup_1.add(rdonhanvien);
		buttonGroup_1.add(rdoquanly);
		
		txtmatkhau = new JPasswordField();
		txtmatkhau.setBounds(856, 246, 154, 19);
		getContentPane().add(txtmatkhau);
		
		txttimkiem = new JTextField();
		txttimkiem.setBounds(10, 104, 665, 27);
		getContentPane().add(txttimkiem);
		txttimkiem.setColumns(10);
		
		
		lbldem = new JLabel("1");
		lbldem.setBounds(857, 541, 16, 13);
		getContentPane().add(lbldem);
		lblTo = new JLabel("to");
		lblTo.setBounds(869, 541, 16, 13);
		getContentPane().add(lblTo);
		
		lblTo_1 = new JLabel("-");
		lblTo_1.setBounds(883, 541, 16, 13);
		getContentPane().add(lblTo_1);
		
		JButton btnprev = new JButton("Trước ");
		filltable(service.sellectAllNhanVien(index));
		size = (double) service.selectAll().size()/3; 
		rows = (int) Math.ceil(size);
		lbldem.setText("1");
		btnprev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index > 1) {
					--index;
					lbldem.setText(index + "");
					filltable(service.sellectAllNhanVien((index - 1)*3+1));
				}
			}
		});
		btnprev.setBounds(762, 537, 85, 21);
		getContentPane().add(btnprev);		
		JButton btnnext = new JButton("Sau");
		btnnext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index < rows) {
					++index;
					lbldem.setText(index + "");
					filltable(service.sellectAllNhanVien((index - 1)*3+1));
				}
				
			}
		});
		btnnext.setBounds(909, 537, 85, 21);
		getContentPane().add(btnnext);
		
		
		
		lblTo_1.setText(rows+"");
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.setIcon(new ImageIcon(QLNhanVien.class.getResource("/com/shoplaptop/icon/Refresh.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnNewButton.setBounds(20, 530, 101, 27);
		getContentPane().add(btnNewButton);
	//	settable();
	}
	public void filltable(List<NhanVien> list) {
		model.setRowCount(0);
//		list =  new NhanVienService().selectAll();
		for (NhanVien nhanVien : list) {
			Object[] rows = new Object[] {
					nhanVien.getMaNV(),
					nhanVien.getHoTen(),
					nhanVien.getDiaChi(),
					nhanVien.getEmail(),
					XDate.toString(nhanVien.getNgaySinh(), "yyyy-MM-dd"),
					nhanVien.isGioiTinh() ? "Nam": "Nữ",
//					nhanVien.getTendangnhap(),
//					nhanVien.getMatkhau(),
					nhanVien.getSoDienThoai(),
					nhanVien.getHinh(),
					nhanVien.isVaiTro() ? "Quản Lý" : "Nhân Viên"
			};
			model.addRow(rows);
			
		}
		
	}
	
	public void setForm(NhanVien nhanVien) {
		
		txtmanhanvien.setText(nhanVien.getMaNV());
		txttennhanvien.setText(nhanVien.getHoTen());
		txtdiachi.setText(nhanVien.getDiaChi());
		txtemail.setText(nhanVien.getEmail());
		txtngaysinh.setText(XDate.toString(nhanVien.getNgaySinh(),"yyyy-MM-dd"));
		rdonam.setSelected(nhanVien.isGioiTinh());
		rdonu.setSelected(!nhanVien.isGioiTinh());
		//txttendangnhap.setText(taiKhoan.getTenDangNhap());
		//txtmatkhau.setText(nhanVien.getTendangnhap());
		txtsodienthoai.setText(nhanVien.getSoDienThoai());
		if (nhanVien.getHinh()!=null) {
			lblimage.setToolTipText(nhanVien.getHinh());
			lblimage.setIcon(XImage.read(nhanVien.getHinh()));
		}
		rdoquanly.setSelected(nhanVien.isVaiTro());
		rdonhanvien.setSelected(!nhanVien.isVaiTro());
	}
	public void setForm_1(TaiKhoan taiKhoan) {
		txttendangnhap.setText(taiKhoan.getTenDangNhap());
		txtmatkhau.setText(taiKhoan.getMatKhau());
	}
	
	public NhanVien getForm() {
		NhanVien nhanVien = new NhanVien();
		nhanVien.setMaNV(txtmanhanvien.getText());
		nhanVien.setHoTen(txttennhanvien.getText());
		nhanVien.setDiaChi(txtdiachi.getText());
		nhanVien.setEmail(txtemail.getText());
		nhanVien.setNgaySinh(XDate.toDate(txtngaysinh.getText(), "yyyy-MM-dd"));
		nhanVien.setGioiTinh(rdonam.isSelected());
//		nhanVien.setTendangnhap(txttendangnhap.getText());
//		nhanVien.setMatkhau(txtmatkhau.getText());
		nhanVien.setSoDienThoai(txtsodienthoai.getText());
		nhanVien.setHinh(lblimage.getToolTipText());
//		nhanVien.setVaitro(rdoquanly.isSelected());
		return nhanVien;
	}
	
	public TaiKhoan getFormTaiKhoan() {
		TaiKhoan taiKhoan = new TaiKhoan();
		taiKhoan.setMaNV(txtmanhanvien.getText());
		taiKhoan.setTenDangNhap(txttendangnhap.getText());
		taiKhoan.setMatKhau(String.valueOf(txtmatkhau.getPassword()));
		taiKhoan.setVaiTro(rdoquanly.isSelected());
		return taiKhoan;
	}
	public void chooseImage() {
		try {
			JFileChooser fileChooser = new JFileChooser();
			if (fileChooser.showOpenDialog(getContentPane()) == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				XImage.save(file);
				ImageIcon icon = XImage.read(file.getName());
				lblimage.setIcon(icon);
				lblimage.setToolTipText(file.getName());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void clearForm () {
		lblimage.setIcon(null);
		txtdiachi.setText(null);
		txtemail.setText(null);
		txtmatkhau.setText(null);
		txtmanhanvien.setText(null);
		txttendangnhap.setText(null);
		txttennhanvien.setText(null);
		txtngaysinh.setText(null);
		txtsodienthoai.setText(null);
		buttonGroup.clearSelection();
		buttonGroup_1.clearSelection();		
	}
	public void insert() {
		NhanVien nhanVien = getForm();
		TaiKhoan taiKhoan = getFormTaiKhoan();
		try {
			service.insert(nhanVien);
			dao.insert(taiKhoan);
//			filltable(service.selectAll());
			filltable(service.sellectAllNhanVien((index - 1)*3+1));
			
			clearForm();
			MsgBox.alert(contentPanel,"Insert thành công");
		} catch (Exception e) {
			System.out.println(e);
			MsgBox.alert(contentPanel, "Insert thất bại");
			// TODO: handle exception
		}
	}
//	public NhanVien findbyid(String manv) {
//		list = (ArrayList<NhanVien>) service.selectAll();
//		for (NhanVien nhanVien : list) {
//			if (nhanVien.getMaNV().equalsIgnoreCase(manv)) {
//				return nhanVien;
//			}
//		}
//		return null;
//	}
	
	public void FindMaNV() {
		String manv_1 = txttimkiem.getText();
		if (manv_1.trim().isEmpty()) {
			manv_1 = "%%";
			
		}
		list = service.selectBySQL(SelectById_SQL, "%" + manv_1 + "%","%" + manv_1 + "%" , "%" + manv_1 + "%");
		
//		model.setRowCount(0);
//		for (NhanVien nhanVien : list) {
//			Object [] rows = new Object[] {
//					nhanVien.getMaNV(),
//					nhanVien.getHoTen(),
//					nhanVien.getDiaChi(),
//					nhanVien.getEmail(),
//					XDate.toString(nhanVien.getNgaySinh(), "YYYY-MM-dd"),
//					nhanVien.isGioiTinh()? "Nam":"Nữ",
//					nhanVien.getSoDienThoai(),
//					nhanVien.getHinh(),
//					nhanVien.isVaitro() ? "Quản Lý": "Nhân viên"
//			};
//			model.addRow(rows);
//		}	
		filltable(list);
	}
//	public void FindTenNV() {
//		String manv_1 = txttimkiem.getText();
//		if (manv_1.trim().isEmpty()) {
//			manv_1 = "%%";
//		}
//		List<NhanVien> listNV_1 = new ArrayList<>();
//		
//		listNV_1 = service.selectBySQL(SelectById_SQL_1,manv_1);
//		filltable(listNV_1);
//	}
	
	public TaiKhoan findbyid_1(String manv) {
		list2 = dao.selectAll();
		for (TaiKhoan taiKhoan : list2) {
			if (taiKhoan.getMaNV().equalsIgnoreCase(manv)) {
				return taiKhoan;
			}
		}
		return null;
	}
	
	public void Update(NhanVien nhanVien) {
		try {
			MsgBox.alert(contentPanel, service.update(nhanVien));
			filltable(service.selectAll());
		} catch (Exception e) {
			
		}
	}
//	public void Updatetaikhoan(TaiKhoan taiKhoan) {
//		try {
//			MsgBox.alert(contentPanel, dao.update(taiKhoan));
//			filltable(dao.selectAll());
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	
	public void delete(NhanVien nhanVien) {
		try {
			MsgBox.alert(contentPanel, service.delete(nhanVien.getMaNV()));
			filltable(service.selectAll());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public boolean vali() {
		if (lblimage.getIcon() == null) {
			JOptionPane.showMessageDialog(contentPanel, "Hình nhân viên k được để trống");
			return false;
		}
		if (txtmanhanvien.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(contentPanel, "Mã nhân viên k được để trống");
			return false;
		}
		if (txttennhanvien.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(contentPanel, "Tên nhân viên k được để trống");
			return false;
		}
		if (txtdiachi.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(contentPanel, "Địa chỉ nhân viên k được để trống");
			return false;
		}
		if (txtemail.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(contentPanel, "Email nhân viên k được để trống");
			return false;
		}
		if (txtngaysinh.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(contentPanel, "Ngày sinh nhân viên k được để trống");
			return false;
		}
		if (!rdonam.isSelected() && !rdonu.isSelected()) {
			JOptionPane.showMessageDialog(contentPanel, "Bạn chưa chọn giới tính");
			return false;
		}
		if (txttendangnhap.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(contentPanel, "Tên đăng nhập k được để trống");
			return false;
		}
		if (txtmatkhau.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(contentPanel, "Mật khẩu nhân viên k được để trống");
			return false;
		}
		if (txtsodienthoai.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(contentPanel, "SĐT nhân viên k được để trống");
			return false;
		}
		if (!rdonhanvien.isSelected() && !rdoquanly.isSelected()) {
			JOptionPane.showMessageDialog(contentPanel, "Bạn chưa chọn vai trò nhân viên");
			return false;
		}
		
		return true;
	}
	
	public void setFormChiTiet(NhanVien nhanVien) {
		LS_NhanVien.txtdiachi.setText(nhanVien.getDiaChi());
		LS_NhanVien.txtmanhanvien.setText(nhanVien.getMaNV());
		LS_NhanVien.txttennhanvien.setText(nhanVien.getHoTen());
		LS_NhanVien.txtemail.setText(nhanVien.getEmail());
		LS_NhanVien.txtngaysinh.setText(XDate.toString(nhanVien.getNgaySinh(), "YYYY-MM-dd"));
		LS_NhanVien.txtsodeinthoai.setText(nhanVien.getSoDienThoai());
		LS_NhanVien.rdonam.setSelected(nhanVien.isGioiTinh());
		LS_NhanVien.rdonu.setSelected(!nhanVien.isGioiTinh());
		LS_NhanVien.rdoquanly.setSelected(nhanVien.isVaiTro());
		LS_NhanVien.rdonhanvien.setSelected(!nhanVien.isVaiTro());
		LS_NhanVien.lblimage.setIcon(XImage.read(nhanVien.getHinh()));
		LS_NhanVien.lblimage.setToolTipText(nhanVien.getHinh());
	}
	
	
	public void settable() {
		size = service.selectAll().size()/3;
		rows = (int) Math.ceil(size);
		lblTo_1.setText(rows+"");
	}
}
