package com.notronix.etsy.impl.v2.model.shops;

import com.google.gson.annotations.SerializedName;
import com.notronix.etsy.api.v2.model.shops.Transaction;
import com.notronix.etsy.impl.v2.model.listings.EtsyListingInventory;
import com.notronix.etsy.impl.v2.model.listings.EtsyListingProduct;

import java.time.Instant;
import java.util.List;

public class EtsyTransaction implements Transaction
{
    @SerializedName("transaction_id")
    private Long transactionId;
    private String title;
    private String description;

    @SerializedName("seller_user_id")
    private Long sellerUserId;

    @SerializedName("buyer_user_id")
    private Long buyerUserId;

    @SerializedName("creation_tsz")
    private Instant creationTsz;

    @SerializedName("paid_tsz")
    private Instant paidTsz;

    @SerializedName("shipped_tsz")
    private Instant shippedTsz;

    private Float price;

    @SerializedName("currency_code")
    private String currencyCode;
    private Integer quantity;
    private List<String> tags;
    private List<String> materials;

    @SerializedName("image_listing_id")
    private Long imageListingId;

    @SerializedName("receipt_id")
    private Long receiptId;

    @SerializedName("shipping_cost")
    private Float shippingCost;

    @SerializedName("is_digital")
    private Boolean digital;

    @SerializedName("file_data")
    private String fileData;

    @SerializedName("listing_id")
    private Long listingId;

    @SerializedName("is_quick_sale")
    private Boolean quickSale;

    @SerializedName("seller_feedback_id")
    private Long sellerFeedbackId;

    @SerializedName("buyer_feedback_id")
    private Long buyerFeedbackId;

    @SerializedName("transaction_type")
    private String transactionType;
    private String url;

    private List<EtsyListingInventory> variations;

    @SerializedName("product_data")
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
    public Instant getCreationTsz() {
        return creationTsz;
    }

    public void setCreationTsz(Instant creationTsz) {
        this.creationTsz = creationTsz;
    }

    @Override
    public Instant getPaidTsz() {
        return paidTsz;
    }

    public void setPaidTsz(Instant paidTsz) {
        this.paidTsz = paidTsz;
    }

    @Override
    public Instant getShippedTsz() {
        return shippedTsz;
    }

    public void setShippedTsz(Instant shippedTsz) {
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
