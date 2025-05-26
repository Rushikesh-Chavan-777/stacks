import java.util.Stack;

public class largest_rectangle {
    // now, lets solve the problem of the largest rectangle in ahistorgram
    // using iterating over hisrogram using a stak that stores indexes. cuu element
    // will compare to stack and see if next is smallest or not
    // nse and pse using a simple traversal basically
    public static int largestRectangleArea(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int height = arr[stack.pop()];
                int rightBoundary = i;
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                int width = rightBoundary - leftBoundary - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }

        // Final cleanup: process remaining bars in stack
        while (!stack.isEmpty()) {
            int height = arr[stack.pop()];
            int rightBoundary = n;
            int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
            int width = rightBoundary - leftBoundary - 1;
            max = Math.max(max, height * width);
        }

        return max;
    }

}
