package ut.com.agilent.sparklink.usersskills;

import org.junit.Test;
import com.agilent.sparklink.usersskills.api.MyPluginComponent;
import com.agilent.sparklink.usersskills.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}