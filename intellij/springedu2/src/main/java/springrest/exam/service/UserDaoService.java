package springrest.exam.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import springrest.exam.domain.User;

// 통합 클래스 이름 Dao + Service
@Service
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;

    // static block
    static{
        users.add(new User(1, "둘리",new Date(), "dooly", "1234"));
        users.add(new User(2, "또치",new Date(), "ddochi", "9999"));
        users.add(new User(3, "도우너",new Date(), "dauner", "0000"));
    }

    // 모든 유저 리스트 반환
    public List<User> findAll(){
        return users;
    }

    // 유저 회원 가입 + 유저 count up
    public User save(User user){
        if(user.getId()== null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    // 한명의 유저 반환
    public User findOne(int id){
        for(User user : users){
            if(user.getId()== id){
                return user;
            }
        }
        return null;
    }

    // 사용자 삭제
    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()){
            User user = iterator.next();

            if(user.getId()==id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}