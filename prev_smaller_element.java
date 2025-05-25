import java.util.Stack;

public class prev_smaller_element {

        //now, working on the successor problem to the earlier, this is the next smaller lelement 
    public static int[] prevSmallerElement(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < arr.length; i ++) {
            while(!stack.isEmpty() && stack.peek() >= arr[i]) stack.pop();
            
            if(stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();
            stack.push(arr[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
