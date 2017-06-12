package com.tuba.yuanyc.reconstruction;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author ：yuanyc
 * Time ：2017/6/12
 * Description ：
 */
public class DemoTest {

    private Demo demo;

    @Before
    public void setUp(){
        demo = new Demo();
    }
    @Test
    public void total() throws Exception {
        assertEquals(demo.total(3,4),7);
    }

}