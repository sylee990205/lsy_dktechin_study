package com.example.springedu.controller;

import com.example.springedu.domain.LottoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("count")
public class lottoController {

    @ModelAttribute("count")
    public int[] countMethod() {
        System.out.println("count 객체 생성");
        return new int[1];
    }
/*    @ModelAttribute("lotto")
    public LottoDTO lottoMethod() {
        System.out.println("lotto 객체 생성");
        LottoDTO dto = new LottoDTO();
        return dto;
    }*/

    @GetMapping("/lotto")
    public String handler(@ModelAttribute("lotto") LottoDTO dto, @ModelAttribute("count") int[] count, int lottoNum){
        dto.setLottoNum((int) (Math.random() * 6 + 1));
        count[0]++;
        System.out.println(count[0]+"번째 뽑기");
        int lotto = dto.getLottoNum();
        System.out.println("입력한 숫자:" + lottoNum);
        System.out.println("뽑힌 숫자:" + lotto);
        if(count[0] > 3){
            dto.setResult("로또 응모는 낙첨된 경우에 한하여 3번 까지만 가능합니다.<br>브라우저를 재기동한 후에 응모해주세요");
            dto.setImgName("stop");
        } else {
            if(lotto == lottoNum){
                dto.setResult("추카추카!!");
                dto.setImgName("win");
                count[0] = 3; // 이미 당첨됐으면 더이상 X
            } else {
                dto.setResult("아쉽네요 .. 다음 기회를!!");
                dto.setImgName("fail");
            }
        }

        return "lottoView";
    }

}
