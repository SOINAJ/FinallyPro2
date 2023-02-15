package com.finallypro2;


import com.alibaba.fastjson.JSON;
import com.baidu.aip.ocr.AipOcr;
import com.baidubce.services.bos.model.PutObjectResponse;
import com.finallypro2.POJO.Login_id;
import com.finallypro2.dao.LoginDao;
import com.finallypro2.dao.U_W_MesDao;

import com.finallypro2.util.MyBos;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.misc.BASE64Encoder;
//import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FinallyPro2ApplicationTests {

//    @Autowired
//    @Qualifier("MyredisTemplate")
//    private RedisTemplate redisTemplate;
//    @Autowired
//    private ReadyDao readyDao;

//    @Autowired
//    private U_W_MesDao w_mesDao;

//    public int longestWPI(int[] hours) {
//        int l = hours.length;
//        int[][] arr = new int[l+1][2];
//        for(int i = 0; i < l; i++){
//            if(hours[i] > 8){
//                arr[i+1][0] = arr[i][0] + 1;
//                arr[i+1][1] = arr[i][1];
//            }else{
//                arr[i+1][0] = arr[i][0];
//                arr[i+1][1] = arr[i][1] + 1;
//            }
//        }
//
//        for(int len = l; len > 0; len--){
//            for(int i = 0; i <= l - len; i++){
//                int r = i + len;
//                if(arr[r][0] - arr[i][0] > arr[r][1] - arr[i][1]){
//                    return len;
//                }
//            }
//        }
//        return 0;
//    }
    public static final String APP_ID = "739d63b94c1e468286bc0459851f3841";
    public static final String API_KEY = "0i2FubbUzXDEfzEVW3tPytvZ";
    public static final String SECRET_KEY = "FYSfwwdWkdT1uKSSw9slRLxcrOfhfkDq";
//    public static final String APP_ID = "256050b593a5436387577015977e1dd5";
//    public static final String API_KEY = "SIBjehEscIjOzv9qNIhuaGR5";
//    public static final String SECRET_KEY = "3G6PtLIFwK6Ha5VGOw5Kb7g04Apt8tNQ";


    @Test
    void contextLoads(){
        AipOcr client = new AipOcr(APP_ID,API_KEY,SECRET_KEY);
//        client.setConnectionTimeoutInMillis(2000);
//        client.setSocketTimeoutInMillis(60000);
        String path = "C:\\Users\\LLP\\Desktop\\111.png";
        String path2 = "C:\\Users\\LLP\\Desktop\\222.png";
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("probability", "false");

//        String path = "https://mytest01.gz.bcebos.com/A2SFZ.jpg";
        // 参数为本地图片路径
//        JSONObject res = client.basicGeneralUrl(path,options);
        JSONObject res = client.basicGeneral(path2, options);
        JSONArray array = res.getJSONArray("words_result");

////        System.out.println(array.toString());
//        JSONObject myres = (JSONObject) array.get(7);
//        System.out.println(myres.get("words"));
//        System.out.println(res.get("words_result"));
        try {
            File fileOrFilename = new File("C:\\Users\\LLP\\Desktop\\1.txt");
            BufferedWriter outputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOrFilename, true)));
            List<String> list = new ArrayList<>();
            JSONObject myres = null;
            for(int i=0;i<array.length();i++){
                myres = (JSONObject) array.get(i);
                String s = (String) myres.get("words");
//                System.out.println(s);
                list.add(s);

            }
//            String[] arrays = new String[list.size()];
            for(int i=0;i<list.size();i++){
//                byte[] bytes = ()).getBytes();
                outputStream.write(list.get(i));
            }
            outputStream.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(res.toString(2));
//        redisTemplate.opsForList().rightPush("mykey","123");
//        redisTemplate.opsForList().rightPush("mykey","3213");
//        System.out.println(redisTemplate.opsForList().range("mykey",0,10));
        //        redisTemplate.opsForValue().set("key1","66666");
//        System.out.println(redisTemplate.opsForValue().get("key1"));
//        Jedis jedis = new Jedis("localhost");
//        System.out.println(jedis.ping());
//        System.out.println(jedis.get("myKey"));
//        List<Ready_work> a2 = readyDao.get_WorkReady_work("B2", 0);
//        for (Ready_work ready_work : a2) {
//            System.out.println(ready_work.getTime_start());
//        }
//        User_message user_message = new User_message();
//        user_message.setPhone("123");
//        user_message.setPart("A2");
//        user_message.setPlace("C5-111");
//        Integer B2 = w_mesDao.get_UMesage(user_message);
//        System.out.println(B2);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
//        Date date = simpleDateFormat.parse("2022-09-11 22:04");
//        Date date1 = simpleDateFormat.parse("2022-09-11 22:30");
//        Goods_work goods_work = new Goods_work("A2",date,date1,"广州","暂时没有要说");
////        Integer integer = goodsService.update_new_Goods_Work(goods_work);
//        System.out.println(integer);

//        List<Ready_work> list = readyDao.get_WorkReady_user("A2", 0);
//        String str = "";
//        for (int i = 0; i < list.size(); i++) {
//            int res = new Date().compareTo(list.get(i).getTime_end());
//            System.out.println(list.get(i).getId()+"??>"+res);
//            if (res == 0 || res == 1) {
//                str += list.get(i).getId();
//                str += ",";
////                list.remove(list.get(i));
//            }
//        }
//        System.out.println(str);

    }

    @Autowired
    U_W_MesDao uWMesDao;

    @Test
    void test2() {
        uWMesDao.updata_Url_Bos_B("ZG","test1","B2");
    }

    @Test
    void test1() throws FileNotFoundException {

        try {
            InputStream inputStream = new FileInputStream("C:\\Users\\LLP\\Desktop\\Spring\\test2.png");
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            inputStream.close();
            BASE64Encoder encoder = new BASE64Encoder();

            PutObjectResponse objectResponse = new MyBos().getBosClient().putObject("mytest01","test2.png",encoder.encode(bytes));
            System.out.println(objectResponse.getETag());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Autowired
    private LoginDao loginDao;

    @Test
    void test4(){
        Login_id testacc = loginDao.check_account("testacc");
        System.out.println(testacc.toString());
    }
}
