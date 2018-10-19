package tech.saltyegg.code;

public class QuickSelect {

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 2, 5, 2, 2};
        // find 8th smallest
        int smallest = quickSelect(arr, 0, arr.length - 1, 8);
        System.out.println(smallest);
    }

    public static int quickSelect(int[] arr, int s, int e, int k) {
        if (s == e) return arr[s];
        int pivot = partition(arr, s, e);
        if (pivot == k) {
            return arr[pivot];
        } else if (k < pivot) {
            return quickSelect(arr, s, pivot - 1, k);
        } else {
            return quickSelect(arr, pivot + 1, e, k);
        }
    }

    public static int quickSelectV2(int[] arr, int s, int e, int k) {
        if (s == e) return arr[s];
        while (true) {
            int pivot = partition(arr, s, e);
            if (pivot == k) {
                return arr[pivot];
            } else if (k < pivot) {
                e = pivot - 1;
            } else {
                s = pivot + 1;
            }
        }
    }

    private static int partition(int[] arr, int s, int e) {
        int partitionIndex = s;
        for (int i = s; i <= e - 1; i++) {
            if (arr[i] < arr[e]) {
                swap(arr, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(arr, partitionIndex, e);
        // partitionIndex will be the rearranged pivot
        return partitionIndex;
    }

    private static void swap(int[] arr, int s, int e) {
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }

}