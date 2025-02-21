package technarts.benchmark.service;

import redis.clients.jedis.Jedis;

public class RedisService {
    private static final String HOST = "localhost";
    private static final int PORT = 6379;

    private static final Jedis jedis = new Jedis(HOST, PORT);

    public static String get(String key) {
        return jedis.get(key);
    }

    public static String set(String key, String value) {
        return jedis.set(key, value);
    }

    public static Long del(String... keys) {
        return jedis.del(keys);
    }
}
