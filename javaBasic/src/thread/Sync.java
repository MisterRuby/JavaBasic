package thread;

import org.junit.Test;

public class Sync {

    int data = 0;

    /**
     * synchronized - 메서드 동기화
     *  - 해당 키워드가 반환타입에 붙은 메서드는 동시에 2개 이상의 쓰레드에서 실행할 수 없다.
     *      하나의 쓰레드에서 실행이 완료된 뒤에 다른 쓰레드에서 실행할 수 있게된다. 비동기로 실행 불가능
     */
    public synchronized void add() {
        System.out.println(Sync.this.data);
        Sync.this.data += 1;
    }

    /**
     * block synchronized - 블록 동기화
     *  - 메서드 전체를 동기화하지 않고 메서드 내의 필요한 부분만 한정해 적용
     *  - 필요없는 부분까지 동기화를 적용시키면 성능면에서 손해를 보기 때문에 메서드 영역 전체를 동기화 할 필요가 없다면
     *      필요한 부분만 동기화시키는 블록 동기화를 사용하는 것이 좋다.
     */
    public void addBlockSync() {
        System.out.println("동기화 할 필요가 없는 부분1");
        System.out.println("동기화 할 필요가 없는 부분2");
        System.out.println("동기화 할 필요가 없는 부분3");

        synchronized (this) {
            System.out.println(Sync.this.data);
            Sync.this.data += 1;
        }

        System.out.println("동기화 할 필요가 없는 부분4");
        System.out.println("동기화 할 필요가 없는 부분5");
        System.out.println("동기화 할 필요가 없는 부분6");
    }

    class AsyncThread extends Thread {

        final static int ADD_METHOD = 0;
        final static int ADD_BLOCK_METHOD = 1;

        int selectMethod;

        AsyncThread(int selectMethod) {
            this.selectMethod = selectMethod;
        }

        @Override
        public void run() {
            if (selectMethod == ADD_METHOD) {
                add();
            } else {
                addBlockSync();
            }
        }
    }

    @Test
    public void testSynchronizedMethod() {
        AsyncThread asyncThread1 = new AsyncThread(AsyncThread.ADD_METHOD);
        asyncThread1.start();

        AsyncThread asyncThread2 = new AsyncThread(AsyncThread.ADD_METHOD);
        asyncThread2.start();
    }

    @Test
    public void testSynchronizedBlock() {
        AsyncThread asyncThread1 = new AsyncThread(AsyncThread.ADD_BLOCK_METHOD);
        asyncThread1.start();

        AsyncThread asyncThread2 = new AsyncThread(AsyncThread.ADD_BLOCK_METHOD);
        asyncThread2.start();
    }
}

/**
 * m - 5
 * o - 2
 * y - 1
 * a - 3
 *
 *
 */
