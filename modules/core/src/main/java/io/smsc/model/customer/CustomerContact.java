package io.smsc.model.customer;

import io.smsc.model.BaseEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CUSTOMER_CONTACT", uniqueConstraints = {@UniqueConstraint(columnNames = "EMAIL_ADDRESS", name = "customer_contact_unique_email_address_id_idx")})
public class CustomerContact extends BaseEntity {

    @Column(name = "FIRST_NAME", nullable = false)
    @NotEmpty(message = "{customer.contact.firstName.validation}")
    private String firstName;

    @Column(name = "SURNAME", nullable = false)
    @NotEmpty(message = "{customer.contact.surName.validation}")
    private String surName;

    @Column(name = "PHONE", nullable = false)
    @NotEmpty(message = "{customer.contact.phone.validation}")
    private String phone;

    @Column(name = "MOBILE_PHONE", nullable = false)
    @NotEmpty(message = "{customer.contact.mobilePhone.validation}")
    private String mobilePhone;

    @Column(name = "FAX", nullable = false)
    @NotEmpty(message = "{customer.contact.fax.validation}")
    private String fax;

    @Column(name = "EMAIL_ADDRESS", nullable = false, unique = true)
    @NotEmpty(message = "{customer.contact.emailAddress.validation}")
    private String emailAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CUSTOMER")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "CUSTOMER_CONTACT_TYPE", joinColumns = @JoinColumn(name = "CUSTOMER_CONTACT_ID"))
    @Column(name = "TYPE")
    @ElementCollection(fetch = FetchType.LAZY)
    private List<Type> type;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "CUSTOMER_CONTACT_SALUTATION", joinColumns = @JoinColumn(name = "CUSTOMER_CONTACT_ID"))
    @Column(name = "SALUTATION")
    @ElementCollection(fetch = FetchType.LAZY)
    private List<Salutation> salutation;

    public CustomerContact() {
    }

    public CustomerContact(CustomerContact customerContact) {
        this(customerContact.getId(),customerContact.getFirstName(),customerContact.getSurName(),customerContact.getPhone(),
                customerContact.getMobilePhone(),customerContact.getFax(),customerContact.getEmailAddress());
    }

    public CustomerContact(Long id, String firstName, String surName, String phone, String mobilePhone, String fax, String emailAddress) {
        super(id);
        this.firstName = firstName;
        this.surName = surName;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.fax = fax;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Type> getType() {
        return type;
    }

    public void setType(List<Type> type) {
        this.type = type;
    }

    public List<Salutation> getSalutation() {
        return salutation;
    }

    public void setSalutation(List<Salutation> salutation) {
        this.salutation = salutation;
    }

    @Override
    public String toString() {
        return "CustomerContact{" +
                "firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", phone='" + phone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", fax='" + fax + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", customer=" + customer +
                ", type=" + type +
                ", salutation=" + salutation +
                "} " + super.toString();
    }
}
