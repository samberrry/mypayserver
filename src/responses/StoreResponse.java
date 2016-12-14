package responses;

/**
 * Created by Hessam! on 14.12.2016.
 */
public class StoreResponse extends Response {
    int storeid;
    String storename;

    public StoreResponse(int resultcode, String metadata, int storeid, String storename) {
        super(resultcode, metadata);
        this.storeid = storeid;
        this.storename = storename;
    }

    public int getStoreid() {
        return storeid;
    }

    public String getStorename() {
        return storename;
    }

    public void setStoreid(int storeid) {
        this.storeid = storeid;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }
}
