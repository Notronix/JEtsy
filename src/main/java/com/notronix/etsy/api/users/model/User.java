package com.notronix.etsy.api.users.model;

public interface User
{
    Long getUserId();
    String getPrimaryEmail();
    String getFirstName();
    String getLastName();
    String getImageUrl75x75();
}
