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


public class minstack {
    
}
