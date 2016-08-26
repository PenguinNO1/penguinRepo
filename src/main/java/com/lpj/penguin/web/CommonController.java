package com.lpj.penguin.web;

import com.lpj.penguin.biz.common.CommonService;
import com.lpj.penguin.common.bean.AuthUserBean;
import com.nfsq.customer.api.ims.org.bean.OrgBean;
import com.nfsq.framework.structure.wrapper.NfsqResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * 组织渠道等公用 web 接口
 * Created by free9 on 15/12/7.
 */
@Controller
public class CommonController {

    @Autowired
    private CommonService commonService;

    /**
     * 获取组织信息接口
     * @return
     */
    @RequestMapping(value = "/org/list")
    @ResponseBody
    public NfsqResult<Set<OrgBean>> orgList(@RequestParam(value = "orgName") String orgName, HttpServletRequest request) {
        AuthUserBean authUserBean = commonService.getAuthUserBean(request);
        return commonService.getOrgTreeByCondition(authUserBean.getEmpId(), orgName);
    }

}
