package Day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class yy1233删除子文件夹 {
    /**
     * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
     *
     * 我们这样定义「子文件夹」：
     *
     * 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的子文件夹。
     * 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：
     *
     * / 后跟一个或者多个小写英文字母。
     * 例如，/leetcode 和 /leetcode/problems 都是有效的路径，而空字符串和 / 不是。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
     * 输出：["/a","/c/d","/c/f"]
     * 解释："/a/b/" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
     * 示例 2：
     *
     * 输入：folder = ["/a","/a/b/c","/a/b/d"]
     * 输出：["/a"]
     * 解释：文件夹 "/a/b/c" 和 "/a/b/d/" 都会被删除，因为它们都是 "/a" 的子文件夹。
     * 示例 3：
     *
     * 输入：folder = ["/a/b/c","/a/b/d","/a/b/ca"]
     * 输出：["/a/b/c","/a/b/ca","/a/b/d"]
     *  
     *
     * 提示：
     *
     * 1 <= folder.length <= 4 * 10^4
     * 2 <= folder[i].length <= 100
     * folder[i] 只包含小写字母和 /
     * folder[i] 总是以字符 / 起始
     * 每个文件夹名都是唯一的
     * */

    public static void main(String[] args) {

    }

    public List<String> removeSubfolders(String[] folder) {
        List<String> list = new ArrayList<>();
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (String s : folder) {
            hashMap.put(s,s.length());
        }
        for (String s : folder) {
            int i = s.length()-1;
            boolean flag = true;
            for ( ; i >0 ; i--) {
                if (s.charAt(i) == '/'){
                    if (hashMap.get(s.substring(0,i)) != null){
                        flag = false;
                    }
                }
            }
            if (flag){
                list.add(s);
            }
        }
        return list;
    }
}
