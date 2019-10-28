package com.his.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Office  implements Serializable {
    private String Code;//科室编号
    private String OfiiceName;//科室名称
    private ArrayList<Doctor> doctors=new ArrayList<>();//科室医生
    private ArrayList<Case> cases=new ArrayList<>();//科室病历模板
    private static final long serialVersionUID = 3735132092273200831L;
    public Office(){};

    public Office(String code, String ofiiceName) {
        Code = code;
        OfiiceName = ofiiceName;
    }

    public String getCode() {
        return Code;
    }//获取科室编号
    public Doctor getDoctor(String  code){
        Doctor doctor=new Doctor();
        for (Doctor d:doctors
             ) {
            if (d.getCode2().equals(code)){
                doctor=d;
            }

        }
        if( doctor.getCode2()==null){
            return null;
        }else{
        return doctor;}
    }//从科室获取某一医生

    public void AddDoctor(Doctor doctor){
        doctors.add(doctor);

    }//科室增加医生

    public String getOfiiceName() {
        return OfiiceName;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }
    public void RemoveDoctor(Doctor d){
        doctors.remove(d);
    }
}
