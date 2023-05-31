package test;

import java.util.Arrays;

public class Test {
    public static int[] solution(int[] a) {
        int min;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == -1) {
                continue;
            }
            else {
                min = i;
                for (int j = i + 1; j < a.length; j++)
                    if (a[j] < a[min])
                        min = j;
                if (min != i) {
                    int temp = a[min];
                    a[min] = a[i];
                    a[i] = temp;
                }
            }
        }
        return a;
    }


    public static void main(String[] args) {
        int[] a = {-1, 150, 190, 170, -1, -1, 160, 180};
        Test test = new Test();
        System.out.println(Arrays.toString(test.solution(a)));
    }

}
