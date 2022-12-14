package com.crq.content.service.impl;

import com.crq.content.domain.entity.Notice;
import com.crq.content.repository.NoticeRepository;
import com.crq.content.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author: crq
 * @description:
 * @date: 2022/9/6 16:29
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NoticeServiceImpl implements NoticeService {
    private final NoticeRepository noticeRepository;


    @Override
    public Notice getLatestNotice() {
        Sort sort = Sort.by("createTime").descending();
        return noticeRepository.findByShowFlag(true,sort).get(0);
    }
}
