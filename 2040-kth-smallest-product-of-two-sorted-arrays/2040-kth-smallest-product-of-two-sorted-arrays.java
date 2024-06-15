class Solution {
    
     public long kthSmallestProduct(int[] nums1, int[] nums2, long k)
    {
        long si = -1000_000_0000l;
        long ei = 1000_000_0000l;
        long ans = 0;
        while(si <= ei)
        {
            long mid = si + (ei - si) / 2;
            long count = 0;
            if(countofProduct(nums1,nums2,mid) >= k)
            {
                ans = mid;
                ei = mid - 1;
            }
            else
            {
                si = mid + 1;
            }


        }

        return ans;


    }

    private static long countofProduct(int[] nums1, int[] nums2, long prod)
    {
        long res = 0;
        for(int e1 : nums1)
        {
            if(e1 >= 0)
            {
                int count = 0;
                int low = 0;
                int high = nums2.length - 1;
                while (low <= high)
                {
                    int mid = low + (high - low) / 2;
                    if((long) e1 * nums2[mid] <= prod)
                    {
                        count = mid + 1;
                        low = mid + 1;
                    }
                    else {
                        high = mid - 1;
                    }
                }
                res += count;

            }
            else {
                int count = 0;
                int low = 0;
                int high = nums2.length - 1;
                while (low <= high)
                {
                    int mid = low + (high - low) / 2;
                    if((long) e1 * nums2[mid] <= prod)
                    {
                        count = nums2.length - mid;
                        high = mid - 1;
                    }
                    else {
                        low = mid + 1;
                    }
                }
                res += count;
            }

        }
        return res;


    }
}