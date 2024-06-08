class Solution {
    public int maximumLength(int[] nums, int k) {
          int dp[][]; 
                   int ans ;
        
        dp=new int[nums.length][k + 1];
        for (int i = 0; i< nums.length; i=i+1) {
            
            Arrays.fill(dp[i], 1);
       }
        
        
 int n =nums.length;
      

        
     int ab[]= new int[k + 1];
        
                                    ans=1;
                                                                           Arrays.fill(ab, -1);
        
         List<Map<Integer, Integer>> map= new ArrayList<>();
      
      for (int j = 0; j<= k; j++) {
            map.add(new HashMap<>());
        }

        for (int i = 0; i< n; i++)
        {
               for (int j=0; j<=k;j++) {
             
    for (int l = 0; l < j; l++) {
                    dp[i][j]= Math.max(dp[i][j],1+ab[l]);
                    }
              
    if (map.get(j).containsKey(nums[i])) {
                    dp[i][j] = Math.max(dp[i][j], 1   +  map.get(j).get(nums[i]));
                 }
     
                   
                   ans = Math.max(ans, dp[i][j]);
            }
            
            for (int j = 0; j <= k; j++) {
                ab[j] = Math.max(ab[j], dp[i][j]);
                
                map.get(j).put(nums[i], Math.max(map.get(j).getOrDefault(nums[i], -1), dp[i][j]));
}
        }
        return ans;
    }
}