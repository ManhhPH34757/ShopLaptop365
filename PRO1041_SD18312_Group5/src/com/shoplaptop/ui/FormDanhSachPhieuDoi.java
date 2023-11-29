package com.shoplaptop.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.shoplaptop.dao.CTPhieuDoiDAO;
import com.shoplaptop.dao.PhieuDoiDAO;
import com.shoplaptop.entity.CTPhieuDoi;
import com.shoplaptop.entity.PhieuDoi;
import com.shoplaptop.utils.MsgBox;
import com.shoplaptop.utils.XDate;

import javax.sound.midi.Soundbank;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class FormDanhSachPhieuDoi extends JDialog {
	public DefaultTableModel model ;
	public DefaultTableModel model2;
	PhieuDoiDAO phieuDoiDAO = new PhieuDoiDAO();
	CTPhieuDoiDAO ctPhieuDoiDAO = new CTPhieuDoiDAO();
	List<PhieuDoi> list = new ArrayList<PhieuDoi>();
	PhieuDoi phieuDoi;
	private JPanel getconten;
	private JTextField txtTimKiem;
	private JTable tblDanhSachPhieuDoi;
	private JTable tblDanhSachPhieuDoiChiTiet;
	private int row = -1;
	private String maPhieuDoi = "";
	private int id_phieuDoi;
	String SelectPhieuDoiByMaPhieuDoi = "SELECT * FROM dbo.PhieuDoi WHERE MaPhieuDoi = ?";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDanhSachPhieuDoi dialog = new FormDanhSachPhieuDoi();
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
	public FormDanhSachPhieuDoi() {
		setBounds(100, 100, 834, 670);
		setLocationRelativeTo(this);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH PHIẾU ĐỔI");
		lblNewLabel.setForeground(new Color(255, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 21, 320, 40);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm Kiếm Phiếu Đổi");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(33, 81, 133, 28);
		getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 215, 215));
		panel.setBounds(33, 123, 764, 51);
		getContentPane().add(panel);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setText(" ");
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(10, 10, 643, 29);
		panel.add(txtTimKiem);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindByMaPhieuDoi();
			}
		});
		btnTimKiem.setForeground(new Color(64, 0, 0));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTimKiem.setBackground(new Color(255, 128, 128));
		btnTimKiem.setBounds(663, 10, 85, 29);
		panel.add(btnTimKiem);
		
		JButton btnTaoPhieuDoi = new JButton("Tạo Phiếu Đổi");
		btnTaoPhieuDoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ThemPhieuDoi().setVisible(true);
			}
		});
		btnTaoPhieuDoi.setForeground(new Color(64, 0, 0));
		btnTaoPhieuDoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTaoPhieuDoi.setBackground(new Color(255, 204, 204));
		btnTaoPhieuDoi.setBounds(636, 37, 161, 34);
		getContentPane().add(btnTaoPhieuDoi);
		
		JLabel lblNewLabel_2 = new JLabel("Danh Sách Phiếu Đổi");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(33, 206, 176, 19);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnDeletePhieuDoi = new JButton("Delete");
		btnDeletePhieuDoi.setForeground(new Color(64, 0, 0));
		btnDeletePhieuDoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeletePhieuDoi.setBackground(new Color(255, 191, 191));
		btnDeletePhieuDoi.setBounds(712, 206, 85, 32);
		getContentPane().add(btnDeletePhieuDoi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 248, 763, 158);
		getContentPane().add(scrollPane);
		
		model = new DefaultTableModel();
		String[] cols = {"MaPhieuDoi","MaKH","MaHD","MaNV","NgayTao","LiDo"};
		model.setColumnIdentifiers(cols);
		
		tblDanhSachPhieuDoi = new JTable(model);
		tblDanhSachPhieuDoi.setRowMargin(3);
		tblDanhSachPhieuDoi.setRowHeight(25);
		tblDanhSachPhieuDoi.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblDanhSachPhieuDoi);
		
		JLabel lblNewLabel_2_1 = new JLabel("Danh Sách Chi Tiết Phiếu Đổi");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(35, 427, 218, 19);
		getContentPane().add(lblNewLabel_2_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(33, 465, 764, 158);
		getContentPane().add(scrollPane_1);
		
		model2 = new DefaultTableModel();
		String[] colS = {"Mã phiếu đổi","Serial_Old","Giá cũ","Serial_New","Giá mới"};
		model2.setColumnIdentifiers(colS);
		
		tblDanhSachPhieuDoiChiTiet = new JTable(model2);
		tblDanhSachPhieuDoiChiTiet.setRowMargin(3);
		tblDanhSachPhieuDoiChiTiet.setRowHeight(25);
		tblDanhSachPhieuDoiChiTiet.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tblDanhSachPhieuDoiChiTiet);
		tblDanhSachPhieuDoiChiTiet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					int index = tblDanhSachPhieuDoiChiTiet.getSelectedRow();
					PhieuDoi phieuDoi = phieuDoiDAO.selectAllSetForm().get(index);
					CTPhieuDoi ctPhieuDoi = (CTPhieuDoi) ctPhieuDoiDAO.selectAllCTPhieuDoiSetForm(maPhieuDoi).get(index);
					new ChiTietPhieuDoiView().setVisible(true);
					setFormPhieuDoi(phieuDoi);
					setFormCTPhieuDoi(ctPhieuDoi);
					
					
				
			}
		});
		fillTablePhieuDoi();
		tblDanhSachPhieuDoi.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					row = tblDanhSachPhieuDoi.getSelectedRow();
					maPhieuDoi = (String) tblDanhSachPhieuDoi.getValueAt(row, 0);
					fillTableCTPhieuDoi(maPhieuDoi);
					PhieuDoi phieuDoi = new PhieuDoiDAO().selectById(maPhieuDoi);
					id_phieuDoi = phieuDoi.getID();
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnDeletePhieuDoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int config = JOptionPane.showConfirmDialog(getContentPane(), "Bạn có chắc chắn muốn xóa không?");
				if (config == JOptionPane.YES_OPTION) {
					new CTPhieuDoiDAO().delete(id_phieuDoi);
					MsgBox.alert(getContentPane(), new PhieuDoiDAO().delete(maPhieuDoi));
					fillTablePhieuDoi();
					model2.setRowCount(0);
				}
			}
		});
	}

	public void fillTablePhieuDoi() {
		model.setRowCount(0);
		List<PhieuDoi> list = phieuDoiDAO.selectAll();
		for(PhieuDoi phieuDoi : list) {
			Object[] row = new Object[] {
					phieuDoi.getMaPhieuDoi(),
					phieuDoi.getMaKH(),
					phieuDoi.getMaHD(),
					phieuDoi.getMaNV(), 
					phieuDoi.getNgayTao(),
					phieuDoi.getLiDo()
			};
			model.addRow(row);
		}
		
	}
	public void fillTableCTPhieuDoi(String MaPhieuDoi) {
		try {
			model2.setRowCount(0);
			List<CTPhieuDoi> list = new CTPhieuDoiDAO().selectAllCTPhieuDoiByMaPhieuDoi(MaPhieuDoi);
			for(CTPhieuDoi pDoi : list) {
				Object[] rows = new Object[] {
					pDoi.getMaPhieuDoi(),
					pDoi.getSerialNumber_Old(),
					pDoi.getGiaCu(),
					pDoi.getSerialNumber_New(),
					pDoi.getGiaMoi()
				};
				model2.addRow(rows);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void FindByMaPhieuDoi() {
		try {
			String MaPhieuDoi = txtTimKiem.getText();
			if (MaPhieuDoi.trim().isEmpty()) {
				MaPhieuDoi = "%%";
			}
			List<PhieuDoi> list = phieuDoiDAO.selectAll();
			list = phieuDoiDAO.selectBySQL(SelectPhieuDoiByMaPhieuDoi,"%"+ MaPhieuDoi +"%");
			fillTablePhieuDoi();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void setFormPhieuDoi(PhieuDoi phieuDoi) {
		ChiTietPhieuDoiView.txtMaPhieuDoi.setText(phieuDoi.getMaPhieuDoi());
		ChiTietPhieuDoiView.txtMaHoaDon.setText(phieuDoi.getMaHD());
		ChiTietPhieuDoiView.txtMaKhachHang.setText(phieuDoi.getMaKH());
		ChiTietPhieuDoiView.txtTenKhachHang.setText(phieuDoi.getTenKH());
		ChiTietPhieuDoiView.txtMaNhanVien.setText(phieuDoi.getMaNV());
		ChiTietPhieuDoiView.txtTenNhanVien.setText(phieuDoi.getTenNV());
		ChiTietPhieuDoiView.txtNgayTao.setText(XDate.toString(phieuDoi.getNgayTao(),"yyyy-MM-dd"));
		ChiTietPhieuDoiView.txtLiDo.setText(phieuDoi.getLiDo());
	}
	public void setFormCTPhieuDoi(CTPhieuDoi ctPhieuDoi) {
		ChiTietPhieuDoiView.txtSerialold.setText(ctPhieuDoi.getSerialNumber_Old());
		ChiTietPhieuDoiView.txtSerialNew.setText(ctPhieuDoi.getSerialNumber_New());
		ChiTietPhieuDoiView.txtTenLapCu.setText(ctPhieuDoi.getTenLapCu());
		ChiTietPhieuDoiView.txtTenLapMoi.setText(ctPhieuDoi.getTenLapMoi());
		ChiTietPhieuDoiView.txtGiaCu.setText(ctPhieuDoi.getGiaCu()+"");
		ChiTietPhieuDoiView.txtGiaMoi.setText(ctPhieuDoi.getGiaMoi()+"");
	}
	
}
