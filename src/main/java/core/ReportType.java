package core;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ReportType {

    public static void reportToAllureHeaderAndBodyResponse(Response response){
        Allure.addAttachment(AllureTypeFile.RESPONSE_HEADERS,response.getHeaders().toString());
        Allure.addAttachment(AllureTypeFile.RESPONSE_BODY,response.getBody().prettyPrint());
        Allure.addAttachment(AllureTypeFile.RESPONSE_STATUSCODE, String.valueOf(response.getStatusCode()));
        log.info("Header: " + response.getHeaders().toString());
        log.info("Status Code: " + response.getStatusCode());
    }

    public static void reportToAllureUriRequest(String uri){
        Allure.addAttachment(AllureTypeFile.REQUEST,uri);
        log.info("URI: " + uri);
    }

    public static void reportToAllureSendBody(String bodySended) {
        Allure.addAttachment(AllureTypeFile.REQUEST_BODY, bodySended);
        log.info("Body: " + bodySended);
    }
}
