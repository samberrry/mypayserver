package responses;

/**
 * Created by Hessam! on 05.12.2016.
 */
public class Response {
     int resultcode ;
     String metadata;

    public Response(int resultcode, String metadata) {
        this.resultcode = resultcode;
        this.metadata = metadata;
    }

    public Response() {
    }

    public int getResultcode() {
        return resultcode;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setResultcode(int resultcode) {
        this.resultcode = resultcode;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
}
