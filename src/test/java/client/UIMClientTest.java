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
    private String endPoint = "******";
    private String appKey = "*****";
    private String appSecret = "*******";
    @Before
    public void setUp() throws Exception {
        client = new UIMClient(endPoint,appKey,appSecret);
    }
    @Test
    public void readUsertest(){
//        ExecuteResponse<UIMUser> rps = client.readuser("2058");
//        ExecuteResponse<UIMUser> rps = client.readuser("0011156");
        ExecuteResponse<UIMUser> rps = client.readuser("1570");
        UIMUser user = rps.getReturnObject();
        System.out.println(user);
    }
    @Test
    public void readorgTest(){
        ExecuteResponse<UIMOrg> rps = client.readorg("IT160506");
//        ExecuteResponse<UIMOrg> rps = client.readorg("IT1605");
//        ExecuteResponse<UIMOrg> rps = client.readorg("72815062");
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
        String name = "oaId";
//        String value = "IT0801";
        String value = "72815062";
        PageResponse<UIMOrg> rps = client.orgfind(name,value);
        List<UIMOrg> list = rps.getContent();
        System.out.println(list);
    }
    @Test
    public void userfindTest(){
        String email = "email";
        String value ="Jay.Jiang@infinitus-int.com";
        PageResponse<UIMUser> rps = client.userfind(email,value);
        List<UIMUser> uimUsers = rps.getContent();
        System.out.println(uimUsers);
    }
}
