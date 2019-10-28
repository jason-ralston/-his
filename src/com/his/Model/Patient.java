package com.his.Model;



import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Patient implements Serializable {
    private static final long serialVersionUID = 1735132092273200831L;
    private String Name;
    private String Sex;
    private String BirthDay;
    private String Adress;//地址
    private String SelfNumber;//身份证号
    private String kindOfPay;//挂号的类型
    private String OfficeCode;//挂的科室编号
    private boolean Book=false;//是否需要电子病历本
    private double Fee;//挂号看诊时的总费用
    private boolean Register=false;//是否已经挂号
    private boolean Diagnosis=false;//是否已经被诊断
    private Disease disease;
    private String DoctorName;
    private boolean Medicine=false;//是否开过药

    private String Code;//病人编号
    private String Age;

    private Case aCase;//当前病历
    private ArrayList<Case> caseArrayList=new ArrayList<>();
    //以往病历列表
    private Votes EmployVotes;//门诊发票
    private Votes DoctorVotes;//医生收费发票


    public Patient(){}

    public String getName() {
        return Name;
    }

    public ArrayList<Case> getCaseArrayList() {
        return caseArrayList;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public void setDiagnosis() {
        Diagnosis =true;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public void setSelfNumber(String selfNumber) {
        SelfNumber = selfNumber;
    }

    public void setBirthDay(String birthDay) {
        BirthDay = birthDay;
    }

    public void setName(String name) {
        Name = name;
    }



    public void setRegister() {
        Register=true;
    }

    public String getKindOfPay() {
        return kindOfPay;
    }

    public void setKindOfPay(String kindOfPay) {
        this.kindOfPay = kindOfPay;
    }
    public void SetBook(){
        Book=true;
    }

    public void setDoctorCode(String doctorName) {
        DoctorName = doctorName;
    }
    public void Setage() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(BirthDay);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(date);
        Calendar calendar1 = Calendar.getInstance();
        int year1 = calendar.get(Calendar.YEAR);
        int year2 = calendar1.get(Calendar.YEAR);
        int month1 = calendar.get(Calendar.MONTH) + 1;
        int month2 = calendar1.get(Calendar.MONTH) + 1;
        int age = year2 - year1-1;
        if (month2 > month1) {
            age += 1;
        }
        Age= String.valueOf(age);
    }//计算患者年龄

    public Patient(String name, String sex, String birthDay, String adress, String selfNumber) {
        Name = name;
        Sex = sex;
        BirthDay = birthDay;
        Adress = adress;
        SelfNumber = selfNumber;
    }

    public boolean isBook() {
        return Book;
    }

    public void setFee(double fee) {
        Fee = fee;
    }

    public String getCode() {
        return Code;
    }

    public void setEmployVotes(Votes employVotes) {
        EmployVotes = employVotes;
    }

    public void setDoctorVotes(Votes doctorVotes) {
        DoctorVotes = doctorVotes;
    }

    public double getFee() {
        return Fee;
    }



    public void setDiagnosis(boolean diagnosis) {
        Diagnosis = diagnosis;
    }

    public void setRegister(boolean register) {
        Register = register;
    }

    public Votes getEmployVotes() {
        return EmployVotes;
    }
    public void AddCase(Case c  ){
        caseArrayList.add(c);
    }

    public void setOfficeCode(String officeCode) {
        OfficeCode = officeCode;
    }

    public void setaCase(Case aCase) {
        this.aCase = aCase;
    }

    public boolean isRegister() {
        return Register;
    }

    public boolean isDiagnosis() {
        return Diagnosis;
    }
    public  String setCode(){
     Calendar calendar=Calendar.getInstance();
        int second=calendar.get(Calendar.SECOND);
        int minute=calendar.get(Calendar.MINUTE);
        return "00"+ String.valueOf(second)+String.valueOf(minute);
    }
    public void setCode(String code){
        Code=code;
    }


    public String getAge() {
        return Age;
    }

    public Case getaCase() {
        return aCase;
    }

    public String getSex() {
        return Sex;
    }
    public void SetCase( Case case1){
        aCase=case1;
    }

    public void setMedicine() {
        Medicine = true;
    }

    public boolean isMedicine() {
        return Medicine;
    }

    public String getAdress() {
        return Adress;
    }

    public String getSelfNumber() {
        return SelfNumber;
    }
}
