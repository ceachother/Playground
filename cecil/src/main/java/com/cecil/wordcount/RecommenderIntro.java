package com.cecil.wordcount;

import org.apache.mahout.cf.taste.impl.model.file.*;
import org.apache.mahout.cf.taste.impl.neighborhood.*;
import org.apache.mahout.cf.taste.impl.recommender.*;
import org.apache.mahout.cf.taste.impl.similarity.*;
import org.apache.mahout.cf.taste.model.*;
import org.apache.mahout.cf.taste.neighborhood.*;
import org.apache.mahout.cf.taste.recommender.*;
import org.apache.mahout.cf.taste.similarity.*;

import java.io.File;
import java.util.List;

public class RecommenderIntro {

    private RecommenderIntro(){}

    public static void main (String args[])throws Exception{
        // step:1 构建模型
        DataModel  model =new FileDataModel(new File("D:\\test\\test.txt"));//文件名一定要是绝对路径
        //2 计算相似度
        UserSimilarity similarity =new PearsonCorrelationSimilarity(model);
        //3 查找k紧邻 4 构造推荐引擎
        UserNeighborhood neighborhood =new NearestNUserNeighborhood(2,similarity,model);
        Recommender recommender= new GenericUserBasedRecommender(model,neighborhood,similarity);
        List<RecommendedItem> recommendations =recommender.recommend(1, 2);//为用户1推荐两个ItemID
        for(RecommendedItem recommendation :recommendations){
            System.out.println(recommendation);
        }
    }
}  