package com.example.msuserservice.inner.service.domain.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false, unique = true)
    private String encryptedPwd;


//    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
//    @ToString.Exclude
//    private List<recentlyViewdVo> recentlyViewdVoList;


//    public void setRecentlyViewed(String productId) {
//        recentlyViewdVo recentlyViewdVo = new recentlyViewdVo();
//        recentlyViewdVo.setCatalog(productId);
//        recentlyViewdVo.setUserEntity(this);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserEntity that = (UserEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
