package multithread;

import com.jdbcdemo.jdbcdemo.dto.PincodeDetails;
import com.jdbcdemo.jdbcdemo.dto.TrainDetailsResponse;

public class MultiThreadOne extends Thread {
	// Declare a String variable to represent task.
	// String task;

	public PincodeDetails pinCodeDtl;
	public TrainDetailsResponse tDd;

	public void updatePincode(PincodeDetails pinCodeDt, TrainDetailsResponse train) throws InterruptedException {
		//MultiThreadOne th1 = new MultiThreadOne();
		MultiThreadOne th2 = new MultiThreadOne();

		//th1.setPinCodeDtl(pinCodeDt);
		//th1.settD(train);
		th2.settD(train);


		//MultiThreadRun obj = new MultiThreadRun(th1);
		MultiThreadRun obj2 = new MultiThreadRun(th2);
		// Passing task as an argument to its constructor.

	//	Thread t1 = new Thread(obj);

		Thread t2 = new Thread(obj2);
		t2.start();
		t2.join();
		//t1.start();
	}

	public TrainDetailsResponse gettD() {
		return tDd;
	}

	public void settD(TrainDetailsResponse tD) {
		this.tDd = tD;
	}

	public PincodeDetails getPinCodeDtl() {
		return pinCodeDtl;
	}

	public void setPinCodeDtl(PincodeDetails pinCodeDtl) {
		this.pinCodeDtl = pinCodeDtl;
	}

}
