class Solution {
            HashMap<Integer,List<Integer>> map=new HashMap<>();
            int color[];
            int N;
    public int[] gardenNoAdj(int n, int[][] paths) {
        N=n;
     for(int i=0;i<n;i++){
        map.put(i,new ArrayList<>());
        
     }
     color=new int[n];
        for(int a[]:paths){
            int u=a[0]-1;
            int v=a[1]-1;
            map.get(u).add(v);
            map.get(v).add(u);
        }
        backtrack(0);
        return color;
       
    }
    boolean backtrack(int u){
        if(u==N) return true;
        for(int c=1;c<=4;c++){
            if(isValid(u,c)){
                color[u]=c;
                if(backtrack(u+1))
                return true;

                color[u]=0;
            }
        }
        return false;
    }
    boolean isValid(int u,int c){
        for(int v:map.get(u)){
            if(c==color[v])
            return false;
        }
        return true;
    }
}