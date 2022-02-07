package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.pt.*;
import org.junit.Assert;
import pojo.Users;
import services.UsersService;
import io.restassured.response.Response;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;

public class UsersSteps  {

    private Response response;
    private UsersService usersService;
    private Users users;
    private Users user;

    @Dado("que o usuário quer criar um novo usuário")
    public void queOUsuarioQuerCriarUmNovoUsuario() {
        user = new Users();
        usersService = new UsersService();
    }

    @E("o usuário informar no campo {string} o valor {string}")
    public void oUsuarioInformarNoCampoOValor(String field, String value) {
        usersService.setField(user, field, value);
    }

    @Quando("o usuário salvar os dados")
    public void oUsuarioSalvarOsDados() {
        usersService.post(user);
    }

    @Então("^o usuário deverá ver o resultado \"([^\"]*)\"$")
    public void oUsuarioDeveraVerOResultado(String message) {
        int statusExpected = usersService.getFromMessageToStatus(message);
        Assert.assertEquals(statusExpected, usersService.getResponse().getStatusCode());
    }

    @E("o usuário buscar as informações deste mesmo usuário")
    public void oUsuarioBuscarAsInformacoesDesteMesmoUsuario() {
        usersService.get(usersService.getLastId());
    }

    @E("o usuário deveria ver no campo {string} o valor {string}")
    public void oUsuarioDeveriaVerNoCampoOValor(String field, String value) {
        Assert.assertEquals(value, usersService.getField(field));
    }

    @Dado("que o usuário já está na base de dados")
    public void queOUsuarioJaEstaNaBaseDeDados() {
        usersService = new UsersService();
        new Users();
        users = Users.builder().
                email("robson.correa@gft.com").
                full_name("Robson Agapito Correa").
                age(18).
                login("robsonagapito").
                build();
    }

    @Quando("^eu consultar um usuario$")
    public void euConsultarUmUsuario()  {
        usersService.get(2654);
    }

    @Entao("^sera apresentado todos os dados deste usuario$")
    public void seraApresentadoTodosOsDadosDesteUsuario()  {
        Assert.assertEquals(users.getLogin(),usersService.getField("login"));
        Assert.assertEquals(users.getAge(),Integer.valueOf(usersService.getField("age")));
        Assert.assertEquals(users.getEmail(),usersService.getField("email"));
        Assert.assertEquals(users.getFull_name(),usersService.getField("full_name"));
        Assert.assertEquals(200, usersService.getResponse().getStatusCode());
    }

    @E("o usuário deverá ter um schema válido para User Json")
    public void oUsuarioDeveraTerUmSchemaValidoParaUserJson() {
        assertThat(usersService.getResponse().getBody().prettyPrint(),
                   usersService.matchSchema());
    }

    @Dado("que o usuário já está na base de dados com yml")
    public void queOUsuarioJaEstaNaBaseDeDadosComYml() {
        usersService = new UsersService();
        HashMap data = usersService.getDataFile();
        new Users();
        users = Users.builder().
                email(data.get("email").toString()).
                full_name(data.get("full_name").toString()).
                age(Integer.valueOf(data.get("age").toString())).
                login(data.get("login").toString()).
                build();
    }

    @Quando("eu consultar um usuario com yml")
    public void euConsultarUmUsuarioComYml() {
        HashMap data = usersService.getDataFile();
        usersService.get(Integer.valueOf(data.get("id").toString()));
    }

    @E("o usuário atualizar as informações deste usuário")
    public void oUsuarioAtualizarAsInformacoesDesteUsuario() {
        usersService.put(user);
    }

    @Quando("o usuário deletar as informações deste usuário")
    public void oUsuarioDeletarAsInformacoesDesteUsuario() {
        usersService.delete(usersService.getLastId());    }


}
