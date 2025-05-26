import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class sliding_window {

    // solving the famous sliding window problem usinga dequeue
    public static ArrayList<Integer> sliding_window1(int[] arr, int k) {
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
    
}
