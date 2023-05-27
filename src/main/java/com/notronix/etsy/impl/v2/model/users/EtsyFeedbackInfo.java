package com.notronix.etsy.impl.v2.model.users;

import com.notronix.etsy.api.v2.model.users.FeedbackInfo;

public class EtsyFeedbackInfo implements FeedbackInfo
{
    private Integer count;
    private Integer score;

    @Override
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
