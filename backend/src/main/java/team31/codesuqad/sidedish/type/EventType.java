package team31.codesuqad.sidedish.type;

public enum EventType {

    MEAT,
    SIDE,
    SEASON,
    KIDS;

    public static EventType valueOfOrNull(String eventTab) {
        try {
            return valueOf(eventTab.toUpperCase());
        } catch (NullPointerException e) {
            return MEAT;
        }
    }

}
