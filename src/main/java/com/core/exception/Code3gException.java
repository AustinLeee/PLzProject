package com.core.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * LYZ1G 使用的Exception,<br/>
 * 其中<br/>
 * messageCode為訊息庫的代碼, 如B111001<br/>
 * args為要取代的字串陣列</br>
 * status為 UI ResultRMIVO所使用
 * @author 李喻哲
 */
public class Code3gException extends RuntimeException {

    private static final long serialVersionUID = -1694906970565932314L;
    private Object[] args = null;
    private String messageCode = "";
    private int status = -1;
    private Object result = null;
    private List<Code3gException> exceptionList = new ArrayList<Code3gException>(0);

    public Code3gException() {}

    public Code3gException(final String messageCode) {
        super(messageCode);
        this.messageCode = messageCode;
    }

    public Code3gException(final String messageCode, final Object[] args) {
        super(messageCode);
        this.messageCode = messageCode;
        this.args = args;
    }

    public Code3gException(final String messageCode, final Throwable cause) {
        super(cause.getMessage(), cause);
        this.messageCode = messageCode;
    }

    public Code3gException(final String messageCode, final Throwable cause, final Object[] args) {
        super(cause.getMessage(), cause);
        this.args = args;
        this.messageCode = messageCode;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(final Object[] args) {
        this.args = args;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(final String messageCode) {
        this.messageCode = messageCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public void addOtherException(final Code3gException pos3ge) {
        exceptionList.add(pos3ge);
    }

    public List<Code3gException> getExceptionList() {
        return exceptionList;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(final Object result) {
        this.result = result;
    }
}
