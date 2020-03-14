package com.example.hp.pocket;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.Calendar;

public class compare extends Fragment implements View.OnClickListener,AdapterView.OnItemSelectedListener {
    EditText fd,sd;
    Spinner Spin;
    Button btn;
    String tea=null,fdate,sdate;
    Adddb helper;
    BarChart in,ex;
    int sYear,sMonth,sDay,fYear,fMonth,fDay;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmentcompare, container, false);
        Spinner dropdown = rootView.findViewById(R.id.spin);
        String[] items = new String[]{"Day","Week","Month"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        helper=new Adddb(getContext());
        btn=(Button)rootView.findViewById(R.id.cmp);
        Spin=(Spinner)rootView.findViewById(R.id.spin);
        Spin.setOnItemSelectedListener(this);
        sd=(EditText)rootView.findViewById(R.id.sdate);
        fd=(EditText)rootView.findViewById(R.id.fDate);
        in=(BarChart) rootView.findViewById(R.id.barchartinc);
        ex=(BarChart) rootView.findViewById(R.id.barchartexp);
        btn.setOnClickListener(this);
        sd.setOnClickListener(this);
        fd.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.fDate){
            final Calendar c = Calendar.getInstance();
            fYear = c.get(Calendar.YEAR);
            fMonth = c.get(Calendar.MONTH);
            fDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            fd.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            fdate=fd.getText().toString();
                        }
                    }, fYear, fMonth, fDay);
            datePickerDialog.show();
        }
        if(id==R.id.sdate){
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
                        }
                    }, sYear, sMonth, sDay);
            datePickerDialog.show();
            helper.bidata(fdate,sdate,tea,getContext(),in);
        }
        if(id==R.id.cmp){
            if(fdate==null){
                Toast.makeText(getContext(),"Enter first date",Toast.LENGTH_LONG).show();
            }
            else if(sdate==null){
                Toast.makeText(getContext(),"Enter second date",Toast.LENGTH_LONG).show();
            }
            else{
                helper.bidata(fdate,sdate,tea,getContext(),in);
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        tea=item;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(getContext(),"Select anything",Toast.LENGTH_LONG).show();
    }
}
