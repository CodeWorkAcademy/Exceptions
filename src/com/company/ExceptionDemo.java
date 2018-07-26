package com.company;

import java.io.*;
public class ExceptionDemo {

    public static void main(String[] args) {
        MethodA();
    }
    private static void MethodA(){
        MethodB();
    }
    private static void MethodB(){
        try{
            MethodC();
        }catch(FileNotFoundException e){
            System.out.println("File not found. You'll find it in the last place you look.");
        }catch(IOException e){
            System.out.println("IO Exception occurred. Bummer!");
        }
    }
    private static void MethodC() throws FileNotFoundException,IOException{
        FileInputStream fis = null;
        int k;
        fis = new FileInputStream("myfile.txt");
        while ( (k = fis.read()) != -1)
        {
            System.out.println((char)k);
        }
    }
}