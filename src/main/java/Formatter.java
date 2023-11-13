public class Formatter {
    public static String getRubleForm(float floatValue) {
        int value = (int) Math.floor(floatValue);
        int preLastDigit = value % 100 / 10;
        if (preLastDigit == 1) return " рублей";
        return switch (value % 10) {
            case 1 -> " рубль";
            case 2, 3, 4 -> " рубля";
            default -> " рублей";
        };
    }
}
