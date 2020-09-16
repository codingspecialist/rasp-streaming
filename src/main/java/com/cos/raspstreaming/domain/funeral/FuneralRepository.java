package com.cos.raspstreaming.domain.funeral;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuneralRepository extends JpaRepository<Funeral, Long>{
	Page<Funeral> findByCompanyId(long companyId, Pageable pageable);
}
