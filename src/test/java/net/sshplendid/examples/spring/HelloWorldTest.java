package net.sshplendid.examples.spring;

import org.junit.Test;

public class HelloWorldTest {
    @Test
    public void test_Main() {
        String[] args = new String[0];
        HelloWorld app = new HelloWorld();
        app.main(args);
    }

    @Test(expected = Exception.class)
    public void test_throw_Exception() throws Exception {

        throw new Exception("고의로 발생시킨 익셉션");
    }
}
