package com.his.Model;

import com.his.Model.Case;
import com.his.Model.Disease;

import java.io.Serializable;
import java.util.ArrayList;

public class Doctor implements Serializable {
    private String Name;
    private String Id;
    private String Password;
    private String OfficeCode;
    private String Level;//医生等级
    private String Ontime="0";//医生是否在岗
    private String Code2;//医生编号
    private Patient patient;//当前负责患者
    private static final long serialVersionUID = 6735132092273200831L;
    private ArrayList<Patient> patientArrayList=new ArrayList<>();//患者列表
    private ArrayList<Case> caseArrayList=new ArrayList<>();//医生病历模板
    private ArrayList<Medicine> medicines=new ArrayList<>();//医生常用药
    private ArrayList<MedicineList> medicineLists=new ArrayList<>();//医生用药组套
    public Doctor (String s1,String s2,String s3, String s5,String s6,String s7){
        Name=s1;
        Id=s2;
        Password=s3;
        this.OfficeCode=s5;
        this.Level=s6;
        this.Code2=s7;

    }
    public Doctor(){}
    public Patient SearchPatientCode(String code){
        Patient patient =new Patient();
        for (Patient p:patientArrayList
             ) {
            if (p.getCode().equals(code)){
                patient=p;
            }
        }
        return patient;
    }
    public Patient SearchPatientCase(String id){
        Patient patient=new Patient();
        for (Patient p:patientArrayList
             ) {
            for (Case c1:p.getCaseArrayList()
                 ) {
                if(c1.getId().equals(id)){
                    patient=p;
                }
            }
        }
        return patient;
    }//通过病历号查找患者

    public void SaveasModel(Case c){
        caseArrayList.add(c);
    }//医生将病历存为个人模板
    public Case GetoneCase(String id){
        Case c1=new Case();
        for (Case c:caseArrayList
             ) {
            if (c.getId().equals(id)){
               c1=c;
            }
        }
        return c1;
    }//从医生模板病历列表中寻找
    public void UseModel(Case c){
        Patient patient1=patient;
        patient1.getCaseArrayList().add(c);
    }//医生将模板病历套入患者
    public ArrayList<Case> getOnePatientCaseArrayList(){
        return patient.getCaseArrayList();
    }//获取某患者的所有病历
    public void WriteCase(String feeling, String nowIll, String passIll, String allergy, String body, Disease disease){
       Case c=new Case(feeling,nowIll,passIll,allergy,body);
       c.setPatientCode(Code2);
       c.setPatientCode(patient.getCode());
       patient.getCaseArrayList().add(c);
       patient.setDisease(disease);
       patient.setDiagnosis();

    }
    //医生为患者写入病历给出诊断并提交
    public Medicine GiveMedicine(Medicine medicine , int int1, String str){
        medicine.setTime(int1);
        medicine.setHowUse(str);
        return medicine;
    }//为患者开的药写入医嘱
    public void GiveMedList(ArrayList<MedicineList> medicineLists){
       this.patient.getaCase().setMedicineLists(medicineLists);
    }//为患者开出药方


    public void SaveMedicine(Medicine medicine){
        medicines.add(medicine); }//存为常用药
    public void LoadPatient (Patient patient1){
        patient=patient1;
    }//设置当前正诊患者


    public String getCode2() {
        return Code2;
    }//获得医生编号

    public String getPassword() {
        return Password;
    }

    public String getName() {
        return Name;
    }
    public void AddPatient(Patient patient){
        patientArrayList.add(patient);
    }

    public ArrayList<Patient> getPatientArrayList() {
        return patientArrayList;
    }
    public Integer getPatientnumber(){
        return patientArrayList.size();
    }
    public void AddCase(Case c){
        caseArrayList.add(c);
    }//存为模板

    public ArrayList<Case> getCaseArrayList() {
        return caseArrayList;
    }

    public Patient getPatient() {
        return patient;
    }

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    public ArrayList<MedicineList> getMedicineLists() {
        return medicineLists;
    }

    public void setMedicines(ArrayList<Medicine> medicines) {
        this.medicines = medicines;
    }

    public void setMedicineLists(ArrayList<MedicineList> medicineLists) {
        this.medicineLists = medicineLists;
    }
    public void addMedicinelist(MedicineList medicineList){
        medicineLists.add(medicineList);
    }
    public void addMedicine(Medicine medicine){
        medicines.add(medicine);
    }
    public MedicineList searchMedicinelist(String code){
        MedicineList medicineList=new MedicineList();
        for (MedicineList m:medicineLists
             ) {
            if(code.equals(m.getCode()));
            medicineList=m;
        }
        return medicineList;
    }
    public Medicine searchMdicine(String code){
        Medicine medicine=new Medicine();
        for (Medicine m:medicines
        ) {
            if(code.equals(m.getCode()));
            medicine=m;
        }
        return medicine;
    }
    public void setPatient(Patient patient1){
        patient=patient1;
    }
}
