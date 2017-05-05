import java.util.Hashtable;
public class FIFO
{
    Node head;
    int capacity;
    Hashtable<Integer, Node> ht1 = new Hashtable<Integer, Node>();
    int cacheMiss;
    public FIFO(int size)
    {
        this.capacity = size;
        this.head = null;
        this.cacheMiss = 0;
    }
    public int get(int key)
    {
        if (this.ht1.containsKey(key))
        {
            Node selectedNode = this.ht1.get(key);
            return selectedNode.v;
        }
        else
        {
            this.cacheMiss += 1;
            this.put(key, 1);
            Node selectedNode = this.ht1.get(key);
            return selectedNode.v;
        }
    }
    public int getCacheMisses()
    {
        return this.cacheMiss;
    }
    public void put(int key, int value)
    {
        if (this.ht1.size() > this.capacity)
        {
            this.ht1.remove(this.head.k);
            this.remove();
            Node targetNode = new Node(key, value);
            ht1.put(key, targetNode);
            this.add(targetNode);
            return;
        }
        
        else
        {
            Node targetNode = new Node(key, value);
            this.add(targetNode);
            ht1.put(key, targetNode);
            return;
        }
    }
    
    public void add(Node element)
    {
        if (this.head == null)
        {
            this.head = element;
            this.head.forward = null;
            return;
        }
        
        Node pointer = this.head;
        while (pointer.forward != null)
        {
            pointer = pointer.forward;
        }
        pointer.forward = element;
        pointer.forward.forward = null;
        
        return;
    }
    
    public void remove()
    {
        this.head = this.head.forward;
        return;
    }
}