public class celebrity_problem {
    // Function to find celebrity, returns celebrity index or -1 if no celebrity
    public static int findCelebrity(int[][] M, int n) {
        int candidate = 0;
        // find the potential celebrity
        for (int i = 1; i < n; i++) {
            if (M[candidate][i] == 1) {
                candidate = i; // candidate knows i, so candidate can't be celebrity
            }
        }
        // verify if candidate is actually a celebrity
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

}
