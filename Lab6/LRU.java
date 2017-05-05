import java.util.Hashtable;
public class LRU
{
    Hashtable<Integer, Node> ht = new Hashtable<Integer, Node>();
    Node head;
    Node tail;
    int capacity;
    int cacheMiss;
    
    public LRU(int size)
    {
        this.capacity = size;
        this.cacheMiss = 0;
        this.head = null;
        this.tail = null;
    }
    
    public int get(int key)
    {
        if (ht.containsKey(key))
        {
            Node selectedNode = ht.get(key);
            this.remove(selectedNode);
            this.addHead(selectedNode);
            return selectedNode.v;
        
        }
        
        else
        {
            this.cacheMiss += 1;
            put(key, 1);
            Node selectedNode = ht.get(key);
            return selectedNode.v;
        }
        
    }
    public int getCacheMisses()
    {
        return this.cacheMiss;
    }
    public void remove(Node element)
    {
        if (element.back == null)
        {
            this.head = element.forward;
        }
        
        else
        {
            element.back.forward = element.forward;
        }
        if (element.forward == null)
        {
            this.tail = element.back;
        }
        else
        {
            element.forward.back = element.back;
        }
        
       
    }
    
    public void addHead(Node element)
    {
        element.forward = this.head;
        element.back = null;
        if (this.head != null)
        {
            this.head.back = element;
        }
        
        this.head = element;
        
        if (this.tail == null)
        {
            this.tail = head;
        }
             
    }
    
    public void put(int k, int v)
    {
        Node newNode = new Node(k, v);
        if (ht.size() == this.capacity)
        {
            this.ht.remove(this.tail.k);
            this.remove(this.tail);
        }
        this.addHead(newNode);
        ht.put(k, newNode);
        
    }
}