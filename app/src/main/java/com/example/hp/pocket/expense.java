package com.example.hp.pocket;

import android.app.DatePickerDialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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

import java.util.Calendar;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class expense extends Fragment implements View.OnClickListener ,AdapterView.OnItemSelectedListener {
    Adddb helper;
    int mYear,mMonth,mDay;
    EditText a,b,c;
    Button save;
    Spinner Spin;
    String tea;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_expense, container, false);
        Spinner dropdown = rootView.findViewById(R.id.tag);
        String[] items = new String[]{"fees", "recharge", "electricity","water","food","clothing"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        Spin=(Spinner)rootView.findViewById(R.id.tag);
        Spin.setOnItemSelectedListener(this);
        a=(EditText)rootView.findViewById(R.id.date);
        b=(EditText)rootView.findViewById(R.id.dsr);
        c=(EditText)rootView.findViewById(R.id.amount);
        save=(Button)rootView.findViewById(R.id.saveexp);
        helper=new Adddb(getContext());
        a.setOnClickListener(this);
        save.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        String amt = c.getText().toString();
    String dsr = b.getText().toString();
    String date = a.getText().toString();
        Spin.setOnItemSelectedListener(this);
    int id = v.getId();
        if (id == R.id.date) {
        final Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        a.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
        if (id == R.id.saveexp) {
        if(amt.isEmpty()){
            Toast.makeText(getContext(), "You did not enter an amount", Toast.LENGTH_SHORT).show();
        }
        else if(date.isEmpty()){
            Toast.makeText(getContext(), "You did not enter a date", Toast.LENGTH_SHORT).show();
        }
        else if(dsr.isEmpty()){
            Toast.makeText(getContext(), "You did not enter a description", Toast.LENGTH_SHORT).show();
        }
        else{

            long i = helper.einsertData(amt,tea,date,dsr);
            if(i<=0)
            {
                Toast.makeText(getContext(),"Insertion Unsuccessful",Toast.LENGTH_LONG).show();
                a.setText("");
                b.setText("");
                c.setText("");
            } else
            {
                Toast.makeText(getContext(),"Insertion Successful",Toast.LENGTH_LONG).show();
                a.setText("");
                b.setText("");
                c.setText("");
            }
            String data=helper.egetData();
            Toast.makeText(getContext(),data,Toast.LENGTH_LONG).show();
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
