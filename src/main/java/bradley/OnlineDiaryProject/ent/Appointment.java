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
@Entity
@Table(name = "APPOINTMENT")
public class Appointment implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long appointmentId;
    
    @Column
    private Integer startTime;
    @Column
    private Integer endTime;
    @Column
    private String details;
    @Column
    private Long creator;
    @JoinColumn
    private List<UserLogin> participants = new ArrayList<>();
    @Column
    private String dayOfWeek;

    public Long getId() {
        return appointmentId;
    }

    public void setId(Long id) {
        this.appointmentId = appointmentId;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public List<UserLogin> getParticipants() {
        return participants;
    }

    public void setParticipants(List<UserLogin> participants) {
        this.participants = participants;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.appointmentId);
        hash = 67 * hash + Objects.hashCode(this.startTime);
        hash = 67 * hash + Objects.hashCode(this.endTime);
        hash = 67 * hash + Objects.hashCode(this.details);
        hash = 67 * hash + Objects.hashCode(this.creator);
        hash = 67 * hash + Objects.hashCode(this.participants);
        hash = 67 * hash + Objects.hashCode(this.dayOfWeek);
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
        if (!Objects.equals(this.details, other.details)) {
            return false;
        }
        if (!Objects.equals(this.dayOfWeek, other.dayOfWeek)) {
            return false;
        }
        if (!Objects.equals(this.appointmentId, other.appointmentId)) {
            return false;
        }
        if (!Objects.equals(this.startTime, other.startTime)) {
            return false;
        }
        if (!Objects.equals(this.endTime, other.endTime)) {
            return false;
        }
        if (!Objects.equals(this.creator, other.creator)) {
            return false;
        }
        if (!Objects.equals(this.participants, other.participants)) {
            return false;
        }
        return true;
    }    
    
}
