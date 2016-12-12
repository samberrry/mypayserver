package mypaydbmap;

import javax.persistence.*;

/**
 * Created by Hessam! on 03.12.2016.
 */
@Entity
public class LogEntity {
    private int idlog;
    private int number;
    private String name;
    private String description;

    public LogEntity(int number, String name, String description) {
        this.number = number;
        this.name = name;
        this.description = description;
    }

    public LogEntity() {
    }

    @Id
    @Column(name = "idlog", nullable = false)
    public int getIdlog() {
        return idlog;
    }

    public void setIdlog(int idlog) {
        this.idlog = idlog;
    }

    @Basic
    @Column(name = "number", nullable = false)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 16)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 250)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogEntity logEntity = (LogEntity) o;

        if (idlog != logEntity.idlog) return false;
        if (number != logEntity.number) return false;
        if (name != null ? !name.equals(logEntity.name) : logEntity.name != null) return false;
        if (description != null ? !description.equals(logEntity.description) : logEntity.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idlog;
        result = 31 * result + number;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
