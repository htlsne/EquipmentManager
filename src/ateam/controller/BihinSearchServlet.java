package ateam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ateam.logic.BihinListLogic;
import ateam.logic.BihinSearchLogic;
import ateam.model.Bihin;

/**
 * Servlet implementation class BihinSearchServlet
 */
@WebServlet("/BihinSearchServlet")
public class BihinSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BihinSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        List<Bihin> list;
        String statusName = request.getParameter("status");
        int status = BihinSearchLogic.getStatusSearch(statusName);
        if (status == 0) {
            list = BihinListLogic.getAllBihinList();
        } else {
            list = BihinSearchLogic.getBihinSearchList(status);
        }
        request.setAttribute("bihinList", list);
        request.getRequestDispatcher("/bihinList.jsp").forward(request, response);
    }

}
