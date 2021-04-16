import java.util.*;

/*
 * 207. Course Schedule
 * 위상 정렬 (Topological Sort)
 * 1. 그래프에 Courses 등록
 * 2. 선행 코스 등록
 * 3. 위상 정렬 동작
 *
 * O(N^2) 4ms 39.1mb
 * */
public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        int[] degree = new int[numCourses];

        // 1. 그래프에 Courses 등록
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<Integer>());
        }

        // 2. 선행 코스 등록
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
            degree[prerequisites[i][1]]++;
        }


        return topologicalSort(graph, degree);
    }

    private boolean topologicalSort(Map<Integer, ArrayList<Integer>> graph, int[] degree) {
        Queue<Integer> q = new LinkedList<Integer>();

        int n = graph.size(); // 정점의 수

        // 선행 코스를 가지지 않는 코스를 큐에 삽입
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                q.offer(i);
            }
        }

        // 큐가 빌때까지
        while (!q.isEmpty()) {
            int v = q.poll();
            n--;

            for (int i : graph.get(v)) {
                degree[i]--;

                if (degree[i] == 0) {
                    q.offer(i);
                }
            }
        }
        return n == 0;
    }
}
