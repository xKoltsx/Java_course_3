package org.example.lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBService {

    final String url;
    final String username;
    final String password;
    final Connection connection;

    DBService(String url, String username, String password) throws SQLException, ClassNotFoundException {
        this.url = url;
        this.username = username;
        this.password = password;
        connection = getConnection();
    }
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        //Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url,username,password);
    }
    void dropAllTables() throws ClassNotFoundException, SQLException {
        String sqlStatement[] =
                {
                        "DROP TABLE IF EXISTS circle",
                        "DROP TABLE IF EXISTS rectangle",
                        "DROP TABLE IF EXISTS shape"

                };
        Statement statement = connection.createStatement();
        for (String sqlSt:sqlStatement) {
            statement.execute(sqlSt);
        }
        System.out.println("All tables removed");
    }
    void createAllTables() throws SQLException {
        String sqlStatement[]=
                {
                        """
                        CREATE TABLE lab5.shape (
                            id BIGINT NOT NULL AUTO_INCREMENT,
                            shapeName varchar(100) NOT NULL,
                            type varchar(100) NOT NULL,
                            CONSTRAINT PK_SHAPE PRIMARY KEY (id)
                        );
                        """,
                        """
                         CREATE TABLE lab5.rectangle (
                            id BIGINT NOT NULL AUTO_INCREMENT,
                            length INT NOT NULL,
                            width INT NOT NULL,
                            id_shape BIGINT,
                            CONSTRAINT PK_RECTANGLE PRIMARY KEY (id),
                            FOREIGN KEY (id_shape) REFERENCES lab5.shape(id) ON UPDATE CASCADE ON DELETE SET NULL
                        );
                        """,
                        """
                         CREATE TABLE lab5.circle (
                            id BIGINT NOT NULL AUTO_INCREMENT,
                            radius INT NOT NULL,
                            id_shape BIGINT,
                            CONSTRAINT PK_CIRCLE PRIMARY KEY (id),
                            FOREIGN KEY (id_shape) REFERENCES lab5.shape(id) ON UPDATE CASCADE ON DELETE SET NULL
                        );
                        """
                };

        Statement statement = connection.createStatement();
        for (String sqlSt:sqlStatement) {
            statement.execute(sqlSt);
        }
        System.out.println("All tables created");
    }
}