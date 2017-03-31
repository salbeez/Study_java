package vending_machine_V;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

public class Admin_View extends JFrame {

	public JButton bt_day, bt_weak, bt_year;
	JPanel p;
	
	public JButton  bt_vet[] = new JButton[8];
	public JButton bt_re,bt_summit;// ������� ���ư���,�ܰ� ����
	JLabel la_one, la_five, la_ten, la_fifty, la_sum;
	public JTextField tf_one, tf_five, tf_ten, tf_fifty, tf_sum;

	JPanel panel_vet, p_won1, p_won2, p_won3, p_won4,p_wSum, panel_admin;
	JPanel p_big1, p_big2, p_leftDown, p_rightTop, p_rightDown;
	// =========================================
	public JFreeChart chart;
	public ChartPanel cp;

	public Admin_View() {
		init();
		setting();
		setSize(600, 550);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void init() {
		bt_day = new JButton("��");
		bt_weak = new JButton("��");
		bt_year = new JButton("����");
		p = new JPanel();
		
		bt_vet[0] = new JButton("��ä1");
		bt_vet[1] = new JButton("��ä2");
		bt_vet[2] = new JButton("��ä3");
		bt_vet[3] = new JButton("��ä4");
		bt_vet[4] = new JButton("��ä5");
		bt_vet[5] = new JButton("��ä6");
		bt_vet[6] = new JButton("��ä7");
		bt_vet[7] = new JButton("��ä8");
		panel_vet = new JPanel();
		p_leftDown = new JPanel();//==========
		
		la_one= new  JLabel("1,000��");
		tf_one = new  JTextField(3);
		p_won1 = new JPanel();//=====>1
		
		la_five = new  JLabel("5,000��");
		tf_five = new  JTextField(3);
		p_won2 = new JPanel();
		
		la_ten = new  JLabel("10,000��");
		tf_ten = new  JTextField(3);
		p_won3 = new JPanel();
		
		la_fifty = new  JLabel("50,000��");
		tf_fifty = new  JTextField(3);
		p_won4 = new JPanel();
		
		la_sum = new  JLabel("�Ѿ׼�");
		tf_sum = new  JTextField(7);
		p_wSum = new JPanel();
		bt_summit= new JButton("���� ����");
		p_rightTop = new  JPanel();//==========
		
		bt_re = new JButton("���ư���");
		p_rightDown = new JPanel();//==========
		
		p_big1 = new JPanel();
		p_big2 = new JPanel();
		
	}

	private void setting() {
		setTitle("�����ڸ��");
		
		p.setLayout(new FlowLayout());//==============LEFTDOWN �г� ����
		p.add(bt_day);
		p.add(bt_weak);
		p.add(bt_year);
		
		panel_vet.setLayout(new GridLayout(2,4,10,50));
		panel_vet.add(bt_vet[0]);
		panel_vet.add(bt_vet[1]);
		panel_vet.add(bt_vet[2]);
		panel_vet.add(bt_vet[3]);
		panel_vet.add(bt_vet[4]);
		panel_vet.add(bt_vet[5]);
		panel_vet.add(bt_vet[6]);
		panel_vet.add(bt_vet[7]);
		
		p_leftDown.setLayout(new BorderLayout());
		p_leftDown.add("North",p);
		p_leftDown.add("Center",panel_vet);//==================LEFTDOWN �г� ��
		
		p_won1.setLayout(new FlowLayout());
		p_won1.add(la_one);
		p_won1.add(tf_one);
		
		p_won2.setLayout(new FlowLayout());
		p_won2.add(la_five);
		p_won2.add(tf_five);
		
		p_won3.setLayout(new FlowLayout());
		p_won3.add(la_ten);
		p_won3.add(tf_ten);
		
		p_won4.setLayout(new FlowLayout());
		p_won4.add(la_fifty);
		p_won4.add(tf_fifty);
		
		p_wSum.setLayout(new FlowLayout());
		p_wSum.add(la_sum);
		p_wSum.add(tf_sum);
		
		p_rightTop.setLayout(new FlowLayout());
		p_rightTop.add(p_won1);
		p_rightTop.add(p_won2);
		p_rightTop.add(p_won3);
		p_rightTop.add(p_won4);
		p_rightTop.add(p_wSum);
		p_rightTop.add(bt_summit);
		
		p_rightDown.setLayout(new BorderLayout());
		p_rightDown.add("South",bt_re);
		
		setLayout(null);
		p_big1.setBounds(20, 20, 400, 500);
		p_big1.setBackground(Color.BLUE);
		p_big1.setLayout(new GridLayout(2, 1));
		cp = new ChartPanel(chart);
		cp.setSize(400,300);
		p_big1.add(cp);// ��Ʈ�κ�
		p_big1.add(p_leftDown);
		
		p_big2.setBounds(420, 20, 200, 500);
		p_big2.setBackground(Color.ORANGE);
		p_big2.setLayout(new GridLayout(2, 1));
		p_big2.add(p_rightTop);
		p_big2.add(p_rightDown);
		
		add(p_big1);
		add(p_big2);
		setBounds(20, 20, 500, 500);
		

	}

	
	
	public JFreeChart getChart(DefaultCategoryDataset dataset) {

//		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// ������ �Է� ( ��, ����, ī�װ� )�����Ǽ�,String,String
		// �׷���
	
		
		/*final*/ LineAndShapeRenderer renderer = new LineAndShapeRenderer();

		// ���� �ɼ� ����
		/*final*/ CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
		/*final*/ ItemLabelPosition p_center = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
		/*final*/ ItemLabelPosition p_below = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT);
		Font f = new Font("Gulim", Font.BOLD, 14);
		Font axisF = new Font("Gulim", Font.PLAIN, 14);

		// �׷��� 
		renderer.setBaseItemLabelGenerator(generator);
		renderer.setBaseItemLabelsVisible(true);
		renderer.setBaseShapesVisible(true);
		renderer.setDrawOutlines(true);
		renderer.setUseFillPaint(true);
		renderer.setBaseFillPaint(Color.WHITE);
		renderer.setBaseItemLabelFont(f);
		renderer.setBasePositiveItemLabelPosition(p_below);
		renderer.setSeriesPaint(0, new Color(219, 121, 22));
		renderer.setSeriesStroke(0, new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 3.0f));

		// plot ����
		/*final*/ CategoryPlot plot = new CategoryPlot();
		plot.setDataset(1, dataset);
		plot.setRenderer(1, renderer);

		// plot �⺻ ����
		plot.setOrientation(PlotOrientation.VERTICAL); // �׷��� ǥ�� ����
		plot.setRangeGridlinesVisible(true); // X�� ���̵� ���� ǥ�ÿ���
		plot.setDomainGridlinesVisible(true); // Y�� ���̵� ���� ǥ�ÿ���

		// ������ ���� ���� : dataset ��� ������� ������ ( ��, ���� ����Ѱ� �Ʒ��� �� )
		plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

		// X�� ����
		plot.setDomainAxis(new CategoryAxis()); // X�� ���� ����
		plot.getDomainAxis().setTickLabelFont(axisF); // X�� ���ݶ� ��Ʈ ����
		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD); // ī�װ�
																							// ��
																							// ��ġ
																							// ����

		// Y�� ����
		plot.setRangeAxis(new NumberAxis()); // Y�� ���� ����
		plot.getRangeAxis().setTickLabelFont(axisF); // Y�� ���ݶ� ��Ʈ ����

		// ���õ� plot�� �������� chart ����
		/*final*/ JFreeChart chart = new JFreeChart(plot);
		// chart.setTitle("Overlaid Bar Chart"); // ��Ʈ Ÿ��Ʋ
		// TextTitle copyright = new TextTitle("JFreeChart WaferMapPlot", new
		// Font("SansSerif", Font.PLAIN, 9));
		// copyright.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		// chart.addSubtitle(copyright); // ��Ʈ ���� Ÿ��Ʋ
		return chart;// ��Ʈ����
	}// getChart ��

}
// http://androphil.tistory.com/441 [�Ҹ����� ȫ����!]