package com.shoplaptop.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import com.shoplaptop.dao.CTHoaDonDAO;
import com.shoplaptop.dao.CTPhieuDoiDAO;
import com.shoplaptop.dao.HoaDonDAO;
import com.shoplaptop.dao.PhieuDoiDAO;
import com.shoplaptop.dao.SerialNumberDAO;
import com.shoplaptop.entity.CTHoaDon;
import com.shoplaptop.entity.CTPhieuDoi;
import com.shoplaptop.entity.HoaDon;
import com.shoplaptop.entity.PhieuDoi;
import com.shoplaptop.entity.SerialNumber;
import com.shoplaptop.utils.Auth;
import com.shoplaptop.utils.MsgBox;
import com.shoplaptop.utils.XDate;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ThemPhieuDoi extends JDialog {
	public static DefaultTableModel model;
	public static DefaultTableModel model1;
	PhieuDoiDAO phieuDoiDAO = new PhieuDoiDAO();
	List<PhieuDoi> listPhieuDoi = new ArrayList<PhieuDoi>();
	HoaDonDAO hoaDonDAO = new HoaDonDAO();
	List<HoaDon> listHoaDon = new ArrayList<HoaDon>();
	PhieuDoi phieuDoi;
	private JPanel getconJPanel;
	private JTextField txtMaPhieuDoi;
	private JTable tblSpDaMua;
	private JTable tblChiTietSanPhamDaMua;
	private JTextField txtLiDo;
	public static JTextField txtMaHD;
	public static JTextField txtMaKH;
	public static JTextField txtMaNV;
	private JButton btnDoi;
	private JTextArea txtSerialNew;
	private JButton btnAddPhieuDoi;
	private String SelectSPMUAChiTiet = "SELECT dbo.Serial.SerialNumber , dbo.BienThe.Gia , dbo.Laptop.TenLaptop	FROM dbo.HoaDon JOIN dbo.CTHoaDon ON CTHoaDon.MaHD = HoaDon.MaHD JOIN dbo.Serial ON Serial.ID = CTHoaDon.ID_Serial JOIN dbo.BienThe ON BienThe.ID = Serial.ID_BienThe "
			+ "JOIN dbo.Laptop ON Laptop.ID = BienThe.ID_Laptop WHERE HoaDon.MaHD = ? and SerialNumber = ?";
	private List<HoaDon> list = new ArrayList<HoaDon>();
	private int rows = -1;
	private CTHoaDon ctHoaDon = new CTHoaDon();
	static List<CTHoaDon> listCT = new ArrayList<CTHoaDon>();
	private String[] lines = {};

	/**
	 * Create the dialog.
	 */
	public ThemPhieuDoi() {
		setBounds(100, 100, 1028, 675);
		setLocationRelativeTo(this);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" PHIẾU ĐỔI");
		lblNewLabel.setForeground(new Color(255, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(10, 28, 212, 45);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Phiếu Đổi");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(45, 112, 126, 27);
		getContentPane().add(lblNewLabel_1);
		
		txtMaPhieuDoi = new JTextField();
		txtMaPhieuDoi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtMaPhieuDoi.setColumns(10);
		txtMaPhieuDoi.setBounds(217, 102, 388, 37);
		getContentPane().add(txtMaPhieuDoi);
		
		JLabel lblNewLabel_2 = new JLabel("Sản phẩm Đã Mua");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(45, 208, 156, 31);
		getContentPane().add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 249, 557, 120);
		getContentPane().add(scrollPane);
		
		model = new DefaultTableModel();
		String[] cols = {"ID", "SerialNumber", "Tên Laptop", "Giá" };
		model.setColumnIdentifiers(cols);
		
		tblSpDaMua = new JTable(model);
		tblSpDaMua.setRowMargin(3);
		tblSpDaMua.setRowHeight(25);
		tblSpDaMua.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblSpDaMua);
		
		JLabel lblNewLabel_2_1 = new JLabel("Chi Tiết Sản Phẩm Muốn Đổi");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(45, 379, 262, 31);
		getContentPane().add(lblNewLabel_2_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(45, 420, 560, 120);
		getContentPane().add(scrollPane_1);
		
		model1 = new DefaultTableModel();
		String[] colss = { "ID","SerialNumber", "Tên Laptop", "Giá" };
		model1.setColumnIdentifiers(colss);
		
		tblChiTietSanPhamDaMua = new JTable(model1);
		tblChiTietSanPhamDaMua.setRowMargin(3);
		tblChiTietSanPhamDaMua.setRowHeight(25);
		tblChiTietSanPhamDaMua.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tblChiTietSanPhamDaMua);
		
		btnDoi = new JButton("Đổi");
		btnDoi.setForeground(new Color(64, 0, 0));
		btnDoi.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDoi.setBackground(new Color(255, 179, 179));
		btnDoi.setBounds(543, 215, 62, 27);
		getContentPane().add(btnDoi);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Serial");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(651, 340, 68, 19);
		getContentPane().add(lblNewLabel_1_1_1);
		
		txtSerialNew = new JTextArea();
		txtSerialNew.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtSerialNew.setBounds(651, 373, 335, 71);
		getContentPane().add(txtSerialNew);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("Lí Do");
		lblNewLabel_3_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3_2_1_1.setBounds(651, 460, 62, 20);
		getContentPane().add(lblNewLabel_3_2_1_1);
		
		txtLiDo = new JTextField();
		txtLiDo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtLiDo.setColumns(10);
		txtLiDo.setBounds(651, 495, 335, 45);
		getContentPane().add(txtLiDo);
		
		JLabel lblNewLabel_2_2 = new JLabel("Hóa Đơn");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(653, 83, 87, 20);
		getContentPane().add(lblNewLabel_2_2);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(653, 112, 333, 203);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("MaHD");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 30, 76, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("MaKH");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(10, 89, 76, 20);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("MaNV");
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3_2.setBounds(10, 149, 76, 20);
		panel.add(lblNewLabel_3_2);
		
		txtMaHD = new JTextField();
		txtMaHD.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(96, 22, 216, 34);
		panel.add(txtMaHD);
		
		txtMaKH = new JTextField();
		txtMaKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(96, 81, 216, 34);
		panel.add(txtMaKH);
		
		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(96, 141, 216, 34);
		panel.add(txtMaNV);
		
		btnAddPhieuDoi = new JButton("Lưu Phiếu Đổi");
		btnAddPhieuDoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int config = JOptionPane.showConfirmDialog(getContentPane(), "Bạn có chắc chắn muốn thêm không?");
					if (config == JOptionPane.YES_OPTION) {
						phieuDoiDAO.insert(getModelPhieuDoi());
						int row = tblChiTietSanPhamDaMua.getRowCount();
						lines = txtSerialNew.getText().split("\n");
						for (int i = 0; i < row; i++) {
							new CTPhieuDoiDAO().insert(getModelCtPhieuDoi(i));
						}
					}
					MsgBox.alert(getContentPane(), "Insert thành công");
					dispose();
					new ChiTietPhieuDoiView().setVisible(true);
					FormDanhSachPhieuDoi.setFormPhieuDoi(new PhieuDoiDAO().selectById(txtMaPhieuDoi.getText()));
					FormDanhSachPhieuDoi.fillTableCTPhieuDoi2(txtMaPhieuDoi.getText());
					
				} catch (Exception e2) {
					MsgBox.alert(getContentPane(), "Nhập lại dữ liệu");
				}
			}
		});
		btnAddPhieuDoi.setForeground(new Color(64, 0, 0));
		btnAddPhieuDoi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnAddPhieuDoi.setBackground(new Color(255, 196, 196));
		btnAddPhieuDoi.setBounds(814, 559, 172, 54);
		getContentPane().add(btnAddPhieuDoi);
		
		
		tblSpDaMua.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				rows = tblSpDaMua.getSelectedRow();
				ctHoaDon = new CTHoaDonDAO().selectById((Integer) tblSpDaMua.getValueAt(rows, 0));
			}
		});
		btnDoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listCT.add(ctHoaDon);
				fillTableSPDoi(listCT);
			}
		});
	}
	
	public static void fillTableSPDaMua(List<CTHoaDon> list) {
		model.setRowCount(0);
		try {
			for (CTHoaDon ctHoaDon : list) {
				Object[] rows = new Object[] {
					ctHoaDon.getID(),
					ctHoaDon.getSerialNumber(),
					ctHoaDon.getTenLaptop(),
					FormDanhSachPhieuDoi.decimalFormat(ctHoaDon.getGia())
				};
				model.addRow(rows);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void fillTableSPDoi(List<CTHoaDon> list) {
		model1.setRowCount(0);
		try {
			for (CTHoaDon ctHoaDon : list) {
				Object[] rows = new Object[] {
					ctHoaDon.getID(),
					ctHoaDon.getSerialNumber(),
					ctHoaDon.getTenLaptop(),
					FormDanhSachPhieuDoi.decimalFormat(ctHoaDon.getGia())
				};
				model1.addRow(rows);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public PhieuDoi getModelPhieuDoi() {
		String MaPhieuDoi = txtMaPhieuDoi.getText();
		String MaKH = txtMaKH.getText();
		String MaHD = txtMaHD.getText();
		HoaDon hoaDon = new HoaDonDAO().selectById(MaHD);
		int IDHoaDon = hoaDon.getID();
		String MaNV = Auth.user.getMaNV();
		Date nowDate = new Date();
		Date NgayTao = XDate.toDate(XDate.toString(nowDate, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss");
		String LiDo = txtLiDo.getText();
		PhieuDoi phieuDoi = new PhieuDoi(MaPhieuDoi, MaKH, IDHoaDon, MaNV, NgayTao, LiDo);
		return phieuDoi;
	}
	
	public CTPhieuDoi getModelCtPhieuDoi(int i) {
		String MaPD = txtMaPhieuDoi.getText();
		PhieuDoi phieuDoi = new PhieuDoiDAO().selectById(MaPD);
		int IDPhieuDoi = phieuDoi.getID();
		String SerialOld = (String) tblChiTietSanPhamDaMua.getValueAt(i, 1);
		SerialNumber serialNumberOld = new SerialNumberDAO().selectById(SerialOld);
		int ID_SerialOld = serialNumberOld.getId();
		String SerialNew = lines[i];
		SerialNumber serialNumberNew = new SerialNumberDAO().selectById(SerialNew);
		int ID_SerialNew = serialNumberNew.getId();
		CTPhieuDoi ctPhieuDoi = new CTPhieuDoi(IDPhieuDoi, ID_SerialOld, ID_SerialNew);
		return ctPhieuDoi;
	}
}
