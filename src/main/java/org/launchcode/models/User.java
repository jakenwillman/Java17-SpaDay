package org.launchcode.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User {

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    @NotBlank(message = "Username is required")
    @Size(message = "Enter a username between 5 and 15 characters long", min = 5, max = 15)
    private String username;

    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(message = "Enter a password between 6 and 20 characters long", min = 6, max = 20)
    private String password;

    @NotBlank(message = "Verify password is required")
    private String verify;

    public User() {
    }

    public User(String username, String email, String password, String verify, String verifyPassword) {
        this();
        this.verifyPassword = verifyPassword;
        this.verify = verify;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword() {
        if (password != null && verifyPassword != null && !password.equals(verifyPassword))
           verifyPassword = null;
    }

}

