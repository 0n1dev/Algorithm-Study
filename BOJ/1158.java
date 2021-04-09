import java.io.*;
import java.util.ArrayList;

public class Main_1158 {
    /**
     * 요세푸스 문제
     * https://www.acmicpc.net/problem/1158
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] cmd = reader.readLine().split(" ");

        int n = Integer.parseInt(cmd[0]);
        int k = Integer.parseInt(cmd[1]);

        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> resultList = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int idx = 1;
        int listIdx = 0;
        while (!list.isEmpty()) {
            if (idx == k) {
                resultList.add(list.remove(listIdx));
                listIdx--;
                idx = 1;
            } else {
                idx++;
            }

            if (list.size() - 1 > listIdx) {
                listIdx++;
            } else {
                listIdx = 0;
            }
        }

        bw.write("<");

        for (int i = 0; i < resultList.size() - 1; i++) {
            bw.write(resultList.get(i) + ", ");
        }

        bw.write(resultList.get(resultList.size() - 1) + ">");
        bw.flush();
    }
}

// Queue 사용 풀이

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] cmd = reader.readLine().split(" ");

        int n = Integer.parseInt(cmd[0]);
        int k = Integer.parseInt(cmd[1]);

        Queue<Integer> list = new LinkedList<>();
        ArrayList<Integer> resultList = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            list.offer(i);
        }

        int idx = 1;

        while (!list.isEmpty()) {
            if (idx == k) {
                resultList.add(list.remove());
                idx = 1;
            } else {
                list.offer(list.remove());
                idx++;
            }
        }

        bw.write("<");

        for (int i = 0; i < resultList.size() - 1; i++) {
            bw.write(resultList.get(i) + ", ");
        }

        bw.write(resultList.get(resultList.size() - 1) + ">");
        bw.flush();
    }
}