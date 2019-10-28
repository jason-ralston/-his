/*
 * Created by JFormDesigner on Wed Sep 18 18:56:42 CST 2019
 */

package com.his.View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.his.Controller;
import com.his.Model.*;

/**
 * @author I_love_Mr_Liu
 */

public class Diagnosis extends JFrame {
    private Doctorcontrol doctorcontrol;
    public Diagnosis(Doctorcontrol doctorcontrol) {

        initComponents();
        setVisible(true);
        settable1();
        setDoctorcontrol(doctorcontrol);

    }
    private  Disease disease;

    public void setDoctorcontrol(Doctorcontrol doctorcontrol) {
        this.doctorcontrol = doctorcontrol;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    private void  settable1(){
        DefaultTableModel tableModel= new DefaultTableModel();
        String[] strings1=new String[]{"icd编号","名称"};
        tableModel.setColumnIdentifiers(strings1);
        for (Disease disease: Controller.getInstance().getDiseases()
             ) {
            String[] strings=disease.ToString();
            tableModel.addRow(strings);
        }

        table1.setModel((TableModel) tableModel);
        table1.updateUI();

    }

    private void button1MouseClicked(MouseEvent e) {
        int indexr=table1.getSelectedRow();
        String code=(String) table1.getValueAt(indexr,0);
        doctorcontrol.AddDiease(Controller.getInstance().SearchDisease(code));
        doctorcontrol.SetTable1();



    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();

        //======== this ========
        setTitle("\u8bca\u65ad");
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        //---- button1 ----
        button1.setText("text");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- label2 ----
        label2.setText("\u75be\u75c5\u8be6\u60c5");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(39, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                            .addGap(22, 22, 22))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(222, 222, 222)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 230, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(label2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label1)
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(button1)
                    .addContainerGap(52, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JLabel label1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}
