package com.shoplaptop.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.shoplaptop.dao.HoaDonDAO;
import com.shoplaptop.dao.KhachHangDAO;
import com.shoplaptop.entity.KhachHang;
import com.shoplaptop.utils.MsgBox;
import com.shoplaptop.utils.XDate;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class QuanLyKhachHang extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyKhachHang dialog = new QuanLyKhachHang();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTextField txtTimKiem;
	private DefaultTableModel model;
	private JTable tblKhachHang;
	public List<KhachHang> list = new KhachHangDAO().selectAll();
	private KhachHangDAO dao = new KhachHangDAO();
	private int index =1;
	String selectBySDT = "SELECT * FROM KhachHang WHERE SoDienThoai like ? OR MaKH like ? ";
	private JLabel lblSau;
	private JLabel lblTo;
	private JLabel lblTruoc;
	private JButton btnSau;
	private int rows;
	String selectByMaKH = "SELECT HoaDon.ID, dbo.HoaDon.MaHD, HoaDon.MaKH,dbo.HinhThucVanChuyen.ID AS 'ID_HinhThucVanChuyen', dbo.HinhThucVanChuyen.HinhThuc AS 'HinhThucVanChuyen',dbo.HinhThucThanhToan.ID AS 'ID_HinhThucThanhToan',\r\n"
			+ "	dbo.HinhThucThanhToan.HinhThuc AS 'HinhThucThanhToan',\r\n"
			+ "	dbo.PhieuGiamGia.ID AS 'ID_PhieuGiamGia', PhieuGiamGia.MaPG, dbo.HoaDon.DotGiamGia,\r\n"
			+ "	HoaDon.MaNV,\r\n"
			+ "	dbo.HoaDon.NgayTao, dbo.HoaDon.TongTien\r\n"
			+ "FROM dbo.HoaDon JOIN  dbo.KhachHang ON KhachHang.MaKH = HoaDon.MaKH\r\n"
			+ "			JOIN dbo.HinhThucVanChuyen ON HinhThucVanChuyen.ID = HoaDon.HinhThucVanChuyen\r\n"
			+ "			JOIN dbo.HinhThucThanhToan ON HinhThucThanhToan.ID = HoaDon.HinhThucThanhToan\r\n"
			+ "			LEFT JOIN dbo.PhieuGiamGia ON PhieuGiamGia.ID = HoaDon.PhieuGiamGia\r\n"
			+ "			LEFT JOIN dbo.DotGiamGia ON DotGiamGia.MaDG = dbo.HoaDon.DotGiamGia\r\n"
			+ "			JOIN dbo.NhanVien ON NhanVien.MaNV = HoaDon.MaNV "
			+ "WHERE dbo.HoaDon.MaKH = ?";
	
	/**
	 * Create the dialog.
	 */
	public QuanLyKhachHang() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Quản lý khách hàng");
		
		setBounds(100, 100, 975, 675);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH KHÁCH HÀNG");
		lblNewLabel.setForeground(new Color(255, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(10, 10, 476, 32);
		getContentPane().add(lblNewLabel);
		
		JButton btnThemKH = new JButton("Thêm khách hàng");
		btnThemKH.setIcon(new ImageIcon(QuanLyKhachHang.class.getResource("/com/shoplaptop/icon/Add.png")));
		btnThemKH.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnThemKH.setForeground(new Color(0, 0, 0));
		btnThemKH.setBounds(591, 50, 204, 33);
		getContentPane().add(btnThemKH);
		
		btnThemKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ThemKhachHangJDialog(QuanLyKhachHang.this).setVisible(true);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm khách hàng");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 68, 236, 23);
		getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(10, 94, 943, 65);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTimKiem.setBounds(10, 8, 754, 46);
		panel.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(Color.PINK);
		btnTimKiem.setIcon(new ImageIcon(QuanLyKhachHang.class.getResource("/com/shoplaptop/icon/Search.png")));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findSDT();
				
			}
		});
		btnTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnTimKiem.setForeground(new Color(255, 0, 0));
		btnTimKiem.setBounds(774, 4, 159, 50);
		panel.add(btnTimKiem);
		
		model = new DefaultTableModel();
		String[] cols = {"Mã KH","Họ tên","Số điện thoại","Địa chỉ"};
		model.setColumnIdentifiers(cols);
		
		JLabel lblNewLabel_1_1 = new JLabel("Danh sách khách hàng");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 170, 236, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 195, 943, 400);
		getContentPane().add(scrollPane);
		
		tblKhachHang = new JTable(model);
		tblKhachHang.setRowMargin(3);
		tblKhachHang.setRowHeight(25);
		tblKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tblKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tblKhachHang.getSelectedRow();
				KhachHang khachHang = list.get(index);
				new ChiTietKhachHang(QuanLyKhachHang.this).setVisible(true);
				setForm(khachHang);
				ChiTietKhachHang.fillTable(new HoaDonDAO().selectBySQL(selectByMaKH, khachHang.getMaKH()));;
			}
		});
		scrollPane.setViewportView(tblKhachHang);
		
		
		lblTruoc = new JLabel("1");
		lblTruoc.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTruoc.setBounds(442, 606, 17, 23);
		getContentPane().add(lblTruoc);
		
		
		fillTable(dao.sellectAllKhachHang(index));
		double size = (double) dao.selectAll().size()/5;
		 rows = (int) Math.ceil(size);
		lblTruoc.setText("1");
		
		
		
		JButton btnTruoc = new JButton("");
		btnTruoc.setIcon(new ImageIcon(QuanLyKhachHang.class.getResource("/com/shoplaptop/icon/sau.png")));
		btnTruoc.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTruoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index > 1) {
					--index;
					lblTruoc.setText(index+"");
					fillTable(dao.sellectAllKhachHang((index-1)*5+1));
					
					
				}
			}
		});
		btnTruoc.setBounds(375, 606, 57, 23);
		getContentPane().add(btnTruoc);

		btnSau = new JButton("");
		btnSau.setIcon(new ImageIcon(QuanLyKhachHang.class.getResource("/com/shoplaptop/icon/truoc.png")));
		btnSau.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSau.setBackground(new Color(240, 240, 240));
		
		
		btnSau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index < rows) {
					++index;
					lblTruoc.setText(index+"");
					fillTable(dao.sellectAllKhachHang((index-1)*5+1));
					
					
				}
			}
		});
		btnSau.setBounds(524, 606, 51, 23);
		getContentPane().add(btnSau);
		
		
		lblTo = new JLabel("To");
		lblTo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTo.setBounds(459, 606, 27, 23);
		getContentPane().add(lblTo);
		
		lblSau = new JLabel("-");
		lblSau.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSau.setBounds(487, 610, 27, 14);
		getContentPane().add(lblSau);
		lblSau.setText(rows+"");
		
		JButton btnNewButton = new JButton("Xuất file");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<KhachHang> list_khachHang = dao.selectAll();
				XuatFile(list_khachHang);
				MsgBox.alert(getContentPane(), "Xuất file thành công");
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setIcon(new ImageIcon(QuanLyKhachHang.class.getResource("/com/shoplaptop/icon/List.png")));
		btnNewButton.setBounds(805, 50, 148, 33);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Thêm vào hóa đơn");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.setBounds(764, 161, 189, 32);
		getContentPane().add(btnNewButton_1);
		fillTable(new KhachHangDAO().sellectAllKhachHang(1));

	}
	public void fillTable(List<KhachHang> list) {
		model.setRowCount(0);
		for (KhachHang khachHang : list) {
			Object[] rows = new Object[] {
					khachHang.getMaKH(),
					khachHang.getHoTen(),
					khachHang.getSoDienThoai(),
					khachHang.getDiaChi()
			};
			model.addRow(rows);
		}
		
		
	}
	
	public void setForm(KhachHang khachHang) {
		ChiTietKhachHang.txtMaKH.setText(khachHang.getMaKH());
		ChiTietKhachHang.txtTenKH.setText(khachHang.getHoTen());
		ChiTietKhachHang.txtSDT.setText(khachHang.getSoDienThoai());
		ChiTietKhachHang.dateChooser.setDate(khachHang.getNgaySinh());
		ChiTietKhachHang.rdoNam.setSelected(khachHang.isGioiTinh());
		ChiTietKhachHang.rdoNu.setSelected(!khachHang.isGioiTinh());
		ChiTietKhachHang.txtEmail.setText(khachHang.getEmail());
		ChiTietKhachHang.txtDiaChi.setText(khachHang.getDiaChi());	
	}
	public void findSDT() {
		String soDienThoai =  txtTimKiem.getText();
		if (soDienThoai.trim().isEmpty()) {
			soDienThoai="%%";
		}
		list = dao.selectBySQL(selectBySDT, "%" + soDienThoai+"%" , "%" + soDienThoai+"%");
		fillTable(list);
		lblSau.setText("1");
		
	}
//	public void findMaKH() {
//		String maKH =  txtTimKiem.getText();
//		if (maKH.trim().isEmpty()) {
//			maKH="";
//		}
//		ArrayList<KhachHang> listKH = new ArrayList<>();
//		listKH.add(new KhachHangDAO().selectById(maKH));
//		model.setRowCount(0);
//		for (KhachHang khachHang : listKH) {
//			Object[] rows = new Object[] {
//					khachHang.getMaKH(),
//					khachHang.getHoTen(),
//					khachHang.getSoDienThoai(),
//					khachHang.getDiaChi()
//			};
//			model.addRow(rows);
//			
//		}
//		fillTable();
//		
//	}
	
	public void updateKH(KhachHang khachHang) {

		try {
			MsgBox.alert(getContentPane(),new KhachHangDAO().update(khachHang) );
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	public void XuatFile(List<KhachHang> list_khachHang) {
		JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files", "xls", "xlsx");
        fileChooser.setFileFilter(filter);
        if (fileChooser.showSaveDialog(getContentPane()) == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".xlsx") && !filePath.toLowerCase().endsWith(".xls")) {
                fileToSave = new File(filePath + ".xlsx");
            }

            Workbook workbook = new XSSFWorkbook(); 
            Sheet sheet = workbook.createSheet("Danh sách"); 
           
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Mã KH");
            headerRow.createCell(1).setCellValue("Họ tên");
            headerRow.createCell(2).setCellValue("Số điện thoại");
            headerRow.createCell(3).setCellValue("Địa chỉ");


            for (int i = 0; i < list_khachHang.size(); i++) {
                KhachHang khachHang = list_khachHang.get(i);
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(khachHang.getMaKH());
                row.createCell(1).setCellValue(khachHang.getHoTen());
                row.createCell(2).setCellValue(khachHang.getSoDienThoai());
//                row.createCell(3).setCellValue(khachHang.getNgaySinh());
//                row.createCell(4).setCellValue(khachHang.isGioiTinh()?"Nam":"Nữ");
//                row.createCell(5).setCellValue(khachHang.getEmail());
                row.createCell(3).setCellValue(khachHang.getDiaChi());
            }

            try (FileOutputStream outputStream = new FileOutputStream(fileToSave)) { 
                workbook.write(outputStream); 
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                workbook.close(); 
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	

	}


