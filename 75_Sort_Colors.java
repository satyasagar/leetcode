/*75. Sort Colors
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note: You are not suppose to use the library's sort function for this problem.
*/
class Solution {
    public void sortColors(int[] nums) {
        int i=0; 
        int p1 = 0;
        int p2 = nums.length-1;
        
        while(i <= p2){
            if(nums[i] == 0){
                swap(nums, i, p1);
                p1++;                
            }
            if(nums[i] == 2){
                swap(nums, i, p2);
                p2--;
                i--;
            }
            i++;
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}