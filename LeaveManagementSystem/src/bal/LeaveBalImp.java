package bal;

import dao.LeaveDao;
import dao.LeaveDaoImp;
import exception.LeaveException;
import model.LeaveDetails;

import java.util.Date;
import java.util.List;

public class LeaveBalImp implements LeaveBal {

    private LeaveDao leaveDao = new LeaveDaoImp();

    @Override
    public String addLeaveBal(LeaveDetails leave) throws LeaveException {
        validateLeave(leave);
        leave.setAppliedOn(new Date());   // today’s date
        leave.setNoOfDays(calculateDays(leave));  // auto calculate days
        return leaveDao.addLeaveDao(leave);
    }

    @Override
    public List<LeaveDetails> showLeaveBal() {
        return leaveDao.showLeaveDao();
    }

    @Override
    public LeaveDetails searchLeaveBal(int leaveId) {
        return leaveDao.searchLeaveDao(leaveId);
    }

    @Override
    public String updateLeaveBal(LeaveDetails leave) throws LeaveException {
        validateLeave(leave);
        leave.setAppliedOn(new Date());
        leave.setNoOfDays(calculateDays(leave));
        return leaveDao.updateLeaveDao(leave);
    }

    @Override
    public String deleteLeaveBal(int leaveId) {
        return leaveDao.deleteLeaveDao(leaveId);
    }


    private void validateLeave(LeaveDetails leave) throws LeaveException {

        StringBuilder errors = new StringBuilder();

        Date today = new Date();

        if (leave.getLeaveStartDate().before(today)) {
            errors.append("Leave Start Date cannot be yesterday or past date.\n");
        }

        if (leave.getLeaveEndDate().before(today)) {
            errors.append("Leave End Date cannot be yesterday or past date.\n");
        }

        if (leave.getLeaveStartDate().after(leave.getLeaveEndDate())) {
            errors.append("Leave Start Date cannot be greater than Leave End Date.\n");
        }

        if (errors.length() > 0) {
            throw new LeaveException(errors.toString());
        }
    }

    private int calculateDays(LeaveDetails leave) {
        long diff = leave.getLeaveEndDate().getTime() - leave.getLeaveStartDate().getTime();
        return (int) (diff / (1000 * 60 * 60 * 24)) + 1; // inclusive count
    }
}