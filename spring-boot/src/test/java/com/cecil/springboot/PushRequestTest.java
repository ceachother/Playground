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

        StringReader reader = new StringReader("<pushtocenter><instanceuid>1.2.3</instanceuid><instanceuid>1.2.4</instanceuid><instanceuid>1.2.5</instanceuid></pushtocenter>");
        PushRequest person = (PushRequest) unmarshaller.unmarshal(reader);
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