package com.tuba.yuanyc.reconstruction;

import java.util.Arrays;
import java.util.List;

/**
 * Author ：yuanyc
 * Time ：2017/6/12
 * Description ：重构代码分析类
 */

public class Reconstruction {
    //----------------------------------------------
    private int number;

    /**
     * 需要重构的情形一：
     * <p>内联函数，视情况进行重构</p>
     *
     * @return
     */
    private int method1_before() {
        return getNumber() ? 1 : 2;
    }

    private boolean getNumber() {
        return number > 5;
    }

    /**
     * 针对情形一重构之后的效果
     * <p>不再调用getNumber()方法直接在此方法内部进行逻辑判断</p>
     *
     * @return
     */
    private int method1_after() {
        return number > 5 ? 1 : 2;
    }

    //----------------------------------------------

    //----------------------------------------------

    /**
     * 需要重构的情形二：
     * <p>内联临时变量，视情况进行重构</p>
     *
     * @return
     */
    private boolean method2_before() {
        boolean tempNumber = getNumber();
        return tempNumber;
    }

    /**
     * 针对情形二重构之后的效果：
     * <p>内联临时变量，视情况进行重构</p>
     *
     * @return
     */
    private boolean method2_after() {
        return getNumber();
    }

    //----------------------------------------------

    //----------------------------------------------
    private String temp = "abcd";

    /**
     * 需要重构的情形三：
     * <p>引入解释性变量（针对复杂表达式情形），视情况进行重构</p>
     */
    private void method3_before() {

        if (temp.toUpperCase().indexOf("ABC") > -1 && temp.toUpperCase().indexOf("D") > -1 && temp.toUpperCase().length() > 4) {
            //doSomthing
        }
    }

    /**
     * 针对情形三重构之后的效果：
     * <p>引入解释性变量（针对复杂表达式情形），视情况进行重构</p>
     */
    private void method3_after() {
        boolean condition_1 = temp.toUpperCase().indexOf("ABC") > -1;
        boolean condition_2 = temp.toUpperCase().indexOf("D") > -1;
        boolean condition_3 = temp.toUpperCase().length() > 4;
        if (condition_1 && condition_2 && condition_3) {
            //doSomthing
        }
    }
    //----------------------------------------------

    //----------------------------------------------

    /**
     * 需要重构的情形三：
     * <p>替换算法，视情况进行重构</p>
     */
    private String method4_before(String[] people) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].equals("A")) {
                return "A";
            }
            if (people[i].equals("B")) {
                return "B";
            }
            if (people[i].equals("C")) {
                return "C";
            }
        }
        return "";
    }

    /**
     * 需要重构的情形三：
     * <p>替换算法，视情况进行重构</p>
     */
    private String method4_after(String[] people) {
        List<String> asList = Arrays.asList(new String[]{"A", "B", "C"});
        for (int i = 0; i < people.length; i++) {
            if (asList.contains(people[i])) {
                return people[i];
            }
        }
        return "";
    }
}
