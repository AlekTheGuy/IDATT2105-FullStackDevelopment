import java.io.Console;
import java.sql.*;

public class DatabaseWrapper {
    //"?" Shows that there will be a string input into the command.
    public static final String sql = "select * from person where fornavn=?";

    public static void main(String[] args) throws Exception {

        Connection connection = DriverManager
                .getConnection(
                        "jdbc:mysql://mysql.stud.iie.ntnu.no:3306/alekhal" + "?user=alekhal&password=4ml9HIe6");

        //Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "aleksander");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println("Personnr: " + resultSet.getString("personnr"));
            System.out.println("Fornavn: " + resultSet.getString("fornavn"));
            System.out.println("Etternavn: " + resultSet.getString("etternavn"));

        }
    }

} 