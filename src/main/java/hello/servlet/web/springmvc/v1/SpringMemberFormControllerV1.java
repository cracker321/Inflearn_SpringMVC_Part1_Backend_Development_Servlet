package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller //- 스프링은 '@Controller가 붙어 있는 클래스'를 '자동'으로 '스프링 빈'으로 등록시켜버린다.
            // 또한, '@Controller의 내부'에는 '@Component'가 있어서, 스프링이 '컴포넌트 스캔'을 할 때, 그 '스캔의 대상'이 된다!
            //- ctrl 누르고, '@Controller'위에 커서 두고 들어가보면, 그 내부에 '@Component', '@Target' 등등을
            //  그 내부 기능으로 포함하고 있음
            //- 또한, '클래스 레벨'에서 '@Controller' 대신, '@Component 하나만', 또는 '@RequestMapping 하나만' 있어도
            //  동일하게 작동한다!
public class SpringMemberFormControllerV1 {


    @RequestMapping("/springmvc/v1/members/new-form")

    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}