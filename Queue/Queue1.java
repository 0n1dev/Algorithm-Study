import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;

        int totalWeight = 0;
        int truckIndex = 0;
        Queue<Truck> truckQueue = new LinkedList<Truck>();

        while (truckIndex < truck_weights.length) {
            time++;

            if (!truckQueue.isEmpty()) {
                Truck truck = truckQueue.peek();

                if (time - truck.getEnterTime() == bridge_length) {
                    totalWeight -= truck.getWeight();
                    truckQueue.poll();
                }
            }

            int nextTruck = truck_weights[truckIndex];
            if (totalWeight + nextTruck <= weight) {
                truckQueue.offer(new Truck(nextTruck, time));
                totalWeight += nextTruck;
                truckIndex++;
            }
        }
        
        time += bridge_length;

        return time;
    }
}

class Truck {
    private int weight;
    private int enterTime;

    public Truck(int weight, int enterTime) {
        this.weight = weight;
        this.enterTime = enterTime;
    }

    public int getWeight() {
        return weight;
    }

    public int getEnterTime() {
        return enterTime;
    }
}