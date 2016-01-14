package com.lpj.penguin.web.interceptor;

import com.lpj.penguin.biz.common.CommonService;
import com.lpj.penguin.common.bean.AuthUserBean;
import com.nfsq.customer.api.ims.employee.bean.AllUserBean;
import com.nfsq.customer.api.ims.employee.service.AllUserCommonDubboService;
import com.nfsq.customer.api.ims.org.service.OrgCommonDubboService;
import com.nfsq.framework.structure.wrapper.NfsqResult;
import com.nfsq.sso.sdk.beans.User;
import com.nfsq.sso.sdk.oauth2.OAuthSDK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * Created by free9 on 15/12/7.
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

    public static final String LOGIN_KEY = "SECURITY_LOGINUSER";

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthInterceptor.class);

    @Autowired
    private CommonService commonService;
    /**
     * 从IMS获取用户信息 dubbo类
     */
    @Autowired
    private AllUserCommonDubboService allUserCommonDubboService;
    @Autowired
    private OrgCommonDubboService orgCommonDubboService;

    /**
     * 执行前拦截处理
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 初始化 session
        HttpSession httpSession = request.getSession();
        if(httpSession.getAttribute(LOGIN_KEY) == null){
            LOGGER.info("{} key not exists", LOGIN_KEY);

            //从sso获取用户基本信息
            User user = OAuthSDK.instance().getBaseUserInfo(request, response);
            if(user == null){
                LOGGER.error("sso获取用户信息异常!");
                OAuthSDK.instance().returnNoLoginData(response);
                return false;
            }

            try {
                AuthUserBean authUserBean = this.getAuthUserBean(user);

                if (null == authUserBean) {
                    //如果未登录状态，清除session登录用户信息
                    if (httpSession.getAttribute(LOGIN_KEY) != null){
                        Enumeration enumeration = httpSession.getAttributeNames();
                        while (enumeration.hasMoreElements()) {
                            httpSession.removeAttribute((String) enumeration.nextElement());
                        }
                    }

                    response.sendRedirect(request.getContextPath() + "/login.htm");
                    return false;
                } else {
                    httpSession.setAttribute(LOGIN_KEY, authUserBean);
                }
            } catch (Exception e) {
                LOGGER.error("查询用户数据失败！", e);
                return false;
            }
        }
        return true;
    }

    /**
     * 返回包装后的 AuthUserBean
     * @param user
     * @return
     */
    public AuthUserBean getAuthUserBean(User user){
        if (null == user) {
            return null;
        }

        AllUserBean allUserBean = getAllUser(user.getUid().toString());
        if (null == allUserBean) {
            return null;
        }

        AuthUserBean authUserBean = new AuthUserBean();
        authUserBean.setEmpId(Long.valueOf(allUserBean.getUserId()));
        authUserBean.setEmpName(allUserBean.getUserName());
        authUserBean.setOrgId(Long.valueOf(allUserBean.getOrgId()));
        authUserBean.setPosId(Long.valueOf(allUserBean.getPosId()));
        return authUserBean;
    }

    /**
     * 根据当前登陆人id获取相关职位信息
     * @param empId
     * @return
     */
    public AllUserBean getAllUser(String empId) {
        NfsqResult<AllUserBean> allUserBean;
        try {
            allUserBean = allUserCommonDubboService.getAllUser(empId);
        } catch (Exception e){
            LOGGER.error("Dubbo 接口 AllUserCommonDubboService.getAllUser 错误", e);
            return null;
        }
        if (allUserBean.isSuccess()) {
            return allUserBean.getData();
        } else {
            LOGGER.error("allUserCommonDubboService.getAllUser(" + empId + ")" + allUserBean.getMessage());
        }

        return null;
    }

}
