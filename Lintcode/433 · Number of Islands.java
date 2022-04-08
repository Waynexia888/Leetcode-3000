public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;
        int numberOfIsland = 0;
        boolean[][] visited = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] && visited[i][j] == false) {
                    bfs(grid, i, j, visited);  //通过当前岛屿 把它邻居岛屿找出来， 然后标记访问过
                    numberOfIsland++;
                }
            }
        }
        return numberOfIsland;
    }

    // (i, j) (i - 1, j) (i + 1, j), (i, j - 1) (i, j + 1)

    private void bfs(boolean[][] grid, int i, int j, boolean[][] visited) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        queueX.offer(i);
        queueY.offer(j);
        visited[i][j] = true;

        while (!queueX.isEmpty()) {
            int curX = queueX.poll();
            int curY = queueY.poll();
            for (int k = 0; k < 4; k++) {
                int nx = curX + dx[k];
                int ny = curY + dy[k];
                // 1. 新的坐标是否出界. 2. 是不是岛屿 3. 之前有没有访问过
                if (check(grid, nx, ny, visited)) {
                    queueX.offer(nx);
                    queueY.offer(ny);
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private boolean check(boolean[][] grid, int nx, int ny, boolean[][] visited) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (nx >= 0 && nx < rows && ny >= 0 && ny < columns && grid[nx][ny] && visited[nx][ny] == false) {
            return true;
        }
        return false;
    }

}

///////////////////////////////////////////////////////////////////

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;
        int numberOfIsland = 0;
        boolean[][] visited = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] && visited[i][j] == false) {
                    bfs(grid, i, j, visited);  //通过当前岛屿 把它邻居岛屿找出来， 然后标记访问过
                    numberOfIsland++;
                }
            }
        }
        return numberOfIsland;
    }

    // (i, j) (i - 1, j) (i + 1, j), (i, j - 1) (i, j + 1)

    private void bfs(boolean[][] grid, int i, int j, boolean[][] visited) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        // Queue<Integer> queueX = new LinkedList<>();
        // Queue<Integer> queueY = new LinkedList<>();
        Queue<Point> queue = new LinkedList<>();
        // queueX.offer(i);
        // queueY.offer(j);
        queue.offer(new Point(i, j));
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            // int curX = queueX.poll();
            // int curY = queueY.poll();
            for (int k = 0; k < 4; k++) {
                int nx = point.x + dx[k];
                int ny = point.y + dy[k];
                // 1. 新的坐标是否出界. 2. 是不是岛屿 3. 之前有没有访问过
                if (check(grid, nx, ny, visited)) {
                    // queueX.offer(nx);
                    // queueY.offer(ny);
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private boolean check(boolean[][] grid, int nx, int ny, boolean[][] visited) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (nx >= 0 && nx < rows && ny >= 0 && ny < columns && grid[nx][ny] && visited[nx][ny] == false) {
            return true;
        }
        return false;
    }

}