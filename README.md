# Leetcode-3000
### Binary Search
* 使⽤条件
 1. 排序数组 (30-40%是⼆分)
 2. 当⾯试官要求你找⼀个⽐ O(n) 更⼩的时间复杂度算法的时候(99%)
 3. 找到数组中的⼀个分割位置，使得左半部分满⾜某个条件，右半部分不满⾜(100%)
 4. 找到⼀个最⼤/最⼩的值使得某个条件被满⾜(90%)
* 复杂度
 1. 时间复杂度：O(logn)
 2. 空间复杂度：O(1)
* 代码模版
 * ![Binary Search 模版](images/Binary_Search.png)<br/>

### 双指针 Two Pointers
* 类型
 1. 相向双指针 Opposite Direction Two Pointer: 
    - 两根指针一头一尾，向中间靠拢直到相遇
    - 时间复杂度 O(n)
    - 几乎所有 Two Sum 变种
    - Partition: Quick Select, 分成两个部分, 分成三个部分
    - Reverse类
    - 一些你没听过的（但是面试会考的）排序算法
 2. 同向双指针 Same Direction Two Pointer:
    - 两根指针都从头出发，朝着同一个方向移动
    - 滑动窗口类 Sliding Window
    - 快慢指针类 Fast & Slow Pointers
 3. 背向双指针
    - 这类类型题目不多，总共不超过10道
    - Longest Palindromic Substring 的中心线枚举算法
    - Find K Closest Elements