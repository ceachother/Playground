/**
 * @ProjectName:
 * @Copyright: 2014 ShangHai DJ HealthUnion Systems Co., Ltd. All Right Reserved.
 * @address: http://www.djhealthunion.com/
 * @date: 2016-08-31 14:56
 * @Description:
 */

import com.cecil.springboot.GreetingController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author LiMingChi 2016-08-31 14:56
 * @version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=GreetingController.class)
public class ControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(new GreetingController()).build();
    }

    @Test
    public void testController() throws Exception {
        this.mockMvc.perform(get("/greeting/xml/greet"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testPostXml() throws Exception {
//        PushRequest pushRequest = new PushRequest();
//        List<String> list = new ArrayList<String>();
//        list.add("1");
//        list.add("2");
//        pushRequest.setInstanceuid(list);

        String xml =
                "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" +
                        "<pushtocenter><instanceuids><instanceuid>1.2.3</instanceuid><instanceuid>1.2.4</instanceuid><instanceuid>1.2.5</instanceuid></instanceuids></pushtocenter>"
                +"<Greeting><content>1</content></Greeting>";

        this.mockMvc.perform(post("/greeting/post/postxml")
                        .contentType(MediaType.APPLICATION_XML)
                        .content(xml))
                    .andExpect(status().isOk())
                    .andDo(print());
    }

}