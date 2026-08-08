class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // suf[j] = minimum index in word1 from which
        // word2[j...] can be matched exactly.
        int[] suf = new int[m];

        Arrays.fill(suf, -1);

        int i = n - 1;
        int j = m - 1;

        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                suf[j] = i;
                j--;
            }

            i--;
        }

        int[] ans = new int[m];

        int p = 0;
        boolean changed = false;

        for (i = 0; i < n && p < m; i++) {

            // Exact match
            if (word1.charAt(i) == word2.charAt(p)) {

                ans[p] = i;
                p++;
            }

            // Use our one allowed change
            else if (!changed) {

                // Last character hai, toh mismatch directly allowed
                if (p == m - 1) {

                    ans[p] = i;
                    p++;
                    changed = true;
                }

                // Otherwise remaining characters exact match hone chahiye
                else if (suf[p + 1] != -1 && suf[p + 1] > i) {

                    ans[p] = i;
                    p++;
                    changed = true;
                }
            }
        }

        if (p != m) {
            return new int[0];
        }

        return ans;
    }
}