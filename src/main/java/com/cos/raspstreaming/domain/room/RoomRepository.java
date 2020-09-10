package com.cos.raspstreaming.domain.room;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomRepository extends JpaRepository<Room, Long>{
	Page<Room> findByCompanyId(long companyId, Pageable pageable);
	
	@Query(value = "select * from room where id not in (select distinct roomId from funeral where startDate between :startDate and :startDate + INTERVAL 2 day or endDate between :startDate and :startDate + INTERVAL 2 day and companyId = (select companyId from user where id = :companyId))", nativeQuery = true)
	List<Room> mFindActiveRooms(String startDate, long companyId);
}
