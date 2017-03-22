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
	 * <이벤트 처리> 열기,저장,종료를 눌렀을때 이벤트 처리 메소드 추가 ) public void fromFile(){ //파일을 읽어서
	 * --> ta에 출력 } public void toFile(){ //ta를 읽어서 File에 출력 }
	 * ------------------------------ jFileChooser사용 saveDialog 를 통해 특정파일로 저장
	 * write()메소드 openDiallog를 통해 출력 read() 메소드
	 */
	public NotePad() {
		setTitle("메모장");

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
		file = new JMenu("파일");
		help = new JMenu("도움말");

		file_open = new JMenuItem("열기");
		file_save = new JMenuItem("저장");
		file_exit = new JMenuItem("종료");

		ta = new JTextArea();
		scroll = new JScrollPane(ta);

		chooser = new JFileChooser();
	}// init 초기화 끝

	private void setting() {
		file.add(file_open);
		file.add(file_save);
		file.addSeparator();// 구분선
		file.add(file_exit);

		menubar.add(file);
		menubar.add(help);

		setJMenuBar(menubar);// 메뉴바 부착
		add(scroll);// ta부착

		setVisible(true);
		setBounds(600, 200, 600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}// 세팅 끝

	public static void main(String[] args) {
		new NotePad();
	}

	public void fromFile() {// 파일을 읽어서 ta에 출력
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
			while ((i = fis.read(b)) != -1) {// 데이터가 존재한다면
				String byteToString = new String(b, 0, i);
				ta.append(byteToString);
			}
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void toFile() {// ta에 있는 문자열을 다시 File에 저장
		chooser.showSaveDialog(this);

		try {
			File savetFile = chooser.getSelectedFile();
			fos = new FileOutputStream(savetFile);

//			int i = 0, j = 0;
			byte c[]=ta.getText().getBytes();// ta에 있는 값을 전부 바꾸고
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
