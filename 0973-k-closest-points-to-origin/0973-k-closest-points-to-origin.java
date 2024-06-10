class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt((a)->-a[2]));
        for(int point[]:points){
            int x=point[0];
            int y=point[1];
            int d=x*x+y*y;
            pq.add(new int[]{x,y,d});
            if(pq.size()>k)
            pq.poll();
        }
        int ans[][]=new int[pq.size()][2];
        int i=0;
        while(!pq.isEmpty()){
            int[] polled=pq.poll();
            ans[i][0]=polled[0];
            ans[i][1]=polled[1];
            i++;
        }
        return ans;
    }
}