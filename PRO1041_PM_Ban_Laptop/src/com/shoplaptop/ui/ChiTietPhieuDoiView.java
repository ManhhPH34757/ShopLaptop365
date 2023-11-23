package com.shoplaptop.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ChiTietPhieuDoiView extends JDialog {
	public static JTextField txtMaPhieuDoi;
	public static JTextField txtMaHoaDon;
	public static JTextField txtNgayTao;
	public static JTextField txtLiDo;
	public static JTextField txtSerialold;
	public static JTextField txtSerialNew;
	public static JTextField txtMaKhachHang;
	public static JTextField txtTenKhachHang;
	public static JTextField txtMaNhanVien;
	public static JTextField txtTenNhanVien;
	public static JTextField txtTenLapCu;
	public static JTextField txtGiaCu;
	public static JTextField txtTenLapMoi;
	public static JTextField txtGiaMoi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietPhieuDoiView dialog = new ChiTietPhieuDoiView();
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
	public ChiTietPhieuDoiView() {
		setBounds(100, 100, 1022, 756);
		setLocationRelativeTo(this);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHI TIẾT PHIẾU ĐỔI");
		lblNewLabel.setForeground(new Color(255, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 22, 268, 40);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 107, 553, 304);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMaPhieuDoi = new JLabel("Mã Phiếu Đổi");
		lblMaPhieuDoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaPhieuDoi.setBounds(25, 36, 111, 24);
		panel.add(lblMaPhieuDoi);
		
		txtMaPhieuDoi = new JTextField();
		txtMaPhieuDoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaPhieuDoi.setBounds(196, 35, 319, 32);
		panel.add(txtMaPhieuDoi);
		txtMaPhieuDoi.setColumns(10);
		
		JLabel lblMaHoaDon = new JLabel("Mã Hóa Đơn");
		lblMaHoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaHoaDon.setBounds(25, 99, 111, 24);
		panel.add(lblMaHoaDon);
		
		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaHoaDon.setColumns(10);
		txtMaHoaDon.setBounds(196, 98, 319, 32);
		panel.add(txtMaHoaDon);
		
		JLabel lblNgayTao = new JLabel("Ngày Tạo");
		lblNgayTao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNgayTao.setBounds(25, 168, 111, 24);
		panel.add(lblNgayTao);
		
		txtNgayTao = new JTextField();
		txtNgayTao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNgayTao.setColumns(10);
		txtNgayTao.setBounds(196, 160, 319, 32);
		panel.add(txtNgayTao);
		
		JLabel lblLiDo = new JLabel("Lí Do");
		lblLiDo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLiDo.setBounds(25, 230, 111, 24);
		panel.add(lblLiDo);
		
		txtLiDo = new JTextField();
		txtLiDo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLiDo.setColumns(10);
		txtLiDo.setBounds(196, 229, 319, 32);
		panel.add(txtLiDo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(588, 266, 410, 145);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMNhnVin = new JLabel("Mã Nhân Viên");
		lblMNhnVin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMNhnVin.setBounds(10, 27, 136, 24);
		panel_1.add(lblMNhnVin);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(156, 24, 244, 32);
		panel_1.add(txtMaNhanVien);
		
		JLabel lblMaKH_1_1 = new JLabel("Tên Nhân Viên");
		lblMaKH_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaKH_1_1.setBounds(10, 94, 136, 24);
		panel_1.add(lblMaKH_1_1);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(156, 91, 244, 32);
		panel_1.add(txtTenNhanVien);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(588, 107, 410, 149);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMaKH = new JLabel("Mã Khách Hàng");
		lblMaKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaKH.setBounds(10, 28, 136, 24);
		panel_2.add(lblMaKH);
		
		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaKhachHang.setColumns(10);
		txtMaKhachHang.setBounds(156, 27, 244, 32);
		panel_2.add(txtMaKhachHang);
		
		JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTnKhchHng.setBounds(10, 94, 136, 24);
		panel_2.add(lblTnKhchHng);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(156, 86, 244, 32);
		panel_2.add(txtTenKhachHang);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(10, 431, 988, 207);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblSerialOld = new JLabel("Serial_Old");
		lblSerialOld.setBounds(39, 26, 111, 24);
		panel_3.add(lblSerialOld);
		lblSerialOld.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtSerialold = new JTextField();
		txtSerialold.setBounds(173, 23, 256, 32);
		panel_3.add(txtSerialold);
		txtSerialold.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSerialold.setColumns(10);
		
		JLabel lblSerialNEw = new JLabel("Serial_New");
		lblSerialNEw.setBounds(549, 26, 100, 24);
		panel_3.add(lblSerialNEw);
		lblSerialNEw.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtSerialNew = new JTextField();
		txtSerialNew.setBounds(677, 23, 256, 32);
		panel_3.add(txtSerialNew);
		txtSerialNew.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSerialNew.setColumns(10);
		
		JLabel lblTenLapCu = new JLabel("Tên Lap Cũ");
		lblTenLapCu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenLapCu.setBounds(39, 92, 111, 24);
		panel_3.add(lblTenLapCu);
		
		JLabel lblGiaCu = new JLabel("Giá Cũ");
		lblGiaCu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGiaCu.setBounds(39, 153, 111, 24);
		panel_3.add(lblGiaCu);
		
		JLabel lblTenLapMoi = new JLabel("Tên Lap Mới");
		lblTenLapMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenLapMoi.setBounds(549, 92, 100, 24);
		panel_3.add(lblTenLapMoi);
		
		JLabel lblGiaMoi = new JLabel("Giá Mới");
		lblGiaMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGiaMoi.setBounds(549, 153, 100, 24);
		panel_3.add(lblGiaMoi);
		
		txtTenLapCu = new JTextField();
		txtTenLapCu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenLapCu.setColumns(10);
		txtTenLapCu.setBounds(173, 89, 256, 32);
		panel_3.add(txtTenLapCu);
		
		txtGiaCu = new JTextField();
		txtGiaCu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGiaCu.setColumns(10);
		txtGiaCu.setBounds(173, 145, 256, 32);
		panel_3.add(txtGiaCu);
		
		txtTenLapMoi = new JTextField();
		txtTenLapMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenLapMoi.setColumns(10);
		txtTenLapMoi.setBounds(677, 84, 256, 32);
		panel_3.add(txtTenLapMoi);
		
		txtGiaMoi = new JTextField();
		txtGiaMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGiaMoi.setColumns(10);
		txtGiaMoi.setBounds(677, 145, 256, 32);
		panel_3.add(txtGiaMoi);

	}
}
