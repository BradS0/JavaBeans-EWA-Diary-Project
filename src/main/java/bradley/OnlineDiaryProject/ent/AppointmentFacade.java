/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bradley.OnlineDiaryProject.ent;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Bradley
 */
@Stateless
public class AppointmentFacade extends AbstractFacade<Appointment> {

    @PersistenceContext(unitName = "OnlineDiaryPU")
    private EntityManager em;
    private List<Appointment> fetchedAppointments, timetableData;
    private Appointment passTimetableData;
    

    protected EntityManager getEntityManager() {
        return em;
    }

    public AppointmentFacade() {
        super(Appointment.class);
    }

    public Appointment dayChoice(String dayInput) {
        Appointment timetableInfo = new Appointment();
        timetableInfo.setDayOfWeek(dayInput);
        timetableData = fetchTimetableDetails(timetableInfo);
        passTimetableData = timetableData.get(0);
        timetableInfo.setStartTime(passTimetableData.getStartTime());
        timetableInfo.setEndTime(passTimetableData.getEndTime());
        timetableInfo.setDetails(passTimetableData.getDetails());
        timetableInfo.setCreator(passTimetableData.getCreator());
        timetableInfo.setParticipants(passTimetableData.getParticipants());
        return timetableInfo;       
        }

    public List<Appointment> fetchTimetableDetails(Appointment timetableInfo) {
        Query timetableQuery = em.createQuery("SELECT a from Appointment a WHERE a.dayOfWeek = '" + timetableInfo.getDayOfWeek() + "'");
        try {
            fetchedAppointments = timetableQuery.getResultList();
            if (!fetchedAppointments.isEmpty()) {
                return fetchedAppointments;
            } else {
                return null;
            }
        } catch (NoResultException e) {
            System.out.println("Error - Null");
            return null;
        }
    }
}

