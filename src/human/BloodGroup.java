package human;

public enum BloodGroup {

    FIRST(1), SECOND(2), THIRD(3), FOURTH(4);

    BloodGroup(int code) {
        this.code = code;
    }

    private final int code;

    public int getCode() {
        return code;
    }

}
