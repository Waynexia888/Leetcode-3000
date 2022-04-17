public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        int[] topologicalOrder = new int[numCourses];
        if (prerequisites == null || numCourses <= 0) {
            return topologicalOrder;
        }
        
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            if (graph.containsKey(prerequisites[i][1])) {
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                graph.put(prerequisites[i][1], list);
            }
        }

        // 入度为0的课程 加到queue里面去
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            topologicalOrder[count++] = course;
            List<Integer> preCourse = graph.get(course);
            if (preCourse == null || preCourse.size() == 0) {
                continue;
            }
            for (int i = 0; i < preCourse.size(); i++) {
                inDegree[preCourse.get(i)]--;
                if (inDegree[preCourse.get(i)] == 0) {
                    queue.offer(preCourse.get(i));
                }
            }
        }
        
        return count == numCourses ? topologicalOrder : new int[0];
    }
}