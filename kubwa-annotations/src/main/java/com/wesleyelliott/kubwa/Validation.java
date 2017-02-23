package com.wesleyelliott.kubwa;

import android.content.Context;

import com.wesleyelliott.kubwa.rule.ConfirmRule;
import com.wesleyelliott.kubwa.rule.Rule;

/**
 * Created by wesley on 2016/07/28.
 */

public class Validation<T> {

    private Context context;
    private String message = null;
    private int errorMessageId;
    private Rule<T> rule;

    public Validation(Context context, int errorMessageId, Rule<T> rule) {
        this.context = context;
        this.errorMessageId = errorMessageId;
        this.rule = rule;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean validate(T value) {
        if (!rule.isValid(value)) {
            message = errorMessageId != -1 ? context.getString(errorMessageId) : "Error";
            return false;
        } else {
            message = null;
            return true;
        }
    }

    public boolean validate(T value, T value2) {
        ConfirmRule confirmRule = (ConfirmRule) rule;
        if (!confirmRule.isValid(value, value2)) {
            message = errorMessageId != -1 ? context.getString(errorMessageId) : "Error";
            return false;
        } else {
            message = null;
            return true;
        }
    }

}
