import java.util.Stack;

public class balancedparanthesis {
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
    public static void main(String[] args) {
        
    }
    
}
