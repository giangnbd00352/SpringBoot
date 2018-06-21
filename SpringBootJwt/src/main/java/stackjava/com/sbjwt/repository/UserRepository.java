package stackjava.com.sbjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import stackjava.com.sbjwt.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
