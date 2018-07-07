package com.saas.commons.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example extends Thread {

    private String url;
    
    //建造的线程池容量以及创建的线程池数量
    private final static int client = 500;

    private static long start = System.currentTimeMillis();
    
    public static void main(String[] agr) {
    	//创建线程池
        ExecutorService service = Executors.newFixedThreadPool(client);
        String[] urls = {"http://localhost:8080/hyplatform/api/login",""};
        Example example = new Example(urls[0]);
        //创建执行线程
        for (int i=0;i<client;i++){
        	 service.execute(example);
        	 System.out.print(i+"****");
        }
        service.shutdown();  
    }

    /**
     * 初始化
     *
     * @param url      提交地址
     */
    public Example(String url) {
        this.url = url;
    }

    private int count=100000;
//    private int submit = 0;
//    private int fee = 0;
    
    public /*synchronized同步多线程按序请求*/ void run() {
        while (this.count>0) {
        	Param param = new Param();
        	param.phone="17625010895";
        	param.password="123456";
            int result = post(param);
            if (result == 1) {
//                this.fee += 1;
                this.count -= 1;
            } else {
            	long timeSpend = (System.currentTimeMillis()-start)/1000;  
                System.out.println(timeSpend +"s" ); 
            }
        }
    }

    public int post(Param p) {
		return 1;
//    	List<NameValuePair> params = new ArrayList<>();
//		params.add(new BasicNameValuePair("phone", "17625010895"));
//		params.add(new BasicNameValuePair("password", "123456"));
//		CloseableHttpClient httpclient = HttpClients.createDefault();
//		HttpPost post = new HttpPost(url);
//		CloseableHttpResponse response = null;
//		try {
//			post.setHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT5.1; en-US; rv:0.9.4)");
//			post.addHeader("token", "C47B1071");
//			post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
//			response = httpclient.execute(post);
//			if (response.getStatusLine().getStatusCode() == 200) {
//                HttpEntity httpEntity = response.getEntity();
//                if (null != httpEntity) {
//					return 1;
//				} else {
////					System.out.println("--谢谢：-");
//					return 0;
//				}
//            }else {
//				return 0;
//			}
//        } catch (Exception exception){
//        	return 0;
//        } finally {
//            try {
//                httpclient.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }

    class Param {
        public String phone;
        public String password;
    }

}
