package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc.Connect;
import jdbc.SqlCRUD;
import users.User1;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Servlet1/*")
public class Servlet1 extends HttpServlet {
    private static final long SerialVersionUID = 1L;

    LabCRUDInterface<User1> crud = new SqlCRUD();
    Connect connect;

    public void init(ServletConfig config) throws ServletException{
        this.connect = new Connect();
        crud = new SqlCRUD();
    }

    public void destroy(){
        try {
            ((SqlCRUD )crud).getConnection().close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setAccessControlHeaders(response);
        response.setContentType("application/json");
        response.getWriter().println(crud.read());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setAccessControlHeaders(response);
        User1 user = Helpers.userParse(request);
        crud.create(user);
        doGet(request, response);
    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setAccessControlHeaders(response);
        User1 user = Helpers.userParse(request);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        crud.update(id, user);
        doGet(request, response);
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setAccessControlHeaders(response);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        crud.delete(id);
        doGet(request, response);
    }
    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setAccessControlHeaders(response);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    private void setAccessControlHeaders(HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Allow-Headers", "*");
    }
}