/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>();
 *     }
 * }
 */

public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return node;
        }

        // 1. 通过给的node -> 找到所有的nodes
        List<UndirectedGraphNode> nodes = getNodes(node); 

        // 2. copy all nodes, store the old node -> new node (mapping) in hashmap
        Map<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }

        // 3. copy all neighbors(edges)
        for (UndirectedGraphNode oldNode : nodes) {
            UndirectedGraphNode newNode = mapping.get(oldNode);
            for (UndirectedGraphNode oldNei : oldNode.neighbors) {
                UndirectedGraphNode newNeighbor = mapping.get(oldNei);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return mapping.get(node);
    }

    private List<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(node);
        set.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            for (UndirectedGraphNode nei : n.neighbors) {
                if (!set.contains(nei)) {
                    queue.offer(nei);
                    set.add(nei);
                }
            }
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }
}

// 1 -> [-2, 4]
// -2: -> [1, 4]
// 4; -> [1, -2, 6]

// node -> nodes  (BFS)
// nodes -> copy nodes (1 -> 1'; 2 -> 2')
// neighbors -> copy neighbors
