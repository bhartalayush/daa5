import java.util.*;

class Master
{
    static int binary(int a[], int l, int r, int x)
    {
        if(l > r)
            return -1;

        int m = (l + r) / 2;

        if(a[m] == x)
            return m;

        if(x < a[m])
            return binary(a, l, m - 1, x);

        return binary(a, m + 1, r, x);
    }

    static void merge(int a[], int l, int m, int r)
    {
        int b[] = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while(i <= m && j <= r)
        {
            if(a[i] < a[j])
                b[k++] = a[i++];
            else
                b[k++] = a[j++];
        }

        while(i <= m)
            b[k++] = a[i++];

        while(j <= r)
            b[k++] = a[j++];

        for(i = 0; i < b.length; i++)
            a[l + i] = b[i];
    }

    static void sort(int a[], int l, int r)
    {
        if(l >= r)
            return;

        int m = (l + r) / 2;

        sort(a, l, m);
        sort(a, m + 1, r);
        merge(a, l, m, r);
    }

    static int fact(int n)
    {
        if(n <= 1)
            return 1;

        return n * fact(n - 1);
    }

    static int fsum(int n)
    {
        if(n == 0)
            return 0;

        return fact(n) + fsum(n - 1);
    }

    static int fib(int n)
    {
        if(n <= 1)
            return n;

        return fib(n - 1) + fib(n - 2);
    }

    static int fibsum(int n)
    {
        if(n == 0)
            return 0;

        return fib(n) + fibsum(n - 1);
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int a[] = {10, 20, 30, 40, 50, 60, 70};

        System.out.print("Enter element for Binary Search: ");
        int x = sc.nextInt();

        int p = binary(a, 0, a.length - 1, x);

        if(p == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index " + p);

        int b[] = {50, 20, 40, 10, 30, 60};

        sort(b, 0, b.length - 1);

        System.out.println("Merge Sort:");
        for(int i = 0; i < b.length; i++)
            System.out.print(b[i] + " ");

        System.out.println();

        System.out.print("Enter n for Factorial Sum: ");
        int n = sc.nextInt();
        System.out.println("Sum of factorials = " + fsum(n));

        System.out.print("Enter n for Fibonacci Sum: ");
        n = sc.nextInt();
        System.out.println("Sum of Fibonacci numbers = " + fibsum(n));
    }
}