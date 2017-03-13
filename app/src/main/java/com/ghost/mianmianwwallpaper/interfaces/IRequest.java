package com.ghost.mianmianwwallpaper.interfaces;

import java.util.Map;

/**
 * Created by Ghost on 2017/3/10.
 */

public interface IRequest {
    Map<String,Object> getParams();
    String getBaseUrl();
    String getMothed();
    Map<String,String> getHeader();
}
