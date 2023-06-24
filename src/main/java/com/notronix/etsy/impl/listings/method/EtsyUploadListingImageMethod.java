package com.notronix.etsy.impl.listings.method;

import com.google.api.client.http.*;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.AccessToken;
import com.notronix.etsy.api.common.method.OAuthMethod;
import com.notronix.etsy.api.listings.method.UploadListingImageMethod;
import com.notronix.etsy.api.listings.model.ListingImage;
import com.notronix.etsy.impl.AbstractEtsyMethod;
import com.notronix.etsy.impl.listings.model.EtsyListingImage;

import java.io.File;
import java.net.URLConnection;
import java.util.UUID;

import static com.google.common.net.HttpHeaders.CONTENT_DISPOSITION;
import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

public class EtsyUploadListingImageMethod extends AbstractEtsyMethod<ListingImage>
    implements UploadListingImageMethod<HttpContent>, OAuthMethod
{
    private AccessToken accessToken;
    private Long shopId;
    private Long listingId;
    private File imageFile;
    private Integer rank;
    private Boolean overwrite;
    private Boolean watermarked;
    private String altText;

    @Override
    public EtsyListingImage buildResponseBody(Unmarshaller unmarshaller, String payload) {
        return unmarshaller.unmarshal(payload, EtsyListingImage.class);
    }

    @Override
    protected String getURI() {
        return "/application/shops/" + requireNonNull(shopId) + "/listings/" + requireNonNull(listingId) + "/images";
    }

    @Override
    public String getRequestMethod() {
        return HttpMethods.POST;
    }

    @Override
    public HttpContent buildRequestContent(Marshaller marshaller) {
        requireNonNull(imageFile);
        if (nonNull(altText) && altText.length() > MAX_ALT_TEXT_LENGTH) {
            throw new IllegalArgumentException("alt_text is more than 250 characters.");
        }

        String boundary = "---------------------------" + UUID.randomUUID();
        HttpMediaType mediaType = new HttpMediaType("multipart/form-data;boundary=\"" + boundary + "\"");
        MultipartContent content = new MultipartContent().setMediaType(mediaType);

        FileContent fileContent = new FileContent(URLConnection.guessContentTypeFromName(imageFile.getName()), imageFile);
        addMultiPart(content, boundary, fileContent,
                "form-data; name=\"image\"; filename=\"" + imageFile.getName() + "\"");

        addPartIfProvided(content, boundary, "rank", rank);
        addPartIfProvided(content, boundary, "overwrite", overwrite);
        addPartIfProvided(content, boundary, "is_watermarked", watermarked);
        addPartIfProvided(content, boundary, "alt_text", altText);

        return content;
    }

    private void addPartIfProvided(MultipartContent content, String boundary, String key, Object value) {
        if (nonNull(value)) {
            ByteArrayContent partContent = ByteArrayContent.fromString("text/plain", value.toString());
            String disposition = "form-data; name=\"" + key + "\"";
            addMultiPart(content, boundary, partContent, disposition);
        }
    }

    private void addMultiPart(MultipartContent content, String boundary, HttpContent partContent, String disposition) {
        HttpHeaders headers = new HttpHeaders().set(CONTENT_DISPOSITION, requireNonNull(disposition));
        MultipartContent.Part part = new MultipartContent.Part(headers, requireNonNull(partContent));
        requireNonNull(content).setBoundary(requireNonNull(boundary));
        content.addPart(part);
    }

    @Override
    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public EtsyUploadListingImageMethod withAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public Long getShopId() {
        return shopId;
    }

    @Override
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public EtsyUploadListingImageMethod withShopId(Long shopId) {
        this.shopId = shopId;
        return this;
    }

    public Long getListingId() {
        return listingId;
    }

    @Override
    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public EtsyUploadListingImageMethod withListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }

    public File getImageFile() {
        return imageFile;
    }

    @Override
    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
    }

    public EtsyUploadListingImageMethod withImageFile(File imageFile) {
        this.imageFile = imageFile;
        return this;
    }

    public Integer getRank() {
        return rank;
    }

    @Override
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public EtsyUploadListingImageMethod withRank(Integer rank) {
        this.rank = rank;
        return this;
    }

    public Boolean getOverwrite() {
        return overwrite;
    }

    @Override
    public void setOverwrite(Boolean overwrite) {
        this.overwrite = overwrite;
    }

    public EtsyUploadListingImageMethod withOverwrite(Boolean overwrite) {
        this.overwrite = overwrite;
        return this;
    }

    public Boolean getWatermarked() {
        return watermarked;
    }

    @Override
    public void setWatermarked(Boolean watermarked) {
        this.watermarked = watermarked;
    }

    public EtsyUploadListingImageMethod withWatermarked(Boolean watermarked) {
        this.watermarked = watermarked;
        return this;
    }

    public String getAltText() {
        return altText;
    }

    @Override
    public void setAltText(String altText) {
        this.altText = altText;
    }

    public EtsyUploadListingImageMethod withAltText(String altText) {
        this.altText = altText;
        return this;
    }
}
