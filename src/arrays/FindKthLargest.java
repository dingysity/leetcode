package arrays;

/**
 * @author dingyehang
 * @date 2022/5/18 11:01
 **/
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, i);
        }
        int heapSize = nums.length;
        for (int index = nums.length - 1; index >= nums.length - k + 1; index--) {
            swap(nums, 0, index);
            --heapSize;
            heapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void heapify(int[] a, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && a[left] < a[left + 1] ? left + 1 : left;
            largest = a[index] < a[largest] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(a, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public void heapInsert(int[] a, int index) {
        while (a[index] > a[(index - 1) / 2]) {
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
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] nums = {1, 3, 2, 5, 4, 7, 8, 6};
        int kth = findKthLargest.findKthLargest(nums, 4);
        System.out.println("the k is: " + kth);
        for (int num : nums) {
            System.out.print(num);
            System.out.print(" ");
        }
    }
}
