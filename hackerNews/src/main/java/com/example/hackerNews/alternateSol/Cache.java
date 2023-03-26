package com.example.hackerNews.alternateSol;//package com.example.demo;
//
//import com.example.demo.model.Story;
//
//import java.util.List;
//
//public class Cache {
//    private static Cache single_instance = null;
//    private static long startTime;
//    private static long endTime;
//    private static List<Story> stories;
//
//
//
//    private Cache(){
//        startTime=System.currentTimeMillis();
//    }
//    static void reset(List<Story> Story){
//        startTime=System.currentTimeMillis();
//        stories= Story;
//    }
//    static List<Story> getStory(){
//        return stories;
//    }
//    static boolean  isValid(){
//        if(single_instance == null){
//            single_instance=new Cache();
//            return false;
//        }else{
//            endTime=System.currentTimeMillis();
//            if((endTime-startTime)<900000)
//                return true;
//            else
//                return false;
//        }
//    }
//}
