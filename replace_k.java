import java.util.Stack;

public class replace_k {
        public static int[] replace_k1(int[] arr, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && k > 0 && arr[i] <= stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(arr[i]);
        }
        // If still k > 0, remove from end
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        // If empty, return [0]
        if (stack.isEmpty()) {
            return new int[] { 0 };
        }
        // Convert stack to array (in order)
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
    
}
