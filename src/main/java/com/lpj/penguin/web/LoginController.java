package com.lpj.penguin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by free9 on 14/11/20.
 */
@Controller
public class LoginController {

    /**
     * 登陆
     * @param response
     * @return
     */
    @RequestMapping(value="/login")
    public String login(HttpServletResponse response) {
        // 401 需要验证
        response.setStatus(401);
        return "login";
    }

}
