package PDD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 商品可选计算 {

  /**
   * 计算剩余可以选择的规格，禁止向控制台打印输出，否则会影响判题。
   *
   * @param styles         商品的所有规格，和该规格对应的可选项目，key为规格名称。value为可选项目列表，例如{"color":["red","blue"]}
   * @param inventory      有库存的商品规格组合。
   * @param selectedStyles 用户已经选择了的规格，key为规格名称，value为选择的规格
   * @return 剩余可以选择的规格，不可以返回 null，key为规格名称。value为可选项目列表，例如{"color":["red","blue"]}
   */

  public static void main(String[] args) {
    // 规格
    Map<String, List<String>> styles = new HashMap<>();
    // 颜色
    List<String> colorList = new ArrayList<>();
    colorList.add("red");
    colorList.add("blue");
    colorList.add("green");
    styles.put("color", colorList);
    // 大小
    List<String> sizeList = new ArrayList<>();
    sizeList.add("s");
    sizeList.add("m");
    sizeList.add("l");
    styles.put("size", sizeList);
    // image
    List<String> imageList = new ArrayList<>();
    imageList.add("apple");
    imageList.add("banana");
    imageList.add("cherry");
    styles.put("image", imageList);

    // 库存
    List<Map<String, String>> inventory = new ArrayList<>();
    Map<String, String> map1 = new HashMap<>();
    map1.put("color", "red");
    map1.put("size", "s");
    map1.put("image", "apple");
    inventory.add(map1);
    Map<String, String> map2 = new HashMap<>();
    map2.put("color", "blue");
    map2.put("size", "m");
    map2.put("image", "cherry");
    inventory.add(map2);
    Map<String, String> map3 = new HashMap<>();
    map3.put("color", "red");
    map3.put("size", "xl");
    map3.put("image", "cherry");
    inventory.add(map3);

    // 已选
    Map<String, String> selectedStyles = new HashMap<>();
    selectedStyles.put("color", "red");
//    selectedStyles.put("size", "xl");

    aa(styles, inventory, selectedStyles);
//    yy();
  }

  private static Map<String, List<String>> aa(Map<String, List<String>> styles,
      List<Map<String, String>> inventory, Map<String, String> selectedStyles) {

    Set<String> selectedStyleList = selectedStyles.keySet();
    for (String selectedStyle : selectedStyleList) {
      // 选择后的库存
      List<Map<String, String>> newInventory = new ArrayList<>();
      // 选择的在规格中
      if (styles.containsKey(selectedStyle)) {
        for (Map<String, String> i : inventory) {
          if (i.get(selectedStyle).equals(selectedStyles.get(selectedStyle))) {
            i.remove(selectedStyle);
            newInventory.add(i);
          }
        }
      }
      inventory = newInventory;
    }

    // 结果
    Map<String, List<String>> result = new HashMap<String, List<String>>();

    Set<String> strings1 = inventory.get(0).keySet();
    for (String s : strings1) {
      List<String> re = new ArrayList<>();
      for (Map<String, String> inv : inventory) {
        re.add(inv.get(s));
      }
      result.put(s,re);
    }

    return result;
  }


  private static void tt() {
    // 规格
    Map<String, List<String>> ss = new HashMap<>();
    // 颜色
    List<String> colorList = new ArrayList<>();
    colorList.add("red");
    colorList.add("blue");
    colorList.add("green");
    ss.put("color", colorList);
    // 大小
    List<String> sizeList = new ArrayList<>();
    sizeList.add("s");
    sizeList.add("m");
    sizeList.add("l");
    ss.put("size", sizeList);
    // 已选
    Map<String, String> aa = new HashMap<>();
    aa.put("color", "red");
    Set<String> strings = aa.keySet();
    for (String s : strings) {
      if (ss.containsKey(s)) {
        System.out.println("111111111");
      }
    }
  }

  private static void yy() {
    Map<String, String> map1 = new HashMap<>();
    map1.put("color", "red");
    map1.put("size", "s");
    map1.put("image", "apple");
    map1.remove("color1");
    System.out.println("a");
  }
}
