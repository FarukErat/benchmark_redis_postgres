package technarts.benchmark;

import org.openjdk.jmh.annotations.*;
import technarts.benchmark.service.PostgresService;
import technarts.benchmark.service.RedisService;

import java.util.concurrent.TimeUnit;

public class DataBenchmark {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Warmup(iterations = 5, time = 1)
    @Measurement(iterations = 10, time = 1)
    @Fork(1)
    public void benchmarkPostgres() {
        PostgresService.executeRawSql("SELECT email FROM auth_user WHERE id = 1;");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Warmup(iterations = 5, time = 1)
    @Measurement(iterations = 10, time = 1)
    @Fork(1)
    public void benchmarkRedis() {
        RedisService.jedis.hget("userById::1", "email");
    }
}
