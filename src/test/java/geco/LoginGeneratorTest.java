package geco;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {
    private LoginService loginService ;
    private LoginGenerator lg;
    @Before
    public void before() {

        this.loginService = new LoginService(new String[]{"JROL", "BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
        lg =new LoginGenerator(loginService);
    }

    @Test
    public void generateLoginForNomAndPrenom() {
    lg.generateLoginForNomAndPrenom("Durand", "Paul");
    boolean ok=loginService.loginExists("PDUR");
        Assert.assertEquals(true,ok);

    lg.generateLoginForNomAndPrenom("Ralling", "John") ;
    boolean okk=loginService.loginExists("JRAL2");
        Assert.assertEquals(true,okk);

    lg.generateLoginForNomAndPrenom("Rolling", "Jean");
    boolean okkk=loginService.loginExists("JROL1");
        Assert.assertEquals(true,okkk);

        lg.generateLoginForNomAndPrenom("Dûrand", "Paul");
        boolean okkkk=loginService.loginExists("PDUR");
        Assert.assertEquals(true,okkkk);
    }
}