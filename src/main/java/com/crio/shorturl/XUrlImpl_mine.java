// package com.crio.shorturl;

// import java.io.StringWriter;
// import java.nio.charset.Charset;
// import java.util.Random;
// import javax.annotation.processing.Generated;
// import java.util.*;

// public class XUrlImpl_mine implements XUrl{
//     ArrayList<String> hit_counter = new ArrayList<String>();

//     Map<String, String> map = new HashMap<String, String>();
    
//     @Override
//     public String registerNewUrl(String longUrl) {
//         hit_counter.add(longUrl);
//         String end_point = endpoint_generator(9);
//         String shortUrl = "";
//         if(map.containsKey(longUrl)){
//             shortUrl = map.getOrDefault(longUrl, shortUrl);
//         }
//         else{
//             shortUrl = "http://short.url/" + end_point;
//             map.put(longUrl, shortUrl);
//         }
//         return shortUrl;
//     }

//     @Override
//     public String registerNewUrl(String longUrl, String shortUrl) {
//         map.putIfAbsent(longUrl, shortUrl);
//         return shortUrl;
//     }

//     @Override
//     public String getUrl(String shortUrl) {
//         String longUrl = "";
//         if(shortUrl == null){
//             longUrl = null;
//         }
//         for(Map.Entry<String, String> entry : map.entrySet()){
//             if(entry.getValue() == shortUrl){
//                 longUrl = entry.getKey();
//             }
//         }
//         return longUrl;
//     }

//     @Override
//     public Integer getHitCount(String longUrl) {
//         int hit_count = 0;

//         for(String url : hit_counter){
//             if(url == longUrl){
//                 hit_count = hit_count + 1;
//             }
//         }
//         return hit_count;
//     }

//     @Override
//     public String delete(String longUrl) {
//         map.remove(longUrl);
//         // System.out.println(map); 
//         return map.get(longUrl);
//     }

//     // reference taken from gfg
//     private String endpoint_generator(int size) {
//         String end_point = "";
//         byte[] bytes = new byte[256];
//         new Random().nextBytes(bytes);

//         end_point = new String(bytes, Charset.forName("UTF-8"));
//         StringBuffer sb = new StringBuffer();

//         for(int i = 0 ; i < end_point.length(); i++){
//             char ch = end_point.charAt(i);
//             if(((ch >= 'a' && ch <= 'z') 
//             || (ch >= 'A' && ch <= 'Z') 
//             || (ch >= '0' && ch <= '9')) && (size > 0)){
//                 sb.append(ch);
//                 size--;
//             }
//         }
//         end_point = sb.toString();
        
//         return end_point;
//     }
// } 