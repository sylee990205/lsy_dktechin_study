package springrest.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springrest.exam.entity.Friend;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Integer> {
    public List<Friend> findByFname(String fname);
    public List<Friend> findByFage(Integer fage);
}
