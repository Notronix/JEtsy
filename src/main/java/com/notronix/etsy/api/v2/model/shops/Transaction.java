package com.notronix.etsy.api.v2.model.shops;

import com.notronix.etsy.api.v2.model.listings.ListingInventory;
import com.notronix.etsy.api.v2.model.listings.ListingProduct;

import java.time.Instant;
import java.util.List;

public interface Transaction
{
    Long getTransactionId();
    String getTitle();
    String getDescription();
    Long getSellerUserId();
    Long getBuyerUserId();
    Instant getCreationTsz();
    Instant getPaidTsz();
    Instant getShippedTsz();
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
