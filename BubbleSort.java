public class BubbleSort {

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public int[] sort(int[] array, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j + 1] < array[j])
                    swap(array, j, j + 1);
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {5, 4, 1, 22, 89, 500, 3, 6};
        BubbleSort bubbleSort = new BubbleSort();
        for (int a : bubbleSort.sort(array, array.length)) {
            System.out.println(a);
        }
    }
}
