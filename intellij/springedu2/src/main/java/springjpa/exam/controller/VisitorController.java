package springjpa.exam.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import springjpa.exam.entity.Visitor;
import springjpa.exam.repository.VisitorRepository;

@Controller
public class VisitorController {
	private VisitorRepository  repository;
	// @Autowired를 따로 지정하지 않고 생성자를 선언하여 초기화할 수 있음
	// Spring docs에서는 멤버 변수를 통한 Autowired를 하는것도 가능하지만 생성자를 통한 Autowired를 권장한다고 나와있음
	public VisitorController(VisitorRepository repository) {
		this.repository = repository;
	}
	@RequestMapping("/vlist")
	public ModelAndView list() {
		List<Visitor> list = null;
		list = repository.findAll();
		ModelAndView mav = new ModelAndView();	
		if (list.size() != 0) {
			mav.addObject("list", list);
		} else {
			mav.addObject("msg", "추출된 결과가 없어요");
		}
		mav.setViewName("visitorView");
		return mav;
	}

	@RequestMapping("/vsearch")
	public ModelAndView search(String key) {
		List<Visitor> list = null;
		//list = repository.findByMemoLike(key);
		list = repository.findByMemoContains(key);
		ModelAndView mav = new ModelAndView();
		if (list.size() != 0) {
			System.out.println(list);
			mav.addObject("list", list);
		} else {
			mav.addObject("msg", "추출된 결과가 없어요");
		}
		mav.setViewName("visitorView");
		return mav;
	}

	@RequestMapping(value = "/vdelete")
	@Transactional // data 변경할 때는 transaction 상에서 해야하니 이 어노테이션을 사용
	public ModelAndView delete(int id) {
		ModelAndView mav = new ModelAndView();
		try {
			repository.deleteById(id);			
			mav.addObject("list", repository.findAll());
		} catch(Exception e) {			
			mav.addObject("msg", "글 삭제에 실패했습니다.");
		}
		mav.setViewName("visitorView");
		return mav;
	}
	
	@RequestMapping(value = "/one", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Visitor one(int id) {
		Optional<Visitor> result = repository.findById(id);
		return result.get();		
	}

	@RequestMapping(value = "/vinsert", 
			                     method = RequestMethod.POST)
	@Transactional
	public String insert(Visitor vo, Model model) {
		try {
			repository.save(vo);			
			return "redirect:/vlist";
		} catch(Exception e) {			
			model.addAttribute("msg", "글 작성에 실패했습니다.");
		}
		return "visitorView";
	}
	
	@RequestMapping(value = "/vupdate", 
            method = RequestMethod.POST)
	@Transactional
	public String update(Visitor vo, Model model) {		
		try {
			Visitor entity = repository.findById(vo.getId()).get();
			entity.setName(vo.getName());	
			entity.setMemo(vo.getMemo());
			return "redirect:/vlist";
		} catch(Exception e) {						
			model.addAttribute("msg", "글 수정에 실패했습니다.");
		}
		return "visitorView";	
	}
}



