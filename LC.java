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

     public String interpret(String command) {
       int l = 0, r = 0;
       String al = "(al)";
       String p = "()";
       String res = "";
       while(l < command.length()){
           if(command.charAt(l) == 'G'){
               res += "G";
           }else if(command.charAt(l) == '(' && command.charAt(l+1) == ')'){
               res += "o";
               l++;
           }else{
               res += "al";
               l+=3;
           }
           l++;
       }
        return res;
    }


    /**
     * 1945. Sum of Digits of String After Convert
     */
    public int getLucky(String s, int k) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int result = 0;
        arr = breakDown(s);

        for(int i = 0; i < k; i++){
            result = addNums(arr);
            if(k > 1 && i < k-1){
                arr = divideDigits(result);
            }
        }
        return result;
    }

    public ArrayList<Integer> breakDown(String s){
        ArrayList<Integer> res = new ArrayList<Integer>();
        String z = "";

        for(int i = 0; i < s.length(); i++){
            z += s.charAt(i) - 'a' + 1;
        }
        // int bruh = 0;
        for(int i = 0; i < z.length(); i++){
            int a = z.charAt(i) - 48;       
            res.add(a);
        }
        
        return res;
    }

    public int addNums(ArrayList<Integer> arr){
        int a = 0;
        for(int i = 0; i < arr.size(); i++){
            a += arr.get(i);
        }
        return a;
    }

    public ArrayList<Integer> divideDigits(int a){
        String b = Integer.toString(a);
        ArrayList<Integer> res = new ArrayList<Integer>();

        for(int i = 0; i < b.length(); i++){
            res.add(b.charAt(i) - 48);
        }

        return res;
    }
    /**
     * 1945. Sum of Digits of String After Convert
     */


    /**11. Container with most water */
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
    /**11. Container with most water */
    
}
