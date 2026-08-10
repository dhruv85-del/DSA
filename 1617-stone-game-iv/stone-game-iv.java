class Solution {
    public boolean winnerSquareGame(int n) {

        boolean[] dp = new boolean[n + 1];

        // dp[0] = false
        // If no stones are left, current player loses.

        for (int i = 1; i <= n; i++) {

            // Try removing every possible square
            for (int j = 1; j * j <= i; j++) {

                int square = j * j;

                // If after removing square stones,
                // opponent is in a losing position,
                // current player wins.
                if (!dp[i - square]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}