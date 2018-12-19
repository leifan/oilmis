package com.mltech.brite.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateUtil {

	public static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public static String convertToYYYYMMDDHHMMSS(Timestamp timestamp) {

		return sdf.format(timestamp.getDate());

	}

	public static String convertToYYYYMMDDHHMMSS(long timeMillions) {

		return sdf.format(timeMillions);

	}

}
