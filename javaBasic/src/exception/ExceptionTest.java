package exception;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExceptionTest {

    @Test
    public void testNullPointerException() {
        String str = null;

        str.length();
    }

    @Test
    public void testArithmeticException() {
        int num = 10 / 0;
    }

    class A { }

    class B extends A { }

    @Test
    public void testClassCastException2() {
        A a = new B();          // 자식 생성자로 객체를 생성한 부모 타입의 객체는 다운 캐스팅 가능
        B b = (B) a;
    }


    @Test
    public void testArrayIndexOutOfBoundsException() {
        int[] num = new int[10];

        System.out.println(num[10]);
    }

    @Test
    public void testNumberFormatException() {
        String num = "10!";

        System.out.println(Integer.parseInt(num));
    }

    /**
     * InputStream 을 상속받은 예제 클래스
     */
    class CustomISR extends InputStream {

        String callName;

        public CustomISR(String callName) {
            this.callName = callName;
        }

        @Override
        public int read() throws IOException {
            return 0;
        }

        @Override
        public void close() throws IOException {
            super.close();
            System.out.println(callName + " Close Call");
        }
    }

    /**
     * try-catch-finally
     *      finally 구간에서 close() 메서드를 호출
     */
    @Test
    public void TestTryCatchClose() {
        CustomISR customISR = null;
        try {
            customISR = new CustomISR("TestTryCatchClose");
            customISR.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (customISR != null) {
                    customISR.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * try-catch-resource
     *      try-catch 구간을 벗어나면 자동으로 close() 메서드 호출
     */
    @Test
    public void TestTryCatchResource(){
        try (CustomISR customISR = new CustomISR("TestTryCatchResource")){
            customISR.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  사용자 정의 예외 클래스
     *      - 일반 예외 : Exception 을 상속해 작성
     *      - 실행 예외 : RuntimeException 을 상속해 작성
     */
    class DivisionException extends Exception{

        DivisionException() {};

        DivisionException(String s) {
            super(s);
        }
    }

    @Test
    public void testDivisionException() {
        int n = 10;
        int m = 0;
        int result;

            try {
                if (m == 0) {
                    throw new DivisionException("분모가 0일 경우에는 나누기 연산을 할 수 없습니다.");
                }
                else {
                    result = n / m;
                }
            } catch (DivisionException e) {
                e.printStackTrace();
            }
    }


}
