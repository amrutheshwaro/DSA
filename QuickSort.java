public class QuickSort {

    public void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int i = left, j = right;
        while (i < j) {
            while (pivot >= array[i]) i++;
            while (array[j] > pivot) j--;
            if (i < j) {
                swap(array, i, j);
            }
        }
        swap(array, left, j);
        return j;
    }

    public int[] sort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            sort(array, left, pivot - 1);
            sort(array, pivot + 1, right);
        }
        return array;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = {5, 4, 1, 22, 89, 500, 3, 6};
        for (int a : quickSort.sort(array, 0, array.length - 1)) {
            System.out.println(a);
        }
    }
}