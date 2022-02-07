package services;

import com.google.gson.Gson;
import config.Configuration;
import core.DataYaml;
import core.ReportType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import org.aeonbits.owner.ConfigCache;

import java.util.HashMap;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@Getter
@Setter
public class TestingSupport {

    private Configuration configuration;
    private String URI;
    private Response response;
    private Gson gson = new Gson();
    private Integer lastId;
    private String schemaFile;
    private HashMap dataFile;

    public TestingSupport() {
        setConfiguration(ConfigCache.getOrCreate(Configuration.class));
    }

    public void setDataFile(String fileName, String block){
       dataFile = DataYaml.getMapYamlValues(fileName,block);
    }

    void logResponse() {
        ReportType.reportToAllureHeaderAndBodyResponse(getResponse());
    }

    void logRequest(String body) {
        ReportType.reportToAllureUriRequest(getURI());
    }

    void logRequest() {
        ReportType.reportToAllureUriRequest(getURI());
    }

    public int getFromMessageToStatus(String message) {
        HashMap<String, Integer> statusCodes = new HashMap<String,Integer>();
        statusCodes.put("salvo com sucesso", 201);
        statusCodes.put("save with success", 201);
        statusCodes.put("sucesso", 200);
        statusCodes.put("success", 200);
        statusCodes.put("not content", 204);
        statusCodes.put("não encontrado", 404);
        statusCodes.put("not found", 404);
        statusCodes.put("não autorizado", 401);
        return statusCodes.get(message);
    }

    public JsonSchemaValidator matchSchema() {
        return matchesJsonSchemaInClasspath(schemaFile);
    }
}
