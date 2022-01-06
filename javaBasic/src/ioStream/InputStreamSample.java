package ioStream;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamSample {

    /**
     * BufferedInputStream 활용 X
     */
    @Test
    public void testFileInputStream() {
        File file = new File("C:\\Users\\hiper\\Desktop\\sample.txt");

        long start = System.nanoTime();

        // try-catch-resource 를 통해 try 코드 블록이 끝나면 close()는 자동으로 호출된다.
        try (FileInputStream iStream = new FileInputStream(file)) {
            int data;
            do {
                data = iStream.read();

            } while (data != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end = System.nanoTime();
        System.out.println("testFileInputStream");
        System.out.println(end - start);
    }

    /**
     * BufferedInputStream 활용
     */
    @Test
    public void testBufferedInputStream() {
        File file = new File("C:\\Users\\hiper\\Desktop\\sample.txt");

        long start = System.nanoTime();

        try (FileInputStream iStream = new FileInputStream(file)) {
            // 두 번째 인자로 버퍼 크기값을 받으며, 크기값을 지정하지 않으면 default 값으로 설정된다.
            BufferedInputStream biStream = new BufferedInputStream(iStream);

            int data;
            do {
                data = biStream.read();
            } while (data != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end = System.nanoTime();
        System.out.println("testBufferedInputStream");
        System.out.println(end - start);
    }
}
