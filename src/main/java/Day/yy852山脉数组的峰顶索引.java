package Day;

public class yy852山脉数组的峰顶索引 {

  /**
   * 符合下列属性的数组 arr 称为 山脉数组 ： arr.length >= 3 存在 i（0 < i < arr.length - 1）使得： arr[0] < arr[1] < ...
   * arr[i-1] < arr[i] arr[i] > arr[i+1] > ... > arr[arr.length - 1] 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0]
   * < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
   * <p>
   *  
   * <p>
   * 示例 1：
   * <p>
   * 输入：arr = [0,1,0] 输出：1 示例 2：
   * <p>
   * 输入：arr = [0,2,1,0] 输出：1 示例 3：
   * <p>
   * 输入：arr = [0,10,5,2] 输出：1 示例 4：
   * <p>
   * 输入：arr = [3,4,5,1] 输出：2 示例 5：
   * <p>
   * 输入：arr = [24,69,100,99,79,78,67,36,26,19] 输出：2  
   */

  public static void main(String[] args) {
    int[] arr = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
    int i = tt(arr);
    System.out.println(i);
  }

  public static int peakIndexInMountainArray(int[] arr) {
    int maxIndex = 0;
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] < arr[i + 1]) {
        maxIndex = i + 1;
      }
    }
    return maxIndex;
  }

  /**
   * 二分
   */

  public static int tt(int[] arr) {
    int left = 0;
    int right = arr.length;
    while (left<right) {
      int mid = (left + right) / 2;
      if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]){
        left = mid;
      } else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
        right = mid;
      } else if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
        return mid;
      }
    }
    return -1;
  }
}
