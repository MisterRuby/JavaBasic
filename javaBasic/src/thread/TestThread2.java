package thread;

import org.junit.Test;

public class TestThread2 {

    class CustomRunnable implements Runnable {

        String message;

        CustomRunnable (String message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.println(message);
        }
    }

    @Test
    public void methodName() {
        CustomRunnable customRunnable = new CustomRunnable("Runnable 의 run 실행!");
        Thread thread = new Thread(customRunnable);
        thread.start();
    }
}
