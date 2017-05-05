import java.util.Random;
import java.util.Arrays;
public class Test
{

    public int[] generateString(int length)
    {
        int[] result = new int[length];
        Random rand = new Random();
        for (int i = 0 ; i < length; i++)
        {
            result[i] = rand.nextInt(10) + 1;
        }
        System.out.println(Arrays.toString(result));
        
        return result;
    }
    
    public static void main(String[] args)
    {   
        Test t1 = new Test();
        LRU l1 = new LRU(5);
        FIFO f1 = new FIFO(5);
        Node n1 = new Node(1, 1);
        int[] input = t1.generateString(100);
        for (int i = 0; i < input.length; i++)
        {
            l1.get(input[i]);
            f1.get(input[i]);
        }
        System.out.println(l1.getCacheMisses());
        System.out.println(f1.getCacheMisses());
        
    }
}