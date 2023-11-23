package com.shoplaptop.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.shoplaptop.utils.Auth;
import com.shoplaptop.utils.XImage;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Dimension;
<<<<<<< HEAD:PRO1041_PM_Ban_Laptop/src/com/shoplaptop/ui/ShopLaptop365.java
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
>>>>>>> 5333666a20df74651b67483a033cff49cf04782a:PRO1041_SD18312_Group5/src/com/shoplaptop/ui/ShopLaptop365.java

@SuppressWarnings("serial")
public class ShopLaptop365 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ShopLaptop365 frame = new ShopLaptop365();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShopLaptop365() {
		setTitle("ShopLaptop365");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 735);
		setLocationRelativeTo(null);
		setIconImage(XImage.getAppIcon());
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnHeThong = new JMenu("Hệ thống");
		mnHeThong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		menuBar.add(mnHeThong);
		
		JMenuItem mntmDangXuat = new JMenuItem("Đăng xuất");
		mntmDangXuat.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/Log out.png")));
		mntmDangXuat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnHeThong.add(mntmDangXuat);
		
		JMenuItem mntmDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		mntmDoiMatKhau.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/Refresh.png")));
		mntmDoiMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnHeThong.add(mntmDoiMatKhau);
		
		JMenuItem mntmKetThuc = new JMenuItem("Kết thúc");
		mntmKetThuc.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/Stop.png")));
		mntmKetThuc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnHeThong.add(mntmKetThuc);
		
		JMenu mnQuanLy = new JMenu("Quản lý");
		mnQuanLy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		menuBar.add(mnQuanLy);
		
		JMenuItem mntmKhachHang = new JMenuItem("Khách hàng");
		mntmKhachHang.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/Users.png")));
		mntmKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnQuanLy.add(mntmKhachHang);
		
		JMenuItem mntmDonHang = new JMenuItem("Đơn hàng");
		mntmDonHang.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/Notes.png")));
		mntmDonHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnQuanLy.add(mntmDonHang);
		
		JMenuItem mntmHoaDon = new JMenuItem("Hóa đơn");
		mntmHoaDon.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/Price list.png")));
		mntmHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnQuanLy.add(mntmHoaDon);
		
		JMenuItem mntmLaptop = new JMenuItem("Laptop");
		mntmLaptop.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/laptop.png")));
		mntmLaptop.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnQuanLy.add(mntmLaptop);
		
		JMenuItem mntmPhieuGiamGia = new JMenuItem("Phiếu giảm giá");
		mntmPhieuGiamGia.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/Statistics.png")));
		mntmPhieuGiamGia.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnQuanLy.add(mntmPhieuGiamGia);
		
		JMenuItem mntmDotGiamGia = new JMenuItem("Đợt giảm giá");
		mntmDotGiamGia.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/sale-icon.png")));
		mntmDotGiamGia.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnQuanLy.add(mntmDotGiamGia);
		
		JMenuItem mntmPhieuDoiTra = new JMenuItem("Phiếu đổi");
		mntmPhieuDoiTra.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/phieudoi.png")));
		mntmPhieuDoiTra.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnQuanLy.add(mntmPhieuDoiTra);
		
		JMenuItem mntmNhanVien = new JMenuItem("Nhân viên");
		mntmNhanVien.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/User.png")));
		mntmNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnQuanLy.add(mntmNhanVien);
		
		JMenu mnNewMenu_2 = new JMenu("Thông tin cá nhân");
		mnNewMenu_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmXemThongTinCaNhan = new JMenuItem("Xem thông tin cá nhân");
		mntmXemThongTinCaNhan.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/profile.png")));
		mntmXemThongTinCaNhan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnNewMenu_2.add(mntmXemThongTinCaNhan);
		
		JMenuItem mntmCapNhatThongTinCaNhan = new JMenuItem("Cập nhật thông tin cá nhân");
		mntmCapNhatThongTinCaNhan.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/Refresh.png")));
		mntmCapNhatThongTinCaNhan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mnNewMenu_2.add(mntmCapNhatThongTinCaNhan);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 10, 1056, 56);
		contentPane.add(toolBar);
		
		JButton btnNewButton = new JButton("Đăng xuất");
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/Exit.png")));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		toolBar.add(btnNewButton);
		
		JButton btnKtThc = new JButton("Kết thúc");
		btnKtThc.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/Stop.png")));
		btnKtThc.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnKtThc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnKtThc.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		toolBar.add(btnKtThc);
		
		JSeparator separator = new JSeparator();
		separator.setMaximumSize(new Dimension(1, 55));
		separator.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator);
		
		JButton btnKhchHng = new JButton("Khách hàng");
		btnKhchHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QuanLyKhachHang().setVisible(true);
			}
		});
		btnKhchHng.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/Users.png")));
		btnKhchHng.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnKhchHng.setHorizontalTextPosition(SwingConstants.CENTER);
		btnKhchHng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		toolBar.add(btnKhchHng);
		
		JButton btnnHng = new JButton("Đơn hàng");
		btnnHng.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/Notes.png")));
		btnnHng.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnnHng.setHorizontalTextPosition(SwingConstants.CENTER);
		btnnHng.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		toolBar.add(btnnHng);
		
		JButton btnHan = new JButton("Hóa đơn");
		btnHan.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/Price list.png")));
		btnHan.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnHan.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		toolBar.add(btnHan);
		
		JButton btnSnPhm = new JButton("Laptop");
		btnSnPhm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LaptopManager().setVisible(true);
			}
		});
		btnSnPhm.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/laptop.png")));
		btnSnPhm.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSnPhm.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSnPhm.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		toolBar.add(btnSnPhm);
		
		JButton btnPhiuGimGi = new JButton("Phiếu giảm giá");
		btnPhiuGimGi.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/Statistics.png")));
		btnPhiuGimGi.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPhiuGimGi.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPhiuGimGi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		toolBar.add(btnPhiuGimGi);
		
		JButton btntGimGi = new JButton("Đợt giảm giá");
		btntGimGi.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/sale-icon.png")));
		btntGimGi.setVerticalTextPosition(SwingConstants.BOTTOM);
		btntGimGi.setHorizontalTextPosition(SwingConstants.CENTER);
		btntGimGi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		toolBar.add(btntGimGi);
		
		JButton btnNewButton_8 = new JButton("Phiếu đổi");
		btnNewButton_8.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/phieudoi.png")));
		btnNewButton_8.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_8.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_8.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		toolBar.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Nhân viên");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QLNhanVien().setVisible(true);
			}
		});
		btnNewButton_9.setIcon(new ImageIcon(ShopLaptop365.class.getResource("/com/shoplaptop/icon/User.png")));
		btnNewButton_9.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_9.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_9.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		toolBar.add(btnNewButton_9);
		
		new HelloWindows(this, true).setVisible(true);
		new Login(this, true).setVisible(true);
		if (!Auth.isManager()) {
			mntmNhanVien.setEnabled(false);
		}
		setResizable(false);

	}
}
