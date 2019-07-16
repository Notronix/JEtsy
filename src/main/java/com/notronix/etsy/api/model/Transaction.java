package com.notronix.etsy.api.model;

import java.util.List;

public interface Transaction
{
    Long getTransactionId();
    String getTitle();
    String getDescription();
    Long getSellerUserId();
    Long getBuyerUserId();
    Float getCreationTsz();
    Float getPaidTsz();
    Float getShippedTsz();
    Float getPrice();
    String getCurrencyCode();
    Integer getQuantity();
    List<String> getTags();
    List<String> getMaterials();
    Long getImageListingId();
    Long getReceiptId();
    Float getShippingCost();
    Boolean getDigital();
    String getFileData();
    Long getListingId();
    Boolean getQuickSale();
    Long getSellerFeedbackId();
    Long getBuyerFeedbackId();
    String getTransactionType();
    String getUrl();
    List<? extends ListingInventory> getVariations();
    ListingProduct getListingProduct();
}
