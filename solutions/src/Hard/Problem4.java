package Hard;

// So far the worst problem in terms of how well I was able to anticipate edge cases and how I handled them...
public class Problem4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 1 && nums2.length == 1)
            return (double) (nums1[0] + nums2[0]) / 2;
        int halfLen = (nums1.length + nums2.length) >>> 1;
        if (nums1.length < nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        if (nums1.length == 2 && nums2.length == 1) {
            if (nums1[0] >= nums2[0])
                return nums1[0];
            return Math.min(nums1[1], nums2[0]);
        }
        if (nums2.length == 0) {
            if (nums1.length % 2 == 0)
                return (double) (nums1[halfLen - 1] + nums1[halfLen]) / 2;
            return nums1[halfLen];
        }
        return findMedianBinarySearch(nums1, nums2, 0, halfLen, halfLen);
    }

    private double findMedianBinarySearch(int[] nums1, int[] nums2, int low, int high, int halfLen) {
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (mid == 0) {
                int len2 = nums2[0] < nums1[halfLen - 1] ? 1 : 0;
                return handleBinarySearchReturn(nums1, nums2, halfLen - len2, len2);
            }
            if (mid - 1 < nums2.length && nums1[halfLen - mid] >= nums2[mid - 1] && (nums2.length == mid || nums2[mid] >= nums1[halfLen - mid - 1]))
                return handleBinarySearchReturn(nums1, nums2, halfLen - mid, mid);
            if (mid - 1 >= nums2.length || nums1[halfLen - mid - 1] <= nums2[mid - 1])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }

    private double handleBinarySearchReturn(int[] nums1, int[] nums2, int len1, int len2) {
        if ((nums1.length + nums2.length) % 2 == 0)
            return (double) (Math.max(len1 != 0 ? nums1[len1 - 1] : Integer.MIN_VALUE, len2 != 0 ? nums2[len2 - 1] : Integer.MIN_VALUE) + Math.min(len1 < nums1.length ? nums1[len1] : Integer.MAX_VALUE, len2 < nums2.length ? nums2[len2] : Integer.MAX_VALUE)) / 2;
        else
            return Math.min(nums1[len1], len2 < nums2.length ? nums2[len2] : Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        System.out.println(problem4.findMedianSortedArrays(new int[]{1}, new int[]{2}));                        // 1.5
        System.out.println(problem4.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));                      // 2.0
        System.out.println(problem4.findMedianSortedArrays(new int[]{2,3}, new int[]{1}));                      // 2.0
        System.out.println(problem4.findMedianSortedArrays(new int[]{2,3}, new int[]{1,4}));                    // 2.5
        System.out.println(problem4.findMedianSortedArrays(new int[]{2,3}, new int[]{1,1}));                    // 1.5
        System.out.println(problem4.findMedianSortedArrays(new int[]{1,2,2}, new int[]{2,3}));                  // 2.0
        System.out.println(problem4.findMedianSortedArrays(new int[]{1,2,2}, new int[]{1,2}));                  // 2.0
        System.out.println(problem4.findMedianSortedArrays(new int[]{1,2,2}, new int[]{2,3,4}));                // 2.0
        System.out.println(problem4.findMedianSortedArrays(new int[]{1,3,5}, new int[]{0,2,4,6}));              // 3.0
        System.out.println(problem4.findMedianSortedArrays(new int[]{1,2,2}, new int[]{2,3,4,5,6,7,8,9,10}));   // 4.5
        System.out.println(problem4.findMedianSortedArrays(new int[]{1,2,2}, new int[]{2,3,4,5,6,7,8,9,10,11}));// 5.0
        System.out.println(problem4.findMedianSortedArrays(new int[]{1,2,2,4,5}, new int[]{2,3,4,5,6,7}));      // 4.0
        System.out.println(problem4.findMedianSortedArrays(new int[]{1}, new int[]{2,3,4,5,6,7,8}));            // 4.5
        System.out.println(problem4.findMedianSortedArrays(new int[]{2}, new int[]{1,3,4,5,6,7,8}));            // 4.5
    }
}
