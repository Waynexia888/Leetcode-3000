public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int x) {
        // write your code here
        queue1.offer(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        queue1.poll();
        // swap queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int num = queue1.poll();
        // swap queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        this.push(num);
        return num;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return queue1.isEmpty();
    }
}

//--------------------------------------------------------------------

public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void queue1ToQueue2() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
    }

    public void swapQueues() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public void push(int x) {
        // write your code here
        queue1.offer(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        this.queue1ToQueue2();
        queue1.poll();
        // swap queue1 and queue2
        this.swapQueues();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        this.queue1ToQueue2();
        int num = queue1.poll();
        // swap queue1 and queue2
        this.swapQueues();
        this.push(num);
        return num;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return queue1.isEmpty();
    }
}

// time: top() & pop() => O(n); push() & isEmpty() => O(1)
