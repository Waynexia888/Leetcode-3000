public class MinStack {
    Stack<Integer> stack, minStack;
    public MinStack() {
        // do intialization if necessary
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty() || number < minStack.peek()) {
            minStack.push(number);
        } else {
            minStack.push(minStack.peek());
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        minStack.pop();
        return stack.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return minStack.peek();
    }
}

// -------------------------有什么可以优化的地方吗？ 空间方面--------------------------

public class MinStack {
    Stack<Integer> stack, minStack;
    public MinStack() {
        // do intialization if necessary
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty() || number <= minStack.peek()) {
            minStack.push(number);
        } 
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int number = stack.pop();
        if (number == minStack.peek()) {
            minStack.pop();
        }
        return number;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return minStack.peek();
    }
}

//--------------------------solution----------------------------
public class MinStack {
    Stack<int[]> stack;
    public MinStack() {
        // do intialization if necessary
        stack = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        if (stack.isEmpty()) {
            int[] item = new int[2];
            item[0] = number;
            item[1] = number;
            stack.push(item);
        } else {
            int[] item = new int[2];
            item[0] = number;
            if (number > stack.peek()[1]) {
                item[1] = stack.peek()[1];
            } else {
                item[1] = number;
            }
            stack.push(item);
        }
    }
    //[2, 2], [3, 2], [1, 1]
    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        return stack.pop()[0];
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return stack.peek()[1];
    }
}