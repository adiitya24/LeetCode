class Solution {
    public int specialArray(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int a:nums){
            pq.add(a);
        }
        int n=nums.length;
        
      
        List<Integer> list=new ArrayList();
        for(int i=1;i<=n;i++){
            while(!pq.isEmpty()&&i>pq.peek()){
                list.add(pq.poll());
            }
            if(i==pq.size()) return i;
            while(!list.isEmpty()){
                pq.offer(list.remove(0));
            }
        }
        return -1;
    }
}