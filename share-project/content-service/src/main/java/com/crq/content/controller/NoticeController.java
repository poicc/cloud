package com.crq.content.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.crq.content.common.ResponseResult;
import com.crq.content.common.ResultCode;
import com.crq.content.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RefreshScope
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NoticeController {

    @Value("${disableNoticeRequest:false}")
    private Boolean disableNotice;
    private final NoticeService noticeService;

    @GetMapping("latest")
    @SentinelResource(value = "getNotice",blockHandler = "getNoticeBlock")
    public ResponseResult getNotice() {
        if(disableNotice) {
            log.info("暂停公告服务");
            return ResponseResult.failure(ResultCode.INTERFACE_FORBID_VISIT);
        }
        
        val notice = noticeService.getLatestNotice();
        if(notice != null) {
            return ResponseResult.success(notice);
        } else {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    public ResponseResult getNoticeBlock(BlockException exception) {
        log.info("接口被限流");
        log.info(exception.toString());
        return  ResponseResult.failure(ResultCode.INTERFACE_EXCEED_LOAD);
    }
}
