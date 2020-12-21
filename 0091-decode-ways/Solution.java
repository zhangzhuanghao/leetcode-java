// 2020/12/16

public class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] memo = new int[s.length() + 1];
        memo[0] = memo[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i-1) == '0') {
                if (s.charAt(i-2) == '0' || s.charAt(i-2) > '2') {
                    return 0;
                } else {
                    memo[i] = memo[i-2];
                }
            } else {
                if (s.charAt(i-2) == '0' || s.charAt(i-2) > '2'
                        || (s.charAt(i-2) == '2' && s.charAt(i-1) > '6')) {
                    memo[i] = memo[i-1];
                } else {
                    memo[i] = memo[i-1] + memo[i-2];
                }
            }
        }
        return memo[memo.length - 1];
    }

    public static void main(String[] args) {
        var s = "-222";
        System.out.println( Integer.parseInt(s) );
    }
}
