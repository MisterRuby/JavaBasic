package thread;

import org.junit.Test;

public class ThreadProperty {

    /**
     * Thread.currentThread()
     *      - 현재 쓰레드의 참조값을 반환
     */
    @Test
    public void getCurrentThread() {
        System.out.println("현재 쓰레드의 참조값: " + Thread.currentThread());
    }

    /**
     * Thread.activeCount()
     *      - 동일한 쓰레드 그룹 내에서 실행 중인 쓰레드의 개수를 반환
     */
    @Test
    public void getActiveCount() {
        System.out.println("현재 쓰레드 그룹 내에서 실행중인 쓰레드 개수: " + Thread.activeCount());
    }

    /**
     * getName()
     *      - 쓰레드의 이름 가져오기
     * setName()
     *      - 쓰레드의 이름을 지정
     */
    @Test
    public void threadName() {
        Thread thread = new Thread();
        System.out.println("자동 지정된 쓰레드 이름 : " + thread.getName());
        thread.setName("custom Thread");
        System.out.println("직접 지정한 쓰레드 이름 : " + thread.getName());
    }

    @Test
    public void getCpuCount() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
