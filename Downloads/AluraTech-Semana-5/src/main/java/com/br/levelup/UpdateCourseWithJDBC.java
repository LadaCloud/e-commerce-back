package com.br.levelup;

import com.br.levelup.DAO.CourseDAO;
import com.br.levelup.db.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class UpdateCourseWithJDBC {

    public static void main(String[] args) throws SQLException {

        try(Connection connection = new ConnectionFactory().recoverConnection()) {
            CourseDAO courseDAO = new CourseDAO(connection);
            courseDAO.updatePublicVisibility();
        }

    }

}