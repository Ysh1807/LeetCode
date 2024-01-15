class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int count1 = 0;
        int count2 = 0;

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j]==2){
                    q.add(new Pair(i, j, 0));
                    count2++;
                }else if (grid[i][j]==1) {
                    count1++;
                }
            }
        }
        if (count1==0){
            return 0;
        } else if (count2==0) {
            return -1;
        }

        int ans = -1;

        while (q.size()>0){
            Pair remove = q.remove();
            int r = remove.row;
            int c = remove.col;
            ans = remove.time;

            if (r>0 && grid[r-1][c]==1){
                q.add(new Pair(r-1, c, ans+1));
                grid[r-1][c]=2;
            }
            if (c>0 && grid[r][c-1]==1){
                q.add(new Pair(r, c-1, ans+1));
                grid[r][c-1]=2;
            }
            if (r<m-1 && grid[r+1][c]==1){
                q.add(new Pair(r+1, c, ans+1));
                grid[r+1][c]=2;
            }
            if (c<n-1 && grid[r][c+1]==1){
                q.add(new Pair(r, c+1, ans+1));
                grid[r][c+1]=2;
            }

        }
        for(int i = 0; i < m ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(grid[i][j] == 1) {
					return -1;
				}
			}
		}

        return ans;

    }
}

class Pair{
    int row;
    int col;
    int time;

    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}