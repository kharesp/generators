package edu.vanderbilt.generators;

import java.util.Random;
/**
 * Created by kharesp on 7/6/16.
 */
public final class BuiltinGenerators {

    public static Generator<Integer> intGen() {
        return new Generator<Integer>(){
            Random random = new Random();
            Integer generate(){
                return random.nextInt();
            }
        };
    }
    public static Generator<Byte> byteGen(){
        return new Generator<Byte>(){
            Random random= new Random();
            Byte generate()
            {
                return (byte)random.nextInt();
            }
        };
    }
    public static void main(String[] args){
        System.out.println(intGen().generate());
        System.out.println(byteGen().generate().intValue());
    }
}
