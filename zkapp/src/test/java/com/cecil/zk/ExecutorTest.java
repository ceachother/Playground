package com.cecil.zk;

import junit.framework.TestCase;

/**
 * @author LiMingChi 2016-05-20 15:34
 * @version V1.0
 */
public class ExecutorTest extends TestCase{


    public void testExecutor()
    {
        String hostPort = "192.168.130.51:2181";
        String znode = "/cecil1";
        String filename = "testfile";
        String exec[] = null;
        try {
            Executor executor = new Executor(hostPort, znode, filename, exec);
            executor.run();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}