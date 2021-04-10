# Heap
---

- **완전 이진 트리 일종** 우선 순위 큐를 위하여 만들어진 자료구조
- 여러 개의 값들 중 최댓 값 or 최솟 값을 빠르게 찾아 내기 위한 자료구조
- **반 정렬 상태(느슨한 정렬 상태)**

## Heap 종류
---

- 최대 힙
    - 부모 노드 >= 자식 노드
    - Java에서 PriorityQueue<E>();
- 최소 힙
    - 부모 노드 <= 자식 노드
    - Java에서 PriorityQueue<Integer>(Collections.reverseOrder());

-> 자바에서 우선순위 큐를 이용하면 쉽게 구현 할 수 있다.
