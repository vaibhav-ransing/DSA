public class ChampangeTower {

    public double champagneTower(int poured, int query_row, int query_glass) {
        return helper(poured, 0, 0, query_row, query_glass, new Double[query_row + 1][query_row + 1]);
    }

    public double helper(double curr_water, int cr, int cc, int qr, int qc, Double[][] memo) {
        if (curr_water <= 0) {
            return 0;
        }

        if (cr > qr || cc > cr) {
            return 0;
        }

        if (memo[cr][cc] != null) {
            return memo[cr][cc];
        }

        if (cr == qr && cc == qc) {
            return Math.min(1.0, curr_water);
        }

        double overflow = Math.max(0, (curr_water - 1) / 2.0);

        double left = helper(overflow, cr + 1, cc, qr, qc, memo);
        double right = helper(overflow, cr + 1, cc + 1, qr, qc, memo);

        memo[cr][cc] = left + right;
        return memo[cr][cc];
    }

    // public double champagneTower(int poured, int query_row, int query_glass) {
    // if (query_row == 0) {
    // return Math.min(1.0, poured);
    // }
    // return helepr(poured, 1, query_row, query_glass);
    // }

    // public double helepr(double curr_water, int cr, int qr, int qc) {
    // if (curr_water <= 0)
    // return 0;

    // if (cr - 1 == qr) {
    // // left most and right most will only get water from 1 of the streams from
    // pervious row
    // if ((qc == 0 || qc == qr) && cr % 2 == 1) {
    // return (1 / 2 * (cr - 1)) * curr_water;
    // } else {
    // return (1 / (cr - 1)) * curr_water;

    // }
    // }
    // double nextRowWater = (curr_water - 1) / 2.0;
    // return helepr(nextRowWater, cr + 1, qr, qc);
    // }
}
