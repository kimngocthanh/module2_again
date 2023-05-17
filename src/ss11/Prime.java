package ss11;

import java.util.*;

public class Prime {
    public boolean checkPrime(int n) {
        boolean flag = true;
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        } else {
            for (int i = 2; i < n; i++) {
                flag = true;
                if (n % i == 0) {
                    flag = false;
                    break;
                }
            }if (flag){
                return true;
            }return false;
        }
    }

    public Stack<Integer> stackPrime(int n) {
        Stack<Integer> stack = new Stack<>();
        Prime prime = new Prime();
        for (int i = 2; i < n; i++) {
            if (prime.checkPrime(i)) {
                stack.push(i);
            }
        }
        return stack;
    }

    public Queue<Integer> queuePrime(int n) {
        Queue<Integer> queue = new PriorityQueue<>();
        Prime prime = new Prime();
        for (int i = 2; i < n; i++) {
            if (prime.checkPrime(i)) {
                queue.add(i);
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Prime prime = new Prime();
        System.out.println(prime.stackPrime(n));
        System.out.println(prime.queuePrime(n));

    }


}
