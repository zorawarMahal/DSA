class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        validCombinations(0, target, candidates, ans, new ArrayList<>());
        return ans;
    }

    private void validCombinations(int index, int target, int[] arr, List<List<Integer>> ans, List<Integer> ds) {
        if (index == arr.length || target == 0) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[index] <= target) {   // picking an element
            ds.add(arr[index]);
            validCombinations(index, target-arr[index], arr, ans, ds);
            ds.remove(ds.size() - 1);
        }

        // not picking an element
        validCombinations(index+1, target, arr, ans, ds);
    }
}