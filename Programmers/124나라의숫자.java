class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        int num = n;

        while (num > 3) {
            int remainder = num % 3;;
            num /= 3;

            if (remainder == 0) num--;
            sb.append(getStr(remainder));
        }

        sb.append(getStr(num));

        answer = sb.reverse().toString();

        return answer;
    }

    public String getStr(int n) {
        if (n == 3 || n == 0) {
            return "4";
        } else {
            return String.valueOf(n);
        }
    }
}