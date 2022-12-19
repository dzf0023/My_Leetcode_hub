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
