class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
    

        subset(nums,list,new ArrayList<>(),0);
    
        return list;

        
    }
    public void subset(int[] a,List<List<Integer>> list,List<Integer> templist,int start){
       list.add(new ArrayList<>(templist));
       for(int i=start;i<a.length;i++){
           templist.add(a[i]);

           subset(a,list,templist,i+1);

           templist.remove(templist.size()-1);
       }
    } 
}