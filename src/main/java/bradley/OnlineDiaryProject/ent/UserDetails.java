/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bradley.OnlineDiaryProject.ent;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bradley
 */
@Entity
@Table(name = "USERDETAILS")
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userDetailsId;
    @ManyToOne
    @JoinColumn(referencedColumnName = "ID")
    private UserLogin userId;

    @Column
    private String fullName;
    @Column
    private String address;
    @Column
    private String contactNumber;
    @Column
    private String emailAddress;

    /**
     *
     */
    public UserDetails() {

    }

    /**
     *
     * @return
     */
    public Long getUserDetailsId() {
        return userDetailsId;
    }

    /**
     *
     * @param userDetailsId
     */
    public void setUserDetailsId(Long userDetailsId) {
        this.userDetailsId = userDetailsId;
    }

    /**
     *
     * @return
     */
    public String getFullName() {
        return fullName;
    }

    /**
     *
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     *
     * @param contactNumber
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     *
     * @return
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     *
     * @param emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     *
     * @return
     */
    public UserLogin getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(UserLogin userId) {
        userId.setId(userId.getId());
    }

}