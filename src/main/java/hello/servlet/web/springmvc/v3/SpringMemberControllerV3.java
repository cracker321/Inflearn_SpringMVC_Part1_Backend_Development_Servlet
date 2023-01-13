package hello.servlet.web.springmvc.v3;


import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * v3
 * Model 도입
 * ViewName 직접 반환
 *
 * @RequestParam 사용
 * @RequestMapping -> @GetMapping, @PostMapping
 */
@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    //@RequestMapping(value = "/new-form", method = RequestMethod.GET) 이렇게 쓰는 대신 아래에 '@GetMapping'을 슨다
    @GetMapping("/new-form")
    public String newForm() {

        return "new-form";
    }


    //@RequestMapping(value = "/save", method = RequestMethod.Post) 이렇게 쓰는 대신 아래에 '@PostMapping'을 슨다
    @PostMapping("/save")
    public String save(@RequestParam("username") String username,
                       @RequestParam("age") int age, Model model) {
                            //'@RequestParam'은 이전의 'request.geParameter("username")'과 같은 의미이다!


        Member member = new Member(username, age);
        memberRepository.save(member);
        
        model.addAttribute("member", member); //'모델 객체'에 'member'를 넣어서 '뷰'로 보내줌

        return "save-result";
    }


    
    @GetMapping
    public String members(Model model) {

        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);

        return "members";
    }
}

