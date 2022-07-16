package br.kenoby.repository;

import br.kenoby.models.QUser;
import br.kenoby.models.User;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.stereotype.Repository;

@Primary
@Repository(value = "userRepository")
@Qualifier("userRepository")
public interface UserRepository extends JpaRepository<User, UUID>, QuerydslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser> {


}
