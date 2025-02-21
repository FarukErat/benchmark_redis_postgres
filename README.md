# Data Access Performance Benchmark

This project evaluates the performance of data retrieval operations using PostgreSQL and Redis. Benchmarks were conducted using the Java Microbenchmark Harness (JMH) to measure the average execution time of data access methods.

## Benchmark Overview

The benchmarks focus on comparing the average time per operation (`ms/op`) for data retrieval from PostgreSQL and Redis.

## System Configuration

- **Processor**: 2.3 GHz 8-Core Intel Core i9
- **Memory**: 32 GB 2667 MHz DDR4
- **Graphics**: Intel UHD Graphics 630 1536 MB
- **Machine**: MacBook Pro 2019

## Benchmark Results

The following results were obtained from the benchmarks:

| Benchmark                       | Mode | Count | Score (ms/op) | Error (ms/op) |
|---------------------------------|------|-------|---------------|---------------|
| `benchmarkPostgres`             | avgt | 10    | 0.716         | ± 0.099       |
| `benchmarkRedis`                | avgt | 10    | 0.674         | ± 0.170       |

**Interpretation:**

- **Mode**: `avgt` indicates that the benchmark measures the average time per operation.
- **Count**: Number of measurement iterations conducted.
- **Score**: Average time taken per operation.
- **Error**: Statistical error margin of the score.

The results demonstrate that data retrieval from Redis (`benchmarkRedis`) is slightly faster than from PostgreSQL (`benchmarkPostgres`) under the tested conditions.

## How to Run the Benchmarks

1. **Clone the Repository**: Ensure you have the project source code.
2. **Build the Project**: Compile the project using your preferred build tool (e.g., Maven, Gradle).
3. **Execute Benchmarks**: Run the benchmarks using JMH.

   For example, using Maven:

   ```bash
   mvn clean install
   java -jar target/benchmarks.jar
   ```


## Dependencies

- **JMH**: Java Microbenchmark Harness
- **PostgreSQL Driver**: JDBC driver for PostgreSQL
- **Redis Client**: Jedis or an equivalent Redis client

Ensure all dependencies are included in your project's build configuration.

## Notes

- **Consistency**: Benchmark results can vary based on system load and configuration. It's recommended to run benchmarks in a controlled environment.
- **Warmup and Measurement**: JMH performs warmup iterations before actual measurements to allow the JVM to optimize the code.
- **Forking**: Benchmarks are executed in separate JVM forks to isolate them from each other and obtain accurate measurements.

For more information on interpreting JMH benchmark results, refer to the [JMH documentation](https://openjdk.java.net/projects/code-tools/jmh/). 