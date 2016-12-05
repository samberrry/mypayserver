package mypaydbmap;

import javax.persistence.*;

/**
 * Created by Hessam! on 03.12.2016.
 */
@Entity
public class PurchaseEntity {
    private int idpurchase;
    private int total;
    private String bank;
    private String date;
    private int iduser;
    private String type;
    private int transactionid;

    @Id
    @Column(name = "idpurchase", nullable = false)
    public int getIdpurchase() {
        return idpurchase;
    }

    public void setIdpurchase(int idpurchase) {
        this.idpurchase = idpurchase;
    }

    @Basic
    @Column(name = "total", nullable = false)
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Basic
    @Column(name = "bank", nullable = true, length = 45)
    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Basic
    @Column(name = "date", nullable = true, length = 10)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "iduser", nullable = false)
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 20)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "transactionid", nullable = false)
    public int getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(int transactionid) {
        this.transactionid = transactionid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseEntity that = (PurchaseEntity) o;

        if (idpurchase != that.idpurchase) return false;
        if (total != that.total) return false;
        if (iduser != that.iduser) return false;
        if (transactionid != that.transactionid) return false;
        if (bank != null ? !bank.equals(that.bank) : that.bank != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpurchase;
        result = 31 * result + total;
        result = 31 * result + (bank != null ? bank.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + iduser;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + transactionid;
        return result;
    }
}
