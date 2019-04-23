package com.bbva.pibee.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class NumberUtil {

	public static String formatNumber(Number number, String pattern, char decimalSeparator){
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(decimalSeparator);
		DecimalFormat formatter = new DecimalFormat(pattern, decimalFormatSymbols);
		return formatter.format(number);
	}
	
}
