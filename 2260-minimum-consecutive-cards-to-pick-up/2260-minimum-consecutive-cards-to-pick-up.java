class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<cards.length;i++){
            int a=cards[i];
            if(map.containsKey(a)){
                ans=Math.min(ans,i-map.get(a)+1);
            }
            map.put(a,i);
        }
        return ans==Integer.MAX_VALUE?-1:ans;

    }
}