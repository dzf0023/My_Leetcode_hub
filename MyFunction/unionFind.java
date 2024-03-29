// UnionFind.class
class UnionFind {
    private int[] root;

    public UnionFind(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    void union(int x, int y){
        x = root[x];   // 这个地方注意是  find(x) 还是 root[x]， 有时候只能是 find(x)
        y = root[y];
        if(x < y){
            root[y] = x;
        }else{
            root[x] = y;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

// App.java
// Test Case
public class App {
    public static void main(String[] args) throws Exception {
        UnionFind uf = new UnionFind(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}
============================================================


class UnionFind {
    
    private int[] group;
    private int[] rank;
    
    public UnionFind(int size){
        this.group = new int[size];
        this.rank = new int[size];
        for(int i = 0; i < size; i++){
            this.group[i] = i;
            this.rank[i] = 1;
        }
    }
    
    public int find(int person){
        // while(person != this.group[person]){
        //     person = this.find(person);
        // }
        // return person;
        if (this.group[person] == person){
            return this.group[person];
        }
        return this.group[person] = this.find(this.group[person]);
    }
    
    public boolean union(int  a, int b){
        int groupA = this.find(a);
        int groupB = this.find(b);
        
        boolean isMerged = false;
        
        if(groupA == groupB){
            return isMerged;
        }
        
        isMerged = true;
        
        if(this.rank[groupA] > this.rank[groupB]){
            this.group[groupB] = groupA;
        }else if(this.rank[groupA] < this.rank[groupB]){
            this.group[groupA] = groupB;
        }else{
            this.group[groupA] = groupB;
            this.rank[groupB] += 1;
        }
        return isMerged;
    }

    
    
}
