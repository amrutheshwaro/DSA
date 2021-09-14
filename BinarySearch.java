public class BinarySearch {

    public int searchRecursive(int[] array, int key, int left, int right) {
        int mid = left + (right - left) / 2;
        if (key == array[mid])
            return mid + 1;
        if (left < right) {
            if (key < array[mid])
                return searchRecursive(array, key, left, mid);
            else
                return searchRecursive(array, key, mid + 1, right);
        }
        return -1;
    }

    public int searchIterative(int[] array, int key, int left, int right) {
        while(left <= right) {
            int mid = left + (right - left)/2;
            if (key == array[mid])
                return mid + 1;
            if (key < array[mid])
                right = mid;
            else
                left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = {5, 4, 1, 22, 89, 500, 3, 6 };
        System.out.println("Recursive Binary Search");
        int key1 = 4;
        int res1 = binarySearch.searchRecursive(array, key1, 0, array.length - 1);
        System.out.println((res1 == -1) ? "Key " + key1 + " not found" : "Key " + key1 + " found at position " + res1);
        System.out.println("Iterative Binary Search");
        int key2 = 500;
        int res2 = binarySearch.searchIterative(array, key2, 0, array.length - 1);
        System.out.println((res2 == -1) ? "Key " + key2 + " not found" : "Key " + key2 + " found at position " + res2);
    }
}
