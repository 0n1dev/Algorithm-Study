import java.util.*;

/*
* Programmer 가장 먼 노드
* BFS로 풀어야 될것으로 보임
* */
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 1;

        Map<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>(); // 그래프
        int[] degree = new int[n + 1];

        boolean[] visited = new boolean[n + 1]; // 방문 여부

        // 그래프 세팅
        for (int i = 1; i <= n; i++) {
            graph.put(i ,new ArrayList<Integer>());
        }
        
        for (int i = 0; i < edge.length; i++) {
            ArrayList<Integer> v1 = graph.get(edge[i][0]);
            ArrayList<Integer> v2 = graph.get(edge[i][1]);

            if (!v1.contains(edge[i][1])) v1.add(edge[i][1]);
            if (!v2.contains(edge[i][0])) v2.add(edge[i][0]);
        }

        Queue<Integer> q = new LinkedList<Integer>();
        
        // 노드 1 부터 시작
        q.offer(1);
        visited[1] = true;
        
        // BFS
        while (!q.isEmpty()) {
            int v = q.poll();

            for (int i : graph.get(v)) {
                if (!visited[i]) {
                    degree[i] = degree[v] + 1;
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }

        // 가장 멀리 있는 노드 개수
        int max = 0;
        for (int i : degree) {
            if (max < i) {
                answer = 1;
                max = i;
            } else if (max == i) {
                answer++;
            }
        }

        return answer;
    }
}