class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        // Frequency of characters in s
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Try changing target from right to left
        for (int i = n - 1; i >= 0; i--) {

            // We need to restore characters used by target[0...i-1]
            // So make a fresh frequency array for this position.
            int[] count = freq.clone();

            // Remove characters of target[0...i-1]
            boolean possible = true;

            for (int j = 0; j < i; j++) {
                int idx = target.charAt(j) - 'a';

                if (count[idx] == 0) {
                    possible = false;
                    break;
                }

                count[idx]--;
            }

            if (!possible) {
                continue;
            }

            // Find the smallest character greater than target[i]
            int current = target.charAt(i) - 'a';

            for (int c = current + 1; c < 26; c++) {

                if (count[c] > 0) {

                    StringBuilder ans = new StringBuilder();

                    // Same prefix as target
                    ans.append(target, 0, i);

                    // Put the smallest greater character
                    ans.append((char) ('a' + c));

                    count[c]--;

                    // Put remaining characters in sorted order
                    for (int x = 0; x < 26; x++) {
                        while (count[x] > 0) {
                            ans.append((char) ('a' + x));
                            count[x]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}