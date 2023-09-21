package tp2;

public class LinkedHashMap<KeyType, DataType> {

    private static final double COMPRESSION_FACTOR = 2; // 50%
    private static final int DEFAULT_CAPACITY = 20;
    private static final int CAPACITY_INCREASE_FACTOR = 2;

    private Node<KeyType, DataType>[] map;
    private int capacity;
    private int size = 0;

    public LinkedHashMap() {
        capacity = DEFAULT_CAPACITY;
        map = new Node[DEFAULT_CAPACITY];
    }

    public LinkedHashMap(int capacity) {
        this.capacity = capacity;
        map = new Node[capacity];
    }

    /**
     * Finds the index attached to a particular key
     * @param key Value used to access to a particular instance of a DataType within map
     * @return The index value attached to a particular key
     */
    private int getIndex(KeyType key){
        int keyHash = key.hashCode() % capacity;
        return keyHash < 0 ? -keyHash : keyHash;
    }

    private boolean shouldRehash() {
        return size * COMPRESSION_FACTOR > capacity;
    }

    /** TODO
     * Increases capacity by CAPACITY_INCREASE_FACTOR (multiplication) and
     * reassigns all contained values within the new map
     */
    private void rehash() {
        capacity = capacity*CAPACITY_INCREASE_FACTOR;
        Node<KeyType, DataType>[] ancienMap = this.map;
        LinkedHashMap nouvelleMap = new LinkedHashMap(capacity);
        for (int i=0; i<capacity/2; i++) {
            if(ancienMap[i]!=null){
                while(ancienMap[i]!=null){
                    nouvelleMap.put(ancienMap[i].key, ancienMap[i].data);
                    ancienMap[i] = ancienMap[i].next;
                }
            }
        }
        this.map = nouvelleMap.map;
    }

    public int size() {
        return size;
    }

    public int getCapacity(){
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /** TODO
     * Finds if map contains a key
     * @param key Key which we want to know if exists within map
     * @return if key is already used in map
     */
    public boolean containsKey(KeyType key)
    {
        int index = getIndex(key);
        for (Node<KeyType, DataType> iterator = map[index];  iterator != null ; iterator = iterator.next)
        {
            if (iterator.key.equals(key))
            {
                return true;
            }
        }
        return false;
    }

    /** TODO
     * Finds the value attached to a key
     * @param key Key which we want to have its value
     * @return DataType instance attached to key (null if not found)
     */
    public DataType get(KeyType key) {
        int INDEX = getIndex(key);
        if(map[INDEX] == null) {
            return null;
        }
        else{
            Node temp = map[INDEX];
            while(temp!= null){
                if(temp.key.equals(key)) {
                    return (DataType) temp.data;
                }
                temp = temp.next;
            }

        }
        return null;
    }

    /** TODO
     * Assigns a value to a key
     * @param key Key which will have its value assigned or reassigned
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType put(KeyType key, DataType value) {
        if(shouldRehash()){
            rehash();
        }

        DataType cle=get(key);
        Node<KeyType, DataType> head = map[getIndex(key)];

        if(head==null){
            ++size;
            head=new Node<>(key,value);
            map[getIndex(key)] = head;
            return cle;
        }

        while(!head.key.equals(key) && head.next!=null){
            head=head.next;
        }

        if(head.key.equals(key)) {
            head.data = value;
        } else {
            ++size;
            head.next = new Node(key, value);
        }
        return cle;
    }

    private DataType replaceNodeValue(Node<KeyType, DataType> node, DataType value){
        DataType oldValue = node.data;
        node.data = value;
        return oldValue;
    }

    /** TODO
     * Removes the node attached to a key
     * @param key Key which is contained in the node to remove
     * @return Old DataType instance at key (null if none existed)
     */
    public DataType remove(KeyType key)
    {
        int index = getIndex(key);
        for (Node<KeyType, DataType> iterator = map[index]; iterator != null; iterator = iterator.next)
        {
            if (iterator.key.equals(key))
            {
                Node<KeyType, DataType> oldNode = iterator;
                iterator = iterator.next;
                size = size -1;
                return oldNode.data;
            }
        }
        return null;
    }

    /** TODO
     * Removes all nodes contained within the map
     */
    public void clear() {
        Node<KeyType,DataType>[] temp;
        if((temp=map)!=null && size>0){
            size=0;
            for(int i=0;i<temp.length;i++){
                temp[i]=null;
            }
        }
    }


    static class Node<KeyType, DataType> {
        final KeyType key;
        DataType data;
        Node next; // Pointer to the next node within a Linked List

        Node(KeyType key, DataType data)
        {
            this.key = key;
            this.data = data;
            next = null;
        }
    }
}
