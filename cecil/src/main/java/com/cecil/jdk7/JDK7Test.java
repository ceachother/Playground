/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-10-25 14:46
 * @Description:
 */
package com.cecil.jdk7;

import junit.framework.TestCase;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author LiMingChi 2016-10-25 14:46
 * @version V1.0
 */
public class JDK7Test extends TestCase{

    public static void main(String[] args) {
        Path folderStarter = Paths.get("D:/TEST");
        try {
            Files.walkFileTree(folderStarter, new SimpleFileVisitor<Path>(){

                @Override
                public FileVisitResult visitFile(Path file,
                                                 BasicFileAttributes attributes) throws IOException {
                    System.out.println(file);
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    System.out.println(dir);
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testFile() {
        Path source = Paths.get("D:\\Images\\xuaiyu\\0007ca1b.dcm");
        Path target = Paths.get("D:\\test\\test1\\test2\\f03e24a1.dcm");
        System.out.println(source.toString());
        try {
            if (!Files.exists(target.getParent())) {
                Files.createDirectories(target.getParent());
            }
            Files.copy(source, target,StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}