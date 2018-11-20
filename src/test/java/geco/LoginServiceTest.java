package geco;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LoginServiceTest {
   private String[] loginExistant;
   private LoginService ls ;

    @Before
    public void before() {
        this.loginExistant=new String[4];
        loginExistant[0]="julien";
        loginExistant[1]="sylvie";
        loginExistant[2]="ludo";
        loginExistant[3]="antoine";

       this.ls = new LoginService(loginExistant);
    }

    @Test
    public void loginExists() {
        Assert.assertEquals(true,ls.loginExists("antoine"));
        Assert.assertEquals(true,ls.loginExists("sylvie"));
        Assert.assertEquals(false,ls.loginExists("anne"));
    }

    @Test
    public void addLogin() {
        ls.addLogin("anne");
        Assert.assertEquals(true,ls.loginExists("anne"));
    }

    @Test
    public void findAllLoginsStartingWith() {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> attendu = new ArrayList<String>();
        attendu.add("antoine");
        attendu.add("anne");
        ls.addLogin("anne");
        Assert.assertEquals(true,ls.loginExists("anne"));
        result= (ArrayList<String>) ls.findAllLoginsStartingWith("an");
        Assert.assertEquals(result,attendu);
        boolean test=result.contains("sylvie");
        Assert.assertEquals(false,test);
    }

    @Test
    public void findAllLogins() {
        ArrayList<String> result = new ArrayList<String>();
        result= (ArrayList<String>) ls.findAllLogins();
        ArrayList<String> attendu = new ArrayList<String>();
        attendu.add("antoine");
        attendu.add("julien");
        attendu.add("ludo");
        attendu.add("sylvie");
        Assert.assertEquals(result,attendu);

    }

}