import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentCheckerImpl {
    public ArrayList check(String id){  //真正执行查询功能，以ArrayList形式返回查询结果
        ArrayList result = new ArrayList();
        for (int i = 0; i < 24; i++) {
            if (i == 0 || i == 1 || i > 3){
                result.add(i, 0);
            }else {
                result.add(i, null);
            }
        }
        //为防止客户端传入不存在的id使result内没有值，导致后续出现异常，先在result里添加默认值
        String sql = "SELECT * FROM score WHERE score.id = " + id;
        DBUtil dbUtil = new DBUtil();
        ResultSet query = dbUtil.query(sql);
//        执行查询
        try {
            if (query.next()){
                    for (int i = 1; i <= result.size(); i++) {
                        result.set(i-1,query.getString(i));
                    }
                    //若查询出结果，则改result里的默认值为查询值
            }
            } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return result;
        }
    }
}
