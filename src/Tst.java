import com.google.gson.Gson;
import responses.Response;

/**
 * Created by Hessam! on 06.12.2016.
 */
public class Tst {
    public String convertTojson(Response response)
    {
        Gson gson = new Gson();
        String jsonString = gson.toJson(response,Response.class);
        return jsonString;
    }
}
