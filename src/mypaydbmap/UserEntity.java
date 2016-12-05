package mypaydbmap;

import javax.persistence.*;

/**
 * Created by Hessam! on 03.12.2016.
 */
@Entity
public class UserEntity {
    private int iduser;
    private String username;
    private String password;
    private String registryDate;
    private String type;
    private Integer age;
    private String phoneNumber;
    private String email;
    private Integer idstore;
    private byte isenable;

    public UserEntity() {
    }

    @Id

    @Column(name = "iduser", nullable = false)
    public int getIduser() {
        return iduser;
    }

    public UserEntity(String username, String password, String registryDate, String type, Integer age, String phoneNumber, String email, Integer idstore, byte isenable) {
        this.iduser = iduser;
        this.username = username;
        this.password = password;
        this.registryDate = registryDate;
        this.type = type;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idstore = idstore;
        this.isenable = isenable;
    }

    public UserEntity(String username, String password, String type, Integer age, String phoneNumber, String email, byte isenable) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isenable = isenable;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "registry_date", nullable = true, length = 10)
    public String getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(String registryDate) {
        this.registryDate = registryDate;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 45)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "phone_number", nullable = true, length = 45)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "idstore", nullable = true)
    public Integer getIdstore() {
        return idstore;
    }

    public void setIdstore(Integer idstore) {
        this.idstore = idstore;
    }

    @Basic
    @Column(name = "isenable", nullable = false)
    public byte getIsenable() {
        return isenable;
    }

    public void setIsenable(byte isenable) {
        this.isenable = isenable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (iduser != that.iduser) return false;
        if (isenable != that.isenable) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (registryDate != null ? !registryDate.equals(that.registryDate) : that.registryDate != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (idstore != null ? !idstore.equals(that.idstore) : that.idstore != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iduser;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (registryDate != null ? registryDate.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (idstore != null ? idstore.hashCode() : 0);
        result = 31 * result + (int) isenable;
        return result;
    }
}
