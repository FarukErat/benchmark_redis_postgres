package technarts.benchmark;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import technarts.benchmark.benchmark.DataBenchmark;

public class Application {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(DataBenchmark.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }

}
