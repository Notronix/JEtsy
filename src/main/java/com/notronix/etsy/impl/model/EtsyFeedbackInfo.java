package com.notronix.etsy.impl.model;

import com.notronix.etsy.api.model.FeedbackInfo;

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
