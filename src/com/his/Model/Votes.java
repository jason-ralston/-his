package com.his.Model;

public class Votes {
    private String Number;//发票号
    private String PatientCode;//患者编号
    private String DoctorCode;//医生编号
    private String EmployCode;//挂号员编号
    private String WayOfPay;//结算方法
    private double fee;

    public Votes(String number, String patientCode) {
        Number = number;
        PatientCode = patientCode;
    }

    public void setDoctorCode(String doctorCode) {
        DoctorCode = doctorCode;
    }

    public void setEmployCode(String employCode) {
        EmployCode = employCode;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }

    public String getWayOfPay() {
        return WayOfPay;
    }

    public void setWayOfPay(String wayOfPay) {
        WayOfPay = wayOfPay;
    }
}
