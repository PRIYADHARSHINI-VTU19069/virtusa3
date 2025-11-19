package dao;

import model.LeaveDetails;
import java.util.List;

public interface LeaveDao {

    String addLeaveDao(LeaveDetails leave);

    List<LeaveDetails> showLeaveDao();

    LeaveDetails searchLeaveDao(int leaveId);

    String updateLeaveDao(LeaveDetails leaveUpdate);

    String deleteLeaveDao(int leaveId);
}