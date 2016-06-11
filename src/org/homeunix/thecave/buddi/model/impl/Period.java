package org.homeunix.thecave.buddi.model.impl;

import ca.digitalcave.moss.common.DateUtil;

import java.util.Date;

public class Period {
    private final Date startDate;
    private final Date endDate;

    public Period(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getDayCount() {
        return DateUtil.getDaysBetween(startDate, endDate, true);
    }

    public long getOverlappingDayCount(Period another) {
        Date startDateOfOverlapping = startDate.after(another.startDate) ? startDate : another.startDate;
        Date endDateOfOverlapping = endDate.before(another.endDate) ? endDate : another.endDate;

        if (startDateOfOverlapping.after(endDateOfOverlapping))
            return 0;

        return new Period(startDateOfOverlapping, endDateOfOverlapping).getDayCount();
    }

}
