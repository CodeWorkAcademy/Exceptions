package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionExample {

    public static void main(String[] args) {
        FileInputStream fis = null;
        int k;

        try
        {
            fis = new FileInputStream("c:\\myfile.txt");

            while ( (k = fis.read()) != -1)
            {
                System.out.println((char)k);
            }
            //catch the most specific exception first
        }catch (FileNotFoundException e)
        {
            System.out.println("There is no file!");
            //an IO exception is more general... maybe the drive is corrupt
        }catch (IOException e)
        {
            System.out.println("There is an IO exception.");
            //This catches all the other exceptions that we can catch
            //So save the more general exception for last
        }catch (Exception e)
        {
            System.out.println("Something else went wrong");
        }
    }
}
