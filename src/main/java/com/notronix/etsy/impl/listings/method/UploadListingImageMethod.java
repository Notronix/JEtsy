package com.notronix.etsy.impl.listings.method;

import com.google.api.client.http.*;
import com.notronix.etsy.api.Marshaller;
import com.notronix.etsy.api.Unmarshaller;
import com.notronix.etsy.api.authentication.model.Credentials;
import com.notronix.etsy.impl.EtsyMethod;
import com.notronix.etsy.impl.listings.model.EtsyListingImage;

import java.io.File;
import java.net.URLConnection;
import java.util.UUID;

import static com.google.common.net.HttpHeaders.CONTENT_DISPOSITION;
import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

public class UploadListingImageMethod extends EtsyMethod<EtsyListingImage>
{
    private Long shopId;
    private Long listingId;
    private File imageFile;
    private Integer rank;
    private Boolean overwrite;
    private Boolean watermarked;
    private String altText;

    public UploadListingImageMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public EtsyListingImage getResponse(Unmarshaller unmarshaller, String payload) {
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
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public HttpContent getContent(Marshaller marshaller) {
        requireNonNull(imageFile);
        if (nonNull(altText) && altText.length() > 250) {
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

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public UploadListingImageMethod withShopId(Long shopId) {
        this.shopId = shopId;
        return this;
    }

    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public UploadListingImageMethod withListingId(Long listingId) {
        this.listingId = listingId;
        return this;
    }

    public File getImageFile() {
        return imageFile;
    }

    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
    }

    public UploadListingImageMethod withImageFile(File imageFile) {
        this.imageFile = imageFile;
        return this;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public UploadListingImageMethod withRank(Integer rank) {
        this.rank = rank;
        return this;
    }

    public Boolean getOverwrite() {
        return overwrite;
    }

    public void setOverwrite(Boolean overwrite) {
        this.overwrite = overwrite;
    }

    public UploadListingImageMethod withOverwrite(Boolean overwrite) {
        this.overwrite = overwrite;
        return this;
    }

    public Boolean getWatermarked() {
        return watermarked;
    }

    public void setWatermarked(Boolean watermarked) {
        this.watermarked = watermarked;
    }

    public UploadListingImageMethod withWatermarked(Boolean watermarked) {
        this.watermarked = watermarked;
        return this;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public UploadListingImageMethod withAltText(String altText) {
        this.altText = altText;
        return this;
    }
}
