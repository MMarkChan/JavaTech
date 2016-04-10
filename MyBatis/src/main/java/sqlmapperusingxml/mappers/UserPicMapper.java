package sqlmapperusingxml.mappers;

import getstarted.installandconfigure.model.Course;
import getstarted.installandconfigure.model.UserPic;
import org.hsqldb.rights.User;

import java.util.List;
import java.util.Map;

public interface UserPicMapper {
    int insertUserPic(UserPic userPic);
    UserPic getUserPic(int id);
}