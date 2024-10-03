package ZRandom;

public class ZigzagConversion {

    public String convert(String str, int numRows) {
        if (numRows == 1)
            return str;
        StringBuilder[] arr = new StringBuilder[numRows];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new StringBuilder();
        }
        // __ , __ , __

        // PAYPALISHIRING

        // P   A   H   N
        // A P L S I I G
        // Y   I   R

        boolean goRigt = true;
        int col = 0;

        for (char ch : str.toCharArray()) {
            arr[col].append(ch);
            if (col == numRows - 1) {
                goRigt = false;
            }
            if (col == 0) {
                goRigt = true;
            }
            if (goRigt) {
                col++;
            } else {
                col--;
            }
        }
        String ans = "";
        for (StringBuilder sb : arr) {
            ans += sb;
        }
        return ans;
    }
}