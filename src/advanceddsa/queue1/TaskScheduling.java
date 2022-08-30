package advanceddsa.queue1;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Problem Description
 * A CPU has N tasks to be performed. It is to be noted that the tasks have to be completed in a specific order to avoid deadlock. In every clock cycle, the CPU can either perform a task or move it to the back of the queue. You are given the current state of the scheduler queue in array A and the required order of the tasks in array B.
 * <p>
 * Determine the minimum number of clock cycles to complete all the tasks.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 1000
 * 1 <= A[i], B[i] <= N
 * <p>
 * <p>
 * Input Format
 * First argument consist of integer array A.
 * Second argument consist of integer array B.
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the minimum number of clock cycles required to complete all the tasks.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [2, 3, 1, 5, 4]
 * B = [1, 3, 5, 4, 2]
 * Input 2:
 * <p>
 * A = [1]
 * B = [1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 10
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * According to the order array B task 1 has to be performed first, so the CPU will move tasks 2 and 3 to the end of the queue (in 2 clock cycles).
 * Total clock cycles till now = 2
 * Now CPU will perform task 1.
 * Total clock cycles till now = 3
 * Now, queue becomes [5, 4, 2, 3]
 * Now, CPU has to perform task 3. So it moves tasks 5, 4, and 2 to the back one-by-one.
 * Total clock cycles till now = 6
 * Now all the tasks in the queue are as in the required order so the CPU will perform them one-by-one.
 * Total clock cycles = 10
 * Explanation 2:
 * <p>
 * Directly task 1 is completed.
 */
public class TaskScheduling {

    public static int solve(int[] A, int[] B) {

        int numOfCycles = 0;

        // build queue for input tasks list.
        Queue<Integer> queue = new LinkedList<>();
        for (int num : A) {
            queue.offer(num);
        }

        // check for order of task in array B
        for (int order : B) {
            while (!queue.isEmpty() && queue.peek() != order) {
                int task = queue.remove();
                queue.offer(task);
                // increment no of cycles as we are moving task to the end of the queue.
                numOfCycles++;
            }

            // as we reach the task which we have to execute, remove it from the queue and increment no of cycles
            queue.remove();
            numOfCycles++;
        }
        return numOfCycles;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 1, 5, 4};
        int[] B = {1, 3, 5, 4, 2};
        System.out.println(solve(A, B));
    }
}
