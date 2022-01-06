package thread;

public class SyncKey {

    Integer num = 0;

    /**
     *  synchronized 가 붙은 메서드는 쓰레드의 Key로 메서드가 속한 객체의 key를 사용한다.
     *      - 해당 메서드가 실행되는 동안 같은 객체의 synchronized 가 붙은 다른 메서드는 비동기로 실행할 수 없다.
     */
    synchronized void add1 () {
        System.out.println("add1 호출!");
    }

    synchronized void add2 () {
        System.out.println("add2 호출!");
    }

    void addBlock1() {
        /**
         * () 안에 넣은 객체의 key가 쓰레드의 key로 사용된다. 다른 곳에서 해당 객체를 key로 사용하고 있다면 비동기로 실행할 수 없다.
         */
        synchronized (num) {
            System.out.println("addBlock1 호출!");
        }
    }

    void addBlock2() {
        synchronized (num) {
            System.out.println("addBlock2 호출!");
        }
    }

    void addBlock3() {
        /**
         * 위의 두 블록과는 key가 다르므로 두 블록과는 별개로 비동기로 실행가능.
         *      - 반대로 위의 synchronized가 붙은 메서드들과 같은 key를 사용하므로 해당 메서드들이 실행될때에는 비동기 불가능
         */
        synchronized (this) {
            System.out.println("addBlock3 호출!");
        }
    }
}
