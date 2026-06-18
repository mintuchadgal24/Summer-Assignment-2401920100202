class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int m = temperatures.length;
        int[] answer = new int[m];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }
        return answer;
    }
}
