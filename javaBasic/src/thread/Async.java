package thread;

import org.junit.Test;

/**
 * Synchronized (동기화)
 *  - 하나의 작업이 완전히 완료된 후 다른 작업을 수행하는 것을 의미
 */


/**
 * 비동기 예제 클래스
 */
public class Async {

    static class SampleData {
        int data = 0;

    }

    static class AsyncThread extends Thread {

        SampleData sampleData;

        AsyncThread (SampleData data) {
            this.sampleData = data;
        }

        @Override
        public void run() {
            System.out.println(sampleData.data);
            this.sampleData.data += 1;

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testAsyncThread() {
        SampleData sampleData = new SampleData();

        AsyncThread asyncThread1 = new AsyncThread(sampleData);
        asyncThread1.start();

        // asyncThread1 에서 this.sampleData.data += 1 이 실행되기전에 asyncThread2의 run이 비동기로 실행됨
        AsyncThread asyncThread2 = new AsyncThread(sampleData);
        asyncThread2.start();
    }
}
