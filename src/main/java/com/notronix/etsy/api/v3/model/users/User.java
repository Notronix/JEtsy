package com.notronix.etsy.api.v3.model.users;

public interface User
{
    Long getUserId();
    String getPrimaryEmail();
    String getFirstName();
    String getLastName();
    String getImageUrl75x75();
}
