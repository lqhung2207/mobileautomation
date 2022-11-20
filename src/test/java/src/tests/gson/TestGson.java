package src.tests.gson;

import com.google.gson.Gson;
import src.test_data.models.LoginCred;
import src.test_data.utils.DataObjectBuilder;

public class TestGson {

    public static void main(String[] args) {
        Gson gson = new Gson();
        // From Json to Object
        String fileLocation = "/src/test/java/src/tests/gson/login.json";
        LoginCred[] loginCreds = DataObjectBuilder.buildDataObject(fileLocation, LoginCred[].class);
        for (LoginCred loginCred : loginCreds){
            System.out.println(loginCred);
        }

        // From object to Json
        LoginCred loginCred1 = new LoginCred("Ti", "12345678");
        System.out.println(gson.toJson(loginCred1));
    }
}
