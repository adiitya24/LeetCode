class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int inDegree[]=new int[n];
        TreeMap<Integer,List<Integer>> map=new TreeMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }

        for(int a[]:edges){
            int u=a[0];
            int v=a[1];
            map.get(u).add(v);
            inDegree[v]++;

        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
                if(inDegree[i]==0)
                q.add(i);
        }
        List<Set<Integer>> ancestors=new ArrayList<>();
        for(int i=0;i<n;i++){
            ancestors.add(new HashSet<>());
        }

        while(!q.isEmpty()){
            int u=q.poll();
            for(int v:map.get(u)){
                inDegree[v]--;
                ancestors.get(v).add(u);
                for(int ancestor:ancestors.get(u)){
                    ancestors.get(v).add(ancestor);
                }
                if(inDegree[v]==0)
                q.add(v);
            }

        }
        List<List<Integer>> ans=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            List<Integer> list=new ArrayList<>(ancestors.get(i));
            Collections.sort(list);
            ans.add(list);
        }
        return ans;
            }
}