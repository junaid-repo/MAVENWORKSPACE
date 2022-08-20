package recordTab;

import java.text.DecimalFormat;

public class OracleFunc {
	private static DecimalFormat dcMaskForLng;
	private static DecimalFormat dcMaskForDbl;
	
	public static String to_char(long lngValue)
	{
		if(lngValue == Long.MIN_VALUE) return "";
		return dcMaskForLng.format(lngValue);
	}
	
	public static String to_char(double dblValue) {
		return to_char(dblValue,dcMaskForDbl );
	}
	public static String to_char(double dblValue, String strFormat) {
		return to_char(dblValue,dcMaskForDbl );
	}
	
	public static String to_char(double dblValue, DecimalFormat dcfMask) {
		if(dblValue == Integer.MIN_VALUE || dblValue == Long.MIN_VALUE|| dblValue == Double.MIN_NORMAL) return "";
		return dcfMask.format(dblValue);
	}
}
