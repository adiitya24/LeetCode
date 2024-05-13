class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;

        int a[]=new int[n1+n2];
        int i=0,j=0,k=0;
        while(i<n1&&j<n2){
            if(nums1[i]<nums2[j]){
                a[k]=nums1[i];
                k++;
                i++;
            }
            else{
                a[k]=nums2[j];
                k++;
                j++;
            }
        }
        while(i<n1){
            a[k]=nums1[i];
            k++;
            i++;
        }
        while(j<n2){
            a[k]=nums2[j];
            k++;
            j++;
        }
        if(a.length%2!=0){
  return a[(a.length)/2];
        }
        else{
            int n=a.length;
            return (float)(a[n/2-1]+a[n/2])/2;
        }
    }
}