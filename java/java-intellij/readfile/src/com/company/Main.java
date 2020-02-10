package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        //read abc.txt and print
        try {
            FileInputStream in = new FileInputStream("abc.txt");
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            System.out.println(line);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
