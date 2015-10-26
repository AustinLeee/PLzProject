package com.core.util;

import java.lang.reflect.Field;

import com.core.exception.Code3gException;
import org.apache.log4j.Logger;

public class HibernateUtil {
	private static Logger LOG = Logger.getLogger(HibernateUtil.class);
	
	public static final void checkDataVersion(final Object data1, final Object data2) {
		if (null != data1) {
			try {
				final Field data1Version = data1.getClass().getDeclaredField("version");
				//LOG.debug("find updId in methodinvocation");
				data1Version.setAccessible(true);
				final long data1Verlong = data1Version.getLong(data1);
				
				if (null == data2) {
					final Code3gException pos3ge = new Code3gException("B341005");
					pos3ge.setStatus(1);
					throw pos3ge;
				}
				
				final Field data2Version = data2.getClass().getDeclaredField("version");
				//LOG.debug("find updId in methodinvocation");
				data2Version.setAccessible(true);
				final long data2Verlong = data2Version.getLong(data2);
				
				if (data1Verlong != data2Verlong) {
					final Code3gException pos3ge = new Code3gException("B341005");
					pos3ge.setStatus(1);
					throw pos3ge;
				}
			}  catch (NoSuchFieldException e) {
				LOG.error("check version error, " + e.getMessage(), e);
			} catch (IllegalArgumentException e) {
				LOG.error("check version error, " + e.getMessage(), e);
			} catch (IllegalAccessException e) {
				LOG.error("check version error, " + e.getMessage(), e);
			}
		}
	}
}
