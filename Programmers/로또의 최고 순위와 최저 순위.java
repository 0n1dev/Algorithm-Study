class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] lottoRank = {6, 6, 5, 4, 3, 2, 1};
        int[] answer = new int[2];

        int zeroCount = 0;
        int winCount = 0;

        // 0의 개수
        for (int num : lottos) {
            if (num == 0) {
                zeroCount++;
            }
        }

        // 맞는 번호 체크
        for (int num : lottos) {
            for (int win : win_nums) {
                if (num == win) {
                    winCount++;
                    break;
                }
            }
        }

        answer[0] = lottoRank[winCount + zeroCount];
        answer[1] = lottoRank[winCount];

        return answer;
    }
}