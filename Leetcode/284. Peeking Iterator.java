// --------------------------JavaScript解法1-----------------------------------

/**
 * // This is the Iterator's API interface.
 * // You should not implement it, or speculate about its implementation.
 * function Iterator() {
 *    @ return {number}
 *    this.next = function() { // return the next number of the iterator
 *       ...
 *    }; 
 *
 *    @return {boolean}
 *    this.hasNext = function() { // return true if it still has numbers
 *       ...
 *    };
 * };
 */

/**
 * @param {Iterator} iterator
 */
var PeekingIterator = function(iterator) {
    // O(1)
    this.iterator = iterator;
    // 用一个变量nextElement保存下一个元素； 当调用peek(),则直接return nextElement;
    // 当调用next()之后, nextElement会成为iterator的下一个元素，所以要更新nextElement
    this.nextElement = iterator.next();
};

/**
 * @return {number}
 */
PeekingIterator.prototype.peek = function() {
    return this.nextElement; // O(1)
};

/**
 * @return {number}
 */
PeekingIterator.prototype.next = function() {
    // O(1)
    let curElement = this.nextElement;  // 先把当前的nextElement保存到前一个变量里
    if (this.iterator.hasNext()) {    // 判断iterator是否走到头了
        this.nextElement = this.iterator.next();
    } else {
        this.nextElement = null;
    }
    return curElement;
};

/**
 * @return {boolean}
 */
PeekingIterator.prototype.hasNext = function() {
    return this.nextElement != null;
};

/** 
 * Your PeekingIterator object will be instantiated and called as such:
 * var obj = new PeekingIterator(arr)
 * var param_1 = obj.peek()
 * var param_2 = obj.next()
 * var param_3 = obj.hasNext()
 */

 // --------------------------JavaScript 解法2--------------------------------
 /**
 * // This is the Iterator's API interface.
 * // You should not implement it, or speculate about its implementation.
 * function Iterator() {
 *    @ return {number}
 *    this.next = function() { // return the next number of the iterator
 *       ...
 *    }; 
 *
 *    @return {boolean}
 *    this.hasNext = function() { // return true if it still has numbers
 *       ...
 *    };
 * };
 */

/**
 * @param {Iterator} iterator
 */
var PeekingIterator = function(iterator) {
    // 创建一个array，把iterator里面的数都倒腾给array, O(n) time
    this.arr = [];
    while (iterator.hasNext()) {
        this.arr.push(iterator.next());
    }
    this.index = 0;
    this.size = this.arr.length;
};

/**
 * @return {number}
 */
PeekingIterator.prototype.peek = function() {
    //返回数组中的下一个元素，但 不 移动指针
    return this.arr[this.index]; // O(1)
};

/**
 * @return {number}
 */
PeekingIterator.prototype.next = function() {
    //返回数组中的下一个元素，移动指针。
    return this.arr[this.index++];  // O(1)
};

/**
 * @return {boolean}
 */
PeekingIterator.prototype.hasNext = function() {
    // 判断一下指针是否走到头了
    return this.index < this.size;  // O(1)
};

/** 
 * Your PeekingIterator object will be instantiated and called as such:
 * var obj = new PeekingIterator(arr)
 * var param_1 = obj.peek()
 * var param_2 = obj.next()
 * var param_3 = obj.hasNext()
 */

 // ---------------------------Java 解法-----------------------------------
 // Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    public Queue<Integer> queue;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        queue = new LinkedList<>();
        while (iterator.hasNext()) {          // O(n)
            queue.offer(iterator.next());
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {   // O(1)
        return queue.peek();
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {   // O(1)
	    return queue.poll();
	}
	
	@Override
	public boolean hasNext() {  // O(1)
        return queue.size() > 0;
	}
}
