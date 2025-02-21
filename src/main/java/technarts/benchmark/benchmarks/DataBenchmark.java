package technarts.benchmark.benchmarks;

import org.openjdk.jmh.annotations.*;
import technarts.benchmark.services.PostgresService;
import technarts.benchmark.services.RedisService;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 10, time = 1)
@Fork(1)
public class DataBenchmark {

    @Benchmark
    public void benchmarkPostgres() {
        PostgresService.executeRawSql("SELECT email FROM auth_user WHERE id = 1;");
    }

    @Benchmark
    public void benchmarkRedis() {
        RedisService.jedis.hget("userById::1", "email");
    }
}
