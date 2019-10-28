package com.his.Model;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MedicineList implements Serializable {
    private ArrayList<Medicine> medicines=new ArrayList<>();
    private String Time;
    private String Code;//处方名称
    private String range;//使用的范围，利用该字段判断属于个人/科室/医院
    private String Name;//组套编号（自动生成）
    private static final long serialVersionUID = 5735132092273200831L;

    public MedicineList(ArrayList<Medicine> medicines, String code) {
        this.medicines = medicines;
        Code = code;
    }
    public  MedicineList(){}

    public void setTime() {
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        int date=calendar.get(Calendar.DATE);
        String id=String.valueOf(year)+String.valueOf(month)+String.valueOf(date);
        Time=id;
    }

    public String getTime() {
        return Time;
    }

    public void setMedicines(ArrayList<Medicine> medicines) {
        this.medicines = medicines;
    }

    public void setCode(String code) {
        Code = code;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getCode() {
        return Code;
    }

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }
    public void AddMedicine(Medicine medicine){
        medicines.add(medicine);
    }

    public String getName() {
        return Name;
    }
    public void setName(){
        Name=String.valueOf((int)(Math.random()*9+1)*100000);
    }
    public void setName1(){
        Name=String.valueOf((int)(Math.random()*9+1)*1000);
    }
}
