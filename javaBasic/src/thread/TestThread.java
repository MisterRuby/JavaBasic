package thread;

import org.junit.Test;

public class TestThread {

    class CustomThread extends Thread {

        String message;

        CustomThread (String message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.println(currentThread());
            System.out.println(message);
        }
    }

    /**
     *  start() : 새로운 쓰레드 생성 / 추가 하기 위한 준비 + 새로운 쓰레드 위에서 run() 실행
     */
    @Test
    public void testCallStart() {
        for (int i = 0; i < 5; i++) {
            CustomThread customThread = new CustomThread("call customThread " + i);
            customThread.start();
        }
    }

    /**
     * run() : 기존 호출 스택에서 run() 호출. 새로운 쓰레드를 생성하지 않고 기존 쓰레드에서 처리된다.
     */
    @Test
    public void testCallRun() {
        for (int i = 0; i < 5; i++) {
            CustomThread customThread = new CustomThread("call customThread " + i);
            customThread.run();
        }
    }

    /**
     * start() 메서드로 한 번 실행된 Thread 객체는 재사용할 수 없다.
     */
    @Test
    public void testRecallStart() {
        CustomThread customThread = new CustomThread("call customThread");
        customThread.start();
        customThread.start();
    }
}
