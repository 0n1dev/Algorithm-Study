# Queue

큐는 FIFO(First In First Out) 형태로 한쪽에서 삽입 다른 한쪽에서 삭제가 이루어지는 형태의 자료구조

- Search : O(n)
- Insert/Delete : O(1)

## 예시

---

```java
class Queue<T> {

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first; // 큐는 앞/뒤 모두를 알고있어야 함
    private Node<T> last;

    public void add(T item) {
        Node<T> t = new Node<T>(item);

        if (last != null) {
            last.next = t;
        }

        last = t;

        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        T data = first.data;
        first = first.next;

        if (first == null) {
            last = null;
        }

        return data;
    }

    public T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
```