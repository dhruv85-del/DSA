class Solution {
    public boolean stoneGameIX(int[] stones) {

        int[] cnt = new int[3];

        for (int stone : stones) {
            cnt[stone % 3]++;
        }

        int zero = cnt[0];
        int one = cnt[1];
        int two = cnt[2];

        // Remove all 0-mod-3 stones.
        // They only change whose turn it is.
        if (one == 0 && two == 0) {
            return false;
        }

        if (zero % 2 == 0) {
            return one > 0 && two > 0;
        }

        return Math.abs(one - two) > 2;
    }
}