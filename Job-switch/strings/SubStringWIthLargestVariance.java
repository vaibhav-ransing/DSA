import java.util.Arrays;

public class SubStringWIthLargestVariance {



    public static int largestVarianceBruteForce(String str) {
        int n = str.length();
        int[][] freq_prefix = new int[n][26];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                freq_prefix[i][str.charAt(i) - 'a']++;
            } else {
                freq_prefix[i] = Arrays.copyOf(freq_prefix[i - 1], 26);
                freq_prefix[i][str.charAt(i) - 'a']++;
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {  
                int[] curr = new int[26];
                for (int k = 0; k < 26; k++) {
                    if (i == 0) {
                        curr[k] = freq_prefix[j][k];
                    } else {
                        curr[k] = freq_prefix[j][k] - freq_prefix[i - 1][k];
                    }
                }
                
                int curr_max = Arrays.stream(curr).max().orElse(0);
                int curr_min = Arrays.stream(curr).filter(x -> x != 0).min().orElse(0);

                max = Math.max(max, curr_max - curr_min);
            }
        }
        return max;
    }
    class MyCode{
        public static int largestVariance(String str) {
            int n = str.length();
            int[][] freq_prefix = new int[n][26];
    
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    freq_prefix[i][str.charAt(i) - 'a']++;
                } else {
                    freq_prefix[i] = Arrays.copyOf(freq_prefix[i - 1], 26);
                    freq_prefix[i][str.charAt(i) - 'a']++;
                }
            }
            for (int[] a : freq_prefix) {
                System.out.println(Arrays.toString(a));
            }
            System.out.println("---");
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int fpi[] = freq_prefix[i];
                    int fpj[] = freq_prefix[j];
                    int[] curr = new int[26];
                    for (int k = 0; k < 26; k++) {
                        curr[k] = fpj[k] - fpi[k];
                    }
                    System.out.println(Arrays.toString(curr));
                    int curr_max = Arrays.stream(curr).max().orElse(1);
                    int curr_min = Integer.MAX_VALUE;
                    for (int k = 0; k < 26; k++) {
                        if (curr[k] != 0) {
                            curr_min = Math.min(curr_min, curr[k]);
                        }
                    }
                    if (curr_min == Integer.MAX_VALUE)
                        continue;
                    max = Math.max(max, curr_max - curr_min);
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        String str = "abcaab";
        System.out.println(largestVarianceBruteForce(str));
    }

}
