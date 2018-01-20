package com.example.app.shiro.demo;

        import com.example.app.shiro.demo.model.UserInfo;
        import com.example.app.shiro.demo.repository.UserInfoRepository;
        import org.apache.shiro.crypto.hash.SimpleHash;
        import org.apache.shiro.util.ByteSource;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    private UserInfoRepository userInfoRepository;

    @Test
    public void contextLoads() {
    }


    /*
    * 新建一个用户*/
    @Test
    public void user() {

        UserInfo userInfo = new UserInfo();
        userInfo.setName("A");

        userInfo.setUsername("A");
        userInfoRepository.save(userInfo);
        userInfo.setSalt("liu");
        String hashAlgorithmName = "MD5";
        String credentials ="123456";
        int hashIterations = 2;
        ByteSource credentialsSalt = ByteSource.Util.bytes(userInfo.getCredentialsSalt());
        Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
        System.out.println(obj);
        userInfo.setPassword(obj.toString());
        userInfoRepository.save(userInfo);

     //   String password =  new SimpleHash("md5","123456",ByteSource.Util.bytes("adminnull"),2).toHex();

    }

    @Test
    public void userinfo() {

        UserInfo userInfo = userInfoRepository.findByUsername("admin");

        System.out.println(userInfo.getRoleList());

    }

    @Test
    public void main() {


        String hashAlgorithmName = "MD5";
        String credentials ="123456";
        int hashIterations = 2;
        ByteSource credentialsSalt = ByteSource.Util.bytes("admin1");
        SimpleHash obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
        System.out.println(obj);


    }
}
