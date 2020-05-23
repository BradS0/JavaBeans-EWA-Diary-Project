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
@Table(name = "USERDETAILSs")
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userDetailsId;
    @Column
    private Long userId;
    @Column
    private String fullName;
    @Column
    private String address;
    @Column
    private String contactNumber;
    @Column
    private String emailAddress;

    public UserDetails(){
        
    }

    public Long getUserDetailsId() {
        return userDetailsId;
    }

    public void setUserDetailsId(Long userDetailsId) {
        this.userDetailsId = userDetailsId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
         return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Long getUserId(UserLogin user) {
        userId = user.getId();
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    
}










/*




@Entity
@Table(name = "USERDETAILS_TABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDetails.findAll", query = "SELECT u FROM UserDetails u"),
    @NamedQuery(name = "UserDetails.findByUserdetailsid", query = "SELECT u FROM UserDetails u WHERE u.userdetailsid = :userdetailsid"),
    @NamedQuery(name = "UserDetails.findByFullname", query = "SELECT u FROM UserDetails u WHERE u.fullname = :fullname"),
    @NamedQuery(name = "UserDetails.findByAddress", query = "SELECT u FROM UserDetails u WHERE u.address = :address"),
    @NamedQuery(name = "UserDetails.findByContactnumber", query = "SELECT u FROM UserDetails u WHERE u.contactnumber = :contactnumber"),
    @NamedQuery(name = "UserDetails.findByEmailaddress", query = "SELECT u FROM UserDetails u WHERE u.emailaddress = :emailaddress")})
public class UserDetails implements Serializable
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERDETAILSID", nullable = false)
    private Integer userdetailsid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FULLNAME", nullable = false, length = 50)
    private String fullname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ADDRESS", nullable = false, length = 50)
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CONTACTNUMBER", nullable = false, length = 12)
    private String contactnumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAILADDRESS", nullable = false, length = 50)
    private String emailaddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appointmentcreator")
    private Collection<Appointment> appointmentCollection;
    @JoinColumn(name = "USERID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private User userid;

    public UserDetails() {
    }

    public UserDetails(Integer userdetailsid) {
        this.userdetailsid = userdetailsid;
    }

    public UserDetails(Integer userdetailsid, String fullname, String address, String contactnumber, String emailaddress) {
        this.userdetailsid = userdetailsid;
        this.fullname = fullname;
        this.address = address;
        this.contactnumber = contactnumber;
        this.emailaddress = emailaddress;
    }

    public Integer getUserdetailsid() {
        return userdetailsid;
    }

    public void setUserdetailsid(Integer userdetailsid) {
        this.userdetailsid = userdetailsid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    @XmlTransient
    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userdetailsid != null ? userdetailsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDetails)) {
            return false;
        }
        UserDetails other = (UserDetails) object;
        if ((this.userdetailsid == null && other.userdetailsid != null) || (this.userdetailsid != null && !this.userdetailsid.equals(other.userdetailsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bradley.OnlineDiaryProject.ent.UserDetails[ userdetailsid=" + userdetailsid + " ]";
    }
    
}
*/