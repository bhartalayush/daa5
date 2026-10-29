class Kar
{
    // Recursively multiplies two numbers using Karatsuba
    static long karatsuba(long x, long y)
    {
        // If either number is a single digit, multiply directly
        if (x < 10 || y < 10)
            return x * y;

        // Find the number of digits and the splitting position
        int n = Math.max(
            Long.toString(x).length(),
            Long.toString(y).length()
        );

        int m = n / 2;
        long p = (long) Math.pow(10, m);

        // Split x into a,b and y into c,d
        long a = x / p, b = x % p;
        long c = y / p, d = y % p;

        // Calculate the three smaller products recursively
        long ac = karatsuba(a, c);
        long bd = karatsuba(b, d);
        long abcd = karatsuba(a + b, c + d);

        // Combine the three products to get the final answer
        return ac * p * p
             + (abcd - ac - bd) * p
             + bd;
    }

    public static void main(String[] args)
    {
        // Hardcoded example: multiply 1234 by 1234
        System.out.println(karatsuba(1234, 1234));
    }
}