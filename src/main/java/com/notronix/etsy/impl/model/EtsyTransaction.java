package com.notronix.etsy.impl.model;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.model.Transaction;

import java.util.List;

public class EtsyTransaction implements Transaction
{
    @SerializedName(value = "transaction_id")
    private Long transactionId;
    private String title;
    private String description;

    @SerializedName(value = "seller_user_id")
    private Long sellerUserId;

    @SerializedName(value = "buyer_user_id")
    private Long buyerUserId;

    @SerializedName(value = "creation_tsz")
    private Float creationTsz;

    @SerializedName(value = "paid_tsz")
    private Float paidTsz;

    @SerializedName(value = "shipped_tsz")
    private Float shippedTsz;

    private Float price;

    @SerializedName(value = "currency_code")
    private String currencyCode;
    private Integer quantity;
    private List<String> tags;
    private List<String> materials;

    @SerializedName(value = "image_listing_id")
    private Long imageListingId;

    @SerializedName(value = "receipt_id")
    private Long receiptId;

    @SerializedName(value = "shipping_cost")
    private Float shippingCost;

    @SerializedName(value = "is_digital")
    private Boolean digital;

    @SerializedName(value = "file_data")
    private String fileData;

    @SerializedName(value = "listing_id")
    private Long listingId;

    @SerializedName(value = "is_quick_sale")
    private Boolean quickSale;

    @SerializedName(value = "seller_feedback_id")
    private Long sellerFeedbackId;

    @SerializedName(value = "buyer_feedback_id")
    private Long buyerFeedbackId;

    @SerializedName(value = "transaction_type")
    private String transactionType;
    private String url;

    private List<EtsyListingInventory> variations;

    @SerializedName(value = "product_data")
    private EtsyListingProduct ListingProduct;

    @Override
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Long getSellerUserId() {
        return sellerUserId;
    }

    public void setSellerUserId(Long sellerUserId) {
        this.sellerUserId = sellerUserId;
    }

    @Override
    public Long getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(Long buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    @Override
    public Float getCreationTsz() {
        return creationTsz;
    }

    public void setCreationTsz(Float creationTsz) {
        this.creationTsz = creationTsz;
    }

    @Override
    public Float getPaidTsz() {
        return paidTsz;
    }

    public void setPaidTsz(Float paidTsz) {
        this.paidTsz = paidTsz;
    }

    @Override
    public Float getShippedTsz() {
        return shippedTsz;
    }

    public void setShippedTsz(Float shippedTsz) {
        this.shippedTsz = shippedTsz;
    }

    @Override
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public List<String> getMaterials() {
        return materials;
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    @Override
    public Long getImageListingId() {
        return imageListingId;
    }

    public void setImageListingId(Long imageListingId) {
        this.imageListingId = imageListingId;
    }

    @Override
    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    @Override
    public Float getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Float shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override
    public Boolean getDigital() {
        return digital;
    }

    public void setDigital(Boolean digital) {
        this.digital = digital;
    }

    @Override
    public String getFileData() {
        return fileData;
    }

    public void setFileData(String fileData) {
        this.fileData = fileData;
    }

    @Override
    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    @Override
    public Boolean getQuickSale() {
        return quickSale;
    }

    public void setQuickSale(Boolean quickSale) {
        this.quickSale = quickSale;
    }

    @Override
    public Long getSellerFeedbackId() {
        return sellerFeedbackId;
    }

    public void setSellerFeedbackId(Long sellerFeedbackId) {
        this.sellerFeedbackId = sellerFeedbackId;
    }

    @Override
    public Long getBuyerFeedbackId() {
        return buyerFeedbackId;
    }

    public void setBuyerFeedbackId(Long buyerFeedbackId) {
        this.buyerFeedbackId = buyerFeedbackId;
    }

    @Override
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public List<EtsyListingInventory> getVariations() {
        return variations;
    }

    public void setVariations(List<EtsyListingInventory> variations) {
        this.variations = variations;
    }

    @Override
    public EtsyListingProduct getListingProduct() {
        return ListingProduct;
    }

    public void setListingProduct(EtsyListingProduct listingProduct) {
        ListingProduct = listingProduct;
    }
}
