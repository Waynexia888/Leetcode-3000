/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        int rows = grid.length;
        int columns = grid[0].length;
        if (grid == null || rows == 0 || grid[0] == null || columns == 0) {
            return -1;
        }

        if (source.x == destination.x && source.y == destination.y) {
            return 0;
        }

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][columns];
        queue.offer(source);
        visited[source.x][source.y] = true;

        int[] dx = new int[]{1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = new int[]{2, -2, 2, -2, 1, -1, 1, -1};

        int path = 0;
        while (!queue.isEmpty()) {
            path++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                for (int k = 0; k < 8; k++) {
                    int nx = point.x + dx[k];
                    int ny = point.y + dy[k];
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < columns && !grid[nx][ny] && !visited[nx][ny]) {
                        if (nx == destination.x && ny == destination.y) {
                            return path;
                        }
                        queue.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;   
    }
}

//////////////////////////////////////////////////////////////////////

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        int rows = grid.length;
        int columns = grid[0].length;
        if (grid == null || rows == 0 || grid[0] == null || columns == 0) {
            return -1;
        }

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][columns];
        queue.offer(source);
        visited[source.x][source.y] = true;

        int[] dx = new int[]{1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = new int[]{2, -2, 2, -2, 1, -1, 1, -1};

        int path = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                if (point.x == destination.x && point.y == destination.y) {
                    return path;
                }
                for (int k = 0; k < 8; k++) {
                    int nx = point.x + dx[k];
                    int ny = point.y + dy[k];
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < columns && !grid[nx][ny] && !visited[nx][ny]) {
                        queue.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
            path++;
        }
        return -1;   
    }
}
// queue = [(2, 0)] path = 0
// queue = [(0, 1), (1, 2)] path = 1
// queue = [(2, 2), (0, 0)] path = 2

