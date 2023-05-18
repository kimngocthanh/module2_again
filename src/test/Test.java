package test;

public class Test {
    public static boolean solution(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int j = 0; j < i; j++) {
                sumLeft += arr[j];

            }
            for (int j = i + 1; j < n; j++) {
                sumRight += arr[j];
            }
            if (sumLeft == sumRight) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3};
        Test test = new Test();
        System.out.println(test.solution(a));
    }

}
