class Solution {
public:
    int largestIsland(vector<vector<int>>& grid) {
        if(grid.size() == 0)
        {
            return 0;
        }
        int n = grid.size();
        int m = grid[0].size();
        unordered_map<int, int> table;
        table[0] = 0;
        int index = 2;
        int res = 0;
        for(int i=0; i<grid.size(); i++)
        {
            for(int j =0; j <grid[0].size(); j++)
            {
                if(grid[i][j] == 1)
                {
                    int area = findArea(grid, index, i, j);
                    res = max(area, res);
                    table[index] = area;
                    index++;
                }
            }
        }
       
       
        for(int i=0; i<grid.size(); i++)
        {
            for(int j =0; j <grid[0].size(); j++)
            {
                if(grid[i][j]==0)
                {
                    int sum = 1;
                    unordered_set<int> visited;
                   
                    if(i+1<grid.size())
                    {
                        visited.insert(grid[i+1][j]);
                    }
                    if(j+1<grid[0].size())
                    {
                        visited.insert(grid[i][j+1]);
                    }
                    if(i-1>=0)
                    {
                        visited.insert(grid[i-1][j]);
                    }
                    if(j-1>=0)
                    {
                        visited.insert(grid[i][j-1]);
                    }
                    for(int i:visited)
                    {
                        sum += table[i];
                    }
                    res = max(res, sum);
                }
            }
        }
        return res;
       
    }
   
    int findArea(vector<vector<int>>& grid, int index, int i, int j)
    {
        if(grid[i][j] == 0)
        {
            return 0;
        }
       
        else
        {
            int down = 0;
            int up = 0;
            int right = 0;
            int left = 0;
            grid[i][j] = index;
            if(i+1<grid.size()&& grid[i+1][j] == 1)
            {
                down =  findArea(grid, index, i+1, j);
            }
            if(i-1>=0 && grid[i-1][j] == 1)
            {
                up =  findArea(grid, index, i-1, j);
            }
            if(j+1<grid[0].size() && grid[i][j+1] == 1)
            {
                right = findArea(grid, index, i, j+1);
            }
            if(j-1>=0 && grid[i][j-1] == 1)
            {
                left = findArea(grid, index, i, j-1);
            }
            int sum = down + up + right + left +1;
            return sum;
        }
    }
};