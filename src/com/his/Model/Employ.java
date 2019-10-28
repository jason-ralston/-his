package com.his.Model;

import com.his.Model.Patient;
import com.his.Model.Votes;

import java.io.Serializable;

public class Employ implements Serializable {
    private String Name;
    private String Id;
    private String Password;

    private Patient patient;//当前挂号患者
    private String Code1;//挂号员编号
    private static final long serialVersionUID = 8735132092273200831L;
    public Employ(String s1,String s2,String s3,String s4){
        Name=s1;
        Id=s2;
        Password=s3;
        Code1=s4;
    }
    public Employ(){}

        public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getName() {
        return Name;
    }
    public void Register(){
        patient.setRegister();
    }//挂号
    public void SetkindOfPay(String kind){
    patient.setKindOfPay(kind);
    }//挂号级别
    public void SetBook(){
        patient.SetBook();
    }//要病历本
    public void SetPatient(String name,String Sex,String BirthDay,String Adress,String SelfNumber ){
        Patient patient1=new Patient(name,Sex,BirthDay,Adress,SelfNumber);
        patient=patient1;
    }
    public void SetFee(){
        String Kind= patient.getKindOfPay();
        double fee1=0;
        if(Kind.equals("专家号")){
            fee1=10.0;
        }else if(Kind.equals("普通号")){
            fee1=8.0;
        }
        if(patient.isBook()){
             fee1+=1.5;
        }
        patient.setFee(fee1);

    }//设置患者应收金额
    public void SetEmployVotes(String VotesCode){
        Votes votes=new Votes(VotesCode,patient.getCode());
        votes.setEmployCode(Code1);
        votes.setFee(patient.getFee());
        patient.setEmployVotes(votes);
    }//为患者开出发票
    public Votes RegisterOut(Patient patient1){
        patient1.setRegister(false);
        double fee= patient1.getEmployVotes().getFee();
        Votes votes=new Votes(Code1,patient1.getCode());
        votes.setFee(-fee);
        return votes;
    }//退号

    public String getCode1() {
        return Code1;
    }

    public String getPassword() {
        return Password;
    }
    public  void SetPatientCase(Case c){
        patient.SetCase(c);
    }
}
