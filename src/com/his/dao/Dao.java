package com.his.dao;

import java.io.*;



public class Dao {
    private static Dao ourInstance = new Dao();
    private static final String FileNotFoundException="FileNotFoundException";
    private static final String IOException="IOException";
    private static final String ClassNotFoundException="ClassNotFoundException";
    public static Dao getInstance() {
        return ourInstance;
    }
    public void SaveObject(String Filename,Generic generic){
        String s=Filename+".txt";
        try{

        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(s));
        objectOutputStream.writeObject(generic.getKey());
        objectOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }//用于存储单一对象
    public Generic LoadObject(String filename){
        String s=filename+".txt";
    try{
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(s));
        Object o= objectInputStream.readObject();
        objectInputStream.close();
        Generic<Object> generic=new Generic<>(o);
        return generic;


    }catch (FileNotFoundException e){
        System.out.println(FileNotFoundException);
        return null;
    }catch (IOException e){
        System.out.println(IOException);
        return null;
    }catch (ClassNotFoundException e) {
        System.out.println(ClassNotFoundException);
        return null;
    }
    }
}
