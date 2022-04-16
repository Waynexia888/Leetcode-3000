/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     List<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * }
 */

public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> results = new ArrayList<>();
        if (graph == null) {
            return results;
        }

        // 1. using hashmap to count in degree. (key: DirectedGraphNode; value: in degree)
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode nei : node.neighbors) {
                // if (map.containsKey(nei)) {
                //     map.put(nei, map.get(nei) + 1);
                // } else {
                //     map.put(nei, 1);
                // }
                map.put(nei, map.getOrDefault(nei, 0) + 1);
            }
        }

        // 2. find out nodes that has 0 indegree, then put it into queue
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                queue.offer(node);
            }
        }

        // 3. bfs
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            results.add(node);
            for (DirectedGraphNode nei : node.neighbors) {
                map.put(nei, map.get(nei) - 1);
                if (map.get(nei) == 0) {
                    queue.offer(nei);
                }
            }
        }
        return results;
    }
}