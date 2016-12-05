package mypaydbmap;

import javax.persistence.*;

/**
 * Created by Hessam! on 03.12.2016.
 */
@Entity
//@IdClass(PurchaseHasGoodsEntityPK.class)
public class PurchaseHasGoodsEntity {
    private int idpurchase;
    private int idgoods;
    private int number;

    @Id
    @Column(name = "idpurchase", nullable = false)
    public int getIdpurchase() {
        return idpurchase;
    }

    public void setIdpurchase(int idpurchase) {
        this.idpurchase = idpurchase;
    }

    @Id
    @Column(name = "idgoods", nullable = false)
    public int getIdgoods() {
        return idgoods;
    }

    public void setIdgoods(int idgoods) {
        this.idgoods = idgoods;
    }

    @Basic
    @Column(name = "number", nullable = false)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseHasGoodsEntity that = (PurchaseHasGoodsEntity) o;

        if (idpurchase != that.idpurchase) return false;
        if (idgoods != that.idgoods) return false;
        if (number != that.number) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpurchase;
        result = 31 * result + idgoods;
        result = 31 * result + number;
        return result;
    }
}
