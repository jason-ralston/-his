package com.his.Model;

import java.io.Serializable;

public class Disease  implements Serializable {
    private String Name;
    private boolean type;//false代表西医诊断，true代表中医诊断
    private String ID;//国际ICD编码
    private static final long serialVersionUID = 6735132092273200831L;



    public Disease(String name, String ID) {
        Name = name;
        this.ID = ID;
    }

    public boolean isType() {
        return type;
    }
    public Disease(){}

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setType(boolean type) {
        this.type = type;
    }
    public String[] ToString(){
        String[] strings=new String[2];
        strings[0]=ID;
        strings[1]=Name;
        return strings;
    }
}
