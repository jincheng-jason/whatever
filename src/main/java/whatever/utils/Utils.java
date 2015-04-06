package whatever.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lijc on 15/4/5.
 */
public class Utils {
    
    public static List<Object> returnSuccess(Object object){
        List<Object> returnList = new ArrayList<>();
        Map<String, Boolean> map = new HashMap<>();
        map.put("operation_result",Boolean.TRUE);
        returnList.add(map);
        returnList.add(object);
        return returnList;
    }

    public static List<Object> returnFailed(Object object){
        List<Object> returnList = new ArrayList<>();
        Map<String, Boolean> map = new HashMap<>();
        map.put("operation_result", Boolean.FALSE);
        returnList.add(map);
        returnList.add(object);
        return returnList;
    }


    
//    public static Map<String,String> returnSuccess(){
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("oper_code","1");
//        map.put("message","操作成功");
//        return map;
//    }
//
//    public static Map<String,String> returnFailed(){
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("oper_code","0");
//        map.put("message","操作失败");
//        return map;
//    }
//
//    public static Map<String,String> returnSuccess(String name){
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("oper_code","1");
//        map.put("message",name + "成功");
//        return map;
//    }
//
//    public static Map<String,String> returnFailed(String name){
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("oper_code","0");
//        map.put("message",name + "失败");
//        return map;
//    }
//
//    public static Map<String,String> voidValue(String name){
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("oper_code","0");
//        map.put("message",name + "缺少参数");
//        return map;
//    }
}
