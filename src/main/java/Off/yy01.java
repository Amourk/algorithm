package Off;

public class yy01 {
    /**
     * 一个二维数组，每一行从左到右递增，每一列从上到下递增．
     * 输入一个二维数组和一个整数，判断数组中是否含有整数
     * */
    public static void main(String[] args) {
        //从二维数组右上角，往下递增，往左递减，二分查找
        Integer[][] integers = new Integer[][]{
            {1, 2, 8, 9},
            {2, 4, 9, 12},
            {4, 7, 10, 13},
            {6, 8, 11, 15}
        };

        System.out.println(test(integers,14));
    }

    public static Boolean test(Integer[][] arrays, Integer key){
        int lengths = arrays.length;
        int cols = arrays[0].length;
        int col = 0;
        int length = lengths-1;
        while (col<cols && length>=0){
            if (arrays[col][length] == key){
                return true;
            }else if (arrays[col][length] > key){
                length--;
            }else {
                col++;
            }
        }
        return false;
    }
}
