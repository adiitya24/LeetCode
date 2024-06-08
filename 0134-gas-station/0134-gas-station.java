class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0,totalCost=0;
        for(int i=0;i<gas.length;i++){
            totalGas+=gas[i];
            totalCost+=cost[i];
        }
        if(totalCost>totalGas) return -1;
        int ans=0,current=0;
        for(int i=0;i<gas.length;i++){
            current+=gas[i]-cost[i];
            if(current<0){
                current=0;
                ans=i+1;
            }
        }
        return ans;
    }
}