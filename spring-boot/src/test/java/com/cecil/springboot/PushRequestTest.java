package com.cecil.springboot;

import junit.framework.TestCase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * @author LiMingChi 2016-11-02 16:14
 * @version V1.0
 */
public class PushRequestTest extends TestCase{

    public void testXmlToList() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(PushRequest.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        String s =
//                "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\\n<pushtocenter>" +
//                "<instanceuid>1.2.3</instanceuid>\\r\\n<instanceuid>1.2.4</instanceuid><instanceuid>1.2.5</instanceuid></pushtocenter>";
        "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n" +
                "<pushtocenter>\n" +
                "\t<instanceuid>1.2.3啊</instanceuid>\n" +
                "\t<instanceuid>1.2.4岸边</instanceuid>\n" +
                "\t<instanceuid>1.2.5尺寸</instanceuid>\n" +
                "</pushtocenter>\n";
//        s = s.replace("\\r", "").replace("\\n", "");
        StringReader stringReader = new StringReader(new StringBuffer(s).toString());
        PushRequest person = (PushRequest) unmarshaller.unmarshal(stringReader);
        System.out.println(person.getInstanceuid());
    }

    public void testXmlToGreet() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Greeting.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader("<Greeting><content>1</content></Greeting>");
        Greeting greeting = (Greeting) unmarshaller.unmarshal(reader);
        System.out.println(greeting.getContent());
    }


}