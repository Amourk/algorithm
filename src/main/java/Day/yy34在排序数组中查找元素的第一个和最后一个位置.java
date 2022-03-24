package Day;

public class yy34在排序数组中查找元素的第一个和最后一个位置 {

  /**
   * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
   * <p>
   * 如果数组中不存在目标值 target，返回 [-1, -1]。
   * <p>
   * 进阶：
   * <p>
   * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？  
   * <p>
   * 示例 1：
   * <p>
   * 输入：nums = [5,7,7,8,8,10], target = 8 输出：[3,4] 示例 2：
   * <p>
   * 输入：nums = [5,7,7,8,8,10], target = 6 输出：[-1,-1] 示例 3：
   * <p>
   * 输入：nums = [], target = 0 输出：[-1,-1]
   */

  public static void main(String[] args) {
    int[] nums = {};
    int[] ints = searchRange(nums, 4);
    System.out.println("aaaaa------------->" + ints);
  }

  public static int[] searchRange(int[] nums, int target) {
    int[] res = new int[] {-1, -1};
    res[0] = tt(nums, target, true);
    res[1] = tt(nums, target, false);
    return res;
  }

  private static int tt(int[] nums, int target, boolean flag){
    int length = nums.length;
    int left = 0;
    int right = length -1 ;
    int result = -1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] > target) {
        right = mid -1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        result = mid;
        if (flag) {
          right--;
        } else {
          left++;
        }
      }
    }
    return result;
  }
}
