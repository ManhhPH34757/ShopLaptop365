package src.com.shoplaptop.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.maven.model.Model;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class HoaDonJDialog extends JDialog {
	private JTable tblHoaDon;
	private JTable tblChiTietHoaDon;
	private JTextField txtKhachHang;
	private JTextField txtNhanVien;
	private JTextField txtNgayTao;
	private JTextField txtTongTien;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDonJDialog dialog = new HoaDonJDialog();
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
	public HoaDonJDialog() {
		setBounds(100, 100, 721, 544);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HÓA ĐƠN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 101, 26);
		getContentPane().add(lblNewLabel);
		
		JButton btnTao = new JButton("Tạo");
		btnTao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTao.setIcon(new ImageIcon(HoaDonJDialog.class.getResource("/src/com/shoplaptop/icon/Add.png")));
		btnTao.setBounds(368, 9, 89, 33);
		getContentPane().add(btnTao);
		
		JButton btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setIcon(new ImageIcon(HoaDonJDialog.class.getResource("/src/com/shoplaptop/icon/Price list.png")));
		btnThanhToan.setBounds(467, 9, 134, 33);
		getContentPane().add(btnThanhToan);
		
		JButton btnIn = new JButton("In");
		btnIn.setIcon(new ImageIcon(HoaDonJDialog.class.getResource("/src/com/shoplaptop/icon/Print preview.png")));
		btnIn.setBounds(610, 9, 89, 33);
		getContentPane().add(btnIn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 309, 163);
		getContentPane().add(scrollPane);
		
		model = new DefaultTableModel();
		String[] cols = {"Mã hóa đơn","Trạng thái"};
		model.setColumnIdentifiers(cols);
		
		tblHoaDon = new JTable(model);
		tblHoaDon.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblHoaDon);
		

		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 263, 309, 201);
		getContentPane().add(scrollPane_1);
		
		tblChiTietHoaDon = new JTable();
		tblChiTietHoaDon.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tblChiTietHoaDon);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(368, 47, 331, 163);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Khách hàng:");
		lblNewLabel_1.setBounds(10, 11, 84, 19);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nhân viên:");
		lblNewLabel_1_1.setBounds(10, 41, 84, 19);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ngày tạo:");
		lblNewLabel_1_2.setBounds(10, 71, 84, 19);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tổng tiền:");
		lblNewLabel_1_3.setBounds(10, 101, 84, 19);
		panel.add(lblNewLabel_1_3);
		
		txtKhachHang = new JTextField();
		txtKhachHang.setBounds(93, 10, 228, 20);
		panel.add(txtKhachHang);
		txtKhachHang.setColumns(10);
		
		txtNhanVien = new JTextField();
		txtNhanVien.setColumns(10);
		txtNhanVien.setBounds(93, 40, 228, 20);
		panel.add(txtNhanVien);
		
		txtNgayTao = new JTextField();
		txtNgayTao.setColumns(10);
		txtNgayTao.setBounds(93, 70, 228, 20);
		panel.add(txtNgayTao);
		
		txtTongTien = new JTextField();
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(93, 100, 228, 20);
		panel.add(txtTongTien);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(HoaDonJDialog.class.getResource("/src/com/shoplaptop/icon/Delete.png")));
		btnXoa.setBounds(230, 464, 89, 23);
		getContentPane().add(btnXoa);
		
		JLabel lblNewLabel_2 = new JLabel("Chi tiết hóa đơn");
		lblNewLabel_2.setBounds(10, 238, 162, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Sản phẩm");
		lblNewLabel_2_1.setBounds(368, 238, 162, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(368, 263, 331, 201);
		getContentPane().add(textArea);

	}
}
