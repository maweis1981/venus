import com.maweis.util.StringUtils;
import junit.framework.Assert;
import org.junit.Test;
import org.unitils.core.Unitils;

/**
 * Created by peter on 12/25/13.
 */
public class StringUtilsTest extends Unitils{

    @Test
    public void testClazzName(){

        String clazzName = this.getClass().getName();

        Assert.assertEquals("StringUtilsTest", StringUtils.getClazzName(clazzName));
        Assert.assertEquals("StringUtilsTest", StringUtils.getClazzName("com.maweis.StringUtilsTest"));


    }

}
