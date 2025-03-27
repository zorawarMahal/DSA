class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(nums);
        int key1=1, key2=1, i=0, j=1;

        for (i=0; i < nums.length-1; i++) {
            int ans = search(nums, target - nums[i], i+1, nums.length-1);
            if (ans != -1) {
                key2 = nums[ans];
                key1 = nums[i];
                break;
            }
        }

        int[] sol = new int[2];

        for (int x=0; x < arr.length; x++) {
            if (arr[x] == key1) {
                sol[0] = x;
                break;
            }
        }
        for (int x=arr.length-1; x > -1; x--) {
            if (arr[x] == key2) {
                sol[1] = x;
                break;
            }
        }

        return sol;
    }

    int search(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end-start)/2;

            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }

        return -1;
    }
}