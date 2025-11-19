package bal;

import model.LeaveDetails;
import exception.LeaveException;
import java.util.List;

public interface LeaveBal {

    String addLeaveBal(LeaveDetails leave) throws LeaveException;

    List<LeaveDetails> showLeaveBal();

    LeaveDetails searchLeaveBal(int leaveId);

    String updateLeaveBal(LeaveDetails leave) throws LeaveException;

    String deleteLeaveBal(int leaveId);
}