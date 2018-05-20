package com.service.impl;

import com.dao.ClubInfroDao;
import com.pojo.Club;
import com.service.ClubInfroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubInfroServiceImpl implements ClubInfroService {
    @Autowired
    private ClubInfroDao clubInfroDao;

    @Override
    public Club getClubInfroById(Integer clubId) {
        return clubInfroDao.getClubInfroById(clubId);
    }

    @Override
    public int addNewClub(Club club) {
        return 0;
    }

    @Override
    public int deleteClub(Integer clubId) {
        return 0;
    }

    @Override
    public int updateClub(Integer clubId) {
        return 0;
    }
}
