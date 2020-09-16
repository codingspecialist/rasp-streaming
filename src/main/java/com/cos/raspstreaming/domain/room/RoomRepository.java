package com.cos.raspstreaming.domain.room;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomRepository extends JpaRepository<Room, Long>{
	Page<Room> findByCompanyId(long companyId, Pageable pageable);
	
	// 장례식 예약 2020-09-17 ~ 2020-09-18 이렇게 예약이 되는데...실제로 사용은 2020-09-19 오전까지 여서 다음 예약자는 2020-09-19부터 사용가능
	@Query(value = "select * from room where id not in (select distinct roomId from funeral where startDate between :startDate and :startDate + INTERVAL 1 day or endDate between :startDate + INTERVAL 1 day and :startDate + INTERVAL 2 day and companyId = (select companyId from user where id = :companyId))", nativeQuery = true)
	List<Room> mFindActiveRooms(String startDate, long companyId);
}
