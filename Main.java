import java.util.*;

class Main
{
    static int a[][] = {
        {0, 2, 3, 0},
        {2, 0, 1, 4},
        {3, 1, 0, 5},
        {0, 4, 5, 0}
    };

    static int n = 4;

    // prim's algorithm: find minimum spanning tree
    static void prim()
    {
        int key[] = {0, 99999, 99999, 99999};
        int parent[] = {-1, -1, -1, -1};
        boolean used[] = new boolean[n];
        int total = 0;

        for (int i = 0; i < n; i++)
        {
            int u = -1;

            for (int j = 0; j < n; j++)
                if (!used[j] &&
                    (u == -1 || key[j] < key[u]))
                    u = j;

            used[u] = true;

            for (int v = 0; v < n; v++)
            {
                if (a[u][v] != 0 && !used[v] &&
                    a[u][v] < key[v])
                {
                    key[v] = a[u][v];
                    parent[v] = u;
                }
            }
        }

        for (int i = 1; i < n; i++)
        {
            System.out.println(parent[i] + " - " + i);
            total += key[i];
        }

        System.out.println("prim cost: " + total);
    }

    // kruskal's algorithm: sort edges and avoid cycles
    static int find(int p[], int x)
    {
        if (p[x] != x)
            p[x] = find(p, p[x]);

        return p[x];
    }

    static void kruskal()
    {
        int e[][] = {
            {0, 1, 2},
            {0, 2, 3},
            {1, 2, 1},
            {1, 3, 4},
            {2, 3, 5}
        };

        Arrays.sort(e, (x, y) ->
            Integer.compare(x[2], y[2]));

        int p[] = {0, 1, 2, 3};
        int total = 0, count = 0;

        for (int i = 0; i < e.length; i++)
        {
            int x = find(p, e[i][0]);
            int y = find(p, e[i][1]);

            if (x != y)
            {
                p[x] = y;
                total += e[i][2];
                count++;

                System.out.println(e[i][0] + " - " + e[i][1]);
            }

            if (count == n - 1)
                break;
        }

        System.out.println("kruskal cost: " + total);
    }

    // dijkstra's algorithm: shortest distance from vertex 0
    static void dijkstra()
    {
        int d[] = {0, 99999, 99999, 99999};
        boolean used[] = new boolean[n];

        for (int i = 0; i < n; i++)
        {
            int u = -1;

            for (int j = 0; j < n; j++)
                if (!used[j] &&
                    (u == -1 || d[j] < d[u]))
                    u = j;

            if (u == -1 || d[u] == 99999)
                break;

            used[u] = true;

            for (int v = 0; v < n; v++)
            {
                if (a[u][v] != 0 && !used[v] &&
                    d[u] + a[u][v] < d[v])
                {
                    d[v] = d[u] + a[u][v];
                }
            }
        }

        for (int i = 0; i < n; i++)
            System.out.println(i + " : " + d[i]);
    }

    public static void main(String[] args)
    {
        System.out.println("prim:");
        prim();

        System.out.println("\nkruskal:");
        kruskal();

        System.out.println("\ndijkstra:");
        dijkstra();
    }
}
