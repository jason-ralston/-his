package com.his.Model;

import java.io.Serializable;

public class Medicine implements Serializable {
    private static final long serialVersionUID = 4735132092273200831L;
    private String Code;
    private String Name;
    private String Standard;//药品规格
    private String Unit;//包装单位
    private String Company;//生产厂家
    private String Type1;//剂型
    private String Type2;//药品类型
    private String Money;//药品单价
    private int Time;//药品数量
    private String HowUse;//药品的用法频次，与数量仅在为患者开具药方时使用
    private String Given="未发药";


    public Medicine(String code, String name, String standard, String unit, String company, String type1, String type2, String money) {
        Code = code;
        Name = name;
        Standard = standard;
        Unit = unit;
        Company = company;
        Type1 = type1;
        Type2 = type2;
        this.Money = money;
    }
    public Medicine(){}

    public String getCode() {
        return Code;
    }

    public void setTime(int time) {
        Time = time;
    }

    public void setHowUse(String howUse) {
        HowUse = howUse;
    }

    public String getMoney() {
        return Money;
    }

    public int getTime() {
        return Time;
    }

    public String getName() {
        return Name;
    }

    public String[] ToString(){
        String[] strings=new String[]{Code,Name,Standard,Unit,Company,Type1,Type2,Money};
        return strings;
        }

    public String getType1() {
        return Type1;
    }

    public String getHowUse() {
        return HowUse;
    }

    public void setGiven(String given) {
        Given = given;
    }

    public String getGiven() {
        return Given;
    }
}


