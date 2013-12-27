package com.maweis.bo;

/**
 * Created by peter on 12/17/13.
 */
public class CustomerBO {

    private long id;
    private String firstName;
    private String lastName;

    protected CustomerBO() {
    }

    public CustomerBO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "CustomerBO[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}
