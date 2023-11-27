package src.com.shoplaptop.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DanhSachHoaDon extends JDialog {
	private JTable tblHoaDon;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DanhSachHoaDon dialog = new DanhSachHoaDon();
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
	public DanhSachHoaDon() {
		setBounds(100, 100, 801, 543);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH HÓA ĐƠN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(10, 11, 268, 25);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 769, 294);
		getContentPane().add(scrollPane);
		
		tblHoaDon = new JTable();
		tblHoaDon.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblHoaDon);
		
		JButton btnXoaHD = new JButton("Xóa HĐ");
		btnXoaHD.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXoaHD.setIcon(new ImageIcon(DanhSachHoaDon.class.getResource("/src/com/shoplaptop/icon/Delete.png")));
		btnXoaHD.setBounds(672, 426, 107, 33);
		getContentPane().add(btnXoaHD);
		
		JButton btnXuatFile = new JButton("Xuất file");
		btnXuatFile.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnXuatFile.setIcon(new ImageIcon(DanhSachHoaDon.class.getResource("/src/com/shoplaptop/icon/List.png")));
		btnXuatFile.setBounds(672, 11, 107, 33);
		getContentPane().add(btnXuatFile);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 74, 769, 42);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon(DanhSachHoaDon.class.getResource("/src/com/shoplaptop/icon/477210.png")));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTimKiem.setBounds(639, 4, 120, 34);
		panel.add(btnTimKiem);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 619, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("to");
		lblNewLabel_1.setBounds(104, 435, 22, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(66, 435, 28, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setBounds(129, 435, 28, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		JButton btnSau = new JButton("");
		btnSau.setIcon(new ImageIcon(DanhSachHoaDon.class.getResource("/src/com/shoplaptop/icon/truoc.png")));
		btnSau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSau.setBounds(158, 426, 57, 23);
		getContentPane().add(btnSau);
		
		JButton btnTruoc = new JButton("");
		btnTruoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTruoc.setIcon(new ImageIcon(DanhSachHoaDon.class.getResource("/src/com/shoplaptop/icon/sau.png")));
		btnTruoc.setBounds(10, 426, 57, 23);
		getContentPane().add(btnTruoc);

	}
}
