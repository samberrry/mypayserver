package mypaydbmap;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Hessam! on 03.12.2016.
 */
public class PresenceEntityPK implements Serializable {
    private int iduser;
    private int idstore;

    @Column(name = "iduser", nullable = false)
    @Id
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Column(name = "idstore", nullable = false)
    @Id
    public int getIdstore() {
        return idstore;
    }

    public void setIdstore(int idstore) {
        this.idstore = idstore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PresenceEntityPK that = (PresenceEntityPK) o;

        if (iduser != that.iduser) return false;
        if (idstore != that.idstore) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iduser;
        result = 31 * result + idstore;
        return result;
    }
}
