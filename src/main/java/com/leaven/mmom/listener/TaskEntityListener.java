package com.leaven.mmom.listener;

import com.leaven.mmom.entity.MmomTask;
import com.leaven.mmom.repository.HistoryTaskRepository;
import com.leaven.mmom.utils.BeanUtils;
import jakarta.persistence.PreUpdate;
import jakarta.transaction.Transactional;


/**********
 *    Entity Listener의 callback 함수(어노테이션)
 *    @PrePersist     // Insert호출 전 실행
 *    @PreUpdate      // marge 호출 전 실행
 *    @PreRemove      // Delete호출 전 실행
 *    @PostPersist    // Insert호출 후 실행
 *    @PostUpdate     // marge 호출 후 실행
 *    @PostRemove     // Delete호출 후 실행
 *    @PostLoad       // select호출 후 실행
 **********/
@Transactional
public class TaskEntityListener {

    @PreUpdate
    public void preUpdateTask(Object o){
        HistoryTaskRepository historyTaskRepository = BeanUtils.getBean(HistoryTaskRepository.class);
        MmomTask mmomTask = (MmomTask) o;


    } // end of preUpdateTast
}
