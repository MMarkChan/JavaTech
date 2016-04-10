package sqlmapperusingxml.service;

import getstarted.installandconfigure.model.Course;
import getstarted.installandconfigure.model.UserPic;
import org.apache.ibatis.session.SqlSession;
import sqlmapperusingxml.MyBatisUtil;
import sqlmapperusingxml.mappers.CourseMapper;
import sqlmapperusingxml.mappers.UserPicMapper;

import java.io.*;
import java.util.*;

public class UserPicService {

    public void insertUserPic() {
        byte[] pic = null;
        try {
            File file = new File("D:\\win.png");
            InputStream is = new FileInputStream(file);
            pic = new byte[is.available()];
            is.read(pic);
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String name = "UserName";
        String bio = "put some lenghty bio here";
        UserPic userPic = new UserPic(0, name, pic , bio);
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            UserPicMapper mapper = sqlSession.getMapper(UserPicMapper.class);
            mapper.insertUserPic(userPic);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void getUserPic() {
        UserPic userPic = null;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            UserPicMapper mapper =
                    sqlSession.getMapper(UserPicMapper.class);
            userPic = mapper.getUserPic(1);
        } finally {
            sqlSession.close();
        }
        byte[] pic = userPic.getPic();
        try {
            OutputStream os = new FileOutputStream(new
                    File("D:\\win_FromDB.png"));
            os.write(pic);
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
