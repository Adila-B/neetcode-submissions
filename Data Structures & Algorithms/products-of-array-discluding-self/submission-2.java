class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        // Step 1: fill output[i] with the product of everything to the LEFT of i
        output[0] = 1; // nothing to the left of index 0
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        // Step 2: multiply in the product of everything to the RIGHT of i
        int rightProduct = 1; // nothing to the right of the last index yet
        for (int i = n - 1; i >= 0; i--) {
            output[i] = output[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return output;
    }
}  
