package ioStream;

import org.junit.Test;

import java.io.*;

public class OutputStreamSample {

    @Test
    public void testFileOutputStream() {
        File inFile = new File("C:\\Users\\hiper\\Desktop\\sample.txt");
        File outFile = new File("C:\\Users\\hiper\\Desktop\\sampleCopy1.txt");

        long start = System.nanoTime();

        try (FileInputStream iStream = new FileInputStream(inFile);
             BufferedInputStream biStream = new BufferedInputStream(iStream);
             FileOutputStream oStream = new FileOutputStream(outFile);
        ) {
            int data;
            while ((data = biStream.read()) != -1){
                oStream.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end = System.nanoTime();
        System.out.println("testFileOutputStream");
        System.out.println(end - start);
    }

    @Test
    public void testBufferedOutputStream() {
        File inFile = new File("C:\\Users\\hiper\\Desktop\\sample.txt");
        File outFile = new File("C:\\Users\\hiper\\Desktop\\sampleCopy2.txt");

        long start = System.nanoTime();

        try (FileInputStream iStream = new FileInputStream(inFile);
             FileOutputStream oStream = new FileOutputStream(outFile);
             BufferedInputStream biStream = new BufferedInputStream(iStream);
             BufferedOutputStream boStream = new BufferedOutputStream(oStream);
        ) {
            int data;
            while ((data = biStream.read()) != -1){
                boStream.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end = System.nanoTime();
        System.out.println("testBufferedOutputStream");
        System.out.println(end - start);
    }

}
