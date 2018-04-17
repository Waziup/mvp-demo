package com.apps.waziup.data.model;

/**
 * Created by KidusMT on 4/1/2018.
 */

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

public class User {

    @SerializedName("id")
    private String id = null;

    @SerializedName("username")
    private String username = null;

    @SerializedName("firstName")
    private String firstName = null;

    @SerializedName("lastName")
    private String lastName = null;

    @SerializedName("subservice")
    private String subservice = null;

    @SerializedName("email")
    private String email = null;

    @SerializedName("phone")
    private String phone = null;

    @SerializedName("address")
    private String address = null;

    @SerializedName("facebook")
    private String facebook = null;

    @SerializedName("twitter")
    private String twitter = null;

    @SerializedName("roles")
    private String roles = null;

    public User id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @ApiModelProperty(example = "eb78eed6-d01a-4f69-b562-1f30002c08d9", value = "")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User username(String username) {
        this.username = username;
        return this;
    }

    /**
     * Get username
     *
     * @return username
     **/
    @ApiModelProperty(example = "cdupont", value = "")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Get firstName
     *
     * @return firstName
     **/
    @ApiModelProperty(example = "Corentin", value = "")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public User lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Get lastName
     *
     * @return lastName
     **/
    @ApiModelProperty(example = "Dupont", value = "")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User subservice(String subservice) {
        this.subservice = subservice;
        return this;
    }

    /**
     * Get subservice
     *
     * @return subservice
     **/
    @ApiModelProperty(example = "farm1", value = "")
    public String getSubservice() {
        return subservice;
    }

    public void setSubservice(String subservice) {
        this.subservice = subservice;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get email
     *
     * @return email
     **/
    @ApiModelProperty(example = "test@gmail.com", value = "")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User phone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * Get phone
     *
     * @return phone
     **/
    @ApiModelProperty(example = "+390000000", value = "")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User address(String address) {
        this.address = address;
        return this;
    }

    /**
     * Get address
     *
     * @return address
     **/
    @ApiModelProperty(example = "25 Test street", value = "")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User facebook(String facebook) {
        this.facebook = facebook;
        return this;
    }

    /**
     * Get facebook
     *
     * @return facebook
     **/
    @ApiModelProperty(example = "test1", value = "")
    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public User twitter(String twitter) {
        this.twitter = twitter;
        return this;
    }

    /**
     * Get twitter
     *
     * @return twitter
     **/
    @ApiModelProperty(example = "@Test1", value = "")
    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public User roles(String roles) {
        this.roles = roles;
        return this;
    }

    /**
     * Get roles
     *
     * @return roles
     **/
    @ApiModelProperty(example = "admin", value = "")
    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(this.id, user.id) &&
                Objects.equals(this.username, user.username) &&
                Objects.equals(this.firstName, user.firstName) &&
                Objects.equals(this.lastName, user.lastName) &&
                Objects.equals(this.subservice, user.subservice) &&
                Objects.equals(this.email, user.email) &&
                Objects.equals(this.phone, user.phone) &&
                Objects.equals(this.address, user.address) &&
                Objects.equals(this.facebook, user.facebook) &&
                Objects.equals(this.twitter, user.twitter) &&
                Objects.equals(this.roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, firstName, lastName, subservice, email, phone, address, facebook, twitter, roles);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class User {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    subservice: ").append(toIndentedString(subservice)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    facebook: ").append(toIndentedString(facebook)).append("\n");
        sb.append("    twitter: ").append(toIndentedString(twitter)).append("\n");
        sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
