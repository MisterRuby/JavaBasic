package defaultMethod;

public class ButtonComp {

    /**
     * setOnClickListener 를 통해 이너 인터페이스를 구현한 익명 클래스로 생성한 객체를 가리킨다
     */
    OnClickListener onClick;

    /**
     * 외부에서 해당 함수를 호출하면서 이벤트 등록
     *      - 매개변수로 들어갈 인터페이스를 외부에서 익명 클래스로 구현해서 넣어준다. (onClick 메서드 구현)
     * @param event
     */
    public void setOnClickListener(OnClickListener event) {
        this.onClick = event;
    }

    public interface OnClickListener {
        void onClick(String e);
    }

    public void click() {
        if (onClick == null) {
            System.out.println("이벤트가 등록되지 않았어요!");
            return;
        }

        /**
         * 외부에서 익명 클래스로 구현한 onCLick 메서드를 실행
         */
        onClick.onClick("event");
    }
}
