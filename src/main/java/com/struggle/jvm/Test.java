package com.struggle.jvm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author strugglesnail
 * @date 2021/4/15
 * @desc
 */
public class Test {

    private Ntast ntast;
    private List<NewTast> newTastList;

    public void setNtast(Ntast ntast) {
        this.ntast = ntast;
    }
    public void setNewTastList(List<NewTast> newTastList) {
        this.newTastList = newTastList;
    }

    public static void main(String[] args) {
//        List<Test> testList = new ArrayList<>();
//        Test test = new Test();
//        test.setNewTastList(new ArrayList<>());
//        test.setNtast(new Ntast());
//        testList.add(test);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("key", new Ntast());
        map1.put("value", new ArrayList<NewTast>());
    }
}
