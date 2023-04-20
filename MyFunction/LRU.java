class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> map;  // Store the nodes to dictionary to get it by its key. 
    int capacity;
    
    
//      (this is most recently used)  head-> node1-> node2.... ->tail (this is least recently used)
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map =  new HashMap<>();
        tail = new Node(0, 0);
        head = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }else{
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
        }
        
        if(map.size() == capacity){
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }
    
    
    public void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void insert(Node node){
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }
}

//      (this is most recently used)  head-> node1-> node2.... ->tail (this is least recently used)

class Node{
    Node prev;
    Node next;
    int key;
    int value;
    
    
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
