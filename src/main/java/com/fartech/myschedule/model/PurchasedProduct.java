package com.fartech.myschedule.model;

import java.util.List;

public class PurchasedProduct {
    private List<Product> productList;
    private List<Purchase> purchaseList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    @Override
    public String toString() {
        return "PurchasedProduct{" +
                "productList=" + productList +
                ", purchaseList=" + purchaseList +
                '}';
    }
}
