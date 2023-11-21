package com.shoplaptop.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;

@SuppressWarnings("serial")
public class CPUManager extends JDialog {
	private CreateLaptop createLaptop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					CPUManager dialog = new CPUManager();
//					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public CPUManager(CreateLaptop createLaptop) {
		this.createLaptop = createLaptop;
		setBounds(100, 100, 760, 505);
		setLocationRelativeTo(null);

	}

}
