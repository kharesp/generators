import org.junit.Test;
import org.junit.Assert;
/**
 * Created by kharesp on 7/7/16.
 */
public class TestBuiltinGenerators {
    @Test
    public void testIntGenerator(){
        Assert.assertTrue("Instance of Generator must be returned by intGen", BuiltinGenerators.intGen() instanceof Generator);
        Assert.assertTrue("Random number returned by builtin Integer generator's generate method must be < 100",
                BuiltinGenerators.intGen().generate() < 100);
    }
    @Test
    public void testByteGenerator(){
        Assert.assertTrue("Instance of Generator must be returned by byteGen", BuiltinGenerators.byteGen() instanceof Generator);
        Assert.assertTrue("Integer value of Byte returned by builtin Byte generator's generate method must be < 100",
                BuiltinGenerators.byteGen().generate().intValue() < 100);
    }

}
