package Shuffle;
import java.util.Arrays;
import java.util.Random;

class Solution {
    private int [] nums;
    private int[] shuffle;

    public Solution(int[] nums) {
        this.nums=nums;
        this.shuffle=new int[nums.length];//inizializza tutti 0
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        //mischiare
        Random rand = new Random();

       int i=0;
        while(i<nums.length){
         int temp=rand.nextInt(nums.length);
         if(shuffle[temp]==0){
             shuffle[temp]=nums[i];
             i++;
         }
        }
        return shuffle;
    }


    public static void main(String[] args) {
        int [] nums= {1,2,3};
        Solution soluzione= new Solution(nums);
        System.out.println(Arrays.toString(soluzione.shuffle()));
        System.out.println(Arrays.toString(soluzione.reset()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */