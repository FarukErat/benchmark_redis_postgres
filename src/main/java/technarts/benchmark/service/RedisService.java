package technarts.benchmark.service;

import redis.clients.jedis.Jedis;

public class RedisService {
    private static final String HOST = "localhost";
    private static final int PORT = 6379;

    private static final Jedis jedis;

    static  {
        jedis = new Jedis(HOST, PORT);
    }

    public static Object executeRawCommand(String command, String... args) {
        command = command.toUpperCase();
        switch (command) {
            case "GET":
                if (args.length != 1) {
                    throw new IllegalArgumentException("GET command requires exactly 1 argument.");
                }
                return jedis.get(args[0]);
            case "SET":
                if (args.length != 2) {
                    throw new IllegalArgumentException("SET command requires exactly 2 arguments.");
                }
                return jedis.set(args[0], args[1]);
            case "DEL":
                if (args.length < 1) {
                    throw new IllegalArgumentException("DEL command requires at least 1 argument.");
                }
                return jedis.del(args);
            default:
                throw new UnsupportedOperationException("Command '" + command + "' is not supported.");
        }
    }
}
