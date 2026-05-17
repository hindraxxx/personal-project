public class MedianOfTwoSortedArraysMergeSolution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] merged = new int[nums1.length + nums2.length];
    int i = 0;
    int j = 0;
    int k = 0;

    while (i < nums1.length || j < nums2.length) {
      if (j == nums2.length || (i < nums1.length && nums1[i] <= nums2[j])) {
        merged[k++] = nums1[i++];
      } else {
        merged[k++] = nums2[j++];
      }
    }

    int len = merged.length;
    int mid = len / 2;

    if (len % 2 == 1) {
      return merged[mid];
    }

    return (merged[mid - 1] + merged[mid]) / 2.0;
  }
}
