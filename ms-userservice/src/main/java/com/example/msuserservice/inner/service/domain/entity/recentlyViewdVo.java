package com.example.msuserservice.inner.service.domain.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class recentlyViewdVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserEntity userEntity;

    private String catalog;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        recentlyViewdVo recentlyViewdVo = (recentlyViewdVo) o;
        return id != null && Objects.equals(id, recentlyViewdVo.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
