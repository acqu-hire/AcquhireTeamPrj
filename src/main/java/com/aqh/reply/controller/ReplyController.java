package com.aqh.reply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.reply.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 댓글Controller
 * 
 * @author Devesg
 * @since 23.01.11
 * 
 */
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/reply")
@Controller
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping(value = "/asd")
    public String getMethodName() {
    	System.out.println("12");
        System.out.println(replyService.getReply(null));
        return null;
    }

}
