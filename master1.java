import java.util.Stack;

//solving the famous minstack problem here 
class MinStack {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void push(Integer it) {
        if (stack.isEmpty()) {
            min = it;
            stack.push(it);
        } else {
            if (it < min) {
                stack.push((2 * it - min));
                min = it;
            } else {
                stack.push(it);
            }
        }
    }

    public void pop() {
        if (stack.peek() < min) {
            min = 2 * min - stack.peek();
        }
        stack.pop();
    }

    public int getMin() {
        return min;
    }
}

public class master1 {

    // trying to solve the famous balanced paranthesis problem using stacks
    public static boolean balancedparanthesis(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                if ((c == '(' && stack.peek() == ')') || (c == '[' && stack.peek() == ']')
                        || (c == '{' && stack.peek() == '}')) {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

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
