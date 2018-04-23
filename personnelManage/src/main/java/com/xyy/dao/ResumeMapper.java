package com.xyy.dao;

import com.xyy.model.Resume;
import com.xyy.model.Tourist;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/21 0021.
 */
public interface ResumeMapper {
    List<Resume> getMyResume(Tourist tourist);

    boolean addResume(Resume resume);

    boolean updateResume(Resume resume);

    Resume getUsingResume(Resume resume);

    boolean deleteResume(Resume resume);

    boolean updateVirtualDeleteResume(Resume resume);
}
