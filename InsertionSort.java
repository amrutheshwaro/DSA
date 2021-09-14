public class InsertionSort {

    public int[] sort(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {5, 4, 1, 22, 89, 500, 3, 6};
        InsertionSort insertionSort = new InsertionSort();
        for (int a : insertionSort.sort(array, array.length)) {
            System.out.println(a);
        }
    }
}
