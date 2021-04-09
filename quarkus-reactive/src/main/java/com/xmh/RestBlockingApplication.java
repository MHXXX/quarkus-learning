package com.xmh;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import io.smallrye.common.annotation.Blocking;
/**
 * .
 *
 * @author 谢明辉
 * @date 2021/3/19
 */
@ApplicationPath("/")
@Blocking
public class RestBlockingApplication extends Application {
}
