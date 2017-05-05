public class Node
{
    int k;
    int v;
    Node back;
    Node forward;
    
    public Node(int k, int v)
    {
        this.k = k;
        this.v = v;
        this.back = null;
        this.forward = null;
    }
}