public class LC{
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && map.size() > 0){
                if(Math.abs(map.get(nums[i]) - i) <= k)
                    return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && map.size() > 0){
                return true;
            }
            map.put(nums[i], 1);
        }
        return false;
    }

	public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int width = height.length-1;
        int len = 0;
        int ans = 0;
        while(left <= right){
            len = Math.min(height[left], height[right]);
            ans = Math.max(ans, len*width);
            width--;
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return ans;
    }
}
