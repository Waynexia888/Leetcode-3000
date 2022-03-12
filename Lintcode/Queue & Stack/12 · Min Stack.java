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