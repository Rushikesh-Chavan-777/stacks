import java.util.Stack;

public class nextGreaterElement2 {

    // now, in continuation to the previous function, we contunue the next greater
    // lement problem, here assuming a curcular array
    // best thng to do is Hypothetically assume tha rray was doubled in size whith
    // next half elements being equal to first half
    public static int[] nextGreaterELement2(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        for (int i = arr.length * 2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i % n]) {
                stack.pop();
            }

            if (i < n) {
                if (stack.isEmpty())
                    ans[i] = -1;
                ans[i] = stack.peek();
            } else {
                stack.push(arr[i % n]);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }

}
