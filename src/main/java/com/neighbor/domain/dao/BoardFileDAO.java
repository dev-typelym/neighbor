package com.neighbor.domain.dao;

import com.neighbor.domain.vo.BoardFileVO;
import com.neighbor.mapper.BoardFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardFileDAO {

    private final BoardFileMapper boardFileMapper;
    /* 파일 추가 */
    public void save(BoardFileVO boardFileVO){boardFileMapper.insert(boardFileVO);}
    
    /* boardId로 파일 전체 가져오기*/
    public List<BoardFileVO> findByBoardId(Long boardId){return boardFileMapper.selectAll(boardId);}

    /* board로 모든 거 삭제하기 */
    public void delete(Long boardId){ boardFileMapper.delete(boardId);}

    //    전일 등록된 파일 조회
    public List<BoardFileVO> findByFilePath(){return boardFileMapper.selectYesterday();}
}