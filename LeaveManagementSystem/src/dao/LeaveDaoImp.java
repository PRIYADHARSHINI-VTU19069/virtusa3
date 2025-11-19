package dao;

import model.LeaveDetails;

import java.util.ArrayList;
import java.util.List;

public class LeaveDaoImp implements LeaveDao {

    private static List<LeaveDetails> leaveList;

    static {
        leaveList = new ArrayList<>();
    }

    @Override
    public String addLeaveDao(LeaveDetails leave) {
        leaveList.add(leave);
        return "Leave Added Successfully";
    }

    @Override
    public List<LeaveDetails> showLeaveDao() {
        return leaveList;
    }

    @Override
    public LeaveDetails searchLeaveDao(int leaveId) {
        return leaveList.stream()
                .filter(leave -> leave.getLeaveId() == leaveId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String updateLeaveDao(LeaveDetails leaveUpdate) {
        LeaveDetails leaveFound = searchLeaveDao(leaveUpdate.getLeaveId());
        if (leaveFound != null) {
            leaveFound.setEmpId(leaveUpdate.getEmpId());
            leaveFound.setLeaveStartDate(leaveUpdate.getLeaveStartDate());
            leaveFound.setLeaveEndDate(leaveUpdate.getLeaveEndDate());
            leaveFound.setNoOfDays(leaveUpdate.getNoOfDays());
            leaveFound.setAppliedOn(leaveUpdate.getAppliedOn());
            leaveFound.setLeaveReason(leaveUpdate.getLeaveReason());
            return "Leave Updated Successfully";
        }
        return "Leave Not Found";
    }

    @Override
    public String deleteLeaveDao(int leaveId) {
        LeaveDetails leaveFound = searchLeaveDao(leaveId);
        if (leaveFound != null) {
            leaveList.remove(leaveFound);
            return "Leave Deleted Successfully";
        }
        return "Leave Not Found";
    }
}