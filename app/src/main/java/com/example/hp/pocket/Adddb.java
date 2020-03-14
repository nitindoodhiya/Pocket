package com.example.hp.pocket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.Arrays;

class Adddb {
    AddHelper ah;
    public Adddb(Context context){
        ah=new AddHelper(context);
    }
    public long iinsertData(String amount,String tag,String date,String description)
    {
        SQLiteDatabase dbb = ah.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ah.iamt, amount);
        contentValues.put(ah.itag, tag);
        contentValues.put(ah.idsr,description);
        contentValues.put(ah.idate,date);
        long id = dbb.insert(ah.TABLE_INCOME, null , contentValues);
        return id;
    }
    String makePlaceholders(int len) {
        if (len < 1) {
            // It will lead to an invalid query anyway ..
            throw new RuntimeException("No placeholders");
        } else {
            StringBuilder sb = new StringBuilder(len * 2 - 1);
            sb.append("?");
            for (int i = 1; i < len; i++) {
                sb.append(",?");
            }
            return sb.toString();
        }
    }
    public ArrayList<PieEntry> pidata(String sdate,String t,Context c){
        String[] date;
        int syear=0,smonth=0,sday=0;
            int sl=sdate.length(),q,d=0,m;
            for(q=0;q<sl;q++){
                if(sdate.charAt(q)=='-') {
                    ++d;
                }
                else{
                    if(d==0){
                        sday=sday*10+(sdate.charAt(q)-48);
                    }
                    else if(d==1){
                        smonth=smonth*10+(sdate.charAt(q)-48);
                    }
                    else{
                        syear=syear*10+(sdate.charAt(q)-48);
                    }
                }
            }
            if(t==null||t=="Day"){
                date=new String[1];
                date[0]=sdate;
            }
            else if(t=="Week"){
                date=new String[7];
                int temp,leap;
                for(temp=0;temp<7;temp++){
                    String add=sday+"-"+smonth+"-"+syear;
                    date[temp]=add;
                    if(syear%4==0 &&(syear%400==0 || syear%100!=0))
                        leap=1;
                    else
                        leap=0;
                    if(leap==1) {
                        if (sday <= 30 && smonth == 1) {
                            ++sday;
                        }
                        else if (sday == 31 && smonth == 1) {
                            sday = 1;
                            smonth = 2;
                        }
                        else if (sday <= 28 && smonth == 2) {
                            ++sday;
                        }
                        else if (sday==29 && smonth==2){
                            sday=1;
                            smonth=3;
                        }
                        else if (sday <= 30 && smonth == 3) {
                            ++sday;
                        }
                        else if (sday == 31 && smonth == 3) {
                            sday = 1;
                            smonth = 4;
                        }
                        else if(sday<=29 && smonth==4){
                            ++sday;
                        }
                        else if(sday==30 && smonth==4){
                            sday=1;
                            smonth=5;
                        }
                        else if(sday<=30 && smonth==5){
                            ++sday;
                        }
                        else if(sday==31 && smonth==5){
                            sday=1;
                            smonth=6;
                        }
                        else if(sday<=29 && smonth==6){
                            ++sday;
                        }
                        else if(sday==30 && smonth==6){
                            sday=1;
                            smonth=7;
                        }
                        else if(sday<=30 && smonth==7){
                            ++sday;
                        }
                        else if(sday==31 && smonth==7){
                            sday=1;
                            smonth=8;
                        }
                        else if(sday<=30 && smonth==8){
                            ++sday;
                        }
                        else if(sday==31 && smonth==8){
                            sday=1;
                            smonth=9;
                        }
                        else if(sday<=29 && smonth==9){
                            ++sday;
                        }
                        else if(sday==30 && smonth==9){
                            sday=1;
                            smonth=10;
                        }
                        else if(sday<=30 && smonth==10){
                            ++sday;
                        }
                        else if(sday==31 && smonth==10){
                            sday=1;
                            smonth=11;
                        }
                        else if(sday<=29 && smonth==11){
                            ++sday;
                        }
                        else if(sday==30 && smonth==11){
                            sday=1;
                            smonth=12;
                        }
                        else if(sday<=30 && smonth==12){
                            ++sday;
                        }
                        else if(sday==31 && smonth==12){
                            sday=1;
                            smonth=1;
                            ++syear;
                        }
                    }
                    else{
                        if (sday <= 30 && smonth == 1) {
                            ++sday;
                        }
                        else if (sday == 31 && smonth == 1) {
                            sday = 1;
                            smonth = 2;
                        }
                        else if (sday <= 27 && smonth == 2) {
                            ++sday;
                        }
                        else if (sday==28 && smonth==2){
                            sday=1;
                            smonth=3;
                        }
                        else if (sday <= 30 && smonth == 3) {
                            ++sday;
                        }
                        else if (sday == 31 && smonth == 3) {
                            sday = 1;
                            smonth = 4;
                        }
                        else if(sday<=29 && smonth==4){
                            ++sday;
                        }
                        else if(sday==30 && smonth==4){
                            sday=1;
                            smonth=5;
                        }
                        else if(sday<=30 && smonth==5){
                            ++sday;
                        }
                        else if(sday==31 && smonth==5){
                            sday=1;
                            smonth=6;
                        }
                        else if(sday<=29 && smonth==6){
                            ++sday;
                        }
                        else if(sday==30 && smonth==6){
                            sday=1;
                            smonth=7;
                        }
                        else if(sday<=30 && smonth==7){
                            ++sday;
                        }
                        else if(sday==31 && smonth==7){
                            sday=1;
                            smonth=8;
                        }
                        else if(sday<=30 && smonth==8){
                            ++sday;
                        }
                        else if(sday==31 && smonth==8){
                            sday=1;
                            smonth=9;
                        }
                        else if(sday<=29 && smonth==9){
                            ++sday;
                        }
                        else if(sday==30 && smonth==9){
                            sday=1;
                            smonth=10;
                        }
                        else if(sday<=30 && smonth==10){
                            ++sday;
                        }
                        else if(sday==31 && smonth==10){
                            sday=1;
                            smonth=11;
                        }
                        else if(sday<=29 && smonth==11){
                            ++sday;
                        }
                        else if(sday==30 && smonth==11){
                            sday=1;
                            smonth=12;
                        }
                        else if(sday<=30 && smonth==12){
                            ++sday;
                        }
                        else if(sday==31 && smonth==12){
                            sday=1;
                            smonth=1;
                            ++syear;
                        }
                    }
                }
            }
            else{
                date=new String[31];
                int temp,leap;
                for(temp=0;temp<31;temp++){
                    String add=sday+"-"+smonth+"-"+syear;
                    date[temp]=add;
                    if(syear%4==0 &&(syear%400==0 || syear%100!=0))
                        leap=1;
                    else
                        leap=0;
                    if(leap==1) {
                        if (sday <= 30 && smonth == 1) {
                            ++sday;
                        }
                        else if (sday == 31 && smonth == 1) {
                            sday = 1;
                            smonth = 2;
                        }
                        else if (sday <= 28 && smonth == 2) {
                            ++sday;
                        }
                        else if (sday==29 && smonth==2){
                            sday=1;
                            smonth=3;
                        }
                        else if (sday <= 30 && smonth == 3) {
                            ++sday;
                        }
                        else if (sday == 31 && smonth == 3) {
                            sday = 1;
                            smonth = 4;
                        }
                        else if(sday<=29 && smonth==4){
                            ++sday;
                        }
                        else if(sday==30 && smonth==4){
                            sday=1;
                            smonth=5;
                        }
                        else if(sday<=30 && smonth==5){
                            ++sday;
                        }
                        else if(sday==31 && smonth==5){
                            sday=1;
                            smonth=6;
                        }
                        else if(sday<=29 && smonth==6){
                            ++sday;
                        }
                        else if(sday==30 && smonth==6){
                            sday=1;
                            smonth=7;
                        }
                        else if(sday<=30 && smonth==7){
                            ++sday;
                        }
                        else if(sday==31 && smonth==7){
                            sday=1;
                            smonth=8;
                        }
                        else if(sday<=30 && smonth==8){
                            ++sday;
                        }
                        else if(sday==31 && smonth==8){
                            sday=1;
                            smonth=9;
                        }
                        else if(sday<=29 && smonth==9){
                            ++sday;
                        }
                        else if(sday==30 && smonth==9){
                            sday=1;
                            smonth=10;
                        }
                        else if(sday<=30 && smonth==10){
                            ++sday;
                        }
                        else if(sday==31 && smonth==10){
                            sday=1;
                            smonth=11;
                        }
                        else if(sday<=29 && smonth==11){
                            ++sday;
                        }
                        else if(sday==30 && smonth==11){
                            sday=1;
                            smonth=12;
                        }
                        else if(sday<=30 && smonth==12){
                            ++sday;
                        }
                        else if(sday==31 && smonth==12){
                            sday=1;
                            smonth=1;
                            ++syear;
                        }
                    }
                    else{
                        if (sday <= 30 && smonth == 1) {
                            ++sday;
                        }
                        else if (sday == 31 && smonth == 1) {
                            sday = 1;
                            smonth = 2;
                        }
                        else if (sday <= 27 && smonth == 2) {
                            ++sday;
                        }
                        else if (sday==28 && smonth==2){
                            sday=1;
                            smonth=3;
                        }
                        else if (sday <= 30 && smonth == 3) {
                            ++sday;
                        }
                        else if (sday == 31 && smonth == 3) {
                            sday = 1;
                            smonth = 4;
                        }
                        else if(sday<=29 && smonth==4){
                            ++sday;
                        }
                        else if(sday==30 && smonth==4){
                            sday=1;
                            smonth=5;
                        }
                        else if(sday<=30 && smonth==5){
                            ++sday;
                        }
                        else if(sday==31 && smonth==5){
                            sday=1;
                            smonth=6;
                        }
                        else if(sday<=29 && smonth==6){
                            ++sday;
                        }
                        else if(sday==30 && smonth==6){
                            sday=1;
                            smonth=7;
                        }
                        else if(sday<=30 && smonth==7){
                            ++sday;
                        }
                        else if(sday==31 && smonth==7){
                            sday=1;
                            smonth=8;
                        }
                        else if(sday<=30 && smonth==8){
                            ++sday;
                        }
                        else if(sday==31 && smonth==8){
                            sday=1;
                            smonth=9;
                        }
                        else if(sday<=29 && smonth==9){
                            ++sday;
                        }
                        else if(sday==30 && smonth==9){
                            sday=1;
                            smonth=10;
                        }
                        else if(sday<=30 && smonth==10){
                            ++sday;
                        }
                        else if(sday==31 && smonth==10){
                            sday=1;
                            smonth=11;
                        }
                        else if(sday<=29 && smonth==11){
                            ++sday;
                        }
                        else if(sday==30 && smonth==11){
                            sday=1;
                            smonth=12;
                        }
                        else if(sday<=30 && smonth==12){
                            ++sday;
                        }
                        else if(sday==31 && smonth==12){
                            sday=1;
                            smonth=1;
                            ++syear;
                        }
                    }
                }
            }

        ArrayList<PieEntry> entry=new ArrayList<>();
        SQLiteDatabase db = ah.getWritableDatabase();
        String[] columns = {ah.itag};
        float[] amt=new float[20];
        Cursor cursor =db.query(ah.TABLE_INCOME,columns,"Date In("+makePlaceholders(date.length)+")" ,date,null,null,null);
        String[] tag=new String[20];
        int i=0,j,k,l=0;
        while (cursor.moveToNext())
        {
            tag[i++]=cursor.getString(cursor.getColumnIndex(ah.itag));
        }
        if(i>0) {
            Arrays.sort(tag, 0, i - 1);
            String[] temp = new String[20];
            for (k = 0; k < i - 1; k++) {
                if ((tag[k].equals(tag[k + 1])) == false) {
                    temp[l++] = tag[k];
                }
            }
            temp[l++] = tag[i - 1];
            for (k = 0; k < l; k++) {
                amt[k] = 0;
                String[] col = {ah.iamt};
                Cursor find = db.query(ah.TABLE_INCOME, col, "Category='" + temp[k] + "' AND Date In(" + makePlaceholders(date.length) + ")", date, null, null, null);
                while (find.moveToNext()) {
                    Float r = Float.parseFloat(find.getString(find.getColumnIndex(ah.iamt)));
                    amt[k] = amt[k] + r;
                }
            }
            for (k = 0; k < l; k++) {
                entry.add(new PieEntry(amt[k], temp[k]));
            }
        }
            return entry;
    }
    public ArrayList<PieEntry> pedata(String sdate,String t,Context c){
        String[] date;
        int syear=0,smonth=0,sday=0;
        int sl=sdate.length(),q,d=0,m;
        for(q=0;q<sl;q++){
            if(sdate.charAt(q)=='-') {
                ++d;
            }
            else{
                if(d==0){
                    sday=sday*10+(sdate.charAt(q)-48);
                }
                else if(d==1){
                    smonth=smonth*10+(sdate.charAt(q)-48);
                }
                else{
                    syear=syear*10+(sdate.charAt(q)-48);
                }
            }
        }
        if(t==null||t=="Day"){
            date=new String[1];
            date[0]=sdate;
        }
        else if(t=="Week"){
            date=new String[7];
            int temp,leap;
            for(temp=0;temp<7;temp++){
                String add=sday+"-"+smonth+"-"+syear;
                date[temp]=add;
                if(syear%4==0 &&(syear%400==0 || syear%100!=0))
                    leap=1;
                else
                    leap=0;
                if(leap==1) {
                    if (sday <= 30 && smonth == 1) {
                        ++sday;
                    }
                    else if (sday == 31 && smonth == 1) {
                        sday = 1;
                        smonth = 2;
                    }
                    else if (sday <= 28 && smonth == 2) {
                        ++sday;
                    }
                    else if (sday==29 && smonth==2){
                        sday=1;
                        smonth=3;
                    }
                    else if (sday <= 30 && smonth == 3) {
                        ++sday;
                    }
                    else if (sday == 31 && smonth == 3) {
                        sday = 1;
                        smonth = 4;
                    }
                    else if(sday<=29 && smonth==4){
                        ++sday;
                    }
                    else if(sday==30 && smonth==4){
                        sday=1;
                        smonth=5;
                    }
                    else if(sday<=30 && smonth==5){
                        ++sday;
                    }
                    else if(sday==31 && smonth==5){
                        sday=1;
                        smonth=6;
                    }
                    else if(sday<=29 && smonth==6){
                        ++sday;
                    }
                    else if(sday==30 && smonth==6){
                        sday=1;
                        smonth=7;
                    }
                    else if(sday<=30 && smonth==7){
                        ++sday;
                    }
                    else if(sday==31 && smonth==7){
                        sday=1;
                        smonth=8;
                    }
                    else if(sday<=30 && smonth==8){
                        ++sday;
                    }
                    else if(sday==31 && smonth==8){
                        sday=1;
                        smonth=9;
                    }
                    else if(sday<=29 && smonth==9){
                        ++sday;
                    }
                    else if(sday==30 && smonth==9){
                        sday=1;
                        smonth=10;
                    }
                    else if(sday<=30 && smonth==10){
                        ++sday;
                    }
                    else if(sday==31 && smonth==10){
                        sday=1;
                        smonth=11;
                    }
                    else if(sday<=29 && smonth==11){
                        ++sday;
                    }
                    else if(sday==30 && smonth==11){
                        sday=1;
                        smonth=12;
                    }
                    else if(sday<=30 && smonth==12){
                        ++sday;
                    }
                    else if(sday==31 && smonth==12){
                        sday=1;
                        smonth=1;
                        ++syear;
                    }
                }
                else{
                    if (sday <= 30 && smonth == 1) {
                        ++sday;
                    }
                    else if (sday == 31 && smonth == 1) {
                        sday = 1;
                        smonth = 2;
                    }
                    else if (sday <= 27 && smonth == 2) {
                        ++sday;
                    }
                    else if (sday==28 && smonth==2){
                        sday=1;
                        smonth=3;
                    }
                    else if (sday <= 30 && smonth == 3) {
                        ++sday;
                    }
                    else if (sday == 31 && smonth == 3) {
                        sday = 1;
                        smonth = 4;
                    }
                    else if(sday<=29 && smonth==4){
                        ++sday;
                    }
                    else if(sday==30 && smonth==4){
                        sday=1;
                        smonth=5;
                    }
                    else if(sday<=30 && smonth==5){
                        ++sday;
                    }
                    else if(sday==31 && smonth==5){
                        sday=1;
                        smonth=6;
                    }
                    else if(sday<=29 && smonth==6){
                        ++sday;
                    }
                    else if(sday==30 && smonth==6){
                        sday=1;
                        smonth=7;
                    }
                    else if(sday<=30 && smonth==7){
                        ++sday;
                    }
                    else if(sday==31 && smonth==7){
                        sday=1;
                        smonth=8;
                    }
                    else if(sday<=30 && smonth==8){
                        ++sday;
                    }
                    else if(sday==31 && smonth==8){
                        sday=1;
                        smonth=9;
                    }
                    else if(sday<=29 && smonth==9){
                        ++sday;
                    }
                    else if(sday==30 && smonth==9){
                        sday=1;
                        smonth=10;
                    }
                    else if(sday<=30 && smonth==10){
                        ++sday;
                    }
                    else if(sday==31 && smonth==10){
                        sday=1;
                        smonth=11;
                    }
                    else if(sday<=29 && smonth==11){
                        ++sday;
                    }
                    else if(sday==30 && smonth==11){
                        sday=1;
                        smonth=12;
                    }
                    else if(sday<=30 && smonth==12){
                        ++sday;
                    }
                    else if(sday==31 && smonth==12){
                        sday=1;
                        smonth=1;
                        ++syear;
                    }
                }
            }
        }
        else {
            date=new String[31];
            int temp,leap;
            for(temp=0;temp<31;temp++){
                String add=sday+"-"+smonth+"-"+syear;
                date[temp]=add;
                if(syear%4==0 &&(syear%400==0 || syear%100!=0))
                    leap=1;
                else
                    leap=0;
                if(leap==1) {
                    if (sday <= 30 && smonth == 1) {
                        ++sday;
                    }
                    else if (sday == 31 && smonth == 1) {
                        sday = 1;
                        smonth = 2;
                    }
                    else if (sday <= 28 && smonth == 2) {
                        ++sday;
                    }
                    else if (sday==29 && smonth==2){
                        sday=1;
                        smonth=3;
                    }
                    else if (sday <= 30 && smonth == 3) {
                        ++sday;
                    }
                    else if (sday == 31 && smonth == 3) {
                        sday = 1;
                        smonth = 4;
                    }
                    else if(sday<=29 && smonth==4){
                        ++sday;
                    }
                    else if(sday==30 && smonth==4){
                        sday=1;
                        smonth=5;
                    }
                    else if(sday<=30 && smonth==5){
                        ++sday;
                    }
                    else if(sday==31 && smonth==5){
                        sday=1;
                        smonth=6;
                    }
                    else if(sday<=29 && smonth==6){
                        ++sday;
                    }
                    else if(sday==30 && smonth==6){
                        sday=1;
                        smonth=7;
                    }
                    else if(sday<=30 && smonth==7){
                        ++sday;
                    }
                    else if(sday==31 && smonth==7){
                        sday=1;
                        smonth=8;
                    }
                    else if(sday<=30 && smonth==8){
                        ++sday;
                    }
                    else if(sday==31 && smonth==8){
                        sday=1;
                        smonth=9;
                    }
                    else if(sday<=29 && smonth==9){
                        ++sday;
                    }
                    else if(sday==30 && smonth==9){
                        sday=1;
                        smonth=10;
                    }
                    else if(sday<=30 && smonth==10){
                        ++sday;
                    }
                    else if(sday==31 && smonth==10){
                        sday=1;
                        smonth=11;
                    }
                    else if(sday<=29 && smonth==11){
                        ++sday;
                    }
                    else if(sday==30 && smonth==11){
                        sday=1;
                        smonth=12;
                    }
                    else if(sday<=30 && smonth==12){
                        ++sday;
                    }
                    else if(sday==31 && smonth==12){
                        sday=1;
                        smonth=1;
                        ++syear;
                    }
                }
                else{
                    if (sday <= 30 && smonth == 1) {
                        ++sday;
                    }
                    else if (sday == 31 && smonth == 1) {
                        sday = 1;
                        smonth = 2;
                    }
                    else if (sday <= 27 && smonth == 2) {
                        ++sday;
                    }
                    else if (sday==28 && smonth==2){
                        sday=1;
                        smonth=3;
                    }
                    else if (sday <= 30 && smonth == 3) {
                        ++sday;
                    }
                    else if (sday == 31 && smonth == 3) {
                        sday = 1;
                        smonth = 4;
                    }
                    else if(sday<=29 && smonth==4){
                        ++sday;
                    }
                    else if(sday==30 && smonth==4){
                        sday=1;
                        smonth=5;
                    }
                    else if(sday<=30 && smonth==5){
                        ++sday;
                    }
                    else if(sday==31 && smonth==5){
                        sday=1;
                        smonth=6;
                    }
                    else if(sday<=29 && smonth==6){
                        ++sday;
                    }
                    else if(sday==30 && smonth==6){
                        sday=1;
                        smonth=7;
                    }
                    else if(sday<=30 && smonth==7){
                        ++sday;
                    }
                    else if(sday==31 && smonth==7){
                        sday=1;
                        smonth=8;
                    }
                    else if(sday<=30 && smonth==8){
                        ++sday;
                    }
                    else if(sday==31 && smonth==8){
                        sday=1;
                        smonth=9;
                    }
                    else if(sday<=29 && smonth==9){
                        ++sday;
                    }
                    else if(sday==30 && smonth==9){
                        sday=1;
                        smonth=10;
                    }
                    else if(sday<=30 && smonth==10){
                        ++sday;
                    }
                    else if(sday==31 && smonth==10){
                        sday=1;
                        smonth=11;
                    }
                    else if(sday<=29 && smonth==11){
                        ++sday;
                    }
                    else if(sday==30 && smonth==11){
                        sday=1;
                        smonth=12;
                    }
                    else if(sday<=30 && smonth==12){
                        ++sday;
                    }
                    else if(sday==31 && smonth==12){
                        sday=1;
                        smonth=1;
                        ++syear;
                    }
                }
            }
        }

        ArrayList<PieEntry> entry=new ArrayList<>();
        SQLiteDatabase db = ah.getWritableDatabase();
        String[] columns = {ah.etag};
        float[] amt=new float[20];
        Cursor cursor =db.query(ah.TABLE_EXPENSE,columns,"Date In("+makePlaceholders(date.length)+")" ,date,null,null,null);
        String[] tag=new String[20];
        int i=0,j,k,l=0;
        while (cursor.moveToNext())
        {
            tag[i++]=cursor.getString(cursor.getColumnIndex(ah.etag));
        }
        if(i>0) {
            Arrays.sort(tag, 0, i - 1);
            String[] temp = new String[20];
            for (k = 0; k < i - 1; k++) {
                if ((tag[k].equals(tag[k + 1])) == false) {
                    temp[l++] = tag[k];
                }
            }
            temp[l++] = tag[i - 1];
            for (k = 0; k < l; k++) {
                amt[k] = 0;
                String[] col = {ah.eamt};
                Cursor find = db.query(ah.TABLE_EXPENSE, col, "Category='" + temp[k] + "' AND Date In(" + makePlaceholders(date.length) + ")", date, null, null, null);
                while (find.moveToNext()) {
                    Float r = Float.parseFloat(find.getString(find.getColumnIndex(ah.eamt)));
                    amt[k] = amt[k] + r;
                }
            }
            for (k = 0; k < l; k++) {
                entry.add(new PieEntry(amt[k], temp[k]));
            }
        }
        return entry;
    }
    public void bidata(String fdate, String sdate, String t, Context c, BarChart bc){
        String[] firstdate;
        String[] seconddate;
        int syear=0,smonth=0,sday=0,fday=0,fmonth=0,fyear=0;
        int sl=sdate.length(),q,d=0,m;
        for(q=0;q<sl;q++){
            if(sdate.charAt(q)=='-') {
                ++d;
            }
            else{
                if(d==0){
                    sday=sday*10+(sdate.charAt(q)-48);
                }
                else if(d==1){
                    smonth=smonth*10+(sdate.charAt(q)-48);
                }
                else{
                    syear=syear*10+(sdate.charAt(q)-48);
                }
            }
        }
        sl=fdate.length();
        d=0;
        for(q=0;q<sl;q++){
            if(fdate.charAt(q)=='-') {
                ++d;
            }
            else{
                if(d==0){
                    fday=fday*10+(fdate.charAt(q)-48);
                }
                else if(d==1){
                    fmonth=fmonth*10+(fdate.charAt(q)-48);
                }
                else{
                    fyear=fyear*10+(fdate.charAt(q)-48);
                }
            }
        }
        if(t==null||t=="Day"){
            seconddate=new String[1];
            seconddate[0]=sdate;
        }
        else if(t=="Week"){
            seconddate=new String[7];
            int temp,leap;
            for(temp=0;temp<7;temp++){
                String add=sday+"-"+smonth+"-"+syear;
                seconddate[temp]=add;
                if(syear%4==0 &&(syear%400==0 || syear%100!=0))
                    leap=1;
                else
                    leap=0;
                if(leap==1) {
                    if (sday <= 30 && smonth == 1) {
                        ++sday;
                    }
                    else if (sday == 31 && smonth == 1) {
                        sday = 1;
                        smonth = 2;
                    }
                    else if (sday <= 28 && smonth == 2) {
                        ++sday;
                    }
                    else if (sday==29 && smonth==2){
                        sday=1;
                        smonth=3;
                    }
                    else if (sday <= 30 && smonth == 3) {
                        ++sday;
                    }
                    else if (sday == 31 && smonth == 3) {
                        sday = 1;
                        smonth = 4;
                    }
                    else if(sday<=29 && smonth==4){
                        ++sday;
                    }
                    else if(sday==30 && smonth==4){
                        sday=1;
                        smonth=5;
                    }
                    else if(sday<=30 && smonth==5){
                        ++sday;
                    }
                    else if(sday==31 && smonth==5){
                        sday=1;
                        smonth=6;
                    }
                    else if(sday<=29 && smonth==6){
                        ++sday;
                    }
                    else if(sday==30 && smonth==6){
                        sday=1;
                        smonth=7;
                    }
                    else if(sday<=30 && smonth==7){
                        ++sday;
                    }
                    else if(sday==31 && smonth==7){
                        sday=1;
                        smonth=8;
                    }
                    else if(sday<=30 && smonth==8){
                        ++sday;
                    }
                    else if(sday==31 && smonth==8){
                        sday=1;
                        smonth=9;
                    }
                    else if(sday<=29 && smonth==9){
                        ++sday;
                    }
                    else if(sday==30 && smonth==9){
                        sday=1;
                        smonth=10;
                    }
                    else if(sday<=30 && smonth==10){
                        ++sday;
                    }
                    else if(sday==31 && smonth==10){
                        sday=1;
                        smonth=11;
                    }
                    else if(sday<=29 && smonth==11){
                        ++sday;
                    }
                    else if(sday==30 && smonth==11){
                        sday=1;
                        smonth=12;
                    }
                    else if(sday<=30 && smonth==12){
                        ++sday;
                    }
                    else if(sday==31 && smonth==12){
                        sday=1;
                        smonth=1;
                        ++syear;
                    }
                }
                else{
                    if (sday <= 30 && smonth == 1) {
                        ++sday;
                    }
                    else if (sday == 31 && smonth == 1) {
                        sday = 1;
                        smonth = 2;
                    }
                    else if (sday <= 27 && smonth == 2) {
                        ++sday;
                    }
                    else if (sday==28 && smonth==2){
                        sday=1;
                        smonth=3;
                    }
                    else if (sday <= 30 && smonth == 3) {
                        ++sday;
                    }
                    else if (sday == 31 && smonth == 3) {
                        sday = 1;
                        smonth = 4;
                    }
                    else if(sday<=29 && smonth==4){
                        ++sday;
                    }
                    else if(sday==30 && smonth==4){
                        sday=1;
                        smonth=5;
                    }
                    else if(sday<=30 && smonth==5){
                        ++sday;
                    }
                    else if(sday==31 && smonth==5){
                        sday=1;
                        smonth=6;
                    }
                    else if(sday<=29 && smonth==6){
                        ++sday;
                    }
                    else if(sday==30 && smonth==6){
                        sday=1;
                        smonth=7;
                    }
                    else if(sday<=30 && smonth==7){
                        ++sday;
                    }
                    else if(sday==31 && smonth==7){
                        sday=1;
                        smonth=8;
                    }
                    else if(sday<=30 && smonth==8){
                        ++sday;
                    }
                    else if(sday==31 && smonth==8){
                        sday=1;
                        smonth=9;
                    }
                    else if(sday<=29 && smonth==9){
                        ++sday;
                    }
                    else if(sday==30 && smonth==9){
                        sday=1;
                        smonth=10;
                    }
                    else if(sday<=30 && smonth==10){
                        ++sday;
                    }
                    else if(sday==31 && smonth==10){
                        sday=1;
                        smonth=11;
                    }
                    else if(sday<=29 && smonth==11){
                        ++sday;
                    }
                    else if(sday==30 && smonth==11){
                        sday=1;
                        smonth=12;
                    }
                    else if(sday<=30 && smonth==12){
                        ++sday;
                    }
                    else if(sday==31 && smonth==12){
                        sday=1;
                        smonth=1;
                        ++syear;
                    }
                }
            }
        }
        else {
            seconddate=new String[31];
            int temp,leap;
            for(temp=0;temp<31;temp++){
                String add=sday+"-"+smonth+"-"+syear;
                seconddate[temp]=add;
                if(syear%4==0 &&(syear%400==0 || syear%100!=0))
                    leap=1;
                else
                    leap=0;
                if(leap==1) {
                    if (sday <= 30 && smonth == 1) {
                        ++sday;
                    }
                    else if (sday == 31 && smonth == 1) {
                        sday = 1;
                        smonth = 2;
                    }
                    else if (sday <= 28 && smonth == 2) {
                        ++sday;
                    }
                    else if (sday==29 && smonth==2){
                        sday=1;
                        smonth=3;
                    }
                    else if (sday <= 30 && smonth == 3) {
                        ++sday;
                    }
                    else if (sday == 31 && smonth == 3) {
                        sday = 1;
                        smonth = 4;
                    }
                    else if(sday<=29 && smonth==4){
                        ++sday;
                    }
                    else if(sday==30 && smonth==4){
                        sday=1;
                        smonth=5;
                    }
                    else if(sday<=30 && smonth==5){
                        ++sday;
                    }
                    else if(sday==31 && smonth==5){
                        sday=1;
                        smonth=6;
                    }
                    else if(sday<=29 && smonth==6){
                        ++sday;
                    }
                    else if(sday==30 && smonth==6){
                        sday=1;
                        smonth=7;
                    }
                    else if(sday<=30 && smonth==7){
                        ++sday;
                    }
                    else if(sday==31 && smonth==7){
                        sday=1;
                        smonth=8;
                    }
                    else if(sday<=30 && smonth==8){
                        ++sday;
                    }
                    else if(sday==31 && smonth==8){
                        sday=1;
                        smonth=9;
                    }
                    else if(sday<=29 && smonth==9){
                        ++sday;
                    }
                    else if(sday==30 && smonth==9){
                        sday=1;
                        smonth=10;
                    }
                    else if(sday<=30 && smonth==10){
                        ++sday;
                    }
                    else if(sday==31 && smonth==10){
                        sday=1;
                        smonth=11;
                    }
                    else if(sday<=29 && smonth==11){
                        ++sday;
                    }
                    else if(sday==30 && smonth==11){
                        sday=1;
                        smonth=12;
                    }
                    else if(sday<=30 && smonth==12){
                        ++sday;
                    }
                    else if(sday==31 && smonth==12){
                        sday=1;
                        smonth=1;
                        ++syear;
                    }
                }
                else{
                    if (sday <= 30 && smonth == 1) {
                        ++sday;
                    }
                    else if (sday == 31 && smonth == 1) {
                        sday = 1;
                        smonth = 2;
                    }
                    else if (sday <= 27 && smonth == 2) {
                        ++sday;
                    }
                    else if (sday==28 && smonth==2){
                        sday=1;
                        smonth=3;
                    }
                    else if (sday <= 30 && smonth == 3) {
                        ++sday;
                    }
                    else if (sday == 31 && smonth == 3) {
                        sday = 1;
                        smonth = 4;
                    }
                    else if(sday<=29 && smonth==4){
                        ++sday;
                    }
                    else if(sday==30 && smonth==4){
                        sday=1;
                        smonth=5;
                    }
                    else if(sday<=30 && smonth==5){
                        ++sday;
                    }
                    else if(sday==31 && smonth==5){
                        sday=1;
                        smonth=6;
                    }
                    else if(sday<=29 && smonth==6){
                        ++sday;
                    }
                    else if(sday==30 && smonth==6){
                        sday=1;
                        smonth=7;
                    }
                    else if(sday<=30 && smonth==7){
                        ++sday;
                    }
                    else if(sday==31 && smonth==7){ sday=1;
                        smonth=8;
                    }
                    else if(sday<=30 && smonth==8){
                        ++sday;
                    }
                    else if(sday==31 && smonth==8){
                        sday=1;
                        smonth=9;
                    }
                    else if(sday<=29 && smonth==9){
                        ++sday;
                    }
                    else if(sday==30 && smonth==9){
                        sday=1;
                        smonth=10;
                    }
                    else if(sday<=30 && smonth==10){
                        ++sday;
                    }
                    else if(sday==31 && smonth==10){
                        sday=1;
                        smonth=11;
                    }
                    else if(sday<=29 && smonth==11){
                        ++sday;
                    }
                    else if(sday==30 && smonth==11){
                        sday=1;
                        smonth=12;
                    }
                    else if(sday<=30 && smonth==12){
                        ++sday;
                    }
                    else if(sday==31 && smonth==12){
                        sday=1;
                        smonth=1;
                        ++syear;
                    }
                }
            }
        }
        if(t==null||t=="Day"){
            firstdate=new String[1];
            firstdate[0]=fdate;
        }
        else if(t=="Week"){
            firstdate=new String[7];
            int temp,leap;
            for(temp=0;temp<7;temp++){
                String add=fday+"-"+fmonth+"-"+fyear;
                firstdate[temp]=add;
                if(fyear%4==0 &&(fyear%400==0 || fyear%100!=0))
                    leap=1;
                else
                    leap=0;
                if(leap==1) {
                    if (fday <= 30 && fmonth == 1) {
                        ++fday;
                    }
                    else if (fday == 31 && fmonth == 1) {
                        fday = 1;
                        fmonth = 2;
                    }
                    else if (fday <= 28 && fmonth == 2) {
                        ++fday;
                    }
                    else if (fday==29 && fmonth==2){
                        fday=1;
                        fmonth=3;
                    }
                    else if (fday <= 30 && fmonth == 3) {
                        ++fday;
                    }
                    else if (fday == 31 && fmonth == 3) {
                        fday = 1;
                        fmonth = 4;
                    }
                    else if(fday<=29 && fmonth==4){
                        ++fday;
                    }
                    else if(fday==30 && fmonth==4){
                        fday=1;
                        fmonth=5;
                    }
                    else if(fday<=30 && fmonth==5){
                        ++fday;
                    }
                    else if(fday==31 && fmonth==5){
                        fday=1;
                        fmonth=6;
                    }
                    else if(fday<=29 && fmonth==6){
                        ++fday;
                    }
                    else if(fday==30 && fmonth==6){
                        fday=1;
                        fmonth=7;
                    }
                    else if(fday<=30 && fmonth==7){
                        ++fday;
                    }
                    else if(fday==31 && fmonth==7){
                        fday=1;
                        fmonth=8;
                    }
                    else if(fday<=30 && fmonth==8){
                        ++fday;
                    }
                    else if(fday==31 && fmonth==8){
                        fday=1;
                        fmonth=9;
                    }
                    else if(fday<=29 && fmonth==9){
                        ++fday;
                    }
                    else if(fday==30 && fmonth==9){
                        fday=1;
                        fmonth=10;
                    }
                    else if(fday<=30 && fmonth==10){
                        ++fday;
                    }
                    else if(fday==31 && fmonth==10){
                        fday=1;
                        fmonth=11;
                    }
                    else if(fday<=29 && fmonth==11){
                        ++fday;
                    }
                    else if(fday==30 && fmonth==11){
                        fday=1;
                        fmonth=12;
                    }
                    else if(fday<=30 && fmonth==12){
                        ++fday;
                    }
                    else if(fday==31 && fmonth==12){
                        fday=1;
                        fmonth=1;
                        ++fyear;
                    }
                }
                else{
                    if (fday <= 30 && fmonth == 1) {
                        ++fday;
                    }
                    else if (fday == 31 && fmonth == 1) {
                        fday = 1;
                        fmonth = 2;
                    }
                    else if (fday <= 27 && fmonth == 2) {
                        ++fday;
                    }
                    else if (fday==28 && fmonth==2){
                        fday=1;
                        fmonth=3;
                    }
                    else if (fday <= 30 && fmonth == 3) {
                        ++fday;
                    }
                    else if (fday == 31 && fmonth == 3) {
                        fday = 1;
                        fmonth = 4;
                    }
                    else if(fday<=29 && fmonth==4){
                        ++fday;
                    }
                    else if(fday==30 && fmonth==4){
                        fday=1;
                        fmonth=5;
                    }
                    else if(fday<=30 && fmonth==5){
                        ++fday;
                    }
                    else if(fday==31 && fmonth==5){
                        fday=1;
                        fmonth=6;
                    }
                    else if(fday<=29 && fmonth==6){
                        ++fday;
                    }
                    else if(fday==30 && fmonth==6){
                        fday=1;
                        fmonth=7;
                    }
                    else if(fday<=30 && fmonth==7){
                        ++fday;
                    }
                    else if(fday==31 && fmonth==7){
                        fday=1;
                        fmonth=8;
                    }
                    else if(fday<=30 && fmonth==8){
                        ++fday;
                    }
                    else if(fday==31 && fmonth==8){
                        fday=1;
                        fmonth=9;
                    }
                    else if(fday<=29 && fmonth==9){
                        ++fday;
                    }
                    else if(fday==30 && fmonth==9){
                        fday=1;
                        fmonth=10;
                    }
                    else if(fday<=30 && fmonth==10){
                        ++fday;
                    }
                    else if(fday==31 && fmonth==10){
                        fday=1;
                        fmonth=11;
                    }
                    else if(fday<=29 && fmonth==11){
                        ++fday;
                    }
                    else if(fday==30 && fmonth==11){
                        fday=1;
                        fmonth=12;
                    }
                    else if(fday<=30 && fmonth==12){
                        ++fday;
                    }
                    else if(fday==31 && fmonth==12){
                        fday=1;
                        fmonth=1;
                        ++fyear;
                    }
                }
            }
        }
        else {
            firstdate = new String[31];
            int temp, leap;
            for (temp = 0; temp < 31; temp++) {
                String add = sday + "-" + smonth + "-" + syear;
                firstdate[temp] = add;
                if (fyear % 4 == 0 && (fyear % 400 == 0 || fyear % 100 != 0))
                    leap = 1;
                else
                    leap = 0;
                if (leap == 1) {
                    if (fday <= 30 && fmonth == 1) {
                        ++fday;
                    }
                    else if (fday == 31 && fmonth == 1) {
                        fday = 1;
                        fmonth = 2;
                    }
                    else if (fday <= 28 && fmonth == 2) {
                        ++fday;
                    }
                    else if (fday == 29 && fmonth == 2) {
                        fday = 1;
                        fmonth = 3;
                    }
                    else if (fday <= 30 && fmonth == 3) {
                        ++fday;
                    }
                    else if (fday == 31 && fmonth == 3) {
                        fday = 1;
                        fmonth = 4;
                    }
                    else if (fday <= 29 && fmonth == 4) {
                        ++fday;
                    }
                    else if (fday == 30 && fmonth == 4) {
                        fday = 1;
                        fmonth = 5;
                    }
                    else if (fday <= 30 && fmonth == 5) {
                        ++fday;
                    }
                    else if (fday == 31 && fmonth == 5) {
                        fday = 1;
                        fmonth = 6;
                    }
                    else if (fday <= 29 && fmonth == 6) {
                        ++fday;
                    }
                    else if (fday == 30 && fmonth == 6) {
                        fday = 1;
                        fmonth = 7;
                    }
                    else if (fday <= 30 && fmonth == 7) {
                        ++fday;
                    }
                    else if (fday == 31 && fmonth == 7) {
                        fday = 1;
                        fmonth = 8;
                    }
                    else if (fday <= 30 && fmonth == 8) {
                        ++fday;
                    }
                    else if (fday == 31 && fmonth == 8) {
                        fday = 1;
                        fmonth = 9;
                    }
                    else if (fday <= 29 && fmonth == 9) {
                        ++fday;
                    }
                    else if (fday == 30 && fmonth == 9) {
                        fday = 1;
                        fmonth = 10;
                    }
                    else if (fday <= 30 && fmonth == 10) {
                        ++fday;
                    }
                    else if (fday == 31 && fmonth == 10) {
                        fday = 1;
                        fmonth = 11;
                    }
                    else if (fday <= 29 && fmonth == 11) {
                        ++fday;
                    }
                    else if (fday == 30 && fmonth == 11) {
                        fday = 1;
                        fmonth = 12;
                    }
                    else if (fday <= 30 && fmonth == 12) {
                        ++fday;
                    }
                    else if (fday == 31 && fmonth == 12) {
                        fday = 1;
                        fmonth = 1;
                        ++fyear;
                    }
                }
                else {
                    if (fday <= 30 && fmonth == 1) {
                        ++fday;
                    }
                    else if (fday == 31 && fmonth == 1) {
                        fday = 1;
                        fmonth = 2;
                    }
                    else if (fday <= 27 && fmonth == 2) {
                        ++fday;
                    }
                    else if (fday == 28 && fmonth == 2) {
                        fday = 1;
                        fmonth = 3;
                    }
                    else if (fday <= 30 && fmonth == 3) {
                        ++fday;
                    }
                    else if (fday == 31 && fmonth == 3) {
                        fday = 1;
                        fmonth = 4;
                    }
                    else if (fday <= 29 && fmonth == 4) {
                        ++fday;
                    }
                    else if (fday == 30 && fmonth == 4) {
                        fday = 1;
                        fmonth = 5;
                    }
                    else if (fday <= 30 && fmonth == 5) {
                        ++fday;
                    }
                    else if (fday == 31 && fmonth == 5) {
                        fday = 1;
                        fmonth = 6;
                    }
                    else if (fday <= 29 && fmonth == 6) {
                        ++fday;
                    }
                    else if (fday == 30 && fmonth == 6) {
                        fday = 1;
                        fmonth = 7;
                    }
                    else if (fday <= 30 && fmonth == 7) {
                        ++fday;
                    }
                    else if (fday == 31 && fmonth == 7) {
                        fday = 1;
                        fmonth = 8;
                    }
                    else if (fday <= 30 && fmonth == 8) {
                        ++fday;
                    }
                    else if (fday == 31 && fmonth == 8) {
                        fday = 1;
                        fmonth = 9;
                    }
                    else if (fday <= 29 && fmonth == 9) {
                        ++fday;
                    }
                    else if (fday == 30 && fmonth == 9) {
                        fday = 1;
                        fmonth = 10;
                    }
                    else if (fday <= 30 && fmonth == 10) {
                        ++fday;
                    }
                    else if (fday == 31 && fmonth == 10) {
                        fday = 1;
                        fmonth = 11;
                    }
                    else if (fday <= 29 && fmonth == 11) {
                        ++fday;
                    }
                    else if (fday == 30 && fmonth == 11) {
                        fday = 1;
                        fmonth = 12;
                    }
                    else if (fday <= 30 && fmonth == 12) {
                        ++fday;
                    }
                    else if (fday == 31 && fmonth == 12) {
                        fday = 1;
                        fmonth = 1;
                        ++fyear;
                    }
                }
            }
        }
        SQLiteDatabase db = ah.getWritableDatabase();
        ArrayList<BarEntry> entry1 = new ArrayList<>();
        ArrayList<BarEntry> entry2=new ArrayList<>();
        String[] columns={ah.etag};
        float amt;
        Cursor cursorf =db.query(ah.TABLE_INCOME,columns,"Date In("+makePlaceholders(firstdate.length)+")" ,firstdate,null,null,null);
        String[] tag=new String[40];
        int i=0,j,k,l=0;
        while (cursorf.moveToNext())
        {
            tag[i++]=cursorf.getString(cursorf.getColumnIndex(ah.itag));
        }
        Cursor cursors =db.query(ah.TABLE_INCOME,columns,"Date In("+makePlaceholders(seconddate.length)+")" ,seconddate,null,null,null);
        while (cursors.moveToNext())
        {
            tag[i++]=cursors.getString(cursors.getColumnIndex(ah.itag));
        }
        if(i>0) {
            Arrays.sort(tag, 0, i - 1);
            String[] temp = new String[40];
            for (k = 0; k < i - 1; k++) {
                if ((tag[k].equals(tag[k + 1])) == false) {
                    temp[l++] = tag[k];
                }
            }
            temp[l++] = tag[i - 1];
            float amt2;
            for (k = 0; k < l; k++) {
                amt = 0;
                amt2=0;
                String[] col = {ah.iamt};
                Cursor ffind = db.query(ah.TABLE_INCOME, col, "Category='" + temp[k] + "' AND Date In(" + makePlaceholders(firstdate.length) + ")", firstdate, null, null, null);
                Cursor sfind = db.query(ah.TABLE_INCOME, col, "Category='" + temp[k] + "' AND Date In(" + makePlaceholders(seconddate.length) + ")", seconddate, null, null, null);
                while (ffind.moveToNext()) {
                    Float r = Float.parseFloat(ffind.getString(ffind.getColumnIndex(ah.iamt)));
                    amt = amt + r;
                }
                while (sfind.moveToNext()) {
                    Float y = Float.parseFloat(sfind.getString(sfind.getColumnIndex(ah.iamt)));
                    amt2 = amt2 + y;
                }
                entry1.add(new BarEntry(k+1,amt));
                entry2.add(new BarEntry(k+1,amt2));
            }
            BarDataSet bds1=new BarDataSet(entry1,fdate);
            bds1.setColor(Color.GREEN);
            BarDataSet bds2=new BarDataSet(entry2,sdate);
            bds2.setColor(Color.BLUE);

            BarData data=new BarData(bds1,bds2);
            bc.setData(data);
            XAxis xaxis=bc.getXAxis();

            xaxis.setValueFormatter(new IndexAxisValueFormatter(temp));
            xaxis.setCenterAxisLabels(true);
            xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            bc.setDragEnabled(true);
            bc.setVisibleXRangeMaximum(3);

            float bs=0.1f;
            float gs=0.5f;

            data.setBarWidth(0.10f);
            bc.getXAxis().setAxisMinimum(0);
            bc.getXAxis().setAxisMaximum(0+bc.getData().getGroupWidth(gs,bs)*7);

            bc.getAxisLeft().setAxisMinimum(0);

            bc.groupBars(0,gs,bs);

            bc.groupBars(0,gs,bs);
            bc.invalidate();

        }

    }
    public String igetData()
    {
        SQLiteDatabase db = ah.getWritableDatabase();
        String[] columns = {ah.iID,ah.iamt,ah.itag,ah.idsr,ah.idate};
        Cursor cursor =db.query(ah.TABLE_INCOME,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(ah.iID));
            String amt =cursor.getString(cursor.getColumnIndex(ah.iamt));
            String  tag =cursor.getString(cursor.getColumnIndex(ah.itag));
            String dsr=cursor.getString(cursor.getColumnIndex(ah.idsr));
            String date=cursor.getString(cursor.getColumnIndex(ah.idate));
            buffer.append(cid+ "   " + amt + "   " + tag +"  " +dsr+ "  " +date+ " \n");
        }
        return buffer.toString();
    }
    public long einsertData(String amount,String tag,String date,String description)
    {
        SQLiteDatabase dbb = ah.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ah.eamt, amount);
        contentValues.put(ah.etag, tag);
        contentValues.put(ah.edsr,description);
        contentValues.put(ah.edate,date);
        long id = dbb.insert(ah.TABLE_EXPENSE, null , contentValues);
        return id;
    }
    public String egetData()
    {
        SQLiteDatabase db = ah.getWritableDatabase();
        String[] columns = {ah.eID,ah.eamt,ah.etag,ah.edsr,ah.edate};
        Cursor cursor =db.query(ah.TABLE_EXPENSE,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(ah.eID));
            String amt =cursor.getString(cursor.getColumnIndex(ah.eamt));
            String  tag =cursor.getString(cursor.getColumnIndex(ah.etag));
            String dsr=cursor.getString(cursor.getColumnIndex(ah.edsr));
            String date=cursor.getString(cursor.getColumnIndex(ah.edate));
            buffer.append(cid+ "   " + amt + "   " + tag +"  " +dsr+ "  " +date+ " \n");
        }
        return buffer.toString();
    }

    private class AddHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "pocket";    // Database Name
        private static final String TABLE_INCOME = "Income";
        private static final String TABLE_EXPENSE = "Expense";// Table Name
        private static final int DATABASE_Version = 1;
        private static final String iID="id";
        private static final String iamt = "Amount";
        private static final String itag = "Category";
        private static final String idsr = "Description";
        private static final String idate="Date";
        private static final String eID="id";
        private static final String eamt = "Amount";
        private static final String etag = "Category";
        private static final String edsr = "Description";
        private static final String edate="Date";
        private static final String CREATE_TABLE_INCOME= "CREATE TABLE "+TABLE_INCOME+
                " ("+iID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+iamt+" VARCHAR(255) ,"+ itag+" VARCHAR(225), "+idsr+" VARCHAR(255), "+idate+" VARCHAR(255));";
        private static final String CREATE_TABLE_EXPENSE= "CREATE TABLE "+TABLE_EXPENSE+
                " ("+eID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+eamt+" VARCHAR(255) ,"+ etag+" VARCHAR(225), "+edsr+" VARCHAR(255), "+edate+" VARCHAR(255));";
        private static final String DROP_INCOME ="DROP TABLE IF EXISTS "+TABLE_INCOME;
        private static final String DROP_EXPENSE ="DROP TABLE IF EXISTS "+TABLE_EXPENSE;
        private Context context;
        public AddHelper(Context context){
            super(context, DATABASE_NAME, null,DATABASE_Version);
            this.context=context;
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_TABLE_INCOME);
                db.execSQL(CREATE_TABLE_EXPENSE);
            } catch (Exception e) {
                Toast.makeText(context, "" + e, Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Toast.makeText(context,"On Upgrade", Toast.LENGTH_LONG).show();
                db.execSQL(DROP_INCOME);
                db.execSQL(DROP_EXPENSE);
                onCreate(db);
            }catch (Exception e) {
                Toast.makeText(context,""+e, Toast.LENGTH_LONG).show();
            }
        }
    }
}
