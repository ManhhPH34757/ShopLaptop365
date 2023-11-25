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
	public DefaultTableModel model;
	public DefaultTableModel model1;
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
	private JComboBox<HoaDon> cboHoaDon;
	private String SelectSPMUAChiTiet = "SELECT dbo.Serial.SerialNumber , dbo.BienThe.Gia , dbo.Laptop.TenLaptop	FROM dbo.HoaDon JOIN dbo.CTHoaDon ON CTHoaDon.MaHD = HoaDon.MaHD JOIN dbo.Serial ON Serial.ID = CTHoaDon.ID_Serial JOIN dbo.BienThe ON BienThe.ID = Serial.ID_BienThe "
			+ "JOIN dbo.Laptop ON Laptop.ID = BienThe.ID_Laptop WHERE HoaDon.MaHD = ? and SerialNumber = ?";
	private List<HoaDon> list = new ArrayList<HoaDon>();
	private int rows = -1;
	private CTHoaDon ctHoaDon = new CTHoaDon();
	private List<CTHoaDon> listCT = new ArrayList<CTHoaDon>();
	private String[] lines = {};


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemPhieuDoi dialog = new ThemPhieuDoi();
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
	public ThemPhieuDoi() {
		setBounds(100, 100, 1080, 724);
		setLocationRelativeTo(this);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" PHIẾU ĐỔI");
		lblNewLabel.setForeground(new Color(255, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 10, 156, 35);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Phiếu Đổi");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(45, 90, 126, 19);
		getContentPane().add(lblNewLabel_1);
		
		txtMaPhieuDoi = new JTextField();
		txtMaPhieuDoi.setColumns(10);
		txtMaPhieuDoi.setBounds(217, 82, 388, 27);
		getContentPane().add(txtMaPhieuDoi);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Hóa Đơn");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(45, 151, 126, 19);
		getContentPane().add(lblNewLabel_1_1);
		
		cboHoaDon = new JComboBox<HoaDon>();
		fillCboHoaDon();
		cboHoaDon.setSelectedIndex(-1);
		cboHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HoaDon hoaDon = (HoaDon) cboHoaDon.getSelectedItem();
				fillTableSPDaMua(new CTHoaDonDAO().selectHoaDonByMaHoaDon(hoaDon.getMaHD()));
				setFormHD(new HoaDonDAO().selectById(hoaDon.getMaHD()));
				listCT.clear();
				fillTableSPDoi(listCT);
			}
		});
		cboHoaDon.setBounds(217, 149, 388, 27);
		getContentPane().add(cboHoaDon);
		
		JLabel lblNewLabel_2 = new JLabel("Sản phẩm Đã Mua");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(45, 208, 156, 31);
		getContentPane().add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 249, 557, 97);
		getContentPane().add(scrollPane);
		
		model = new DefaultTableModel();
		String[] cols = {"ID", "SerialNumber", "Tên Laptop", "Giá" };
		model.setColumnIdentifiers(cols);
		
		tblSpDaMua = new JTable(model);
		tblSpDaMua.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblSpDaMua);
		
		JLabel lblNewLabel_2_1 = new JLabel("Chi Tiết Sản Phẩm Muốn Đổi");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(45, 379, 212, 31);
		getContentPane().add(lblNewLabel_2_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(45, 420, 560, 91);
		getContentPane().add(scrollPane_1);
		
		model1 = new DefaultTableModel();
		String[] colss = { "ID","SerialNumber", "Tên Laptop", "Giá" };
		model1.setColumnIdentifiers(colss);
		
		tblChiTietSanPhamDaMua = new JTable(model1);
		tblChiTietSanPhamDaMua.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tblChiTietSanPhamDaMua);
		
		btnDoi = new JButton("Đổi");
		btnDoi.setForeground(new Color(64, 0, 0));
		btnDoi.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDoi.setBackground(new Color(255, 179, 179));
		btnDoi.setBounds(543, 215, 62, 27);
		getContentPane().add(btnDoi);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Serial");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(45, 548, 68, 19);
		getContentPane().add(lblNewLabel_1_1_1);
		
		txtSerialNew = new JTextArea();
		txtSerialNew.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSerialNew.setBounds(123, 537, 482, 37);
		getContentPane().add(txtSerialNew);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("Lí Do");
		lblNewLabel_3_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1_1.setBounds(45, 616, 62, 20);
		getContentPane().add(lblNewLabel_3_2_1_1);
		
		txtLiDo = new JTextField();
		txtLiDo.setColumns(10);
		txtLiDo.setBounds(123, 610, 482, 26);
		getContentPane().add(txtLiDo);
		
		JLabel lblNewLabel_2_2 = new JLabel("Hóa Đơn");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(653, 83, 87, 20);
		getContentPane().add(lblNewLabel_2_2);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(653, 112, 380, 230);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("MaHD");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 30, 76, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("MaKH");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(10, 89, 76, 20);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("MaNV");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(10, 149, 76, 20);
		panel.add(lblNewLabel_3_2);
		
		txtMaHD = new JTextField();
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(96, 30, 259, 26);
		panel.add(txtMaHD);
		
		txtMaKH = new JTextField();
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(96, 89, 259, 26);
		panel.add(txtMaKH);
		
		txtMaNV = new JTextField();
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(96, 149, 259, 26);
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
					
 					new FormDanhSachPhieuDoi().setVisible(true);
					
				} catch (Exception e2) {
					MsgBox.alert(getContentPane(), "Nhập lại dữ liệu");
				}
			}
		});
		btnAddPhieuDoi.setForeground(new Color(64, 0, 0));
		btnAddPhieuDoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddPhieuDoi.setBackground(new Color(255, 196, 196));
		btnAddPhieuDoi.setBounds(873, 584, 156, 54);
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
	public void fillCboHoaDon() {
		DefaultComboBoxModel<HoaDon> model = (DefaultComboBoxModel<HoaDon>) cboHoaDon.getModel();
		model.removeAllElements();
		List<HoaDon> list = new HoaDonDAO().selectAll();
		for (HoaDon hoaDon : list) {
			model.addElement(hoaDon);
		}
	}
	
	public void fillTableSPDaMua(List<CTHoaDon> list) {
		model.setRowCount(0);
		try {
			for (CTHoaDon ctHoaDon : list) {
				Object[] rows = new Object[] {
					ctHoaDon.getID(),
					ctHoaDon.getSerialNumber(),
					ctHoaDon.getTenLaptop(),
					ctHoaDon.getGia()
				};
				model.addRow(rows);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void fillTableSPDoi(List<CTHoaDon> list) {
		model1.setRowCount(0);
		try {
			for (CTHoaDon ctHoaDon : list) {
				Object[] rows = new Object[] {
					ctHoaDon.getID(),
					ctHoaDon.getSerialNumber(),
					ctHoaDon.getTenLaptop(),
					ctHoaDon.getGia()
				};
				model1.addRow(rows);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void setFormHD(HoaDon hoaDon) {
		txtMaHD.setText(hoaDon.getMaHD());
		txtMaKH.setText(hoaDon.getMaKH());
		txtMaNV.setText(hoaDon.getMaNV());
	}
	
	public PhieuDoi getModelPhieuDoi() {
		String MaPhieuDoi = txtMaPhieuDoi.getText();
		String MaKH = txtMaKH.getText();
		String MaHD = txtMaHD.getText();
		HoaDon hoaDon = new HoaDonDAO().selectById(MaHD);
		int IDHoaDon = hoaDon.getID();
		String MaNV = Auth.user.getMaNV();
		Date nowDate = new Date();
		Date NgayTao = XDate.toDate(XDate.toString(nowDate, "yyyy-MM-dd"), "yyyy-MM-dd");
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
