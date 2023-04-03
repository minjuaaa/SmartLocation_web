package smartlocation.contracker.web.basic;

import smartlocation.contracker.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import smartlocation.contracker.dto.gps;
import smartlocation.contracker.repository.MemoryMemberRepository;
import smartlocation.contracker.service.GpsService;



import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemoryMemberRepository memberRepository;



    @GetMapping
    public String members(Model model) {
        List<Member> Members = memberRepository.findAll();
        model.addAttribute("members", Members);
        return "basic/members";
    }



    @GetMapping("/{memberId}")
    public String member(@PathVariable long memberId, Model model) {
        Member member = memberRepository.findById(memberId);
        model.addAttribute("member", member);
        return "basic/member";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

    @PostMapping("/add")
    public String addMember(Member member, RedirectAttributes redirectAttributes) {
        Member savedItem = memberRepository.save(member);
        redirectAttributes.addAttribute("memberId", savedItem.getMemberId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/basic/members/{memberId}";
    }

    @GetMapping("/{memberId}/edit")
    public String editForm(@PathVariable Long memberId, Model model) {
        Member member = memberRepository.findById(memberId);
        model.addAttribute("member", member);
        return "basic/editForm";
    }

//    @PostMapping("/{memberId}/edit")
//    public String edit(@PathVariable Long memberId, @ModelAttribute Member member) {
//        memberRepository.update(memberId, member);
//        return "redirect:/basic/members/{memberId}";
//    }

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        memberRepository.save(new Member("김철수", "01012345678"));
        memberRepository.save(new Member("김영희", "01043211111"));
        memberRepository.save(new Member("김수현", "01011115678"));
        memberRepository.save(new Member("정우성", "01012341111"));
        memberRepository.save(new Member("전지현", "01000001111"));
        memberRepository.save(new Member("이재현", "01011112222"));
    }
}
