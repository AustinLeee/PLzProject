package com.core.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * This class is converts a java.util.Date to a String
 * and a String to a java.util.Date. 
 * 
 * <p>
 * <a href="DateConverter.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class DateConverter implements Converter {
	
	private static final Log log = LogFactory.getLog(DateConverter.class);

	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public DateConverter(String formatPattern) {
		if (StringUtils.isNotBlank(formatPattern)) {
			format = new SimpleDateFormat(formatPattern);
		}
	}


	public Object convert(Class arg0, Object value) {
		try {
			String dateStr = "";
			if(value instanceof String){
				dateStr = (String) value;
			} else if(value instanceof Timestamp){
				dateStr = ((Timestamp)value).toString();
			} else if(value instanceof Date){
				dateStr = format.format((Date)value);
			} /* end of if */

			if (StringUtils.isNotBlank(dateStr)) {
				dateStr = dateStr.replace('/', '-');
				return format.parse(dateStr);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
}
