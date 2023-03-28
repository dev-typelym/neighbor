package com.neighbor.service;

import com.neighbor.domain.dao.MessageDAO;
import com.neighbor.domain.dto.MessageDTO;
import com.neighbor.domain.dto.MessageRoomDTO;
import com.neighbor.domain.vo.MessageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageDAO messageDAO;

    //    <!-- 내가 보낸 쪽지 전체 -->
    public List<MessageRoomDTO> showList(Long memberId){return messageDAO.findAll(memberId);}

    //    <!-- 해당 게시글의 쪽지 내역-->
    public List<MessageVO> showMessage(Long messageRoomId){return messageDAO.findMessage(messageRoomId);}

    //    <!-- 전체 쪽지 개수 -->
    public Integer getCountList(Long memberId){return messageDAO.findCountList(memberId);}

    //    <!-- 쪽지 대화 내용 개수 -->
    public Integer getCountMessage(Long messageRoomId){return messageDAO.findCountMessage(messageRoomId);}

    //    <!-- 쪽지 대화 내역 중 가장 최근 날짜 -->
    public String showLatestDate(Long messageRoomId){return messageDAO.findLatestDate(messageRoomId);}

    //    <!-- 대화방 번호 가져오기 -->
    public Long getMessageRoomId(Long memberId, Long boardId){return messageDAO.findMessageRoomId(memberId, boardId);}

}
