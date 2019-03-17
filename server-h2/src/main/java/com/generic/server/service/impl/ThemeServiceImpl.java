package com.generic.server.service.impl;

import com.generic.common.constant.ResponseEnum;
import com.generic.common.exception.ThemeInfoException;
import com.generic.server.dto.ThemeInfo;
import com.generic.server.repository.ThemeInfoRepository;
import com.generic.server.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    private ThemeInfoRepository themeInfoRepository;
    @Override
    public ResponseEnum saveThemeInfo(ThemeInfo themeInfo) throws ThemeInfoException {
         themeInfoRepository.save(themeInfo);
        return ResponseEnum.SUCCESS;
    }

    @Override
    public Iterable<ThemeInfo> findAllThemeInfo() throws ThemeInfoException {
        return themeInfoRepository.findAll();
    }
}
