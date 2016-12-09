package io.smsc.model.customer;

import io.smsc.model.BaseEntity;
import io.smsc.model.User;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CUSTOMER", uniqueConstraints = {@UniqueConstraint(columnNames = "CUSTOMER_ID", name = "customers_unique_customer_id_idx")})
public class Customer extends BaseEntity {

    @Column(name = "CUSTOMER_ID", nullable = false, unique = true)
    @NotEmpty(message = "{customer.customerId.validation}")
    private Double customerId;

    @Column(name = "COMPANY_NAME", nullable = false)
    @NotEmpty(message = "{customer.companyName.validation}")
    private String companyName;

    @Column(name = "STREET", nullable = false)
    @NotEmpty(message = "{customer.street.validation}")
    private String street;

    @Column(name = "STREET2", nullable = false)
    @NotEmpty(message = "{customer.street2.validation}")
    private String street2;

    @Column(name = "POSTCODE", nullable = false)
    @NotEmpty(message = "{customer.postcode.validation}")
    private String postcode;

    @Column(name = "COUNTRY", nullable = false)
    @NotEmpty(message = "{customer.country.validation}")
    private String country;

    @Column(name = "CITY", nullable = false)
    @NotEmpty(message = "{customer.city.validation}")
    private String city;

    @Column(name = "VATID")
    private Double vatid;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PARENT_CUSTOMER")
    private Customer parentCustomer;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private List<CustomerContact> contacts;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private List<User> users;

    public Customer() {
    }

    public Customer(Customer customer) {
        this(customer.getId(),customer.getCustomerId(),customer.getCompanyName(),customer.getStreet(),customer.getStreet2(),
                customer.getPostcode(),customer.getCountry(),customer.getCity(),customer.getVatid());
    }

    public Customer(Long id, Double customerId, String companyName, String street, String street2, String postcode, String country, String city, Double vatid) {
        super(id);
        this.customerId = customerId;
        this.companyName = companyName;
        this.street = street;
        this.street2 = street2;
        this.postcode = postcode;
        this.country = country;
        this.city = city;
        this.vatid = vatid;
    }

    public Double getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Double customerId) {
        this.customerId = customerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getVatid() {
        return vatid;
    }

    public void setVatid(Double vatid) {
        this.vatid = vatid;
    }

    public Customer getParentCustomer() {
        return parentCustomer;
    }

    public void setParentCustomer(Customer parentCustomer) {
        this.parentCustomer = parentCustomer;
    }

    public List<CustomerContact> getContacts() {
        return contacts;
    }

    public void setContacts(List<CustomerContact> contacts) {
        this.contacts = contacts;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", companyName='" + companyName + '\'' +
                ", street='" + street + '\'' +
                ", street2='" + street2 + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", vatid=" + vatid +
                ", parentCustomer=" + parentCustomer +
                ", contacts=" + contacts +
                ", users=" + users +
                "} " + super.toString();
    }
}
