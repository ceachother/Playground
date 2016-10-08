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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
        this.mockMvc.perform(get("/greeting/cecillee"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}