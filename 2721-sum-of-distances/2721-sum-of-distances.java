import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ansarr = new long[n];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // Step 1: Group indices by number
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Step 2: For each group of indices, compute distances using prefix sum
        for (ArrayList<Integer> positions : map.values()) {
            int size = positions.size();
            long[] prefix = new long[size];
            prefix[0] = positions.get(0);

            for (int i = 1; i < size; i++) {
                prefix[i] = prefix[i - 1] + positions.get(i);
            }

            for (int i = 0; i < size; i++) {
                int idx = positions.get(i);
                long left = (long) i * positions.get(i) - (i > 0 ? prefix[i - 1] : 0);
                long right = (prefix[size - 1] - prefix[i]) - (long) (size - 1 - i) * positions.get(i);
                ansarr[idx] = left + right;
            }
        }

        return ansarr;
    }
}
