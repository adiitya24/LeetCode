class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> list=new ArrayList<>();
        int res=0,a;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        
        }
        for(int key:map.values()){
          
          
              q.offer(key);
             
        }
        while(!q.isEmpty()){
            int time=0;
            for(int i=0;i<=n;i++){
              if(!q.isEmpty()){
                  a=q.poll();
                
                list.add(a-1);
                time++; 
              }   
            }
            for(int b:list){
              if(b>0){
              q.add(b);  
              }
            }
            res+=q.isEmpty()?time:n+1;
            list.clear();

        }
        return res;
    }
}