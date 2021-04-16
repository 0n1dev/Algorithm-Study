# Graph
---

> 그래프는 정점(Vertex)간의 관계를 표현하는 자료구조

지하철 노선도를 생각하면 기억하기 쉽다.

## 그래프와 트리의 차이
---

|그래프|트리|
|---|---|
|노드와 노드를 연결하는 간선(edge)을 하나로 모아 놓은 자료구조|그래프의 한 종류 <br> Directed Acyclic Graph(방향성 있는 비순환 그래프)의 한 종류|
|- 방향 그래프 <br> - 무방향 그래프|- 방향 그래프|
|- 사이클 가능 <br> - self-loop 가능 <br> - 순환, 비순환 모두 존재|- 사이클 불가능 <br> - self-loop 불가능 <br> - 비순환 그래프|
|- 루트 노드 개념이 없음|- 한 개의 루트 노드만 존재|
|- 부모-자식 개념이 없음|- 부모-자식 개념이 있음 <br> - 자식은 1개의 부모를 가질수 있음|
|- 네트워크 모델|- 계층모델|
|- 그래프에 따라 간선의 수가 다름(없을수도 있음)|- 노드가 N인 트리는 N-1의 간선을 가짐|

## 자바에서 그래프를 표현하는 방법
---

- Adjacency Matrix
    - 2차원 배열로 인접하지 않는건 0 인접하는건 1로 표현
- Adjacency List
    - 리스트로 인접하는 노드를 저장

```java
import java.util.LinkedList;

public class MyGraph {
    class Node {
        int data;
        LinkedList<Node> adjacent; // 인접 노드
        boolean marked; // 방문했는지 확인

        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }

    Node[] nodes;
    MyGraph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1]; // 데이터가 index와 동일해서 인덱스로 사용
        Node n2 = nodes[i2];

        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }

        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }
}
```

# 그래프에서 BFS, DFS
---

- BFS - QUEUE 사용
    - 시작 노드를 Queue에 넣음
    - Queue에서 꺼내서 자식들 Queue 에 추가 (추가 시 이미 한번 들어갔던 노드는 X)
    - 반복
- DFS - STACK 사용
    - 시작 노드를 Stack에 넣음
    - Stack에서 꺼내서 자식들을 Stack에 추가 (추가 시 이미 한번 들어갔던 노드는 X)