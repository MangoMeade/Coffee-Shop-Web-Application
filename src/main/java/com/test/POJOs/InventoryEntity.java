package com.test.POJOs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by user on 8/1/2017.
 */
@Entity
@Table(name = "inventory", schema = "coffeeshop", catalog = "")
public class InventoryEntity {
    private int itemsid;

    @Id
    @Column(name = "itemsid", nullable = false)
    public int getItemsid() {
        return itemsid;
    }

    public void setItemsid(int itemsid) {
        this.itemsid = itemsid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InventoryEntity that = (InventoryEntity) o;

        if (itemsid != that.itemsid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return itemsid;
    }
}
