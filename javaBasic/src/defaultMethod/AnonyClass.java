package defaultMethod;

/**
 * 인터페이스를 구현한 별도의 클래스를 파일로 만들지 않고 바로 new 생성자로 객체를 만드는 시점에 구현
 */
public class AnonyClass {

    Instrument instrument = new Instrument() {
        @Override
        public void accelerando() {
            call();
        }

        public void call() {

        }
    };

}
