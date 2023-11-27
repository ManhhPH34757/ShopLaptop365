package src.com.shoplaptop.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.maven.model.Model;

public class ThongKeDoanhSo extends JDialog {
	private JTable tblDoanhSo;
	private JComboBox cboNam;
	private JComboBox cboThang;
	private JRadioButton rdoCot;
	private JRadioButton rdoDuong;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeDoanhSo dialog = new ThongKeDoanhSo();
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
	public ThongKeDoanhSo() {
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		setBounds(100, 100, 794, 536);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ DOANH SỐ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(0, 0, 495, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Năm");
		lblNewLabel_1.setBounds(10, 34, 48, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tháng");
		lblNewLabel_1_1.setBounds(10, 76, 48, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		cboNam = new JComboBox();
		cboNam.setBounds(20, 53, 102, 22);
		getContentPane().add(cboNam);
		
		cboThang = new JComboBox();
		cboThang.setBounds(20, 101, 102, 22);
		getContentPane().add(cboThang);
		
		
		rdoCot = new JRadioButton("Biểu đồ cột");
		rdoCot.setBounds(0, 145, 102, 23);
		getContentPane().add(rdoCot);
		
		rdoDuong = new JRadioButton("Biểu đồ đường");
		rdoDuong.setBounds(0, 172, 122, 23);
		getContentPane().add(rdoDuong);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoCot);
		buttonGroup.add(rdoDuong);
		
		JButton btnBieuDo = new JButton("Biểu đồ");
		btnBieuDo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBieuDo.setIcon(new ImageIcon(ThongKeDoanhSo.class.getResource("/src/com/shoplaptop/icon/Bar chart.png")));
		btnBieuDo.setBounds(10, 217, 112, 33);
		getContentPane().add(btnBieuDo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(131, 56, 640, 371);
		getContentPane().add(scrollPane);
		
		model = new DefaultTableModel();
		String[] cols = {"Mã SP","Tên SP","Số lượng bán"};
		model.setColumnIdentifiers(cols);
		
		
		tblDoanhSo = new JTable(model);
		tblDoanhSo.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblDoanhSo);
		
		JButton btnXuatFile = new JButton("Xuất file");
		btnXuatFile.setIcon(new ImageIcon(ThongKeDoanhSo.class.getResource("/src/com/shoplaptop/icon/List.png")));
		btnXuatFile.setBounds(652, 4, 119, 33);
		getContentPane().add(btnXuatFile);

	}
}
