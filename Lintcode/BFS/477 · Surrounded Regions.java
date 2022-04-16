class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    /*
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    public void surroundedRegions(char[][] board) {
        // traverse the board, find all border 'O' -> bfs(find connected 'O') -> 'T'
        // traverse the board again, flip all 'O' to 'X', flip all 'T' to 'O'
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    bfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }  
    }

    private void bfs(char[][] board, int i, int j) {
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j));
        board[i][j] = 'T';

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = point.x + dx[k];
                int ny = point.y + dy[k];
                if (check(board, nx, ny)) {
                    board[nx][ny] = 'T';
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    private boolean check(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        if (board[x][y] != 'O') {
            return false;
        }
        return true;
    }
}

// X X T X X
// X T T X X
// X T X O O
// X T X O X