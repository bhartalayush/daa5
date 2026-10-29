class FloydW
{
    public static void main(String[] args)
    {
        // Graph with 4 vertices; 99999 means no direct edge
        int a[][] = {
            {0, 5, 99999, 10},
            {99999, 0, 3, 99999},
            {99999, 99999, 0, 1},
            {99999, 99999, 99999, 0}
        };

        int n = 4; // Number of vertices

        // Try every vertex k as an intermediate vertex
        for (int k = 0; k < n; k++)
        {
            // i is the starting vertex
            for (int i = 0; i < n; i++)
            {
                // j is the destination vertex
                for (int j = 0; j < n; j++)
                {
                    // Check that both parts of the path exist
                    if (a[i][k] != 99999 &&
                        a[k][j] != 99999)
                    {
                        // Update distance if going through k is shorter
                        a[i][j] = Math.min(a[i][j],
                            a[i][k] + a[k][j]);
                    }
                }
            }
        }

        // Print shortest distances between all pairs of vertices
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
                System.out.print(a[i][j] + " ");

            System.out.println();
        }
    }
}