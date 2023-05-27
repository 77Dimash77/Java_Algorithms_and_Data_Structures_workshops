public class SM1and2DZ {
        public static void piramidnayaSortirovka(int[] arr) {
            int n = arr.length;
            for (int i = n / 2 - 1; i >= 0; i--) {
                piramidalnoeUporyadochenie(arr, n, i);
            }
            for (int i = n - 1; i >= 0; i--) {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                piramidalnoeUporyadochenie(arr, i, 0);
            }
        }

        public static void piramidalnoeUporyadochenie(int[] arr, int n, int i) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < n && arr[left] > arr[largest]) {
                largest = left;
            }
            if (right < n && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != i) {
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;
                piramidalnoeUporyadochenie(arr, n, largest);
            }
        }

        public static void main(String[] args) {
            int[] arr = { 12, 11, 13, 5, 6, 7 };
            System.out.println("Исходный массив:");
            pechatMassiva(arr);
            piramidnayaSortirovka(arr);
            System.out.println("Отсортированный массив:");
            pechatMassiva(arr);
        }

        public static void pechatMassiva(int[] arr) {
            for (int i = 0; i < arr.length; ++i) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
