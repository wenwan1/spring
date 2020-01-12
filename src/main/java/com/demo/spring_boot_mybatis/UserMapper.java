package     com.demo.spring_boot_mybatis;

import org.springframework.stereotype.Repository;

@Repository
interface UserMapper {

    User findById(int id);
}
