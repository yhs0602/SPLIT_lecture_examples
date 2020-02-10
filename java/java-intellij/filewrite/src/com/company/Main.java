package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        //write abc.txt and print
        try {
            FileOutputStream out = new FileOutputStream("abcout.txt");
            OutputStreamWriter isr = new OutputStreamWriter(out);
            BufferedWriter bw = new BufferedWriter(isr);
            bw.write("Outputoutput");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
