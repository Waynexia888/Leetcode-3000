class MaxStack {
    Stack<Integer> stack, maxStack; 
    public MaxStack() {
        // do intialization if necessary
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */    
    public void push(int x) {
        // write your code here
        stack.push(x);
        if (maxStack.isEmpty() || x > maxStack.peek()) {
            maxStack.push(x);
        } else {
            maxStack.push(maxStack.peek());
        }
    }

    public int pop() {
        // write your code here
        maxStack.pop();
        return stack.pop();
    }

    /*
     * @return: An integer
     */    
    public int top() {
        // write your code here
        return stack.peek();
    }

    /*
     * @return: An integer
     */    
    public int peekMax() {
        // write your code here
        return maxStack.peek();
    }

    /*
     * @return: An integer
     */    
    public int popMax() {
        // write your code here
        int max = peekMax();
        Stack<Integer> buffer = new Stack<>();
        while (top() != max) {
            buffer.push(pop());
        }
        pop();
        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }
        return max;
    }
}