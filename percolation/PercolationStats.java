import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double CONFIDENCE_95_THRESHOLD = 1.96;

    private final double[] fractions;
    private final int trials;

    public PercolationStats(int n, int t)
    {
        if(n<=0 || t<=0)
        {
            throw new IllegalArgumentException("Illegal Operation,n and t should be greater than 0");
        }
        trials = t;
        fractions = new double[trials];


        for (int i=0; i<trials; i++)
        {
            int opensites = 0;
            Percolation percolation = new Percolation(n);
            while(!percolation.percolates())
            {
                int row = StdRandom.uniformInt(1, n+1);
                int col = StdRandom.uniformInt(1,n+1);

                if(!percolation.isOpen(row,col))
                {
                    percolation.open(row, col);
                    opensites ++;
                }


            }
            fractions[i] = (double) opensites/(n*n);
        }


    }
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);      // input file
        int t = Integer.parseInt(args[1]);

        PercolationStats ps = new PercolationStats(n,t);

        String confidence = ps.confidenceLo() + ", " + ps.confidenceHi();
        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = " + confidence);


    }

    public double confidenceHi(){
        return mean() + ((CONFIDENCE_95_THRESHOLD * stddev())/Math.sqrt(trials));
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo()
    {
        return mean() - ((CONFIDENCE_95_THRESHOLD * stddev())/Math.sqrt(trials));
    }

    // sample mean of percolation threshold
    public double mean(){
        return StdStats.mean(fractions);
    }

    // sample standard deviation of percolation threshold
    public double stddev()
    {
        return StdStats.stddev(fractions);
    }
}
