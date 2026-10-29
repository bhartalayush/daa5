
public class Job
{
    public static void main(String[] args)
    {
        int[] p = {100, 19, 27, 25, 15};
        int[] d = {2, 1, 2, 1, 3};
        int n = p.length;

        // sort jobs by profit
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (p[i] < p[j])
                {
                    int t = p[i]; p[i] = p[j]; p[j] = t;
                    t = d[i]; d[i] = d[j]; d[j] = t;
                }
            }
        }

        int[] slot = new int[n + 1];
        int total = 0;

        // schedule each job in the latest free slot
        for (int i = 0; i < n; i++)
        {
            for (int j = d[i]; j > 0; j--)
            {
                if (slot[j] == 0)
                {
                    slot[j] = p[i];
                    total += p[i];
                    break;
                }
            }
        }

        System.out.println("total profit: " + total);
    }
}
