package operation;

/**
 * @author luofan
 */
public class 移除元素 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while(j<nums.length){
            if(nums[j]==val){
                j++;
            }else{
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        return i;
    }

    public int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]!=val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
