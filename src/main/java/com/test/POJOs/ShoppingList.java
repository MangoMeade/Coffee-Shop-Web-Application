package com.test.POJOs;

import java.util.ArrayList;

/*
Aaron Board

7/24/2017
 */
public class ShoppingList {
    private ArrayList<ItemsEntity> shoppingList;

    public ShoppingList() {
    }

    public ArrayList<ItemsEntity> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ArrayList<ItemsEntity> shoppingList) {
        this.shoppingList = shoppingList;
    }
}
