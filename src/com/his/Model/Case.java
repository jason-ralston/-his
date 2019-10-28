package com.his.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Case implements Serializable {
    private String Id;
    private String Feeling;//主诉
    private String NowIll;//现病史
    private String PassIll;//过往病史
    private String Allergy;//过敏史
    private String Body;//体格检查
    private String person;//个人史
    private boolean Cash ;//是否收费
    private ArrayList<MedicineList> medicineLists=new ArrayList<>();
    //处方
    private ArrayList<Disease> WestDisease=new ArrayList<>();
    //初步诊断（西）
    private ArrayList<Disease> ChinaDisease=new ArrayList<>();
    //初步诊断（中）
    private String DoctorCode;
    private String PatientCode;
    private static final long serialVersionUID = 2735132092273200831L;
    private Calendar calendar=Calendar.getInstance();
    public String SetId(){
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        int date=calendar.get(Calendar.DATE);
        int second=calendar.get(Calendar.SECOND);
        int minute=calendar.get(Calendar.MINUTE);
        String id=String.valueOf(year)+String.valueOf(month)+String.valueOf(date)+String.valueOf(minute)+String.valueOf(second);
        return id;

        }

    public String getId() {
        return Id;
    }

    public Case( String feeling, String nowIll, String passIll, String allergy, String body) {
        Feeling = feeling;
        NowIll = nowIll;
        PassIll = passIll;
        Allergy = allergy;
        Body = body;
    }
    public  Case(){}

    public void setDoctorCode(String doctorName) {
        DoctorCode = doctorName;
    }

    public void setPatientCode(String patientName) {
        PatientCode = patientName;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setAllergy(String allergy) {
        Allergy = allergy;
    }

    public void setBody(String body) {
        Body = body;
    }

    public void setFeeling(String feeling) {
        Feeling = feeling;
    }

    public void setNowIll(String nowIll) {
        NowIll = nowIll;
    }

    public void setPassIll(String passIll) {
        PassIll = passIll;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public void setChinaDisease(ArrayList<Disease> chinaDisease) {
        ChinaDisease = chinaDisease;
    }

    public void setWestDisease(ArrayList<Disease> westDisease) {
        WestDisease = westDisease;
    }
    public String[] ToString(){
        String S="";
        for (Disease d:WestDisease
             ) {
            S=S+" "+d.getName();
        }
        String[] strings=new String[]{Id,Feeling,S};
        return strings;
    }

    public String getBody() {
        return Body;
    }

    public String getAllergy() {
        return Allergy;
    }

    public String getFeeling() {
        return Feeling;
    }

    public String getNowIll() {
        return NowIll;
    }

    public String getPassIll() {
        return PassIll;
    }

    public ArrayList<Disease> getWestDisease() {
        return WestDisease;
    }

    public ArrayList<MedicineList> getMedicineLists() {
        return medicineLists;
    }

    public void setMedicineLists(ArrayList<MedicineList> medicineLists) {
        this.medicineLists = medicineLists;
    }
    public MedicineList searchMedicinelist(String code){
        MedicineList medicineList=new MedicineList();
        for (MedicineList m:medicineLists
             ) {
            if (m.getCode().equals(code)){
                medicineList=m;
            }

        }
        return medicineList;
    }

    public void setCash() {
        Cash = true;
    }

    public boolean isCash() {
        return Cash;
    }
}


