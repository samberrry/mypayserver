package mypaydbmap;

import javax.persistence.*;

/**
 * Created by Hessam! on 03.12.2016.
 */
@Entity
//@IdClass(PresenceEntityPK.class)
public class PresenceEntity {
    private int iduser;
    private int idstore;
    private String date;

    @Id
    @Column(name = "iduser", nullable = false)
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Id
    @Column(name = "idstore", nullable = false)
    public int getIdstore() {
        return idstore;
    }

    public void setIdstore(int idstore) {
        this.idstore = idstore;
    }

    @Basic
    @Column(name = "date", nullable = true, length = 10)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PresenceEntity that = (PresenceEntity) o;

        if (iduser != that.iduser) return false;
        if (idstore != that.idstore) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iduser;
        result = 31 * result + idstore;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
