package cz.uhk.teamworkmanager.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ModelInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

        if (modelAndView != null) {
            // zjisti nazev pohledu a preda do sablony
        	modelAndView.addObject("springViewName", modelAndView.getViewName());
                        
        	// zjisti a preda objekt uzivatele do sablony
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	    modelAndView.addObject("user", auth);
            
        }
        super.postHandle(request, response, handler, modelAndView);
    }

}