package application.repository;

import application.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    Optional<Login> findByUsernameAndPassword(String username, String password);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Login SET token=MD5(CONCAT(?1, CURRENT_TIMESTAMP)) WHERE username=?1 AND pwd=?2", nativeQuery = true)
    void generateTokenNativeQuery(String username, String password);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Login SET expired_at=CURRENT_TIMESTAMP WHERE token=?1", nativeQuery = true)
    void signOut(String token);
}
