/*
 * Created by JFormDesigner on Sun Sep 15 14:57:05 CST 2019
 */

package com.his.View;

import java.awt.event.*;
import com.his.Controller;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

import com.his.Model.*;

/**
 * @author I_love_Mr_Liu
 */
public class guahao extends JFrame {
    private Office office1;
    private Case aCase=new Case();
    private String caseid;
    private Employ employ;
    private Patient patient;
    private MedicineList medicineList;

    public guahao(Employ employ) {


        initComponents();

        SetOfficebox();
        Binglinumber();
        setEmploy(employ);
        EmployName();
        setTable1();
        setVisible(true);




    }
    public void Binglinumber(){
        String id=aCase.SetId();
        textField2.setText(id);
        caseid=id;
        aCase.setId(caseid);
    }
    public void  SetOfficebox(){
        for (Office office:Controller.getInstance().getOffices()
             ) {
            comboBox3.addItem(office.getOfiiceName());

        }

    }
    public void SetDoctorbox(){
       String s=(String)comboBox3.getSelectedItem();
       Office office=Controller.getInstance().SearchnameOffice(s);
       office1=office;
        for (Doctor d:office.getDoctors()
             ) {
            comboBox4.addItem(d.getName());
        }



    }

    private void comboBox4MouseClicked(MouseEvent e) {
        SetDoctorbox();
    }

    private void comboBox4MouseDragged(MouseEvent e) {

    }

    private void button1MouseClicked(MouseEvent e) {
        try{
       Patient patient=new Patient(textField4.getText(),textField7.getText(),textField3.getText(),textField6.getText(),textField5.getText());
       employ.setPatient(patient);

       if (radioButton1.isSelected()){
         employ.SetBook();
       }
       if (comboBox2.getSelectedIndex()==0){
           employ.SetkindOfPay("普通号");
       }else if(comboBox2.getSelectedIndex()==1){
           employ.SetkindOfPay("专家号");
       }
       employ.SetPatientCase(aCase);
       employ.Register();
       employ.SetFee();
       Patient patient1=employ.getPatient();
       patient1.Setage();
       patient1.setOfficeCode(office1.getCode());
       patient1.setDoctorCode((String)comboBox4.getSelectedItem());
       patient1.setCode(patient1.setCode());
       Doctor doctor=Controller.getInstance().SearchnameDoctor(office1,(String) comboBox4.getSelectedItem());
       Controller.getInstance().AddPatient(patient1);
       doctor.AddPatient(patient1);
       Controller.getInstance().UpdateDoctor(doctor.getCode2(),doctor);
       Controller.getInstance().Saveinformation();
       setTable1();
       JOptionPane.showConfirmDialog(null,"挂号成功","成功",JOptionPane.YES_NO_OPTION);
       Binglinumber();

        }catch (Exception e1){
            JOptionPane.showConfirmDialog(null,"请检查您的日期是否按照yyyy-MM-dd格式输入，或者所有项目均填写完全","错误",JOptionPane.YES_NO_OPTION);
        }












    }
    public void clearTable2(){
        DefaultTableModel defaultTableModel=new DefaultTableModel();
        String[] strings=new String[]{"药方名","药方编号","开立时间"};
        defaultTableModel.setColumnIdentifiers(strings);
        table2.setModel(defaultTableModel);
        table2.updateUI();
    }
    public void setTable1(){
        String[] strings=new String[]{"病历号","患者编号","姓名","号别","年龄","地址","身份证","性别","是否需要病历本","是否被诊断"};
        DefaultTableModel model=new DefaultTableModel();
        model.setColumnIdentifiers(strings);
        for (Patient p:Controller.getInstance().getPatients()
             ) {
            if(!p.getaCase().isCash()&& p.isRegister()){
            String[] strings1=new String[]{p.getaCase().getId(),p.getCode(),p.getName(),p.getKindOfPay(),p.getAge(),p.getAdress(),p.getSelfNumber(),p.getSex(),String.valueOf(p.isBook()),String.valueOf(p.isDiagnosis())};
            model.addRow(strings1);}
        }
        table1.setModel(model);
        table1.updateUI();
    }

    private void radioButton1MouseClicked(MouseEvent e) {

    }


    private void button3MouseClicked(MouseEvent e) {
        int indexr=table1.getSelectedRow();
        String code=(String) table1.getValueAt(indexr,1);
        patient= Controller.getInstance().searchPaient(code);
        label2.setText(patient.getaCase().getId());
        label19.setText(patient.getName());
        label2.updateUI();
        label19.updateUI();
        setTable2();

    }
    private void setTable2(){
        DefaultTableModel defaultTableModel=new DefaultTableModel();
        String[] strings=new String[]{"药方名","药方编号","开立时间"};
        defaultTableModel.setColumnIdentifiers(strings);
        for (MedicineList m:patient.getaCase().getMedicineLists()
             ) {
            String[] strings1=new String[]{m.getCode(),m.getName(),m.getTime()};
            defaultTableModel.addRow(strings1);
        }
        table2.setModel(defaultTableModel);
        table2.updateUI();
    }//设置表格

    private void button4MouseClicked(MouseEvent e) {
        int indexr=table2.getSelectedRow();
        String code=(String) table2.getValueAt(indexr,0);
        medicineList=patient.getaCase().searchMedicinelist(code);
        shoufei shoufei=new shoufei(medicineList,guahao.this);




    }

    public Patient getPatient() {
        return patient;
    }

    private void button2MouseClicked(MouseEvent e) {
        int indexr=table1.getSelectedRow();
        String code=(String) table1.getValueAt(indexr,1);
        patient= Controller.getInstance().searchPaient(code);
        if(!patient.isDiagnosis()){ patient.setRegister(false);
            JOptionPane.showConfirmDialog(null,"退号成功","失败",JOptionPane.YES_NO_OPTION);
            Controller.getInstance().updatePatient(patient);
            Controller.getInstance().Saveinformation();
        setTable1();}else{
            JOptionPane.showConfirmDialog(null,"退号失败，该患者已诊","失败",JOptionPane.YES_NO_OPTION);
        }

    }

    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label6 = new JLabel();
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        label15 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        comboBox1 = new JComboBox<>();
        label4 = new JLabel();
        comboBox2 = new JComboBox<>();
        textField4 = new JTextField();
        label5 = new JLabel();
        label8 = new JLabel();
        textField5 = new JTextField();
        label9 = new JLabel();
        textField6 = new JTextField();
        label7 = new JLabel();
        textField3 = new JTextField();
        label10 = new JLabel();
        radioButton1 = new JRadioButton();
        label11 = new JLabel();
        comboBox3 = new JComboBox();
        label16 = new JLabel();
        label12 = new JLabel();
        comboBox4 = new JComboBox();
        label13 = new JLabel();
        comboBox5 = new JComboBox<>();
        label14 = new JLabel();
        textField7 = new JTextField();
        button1 = new JButton();
        label17 = new JLabel();
        panel2 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label18 = new JLabel();
        label19 = new JLabel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        button4 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setTitle("\u6302\u53f7");
        Container contentPane = getContentPane();

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {

                //---- label15 ----
                label15.setText("\u75c5\u5386\u53f7");

                //---- label3 ----
                label3.setText("\u7ed3\u7b97\u7c7b\u522b");

                //---- comboBox1 ----
                comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                    "\u81ea\u8d39",
                    "\u5e02\u533b\u4fdd"
                }));

                //---- label4 ----
                label4.setText("\u53f7\u522b");

                //---- comboBox2 ----
                comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
                    "\u666e\u901a\u53f7",
                    "\u4e13\u5bb6\u53f7"
                }));

                //---- label5 ----
                label5.setText("\u59d3\u540d");

                //---- label8 ----
                label8.setText("\u8eab\u4efd\u8bc1\u53f7");

                //---- label9 ----
                label9.setText("\u5730\u5740");

                //---- label7 ----
                label7.setText("\u51fa\u751f\u65e5\u671f");

                //---- label10 ----
                label10.setText("\u75c5\u5386\u672c");

                //---- radioButton1 ----
                radioButton1.setText("\u9700\u8981");
                radioButton1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        radioButton1MouseClicked(e);
                    }
                });

                //---- label11 ----
                label11.setText("\u6302\u53f7\u79d1\u5ba4");

                //---- label16 ----
                label16.setText("\u6302\u53f7\u5458");

                //---- label12 ----
                label12.setText("\u6302\u53f7\u533b\u751f");

                //---- comboBox4 ----
                comboBox4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        comboBox4MouseClicked(e);
                    }
                });
                comboBox4.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        comboBox4MouseDragged(e);
                    }
                });

                //---- label13 ----
                label13.setText("\u6536\u8d39\u65b9\u5f0f");

                //---- comboBox5 ----
                comboBox5.setModel(new DefaultComboBoxModel<>(new String[] {
                    "\u73b0\u91d1",
                    "\u5237\u5361",
                    "\u7f51\u7edc\u652f\u4ed8"
                }));

                //---- label14 ----
                label14.setText("\u6027\u522b");

                //---- button1 ----
                button1.setText("\u6302\u53f7");
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button1MouseClicked(e);
                    }
                });

                //---- label17 ----
                label17.setText("text");

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addComponent(label15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGap(11, 11, 11))
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(26, 26, 26)))
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addGroup(panel1Layout.createParallelGroup()
                                                        .addComponent(comboBox1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(panel1Layout.createParallelGroup()
                                                        .addGroup(panel1Layout.createSequentialGroup()
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(label9, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(label8, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(panel1Layout.createSequentialGroup()
                                                            .addGap(10, 10, 10)
                                                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))))
                                                .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addComponent(textField6, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(textField4, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                                    .addComponent(textField5, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(492, 492, 492)))
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(label7)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(label10, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label11))
                                            .addGap(29, 29, 29)
                                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(radioButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(comboBox3))))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(label13)
                                        .addComponent(label14)
                                        .addComponent(label12))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboBox5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField7, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(158, Short.MAX_VALUE))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label16, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label17, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 769, Short.MAX_VALUE)
                                    .addComponent(button1)
                                    .addGap(21, 21, 21))))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label15)
                                .addComponent(label5)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label12)
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label7)
                                .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label8)
                                .addComponent(comboBox5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label13)
                                .addComponent(label10)
                                .addComponent(radioButton1)
                                .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label14)
                                .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label11)
                                .addComponent(label9)
                                .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label16)
                                .addComponent(label17)
                                .addComponent(button1))
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("\u6302\u53f7", panel1);

            //======== panel2 ========
            {

                //---- label1 ----
                label1.setText("\u75c5\u5386\u53f7");

                //---- label2 ----
                label2.setText("text");

                //---- label18 ----
                label18.setText("\u59d3\u540d");

                //---- label19 ----
                label19.setText("text");

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(table2);
                }

                //---- button4 ----
                button4.setText("\u9009\u62e9");
                button4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button4MouseClicked(e);
                    }
                });

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(label18, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                .addComponent(label19, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 591, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button4)
                            .addContainerGap(155, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(0, 109, Short.MAX_VALUE)
                                    .addComponent(button4))
                                .addComponent(scrollPane2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                .addGroup(GroupLayout.Alignment.LEADING, panel2Layout.createSequentialGroup()
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addComponent(label1)
                                        .addComponent(label2))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label18)
                                        .addComponent(label19))
                                    .addGap(0, 99, Short.MAX_VALUE)))
                            .addContainerGap())
                );
            }
            tabbedPane1.addTab("\u7f34\u8d39", panel2);
        }

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        //---- button2 ----
        button2.setText("\u9000\u53f7");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });

        //---- button3 ----
        button3.setText("\u9009\u62e9");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(1043, 1043, 1043)
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 935, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button2)
                                .addComponent(button3)))
                        .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 1037, GroupLayout.PREFERRED_SIZE)))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button2)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label6)
                    .addContainerGap(27, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    public static void main(String[] args){

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label6;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JLabel label15;
    private JTextField textField2;
    private JLabel label3;
    private JComboBox<String> comboBox1;
    private JLabel label4;
    private JComboBox<String> comboBox2;
    private JTextField textField4;
    private JLabel label5;
    private JLabel label8;
    private JTextField textField5;
    private JLabel label9;
    private JTextField textField6;
    private JLabel label7;
    private JTextField textField3;
    private JLabel label10;
    private JRadioButton radioButton1;
    private JLabel label11;
    private JComboBox comboBox3;
    private JLabel label16;
    private JLabel label12;
    private JComboBox comboBox4;
    private JLabel label13;
    private JComboBox<String> comboBox5;
    private JLabel label14;
    private JTextField textField7;
    private JButton button1;
    private JLabel label17;
    private JPanel panel2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label18;
    private JLabel label19;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JButton button4;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public void setEmploy(Employ employ) {
        this.employ = employ;
    }
    public void EmployName(){
        label17.setText(employ.getName());
    }
}
