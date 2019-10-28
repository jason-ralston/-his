package com.his;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import com.his.Model.*;
import com.his.View.YaoFang;
import com.his.dao.*;



public class Controller implements Serializable {
    private static final long serialVersionUID = 735132092273200001L;
    private static Controller ourInstance =new Controller();
    public static  Controller getInstance(){return ourInstance;}
    private Controller(){}

    private ArrayList<Medicine> medicines=new ArrayList<>();
    private ArrayList<Disease> diseases=new ArrayList<>();
    private ArrayList<Office>offices=new ArrayList<>();
    private ArrayList<Employ>employs=new ArrayList<>();
    private ArrayList<Patient>patients=new ArrayList<>();


    public void AddMedicine(Medicine medicine){
        medicines.add(medicine);
    }
    public void AddDisease(Disease disease){
        diseases.add(disease);

    }
    public void AddOffice(Office office){
        offices.add(office);
    }
    public void AddEmploys(Employ employ){
        employs.add(employ);
    }
    public Office SearchOffice(String code){
        Office office =new Office();
        for (Office o:offices
             ) {
            if(office.getCode().equals(code)){
                office=o;
            }
        }
        return office;
    }
    public Medicine SearchMedine(String code){
        Medicine medicine=new Medicine();
        for (Medicine medicine1:medicines
             ) {if(medicine1.getCode().equals(code)){
                 medicine=medicine1;
        }

        }
    return medicine;}
    public Disease  SearchDisease(String code){
        Disease disease=new Disease();
        for (Disease disease1:diseases
        ) {if(disease1.getID().equals(code)){
            disease=disease1;
        }

        }
        return disease;}
    public Doctor SearchDoctor(String code){
        Doctor doctor=new Doctor();
        for (Office O:offices
             ) {
          Doctor doctor1= O.getDoctor(code);
          if (doctor1!=null){
              doctor=doctor1;
              break;
        }

    }
    return doctor;}
    public Employ SearchEmploy( String code){
        Employ employ=new Employ();
        for (Employ e:employs
             ) {
            if(e.getCode1().equals(code)){
                employ=e;
            }
        }
        return employ;
    }

    public void SaveList(ArrayList objects){
    Class c=objects.get(0).getClass();
    String classname=c.getName();



    }
    public void SaveOrigionInfornation(){
        Controller controller=new Controller();
        controller.AddEmploys(new Employ("张国争","zgzzs","123456","A001"));
        controller.AddEmploys(new Employ("魏世亨","wshzs","555","A002"));
        Office office1=new Office("C001","呼吸科");
        Office office2=new Office("C002","心脑血管科");
        office1.AddDoctor(new Doctor( "魏子鸿","wzh","1234","C001","主任医师","B001"));
        office1.AddDoctor(new Doctor("刘小枫","lyf","111","C001","副主任医师","B002"));
        office2.AddDoctor(new Doctor("李晟","chipi","chipi","C002","主任医师","B003"));
        controller.AddOffice(office1);
        controller.AddOffice(office2);
        controller.AddDisease(new Disease("古典型霍乱","A00.051"));
        controller.AddDisease(new Disease("伤寒","A01.001"));
        controller.AddDisease(new Disease("阿哥拉沙门氏菌肠炎","A002.003"));
        controller.AddDisease(new Disease("沙门氏菌败血症","A002.101"));
        controller.AddDisease(new Disease("结核感染","A16.902"));
        controller.AddMedicine(new Medicine("ZSYJAZZ","注射用甲氨嘌呤","1g*1支","支","江苏恒瑞医药股份有限公司","针剂","西药","15.73"));
        controller.AddMedicine(new Medicine("HLKL","黄连颗粒","0.5g/3g袋","袋","江阴天江药业有限公司","颗粒剂","中成药","1.07"));
        controller.AddMedicine(new Medicine("WSKL","胃苏颗粒",	"5g*9袋/盒"	,"盒",	"扬子江药业集团有限公司",	"颗粒剂",	"中成药",	"1.73"));
        controller.AddMedicine(new Medicine("ZM"	,"瞿麦",	"1000克/公斤",	"kg",	"江苏",	"中药饮片",	"中草药","43.84"));
        controller.AddMedicine(new Medicine("ZSYTZTZ"	,"注射用头孢他啶(复达欣)"	,"1g×1支	","支"	,"葛兰素史克制药(苏州)有限公司"	,"针剂","西药","8.05"));
        controller.AddMedicine(new Medicine("KLTZSY","康莱特注射液","10g×100ml/瓶","瓶","浙江康莱特药业有限公司","针剂","西药","	11.36"));
        controller.AddMedicine(new Medicine("ZSYFXDSN","注射用夫西地酸钠"	,"0.125g×1支	","支","成都天台山制药有限公司"	,"针剂","西药","44.97"));
        controller.AddMedicine(new Medicine("SNJP"	,"水牛角片",	"1000克/公斤",	"Kg",	"江苏"	,"中药饮片"	,"中草药","5.68"));
        Dao dao=new Dao();
        Generic<Controller> generic=new Generic<>(controller);
        dao.SaveObject("文件",generic);

    }//数据初始化
    public void LoadInfornation (){
        Dao dao=new Dao();
        Generic<Controller> generic=dao.LoadObject("文件");
        Controller controller=generic.getKey();
        patients=controller.patients;
        medicines=controller.medicines;
        offices=controller.offices;
        diseases=controller.diseases;
        employs=controller.employs;
    }//读取文件

    public ArrayList<Disease> getDiseases() {
        return diseases;
    }

    public ArrayList<Employ> getEmploys() {
        return employs;
    }

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    public ArrayList<Office> getOffices() {
        return offices;
    }
    public Office SearchnameOffice(String name){ Office office =new Office();
        for (Office o:offices
        ) {
            if(o.getOfiiceName().equals(name)){
                office=o;
            }
        }
        return office;

    }
    public Doctor SearchnameDoctor( Office office,String name){
        Doctor doctor=new Doctor();
        for (Doctor d:office.getDoctors()
             ) {
            if(d.getName().equals(name)){
                doctor=d;
            }
        }
        return doctor;
    }
    public void Saveinformation(){
        Generic<Controller> controllerGeneric=new Generic<>(Controller.getInstance());
        Dao.getInstance().SaveObject("文件",controllerGeneric);
    }
    public void UpdateDoctor(String Id,Doctor doctor){
        Iterator<Office> iterator=offices.listIterator();
        while (iterator.hasNext()){
            Office office =iterator.next();
            Iterator<Doctor> iterator1=office.getDoctors().listIterator();
            while(iterator1.hasNext()){
                Doctor d=iterator1.next();
                if (d.getCode2().equals(Id)){
                    iterator1.remove();
                    ((ListIterator<Doctor>) iterator1).add(doctor);


                }

            }

        }

    }
    public void updatePatient(Patient patient){
        Iterator<Patient> iterator=patients.listIterator();
        while(iterator.hasNext()){
            Patient patient1=iterator.next();
            if(patient.getCode().equals(patient1.getCode())){
                iterator.remove();
                ((ListIterator<Patient>) iterator).add(patient);
            }

        }
    }


    public ArrayList<Patient> getPatients() {
        return patients;
    }
    public Patient searchPaient(String code){
        Patient patient=new Patient();
        for (Patient p:patients
             ) {
            if (code.equals(p.getCode()));
            patient=p;
        }
        return  patient;
    }
    public  void AddPatient(Patient patient){
        patients.add(patient);
    }


}
