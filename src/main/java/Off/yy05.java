package Off;

import java.util.Stack;

public class yy05 {
    /**
     * 用两个栈来实现一个队列，完成队列的Push(入)和Pop(出)操作。 队列中的元素为int类型。
     * */

    public static void main(String[] args) {
    }

    public class queue{
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public  void push(Integer node){
            stack1.push(node);
        }

        public  Integer pop() {
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }

}
