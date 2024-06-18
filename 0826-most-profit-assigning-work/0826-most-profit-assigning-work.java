class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->-a[1]));
        for(int i=0;i<profit.length;i++){
            pq.add(new int[]{difficulty[i],profit[i]});
        }
        int ans=0;
        Arrays.sort(worker);
        for(int i=worker.length-1;i>=0;i--){
            while(!pq.isEmpty()&&worker[i]<pq.peek()[0]){
                pq.poll();
            }
            
            if(!pq.isEmpty())
            ans+=pq.peek()[1];
        }
        return ans;
    }
}