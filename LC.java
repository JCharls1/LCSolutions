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


    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> res = new ArrayList<List<String>>();
        for(int i = 0; i < strs.length; i++){
            ArrayList<String> currList = new ArrayList<String>();
            if(strs[i] == "AAA")
                continue;
            for(int j = i+1; j < strs.length; j++){
                if(strs[j] != "AAA" && isAnagram(strs[i], strs[j])){
                    currList.add(strs[j]);
                    strs[j] = "AAA";
                }
            }
            currList.add(strs[i]);
            res.add(currList);
            strs[i] = "AAA";
        }
        return res;
    }

    public boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length())
            return false;
        int[] freq = new int[26];

        for(int i = 0; i < str1.length(); i++){
            freq[str1.charAt(i) - 'a']++;
            freq[str2.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] != 0)
                return false;
        }
        return true;
    }

    // two sum II
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;
        while(l < r){
            int sum = numbers[l] + numbers[r];
            if(sum == target){
                int[] ans = new int[2];
                ans[0] = l+1;
                ans[1] = r+1;
                return ans;
            }
            if(sum > target)
                r--;
            else
                l++;
        }
        return new int[2];
    }
    // valid parentheses
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        recurse(res, 0, 0, "", n);
        return res;
    }
    
    public void recurse(List<String> res, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        
        if (left < n) {
            recurse(res, left + 1, right, s + "(", n);
        }
        
        if (right < left) {
            recurse(res, left, right + 1, s + ")", n);
        }
    }
}
