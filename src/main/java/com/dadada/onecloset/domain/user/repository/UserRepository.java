package com.dadada.onecloset.domain.user.repository;

import com.dadada.onecloset.domain.user.entity.User;
import com.dadada.onecloset.domain.user.entity.type.LoginType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLoginIdAndLoginType(String loginId, LoginType loginType);

    @Query("SELECT user FROM User user where user.id=:userId AND user.status = true")
    Optional<User> findByIdWhereStatusIsTrue(@Param("userId") Long userId);

}
