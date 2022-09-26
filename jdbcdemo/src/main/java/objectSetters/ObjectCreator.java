package objectSetters;

import com.jdbcdemo.jdbcdemo.dto.PincodeDetails;
import com.jdbcdemo.jdbcdemo.dto.TrainDetailsResponse;

public class ObjectCreator {

	public static PincodeDetails pinCodeDetailsSetter(String pin, String office, String office_type, String delivery, String division,
			String region, String circle, String taluk, String district, String state_id, String phone,
			String related_suboffice, String related_headoffice, String longitude, String latitude, String trainNo) {

		PincodeDetails pd = new PincodeDetails();

		pd.pin = pin;
		pd.office = office;
		pd.office_type = office_type;
		pd.delivery = delivery;
		pd.division = division;
		pd.region = region;
		pd.circle = circle;
		pd.taluk = taluk;
		pd.district = district;
		pd.state_id = state_id;
		pd.phone = phone;
		pd.related_suboffice = related_suboffice;
		pd.related_headoffice = related_headoffice;
		pd.longitude = longitude;
		pd.latitude = latitude;
		pd.trainNo=trainNo;

		return pd;
	}
public static TrainDetailsResponse trainDetailsSetter(String trainNo, String trainDetails) {
	TrainDetailsResponse train = new TrainDetailsResponse();
	TrainDetailsResponse tr = new TrainDetailsResponse();
	
	tr.trainDetails=trainDetails;
	tr.trainNumber=trainNo;
	
	return tr;
}
}
