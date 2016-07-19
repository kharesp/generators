package edu.vanderbilt.generators;
import java.util.function.Supplier;
import java.util.Random;
/**
 * Created by kharesp on 7/6/16.
 */
public final class BuiltinGenerators {

    public static Generator<Integer> intGen() {
        return new Generator<Integer>(){
            Random random = new Random();
            @Override
            Integer generate(){
                return random.nextInt();
            }
        };
    }
    public static Generator<Byte> byteGen(){
        return new Generator<Byte>(){
            Generator<Integer> integers = intGen();
            @Override
            Byte generate(){
                return integers.generate().byteValue();
            }
        };
    }
    public static <T> Generator<T> newGen(Supplier<T> generator){
        return new Generator<T>() {
            @Override
            T generate() {
                return generator.get();
            }
        };
    }
    public static Generator<Integer> rangeGen(int lower, int upper) {
        System.out.println("lower:" + lower + "higher:"+ upper);
        Generator<Integer> integers = intGen();
        return newGen(() -> lower + Math.abs(integers.generate()) % (upper-lower));
    }
    public static Generator<Character> charGen(){
        Generator<Integer> integers = rangeGen(Character.MIN_VALUE, Character.MAX_VALUE);
        return newGen(() -> (char)integers.generate().intValue());
    }
    public static Generator<Boolean> booleanGen(){
        Generator<Integer> integers = intGen();
        return newGen(() -> integers.generate() > 0);
    }
    public static Generator<Short> shortGen(){
        Generator<Integer> integers = intGen();
        return newGen(() -> integers.generate().shortValue());
    }
    public static Generator<Long> longGen(){
        Generator<Integer> integers = intGen();
        return newGen(() -> integers.generate().longValue());
    }
    public static Generator<Float> floatGen(){
        Generator<Integer> integers = intGen();
        return newGen(() -> integers.generate().floatValue());
    }
    public static Generator<Double> doubleGen(){
        Generator<Integer> integers = intGen();
        return newGen(() -> integers.generate().doubleValue());
    }
    public static void main(String[] args){
        Generator<Character> test = charGen();
        System.out.println(test.generate());
    }
}
