package com.example.zm.text3.ui;

import android.os.Bundle;

import com.example.zm.text3.R;
import com.example.zm.text3.base.BaseActivity;
import com.example.zm.text3.entity.Entity_3;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Activity03 extends BaseActivity {
    private LineChart lineChartX, lineChartY;
    private List<Entity_3> pics;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_03);
        initToolBar(getIntent().getStringExtra("string"), true);

        lineChartX = (LineChart) findViewById(R.id.line_chart_x);
        lineChartY = (LineChart) findViewById(R.id.line_chart_y);
        pics =data();
        ArrayList<String> xVals = new ArrayList<String>();//X轴显示的集合

        ArrayList<Entry> entriesX1 = new ArrayList<Entry>();
        ArrayList<Entry> entriesX2 = new ArrayList<Entry>();
        ArrayList<Entry> entriesX3 = new ArrayList<Entry>();
        ArrayList<Entry> entriesX4 = new ArrayList<Entry>();
        ArrayList<Entry> entriesY1 = new ArrayList<Entry>();
        ArrayList<Entry> entriesY2 = new ArrayList<Entry>();
        ArrayList<Entry> entriesY3 = new ArrayList<Entry>();
        ArrayList<Entry> entriesY4 = new ArrayList<Entry>();
        int i = 0;
        for (Entity_3 d : pics) {
            //添加线
            entriesX1.add(new Entry((float) d.getX1Change(), i));
            entriesX2.add(new Entry((float) d.getX2Change(), i));
            entriesX3.add(new Entry((float) d.getX3Change(), i));
            entriesX4.add(new Entry((float) d.getX4Change(), i));
            entriesY1.add(new Entry((float) d.getY1Change(), i));
            entriesY2.add(new Entry((float) d.getY2Change(), i));
            entriesY3.add(new Entry((float) d.getY3Change(), i));
            entriesY4.add(new Entry((float) d.getY4Change(), i));
            //设置坐标，i为Y轴内容，X 轴内容
            xVals.add(i, simpleDateFormat.format(new Date(d.getSaveTime())));

            i++;
        }

        ArrayList<ILineDataSet> dataSetsX = new ArrayList<ILineDataSet>();
        dataSetsX.add(getLineDataset(entriesX1, "x1"));
        dataSetsX.add(getLineDataset(entriesX2, "x2"));
        dataSetsX.add(getLineDataset(entriesX3, "x3"));
        dataSetsX.add(getLineDataset(entriesX4, "x4"));

        ArrayList<ILineDataSet> dataSetsY = new ArrayList<ILineDataSet>();
        dataSetsY.add(getLineDataset(entriesY1, "y1"));
        dataSetsY.add(getLineDataset(entriesY2, "y2"));
        dataSetsY.add(getLineDataset(entriesY3, "y3"));
        dataSetsY.add(getLineDataset(entriesY4, "y4"));

        setChart(lineChartX, dataSetsX, xVals);
        setChart(lineChartY, dataSetsY, xVals);
    }

    private LineDataSet getLineDataset(ArrayList<Entry> entries, String s) {
        final LineDataSet set = new LineDataSet(entries, s);
        set.setCubicIntensity(0.5f);
        set.setColor(ColorTemplate.JOYFUL_COLORS[new Random().nextInt(ColorTemplate.JOYFUL_COLORS.length)]);
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        set.setDrawCubic(false);
        return set;
    }

    public void setChart(LineChart chart, ArrayList<ILineDataSet> dataSets, ArrayList<String> xVals) {
        LineData data = new LineData(xVals, dataSets);
        chart.setData(data);

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setTextSize(7);
        xAxis.setLabelRotationAngle(40f);
        YAxis yAxis = chart.getAxisLeft();
        yAxis.setDrawZeroLine(true);
        yAxis.setDrawGridLines(false);
        yAxis.setLabelCount(5, false);
        chart.getAxisRight().setEnabled(false);
        chart.setDescription("");
        chart.setDragEnabled(false);
        chart.setScaleXEnabled(false);
        chart.setScaleYEnabled(false);

        chart.invalidate();
    }


    public List<Entity_3> data(){
        List<Entity_3> list=new ArrayList<>();
        for (int i=0;i<4;i++){
            Entity_3 e=new Entity_3();
            e.setSaveTime(1480496926000l+(i*10000000));
            e.setX1Change(1.1+i);
            e.setX2Change(2.2+i);
            e.setX3Change(3.3+i);
            e.setX4Change(4.4+i);
            e.setY1Change(4.3+i);
            e.setY2Change(6.3+i);
            e.setY3Change(2.3+i);
            e.setY4Change(5.5+i);
            list.add(e);
        }
        return list;
    }
}
