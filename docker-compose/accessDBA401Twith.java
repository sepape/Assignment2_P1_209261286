import java.sql.*;

public class AccessDBA401Twith {
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   final String DB_URL = "jdbc:mysql://db:3306/DBA401T";
   try{
      Class.forName("com.mysql.cj.jdbc.Driver");

      conn = DriverManager.getConnection(DB_URL,"root","123456");

      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM DBA401T.Classlist_DBA401T";
      ResultSet rs = stmt.executeQuery(sql);

      String sq;
      sq = "SELECT * FROM DBA401T.DBA401T_TestMarks"
      ResultSet dbResults = stmt.executeQuery(sq);

      while(rs.next()){
         int student_Number  = rs.getInt("StudentNo");
         String first = rs.getString("FirstName");
         String last = rs.getString("LastName");
         String lecturersName = rs.getString("LecturerName");
         String subject_code = rs.getString("SubjectCode");
         String course_name = rs.getString("CourseName");

         System.out.print("StudentNo- " +  student_Number +", FirstName- " + first + ", LastName- " +last +
                           ",LecturerName- "+lecturersName + ",SubjectCode- "+ subject_code +
                           "CourseName- " + course_name);
		 System.out.println();

           int StudentNumber = dbResults.getInt("StudentNo");
           int  chapter_reflect= dbResults.getInt("ChapterReflection");
           int  web_tests= dbResults.getInt("WebTests");
           int assignments = dbResults.getInt("Assignments");
           int  formative_assessment= dbResults.getInt("FormativeAssessment");
           int  summative_assessment= dbResults.getInt("SummativeAssessment");

    System.out.print("StudentNo- " +  StudentNumber +", ChapterReflection- " + chapter_reflect + ", WebTests- " +web_tests +
                                 ",Assignments- "+assignments + ",FormativeAssessment- "+ formative_assessment +
                                 "SummativeAssessment- " + summative_assessment);
      }
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){
      e.printStackTrace();
   }
 }
}
