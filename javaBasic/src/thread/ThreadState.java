package thread;

import org.junit.Test;

/**
 *  쓰레드의 상태
 *      - 쓰레드는 6가지의 상태를 가진다.
 *          - NEW
 *              처음 쓰레드 객체가 생성되면 NEW의 상태를 가진다.
 *          - RUNNABLE
 *              start() 메서드로 실행하면 RUNNABLE 상태가 된다.
 *              이 상태에서는 실행과 실행대기를 반복하면서 CPU를 다른 쓰레드들과 나눠 사용
 *              RUNNABLE 상태에서는 상황에 따라 TIMED_WAITING, BLOCKED, WAITING 상태로 전환될 수 있다.
 *          - TERMINATED
 *              run() 메서드가 종료되면 TERMINATED 상태가 된다.
 *          - TIMED_WAITING
 *              Thread.sleep(), join(time) 메서드가 호출될때 해당 상태가 된다.
 *              일정 시간동안 일시정지된 상태
 *              설정한 일시정지 시간이 지나거나 interrupt() 메서드가 호출되면 RUNNABLE 상태가 된다.
 *          - BLOCKED
 *              동기화 메서드 또는 동기화 블록을 실행하기 위해 먼저 실행중인 쓰레드의 실행 완료를 기다리는 상태
 *              먼저 실행중인 쓰레드와 같은 열쇠를 사용하는 동기 메서드 또는 블록일 때 발생
 *              먼저 실행중인 쓰레드의 작업이 끝나고 열쇠를 사용할 수 있게되면 RUNNABLE 상태가 된다.
 *          - WAITING
 *              시간 정보가 없는, 매개변수가 없는 join() 메서드가 호출되거나 wait() 메서드가 호출될 때 해당 상태가된다.
 *              일시 정지 시간이 정해지지 않고 대기중인 상태
 *              어떤 메서드를 이용해 WAITING 상태가 됐는지에 따라 RUNNABLE 상태로 돌아가는 방법이 다르다
 *                  join() 메서드로 호출했을 때
 *                      join() 의 대상이 된 쓰레드가 종료되거나 외부에서 interrupt() 메서드가 호출
 *                  wait() 메서드로 호출했을 때
 *                      Object 클래스의 notify() 또는 notifyAll() 메서드를 호출
 *                          notify()
 *                              WAITING 상태에 있는 하나의 쓰레드를 RUNNABLE 상태로 전환
 *                          notifyAll()
 *                              WAITING 상태에 있는 모든 쓰레드를 RUNNABLE 상태로 전환
 *                      wait(), notify(), notifyAll() 은 동기화 블록 내에서만 사용가능
 */
public class ThreadState {
    
    class TerminatedThread extends Thread {
        @Override
        public void run() {
            for (long i = 0; i < 100000000L; i++) {
                // 시간 지연을 위한 반복문
            }
        }
    }
    
    @Test
    public void testChangeThreadState() throws InterruptedException {
        TerminatedThread terminatedThread = new TerminatedThread();

        /**
         * NEW
         *  - 처음 쓰레드 객체가 생성되면 NEW의 상태를 가진다.
         */
        System.out.println(terminatedThread.getState());

        /**
         * RUNNABLE
         *  - start() 메서드로 실행하면 RUNNABLE 상태가 된다.
         *  - 이 상태에서는 실행과 실행대기를 반복하면서 CPU를 다른 쓰레드들과 나눠 사용
         *  - RUNNABLE 상태에서는 상황에 따라 TIMED_WAITING, BLOCKED, WAITING 상태로 전환될 수 있다.
         */
        terminatedThread.start();
        System.out.println(terminatedThread.getState());

        // terminatedThread 의 실행이 완료될 때까지 main 쓰레드 일시정지.
        // terminatedThread 실행이 끝날 때까지 main 쓰레드는 WAITING 상태가 된다. 이후의 코드들이 terminatedThread 실행이 끝나기 전에 실행되는 것을 막기 위함
        terminatedThread.join();

        /**
         * TERMINATED
         *  - run() 메서드가 종료되면 TERMINATED 상태가 된다.
         */
        System.out.println(terminatedThread.getState());
    }


    class WaitingThreadBySleep extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                for (long i = 0; i < 400000000L; i++) {
                    // 시간 지연을 위한 반복문
                }
            }
        }
    }

    @Test
    public void testTimeWaitingState1() throws InterruptedException {
        WaitingThreadBySleep threadBySleep = new WaitingThreadBySleep();
        threadBySleep.start();

        try {
            Thread.sleep(1000);         // waitingThread 쓰레드가 준비되는 동안 코드 진행을 중지
        } catch (InterruptedException e) {

        }

        /**
         * TIMED_WAITING
         *  - Thread.sleep() 메서드에 의해 일시정지.
         *  - 정해진 시간이 종료되거나 interrupt() 메서드를 통해 다시 RUNNABLE 상태가 된다.
         */
        System.out.println(threadBySleep.getState());

        threadBySleep.interrupt();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
        System.out.println(threadBySleep.getState());

    }

//    static class WaitingThreadByJoin extends Thread {
//        @Override
//        public void run() {
//            try {
//                Thread.join
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                for (long i = 0; i < 400000000L; i++) {
//                    // 시간 지연을 위한 반복문
//                }
//            }
//        }
//    }
//
//    @Test
//    public void testTimeWaitingState2() throws InterruptedException {
//        WaitingThread waitingThread = new WaitingThread();
//        waitingThread.start();
//
//        try {
//            Thread.sleep(1000);         // waitingThread 쓰레드가 준비되는 동안 코드 진행을 중지
//        } catch (InterruptedException e) {
//
//        }
//
//        /**
//         * TIMED_WAITING
//         *  - Thread.sleep() 메서드에 의해 일시정지.
//         *  - 정해진 시간이 종료되거나 interrupt() 메서드를 통해 다시 RUNNABLE 상태가 된다.
//         */
//        System.out.println(waitingThread.getState());
//
//        waitingThread.interrupt();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//
//        }
//        System.out.println(waitingThread.getState());
//
//    }
}
