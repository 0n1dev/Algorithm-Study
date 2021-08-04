import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class Solution {
    PriorityQueue<User> queue = new PriorityQueue<>();

    public static void main(String[] args) {

        Solution s  = new Solution();
        int k = 3;
        String[] user_scores = {"zalex111 100", "cheries2 200", "coco 150", "luna 100", "zalex111 120", "coco 300", "cheries2 110", "zalex111 300"};

        System.out.println(s.solution(k, user_scores));

    }


    public int solution(int k, String[] user_scores) {
        AtomicInteger i = new AtomicInteger();

        Arrays.stream(user_scores)
                .map(score -> score.split(" "))
                .forEach(e -> {
                    List<User> t1 = queue.stream()
                            .limit(k)
                            .collect(Collectors.toList());

                    updateUser(e[0], Integer.parseInt(e[1]));

                    List<User> t2 = queue.stream()
                            .limit(k)
                            .collect(Collectors.toList());

                    if (!t1.equals(t2)) {
                        i.getAndIncrement();
                    }
                });

        return i.get();
    }

    private void updateUser(String name, int score) {
        User user = queue.stream()
                .filter(u -> u.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (user != null) {
            if (user.getScore() < score) {
                queue.remove(user);
                queue.offer(new User(name, score));
            }
        } else {
            queue.offer(new User(name, score));
        }
    }
}

class User implements Comparable<User> {

    private final String name;
    private final int score;

    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(User o) {
        return o.score - this.score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}