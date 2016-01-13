package com.nfsq.xs.rebates.biz.common;

import com.nfsq.customer.api.ims.channel.service.ChannelCommonDubboService;
import com.nfsq.customer.api.ims.employee.service.AllUserCommonDubboService;
import com.nfsq.customer.api.ims.org.bean.OrgBean;
import com.nfsq.customer.api.ims.org.bean.SearchOrgConditionBean;
import com.nfsq.customer.api.ims.org.service.OrgCommonDubboService;
import com.nfsq.framework.structure.wrapper.NfsqResult;
import com.nfsq.xs.rebates.common.bean.AuthUserBean;
import com.nfsq.xs.rebates.web.interceptor.AuthInterceptor;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * Created by free9 on 15/12/7.
 */
@Component
public class CommonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonService.class);

    @Autowired
    private OrgCommonDubboService orgCommonDubboService;
    @Autowired
    private ChannelCommonDubboService channelCommonDubboService;
    @Autowired
    private AllUserCommonDubboService allUserCommonDubboService;

    /**
     * 获取组织列表
     * @param orgId 当前登陆人ORG_ID
     * @param orgName 组织名
     * @return
     * @throws Exception
     */
    public NfsqResult<Set<OrgBean>> getOrgTreeByCondition(Long orgId, String orgName) {
        SearchOrgConditionBean searchOrgConditionBean = new SearchOrgConditionBean();
        searchOrgConditionBean.setOrgId(orgId);
        if (StringUtils.isNotBlank(orgName)) {
            searchOrgConditionBean.setOrgName(orgName);
        }
        return orgCommonDubboService.getOrgTreeByCondition(searchOrgConditionBean);
    }

    /**
     * 封装 登陆人相关信息
     * @param request
     * @return
     */
    public AuthUserBean getAuthUserBean(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        Object object = httpSession.getAttribute(AuthInterceptor.LOGIN_KEY);
        if (null == object) {
            return null;
        }
        return (AuthUserBean) object;
    }

}
