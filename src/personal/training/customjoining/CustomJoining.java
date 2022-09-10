package personal.training.customjoining;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CustomJoining implements Collector<String,StringBuilder,String> {

    private String delimiter = "";
    private String suffix = "";
    private String prefix = "";

    private CustomJoining(String delimiter, String prefix, String suffix) {
        this.delimiter=delimiter;
        this.prefix=prefix;
        this.suffix=suffix;
    }

    private CustomJoining() {

    }

    public  static CustomJoining CustomJoining(String delimiter, String prefix, String suffix) {
        return new CustomJoining(delimiter,prefix,suffix);

    }

    public static CustomJoining CustomJoining() {
        return new CustomJoining();
    }

    @Override
    public Supplier<StringBuilder> supplier() {

        return () -> new StringBuilder(prefix);
    }

    @Override
    public BiConsumer<StringBuilder,String> accumulator() {
        return  (acc, s) -> acc.append(s).append(delimiter);
    }

    @Override
    public BinaryOperator<StringBuilder> combiner() {
        return  (sb1,sb2) -> sb1.append(sb2);
    }

    @Override
    public Function<StringBuilder,String> finisher() {
               return sb-> {
                   if (sb.length() > 0) {
                       sb.setLength(sb.length() - 1);
                   }
                   sb.append(suffix);
                   return sb.toString();
               };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.UNORDERED);
    }
}
