package com.example.retrofitcall;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Milan Bamaniya on 7/15/2022.
 */
public class Results {

    @SerializedName("name")
    private final String superName;

    public Results(String name) {
        this.superName = name;
    }

    public String getName() {
        return superName;
    }
}
