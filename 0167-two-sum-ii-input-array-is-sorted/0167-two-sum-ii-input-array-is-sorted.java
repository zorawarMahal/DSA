class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i=0; i < numbers.length-1; i++) {
            int index = binarySearch(numbers, target-numbers[i], i+1, numbers.length-1);

            if (index != -1 && numbers[index] == target-numbers[i]) {
                return new int[] {Math.min(index,i)+1, Math.max(index,i)+1};
            }
        }

        return new int[] {-1,-1};
    }

    private int binarySearch(int[] numbers, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end-start)/2;

            if (target == numbers[mid]) {
                return mid;
            }
            if (target < numbers[mid]) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }

        return -1;
    }
}