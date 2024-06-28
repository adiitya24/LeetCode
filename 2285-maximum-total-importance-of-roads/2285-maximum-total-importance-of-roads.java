class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int inDegree[]=new int[n];
        for(int a[]:roads){
           int u=a[0];
           int v=a[1];
            inDegree[u]++;
            inDegree[v]++;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        for(int i=0;i<n;i++){
            pq.add(new int[]{i,inDegree[i]});
        }

        for(int i=0;i<n;i++){
            map.put(pq.poll()[0],i+1);
        }
        long ans=0;
        for(int road[]:roads){
            int u=road[0];
            int v=road[1];
            ans+=map.get(u);
            ans+=map.get(v);
        }
        return ans;
    }
}