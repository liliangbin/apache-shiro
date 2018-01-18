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

    @Test
    public void user() {

        UserInfo userInfo = new UserInfo();
        userInfo.setName("li");
        userInfo.setPassword("123456");
        userInfo.setUsername("li");
        userInfoRepository.save(userInfo);


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
        ByteSource credentialsSalt = ByteSource.Util.bytes("li22");
        Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
        System.out.println(obj);
    }
}
