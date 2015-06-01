package whatever.daos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import whatever.models.Event;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by lijc on 15/5/27.
 */
@Transactional
public interface EventDao extends JpaRepository<Event,Long> {

    public Event findById(long id);

    public Page<Event> findByIsInProcessTrue(Pageable pageable);

    public Page<Event> findByIsInProcessFalse(Pageable pageable);

    //开始时间大于输入时间，用于查询未开始活动
    public Page<Event> findByBeginAtGreaterThanAndStatusTrue(Date date,Pageable pageable);

    //用于查询正在进行活动
    public Page<Event> findByBeginAtLessThanEqualAndEndAtGreaterThanEqualAndStatusTrue(Date date,Date date1,Pageable pageable);

    //查询比输入时间更晚开始的已开始活动
    public Page<Event> findByBeginAtLessThanEqualAndEndAtGreaterThanEqualAndBeginAtGreaterThanAndStatusTrue(Date now,Date now1,Date date,Pageable pageable);

    //查询比输入时间更早结束的已开始活动
    public Page<Event> findByBeginAtLessThanEqualAndEndAtGreaterThanEqualAndBeginAtLessThanAndStatusTrue(Date now,Date now1,Date date,Pageable pageable);

    //结束时间小于于输入时间，用于查询已结束活动
    public Page<Event> findByEndAtLessThanAndStatusTrue(Date date,Pageable pageable);

    public Page<Event> findByEndAtLessThanAndEndAtGreaterThanAndStatusTrue(Date now,Date date,Pageable pageable);

    public Page<Event> findByEndAtLessThanAndEndAtLessThanAndStatusTrue(Date now,Date date,Pageable pageable);
}
