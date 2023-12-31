package com.poseidon.pro1;

import java.lang.ProcessBuilder.Redirect;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;





@Controller
public class BoardController {
	// user -> Controller -> Service -> DAO -> mybatis -> DB

	
	
	// Autowired말고 Resource로 연결
	@Resource(name = "boardService")
	private BoardService boardService;

	@Autowired
	
	private util util;//컴포넌트 util과 연결했습니다. //우리가만든 숫자변환을 사용하기 위해
	
	
	
	
	@GetMapping("/board")
	public String board(Model model) {
		// 서비스에서 값 가져오기
		model.addAttribute("list", boardService.boardList());

		return "board";
	}

	// http://localhost:8000/pro1/detail?bno=143
	// 파라미터로 들어오는 값 잡기
	@GetMapping("detail")
	public String detail(HttpServletRequest request, Model model) {
		//String bno = request.getParameter("bno");
		int bno = util.StrToInt(request.getParameter("bno"));
		// bno에 요청하는 값이 있습니다. 이 값을 db까지 보내겠습니다.
		BoardDTO dto = boardService.detail(bno);
		model.addAttribute("dto", dto);

		return "detail";
	}

	@GetMapping("/write")
	public String write() {
		return "write";
	}

	@PostMapping("/write")
	public String write(HttpServletRequest request) {
		// 사용자가 입력한 데이터 변수에 담기
		//System.out.println(request.getParameter("title"));
		//상대방 ip가져오기 2323-07-19
		String ip =null; //192.168.0.0 ->httpservetrequest가 있어야 합니다.
	
		ip = request.getHeader("X-Forwarded-For");

	      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	         ip = request.getHeader("Proxy-Client-IP");
	      }
	      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	         ip = request.getHeader("WL-Proxy-Client-IP");
	      }
	      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	         ip = request.getHeader("HTTP_CLIENT_IP");
	      }
	      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	         ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	      }
	      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	         ip = request.getHeader("X-Real-IP");
	      }
	      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	         ip = request.getHeader("X-RealIP");
	      }
	      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	         ip = request.getHeader("REMOTE_ADDR");
	      }
	      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	         ip = request.getRemoteAddr();
	      }
		BoardDTO dto= new BoardDTO();
		dto.setBtitle(request.getParameter("title"));
		dto.setBcontent( request.getParameter("content"));
		dto.setBwrite("홍길동2");//이건 임시로 적었습니다. 로그인 추가되면 변경할께요??
		// Service - > DAT - > mybatis - > DB로 보내서 저장하기
		boardService.write(dto);
//		replace(/.d{1,3}.d{1,3}$/, '.***.***', ipAddr);
		return "redirect:board";// 다시 컨트롤러 지나가기 GET방식으로 갑니다.
	}
		
		//삭제가 들어온다면 http://172.30.1.19/delete?
		@GetMapping("/delete")
		public String delete(@RequestParam(value = "bno",required = true, defaultValue = "0") int bno) {//HttpServletRequest
			//System.out.println("bno : " + no);
			//dto
			BoardDTO dto = new BoardDTO();
			dto.setBno(bno);
			//dto.setBwrite(null) 사용자 정보
			//추후 로그인을 하면 사용자의 정보다 담아서 보냅니다.
			
			boardService.delete(dto);
			
			
			return"redirect:board";//삭제를 완료한 후에 다시 보드로 갑니다.
	}
		@GetMapping("/edit")
		public ModelAndView edit(@RequestParam("bno")int bno) {
			ModelAndView mv = new ModelAndView("edit");//edit.jsp
			//데이터베이스에 bno를 보내서 dto 를 얻어옵니다.
			BoardDTO dto = boardService.detail(bno);
			//mv에 실어보냅니다.
			mv.addObject("dto", dto);
			return mv;
					
		}
		@PostMapping("/edit")
		public String edit (BoardDTO dto) {
		//System.out.println("map: "+map);
//			System.out.println(dto.getBtitle());
	//		System.out.println(dto.getBcontent());
		//	System.out.println(dto.getBno());
			
			boardService.edit(dto);
			
			return "redirect:detail?bno=" +dto.getBno(); //보드로 이동하게 해주세요.
		}
}



