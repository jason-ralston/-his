package com.his.View;

import com.his.Controller;
import com.his.Model.Doctor;
import com.his.Model.Employ;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/*
 * Created by JFormDesigner on Thu Jul 25 15:07:48 CST 2019
 */



/**
 * @author I_love_Mr_Liu
 */
public class login extends JFrame {

    private String Password;
    public login() {


        initComponents();
        setVisible(true);

    }

    private void button2MouseClicked(MouseEvent e) {
        Integer index=Getcombobox();
        String ID= GetName();
        try{
        if(index==0){
            Employ employ= Controller.getInstance().SearchEmploy(ID);
            SetPassword(employ.getPassword());
            if (Password.equals(GetPassword())){
               new guahao(employ);

                //进入下一个界面
            }else{
                JOptionPane.showConfirmDialog(null,"用户名或密码错误","错误",JOptionPane.YES_NO_OPTION);
            }
        }else if(index==1){
            Doctor doctor=Controller.getInstance().SearchDoctor(ID);
            SetPassword(doctor.getPassword());
            if (Password.equals(GetPassword())){
                Doctorcontrol doctorcontrol=new Doctorcontrol(doctor);


                //进入下一个界面
            }else{
                JOptionPane.showConfirmDialog(null,"用户名或密码错误","错误",JOptionPane.YES_NO_OPTION);
            }
        }}catch (Exception e1){
            JOptionPane.showConfirmDialog(null,"用户名或密码错误","错误",JOptionPane.YES_NO_OPTION);
        }



        // TODO add your code here
    }
    public void SetPassword(String s1){
        Password=s1;
    }
    public String GetName(){
        return textField1.getText();

    }
    public Integer Getcombobox(){
        return comboBox1.getSelectedIndex();
    }


    private void button1MouseClicked(MouseEvent e) {
        System.out.close();
    }

    private void textField1KeyTyped(KeyEvent e) {
        // TODO add your code here
    }
    public String GetPassword(){
        return String.valueOf(passwordField1.getPassword());
    }



    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Welcome = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        comboBox1 = new JComboBox<>();
        textField1 = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        passwordField1 = new JPasswordField();
        label3 = new JLabel();

        //======== this ========
        setTitle("\u767b\u9646");
        Container contentPane = getContentPane();

        //---- Welcome ----
        Welcome.setText("\u6b22\u8fce\u8fdb\u5165\u4e1c\u8f6fHIS\u4e91\u533b\u9662\u7ba1\u7406\u7cfb\u7edf");
        Welcome.setHorizontalAlignment(SwingConstants.CENTER);
        Welcome.setFont(Welcome.getFont().deriveFont(Welcome.getFont().getSize() + 10f));

        //---- button1 ----
        button1.setText("\u9000\u51fa");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- button2 ----
        button2.setText("\u767b\u9646");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u6302\u53f7\u5458",
            "\u533b\u751f",
            "\u836f\u623f"
        }));

        //---- textField1 ----
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                textField1KeyTyped(e);
            }
        });

        //---- label1 ----
        label1.setText("\u5de5\u53f7");
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label2 ----
        label2.setText("\u5bc6\u7801");
        label2.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label3 ----
        label3.setText("\u8eab\u4efd");
        label3.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button2, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                        .addComponent(passwordField1, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                        .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                        .addComponent(comboBox1, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
                    .addGap(121, 121, 121))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addComponent(Welcome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(Welcome, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(38, 38, 38)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addGap(32, 32, 32))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel Welcome;
    private JButton button1;
    private JButton button2;
    private JComboBox<String> comboBox1;
    private JTextField textField1;
    private JLabel label1;
    private JLabel label2;
    private JPasswordField passwordField1;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args){
        try {

            JFrame.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");

            new login();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        Controller.getInstance().SaveOrigionInfornation();
        Controller.getInstance().LoadInfornation();


    }




    }



