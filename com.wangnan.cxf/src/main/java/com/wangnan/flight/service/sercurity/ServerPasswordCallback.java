package com.wangnan.flight.service.sercurity;

import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
  
import javax.security.auth.callback.Callback;  
import javax.security.auth.callback.CallbackHandler;  
import javax.security.auth.callback.UnsupportedCallbackException;  
  
import org.apache.ws.security.WSPasswordCallback;  
  
public class ServerPasswordCallback implements CallbackHandler {  
      
    Map<String, String> user = new HashMap<String, String>();  
    {  
        user.put("admin", "123");  
        user.put("su", "123");  
    }  
      
    @Override  
    public void handle(Callback[] callbacks) throws IOException,UnsupportedCallbackException   
    {  
        WSPasswordCallback wpc = (WSPasswordCallback) callbacks[0];  
        if (!user.containsKey(wpc.getIdentifier()))   
        {  
            throw new SecurityException("No Permission!");  
        }  
        /* 
         * 此处特别注意:: 
         * WSPasswordCallback 的passwordType属性和password 属性都为null， 
         * 你只能获得用户名（identifier）， 
         * 一般这里的逻辑是使用这个用户名到数据库中查询其密码， 
         * 然后再设置到password 属性，WSS4J 会自动比较客户端传来的值和你设置的这个值。 
         * 你可能会问为什么这里CXF 不把客户端提交的密码传入让我们在ServerPasswordCallbackHandler 中比较呢？ 
         * 这是因为客户端提交过来的密码在SOAP 消息中已经被加密为MD5 的字符串， 
         * 如果我们要在回调方法中作比较，那么第一步要做的就是把服务端准备好的密码加密为MD5 字符串， 
         * 由于MD5 算法参数不同结果也会有差别，另外，这样的工作CXF 替我们完成不是更简单吗？ 
         */  
        wpc.setPassword(user.get(wpc.getIdentifier()));//如果包含用户名,就设置该用户名正确密码,由CXF验证密码  
        String username = wpc.getIdentifier();  
        String password = wpc.getPassword();  
        System.out.println("userName:" + username + " password:" + password);  
    }  
  
}  