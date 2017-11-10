/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package holidayscalculator;

import java.util.Date;

/**
 *
 * @author dmacchi
 */
public class Holiday {
    private String _name;
    private Date _startDate;
    private Date _endDate;

    Holiday(String holidayName, Date holidayDate) {
        _name = holidayName;
        _startDate = holidayDate;
    }
    
    Holiday(String holidayName, Date startDate, Date endDate) {
        _name = holidayName;
        _startDate = startDate;
        _endDate = endDate;
    }

    /**
     * @return the _name
     */
    public String getName() {
        return _name;
    }

    /**
     * @param name the _name to set
     */
    public void setName(String name) {
        this._name = name;
    }

    /**
     * @return the _startDate
     */
    public Date getStartDate() {
        return _startDate;
    }

    /**
     * @param startDate the _startDate to set
     */
    public void setStartDate(Date startDate) {
        this._startDate = startDate;
    }

    /**
     * @return the _endDate
     */
    public Date getEndDate() {
        return _endDate;
    }

    /**
     * @param endDate the _endDate to set
     */
    public void setEndDate(Date endDate) {
        this._endDate = endDate;
    }
}
