# 배열
---

- 논리적 순서와 물리적 순서가 같음
- 인덱스(index)를 통해 데이터에 접근 가능
- 크기가 고정되어 있음
- 데이터 삽입/삭제에 대한 비용이 있음

---

- Access : O(1)
- Search : O(n)
- Insert/Delete : O(n)

---

# Array-169 Majority Element
---

```
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
```

## 내 풀이 방식
---

1. 배열을 오름차순으로 정렬
2. 각 요소를 반복하여 이전 요소와 같으면 계속해서 카운트를 증가시키고 다르면 이전 요소의 개수가 저장된 Max 요소와 비교 후 Max 요소 갱신

## 더 나은 풀이 방식
---

1. 배열을 오름차순으로 정렬
2. 가운데 있는 요소를 출력

-> 해당 방법이 가능한 이유가 가장 많은 개수의 요소는 배열의 크기의 절반보다 많다고 나와있다.

# Array-283 Move Zeroes
---

```
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
```

## 내 풀이 방식
---

1. 배열의 요소가 0이면 해당 요소는 가장 뒤로 보내고 나머지 요소를 한칸씩 당긴다.
2. 해당 반복은 배열의 사이즈 만큼 반복된다.

## 더 나은 풀이 방식
---

1. 배열의 요소가 0이 아니면 다른 배열에 순서대로 저장
2. 남은 사이즈 만큼 0으로 채움

# Array-448 Find All Numbers Disappeared in an Array

```
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
```

## 내 풀이 방식
---

1. 배열을 정렬한다.
2. 배열의 크기가 0보다 작거나 같으면 빈 List 리턴
3. 배열의 길이 만큼 반복
4. Arrays.binarySearch를 사용해서 배열 내에 특정 값이 있는지 확인

다른 언어에서는 indexOf를 사용했겠지만 자바에서는 어떤걸 사용하는지 몰랐다. 찾아보니 Arrays.binarySearch가 있었다.