package vending_machine;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFrame;
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
	// =========================================
	public JFreeChart chart;
	public ChartPanel cp;

	public Admin_View() {
		init();
		setting();
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void init() {
		bt_day = new JButton("일");
		bt_weak = new JButton("월");
		bt_year = new JButton("월간");

		p = new JPanel();

	}

	private void setting() {
		p.setLayout(new FlowLayout());
		p.add(bt_day);
		p.add(bt_weak);
		p.add(bt_year);

		setLayout(new FlowLayout());
		
//		chart =getChart();//차트를 리턴 받아서
		cp = new ChartPanel(chart);
		cp.setSize(300,100);
		add(cp);// 차트부분
		add(p);
	}

	public JFreeChart getChart(DefaultCategoryDataset dataset) {

//		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// 데이터 입력 ( 값, 범례, 카테고리 )정수실수,String,String
		// 그래프
	

		final LineAndShapeRenderer renderer = new LineAndShapeRenderer();

		// 공통 옵션 정의
		final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
		final ItemLabelPosition p_center = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER);
		final ItemLabelPosition p_below = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT);
		Font f = new Font("Gulim", Font.BOLD, 14);
		Font axisF = new Font("Gulim", Font.PLAIN, 14);

		// 그래프 
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

		// plot 생성
		final CategoryPlot plot = new CategoryPlot();
		plot.setDataset(1, dataset);
		plot.setRenderer(1, renderer);

		// plot 기본 설정
		plot.setOrientation(PlotOrientation.VERTICAL); // 그래프 표시 방향
		plot.setRangeGridlinesVisible(true); // X축 가이드 라인 표시여부
		plot.setDomainGridlinesVisible(true); // Y축 가이드 라인 표시여부

		// 렌더링 순서 정의 : dataset 등록 순서대로 렌더링 ( 즉, 먼저 등록한게 아래로 깔림 )
		plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

		// X축 세팅
		plot.setDomainAxis(new CategoryAxis()); // X축 종류 설정
		plot.getDomainAxis().setTickLabelFont(axisF); // X축 눈금라벨 폰트 조정
		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD); // 카테고리
																							// 라벨
																							// 위치
																							// 조정

		// Y축 세팅
		plot.setRangeAxis(new NumberAxis()); // Y축 종류 설정
		plot.getRangeAxis().setTickLabelFont(axisF); // Y축 눈금라벨 폰트 조정

		// 세팅된 plot을 바탕으로 chart 생성
		final JFreeChart chart = new JFreeChart(plot);
		// chart.setTitle("Overlaid Bar Chart"); // 차트 타이틀
		// TextTitle copyright = new TextTitle("JFreeChart WaferMapPlot", new
		// Font("SansSerif", Font.PLAIN, 9));
		// copyright.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		// chart.addSubtitle(copyright); // 차트 서브 타이틀
		return chart;// 차트리턴
	}// getChart 끝

}
// http://androphil.tistory.com/441 [소림사의 홍반장!]