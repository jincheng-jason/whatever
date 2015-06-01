package whatever.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import whatever.daos.EventDao;
import whatever.models.Event;

import java.util.Date;

/**
 * Created by lijc on 15/5/27.
 */
@Service
public class EventService {

    @Autowired
    EventDao eventDao;

    public Page<Event> findIsInProcess(Pageable pageable){
        return eventDao.findByIsInProcessTrue(pageable);
    }

    public Page<Event> findNotInProcess(Pageable pageable){
        return eventDao.findByIsInProcessFalse(pageable);
    }

    //即将开始
    public Page<Event> findStarting(Date date,Pageable pageable){
        return eventDao.findByBeginAtGreaterThanAndStatusTrue(date, pageable);
    }

    //已经结束
    public Page<Event> findEnded(Date date,Pageable pageable){
        return eventDao.findByEndAtLessThanAndStatusTrue(date, pageable);
    }

    public Page<Event> findNewerEnded(Date date,Pageable pageable){
        Date now = new Date();
        return eventDao.findByEndAtLessThanAndEndAtGreaterThanAndStatusTrue(now, date, pageable);
    }

    public Page<Event> findOlderEnded(Date date,Pageable pageable){
        Date now = new Date();
        return eventDao.findByEndAtLessThanAndEndAtLessThanAndStatusTrue(now, date, pageable);
    }

    //已开始未结束
    public Page<Event> findStarted(Date date,Pageable pageable){
        return eventDao.findByBeginAtLessThanEqualAndEndAtGreaterThanEqualAndStatusTrue(date,date,pageable);
    }

    public Page<Event> findNewerStarted(Date date,Pageable pageable){
        Date now = new Date();
        return eventDao.findByBeginAtLessThanEqualAndEndAtGreaterThanEqualAndBeginAtGreaterThanAndStatusTrue(now,now,date,pageable);
    }

    public Page<Event> findOlderStarted(Date date,Pageable pageable){
        Date now = new Date();
        return eventDao.findByBeginAtLessThanEqualAndEndAtGreaterThanEqualAndBeginAtLessThanAndStatusTrue(now, now, date, pageable);
    }

}
