package com.neighbor.controller;

import com.neighbor.domain.dto.MessageDTO;
import com.neighbor.domain.dto.MessageRoomDTO;
import com.neighbor.service.BoardService;
import com.neighbor.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage/*")
public class MypageController {

    private final MessageService messageService;
    private final BoardService boardService;

    //   세션 매개변수로 받기
    @GetMapping("/message_box")
    public void goToMessageBox(Model model){
        Long memberId = 1L;
        List<MessageDTO> result = new ArrayList<>();
        List<MessageRoomDTO> entireList = messageService.showList(memberId);

        for (MessageRoomDTO messageRoom : entireList) {
            MessageDTO messageDTO = new MessageDTO();

            messageDTO.setBoardTitle(boardService.showBoardTitle(messageRoom.getBoardId()));
            messageDTO.setLatestRegisterDate(messageService.showLatestDate(messageRoom.getMessageRoomId()));

            result.add(messageDTO);
        }

        model.addAttribute("targetInfo", result);
    }

}