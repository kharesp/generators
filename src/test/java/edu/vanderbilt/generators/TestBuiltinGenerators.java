package edu.vanderbilt.generators;

import org.junit.Test;
import org.junit.Assert;
/**
 * Created by kharesp on 7/7/16.
 */
public class TestBuiltinGenerators {
    @Test
    public void testIntGenerator(){
        Assert.assertTrue("Instance of Generator must be returned by intGen",BuiltinGenerators.intGen() instanceof Generator);
        int val = BuiltinGenerators.intGen().generate();
        Assert.assertTrue("Integer value must be returned by builtin Integer generator's generate",
                val > Integer.MIN_VALUE && val < Integer.MAX_VALUE);
    }
    @Test
    public void testByteGenerator(){
        Assert.assertTrue("Instance of Generator must be returned by byteGen", BuiltinGenerators.byteGen() instanceof Generator);
        int val = BuiltinGenerators.byteGen().generate().intValue();
        Assert.assertTrue("Integer value of Byte returned by builtin Byte generator's generate must be valid",
                val > Integer.MIN_VALUE && val < Integer.MAX_VALUE);
    }

}
