package mypaydbmap;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Hessam! on 03.12.2016.
 */
public class PurchaseHasGoodsEntityPK implements Serializable {
    private int idpurchase;
    private int idgoods;

    @Column(name = "idpurchase", nullable = false)
    @Id
    public int getIdpurchase() {
        return idpurchase;
    }

    public void setIdpurchase(int idpurchase) {
        this.idpurchase = idpurchase;
    }

    @Column(name = "idgoods", nullable = false)
    @Id
    public int getIdgoods() {
        return idgoods;
    }

    public void setIdgoods(int idgoods) {
        this.idgoods = idgoods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseHasGoodsEntityPK that = (PurchaseHasGoodsEntityPK) o;

        if (idpurchase != that.idpurchase) return false;
        if (idgoods != that.idgoods) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpurchase;
        result = 31 * result + idgoods;
        return result;
    }
}
