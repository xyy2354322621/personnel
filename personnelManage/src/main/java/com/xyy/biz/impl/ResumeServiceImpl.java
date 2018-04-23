package com.xyy.biz.impl;

import com.xyy.biz.ResumeService;
import com.xyy.dao.ResumeMapper;
import com.xyy.model.Resume;
import com.xyy.model.Tourist;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/21 0021.
 */
@Service
public class ResumeServiceImpl implements ResumeService {

    @Resource
    private ResumeMapper resumeMapper;

    @Override
    public List<Resume> getMyResume(Tourist tourist) {
        return resumeMapper.getMyResume(tourist);
    }

    @Override
    public boolean addResume(Resume resume) {
        return resumeMapper.addResume(resume) ;
    }

    @Override
    public boolean updateResume(Resume resume) {
        return resumeMapper.updateResume( resume) ;
    }

    @Override
    public Resume getUsingResume(Resume resume) {
        return resumeMapper.getUsingResume( resume);
    }

    @Override
    public boolean deleteResume(Resume resume) {
        return resumeMapper.deleteResume(resume);
    }

    @Override
    public boolean updateVirtualDeleteResume(Resume resume) {
        return resumeMapper.updateVirtualDeleteResume(resume);
    }

}
