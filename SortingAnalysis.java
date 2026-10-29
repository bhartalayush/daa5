import java.util.*;

public class SortingAnalysis
{
    int arr[];
    int n;

    public void arrSeed()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        n = sc.nextInt();

        System.out.print("For Ascending Array, Enter 1. For Descending Array, Enter 2. For Random Array, Enter 3: ");
        int choice = sc.nextInt();

        arr = new int[n];

        for (int i = 0; i < n; i++)
        {
            if (choice == 1)
            {
                arr[i] = i + 1;
            }
            else if (choice == 2)
            {
                arr[i] = n - i;
            }
            else if (choice == 3)
            {
                arr[i] = (int)(Math.random() * n * 10);
            }
            else
            {
                System.out.println("Invalid choice.");
                i--;
            }
        }
    }

    // INSERTION SORT
    public static void insertionSort(int arr[])
    {
        for(int i = 1; i < arr.length; i++)
        {
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // SELECTION SORT
    public static void selectionSort(int arr[])
    {
        for(int i = 0; i < arr.length - 1; i++)
        {
            int min = i;

            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[j] < arr[min])
                    min = j;
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    // BUBBLE SORT
    public static void bubbleSort(int arr[])
    {
        for(int i = 0; i < arr.length - 1; i++)
        {
            for(int j = 0; j < arr.length - i - 1; j++)
            {
                if(arr[j] > arr[j + 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // MERGE SORT
    public static void mergeSort(int arr[], int left, int right)
    {
        if(left < right)
        {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(int arr[], int left, int mid, int right)
    {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for(int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0;
        int j = 0;
        int k = left;

        while(i < n1 && j < n2)
        {
            if(L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while(i < n1)
            arr[k++] = L[i++];

        while(j < n2)
            arr[k++] = R[j++];
    }

    // QUICK SORT
    public static void quickSort(int arr[], int low, int high)
    {
        if(low < high)
        {
            int p = partition(arr, low, high);

            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    public static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = low - 1;

        for(int j = low; j < high; j++)
        {
            if(arr[j] < pivot)
            {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // SHELL SORT
    public static void shellSort(int arr[])
    {
        int n = arr.length;

        for(int gap = n / 2; gap > 0; gap /= 2)
        {
            for(int i = gap; i < n; i++)
            {
                int temp = arr[i];
                int j;

                for(j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                arr[j] = temp;
            }
        }
    }

    // HEAP SORT
    public static void heapSort(int arr[])
    {
        int n = arr.length;

        for(int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for(int i = n - 1; i > 0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < n && arr[left] > arr[largest])
            largest = left;

        if(right < n && arr[right] > arr[largest])
            largest = right;

        if(largest != i)
        {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        while(true)
        {
            SortingAnalysis obj = new SortingAnalysis();

            obj.arrSeed();

            System.out.println("\nOriginal Array:");
            System.out.println(Arrays.toString(obj.arr));

            System.out.println("\n---SORTING MENU ---");
            System.out.println("1. Insertion Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Bubble Sort");
            System.out.println("4. Merge Sort");
            System.out.println("5. Quick Sort");
            System.out.println("6. Shell Sort");
            System.out.println("7. Heap Sort");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            if(choice == 8)
            {
                System.out.println("Program Exited.");
                break;
            }

            long startTime = System.nanoTime();

            switch(choice)
            {
                case 1:
                    insertionSort(obj.arr);
                    break;

                case 2:
                    selectionSort(obj.arr);
                    break;

                case 3:
                    bubbleSort(obj.arr);
                    break;

                case 4:
                    mergeSort(obj.arr, 0, obj.arr.length - 1);
                    break;

                case 5:
                    quickSort(obj.arr, 0, obj.arr.length - 1);
                    break;

                case 6:
                    shellSort(obj.arr);
                    break;

                case 7:
                    heapSort(obj.arr);
                    break;

                default:
                    System.out.println("Invalid Choice!");
                    continue;
            }

            long endTime = System.nanoTime();

            System.out.println("\nSorted Array:");
            System.out.println(Arrays.toString(obj.arr));

            System.out.println("Execution Time: " + (endTime - startTime) + " nanoseconds\n");
        }

        sc.close();
    }
}