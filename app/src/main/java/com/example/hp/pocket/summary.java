package com.example.hp.pocket;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class summary extends Fragment implements  View.OnClickListener,AdapterView.OnItemSelectedListener {
    EditText sd;
    Spinner Spin;
    String tea=null,sdate;
    Adddb helper;
    PieChart in,ex;
    int sMonth,sYear,sDay,eYear,eMonth,eDay;
    ArrayList<PieEntry> inc,exp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmentsummary, container, false);
        Spinner dropdown = rootView.findViewById(R.id.spin);
        String[] items = new String[]{"Day","Week","Month"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        helper=new Adddb(getContext());
        Spin=(Spinner)rootView.findViewById(R.id.spin);
        Spin.setOnItemSelectedListener(this);
        sd=(EditText)rootView.findViewById(R.id.begin);
        in=(PieChart)rootView.findViewById(R.id.incchart);
        ex=(PieChart)rootView.findViewById(R.id.expchart);
        in.setUsePercentValues(true);
        in.getDescription().setEnabled(false);
        in.setExtraOffsets(5,10,5,5);
        in.setDragDecelerationFrictionCoef(0.95f);

        in.setDrawHoleEnabled(true);
        in.setHoleColor(Color.WHITE);
        in.setTransparentCircleRadius(25f);
        in.setCenterText("Income");
        ex.getDescription().setEnabled(false);
        ex.setExtraOffsets(5,10,5,5);
        ex.setDragDecelerationFrictionCoef(0.95f);

        ex.setDrawHoleEnabled(true);
        ex.setHoleColor(Color.WHITE);
        ex.setTransparentCircleRadius(25f);
        ex.setCenterText("Expemse");
        ex.setUsePercentValues(true);
        sd.setOnClickListener(this);
        return rootView;
    }
    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.begin){
            final Calendar c = Calendar.getInstance();
            sYear = c.get(Calendar.YEAR);
            sMonth = c.get(Calendar.MONTH);
            sDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            sd.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            sdate=sd.getText().toString();
                                inc = helper.pidata(sdate, tea, getContext());
                                exp = helper.pedata(sdate, tea, getContext());
                                PieDataSet dataSet = new PieDataSet(inc, "Income");
                                dataSet.setSliceSpace(3f);
                                dataSet.setSelectionShift(5f);
                                dataSet.setColors(ColorTemplate.JOYFUL_COLORS);
                                PieData data = new PieData((dataSet));
                                data.setValueTextSize(10f);
                                data.setValueTextColor(Color.YELLOW);
                                in.getLegend().setEnabled(false);
                                in.setData(data);

                                PieDataSet dataSet1 = new PieDataSet(exp, "Expense");
                                dataSet1.setSliceSpace(3f);
                                dataSet1.setSelectionShift(5f);
                                dataSet1.setColors(ColorTemplate.JOYFUL_COLORS);
                                PieData data1 = new PieData((dataSet1));
                                data1.setValueTextSize(10f);
                                data1.setValueTextColor(Color.YELLOW);
                                ex.getLegend().setEnabled(false);
                                ex.setData(data1);
                            }
                    }, sYear, sMonth, sDay);
                datePickerDialog.show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        tea=item;
        if(tea==null){
            sd.setVisibility(view.VISIBLE);
        }
        else if(tea=="Day"){
            sd.setVisibility(view.VISIBLE);
        }
        else if(tea=="Week"){
            sd.setVisibility(view.VISIBLE);
        }
        else if(tea=="Month"){
            sd.setVisibility(view.VISIBLE);
        }
        else{
            sd.setVisibility(view.VISIBLE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(getContext(),"Select anything",Toast.LENGTH_LONG).show();
    }
}