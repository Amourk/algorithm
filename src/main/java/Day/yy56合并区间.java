package Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class yy56合并区间 {

  /**
   * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
   * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
   * <p>
   *  
   * <p>
   * 示例 1：
   * <p>
   * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]] 输出：[[1,6],[8,10],[15,18]] 解释：区间 [1,3] 和 [2,6] 重叠,
   * 将它们合并为 [1,6]. 示例 2：
   * <p>
   * 输入：intervals = [[1,4],[4,5]] 输出：[[1,5]] 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
   */
  public static void main(String[] args) {
    int[][] intervals = {{15,18},{1,3},{2,6},{8,10}};
    int[][] merge = merge(intervals);
    System.out.println(merge);
  }

  public static int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, new Comparator<int[]>() {
      public int compare(int[] interval1, int[] interval2) {
        return interval1[0] - interval2[0];
      }
    });
    List<int[]> list = new ArrayList<>();
    for (int i = 0; i < intervals.length; i++) {
      if (list.size() == 0 || list.get(list.size()-1)[1] < intervals[i][0]){
        list.add(new int[]{intervals[i][0],intervals[i][1]});
      }else {
        list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],intervals[i][1]);
      }
    }
    return list.toArray(new int[][]{});
  }
}
