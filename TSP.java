public class TSP
{
    static int[][] a = {
        {0, 10, 15, 20},
        {10, 0, 35, 25},
        {15, 35, 0, 30},
        {20, 25, 30, 0}
    };

    static int min = 9999;
    static int n = 4;

    // try all possible tours
    static void tsp(int city, int count, int cost, boolean[] v)
    {
        if (count == n)
        {
            min = Math.min(min, cost + a[city][0]);
            return;
        }

        for (int i = 1; i < n; i++)
        {
            if (!v[i])
            {
                v[i] = true;
                tsp(i, count + 1, cost + a[city][i], v);
                v[i] = false;
            }
        }
    }

    public static void main(String[] args)
    {
        boolean[] v = new boolean[n];
        v[0] = true;

        tsp(0, 1, 0, v);

        System.out.println("minimum cost: " + min);
    }
}
