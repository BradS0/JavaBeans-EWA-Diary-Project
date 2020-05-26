/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bradley.OnlineDiaryProject.bus;

import bradley.OnlineDiaryProject.ent.Appointment;
import bradley.OnlineDiaryProject.ent.AppointmentFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Bradley
 */
@Stateless
public class OnlineDiaryService {

    @EJB
    private AppointmentFacade af;
    private Appointment fetchedAppointment;

    /**
     * Initialises appointment information fetch from the database based on the day of the week input by the user on the OnlineDiary facelet.
     * @param a
     * @return
     */
    public Appointment fetchTimetableInfo(Appointment a) {
        fetchedAppointment = af.dayChoice(a.getDayOfWeek());
        return fetchedAppointment;
    }
}
