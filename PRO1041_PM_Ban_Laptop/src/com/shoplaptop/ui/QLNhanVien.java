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
import com.shoplaptop.entity.NhanVien;
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

public class QLNhanVien extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField txtmanhanvien;
	private JTextField txttennhanvien;
	private JTextField txtdiachi;
	private JTextField txtemail;
	private JTextField txtngaysinh;
	private JTextField txttendangnhap;
	private JTextField txtmatkhau;
	private JTextField txtsodienthoai;
	private JTable tblquanlynhanvien;
	private ButtonGroup buttonGroup;
	private DefaultTableModel model;
	private ArrayList<NhanVien> list;
	private JRadioButton rdonam;
	private JRadioButton rdonu;
	private JLabel lblimage;
	private NhanVienService service = new NhanVienService();
	private JRadioButton rdonhanvien;
//	private XDate xDate;
	private JRadioButton rdoquanly;
private ButtonGroup buttonGroup_1;

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
		setBounds(100, 100, 1050, 526);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản lý nhân viên ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 20, 219, 34);
		getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 64, 1016, 2);
		getContentPane().add(separator);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 76, 143, 169);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblimage = new JLabel("");
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
		lblNewLabel_2.setBounds(163, 88, 90, 13);
		getContentPane().add(lblNewLabel_2);
		
		txtmanhanvien = new JTextField();
		txtmanhanvien.setBounds(274, 87, 154, 19);
		getContentPane().add(txtmanhanvien);
		txtmanhanvien.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên nhân viên ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(163, 148, 101, 13);
		getContentPane().add(lblNewLabel_2_1);
		
		txttennhanvien = new JTextField();
		txttennhanvien.setColumns(10);
		txttennhanvien.setBounds(274, 147, 154, 19);
		getContentPane().add(txttennhanvien);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Địa Chỉ ");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(163, 205, 90, 13);
		getContentPane().add(lblNewLabel_2_1_1);
		
		txtdiachi = new JTextField();
		txtdiachi.setColumns(10);
		txtdiachi.setBounds(274, 204, 154, 19);
		getContentPane().add(txtdiachi);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Email");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2.setBounds(459, 89, 90, 13);
		getContentPane().add(lblNewLabel_2_1_2);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(553, 88, 154, 19);
		getContentPane().add(txtemail);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Ngày sinh");
		lblNewLabel_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2_1.setBounds(459, 149, 90, 17);
		getContentPane().add(lblNewLabel_2_1_2_1);
		
		txtngaysinh = new JTextField();
		txtngaysinh.setColumns(10);
		txtngaysinh.setBounds(553, 148, 154, 19);
		getContentPane().add(txtngaysinh);
		
		JLabel lblNewLabel_2_1_2_1_1 = new JLabel("Giới tính ");
		lblNewLabel_2_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2_1_1.setBounds(459, 207, 90, 13);
		getContentPane().add(lblNewLabel_2_1_2_1_1);
		
		rdonam = new JRadioButton("Nam ");
		rdonam.setBounds(553, 203, 72, 21);
		getContentPane().add(rdonam);
		
		rdonu = new JRadioButton("Nữ ");
		rdonu.setBounds(649, 203, 72, 21);
		getContentPane().add(rdonu);
		
		JLabel lblNewLabel_2_1_2_2 = new JLabel("Tên đăng nhập ");
		lblNewLabel_2_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2_2.setBounds(746, 89, 101, 19);
		getContentPane().add(lblNewLabel_2_1_2_2);
		
		txttendangnhap = new JTextField();
		txttendangnhap.setColumns(10);
		txttendangnhap.setBounds(856, 87, 154, 19);
		getContentPane().add(txttendangnhap);
		
		JLabel lblNewLabel_2_1_2_3 = new JLabel("Mật khẩu ");
		lblNewLabel_2_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2_3.setBounds(746, 148, 90, 18);
		getContentPane().add(lblNewLabel_2_1_2_3);
		
		txtmatkhau = new JTextField();
		txtmatkhau.setColumns(10);
		txtmatkhau.setBounds(856, 147, 154, 19);
		getContentPane().add(txtmatkhau);
		
		JLabel lblNewLabel_2_1_2_4 = new JLabel("Số điện thoại ");
		lblNewLabel_2_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2_4.setBounds(746, 206, 90, 13);
		getContentPane().add(lblNewLabel_2_1_2_4);
		
		txtsodienthoai = new JTextField();
		txtsodienthoai.setColumns(10);
		txtsodienthoai.setBounds(856, 204, 154, 19);
		getContentPane().add(txtsodienthoai);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 268, 1000, 196);
		getContentPane().add(scrollPane);
		
		model = new DefaultTableModel();
		String[] colums = new String[] {"Mã nhân viên","Tên nhân viên","Địa chỉ","Email","Ngày Sinh","Giới tính","Tên đăng nhập","Mật khẩu","Số điện thoại","Hình","Vai Trò"};
		model.setColumnIdentifiers(colums);
		
		
		tblquanlynhanvien = new JTable(model);
		tblquanlynhanvien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tblquanlynhanvien.getSelectedRow();
				setForm(new NhanVienService().selectAll().get(index));
			}
		});
		scrollPane.setViewportView(tblquanlynhanvien);
		filltable();
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdonu);
		buttonGroup.add(rdonam);
		
		JButton btnthemmoi = new JButton("Thêm mới ");
		btnthemmoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnthemmoi.setBounds(699, 237, 99, 21);
		getContentPane().add(btnthemmoi);
		
		JButton btnsua = new JButton("Sửa ");
		btnsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnsua.setBounds(825, 237, 85, 21);
		getContentPane().add(btnsua);
		
		JButton btnxoa = new JButton("Xóa");
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnxoa.setBounds(920, 237, 85, 21);
		getContentPane().add(btnxoa);
		
		JButton btntimkiem = new JButton("Tìm kiếm ");
		btntimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String manv = txtmanhanvien.getText();
				if (findbyid(manv)== null) {
					JOptionPane.showMessageDialog(contentPanel, "k tìm thấy");
				}else {
					setForm(findbyid(manv));
				}
			}
		});
		btntimkiem.setBounds(585, 237, 90, 21);
		getContentPane().add(btntimkiem);
		
		JLabel lblNewLabel_2_1_2_1_1_1 = new JLabel("Vai trò");
		lblNewLabel_2_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2_1_1_1.setBounds(163, 239, 90, 13);
		getContentPane().add(lblNewLabel_2_1_2_1_1_1);
		
		rdonhanvien = new JRadioButton("Nhân Viên ");
		rdonhanvien.setBounds(267, 237, 90, 21);
		getContentPane().add(rdonhanvien);
		
		rdoquanly = new JRadioButton("Quản Lý");
		rdoquanly.setBounds(372, 237, 72, 21);
		getContentPane().add(rdoquanly);
		
		buttonGroup_1 = new ButtonGroup();
		
		buttonGroup_1.add(rdonhanvien);
		buttonGroup_1.add(rdoquanly);

	}
	public void filltable() {
		model.setRowCount(0);
		list = (ArrayList<NhanVien>) new NhanVienService().selectAll();
		for (NhanVien nhanVien : list) {
			Object[] rows = new Object[] {
					nhanVien.getMaNV(),
					nhanVien.getHoTen(),
					nhanVien.getDiaChi(),
					nhanVien.getEmail(),
					nhanVien.getNgaySinh(),
					nhanVien.isGioiTinh() ? "Nam": "Nữ",
					nhanVien.getTendangnhap(),
					nhanVien.getMatkhau(),
					nhanVien.getSoDienThoai(),
					nhanVien.getHinh(),
					nhanVien.isVaitro() ? "Quản Lý" : "Nhân Viên"
			};
			model.addRow(rows)	;
		}
		
	}
	
	public void setForm(NhanVien nhanVien) {
		txtmanhanvien.setText(nhanVien.getMaNV());
		txttennhanvien.setText(nhanVien.getHoTen());
		txtdiachi.setText(nhanVien.getDiaChi());
		txtemail.setText(nhanVien.getEmail());
		txtngaysinh.setText(XDate.toString(nhanVien.getNgaySinh(),"YYYY-MM-dd"));
		rdonam.setSelected(nhanVien.isGioiTinh());
		rdonu.setSelected(!nhanVien.isGioiTinh());
		txttendangnhap.setText(nhanVien.getTendangnhap());
		txtmatkhau.setText(nhanVien.getTendangnhap());
		txtsodienthoai.setText(nhanVien.getSoDienThoai());
		if (nhanVien.getHinh()!=null) {
			lblimage.setToolTipText(nhanVien.getHinh());
			lblimage.setIcon(XImage.read(nhanVien.getHinh()));
		}
		rdoquanly.setSelected(nhanVien.isVaitro());
		rdonhanvien.setSelected(!nhanVien.isVaitro());
	}
	
	public NhanVien getForm() {
		NhanVien nhanVien = new NhanVien();
		nhanVien.setMaNV(txtmanhanvien.getText());
		nhanVien.setHoTen(txttennhanvien.getText());
		nhanVien.setDiaChi(txtdiachi.getText());
		nhanVien.setEmail(txtemail.getText());
		nhanVien.setNgaySinh(XDate.toDate(txtngaysinh.getText(), "YYYY-MM-dd"));
		nhanVien.setGioiTinh(rdonam.isSelected());
		nhanVien.setTendangnhap(txttendangnhap.getText());
		nhanVien.setMatkhau(txtmatkhau.getText());
		nhanVien.setSoDienThoai(txtsodienthoai.getText());
		nhanVien.setHinh(lblimage.getToolTipText());
		nhanVien.setVaitro(rdoquanly.isSelected());
		return nhanVien;
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
		try {
			service.insert(nhanVien);
			filltable();
			clearForm();
			MsgBox.alert(contentPanel,"Insert thành công");
		} catch (Exception e) {
			System.out.println(e);
			MsgBox.alert(contentPanel, "Insert thất bại");
			// TODO: handle exception
		}
	}
	public void delete() {
		if (!Auth.isManager()) {
			MsgBox.alert(contentPanel, "Bạn k có quyền xóa");
		} else {
			NhanVien nhanVien = getForm();
			String manv = nhanVien.getMaNV();
			if (MsgBox.confirm(contentPanel, "bạn có xác nhận xóa ")) {	
					try {
						service.delete(manv);
						filltable();
						clearForm();
						MsgBox.alert(contentPanel, "Delete thành công");
					} catch (Exception e) {
						MsgBox.alert(contentPanel,  "Delete k thành công");
						System.out.println(e);
						// TODO: handle exception
					}
			}
		}
	}
	public void update() {
		NhanVien nhanVien = getForm();
		try {
			service.update(nhanVien);
			filltable();
			clearForm();
			MsgBox.alert(contentPanel, "Update thành công");
		} catch (Exception e) {
			MsgBox.alert(contentPanel, "Update k thành công");
			System.out.println(e);
			
		}
	}
	public NhanVien findbyid(String manv) {
		list = (ArrayList<NhanVien>) service.selectAll();
		for (NhanVien nhanVien : list) {
			if (nhanVien.getMaNV().equalsIgnoreCase(manv)) {
				return nhanVien;
			}
		}
		return null;
	}
}
