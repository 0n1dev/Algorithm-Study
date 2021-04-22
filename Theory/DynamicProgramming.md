# 다이나믹 프로그래밍
---

> 큰 문제를 작은 문제로 나눠서 푸는 알고리즘(동적 계획법)

- DP
    - 큰 문제를 나누었을 때 작은 문제가 중복이 가능
    - 크기를 기준으로 나누어 버리는것
- 분할 정복
    - 큰 문제를 나누었을 때 작은 문제가 절대로 중복이 불가
    - 가운데를 기준으로 왼쪽과 오른쪽

---

- Overlapping Subproblem : 겹치는 부분(작은)문제
- Optimal Substructure : 최적 부분구조(문제의 정답을 작은 문제의 정답에서 구할수 있다.)

## Overlapping Subproblem
---

- 피보나치 수

0, 1, 1, 2, 3, 5, 8, 13 ...

Fn = Fn-1 + Fn-2 (n>=2)

- 큰 문제 => N번 째 피보나치 수를 구하는 것
- 작은 문제 => N-1번 째 피보나치 수를 구하는 문제,  N-2번 째 피보나치 수를 구하는 문제

...

```java
public int fibonacci(int n) {
    if (n <= 1) {
        return n;
    } else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
```

## Optimal Substructure
---

예시)
- 서울에서 부산을 가는 가장 빠른 길이 대전과 대구를 순서대로 거쳐야 한다면
- 대전에서 부산을 가는 가장 빠른 길은 대구를 거쳐야 한다.

---

- 다이나믹 프로그래밍에서 각 문제는 한 번만 풀어야 한다.
- Optimal Substructure를 만족하기 때문에, 같은 문제는 구할 때마다 정답이 같다
- 따라서 정답을 한 번 구했으면, 정답을 어딘가에 메모해놓는다.
- 이런 메모하는 것을 코드의 구현에서는 배열에 저장하는 것으로 할 수 있다.
- Memoization

...

```java
int memo[100];
public int fibonacci(int n) {
    if (n <= 1) {
        return n;
    } else {
        if (memo[n] > 0) {
            return memo[n]
        }

        memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return memo[n]
    }
}
```

# 푸는 방법
---

- Top - down (재귀)
- Bottom - up (반복문)