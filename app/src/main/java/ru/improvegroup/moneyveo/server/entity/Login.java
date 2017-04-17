package ru.improvegroup.moneyveo.server.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Diana.Raspopova on 4/14/2017.
 */

public class Login {

    @SerializedName("Identifier")
    String identifier;
    @SerializedName("Password")
    String password;

    public static Builder newBuilder() {
        return new Login().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setLogin(String email) {
            Login.this.identifier = email;

            return this;
        }

        public Builder setPassword(String password) {
            Login.this.password = password;

            return this;
        }

        public Login build() {
            return Login.this;
        }

    }

    public String getIdentifier() {
        return identifier;
    }

    public String getPassword() {
        return password;
    }
}
