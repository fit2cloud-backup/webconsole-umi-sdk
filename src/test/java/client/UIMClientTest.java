package client;

import model.UIMOrg;
import model.UIMUser;
import model.vo.ExecuteResponse;
import model.vo.PageResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by linjinbo on 2017/9/18.
 */
public class UIMClientTest {
    private UIMClient client;
    private String endPoint = "https://uim-dev.infinitus.com.cn";
    private String appKey = "CMP";
    private String appSecret = "xIkujdkA90PkujhIa976";
    @Before
    public void setUp() throws Exception {
        client = new UIMClient(endPoint,appKey,appSecret);
    }
    @Test
    public void readUsertest(){
        ExecuteResponse<UIMUser> rps = client.readuser("48252104");
//        ExecuteResponse<UIMUser> rps = client.readuser("0009704");
        UIMUser user = rps.getReturnObject();
        System.out.println(user);
    }
    @Test
    public void readorgTest(){
        ExecuteResponse<UIMOrg> rps = client.readorg("9643");
        UIMOrg uimOrg = rps.getReturnObject();
        System.out.println(uimOrg);
    }
    @Test
    public void orglistTest(){
        ExecuteResponse<List<UIMOrg>> rps = client.orglist();
        List<UIMOrg> list = rps.getReturnObject();
        System.out.println(list);
    }
    @Test
    public void orgfind(){
        String name = "name";
        String value = "9643";
        PageResponse<UIMOrg> rps = client.orgfind(name,value);
        List<UIMOrg> list = rps.getContent();
        System.out.println(list);
    }
}
