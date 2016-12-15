package mypaydbmap;

import javax.persistence.*;

/**
 * Created by Hessam! on 15.12.2016.
 */
@Entity
public class BeaconEntity {
    private int idbeacon;
    private String name;
    private String uuid;
    private Integer major;
    private Integer minor;
    private Integer idstore;

    public BeaconEntity() {
    }

    public BeaconEntity(int idbeacon, String name, String uuid, Integer major, Integer minor, Integer idstore) {
        this.idbeacon = idbeacon;
        this.name = name;
        this.uuid = uuid;
        this.major = major;
        this.minor = minor;
        this.idstore = idstore;
    }

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
    @Column(name = "major", nullable = true)
    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    @Basic
    @Column(name = "minor", nullable = true)
    public Integer getMinor() {
        return minor;
    }

    public void setMinor(Integer minor) {
        this.minor = minor;
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
        if (major != null ? !major.equals(that.major) : that.major != null) return false;
        if (minor != null ? !minor.equals(that.minor) : that.minor != null) return false;
        if (idstore != null ? !idstore.equals(that.idstore) : that.idstore != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idbeacon;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (minor != null ? minor.hashCode() : 0);
        result = 31 * result + (idstore != null ? idstore.hashCode() : 0);
        return result;
    }
}
