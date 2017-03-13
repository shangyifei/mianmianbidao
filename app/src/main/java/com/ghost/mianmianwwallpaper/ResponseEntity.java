package com.ghost.mianmianwwallpaper;

/**
 * Created by Ghost on 2017/3/10.
 */

public class ResponseEntity<T> {
    boolean done;
    String msg;
    T retval;

    public boolean isDone() {
        return done;
    }

    public String getMsg() {
        return msg;
    }

    public T getRetval() {
        return retval;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setRetval(T retval) {
        this.retval = retval;
    }
}
