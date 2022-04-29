package team31.codesuqad.sidedish.domain;

public enum Event {

    MEAT,
    SIDE,
    SEASON,
    KIDS;

    public static Event valueOfOrNull(String eventTab) {
        try {
            return valueOf(eventTab.toUpperCase());
        } catch (NullPointerException e) {
            return null;
        }
    }

}
