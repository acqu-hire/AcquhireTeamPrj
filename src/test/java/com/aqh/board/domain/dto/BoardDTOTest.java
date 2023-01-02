package com.aqh.board.domain.dto;

import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.domain.dto.BoardDTO.Menu;

public class BoardDTOTest {

    /**
     * builder 패턴 사용 예시
     * 
     * @author Devesg
     */
    public static void main(String[] args) {

        BoardDTO boardDTO = BoardDTO.builder()
                .menu(Menu.COMMUNITY)
                .category(Category.COMMUNITY_LIFE)
                .bNo(1)
                .readCount(123)
                .file(null)
                .title(null)
                .writeDay(null)
                .contents(null)
                .build();

        System.out.println(boardDTO);
    }

}
