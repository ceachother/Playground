package com.cecil.grava; /**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-05-24 14:47
 * @Description:
 */

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ComparisonChain;
import com.google.common.io.Files;
import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * @author LiMingChi 2016-05-24 14:47
 * @version V1.0
 */
public class Test extends TestCase {

    public static void main(String[] args) {
//        Optional<Integer> possible = Optional.fromNullable(null);
//        System.out.println(possible.isPresent()); // returns true
////        System.out.println(possible.get()); // returns 5
//        System.out.println(possible.absent());
//        System.out.println(possible);
//
//        Integer i = 1;
//        System.out.println(MoreObjects.toStringHelper(i).add("i",i).toString());
        Integer i2 = ComparisonChain.start()
                .compare(1, 1)
                .compare(5, 10)
                .compare(1, 5)
                .result();
        System.out.println(i2);
        System.out.println(Strings.isNullOrEmpty(null));
    }

    /**
     * 将方法的返回类型指定为Optional，也可以迫使调用者思考返回的引用缺失的情形。
     *
     * @param
     * @return
     * @author LiMingChi
     */
    public void testOptional() throws Exception {
        //Make an Optional containing the given non-null value, or fail fast on null.
        Optional<Integer> possible = Optional.of(6);
        //Return an absent Optional of some type.
        Optional<Integer> absentOpt = Optional.absent();
        //Turn the given possibly-null reference into an Optional, treating non-null as present and null as absent.
        Optional<Integer> NullableOpt = Optional.fromNullable(null);
        Optional<Integer> NoNullableOpt = Optional.fromNullable(10);

        if (possible.isPresent()) {
            System.out.println("possible isPresent:" + possible.isPresent());
            System.out.println("possible value:" + possible.get());
        }
        if (absentOpt.isPresent()) {
            System.out.println("absentOpt isPresent:" + absentOpt.isPresent());
        }
        if (NullableOpt.isPresent()) {
            System.out.println("fromNullableOpt isPresent:" + NullableOpt.isPresent());
        }
        if (NoNullableOpt.isPresent()) {
            System.out.println("NoNullableOpt isPresent:" + NoNullableOpt.isPresent());
        }
    }

    public void testMethodReturn() {
        Optional<Long> value = method();
        if (value.isPresent() == true) {
            System.out.println("return value: " + value.get());
        } else {

            System.out.println("return value: " + value.or(-12L));
        }

        System.out.println("return value orNull: " + value.orNull());

        Optional<Long> valueNoNull = methodNoNull();
        if (valueNoNull.isPresent() == true) {
            Set<Long> set = valueNoNull.asSet();
            System.out.println("return value size of set: " + set.size());
            System.out.println("return value: " + valueNoNull.get());
        } else {
            System.out.println("return value: " + valueNoNull.or(-12L));
        }

        System.out.println("return value orNull: " + valueNoNull.orNull());
    }

    private Optional<Long> method() {
        return Optional.fromNullable(null);
    }

    private Optional<Long> methodNoNull() {
        return Optional.fromNullable(15L);
    }

    public void testIO() {
        File file1 = new File("D:\\test\\test.dcm");
        File file2 = new File("D:\\images\\xuaiyu\\0007ca1b.dcm");
        try {
            System.out.println(Files.equal(file1, file2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}