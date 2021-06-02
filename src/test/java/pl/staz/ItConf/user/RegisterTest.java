//package pl.staz.ItConf.user;
//
//
//import jdk.jfr.ContentType;
//import org.junit.BeforeClass;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static io.restassured.RestAssured.given;
//
//@RunWith(SpringRunner.class)
//public class RegisterTest {
//    @BeforeClass
//    public static void register_admin(){
//        given()
//                .body(new RegisterRequest("admin","admin"))
//                .contentType(ContentType.JSON)
//                .post("/api/register");
//    }
//
//}
