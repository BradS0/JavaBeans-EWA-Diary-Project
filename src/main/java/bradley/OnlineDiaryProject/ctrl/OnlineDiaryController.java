/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bradley.OnlineDiaryProject.ctrl;

import bradley.OnlineDiaryProject.bus.OnlineDiaryService;
import bradley.OnlineDiaryProject.ent.Appointment;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Bradley
 */
@Named(value = "onlineDiaryBean")
@RequestScoped
public class OnlineDiaryController {
    
    @EJB
    private OnlineDiaryService ods;
    private Appointment userInput = new Appointment();
    private Appointment fetchedTableInfo;
    
    public OnlineDiaryController(){
    }
    
    public Appointment loadTimetable(){
        fetchedTableInfo = ods.fetchTimetableInfo(userInput);
        return fetchedTableInfo;
    }
    
    
}
