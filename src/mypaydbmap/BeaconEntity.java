package mypaydbmap;

import javax.persistence.*;

/**
 * Created by Hessam! on 13.12.2016.
 */
@Entity
public class BeaconEntity {
    private int idbeacon;
    private String name;
    private String uuid;
    private Integer majorid;
    private Integer minorid;
    private Integer idstore;

    @Id
    @Column(name = "idbeacon", nullable = false)
    public int getIdbeacon() {
        return idbeacon;
    }

    public void setIdbeacon(int idbeacon) {
        this.idbeacon = idbeacon;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "uuid", nullable = false, length = 200)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "majorid", nullable = true)
    public Integer getMajorid() {
        return majorid;
    }

    public void setMajorid(Integer majorid) {
        this.majorid = majorid;
    }

    @Basic
    @Column(name = "minorid", nullable = true)
    public Integer getMinorid() {
        return minorid;
    }

    public void setMinorid(Integer minorid) {
        this.minorid = minorid;
    }

    @Basic
    @Column(name = "idstore", nullable = true)
    public Integer getIdstore() {
        return idstore;
    }

    public void setIdstore(Integer idstore) {
        this.idstore = idstore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BeaconEntity that = (BeaconEntity) o;

        if (idbeacon != that.idbeacon) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
        if (majorid != null ? !majorid.equals(that.majorid) : that.majorid != null) return false;
        if (minorid != null ? !minorid.equals(that.minorid) : that.minorid != null) return false;
        if (idstore != null ? !idstore.equals(that.idstore) : that.idstore != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idbeacon;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (majorid != null ? majorid.hashCode() : 0);
        result = 31 * result + (minorid != null ? minorid.hashCode() : 0);
        result = 31 * result + (idstore != null ? idstore.hashCode() : 0);
        return result;
    }
}
