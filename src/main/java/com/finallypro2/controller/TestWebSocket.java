package com.finallypro2.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finallypro2.POJO.SocketMsg;

import com.finallypro2.util.RedisBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/mysocket/{nickname}")
@Component
public class TestWebSocket {

    private static CopyOnWriteArraySet<TestWebSocket> webSocketSet = new CopyOnWriteArraySet<>();
    /**
     * 用于储存上线用户的Session
     */
    private static Map<String, Session> map = new HashMap<>();

//    private static Map<String, String> uname = new HashMap<>();

    private static ConcurrentMap<String, Map<String, List<Object>>> messageMap = new ConcurrentHashMap<>();
    private String nickname;
    private Session session;


    private RedisTemplate redisTemplate;


    @OnOpen
    public void onOpen(Session session, @PathParam("nickname") String nickname) {

//        String[] name = nickname.split(":");
//        String toUser = name[1];
//        String myname = name[0];

        this.nickname = nickname;

        this.session = session;


        map.put(this.nickname, session);
        webSocketSet.add(this);

        //显示未读信息
        sendmessageOne_messageMap();
//        this.session.getAsyncRemote().sendText("恭喜"+nickname+"成功连接上WebSocket)-->当前在线人数为："+webSocketSet.size());
        System.out.println("恭喜" + nickname + "成功连接上WebSocket)-->当前在线人数为：" + webSocketSet.size());
    }

    @OnMessage
    public void onMessage(@PathParam("nickname") String nickname, String message) {
        System.out.println("来自客户端的消息-->" + nickname + ": " + message);

        ObjectMapper objectMapper = new ObjectMapper();
        SocketMsg socketMsg;

        try {

            String[] name = nickname.split(":");
            String myname = name[0];


            socketMsg = objectMapper.readValue(message, SocketMsg.class);
//            socketMsg.setFromUser(myname);

//            Session fromSession = map.get(socketMsg.getFromUser());
//            if (uname.get(myname) == null)
//                uname.put(myname, socketMsg.getFromUser());
            String str = "";
            str += this.getData_redis(myname);
            if (str.equals("null") || str == null || str == "null"){
                this.setData_redis(myname,socketMsg.getFromUser());
            }

//            fromSession.getAsyncRemote().sendText(myname+":"+socketMsg.getMsg()+":0");
            if (map.get(socketMsg.getToUser()) != null) {
                Session toSession = map.get(socketMsg.getToUser());

                toSession.getAsyncRemote().sendText(myname + "," + this.getData_redis(myname) + "," + socketMsg.getMsg());
                //0代表自己，1代表对方

            } else {
                System.out.println("你要发送信息的对象" + socketMsg.getToUser() + "暂时不在线");
                sendmessageOne_unonline(socketMsg.getToUser(), socketMsg.getMsg());
            }


        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        map.remove(nickname);

//        savedata_redis();

        System.out.println("有一连接关闭！当前在线人数为" + map.size());
//        System.out.println("有一连接关闭！当前在线人数为" + webSocketSet.size());
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    public void sendmessageOne_messageMap() {
        Map<String, List<Object>> map = messageMap.get(nickname);


        if (map != null) {
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String keys = (String) iterator.next();
//                    if (keys.equals(fromUser)){
                List<Object> message_list = map.get(keys);
                String str = nickname + "," + this.getData_redis(keys) + ",";
                for (Object o : message_list) {
                    str += (String) o + ",";

//                        savedata_redis(fromUser,(String) o);
                }
                String str2 = str.substring(0, str.length() - 1);
                this.session.getAsyncRemote().sendText(str2);
                messageMap.get(nickname).remove(keys);
//                    }
            }
        }
    }

    public void sendmessageOne_unonline(String toUser, String message) {
        List<Object> message_list = null;
        Map<String, List<Object>> map = null;
        //判断系统记录中对方的未读信息  不存在
        if (messageMap.get(toUser) == null) {
            message_list = new ArrayList<>();
            map = new HashMap<>();

            message_list.add(message);
            map.put(nickname, message_list);

            messageMap.put(toUser, map);

        }
        //判断系统记录中对方的未读信息  存在
        else {
            map = messageMap.get(toUser);
//            判断系统记录中对方的未读信息  不存在  来着nickname用户发的信息，并且新建一个储存
            if (map.get(nickname) == null) {
                message_list = new ArrayList<>();
                message_list.add(message);
                map.put(nickname, message_list);
            }
            //判断系统记录中对方的未读信息  存在  来着nickname用户发的信息，并且接着储存
            else {
                message_list = map.get(nickname);
                message_list.add(message);

            }
        }
    }

    //储存俩个人的记录去redis中
    public void savedata_redis(String other, String message) {
        this.redisTemplate = RedisBean.redis;
        redisTemplate.opsForList().rightPush(other, message);
//        redisTemplate.opsForValue().set("key1","66666");
//        System.out.println(redisTemplate.opsForList().range(other,0,10));
    }


    public String getData_redis(String uanme) {
        this.redisTemplate = RedisBean.redis;
        return (String) redisTemplate.opsForValue().get(uanme);
    }

    public void setData_redis(String uanme,String value) {
        this.redisTemplate = RedisBean.redis;
        redisTemplate.opsForValue().set(uanme,value);
        System.out.println(getData_redis(uanme));
    }

}
