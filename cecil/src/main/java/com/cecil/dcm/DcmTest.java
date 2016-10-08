package com.cecil.dcm; /**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-07-28 10:26
 * @Description:
 */

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import org.dcm4che3.io.DicomInputStream;
import org.junit.Test;

import java.io.File;

/**
 * @author LiMingChi 2016-07-28 10:26
 * @version V1.0
 */
public class DcmTest {

    @Test
    public void readFile() throws Exception {
        File dcm = new File("D:\\DownloadFiles\\0803\\f03e24a1.dcm");
        Attributes attributes = new Attributes();
        try (DicomInputStream dis = new DicomInputStream(dcm)) {
            attributes = dis.readDataset(-1, Tag.PixelData);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        //study uid
        String studyUID = attributes.getString(Tag.StudyInstanceUID);
        System.out.println("studyUID" + studyUID);
        //accession number
        String accessionNO = attributes.getString(Tag.AccessionNumber);
        System.out.println("accessionNO" + accessionNO);
    }

}