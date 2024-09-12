package DoLastWeek.Stream;

import java.util.HashMap;

public class LoggerRateLimiter {
    class Logger {

        HashMap<String, Integer> map;

        public Logger() {
            map = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!map.containsKey(message)) {
                // If the message is new, print and store the timestamp
                map.put(message, timestamp);
                return true;
            } else {
                // Check if the message can be printed based on the time difference
                int lastTimestamp = map.get(message);
                if (timestamp - lastTimestamp >= 10) {
                    // Only update the timestamp if the message should be printed
                    map.put(message, timestamp);
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}
