package com.kosta.notePad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.*;

public class NotePad extends JFrame implements ActionListener {

	private JMenuBar menubar;
	private JMenu file, help;
	private JMenuItem file_open, file_save, file_exit;
	private JScrollPane scroll;
	private JTextArea ta;
	private JFileChooser chooser;

	FileInputStream fis;
	FileOutputStream fos;

	/*
	 * <�̺�Ʈ ó��> ����,����,���Ḧ �������� �̺�Ʈ ó�� �޼ҵ� �߰� ) public void fromFile(){ //������ �о
	 * --> ta�� ��� } public void toFile(){ //ta�� �о File�� ��� }
	 * ------------------------------ jFileChooser��� saveDialog �� ���� Ư�����Ϸ� ����
	 * write()�޼ҵ� openDiallog�� ���� ��� read() �޼ҵ�
	 */
	public NotePad() {
		setTitle("�޸���");

		init();

		setting();

		eventUp();
	}

	private void eventUp() {
		// TODO Auto-generated method stub
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		file_exit.addActionListener(this);
	}

	private void init() {
		menubar = new JMenuBar();
		file = new JMenu("����");
		help = new JMenu("����");

		file_open = new JMenuItem("����");
		file_save = new JMenuItem("����");
		file_exit = new JMenuItem("����");

		ta = new JTextArea();
		scroll = new JScrollPane(ta);

		chooser = new JFileChooser();
	}// init �ʱ�ȭ ��

	private void setting() {
		file.add(file_open);
		file.add(file_save);
		file.addSeparator();// ���м�
		file.add(file_exit);

		menubar.add(file);
		menubar.add(help);

		setJMenuBar(menubar);// �޴��� ����
		add(scroll);// ta����

		setVisible(true);
		setBounds(600, 200, 600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}// ���� ��

	public static void main(String[] args) {
		new NotePad();
	}

	public void fromFile() {// ������ �о ta�� ���
		int result = chooser.showOpenDialog(this);
		if (result != JFileChooser.APPROVE_OPTION) {
			return;
		}
		ta.setText("");
		try {
			File selectFile = chooser.getSelectedFile();
			fis = new FileInputStream(selectFile);
			// System.out.println(selectFile.getAbsolutePath());

			byte b[] = new byte[1024];
			int i = 0, j = 0;
			while ((i = fis.read(b)) != -1) {// �����Ͱ� �����Ѵٸ�
				String byteToString = new String(b, 0, i);
				ta.append(byteToString);
			}
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void toFile() {// ta�� �ִ� ���ڿ��� �ٽ� File�� ����
		chooser.showSaveDialog(this);

		try {
			File savetFile = chooser.getSelectedFile();
			fos = new FileOutputStream(savetFile);

//			int i = 0, j = 0;
			byte c[]=ta.getText().getBytes();// ta�� �ִ� ���� ���� �ٲٰ�
			fos.write(c);
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == file_open) {
			fromFile();
		} else if (obj == file_save) {
			toFile();
		} else if (obj == file_exit) {
			System.exit(EXIT_ON_CLOSE);
		}
	}
}
