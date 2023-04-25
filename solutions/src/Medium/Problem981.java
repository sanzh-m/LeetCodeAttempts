package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem981 {
    // Writing static on another line for easy copy to leetcode
    static
    class TimeMap {
        static class TimestampedValue implements Comparable<TimestampedValue> {
            String value;
            int timestamp;

            public TimestampedValue(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }

            @Override
            public int compareTo(TimestampedValue timestampedValue) {
                return Integer.compare(timestamp, timestampedValue.timestamp);
            }
        }
        HashMap<String, List<TimestampedValue>> map = new HashMap<>();
        TimestampedValue dummy = new TimestampedValue("", -1);

        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            List<TimestampedValue> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            TimestampedValue timestampedValue = new TimestampedValue(value, timestamp);
            list.add(timestampedValue);
        }

        public String get(String key, int timestamp) {
            List<TimestampedValue> list = map.get(key);
            if (list == null)
                return "";
            dummy.timestamp = timestamp;
            int index = Collections.binarySearch(list, dummy);
            if (index == -1)
                return "";
            if (index < 0)
                index = -(index + 2);
            return list.get(index).value;
        }
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1));
        System.out.println(timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));
        System.out.println(timeMap.get("foo", 5));
    }
}
