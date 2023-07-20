package com.poseidon.pro1;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardService {
	
	@Inject
	@Named("boardDAO")
	private BoardDAO boardDAO;
	
	
	
	@Autowired
	private util util; // 컴포넌트 유틸을 불러옵니다

	// 보드 리스트 불러오는 메소드
	public List<Map<String, Object>> boardList() {
		return boardDAO.boardList();
	}

	public BoardDTO detail(int bno) {
		BoardDTO dto = boardDAO.detail(bno);
		//여기서 ip뽑아올수 있죠?
	
			if (dto.getBip()!=null && dto.getBip().indexOf(".")!=-1) {
			String oIP = dto.getBip(); // 기존의 IP 주소를 가져옴
		//ip 중간에 하트 넣어 주실 수 있죠?
		 String[] ipParts = oIP.split("\\.");
		    if (ipParts.length >= 4) {
		        ipParts[1] = "❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️"; // 두 번째 자리를 하트(❤️)로 대체
		        oIP = String.join(".", ipParts); // IP 주소의 모든 점(.)을 하트(❤️)로 대체
		    
		//그거 다시 ip에 저장 하실 수 있죠?
		dto.setBip(oIP); // 수정된 IP 주소를 다시 BoardDTO에 저장
		//끝
		    }
	}
			return dto;
	}
	
	//글쓰기 입니다.
	public void write(BoardDTO dto) {
		//btitle을 꺼내줍니다.
		String btitle = dto.getBtitle();
		
		//btitle = btitle.replaceAll("<", "&lt;");
		//btitle = btitle.replaceAll(">", "&gt;");
		btitle = util.exchange(btitle);
		//값을 변경하겠습니다. replase() < - > 	&lt; > -> 	&gt;

		dto.setBtitle(btitle); //다시 저장해주세요.
		
		dto.setBip(util.getIp());//얻어온 ip도 저장해서 데이터베이스로 보내겠습니다.
		
		boardDAO.write(dto);//실행만 시키고 결과를 받지 않습니다.
		//select를 제외한 나머지는 영향받은 행의 수(int)를 받아오기도 합니다.
	}

	public void delete(BoardDTO dto) {
		boardDAO.delete(dto);
		
		
	}

	public void edit(BoardDTO dto) {
		
		boardDAO.edit(dto);
	}



		
	}
	
	
	
	
	

