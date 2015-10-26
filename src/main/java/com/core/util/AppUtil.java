package com.core.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.core.exception.Code3gException;
import com.core.vo.app.*;
import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;

public class AppUtil {
	
	private static final Logger LOG = Logger.getLogger(AppUtil.class);
	
	/**
	 * 組合 Exception 訊息
	 * <p/>	 * 
	 * @param msgDesc : Exception 描述
	 * @param e : Exception e
	 * @return resultVO :ResultRMIVO
	 */
	public static ResultRMIVO getErrorResultRMIVO(String msgDesc, Exception e){
		ResultRMIVO resultVO = new ResultRMIVO();
		resultVO.setStatus(-1);
		resultVO.setMsgDesc("Server Error : " + msgDesc);
		StringBuffer message = new StringBuffer();
		getCauseString(message,e);
		resultVO.setMessage(message.toString());
		return resultVO;
	}
	
	public static ResultRMIVO getErrorResultRMIVO(MessageSource messageSource, Code3gException e){
		ResultRMIVO resultVO = new ResultRMIVO();
		resultVO.setStatus(-1);
		resultVO.setMsgDesc("Server Error : " + messageSource.getMessage(e.getMessageCode(), e.getArgs(), AppContext.getHttpRequest().getLocale()));
		StringBuffer message = new StringBuffer();
		getCauseString(message,e);
		resultVO.setMessage(message.toString());
		return resultVO;
	}
	
	public static SearchResultRMIVO getErrorSearchResultRMIVO(String msgDesc, Exception e){
		SearchResultRMIVO resultVO = new SearchResultRMIVO();
		resultVO.setStatus(-1);
		resultVO.setMsgDesc("Server Error : " + msgDesc);
		StringBuffer message = new StringBuffer();
		getCauseString(message,e);
		resultVO.setMessage(message.toString());
		return resultVO;
	}
	
	public static SearchResultRMIVO getErrorSearchResultRMIVO(MessageSource messageSource, Code3gException e){
		SearchResultRMIVO resultVO = new SearchResultRMIVO();
		resultVO.setStatus(-1);
		resultVO.setMsgDesc("Server Error : " + messageSource.getMessage(e.getMessageCode(), e.getArgs(), AppContext.getHttpRequest().getLocale()));
		StringBuffer message = new StringBuffer();
		getCauseString(message,e);
		resultVO.setMessage(message.toString());
		return resultVO;
	}
	
	/**
	 * 從QueryRMIVO的parm物件解出SearchCriterionRMIVO陣列
	 * @param queryVo
	 * @return
	 */
	public static SearchCriterionRMIVO[] getSearchCriterion(QueryRMIVO queryVo){
		SearchCriterionRMIVO[] searchCriterionRMIVOs = null;
		if(queryVo.getParms()!=null && queryVo.getParms().containsKey("searchCriterion")){
			Object value = queryVo.getParms().get("searchCriterion");
			Object[] obj = (Object[])value;
			searchCriterionRMIVOs = new SearchCriterionRMIVO[obj.length];
			for(int i=0;i<obj.length;i++){
				searchCriterionRMIVOs[i] = (SearchCriterionRMIVO)obj[i];				
			}			
		}
		return searchCriterionRMIVOs;
	}
	
	/**
	 * 使用SearchCriterionRMIVO陣列重組出查詢用參數Map
	 * @param searchCriterionRMIVOs
	 * @return
	 */
	public static Map<String,Object> getSearchCriterionParmMap(SearchCriterionRMIVO[] searchCriterionRMIVOs){
		Map<String,Object> map = new HashMap<String,Object>();
		if(searchCriterionRMIVOs!=null){
			for(int i=0;i<searchCriterionRMIVOs.length;i++){
				map.put(searchCriterionRMIVOs[i].getFieldName(), searchCriterionRMIVOs[i].getValue()); 			
			}			
		}
		return map;
	}
	
	/**
	 * 使用SearchCriterionRMIVO陣列重組出查詢用Operator參數Map
	 * @param searchCriterionRMIVOs
	 * @return
	 */
	public static Map<String,Object> getSearchCriterionOpParmMap(SearchCriterionRMIVO[] searchCriterionRMIVOs){
		Map<String,Object> map = new HashMap<String,Object>();
		if(searchCriterionRMIVOs!=null){
			for(int i=0;i<searchCriterionRMIVOs.length;i++){
				map.put(searchCriterionRMIVOs[i].getFieldName(), searchCriterionRMIVOs[i].getOperator()); 			
			}			
		}
		return map;
	}
	
	/**
	 * 取得SearchCriterionRMIVO中和fieldName對應的value值
	 * @param searchCriterionRMIVOs
	 * @param fieldName
	 * @return
	 */
	public static String getSearchCriterionOperator(SearchCriterionRMIVO[] searchCriterionRMIVOs,String fieldName){
		String op = "=";
		if(searchCriterionRMIVOs!=null){
			for(int i=0;i<searchCriterionRMIVOs.length;i++){
				if(searchCriterionRMIVOs[i].getFieldName().equals(fieldName)){
					op = searchCriterionRMIVOs[i].getOperator();
					break;
				}	
			}			
		}
		return op;
	}
	
	/**
	 * 取得SearchCriterionRMIVO中和fieldName對應的Operator值
	 * @param searchCriterionRMIVOs
	 * @param fieldName
	 * @return
	 */
	public static String getSearchCriterionValue(SearchCriterionRMIVO[] searchCriterionRMIVOs,String fieldName){
		String op = "";
		if(searchCriterionRMIVOs!=null){
			for(int i=0;i<searchCriterionRMIVOs.length;i++){
				if(searchCriterionRMIVOs[i].getFieldName().equals(fieldName)){
					op = searchCriterionRMIVOs[i].getValue();
					break;
				}	
			}			
		}
		return op;
	}
	
	private static void getCauseString(StringBuffer message,Throwable e){
		message.append("<b>" + e.toString() + "</b>\n");		
		StackTraceElement[] elements = e.getStackTrace();
		for (int i=0;i<elements.length;i++){
			String msgStr = elements[i].toString();
			if(msgStr.indexOf("com.pic.")!=-1)
				message.append("<b>      at   <FONT COLOR='#ff0000'>" + elements[i].toString() + "</FONT></b>\n");
			else
				message.append("      at   " + elements[i].toString() + "\n");
		}
		if(e.getCause()!=null)
			getCauseString(message,e.getCause());
	}
	
	public static ResultRMIVO getErrorResultRMIVO(final Code3gException e, final MessageSource messageSource){
		LOG.debug("in getErrorResultRMIVO");
		final String errCode = e.getMessageCode();
		LOG.debug("messageCode = " + errCode);
		final String errMsg = messageSource.getMessage(errCode, e.getArgs(), AppContext.getHttpRequest().getLocale());
		LOG.debug("errMsg = " + errMsg);
		final ResultRMIVO resultVO = new ResultRMIVO();
		resultVO.setStatus(e.getStatus());
		final String errCodeMsg = buildErrCodeMsg(e, messageSource);
		if (e.getStatus() < 0) {
			resultVO.setMsgDesc("Server Error : " + errCodeMsg);
		} else {
			resultVO.setMsgDesc(errCodeMsg);
		}
		StringBuffer message = new StringBuffer();
		message.append(errCode).append(" ").append(errMsg);
		getCauseString(message,e);
		resultVO.setMessage(message.toString());
		resultVO.setResult(e.getResult());
		return resultVO;
	}
	
	public static SearchResultRMIVO getErrorSearchResultRMIVO(final Code3gException e, final MessageSource messageSource){
		LOG.debug("in getErrorResultRMIVO");
		final String errCode = e.getMessageCode();
		LOG.debug("messageCode = " + errCode);
		final String errMsg = messageSource.getMessage(errCode, e.getArgs(), AppContext.getHttpRequest().getLocale());
		//LOG.debug("errMsg = " + errMsg);
		final SearchResultRMIVO resultVO = new SearchResultRMIVO();
		resultVO.setStatus(e.getStatus());
		final String errCodeMsg = buildErrCodeMsg(e, messageSource);
		if (e.getStatus() < 0) {
			resultVO.setMsgDesc("Server Error : " + errCodeMsg);
		} else {
			resultVO.setMsgDesc(errCodeMsg);
		}
		StringBuffer message = new StringBuffer();
		message.append(errCode).append(" ").append(errMsg);
		getCauseString(message,e);
		resultVO.setMessage(message.toString());
		resultVO.setResult(e.getResult());
		return resultVO;
	}
	
	private static String buildErrCodeMsg(final Code3gException e, final MessageSource messageSource) {
		final StringBuffer strBuf = new StringBuffer();
		final String errCode = e.getMessageCode();
		final String errMsg = messageSource.getMessage(errCode, e.getArgs(), AppContext.getHttpRequest().getLocale());
		LOG.debug("base messageCode = " + errCode + ", base errMsg = " + errMsg);
		strBuf.append(errCode).append(" ").append(errMsg);
		final List<Code3gException> exceptionList = e.getExceptionList();
		for (Code3gException pos3ge:exceptionList) {
			final String othErrCode = pos3ge.getMessageCode();
			final String othErrMsg = messageSource.getMessage(othErrCode, pos3ge.getArgs(), AppContext.getHttpRequest().getLocale());
			LOG.debug("other messageCode = " + othErrCode + ", other errMsg = " + othErrMsg);
			strBuf.append("\n").append(othErrCode).append(" ").append(othErrMsg);
		}
		LOG.debug("final message = " + strBuf.toString());
		return strBuf.toString();
	}
}
