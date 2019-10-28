/*
 * Created by JFormDesigner on Sun Sep 15 20:20:54 CST 2019
 */

package com.his.View;

import java.awt.event.*;


import com.his.Controller;
import com.his.Model.Doctor;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;


import com.his.Model.*;

/**
 * @author I_love_Mr_Liu
 */
public class Doctorcontrol extends JFrame {
    private Doctor doctor;
    private Patient patient;
    private Case aCase=new Case();
    private ArrayList<Disease> diseases=new ArrayList<>();
    private ArrayList<MedicineList> medicineLists=new ArrayList<>();
    private MedicineList medicineList=new MedicineList();
    public Doctorcontrol(Doctor doctor1) {


        initComponents();
        setVisible(true);
        SetDocter(doctor1);
        SetJlist();
        SetTable4();
        Settable3();
        settable6();
        settable7();
        setList1();
        label34.setText(doctor1.getName());
        label32.setText(doctor1.getName());



    }

    private void button1MouseClicked(MouseEvent e) {
        try{
        aCase.setAllergy(textField7.getText());
        aCase.setBody(textField8.getText());
        aCase.setFeeling(textField3.getText());
        aCase.setNowIll(textField4.getText());
        aCase.setPassIll(textField5.getText());
        aCase.setPerson(textField6.getText());
        aCase.setDoctorCode(doctor.getCode2());
        aCase.setPatientCode(patient.getCode());
        aCase.setWestDisease(diseases);



        }catch (NullPointerException E){
            JOptionPane.showConfirmDialog(null,"请填写完全信息","错误",JOptionPane.YES_NO_OPTION);
        }
        aCase.setId(patient.getaCase().getId());
        patient.SetCase(aCase);
        patient.setDiagnosis();
        Controller.getInstance().updatePatient(patient);
        Controller.getInstance().UpdateDoctor(doctor.getCode2(),doctor);
        Controller.getInstance().Saveinformation();
        ClearjList();
        SetJlist();
        JOptionPane.showConfirmDialog(null,"诊断成功","成功",JOptionPane.YES_NO_OPTION);
        setList1();
        cleartable1();




    }


    private void list4MouseClicked(MouseEvent e) {






    }

    private void button5MouseClicked(MouseEvent e) {
        String strings =(String) list4.getSelectedValue();
        String[] PatientCode=strings.split("  ");
        patient= doctor.SearchPatientCode(PatientCode[0]);
        doctor.setPatient(patient);
        label1.setText(patient.getaCase().getId());
        label4.setText(patient.getName());
        label5.setText(patient.getSex());
        label6.setText(patient.getAge());
        label1.updateUI();
        label5.updateUI();
        label6.updateUI();
        label4.updateUI();
    }

    private void button8MouseClicked(MouseEvent e) {
       Diagnosis diagnosis=new Diagnosis(Doctorcontrol.this);

       }
        public void AddDiease(Disease disease){
        diseases.add(disease);
        }
        public void SetTable1(){
        DefaultTableModel tableModel= new DefaultTableModel();
        String[] strings1=new String[]{"icd编号","名称"};
        tableModel.setColumnIdentifiers(strings1);
        for (Disease disease: diseases
        ) {
            String[] strings=disease.ToString();
            tableModel.addRow(strings);
        }

        table1.setModel( tableModel);
        table1.updateUI();
    }
    public void SetTable4(){
        DefaultTableModel tableModel= new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"缩写","药品名称","药品规格","包装单位","生产厂家","剂型","药品类型","药品单价"});
        for (Medicine medicine:Controller.getInstance().getMedicines()
             ) {
            String[] strings=medicine.ToString();
            tableModel.addRow(strings);
        }
        table4.setModel(tableModel);
        table4.updateUI();
    }
    public void settable6(){
     DefaultTableModel model=new DefaultTableModel();
     String[] strings= new String[]{"模板处方组套名称","模板处方组套编码","模板中药品明细"};
     model.setColumnIdentifiers(strings);
     String s="";
     if(doctor.getMedicineLists()!=null){
         for (MedicineList m:doctor.getMedicineLists()
         ) {
             for (Medicine m1:m.getMedicines()
                  ) {
                 s=s+" "+m1.getName();
             }
             String[] strings1=new String[]{m.getCode(),m.getName(),s};
             model.addRow(strings1);
         }
     }

        table6.setModel(model);
        table6.updateUI();
    }//显示处方组套
    public void settable7(){
        DefaultTableModel model=new DefaultTableModel();
        String[] strings= new String[]{"缩写","药品名称","药品规格","包装单位","生产厂家","剂型","药品类型","药品单价"};
        model.setColumnIdentifiers(strings);
        for (Medicine medicine:doctor.getMedicines()
        ) {
            String[] strings1=medicine.ToString();
            model.addRow(strings1);
        }
        table7.setModel(model);
        table7.updateUI();
    }//显示常用药
    private  void setList5(){

    }













    public ArrayList<Disease> getDiseases() {
        return diseases;
    }

    private void button3MouseClicked(MouseEvent e) {
        try{
            aCase.setAllergy(textField7.getText());
            aCase.setBody(textField8.getText());
            aCase.setFeeling(textField3.getText());
            aCase.setNowIll(textField4.getText());
            aCase.setPassIll(textField5.getText());
            aCase.setPerson(textField6.getText());
            aCase.setDoctorCode(doctor.getCode2());
            aCase.setPatientCode(patient.getCode());
            aCase.setWestDisease(diseases);
            aCase.setId(patient.getaCase().getId());






        }catch (NullPointerException e1){
            JOptionPane.showConfirmDialog(null,"请填写完整信息","错误",JOptionPane.YES_NO_OPTION);
        }
        doctor.AddCase(aCase);
        Controller.getInstance().UpdateDoctor(doctor.getCode2(),doctor);
        Controller.getInstance().Saveinformation();
        Settable3();

    }//存为病历模板

    private void Settable3(){
        DefaultTableModel model=new DefaultTableModel();
        String[] strings1=new String[]{"病历号","主诉","诊断"};
        model.setColumnIdentifiers(strings1);
        for (Case c:doctor.getCaseArrayList()
             ) {
            model.addRow(c.ToString());
        }
        table3.setModel(model);
        table3.updateUI();

    }//加载医生模板

    private void button11MouseClicked(MouseEvent e) {
        int indexr=table3.getSelectedRow();
        String code=(String) table3.getValueAt(indexr,0);
        Case c= doctor.GetoneCase(code);
        aCase=c;
        textField3.setText(c.getFeeling());
        textField4.setText(c.getNowIll());
        textField5.setText(c.getPassIll());
        textField6.setText(c.getPerson());
        textField7.setText(c.getAllergy());
        textField8.setText(c.getBody());
        diseases=c.getWestDisease();
        SetTable1();
        table1.updateUI();
        textField3.updateUI();
        textField4.updateUI(); textField5.updateUI(); textField6.updateUI(); textField7.updateUI(); textField8.updateUI();


    }//使用病历模板

    private void button16MouseClicked(MouseEvent e) {
        String strings =(String) list1.getSelectedValue();
        String[] PatientCode=strings.split("  ");
        patient= doctor.SearchPatientCode(PatientCode[0]);
        doctor.setPatient(patient);
        label36.setText(patient.getName());
        label38.setText(patient.getSex());
        label40.setText(patient.getAge());
        label36.updateUI();
        label38.updateUI();
        label40.updateUI();


    }

    private void button12MouseClicked(MouseEvent e) {
        int indexr=table4.getSelectedRow();
        String code=(String) table4.getValueAt(indexr,0);
        Medicine medicine=Controller.getInstance().SearchMedine(code);
        GiveMedicine giveMedicine=new GiveMedicine(medicine,Doctorcontrol.this);




    }
    public void addMedicine(    Medicine medicine){
        medicineList.AddMedicine(medicine);
    }
    public void setList3(){
        Vector<String> vector=new Vector<>();
        for (Medicine m:medicineList.getMedicines()
        ) {
            vector.add(m.getCode()+" "+m.getName()+" "+"数量："+m.getTime());
        }
        list3.setListData(vector);
        list3.updateUI();
    }

    private void button17MouseClicked(MouseEvent e) {
        System.out.println(patient.getName());
        String s=JOptionPane.showInputDialog("请输入处方名称：");
        if(s==null){
            s="新建处方";
            medicineList.setTime();
            medicineList.setCode(s);
            medicineList.setName();
        }else{
            medicineList.setTime();
            medicineList.setCode(s);
            medicineList.setName();
        }

        medicineLists.add(medicineList);
        setTable5();
        Vector<String> vector=new Vector<>();
        list3.setListData(vector);
        list3.updateUI();
        JOptionPane.showConfirmDialog(null,"增方成功","成功",JOptionPane.YES_NO_OPTION);
    }//增方

    private void button18MouseClicked(MouseEvent e) {
        doctor.getPatient().setMedicine();
        doctor.GiveMedList(medicineLists);
        SetJlist();
        setList1();

        Controller.getInstance().UpdateDoctor(doctor.getCode2(),doctor);
        Controller.getInstance().updatePatient(doctor.getPatient());
        Controller.getInstance().Saveinformation();
        clearlist3();
        JOptionPane.showConfirmDialog(null,"开立成功","成功",JOptionPane.YES_NO_OPTION);

    }//开立
    private void setList2(){

    }
    private void setTable5(){
        DefaultTableModel model=new DefaultTableModel();
        String[]a =new String[]{"处方名称","处方编码","处方中药品明细"};
        model.setColumnIdentifiers(a);
        String s="";
        for (MedicineList m:medicineLists
             ) {
            for (Medicine m1:m.getMedicines()
                 ) {

                s=s+" "+m1.getName();
            }
            String[] strings=new String[]{m.getCode(),m.getName(),s};
            model.addRow(strings);

        }
        table5.setModel(model);
        table5.updateUI();
    }

    private void button19MouseClicked(MouseEvent e) {
        String s=JOptionPane.showInputDialog("请输入处方名称：");
        if(s==null){
            s="新建处方";

            medicineList.setCode(s);
            medicineList.setName1();
        }else{

            medicineList.setCode(s);
            medicineList.setName1();
        }
        doctor.addMedicinelist(medicineList);
        Controller.getInstance().UpdateDoctor(doctor.getCode2(),doctor);
        settable6();
        Controller.getInstance().Saveinformation();

    }//存为处方用药组套

    private void button15MouseClicked(MouseEvent e) {
        int indexr=table4.getSelectedRow();
        String code=(String) table4.getValueAt(indexr,0);
        Medicine medicine=Controller.getInstance().SearchMedine(code);
        Controller.getInstance().UpdateDoctor(doctor.getCode2(),doctor);
        Controller.getInstance().Saveinformation();

        doctor.addMedicine(medicine);
        settable7();


    }//存为常用药

    private void button13MouseClicked(MouseEvent e) {
        int indexr=table6.getSelectedRow();
        String code=(String) table6.getValueAt(indexr,0);
        medicineLists.add(doctor.searchMedicinelist(code));
        setTable5();




    }//使用处方用药组套

    private void button14MouseClicked(MouseEvent e) {
        int indexr=table7.getSelectedRow();
        String code=(String) table7.getValueAt(indexr,0);
        Medicine medicine=doctor.searchMdicine(code);
        GiveMedicine giveMedicine=new GiveMedicine(medicine,Doctorcontrol.this);




    }//使用常用药

    private void button7MouseClicked(MouseEvent e) {
        int indexr=table1.getSelectedRow();
        String code=(String) table1.getValueAt(indexr,0);

        Iterator<Disease> diseaseIterator=diseases.listIterator();
        while(diseaseIterator.hasNext()){
            Disease disease1=diseaseIterator.next();
            if (disease1.getID().equals(code)){
                diseaseIterator.remove();
            }
        }
        SetTable1();

    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        panel6 = new JPanel();
        label9 = new JLabel();
        scrollPane4 = new JScrollPane();
        list4 = new JList();
        label10 = new JLabel();
        scrollPane5 = new JScrollPane();
        list5 = new JList();
        label11 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label12 = new JLabel();
        label13 = new JLabel();
        textField3 = new JTextField();
        label14 = new JLabel();
        textField4 = new JTextField();
        label15 = new JLabel();
        textField5 = new JTextField();
        label16 = new JLabel();
        textField6 = new JTextField();
        label17 = new JLabel();
        label18 = new JLabel();
        label19 = new JLabel();
        label20 = new JLabel();
        label21 = new JLabel();
        label22 = new JLabel();
        label23 = new JLabel();
        label24 = new JLabel();
        label25 = new JLabel();
        textField7 = new JTextField();
        label26 = new JLabel();
        textField8 = new JTextField();
        label27 = new JLabel();
        label28 = new JLabel();
        label29 = new JLabel();
        scrollPane6 = new JScrollPane();
        table1 = new JTable();
        label30 = new JLabel();
        scrollPane7 = new JScrollPane();
        table2 = new JTable();
        button4 = new JButton();
        label1 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        scrollPane1 = new JScrollPane();
        table3 = new JTable();
        label7 = new JLabel();
        button11 = new JButton();
        label31 = new JLabel();
        label32 = new JLabel();
        panel7 = new JPanel();
        scrollPane2 = new JScrollPane();
        list1 = new JList();
        label2 = new JLabel();
        button12 = new JButton();
        scrollPane8 = new JScrollPane();
        table4 = new JTable();
        label8 = new JLabel();
        button16 = new JButton();
        scrollPane9 = new JScrollPane();
        list3 = new JList();
        button17 = new JButton();
        button18 = new JButton();
        label33 = new JLabel();
        label34 = new JLabel();
        label35 = new JLabel();
        label36 = new JLabel();
        label37 = new JLabel();
        label38 = new JLabel();
        label39 = new JLabel();
        label40 = new JLabel();
        button19 = new JButton();
        tabbedPane2 = new JTabbedPane();
        panel1 = new JPanel();
        scrollPane11 = new JScrollPane();
        table6 = new JTable();
        button13 = new JButton();
        panel2 = new JPanel();
        scrollPane12 = new JScrollPane();
        table7 = new JTable();
        button14 = new JButton();
        scrollPane3 = new JScrollPane();
        table5 = new JTable();
        scrollPane10 = new JScrollPane();
        list2 = new JList();
        label3 = new JLabel();
        button15 = new JButton();
        separator1 = new JSeparator();
        button10 = new JButton();

        //======== this ========
        setTitle("\u533b\u751f");
        Container contentPane = getContentPane();

        //======== tabbedPane1 ========
        {

            //======== panel6 ========
            {

                //---- label9 ----
                label9.setText("\u672a\u8bca\u60a3\u8005");

                //======== scrollPane4 ========
                {
                    scrollPane4.setViewportView(list4);
                }

                //---- label10 ----
                label10.setText("\u5df2\u8bca\u60a3\u8005");

                //======== scrollPane5 ========
                {
                    scrollPane5.setViewportView(list5);
                }

                //---- label11 ----
                label11.setText("\u95e8\uff08\u6025\uff09\u8bca\u75c5\u5386\u4fe1\u606f");

                //---- button1 ----
                button1.setText("\u63d0\u4ea4");
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button1MouseClicked(e);
                    }
                });

                //---- button2 ----
                button2.setText("\u6253\u5370");

                //---- button3 ----
                button3.setText("\u5b58\u4e3a\u6a21\u677f");
                button3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button3MouseClicked(e);
                    }
                });

                //---- label12 ----
                label12.setText("\u75c5\u53f2\u5185\u5bb9");

                //---- label13 ----
                label13.setText("\u4e3b\u8bc9");

                //---- label14 ----
                label14.setText("\u73b0\u75c5\u53f2");

                //---- label15 ----
                label15.setText("\u65e2\u5f80\u53f2\uff1a");

                //---- label16 ----
                label16.setText("\u4e2a\u4eba\u53f2");

                //---- label17 ----
                label17.setText("\u75c5\u5386\u53f7");

                //---- label18 ----
                label18.setText("\u59d3\u540d");

                //---- label21 ----
                label21.setText("\u6027\u522b");

                //---- label23 ----
                label23.setText("\u5e74\u9f84");

                //---- label25 ----
                label25.setText("\u8fc7\u654f\u53f2");

                //---- label26 ----
                label26.setText("\u4f53\u683c\u68c0\u67e5");

                //---- label27 ----
                label27.setText("\u8bc4\u4f30/\u8bca\u65ad");

                //---- label29 ----
                label29.setText("\u897f\u533b\u8bca\u65ad");

                //======== scrollPane6 ========
                {
                    scrollPane6.setViewportView(table1);
                }

                //---- label30 ----
                label30.setText("\u4e2d\u533b\u8bca\u65ad");

                //======== scrollPane7 ========
                {
                    scrollPane7.setViewportView(table2);
                }

                //---- button4 ----
                button4.setText("\u66f4\u65b0");

                //---- label1 ----
                label1.setText("text");

                //---- label4 ----
                label4.setText("text");

                //---- label5 ----
                label5.setText("text");

                //---- label6 ----
                label6.setText("text");

                //---- button5 ----
                button5.setText("\u786e\u8ba4");
                button5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button5MouseClicked(e);
                    }
                });

                //---- button6 ----
                button6.setText("\u6dfb\u52a0");

                //---- button7 ----
                button7.setText("\u5220\u9664");
                button7.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button7MouseClicked(e);
                    }
                });

                //---- button8 ----
                button8.setText("\u6dfb\u52a0");
                button8.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button8MouseClicked(e);
                    }
                });

                //---- button9 ----
                button9.setText("\u5220\u9664");

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(table3);
                }

                //---- label7 ----
                label7.setText("\u533b\u751f\u6a21\u677f");

                //---- button11 ----
                button11.setText("\u5957\u7528");
                button11.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button11MouseClicked(e);
                    }
                });

                //---- label31 ----
                label31.setText("\u533b\u751f");

                //---- label32 ----
                label32.setText("text");

                GroupLayout panel6Layout = new GroupLayout(panel6);
                panel6.setLayout(panel6Layout);
                panel6Layout.setHorizontalGroup(
                    panel6Layout.createParallelGroup()
                        .addGroup(panel6Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel6Layout.createParallelGroup()
                                .addGroup(panel6Layout.createSequentialGroup()
                                    .addComponent(label9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button5))
                                .addComponent(scrollPane4, GroupLayout.Alignment.TRAILING)
                                .addGroup(GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                                    .addComponent(label31, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label32, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button4))
                                .addComponent(label10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(scrollPane5, GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(GroupLayout.Alignment.LEADING, panel6Layout.createSequentialGroup()
                                    .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(GroupLayout.Alignment.LEADING, panel6Layout.createSequentialGroup()
                                            .addGroup(panel6Layout.createParallelGroup()
                                                .addComponent(label29, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label30, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
                                            .addGap(1, 1, 1)
                                            .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(scrollPane6, GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                                                .addComponent(scrollPane7, GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panel6Layout.createParallelGroup()
                                                .addComponent(button7)
                                                .addComponent(button6)
                                                .addComponent(button8)
                                                .addComponent(button9)))
                                        .addGroup(GroupLayout.Alignment.LEADING, panel6Layout.createSequentialGroup()
                                            .addGroup(panel6Layout.createParallelGroup()
                                                .addComponent(label12, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label13, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 755, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label7, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(button11))
                                        .addGroup(GroupLayout.Alignment.LEADING, panel6Layout.createSequentialGroup()
                                            .addComponent(label17, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label19, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label18, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label20, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label21, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label22, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label23, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                            .addGap(1, 1, 1)
                                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label28, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label24, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(label27, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
                                    .addGap(184, 184, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.LEADING, panel6Layout.createSequentialGroup()
                                    .addComponent(label11, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                    .addGap(372, 372, 372))
                                .addGroup(panel6Layout.createSequentialGroup()
                                    .addGroup(panel6Layout.createParallelGroup()
                                        .addGroup(panel6Layout.createSequentialGroup()
                                            .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(label26, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                                .addComponent(label25, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                                            .addGap(12, 12, 12)
                                            .addComponent(textField8, GroupLayout.PREFERRED_SIZE, 755, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(textField7, GroupLayout.PREFERRED_SIZE, 755, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(GroupLayout.Alignment.LEADING, panel6Layout.createSequentialGroup()
                                                .addGroup(panel6Layout.createParallelGroup()
                                                    .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(label14, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label15, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(label16, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(textField5, GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                                                    .addComponent(textField4, GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                                                    .addComponent(textField6, GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)))))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 138, Short.MAX_VALUE))))
                );
                panel6Layout.setVerticalGroup(
                    panel6Layout.createParallelGroup()
                        .addGroup(panel6Layout.createSequentialGroup()
                            .addGroup(panel6Layout.createParallelGroup()
                                .addGroup(panel6Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel6Layout.createParallelGroup()
                                        .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label17)
                                            .addComponent(label19)
                                            .addComponent(label18)
                                            .addComponent(label20)
                                            .addComponent(label22)
                                            .addComponent(label23)
                                            .addComponent(label24)
                                            .addComponent(label28)
                                            .addComponent(label4)
                                            .addComponent(label21)
                                            .addComponent(label5)
                                            .addComponent(label1))
                                        .addComponent(label6)))
                                .addGroup(panel6Layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(button4))
                                .addGroup(panel6Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label31)
                                        .addComponent(label32))))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label9)
                                .addComponent(label11, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button5)
                                .addComponent(button1)
                                .addComponent(button2)
                                .addComponent(button3))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel6Layout.createParallelGroup()
                                .addGroup(panel6Layout.createSequentialGroup()
                                    .addComponent(label12)
                                    .addGap(5, 5, 5)
                                    .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label13)
                                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label7)
                                        .addComponent(button11))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel6Layout.createParallelGroup()
                                        .addGroup(panel6Layout.createSequentialGroup()
                                            .addGroup(panel6Layout.createParallelGroup()
                                                .addComponent(label14)
                                                .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panel6Layout.createParallelGroup()
                                                .addComponent(label15, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(panel6Layout.createSequentialGroup()
                                                    .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(label16)
                                                        .addComponent(textField6, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(panel6Layout.createParallelGroup()
                                                .addGroup(panel6Layout.createSequentialGroup()
                                                    .addGap(19, 19, 19)
                                                    .addComponent(label25))
                                                .addGroup(panel6Layout.createSequentialGroup()
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(textField7, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addGroup(panel6Layout.createSequentialGroup()
                                                    .addGap(11, 11, 11)
                                                    .addComponent(label26, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(textField8, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label27)
                                    .addGroup(panel6Layout.createParallelGroup()
                                        .addGroup(panel6Layout.createSequentialGroup()
                                            .addGap(30, 30, 30)
                                            .addComponent(label29))
                                        .addGroup(panel6Layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addComponent(scrollPane6, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel6Layout.createSequentialGroup()
                                            .addGap(23, 23, 23)
                                            .addComponent(button8)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(button7)))
                                    .addGap(5, 5, 5)
                                    .addGroup(panel6Layout.createParallelGroup()
                                        .addComponent(label30)
                                        .addGroup(panel6Layout.createSequentialGroup()
                                            .addComponent(button6)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(button9))
                                        .addComponent(scrollPane7, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                                    .addGap(18, 18, 18))
                                .addGroup(panel6Layout.createSequentialGroup()
                                    .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label10)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(scrollPane5, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(103, Short.MAX_VALUE))))
                );
            }
            tabbedPane1.addTab("\u8bca\u65ad", panel6);

            //======== panel7 ========
            {

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(list1);
                }

                //---- label2 ----
                label2.setText("\u5df2\u8bca\u672a\u5f00\u836f\u60a3\u8005");

                //---- button12 ----
                button12.setText("\u52a0\u836f");
                button12.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button12MouseClicked(e);
                    }
                });

                //======== scrollPane8 ========
                {
                    scrollPane8.setViewportView(table4);
                }

                //---- label8 ----
                label8.setText("\u9009\u62e9\u836f\u54c1");

                //---- button16 ----
                button16.setText("\u9009\u62e9");
                button16.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button16MouseClicked(e);
                    }
                });

                //======== scrollPane9 ========
                {
                    scrollPane9.setViewportView(list3);
                }

                //---- button17 ----
                button17.setText("\u589e\u65b9");
                button17.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button17MouseClicked(e);
                    }
                });

                //---- button18 ----
                button18.setText("\u5f00\u7acb");
                button18.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button18MouseClicked(e);
                    }
                });

                //---- label33 ----
                label33.setText("\u533b\u751f");

                //---- label34 ----
                label34.setText("text");

                //---- label35 ----
                label35.setText("\u59d3\u540d");

                //---- label36 ----
                label36.setText("text");

                //---- label37 ----
                label37.setText("\u6027\u522b");

                //---- label38 ----
                label38.setText("text");

                //---- label39 ----
                label39.setText("\u5e74\u9f84");

                //---- label40 ----
                label40.setText("text");

                //---- button19 ----
                button19.setText("\u5b58\u4e3a\u6a21\u677f");
                button19.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button19MouseClicked(e);
                    }
                });

                //======== tabbedPane2 ========
                {

                    //======== panel1 ========
                    {

                        //======== scrollPane11 ========
                        {
                            scrollPane11.setViewportView(table6);
                        }

                        //---- button13 ----
                        button13.setText("\u5957\u7528");
                        button13.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                button13MouseClicked(e);
                            }
                        });

                        GroupLayout panel1Layout = new GroupLayout(panel1);
                        panel1.setLayout(panel1Layout);
                        panel1Layout.setHorizontalGroup(
                            panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane11, GroupLayout.PREFERRED_SIZE, 796, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(142, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addContainerGap(860, Short.MAX_VALUE)
                                    .addComponent(button13)
                                    .addContainerGap())
                        );
                        panel1Layout.setVerticalGroup(
                            panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane11, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                    .addComponent(button13))
                        );
                    }
                    tabbedPane2.addTab("\u5904\u65b9\u6a21\u677f", panel1);

                    //======== panel2 ========
                    {

                        //======== scrollPane12 ========
                        {
                            scrollPane12.setViewportView(table7);
                        }

                        //---- button14 ----
                        button14.setText("\u6dfb\u52a0");
                        button14.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                button14MouseClicked(e);
                            }
                        });

                        GroupLayout panel2Layout = new GroupLayout(panel2);
                        panel2.setLayout(panel2Layout);
                        panel2Layout.setHorizontalGroup(
                            panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane12, GroupLayout.PREFERRED_SIZE, 796, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(142, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                    .addContainerGap(860, Short.MAX_VALUE)
                                    .addComponent(button14)
                                    .addContainerGap())
                        );
                        panel2Layout.setVerticalGroup(
                            panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrollPane12, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button14)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        );
                    }
                    tabbedPane2.addTab("\u5e38\u7528\u836f", panel2);
                }

                //======== scrollPane3 ========
                {
                    scrollPane3.setViewportView(table5);
                }

                //======== scrollPane10 ========
                {
                    scrollPane10.setViewportView(list2);
                }

                //---- label3 ----
                label3.setText("\u5df2\u5f00\u836f\u60a3\u8005");

                //---- button15 ----
                button15.setText("\u52a0\u5165\u5e38\u7528\u836f");
                button15.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button15MouseClicked(e);
                    }
                });

                GroupLayout panel7Layout = new GroupLayout(panel7);
                panel7.setLayout(panel7Layout);
                panel7Layout.setHorizontalGroup(
                    panel7Layout.createParallelGroup()
                        .addGroup(panel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel7Layout.createParallelGroup()
                                .addGroup(panel7Layout.createSequentialGroup()
                                    .addGroup(panel7Layout.createParallelGroup()
                                        .addComponent(scrollPane2)
                                        .addGroup(panel7Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(button16))
                                        .addGroup(panel7Layout.createSequentialGroup()
                                            .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(scrollPane10, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                                .addComponent(label3, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                                            .addGap(0, 8, Short.MAX_VALUE)))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel7Layout.createParallelGroup()
                                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane8, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panel7Layout.createSequentialGroup()
                                            .addComponent(scrollPane9, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                                        .addGroup(panel7Layout.createSequentialGroup()
                                            .addComponent(button17)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(button19)
                                            .addGap(156, 156, 156)
                                            .addComponent(button18)))
                                    .addGap(122, 122, 122))
                                .addGroup(panel7Layout.createSequentialGroup()
                                    .addGroup(panel7Layout.createParallelGroup()
                                        .addGroup(panel7Layout.createSequentialGroup()
                                            .addComponent(label33, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label34, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                                    .addGap(323, 323, 323)
                                    .addComponent(label35, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel7Layout.createParallelGroup()
                                        .addGroup(panel7Layout.createSequentialGroup()
                                            .addGap(179, 179, 179)
                                            .addComponent(button12)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(button15))
                                        .addGroup(panel7Layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addComponent(label36, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label37, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label38, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label39, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label40, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(59, 481, Short.MAX_VALUE))
                                .addGroup(panel7Layout.createSequentialGroup()
                                    .addComponent(tabbedPane2, GroupLayout.PREFERRED_SIZE, 944, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 500, Short.MAX_VALUE))))
                );
                panel7Layout.setVerticalGroup(
                    panel7Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel7Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label33)
                                    .addComponent(label34))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label35)
                                    .addComponent(label40)
                                    .addComponent(label39)
                                    .addComponent(label38)
                                    .addComponent(label37)
                                    .addComponent(label36)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(button17)
                                    .addComponent(button19)
                                    .addComponent(button15)
                                    .addComponent(button12)
                                    .addComponent(button18))
                                .addGroup(panel7Layout.createSequentialGroup()
                                    .addComponent(separator1, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label8)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button16))))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel7Layout.createParallelGroup()
                                .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(scrollPane9, GroupLayout.Alignment.LEADING)
                                    .addComponent(scrollPane8, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(GroupLayout.Alignment.LEADING, panel7Layout.createSequentialGroup()
                                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label3)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(scrollPane10, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
                                .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tabbedPane2, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(62, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("\u5f00\u836f", panel7);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(tabbedPane1, GroupLayout.Alignment.TRAILING)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 743, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(9, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //---- button10 ----
        button10.setText("text");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    public void SetDocter(Doctor doctor1){
        doctor=doctor1;
    }
    public void SetJlist(){

        Vector<String> vector1=new Vector<>();
        Vector<String>vector2=new Vector<>();
        Vector<String> vector3=new Vector<>();


        for (Patient p:doctor.getPatientArrayList()
             ) {
                if(p.isDiagnosis()&& !p.isMedicine()){
                    vector1.add(p.getCode()+"  "+p.getName());
                }else if(!p.isDiagnosis()){
                    vector2.add(p.getCode()+"  "+p.getName());
                }else if (p.isMedicine()){
                    vector3.add(p.getCode()+"  "+p.getName());
            }
        }




        if (!vector2.isEmpty()  )  {
            list4.setListData(vector2);
       }
        if(!vector1.isEmpty()){
            list5.setListData(vector1);

             }
        if(!vector3.isEmpty()){
            list2.setListData(vector3);
        }
        list4.updateUI();
        list5.updateUI();
        list1.updateUI();
        list2.updateUI();



    }
    private  void setList1(){
        Vector<String> vector1=new Vector<>();
        for (Patient p:doctor.getPatientArrayList()
        ) {
            if(p.isDiagnosis()&& !p.isMedicine()){
                vector1.add(p.getCode()+"  "+p.getName());

    }}
        list1.setListData(vector1);
        list1.updateUI();
    }


    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public void ClearjList( ){
        Vector<String> vector=new Vector<>();
        list4.setListData(vector);
        list5.setListData(vector);
        list4.updateUI();
        list5.updateUI();
    }
    public void cleartable1(){
        textField3.setText("");
        textField4.setText(""); textField5.setText(""); textField6.setText(""); textField7.setText(""); textField8.setText("");
        textField3.updateUI();
        textField4.updateUI(); textField5.updateUI(); textField6.updateUI(); textField7.updateUI(); textField8.updateUI();
        DefaultTableModel tableModel= new DefaultTableModel();
        String[] strings1=new String[]{"icd编号","名称"};
        tableModel.setColumnIdentifiers(strings1);
        table1.setModel(tableModel);
        table1.updateUI();

    }
    public void clearlist3(){
        Vector<String> vector=new Vector<>();
        list3.setListData(vector);
        list3.updateUI();
    }




    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel panel6;
    private JLabel label9;
    private JScrollPane scrollPane4;
    private JList list4;
    private JLabel label10;
    private JScrollPane scrollPane5;
    private JList list5;
    private JLabel label11;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label12;
    private JLabel label13;
    private JTextField textField3;
    private JLabel label14;
    private JTextField textField4;
    private JLabel label15;
    private JTextField textField5;
    private JLabel label16;
    private JTextField textField6;
    private JLabel label17;
    private JLabel label18;
    private JLabel label19;
    private JLabel label20;
    private JLabel label21;
    private JLabel label22;
    private JLabel label23;
    private JLabel label24;
    private JLabel label25;
    private JTextField textField7;
    private JLabel label26;
    private JTextField textField8;
    private JLabel label27;
    private JLabel label28;
    private JLabel label29;
    private JScrollPane scrollPane6;
    private JTable table1;
    private JLabel label30;
    private JScrollPane scrollPane7;
    private JTable table2;
    private JButton button4;
    private JLabel label1;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JScrollPane scrollPane1;
    private JTable table3;
    private JLabel label7;
    private JButton button11;
    private JLabel label31;
    private JLabel label32;
    private JPanel panel7;
    private JScrollPane scrollPane2;
    private JList list1;
    private JLabel label2;
    private JButton button12;
    private JScrollPane scrollPane8;
    private JTable table4;
    private JLabel label8;
    private JButton button16;
    private JScrollPane scrollPane9;
    private JList list3;
    private JButton button17;
    private JButton button18;
    private JLabel label33;
    private JLabel label34;
    private JLabel label35;
    private JLabel label36;
    private JLabel label37;
    private JLabel label38;
    private JLabel label39;
    private JLabel label40;
    private JButton button19;
    private JTabbedPane tabbedPane2;
    private JPanel panel1;
    private JScrollPane scrollPane11;
    private JTable table6;
    private JButton button13;
    private JPanel panel2;
    private JScrollPane scrollPane12;
    private JTable table7;
    private JButton button14;
    private JScrollPane scrollPane3;
    private JTable table5;
    private JScrollPane scrollPane10;
    private JList list2;
    private JLabel label3;
    private JButton button15;
    private JSeparator separator1;
    private JButton button10;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
