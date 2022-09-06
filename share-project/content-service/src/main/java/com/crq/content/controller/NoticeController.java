package com.crq.content.controller;

import com.crq.content.common.ResponseResult;
import com.crq.content.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/6 16:31
 */
@RestController
@RequestMapping(value = "/notices")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("latest")
    public ResponseResult getNotice() {
        return ResponseResult.success(noticeService.getLatestNotice());
    }
}
