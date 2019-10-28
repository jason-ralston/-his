/*
 * Created by JFormDesigner on Fri Sep 20 10:47:19 CST 2019
 */

package com.his.View;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.*;
import javax.swing.GroupLayout;
import com.his.Model.*;

/**
 * @author I_love_Mr_Liu
 */
public class GiveMedicine extends JFrame {
    private Medicine medicine=new Medicine();
    private Doctorcontrol doctorcontrol;
    public GiveMedicine(Medicine medicine ,Doctorcontrol d) {

        initComponents();
        setVisible(true);
        setMedicine(medicine);
        setTextfield();
        setDoctorcontrol(d);

    }
    private void setTextfield(){
        textField1.setText(medicine.getName());
        textField2.setText(medicine.getCode());
        textField3.setText(medicine.getType1());
        textField4.setText(medicine.getMoney());
        textField1.updateUI();
        textField2.updateUI();
        textField3.updateUI();
        textField4.updateUI();

    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    private void setDoctorcontrol(Doctorcontrol doctorcontrol) {
        this.doctorcontrol = doctorcontrol;
    }

    private void button1MouseClicked(MouseEvent e) {
        medicine.setHowUse(textField5.getText()+","+textField6.getText());
        medicine.setTime(Integer.valueOf(textField7.getText()));
        doctorcontrol.addMedicine(medicine);
        doctorcontrol.setList3();


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        textField5 = new JTextField();
        textField6 = new JTextField();
        label8 = new JLabel();
        textField7 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setTitle("\u5f00\u836f");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u836f\u54c1\u540d\u79f0");

        //---- label2 ----
        label2.setText("\u836f\u54c1\u7f16\u53f7");

        //---- label3 ----
        label3.setText("\u5242\u578b");

        //---- label5 ----
        label5.setText("\u5355\u4ef7");

        //---- label6 ----
        label6.setText("\u7528\u6cd5");

        //---- label7 ----
        label7.setText("\u9891\u6b21");

        //---- label8 ----
        label8.setText("\u6570\u91cf");

        //---- button1 ----
        button1.setText("\u52a0\u836f");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(120, 120, 120)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(label8, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                        .addComponent(label7, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                        .addComponent(label2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                        .addComponent(label1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                        .addComponent(label4, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                        .addComponent(label5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                        .addComponent(label6, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                        .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                        .addComponent(textField3, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                        .addComponent(textField4, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                        .addComponent(textField5, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                        .addComponent(textField6, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                        .addComponent(textField7, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                    .addGap(169, 169, 169))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(413, Short.MAX_VALUE)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                    .addGap(41, 41, 41))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4)
                        .addComponent(label5))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addGap(43, 43, 43))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JTextField textField5;
    private JTextField textField6;
    private JLabel label8;
    private JTextField textField7;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
