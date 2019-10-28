/*
 * Created by JFormDesigner on Fri Sep 20 22:10:38 CST 2019
 */

package com.his.View;

import java.awt.event.*;

import com.his.Controller;
import com.his.Model.MedicineList;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;
import com.his.Model.*;

/**
 * @author I_love_Mr_Liu
 */
public class shoufei extends JFrame {
    private MedicineList medicineList;
    private guahao guahao;

    public shoufei(MedicineList medicineList,guahao guahao) {

        initComponents();
        setMedicineList(medicineList);
        setGuahao(guahao);
        setTable1();
        setLabel2();
        setVisible(true);
    }

    public com.his.View.guahao getGuahao() {
        return guahao;
    }

    public void setGuahao(com.his.View.guahao guahao) {
        this.guahao = guahao;
    }

    public void setMedicineList(MedicineList medicineList) {
        this.medicineList = medicineList;
    }
    public void setTable1(){
        DefaultTableModel defaultTableModel=new DefaultTableModel();
        String[] strings=new String[]{"药名","缩写","单价","用法","数量"};
        defaultTableModel.setColumnIdentifiers(strings);
        for (Medicine m:medicineList.getMedicines()
             ) {
            String[] strings1=new String[]{m.getName(),m.getCode(),m.getMoney(),m.getHowUse(),String.valueOf(m.getTime())};
            defaultTableModel.addRow(strings1);
        }

        table1.setModel(defaultTableModel);
        table1.updateUI();
    }

    public MedicineList getMedicineList() {
        return medicineList;
    }

    private void button1MouseClicked(MouseEvent e) {
        JOptionPane.showConfirmDialog(null,"成功","收费成功",JOptionPane.YES_NO_OPTION);
        Case c=guahao.getPatient().getaCase();
        c.setCash();
        guahao.getPatient().AddCase(c);
        Controller.getInstance().updatePatient(guahao.getPatient());
        Controller.getInstance().Saveinformation();
        guahao.setTable1();
        guahao.clearTable2();

    }
    private void setLabel2(){
        double fee=0.0;
        for (Medicine m:medicineList.getMedicines()
        ) {
            fee+= Double.parseDouble(m.getMoney())*m.getTime();

        }

        label2.setText(String.valueOf(fee));
        label2.updateUI();
    }

    private void textField2KeyTyped(KeyEvent e) {

    }

    private void textField2KeyReleased(KeyEvent e) {
        double fee2=Double.parseDouble(label2.getText());
        double fee1=Double.parseDouble(textField2.getText());
        double fee=fee1-fee2;
        label5.setText(String.valueOf(fee));
        label5.updateUI();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        button1 = new JButton();
        textField1 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }

        //---- label1 ----
        label1.setText("\u9879\u76ee\u660e\u7ec6");

        //---- button1 ----
        button1.setText("\u7f34\u8d39");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- textField1 ----
        textField1.setText("\u5e94\u6536");

        //---- label2 ----
        label2.setText("text");

        //---- label3 ----
        label3.setText("\u5b9e\u6536");

        //---- textField2 ----
        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                textField2KeyReleased(e);
            }
            @Override
            public void keyTyped(KeyEvent e) {
                textField2KeyTyped(e);
            }
        });

        //---- label4 ----
        label4.setText("\u627e\u96f6");

        //---- label5 ----
        label5.setText("text");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
                            .addComponent(button1)
                            .addGap(37, 37, 37))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(267, Short.MAX_VALUE))))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(72, 72, 72)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 74, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2)
                        .addComponent(label4)
                        .addComponent(label5))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button1)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JButton button1;
    private JTextField textField1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField2;
    private JLabel label4;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
