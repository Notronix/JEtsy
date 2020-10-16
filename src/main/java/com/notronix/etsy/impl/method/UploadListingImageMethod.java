package com.notronix.etsy.impl.method;

import com.google.api.client.http.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.notronix.etsy.api.authentication.Credentials;
import com.notronix.etsy.impl.model.EtsyListingImage;

import java.io.File;
import java.net.URLConnection;
import java.util.List;
import java.util.UUID;

import static com.notronix.etsy.impl.method.MethodUtils.addIfProvided;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.BooleanUtils.isTrue;

public class UploadListingImageMethod extends AbstractEtsyMethod<EtsyListingImage>
{
    private Long listingId;
    private File image;
    private Integer rank;
    private Boolean overwrite;
    private Boolean isWaterMarked;

    public UploadListingImageMethod(Credentials clientCredentials, Credentials accessCredentials) {
        super(clientCredentials, accessCredentials);
    }

    @Override
    public String getURI() {
        String uri = "/listings/" + requireNonNull(listingId) + "/images";
        uri = addIfProvided(uri, "rank", rank);
        uri = addIfProvided(uri, "overwrite", overwrite, b -> isTrue(b) ? "1" : "0");
        uri = addIfProvided(uri, "is_watermarked", isWaterMarked, b -> isTrue(b) ? "1" : "0");

        return uri;
    }

    @Override
    public HttpContent getContent(Gson gson) {
        requireNonNull(image);

        MultipartContent content = new MultipartContent().setMediaType(new HttpMediaType("multipart/form-data"));
        String boundary = "---------------------------" + UUID.randomUUID().toString();
        content.setBoundary(boundary);

        FileContent fileContent = new FileContent(URLConnection.guessContentTypeFromName(image.getName()), image);
        MultipartContent.Part part = new MultipartContent.Part(fileContent);
        String disposition = "form-data; name=\"image\"; filename=\"" + image.getName() + "\"";
        part.setHeaders(new HttpHeaders().set("Content-Disposition", disposition));
        content.addPart(part);

        return content;
    }

    @Override
    public EtsyListingImage getResponse(Gson gson, String jsonPayload) {
        EtsyResponse<List<EtsyListingImage>> response =
                gson.fromJson(jsonPayload, new TypeToken<EtsyResponse<List<EtsyListingImage>>>(){}.getType());

        return response.getResults().stream().findAny().orElse(null);
    }

    @Override
    public boolean requiresOAuth() {
        return true;
    }

    @Override
    public String getRequestMethod() {
        return HttpMethods.POST;
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

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public UploadListingImageMethod withImage(File image) {
        this.image = image;
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

    public Boolean getIsWaterMarked() {
        return isWaterMarked;
    }

    public void setIsWaterMarked(Boolean isWaterMarked) {
        this.isWaterMarked = isWaterMarked;
    }

    public UploadListingImageMethod withIsWaterMarked(Boolean isWaterMarked) {
        this.isWaterMarked = isWaterMarked;
        return this;
    }
}
