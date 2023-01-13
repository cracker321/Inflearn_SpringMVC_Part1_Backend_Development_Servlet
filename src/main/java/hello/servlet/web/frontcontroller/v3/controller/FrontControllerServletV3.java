package hello.servlet.web.frontcontroller.v3.controller;


import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "frontControllerServletV2", urlPatterns = "/frontcontroller/v2/*")
public class FrontControllerServletV3 extends HttpServlet {
    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV3());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String requestURI = request.getRequestURI();
        ControllerV2 controller = controllerMap.get(requestURI);

        if (controller == null) {response.setStatus(HttpServletResponse.SC_NOT_FOUND);

            return;
        }

        MyView view = controller.process(request, response);
        view.render(request, response);
    }
}