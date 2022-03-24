package PDD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class 负载均衡 {

  /**
   * 描述
   * <p>
   * 我们都知道，很多项目使用的框架内部，都采用了某种负载均衡算法。它不仅可以把负载分散，还可以实现故障隔离和自动恢复。
   * <p>
   * 假设当前系统配置n个（n>=2）服务调用地址（有顺序），每个地址均匀的接收请求。当系统在n秒时，第2个地址无效无法访问，
   * <p>
   * 在2*n秒时，第1个地址无效无法访问，在3*n秒时所有地址都恢复正常。
   * <p>
   * 如果访问的地址在访问时刻无效，则需要按顺序访问下一个地址。如果已经到最后一个地址，则需要从头开始。
   * <p>
   * 如果当前的所有地址均不可访问，此时输出nullurl 字符串作为当前的访问地址。
   * <p>
   * 请输出该系统在[1，3n] 时间段内每一个时间点访问的访问地址，以英文逗号分隔。
   * <p>
   * 输入的url个数>=2.
   * <p>
   * 如果输入的url个数为1，返回 nullurl 即可。
   * <p>
   * <p>
   * 输入 输入为一个 url 数组
   * <p>
   * <p>
   * 输出 输出为一个字符串，类似 "url1,url2" 这样的字符串
   * <p>
   * <p>
   * 输入样例 1
   * <p>
   * [a.com,b.com,c.com,d.com] 输出样例 1
   * <p>
   * a.com,b.com,c.com,d.com,a.com,c.com,d.com,c.com,d.com,c.com,d.com,a.com 输入样例 2
   * <p>
   * [a.com] 输出样例 2
   * <p>
   * nullurl 提示
   */

  public static void main(String[] args) {
    String[] urls = {"a","b","c","d","e"};
/*    List<String> aa = yy(urls);
    System.out.println(aa);*/
    yy(urls);
  }

  private static List<String> aa(String[] urls) {
    List<String> list = new ArrayList<>();
    List<String> urlList = new ArrayList<>(Arrays.asList(urls));
    int length = urls.length;
    for (int i = 1; i <= length * 3; i++) {
      int j = i;
      int key = j % urlList.size();
      if (key == 0) {
        list.add(urlList.get(urlList.size() - 1));
      } else {
        list.add(urlList.get(key - 1));
      }
      if (i == length) {
        urlList.remove(1);
      }
      if (i == 2 * length) {
        urlList.remove(0);
      }
      if (i == length * 3) {
        urlList.add(0, urls[0]);
        urlList.add(1, urls[1]);
      }
    }
    return list;
  }

  private static void bb(String[] urls) {
    List<String> urlList = new ArrayList<>(Arrays.asList(urls));
    urlList.remove(1);
    System.out.println("a");
    urlList.add(1, "e");
    System.out.println("b");
  }

  private static List<String> rr(String[] urls) {
    List<String> list = new ArrayList<>();
    List<String> urlList = new ArrayList<>(Arrays.asList(urls));
    List<Boolean> flag = new ArrayList<>();
    for (int i = 0; i < urls.length; i++) {
      flag.add(true);
    }
    int length = urls.length;
    int count = 0;
    for (int i = 1; i < 4; i++) {
      for (int j = 1; j <= length; j++) {
        count++;
        int f = j;
        if (count == length) {
          urlList.remove(1);
          f = 1;
        } else if (count == 2 * length) {
          urlList.remove(0);
          f = 1;
        } else if (count == 3 * length) {
          urlList.add(0, urls[0]);
          urlList.add(1, urls[1]);
          f = 1;
        }
        int key = f % urlList.size();
        if (key == 0) {
          list.add(urlList.get(urlList.size() - 1));
        } else {
          list.add(urlList.get(key - 1));
        }
      }
    }
    return list;
  }


  private static List<String> yy(String[] urls) {
    String nullurl = "nullurl";
    List<String> list = new ArrayList<>();
    if (urls.length < 2) {
      list.add(nullurl);
      return list;
    }
    Map<String, Boolean> flagMap = new HashMap<>();
    for (int i = 0; i < urls.length; i++) {
      flagMap.put(urls[i], true);
    }
    List<String> urlList = new ArrayList<>(Arrays.asList(urls));
    int length = urls.length;
    int count = 0;
    int aaa = 0;
    while (list.size() < 3 * length) {
      aaa++;
      count++;
      if (aaa == length) {
        flagMap.put(urls[1], false);
      } else if (aaa == 2 * length) {
        flagMap.put(urls[0], false);
      } else if (aaa == 3 * length) {
        flagMap.put(urls[0], true);
        flagMap.put(urls[1], true);
      }

      int key = count % urlList.size();
      int yy = 0;
      while (true) {
        yy++;
        if (yy > length) {
          list.add(nullurl);
          break;
        } else {
          if (key == 0) {
            if (!flagMap.get(urls[urlList.size() - 1])) {
              count++;
              key = count % urlList.size();
            } else {
              list.add(urlList.get(urlList.size() - 1));
              break;
            }
          } else {
            if (!flagMap.get(urls[key - 1])) {
              count++;
              key = count % urlList.size();
            } else {
              list.add(urlList.get(key - 1));
              break;
            }
          }
        }
      }
    }
    return list;
  }

  private static void qq(String[] urls) {
    Map<String, Boolean> flagMap = new HashMap<>();

    Queue<String> queue = new LinkedList();
    for (int i = 0; i < urls.length; i++) {
      flagMap.put(urls[i], true);
      queue.add(urls[i]);
    }

    List<String> list = new ArrayList<>();
    int length = urls.length;
    int count = 0;
    while (list.size() < 3 * length) {
      for (String s : urls) {
        count++;
        if (count == length) {
          flagMap.put(urls[1], false);
        } else if (count == 2 * length) {
          flagMap.put(urls[0], false);
        } else if (count == 3 * length) {
          flagMap.put(urls[0], true);
          flagMap.put(urls[1], true);
        }
        if (flagMap.get(queue.peek())) {
          list.add(queue.peek());
        }
        queue.poll();
        queue.offer(s);

      }
    }
    System.out.println(list);
  }

}
