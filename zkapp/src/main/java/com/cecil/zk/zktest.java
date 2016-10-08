/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-05-19 18:04
 * @Description:
 */
package com.cecil.zk;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;

/**
 * @author LiMingChi 2016-05-19 18:04
 * @version V1.0
 */
public class zktest {

    public static void main(String[] args)
    {
        try {
            //����һ��Zookeeperʵ������һ������ΪĿ���������ַ�Ͷ˿ڣ��ڶ�������ΪSession��ʱʱ�䣬������Ϊ�ڵ�仯ʱ�Ļص�����
            ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 500000,new Watcher() {
                // ������б��������¼�
                public void process(WatchedEvent event) {
                    System.out.println("value or status has been changed");
                }
            });
            System.out.println("delete");
            zk.delete("/cecil", -1);

            System.out.println("create");
            //����һ���ڵ�cecil��������mydata,������ACLȨ�޿��ƣ��ڵ�Ϊ�����Ե�(���ͻ���shutdown��Ҳ������ʧ)
            zk.create("/cecil", "mydata".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);


            System.out.println("create");
            //��cecil���洴��һ��childone znode,����Ϊchildone,������ACLȨ�޿��ƣ��ڵ�Ϊ�����Ե�
            zk.create("/cecil/childone","childone".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);

            System.out.println("getChildren");
            //ȡ��/cecil�ڵ��µ��ӽڵ�����,����List<String>
            List<String> list = zk.getChildren("/cecil", true);

            System.out.println("getData");
            //ȡ��/cecil/childone�ڵ��µ�����,����byte[]
            byte[] bytes = zk.getData("/cecil/childone", true, null);

            System.out.println("setData");
            //�޸Ľڵ�/cecil/childone�µ����ݣ�����������Ϊ�汾�������-1���ǻ����ӱ��޸ĵ����ݰ汾��ֱ�Ӹĵ�
            zk.setData("/cecil/childone","childonemodify".getBytes(), -1);

            System.out.println("setData2");
            //�޸Ľڵ�/cecil/childone�µ����ݣ�����������Ϊ�汾�������-1���ǻ����ӱ��޸ĵ����ݰ汾��ֱ�Ӹĵ�
            zk.setData("/cecil/childone","childonemodify2".getBytes(), -1);

            System.out.println("setData3");
            //�޸Ľڵ�/cecil/childone�µ����ݣ�����������Ϊ�汾�������-1���ǻ����ӱ��޸ĵ����ݰ汾��ֱ�Ӹĵ�
            zk.setData("/cecil/childone","childonemodify3".getBytes(), -1);

            System.out.println("getData");
            bytes = zk.getData("/cecil/childone", true, null);

            System.out.println("delete");
            //ɾ��/cecil/childone����ڵ㣬�ڶ�������Ϊ�汾����1�Ļ�ֱ��ɾ�������Ӱ汾
            zk.delete("/cecil/childone", -1);


            //�ر�session
            zk.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}