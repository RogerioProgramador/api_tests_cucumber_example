package services;

import io.restassured.http.ContentType;
import lombok.extern.log4j.Log4j2;
import pojo.Users;
import static io.restassured.RestAssured.given;

@Log4j2
public class UsersService extends TestingSupport {

    public UsersService(){
        setURI(getConfiguration().urlBase() + "/users");
        setSchemaFile("schemas/users/users-schema.json");
        setDataFile("Usuarios","usuarios");
    }

    public void setField(Users user, String field, String value) {
        switch (field){
            case "login": user.setLogin(value); break;
            case "full_name": user.setFull_name(value); break;
            case "email": user.setEmail(value); break;
            case "age": user.setAge(Integer.valueOf(value)); break;
            default: break;
        }
    }

    public String getField(String field) {
        String res = "";
        Users usersAux = getGson().fromJson(getResponse().jsonPath().prettify(), Users.class);

        switch (field){
            case "login": res  = usersAux.getLogin(); break;
            case "full_name": res = usersAux.getFull_name(); break;
            case "email": res = usersAux.getEmail(); break;
            case "age": res = usersAux.getAge().toString(); break;
            default: break;
        }
        return res;
    }

    public void post(Users user) {
        String bodySended = getGson().toJson(user);
        logRequest(bodySended);
        setResponse(given().
                        when().
                            contentType(ContentType.JSON).
                            accept(ContentType.JSON).
                            body(bodySended).
                        post(getURI()).
                        then().extract().response()
                    );
        logResponse();
        Users usersAux = getGson().fromJson(getResponse().jsonPath().prettify(), Users.class);
        setLastId(usersAux.getId());
    }

    public void get(Integer id) {
        String url = getURI() + "/" + id;
        logRequest();
        setResponse(given().
                when().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                get(url).
                then().extract().response()
        );
        logResponse();
    }

    public void put(Users user) {
        String bodySended = getGson().toJson(user);
        String url = getURI() + "/" + getLastId();
        logRequest(bodySended);
        setResponse(given().
                when().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(bodySended).
                put(url).
                then().extract().response()
        );
        logResponse();
    }

    public void delete(Integer id) {
        String url = getURI() + "/" + id;
        logRequest();
        setResponse(given().
                when().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                delete(url).
                then().extract().response()
        );
        logResponse();
    }
}
