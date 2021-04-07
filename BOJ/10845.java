import java.io.*;
import java.util.LinkedList;

public class Main_10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int line = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<Integer>();

        while (line-- > 0) {
            String[] cmd = br.readLine().split(" ");

            if (cmd[0].equals("push")) {
                q.add(Integer.parseInt(cmd[1]));
            } else if (cmd[0].equals("pop")) {
                if (q.size() == 0) {
                    bw.write("-1\n");
                } else {
                    bw.write(q.remove(0) + "\n");
                }
            } else if (cmd[0].equals("front")) {
                if (q.size() == 0) {
                    bw.write("-1\n");
                } else {
                    bw.write(q.get(0) + "\n");
                }
            } else if (cmd[0].equals("back")) {
                if (q.size() == 0) {
                    bw.write("-1\n");
                } else {
                    bw.write(q.get(q.size() - 1) + "\n");
                }
            } else if (cmd[0].equals("size")) {
                bw.write(q.size() + "\n");
            } else if (cmd[0].equals("empty")) {
                if (q.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }
        }
        bw.flush();
    }
}
