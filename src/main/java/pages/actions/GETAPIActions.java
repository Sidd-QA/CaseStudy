package pages.actions;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.ArrayList;

public class GETAPIActions {
    private Logger logger;
    Response response;

    public GETAPIActions(){
         this.logger= LogManager.getLogger(GETAPIActions.class);
    }


    public String setBaseURL(String url){
        logger.info("Setting base URL for request, and URL is :: "+url);
       return RestAssured.baseURI = url;
    }

    public void sendRequest(String requestURL){
        logger.info("Sending Request.");
        response = RestAssured.get(requestURL);
    }


    public void validateStatusCode(String statusCode){
        logger.info("Validating status code is equal to :: "+statusCode);
        String sCode= String.valueOf(response.getStatusCode());
        Assert.assertEquals(sCode,statusCode);
    }

    public void validateContentOfResponse(String expectedName){
    logger.info("Validating Content From Response");
        JsonPath jsonPath = response.jsonPath();
        ArrayList<String> name=jsonPath.get("name");
        Assert.assertTrue(name.contains(expectedName),"Name in response");
    }

}
