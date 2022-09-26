package multithread;

import com.jdbcdemo.jdbcdemo.dto.PincodeDetails;
import com.jdbcdemo.jdbcdemo.dto.TrainDetailsResponse;
import com.jdbcdemo.jdbcdemo.interfaces.IMultiThreadOne;
import com.jdbcdemo.service.CoreServiceCall;

public class MultiThreadRun extends MultiThreadOne {

	PincodeDetails pd;
	TrainDetailsResponse tD;

	public MultiThreadRun(MultiThreadOne mto) {
		this.pd = mto.getPinCodeDtl();
		this.tD = mto.gettD();
	}

	/*
	 * MultiThreadOne(String task) { this.task = task; }
	 */

	public void run() {
		IMultiThreadOne core = new CoreServiceCall();
		//core.updatePinCodeMasters2(pd);

		System.out.println(tD.toString());
	} // end of run() method.

}
