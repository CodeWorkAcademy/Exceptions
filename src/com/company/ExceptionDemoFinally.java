package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionDemoFinally {
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
        try{
            int k;
            fis = new FileInputStream("myfile.txt");
            while ( (k = fis.read()) != -1)
            {
                System.out.println((char)k);
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found. You'll find it in the last place you look.");
        }catch(IOException e){
            System.out.println("IO Exception occurred. Bummer!");
        }finally{
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println("We *still* have an IO error!");
            }
        }
    }
}
