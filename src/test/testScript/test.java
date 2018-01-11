package testScript;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by fengtiepeng on 2017/10/27.
 */
public class test {

    @Test
    public void test(){
        List<Integer> listA=new ArrayList<>();
        for(int i=0;i<10000000;i++){
            listA.add(i);
           /* System.out.println(listA.get(i));*/
        }
        List<Integer> listB=new ArrayList<>();
        System.out.println("开始时间:"+new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
       /* for(int i=listA.size()-1;i>=0;i--){
            listB.add(listA.get(i));
        }*/
        Collections.reverse(listA);
        System.out.println("结束时间:"+new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(new Date()));
        /*for(Integer i:listB){
            System.out.println(i);
        }*/
        listA.addAll(listB);

    }
}

