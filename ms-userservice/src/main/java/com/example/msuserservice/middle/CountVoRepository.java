package com.example.msuserservice.middle;

import com.example.msuserservice.inner.service.domain.entity.recentlyViewdVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountVoRepository extends JpaRepository<recentlyViewdVo, Long> {
}