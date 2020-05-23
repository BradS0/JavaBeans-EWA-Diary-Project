/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bradley.OnlineDiaryProject.ent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bradley
 */

public class Appointment implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long appointmentId;
    
    private Integer appointmentStart;
    private Integer appointmentEnd;
    
    private String appointmentDetails;
    
    private Long appointmentCreator;
    
    private List<UserLogin> appointmentParticipants = new ArrayList<>();

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getAppointmentStart() {
        return appointmentStart;
    }

    public void setAppointmentStart(Integer appointmentStart) {
        this.appointmentStart = appointmentStart;
    }

    public Integer getAppointmentEnd() {
        return appointmentEnd;
    }

    public void setAppointmentEnd(Integer appointmentEnd) {
        this.appointmentEnd = appointmentEnd;
    }

    public String getAppointmentDetails() {
        return appointmentDetails;
    }

    public void setAppointmentDetails(String appointmentDetails) {
        this.appointmentDetails = appointmentDetails;
    }

    public Long getAppointmentCreator() {
        return appointmentCreator;
    }

    public void setAppointmentCreator(Long appointmentCreator) {
        this.appointmentCreator = appointmentCreator;
    }

    public List<UserLogin> getAppointmentParticipants() {
        return appointmentParticipants;
    }

    public void setAppointmentParticipants(List<UserLogin> appointmentParticipants) {
        this.appointmentParticipants = appointmentParticipants;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.appointmentId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Appointment other = (Appointment) obj;
        if (!Objects.equals(this.appointmentId, other.appointmentId)) {
            return false;
        }
        return true;
    }
}











/*
@Entity
@Table(name = "APPOINTMENT_TABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a"),
    @NamedQuery(name = "Appointment.findByAppointmentid", query = "SELECT a FROM Appointment a WHERE a.appointmentid = :appointmentid"),
    @NamedQuery(name = "Appointment.findByAppointmentstart", query = "SELECT a FROM Appointment a WHERE a.appointmentstart = :appointmentstart"),
    @NamedQuery(name = "Appointment.findByAppointmentend", query = "SELECT a FROM Appointment a WHERE a.appointmentend = :appointmentend"),
    @NamedQuery(name = "Appointment.findByAppointmentdetails", query = "SELECT a FROM Appointment a WHERE a.appointmentdetails = :appointmentdetails"),
    @NamedQuery(name = "Appointment.findByAppointmentparticipants", query = "SELECT a FROM Appointment a WHERE a.appointmentparticipants = :appointmentparticipants")})
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "APPOINTMENTID", nullable = false)
    private Integer appointmentid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "APPOINTMENTSTART", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date appointmentstart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "APPOINTMENTEND", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date appointmentend;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "APPOINTMENTDETAILS", nullable = false, length = 100)
    private String appointmentdetails;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "APPOINTMENTPARTICIPANTS", nullable = false, length = 150)
    private String appointmentparticipants;
    @JoinColumn(name = "APPOINTMENTCREATOR", referencedColumnName = "USERDETAILSID", nullable = false)
    @ManyToOne(optional = false)
    private UserDetails appointmentcreator;

    public Appointment() {
    }

    public Appointment(Integer appointmentid) {
        this.appointmentid = appointmentid;
    }

    public Appointment(Integer appointmentid, Date appointmentstart, Date appointmentend, String appointmentdetails, String appointmentparticipants) {
        this.appointmentid = appointmentid;
        this.appointmentstart = appointmentstart;
        this.appointmentend = appointmentend;
        this.appointmentdetails = appointmentdetails;
        this.appointmentparticipants = appointmentparticipants;
    }

    public Integer getAppointmentid() {
        return appointmentid;
    }

    public void setAppointmentid(Integer appointmentid) {
        this.appointmentid = appointmentid;
    }

    public Date getAppointmentstart() {
        return appointmentstart;
    }

    public void setAppointmentstart(Date appointmentstart) {
        this.appointmentstart = appointmentstart;
    }

    public Date getAppointmentend() {
        return appointmentend;
    }

    public void setAppointmentend(Date appointmentend) {
        this.appointmentend = appointmentend;
    }

    public String getAppointmentdetails() {
        return appointmentdetails;
    }

    public void setAppointmentdetails(String appointmentdetails) {
        this.appointmentdetails = appointmentdetails;
    }

    public String getAppointmentparticipants() {
        return appointmentparticipants;
    }

    public void setAppointmentparticipants(String appointmentparticipants) {
        this.appointmentparticipants = appointmentparticipants;
    }

    public UserDetails getAppointmentcreator() {
        return appointmentcreator;
    }

    public void setAppointmentcreator(UserDetails appointmentcreator) {
        this.appointmentcreator = appointmentcreator;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appointmentid != null ? appointmentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) object;
        if ((this.appointmentid == null && other.appointmentid != null) || (this.appointmentid != null && !this.appointmentid.equals(other.appointmentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bradley.OnlineDiaryProject.ent.Appointment[ appointmentid=" + appointmentid + " ]";
    }
    
}

*/