public class Solution {
    /**
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        // if (start.equals(end)) {
        //     return 1;
        // }

        dict.add(start);
        dict.add(end);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        int distance = 0;
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(end)) {
                    return distance;
                }
                for (String s : getWords(word, dict)) {
                    if (!visited.contains(s)) {
                        queue.offer(s);
                        visited.add(s);
                    }
                }
            }
        }
        return distance;
    }

    private List<String> getWords(String curWord, Set<String> dict) {
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < curWord.length(); i++) {     // O(L)
            for (char c = 'a'; c <= 'z'; c++) {          // O(25)
                if (curWord.charAt(i) != c) {
                    char[] arr = curWord.toCharArray();  // "hit" -> ['h', 'i', 't']
                    arr[i] = c;                          // 'i' -> 'o'
                    String newWord = new String(arr);    // "hot"      // O(L)
                    if (dict.contains(newWord)) {
                        neighbors.add(newWord);
                    }
                }
            }
        }
        return neighbors;
    }
}

// queue = ["hit"]
// queue = ["hot"]
// ["dot", "lot"]

// dict 的length N >> 单词w的length M
// 方法1:  O(N*M)  = (10000 * 10)
//  for dict中的每个单词w   (O(N))
//     compare w and curWord   (O(M))
//         if edit distance == 1
//             add to neighbors

// 方法2: O(25 * M^2) = (25 * 10* 10)
// for curWord 这个单词中的每个位置(字符) (O(M))
//     for 这个位置(字符)可以变成什么其他的字符 (O(25))
//         构造一个新的单词 newWord (O(M))
//         if newWord 在dict里：  (O(1))
//             add to neighbors
