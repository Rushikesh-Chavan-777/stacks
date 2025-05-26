import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

//the famous stock spanner class
class Pair {
    int first;
    int second;

    Pair(int data1, int data2) {
        this.first = data1;
        this.second = data2;
    }
}

class StockSpan {
    Stack<Pair> stack = new Stack<>();
    int idx = -1;

    public void StockSpanner() {
        idx = -1;
        while (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int next(int val) {
        while (!stack.isEmpty() && stack.peek().second <= val) {
            stack.pop();
        }
        idx++;
        int last = stack.isEmpty() ? -1 : stack.peek().second;
        stack.push(new Pair(idx, val));
        return idx - last;
    }
}

// solving the famous minstack problem here
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

    // now, working on the successor problem to the earlier, this is the next
    // smaller lelement
    public static int[] prevSmallerElement(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i])
                stack.pop();

            if (stack.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stack.peek();
            stack.push(arr[i]);
        }
        return ans;
    }

    public static Stack<Integer> asteroid_collision(int[] arr) {
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

    public static int[] replace_k(int[] arr, int k) {
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

    // solving the famous sliding window problem usinga dequeue
    public static ArrayList<Integer> sliding_window(int[] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            if (!q.isEmpty() && q.peek() <= i - k) {
                q.removeFirst();
            }
            while (!q.isEmpty() && q.peekLast() < arr[i]) {
                q.pop();
            }
            q.addLast(i);
            if (i >= k - 1) {
                ans.add(arr[q.getFirst()]);
            }
        }
        return ans;
    }

    // Function to find celebrity, returns celebrity index or -1 if no celebrity
    public static int findCelebrity(int[][] M, int n) {
        int candidate = 0;
        //find the potential celebrity
        for (int i = 1; i < n; i++) {
            if (M[candidate][i] == 1) {
                candidate = i; //candidate knows i, so candidate can't be celebrity
            }
        }
        //verify if candidate is actually a celebrity
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                // candidate should not know anyone,and everyone should know candidate
                if (M[candidate][i] == 1 || M[i][candidate] == 0) {
                    return -1;
                }
            }
        }
        return candidate;
    }

 

    public static void main(String[] args) {
    }

}
