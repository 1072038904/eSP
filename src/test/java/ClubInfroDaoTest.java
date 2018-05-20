import com.dao.ClubInfroDao;
import com.pojo.Club;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class ClubInfroDaoTest {
    @Autowired
    private ClubInfroDao clubInfroDao;

    @Test
    public void getClubInfroByIdTest() {
        Integer clubId = 1;
        Club club = clubInfroDao.getClubInfroById(clubId);
        System.out.print(club.getClubName());
    }
}
