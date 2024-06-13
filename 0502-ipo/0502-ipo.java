class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        int project[][]=new int[n][2];
        for(int i=0;i<n;i++){
            project[i][0]=profits[i];
            project[i][1]=capital[i];
        }
        Arrays.sort(project,((a,b)->a[1]-b[1]));
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
      int i=0;
        while(k-->0){
            while(i<n&&w>=project[i][1]){
                pq.offer(project[i][0]);
                i++;
            }
            if(pq.isEmpty()) break;

            w+=pq.poll();
        }
        return w;
    }
}