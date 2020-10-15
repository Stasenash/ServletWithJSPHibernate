package controller;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/explorer")
public class DirController extends HttpServlet {

    private String userPath = "servlet/users/";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        UserProfile userProfile = AccountService.getInstance().getUserBySessionId("sessionID-" + req.getRemoteAddr());
        String login = userProfile.getLogin();

        req.setAttribute("name", "Hi, " + login);

        userPath = "C:/";
        userPath += login;

        String path = req.getParameter("path");

        File file = new File(userPath);
        if (!file.exists()) {
            file.mkdirs();
        }

        printDirectory(req, (path == null || !path.contains(userPath + login)) ? (userPath) : path, login);

        req.setAttribute("name", userPath);

        req.getRequestDispatcher("explorer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountService.getInstance().deleteSession("sessionID-" + req.getRemoteAddr());
        resp.sendRedirect("/ServletWithJSP_war/");
    }

    private void printDirectory(HttpServletRequest req, String path, String login) {
        StringBuilder attrFiles = new StringBuilder();
        StringBuilder attrFolders = new StringBuilder();
        if (path.lastIndexOf('/') != path.indexOf('/') && !path.substring(path.lastIndexOf('/') + 1).equals(login))
            addDirectory(attrFolders, path.substring(0, path.lastIndexOf('/')), "return");

        File[] files = new File(path).listFiles();
        if (files == null || files.length == 0)
            return;

        for (File file : files) {
            if (file.isDirectory())
                addDirectory(attrFolders, path + "/" + file.getName(), file.getName());
            else
                addFile(attrFiles, file.getName());
        }
        req.setAttribute("folders", attrFolders);
        req.setAttribute("files", attrFiles);
        req.setAttribute("now", new Date());
    }

    private void addDirectory(StringBuilder attrFiles, String path, String text) {
        attrFiles.append("<li><a href=\"?path=")
                .append(path)
                .append("\">")
                .append(text)
                .append("</a></li>");
    }

    private void addFile(StringBuilder attrFiles, String text) {
        attrFiles.append("<li><a>")
                .append(text)
                .append("</a></li>");
    }
}