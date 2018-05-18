package br.ufc.catalogocinemas.utils;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class DatabaseUtils {

    @Autowired
    private DataSource dataSource;

    private Connection connection;

    public void deleteAllSessao(){
        try{
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            //Remover todas as sessões
            statement.execute("DELETE FROM SESSAO");

            //Setar a sequencia de ID para 0
            statement.execute("ALTER SEQUENCE sessao_id_seq RESTART");
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public int getMaxIdSessao(){
        try{
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select max(id) from sessao");

            int id = 0;
            while(rs.next()){
                id = rs.getInt(1);
            }

            return id;

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

        return -1;
    }

    public void inserts() {
        try{
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            //Remover todas as sessões
            statement.execute("INSERT INTO SALA VALUES (1), (2), (3)");
            statement.execute("INSERT INTO FILME VALUES (1), (2), (3)");
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
