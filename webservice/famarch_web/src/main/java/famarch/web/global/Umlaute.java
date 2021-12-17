package famarch.web.global;

public class Umlaute {
    public static final char auml_lower = (char) 0xE4;
    public static final char auml_upper = (char) 0xC4;
    public static final char ouml_lower = (char) 0xF6;
    public static final char ouml_upper = (char) 0xD6;
    public static final char uuml_lower = (char) 0xFC;
    public static final char uuml_upper = (char) 0xDC;

    public Umlaute() {

    }

    public char getAuml_lower() {
        return Umlaute.auml_lower;
    }

    public char getAuml_upper() {
        return Umlaute.auml_upper;
    }

    public char getOuml_lower() {
        return Umlaute.ouml_lower;
    }

    public char getOuml_upper() {
        return Umlaute.ouml_upper;
    }

    public char getUuml_lower() {
        return Umlaute.uuml_lower;
    }

    public char getUuml_upper() {
        return Umlaute.uuml_upper;
    }
}
