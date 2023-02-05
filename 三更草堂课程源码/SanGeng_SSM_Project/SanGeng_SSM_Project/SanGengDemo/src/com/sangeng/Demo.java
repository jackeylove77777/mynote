package com.sangeng;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        WebApplicationContext springContext = new WebApplicationContext();
        springContext.put("service","service");

        WebApplicationContext mvcContext = new WebApplicationContext();

        //设置mvc容器的父容器
        mvcContext.setParent(springContext);
        mvcContext.put("controller","controller");

        //从mvc容器中获取service
        System.out.println(mvcContext.get("service"));
    }
}
//用来模拟代替容器类
class WebApplicationContext{
    //用来记录父容器的引用
    private WebApplicationContext parent;

    public Map<String,String> map = new HashMap<>();

    public void put(String key,String value){
        map.put(key,value);
    }

    public void setParent(WebApplicationContext parent) {
        this.parent = parent;
    }

    public String get(String key){
        //从自己容器中获取
        String s = map.get(key);
        if(s==null&&parent!=null){
            //如果获取不到就从父容器中获取
            s = parent.get(key);
        }
        return s;
    }

}

