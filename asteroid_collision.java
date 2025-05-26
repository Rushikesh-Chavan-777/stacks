import java.util.Stack;

public class asteroid_collision {
        public static Stack<Integer> asteroid_collision1(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(arr[i]) > stack.peek()) {
                    stack.pop();
                }
                if (!stack.isEmpty() && Math.abs(arr[i]) == stack.peek()) {
                    stack.pop();
                } else if (stack.isEmpty()) {
                    stack.push(arr[i]);
                }
            }
        }
        return stack;
    }
}