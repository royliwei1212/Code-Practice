package tech.saltyegg.java;

import java.util.Arrays;

public class HeapSort {

    private static int[] arr = {16, 7, 3, 20, 17, 8};

    public static void main(String[] args) {
        buildHeap();//建立大顶堆并排序
        System.out.println("排序好的为：" + Arrays.toString(arr));
    }

    private static void buildHeap() {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) { //建立大顶堆
            sortHeap(i, len);
        }
        System.out.println("建立好的大顶堆例如以下：" + Arrays.toString(arr));
        for (int j = len - 1; j > 0; j--) { //对大顶堆进行排序
            swap(0, j);
            sortHeap(0, j);
        }
    }

    private static void sortHeap(int i, int len) {
        int left = 2 * i + 1;         //定义左节点
        int right = 2 * i + 2;        //定义右节点
        int large = 0;                //存放三个节点中最大节点的下标
        if (len > left && arr[left] > arr[i]) {   //假设左孩子大于根节点 将左孩子下标赋值给large
            large = left;
        } else {                                             //否之。将根节点下标赋值给large
            large = i;
        }

        if (len > right && arr[right] > arr[large]) {
            large = right;                                //若右孩子节点大于根节点，把右孩子节点下标赋值给large
        }

        if (large != i) { //若最大节点的下标不等于根节点的下标时，交换其值
            swap(large, i);
            sortHeap(large, len);
        }
    }

    //交换相应下标值
    private static void swap(int m, int n) {
        int temp;
        temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }
}