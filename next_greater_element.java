import java.util.Stack;

public class next_greater_element {
        // now, lets implement next greater element
    public static int[] nextGreaterELement(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // check if the stack became empty
            if (stack.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stack.peek();

            stack.push(arr[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
