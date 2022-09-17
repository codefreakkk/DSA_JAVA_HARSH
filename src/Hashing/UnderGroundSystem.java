package Hashing;

import java.util.HashMap;

class ArrivalPassenger {
    public int id;
    public int time;
    public String stationName;

    public ArrivalPassenger(int id, String stationName, int time) {
        this.id = id;
        this.stationName = stationName;
        this.time = time;
    }
}

class AverageTime {
    public int total;
    public double average;

    public void update(int difference) {
        total += 1;
        average += difference;
    }

    public double getAverage() {
        return average / total;
    }
}

class UnderGroundSystem {

    HashMap<Integer, ArrivalPassenger> checkIn = new HashMap<>();
    HashMap<String, AverageTime> average = new HashMap<>();
    public final String DELIMITER = ",";

    public UnderGroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new ArrivalPassenger(id, stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        // get passenger and remove it from map
        ArrivalPassenger arrivalPassenger = checkIn.get(id);
        checkIn.remove(id);

        // update the average value
        String key = arrivalPassenger.stationName + DELIMITER + stationName;
        int time = t - arrivalPassenger.time;

        AverageTime averageTime = average.containsKey(key) ? average.get(key) : new AverageTime();
        averageTime.update(time);

        average.put(key, averageTime);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + DELIMITER + endStation;
        return average.get(key).getAverage();
    }
}