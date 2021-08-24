import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
	class Member implements Comparable<Member>{
		Queue<Integer> answers;
		int memberCode;
		int correct = 0;

		public Member(int memberCode, Integer[] answers) {
			this.memberCode = memberCode;
			this.answers = Arrays.stream(answers)
							.collect(Collectors.toCollection(LinkedList<Integer>::new));
		}

		public Integer getAnwer() {
			Integer answer = answers.poll();
			answers.offer(answer);

			return answer;
		}

		public void addScore() {
			this.correct++;
		}

		@Override
		public int compareTo(Member o) {
			return o.correct - correct;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Member member = (Member)o;
			return correct == member.correct;
		}

		@Override
		public int hashCode() {
			return Objects.hash(correct);
		}
	}

	public int[] solution(int[] answers) {
		int[] answer = {};

		List<Member> members = new ArrayList<>();

		members.add(new Member(1, new Integer[] {1, 2, 3, 4, 5}));
		members.add(new Member(2, new Integer[] {2, 1, 2, 3, 2, 4, 2, 5}));
		members.add(new Member(3, new Integer[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}));

		Arrays.stream(answers)
			.forEach(v -> {
				members.forEach(member -> {
					Integer memberAnswer = member.getAnwer();

					if (v == memberAnswer) {
						member.addScore();
					}
				});
			});

		Collections.sort(members);

		Member maxScoreMember = members.get(0);

		return members.stream()
			.filter(member -> maxScoreMember.equals(member))
			.mapToInt(member -> member.memberCode)
			.toArray();
	}
}