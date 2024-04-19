import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class RedeSocial {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
        while(!StdIn.isEmpty()){
            int n1 = StdIn.readInt();
            int n2 = StdIn.readInt();
            if(uf.find(n1) != uf.find(n2)){
                uf.union(n1, n2);
            }
            String data_hora = StdIn.readString();

            if(uf.count() == 1){
                StdOut.println("All members were connected at: " + data_hora + " pm");
                break;
            }

        }
    }
}
