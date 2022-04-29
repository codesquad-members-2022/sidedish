package team31.codesuqad.sidedish.type;

public enum ImageType {

    main,
    sub;

    public static ImageType valueOfOrNull(String imageType) {
        try {
            return valueOf(imageType);
        } catch (NullPointerException e) {
            return sub;
        }
    }

}
