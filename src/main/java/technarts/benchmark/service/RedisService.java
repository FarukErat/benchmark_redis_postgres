package technarts.benchmark.service;

import redis.clients.jedis.Jedis;

public class RedisService {
    private static final String HOST = "localhost";
    private static final int PORT = 6379;

    public static final Jedis jedis = new Jedis(HOST, PORT);
}
