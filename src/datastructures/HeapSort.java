package datastructures;

/**
 * 堆排序
 *
 * @author dingyehang
 * @date 2022/5/18 10:25
 **/
public class HeapSort {

    public void sort(int[] nums){
        if (nums == null || nums.length < 2){
            return;
        }
        int heapSize = nums.length;
        for (int i = 0; i < heapSize; i++) {
            heapInsert(nums, i);
        }
        swap(nums, 0, --heapSize);
        while (heapSize > 0){
            heapify(nums, 0, heapSize);
            swap(nums, 0, --heapSize);
        }
    }

    public void heapify(int[] a, int index, int heapSize){
        int left = index * 2 + 1;
        while (left < heapSize){
            int largest = left + 1 < heapSize && a[left] < a[left + 1] ? left + 1: left;
            largest = a[index] < a[largest] ? largest : index;
            if (largest == index){
                break;
            }
            swap(a, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public void heapInsert(int[] a, int index){
        while (a[index] > a[(index - 1) / 2]){
            swap(a, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] nums = {1,3,2,5,4,7,8,6};
        heapSort.sort(nums);
        for (int num: nums){
            System.out.print(num);
            System.out.print(" ");
        }
    }
}
