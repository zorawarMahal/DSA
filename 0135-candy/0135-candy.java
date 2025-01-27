class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1) return 1;

        // Array to store the candies assigned to each child
        int[] candies = new int[n];

        // Each child must have at least one candy
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // Left to right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Calculate the total candies required
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}
