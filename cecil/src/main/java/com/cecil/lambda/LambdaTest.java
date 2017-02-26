package com.cecil.lambda;


import java.security.cert.PKIXRevocationChecker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static groovy.ui.text.StructuredSyntaxHandler.REGEXP;

/**
 * Created by cecillee on 19/2/2017.
 */
public class LambdaTest {


    public static void main(String[] args) {
//        String[] array = {"test1","test2","test3"};
//        Arrays.stream(array)
//                .map(string->string+"cecil")
//                .map(String::toUpperCase)
//                .forEach(System.out::println);

        printList();
    }

    private static void printList() {
        List<Image> images = new ArrayList<>();
        Image image1 = new Image();
        image1.setUid("1");
        image1.setTime(1);

        Image image2 = new Image();
        image2.setUid("2");
        image2.setTime(15321);

        Image image3 = new Image();
        image3.setUid("3");
        image3.setTime(115321);

        Image image4 = new Image();
        image4.setUid("4");
        image4.setTime(215321);

        Image image5 = new Image();
        image5.setUid("5");
        image5.setTime(172131);

        Image image6 = new Image();
        image6.setUid("6");
        image6.setTime(84512);

        Image image7 = new Image();
        image7.setUid("7");
        image7.setTime(115321);

        Image image8 = new Image();
        image8.setUid("8");
        image8.setTime(212121);

        Image image9 = new Image();
        image9.setUid("9");
        image9.setTime(221212);

        Image image10 = new Image();
        image10.setUid("10");
        image10.setTime(230105);

        Image image11 = new Image();
        image11.setUid("11");
        image11.setTime(null);


        images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);
        images.add(image5);
        images.add(image6);
        images.add(image7);
        images.add(image8);
        images.add(image9);
        images.add(image10);
        images.add(image11);

//        sortedList(images);
//        nullableList(images);
        reduce(images);
    }
    //倒序排序，并去掉某个时间段的记录
    private static void sortedList(List<Image> images) {
        images.stream()
                .filter(image -> image.getTime()< 200000 || image.getTime() >220000)
                .sorted((image1, image2) -> image2.getTime().compareTo(image1.getTime()))
                .forEach(image -> System.out.println(image.getTime()));

    }

    //打印非空的时间
    private static void nullableList(List<Image> images) {
        images.stream()
                .forEach(image -> Optional.ofNullable(image.getTime()).ifPresent(System.out::println));

    }

    //无限连接map
    private static void get(List<Image> images) {
        images.stream()
                .map(Image::getUid)
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }

    private static void reduce(List<Image> images) {
        images.stream()
                .filter(image->Optional.ofNullable(image.getTime()).isPresent())
                .reduce(Image::concat)
                .ifPresent(image -> System.out.println(image.getUid()));

    }
}
