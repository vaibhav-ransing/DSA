import java.util.ArrayList;

public class IntegerToRoman {

    public String intToRoman(int num) {

        String roman = "";
        String[][] storeIntRoman = { { "1000", "M" }, { "900", "CM" }, { "500", "D" }, { "400", "CD" }, { "100", "C" },
                { "90", "XC" }, { "50", "L" }, { "40", "XL" }, { "10", "X" }, { "9", "IX" }, { "5", "V" },
                { "4", "IV" }, { "1", "I" } };

        int idx = 0;
        while (num > 0) {
            int div = Integer.parseInt(storeIntRoman[idx][0]);
            if (num / div != 0) {
                roman += storeIntRoman[idx][1];
                num -= div;
            } else {
                idx++;
            }
        }
        return roman;
    }

    public String intToRoman3(int num) {

        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romanNumerals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder sb = new StringBuilder();

        int i = 0;

        while (num > 0) {
            if (num >= values[i]) {

                sb.append(romanNumerals[i]);
                num -= values[i];
            } else {
                i++;
            }
        }

        return sb.toString();
    }

}