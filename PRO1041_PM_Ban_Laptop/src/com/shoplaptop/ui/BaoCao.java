package com.shoplaptop.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.shoplaptop.dao.LS_HoaDonDao;
import com.shoplaptop.entity.BaoCao_LS_HoaDon;
import com.shoplaptop.utils.XDate;

public class BaoCao extends JDialog {
	private JTable tblhoadon;
	private DefaultTableModel model;
	private List<BaoCao_LS_HoaDon> list;
	private LS_HoaDonDao dao = new LS_HoaDonDao();
//	private LS_NhanVien ls_NhanVien;
	String SellectAll = "SELECT * FROM dbo.LS_HoaDon WHERE MaNV =?";
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BaoCao dialog = new BaoCao();
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
	public BaoCao() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BaoCao.class.getResource("/com/shoplaptop/icon/365_1.png")));
		setTitle("ShopLapTop365\r\n");
		setBounds(100, 100, 748, 409);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 714, 349);
		getContentPane().add(tabbedPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Hóa Đơn", null, layeredPane, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 689, 302);
		layeredPane.add(scrollPane);
		
		
		model = new DefaultTableModel();
		String[] cloums = new String[] {"Mã Nhân Viên","Mã Hóa Đơn","Lịch Sử Làm Việc"};
		model.setColumnIdentifiers(cloums);
		
		tblhoadon = new JTable(model);
		scrollPane.setViewportView(tblhoadon);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Phiếu Đổi ", null, layeredPane_1, null);
		filltableHoaDon(dao.selectBySQL(SellectAll, LS_NhanVien.txtmanhanvien.getText()));
		
		

	}
	public void filltableHoaDon(List<BaoCao_LS_HoaDon> list) {
		model.setRowCount(0);
		for (BaoCao_LS_HoaDon baoCao_LS_HoaDon : list) {
			Object[] rows = new Object[] {
				baoCao_LS_HoaDon.getManv(),
				baoCao_LS_HoaDon.getMahd(),
				baoCao_LS_HoaDon.getLS()
			};
			model.addRow(rows);
		}
	}
}
