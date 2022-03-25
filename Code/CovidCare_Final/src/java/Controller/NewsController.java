/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.NewsDAO;
import DAO.UserDAO;
import Model.News;
import Model.NewsCategory;
import Model.User;
import Utils.UploadFile;
import Utils.ValidatingInput;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author User
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)

public class NewsController extends HttpServlet {

    private static final String UPLOAD_DIR = "images/news";

    private final ValidatingInput check = new ValidatingInput();

    private final NewsDAO newsDAO = new NewsDAO();
    private final UserDAO userDAO = new UserDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewsController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewsController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        String action = request.getParameter("action");
        String id = request.getParameter("id");
        String cateId = request.getParameter("cateId");

        String message = "";

        ArrayList<NewsCategory> categories = (ArrayList) session.getAttribute("newsCate");
        if (categories == null) {
            categories = newsDAO.getCateList();
            session.setAttribute("newsCate", categories);
        }

        if (user == null || user.getUserType() != 1) {
            if (action == null) {
                if (id == null && cateId == null) {
                    request.setAttribute("title", "Tin tức");
                    ArrayList<News> topNews = newsDAO.getTopNewsByCategoryId();
                    request.setAttribute("topNews", topNews);
                    request.getRequestDispatcher("/views/news_list.jsp").forward(request, response);
                } else {
                    if (id != null) {
                        newsDAO.updateReadCount(Integer.parseInt(id));
                        News news = newsDAO.getNewsForReader(Integer.parseInt(id));
                        
                        request.setAttribute("author", userDAO.getUserNameWithId(news.getCreator()));
                        request.setAttribute("title", news.getTitle());
                        request.setAttribute("news", news);
                        request.getRequestDispatcher("/views/news_detail.jsp").forward(request, response);

                    } else {
                        ArrayList<News> newsList = new ArrayList<>();
                        if (cateId == null) {
                            request.setAttribute("title", "Tin tức");
                            sendRedirectError(request, response, "message", "Không tìm thấy mục yêu cầu");
                        } else {
                            NewsCategory category = newsDAO.getCategoryById(Integer.parseInt(cateId));
                            if (category == null) {
                                request.setAttribute("title", "Tin tức");
                                sendRedirectError(request, response, "message", "Không tìm thấy mục yêu cầu");
                            } else {
                                newsList = newsDAO.getNewsListByCategoryId(Integer.parseInt(cateId));
                                request.setAttribute("title", newsDAO.getCateName(Integer.parseInt(cateId)));
                                request.setAttribute("newsList", newsList);
                                request.setAttribute("showCate", category);
                                request.getRequestDispatcher("views/news_list.jsp").forward(request, response);
                            }
                        }
                    }
                }
            } else {
                request.setAttribute("title", "Tin tức");
                sendRedirectError(request, response, "message", "Bạn không có quyền truy cập");
            }
        } else {
            if (action == null) {
                if (id == null) {
                    ArrayList<News> newsList = newsDAO.getAllNews();
                    request.setAttribute("newsList", newsList);
                    request.setAttribute("title", "Quản lý Tin tức");
                    request.getRequestDispatcher("/views/admin/news_manage.jsp").forward(request, response);
                } else {
                    News news = newsDAO.getNewsById(Integer.parseInt(id));

                    request.setAttribute("author", userDAO.getUserNameWithId(news.getCreator()));
                    request.setAttribute("title", news.getTitle());
                    request.setAttribute("news", news);
                    request.getRequestDispatcher("/views/news_detail.jsp").forward(request, response);
                }

            } else {
                if (action.equals("delete")) {
                    newsDAO.hideNews(Integer.parseInt(id));
                    response.sendRedirect("news");
                } else if (action.equals("show")) {
                    newsDAO.showNews(Integer.parseInt(id));
                    response.sendRedirect("news");
                } else if (action.equals("add")) {
                    request.setAttribute("title", "Thêm tin mới");
                    request.getRequestDispatcher("/views/admin/news_edit.jsp").forward(request, response);
                } else if (action.equals("update")) {
                    request.setAttribute("title", "Cập nhật");
                    News news = newsDAO.getNewsById(Integer.parseInt(id));

                    if (news == null) {
                        sendRedirectError(request, response, "message", "Không tìm thấy bài viết");
                    } else {
                        request.setAttribute("news", news);
                        request.getRequestDispatcher("/views/admin/news_edit.jsp").forward(request, response);
                    }
                } else {
                    sendRedirectError(request, response, "message", "Không tìm thấy trang yêu cầu");
                }
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        String action = request.getParameter("action");
        String id = request.getParameter("id");

        if (action.equals("search")) {
            String searchText = request.getParameter("searchText");
            String searchCate = request.getParameter("searchCate");

            if (searchText == null) {
                searchText = "";
            }
            if (searchCate == null) {
                searchCate = "0";
            }

            ArrayList<News> result = newsDAO.searchNews(searchText, Integer.parseInt(searchCate));

            request.setAttribute("title", "Kết quả tìm kiếm");
            request.setAttribute("result", result);
            request.getRequestDispatcher("/views/news_list.jsp").forward(request, response);
        } else {
            News news = new News(0, 0, 0, "", "", "", "", true, null, null, 0);
            
            if (check.isNumber(id)) {
                news = newsDAO.getNewsById(Integer.parseInt(id));
            }
            if (action.equals("add") || action.equals("update")) {
                String error = "";

                String title = request.getParameter("title");
                if (title.length() > 250) {
                    error += "Mô tả vượt quá 250 ký tự.<br>";
                }

                int cateId = -1;
                if (check.isNumber(request.getParameter("category"))) {
                    cateId = Integer.parseInt(request.getParameter("category"));
                }
                if (cateId == 0) {
                    error += "Chưa lựa chọn thể loại.<br>";
                }

                // Profile Image processing
                Part filePart = request.getPart("newsPhoto");
                String image = news.getPhoto();

                String shortDes = request.getParameter("description");
                if (shortDes.length() > 250) {
                    error += "Description vượt quá 250 ký tự.<br>";
                }

                String content = request.getParameter("content");

                boolean isPublish = (request.getParameter("publishStatus").equals("1"));
//                News processing
                if (news.getCreator() == 0) {
                    news.setCreator(user.getUserId());
                }
                news.setCateId(cateId);
                news.setTitle(title);
                news.setContent(content);
                news.setShort_des(shortDes);
                UploadFile ulF = new UploadFile();
                if (!ulF.getFileName(filePart).equals("")) {
                    image = ulF.uploadFile(request, "newsPhoto", UPLOAD_DIR);
                }
                news.setPhoto(image);
                news.setStatus(isPublish);
                if (news.getCreate_date() == null) {
                    news.setCreate_date(new Timestamp(System.currentTimeMillis()));
                }
                if (isPublish && news.getPublish_date() == null) {
                    news.setPublish_date(new Timestamp(System.currentTimeMillis()));
                }

                System.out.println(news.getNewsId());
                System.out.println(news.getCreator());
                System.out.println(news.getCateId());
                System.out.println(news.getTitle());
                System.out.println(news.getContent());
                System.out.println(news.getShort_des());
                System.out.println(news.getPhoto());
                System.out.println(news.isStatus());
                System.out.println(news.getCreate_date());
                System.out.println(news.getPublish_date());
                System.out.println(news.getReadCount());

                int success = 0;
                if (news.getNewsId() == 0) {
                    success = newsDAO.addNews(news);
                } else {
                    success = newsDAO.updateNews(news);
                }
                if (success > 0) {
                    response.sendRedirect("news");
                } else {
                    if (action.equals("add")) {
                        request.setAttribute("title", "Thêm tin mới");
                    }
                    if (action.equals("update")) {
                        request.setAttribute("title", "Cập nhật");
                    }
                    request.setAttribute("message", "Đã có lỗi xảy ra<br>Vui lòng thử lại.");
                    request.setAttribute("error", error);
                    request.setAttribute("news", news);
                    request.getRequestDispatcher("/views/admin/news_edit.jsp").forward(request, response);
                }
            } else {
                sendRedirectError(request, response, "message", "Không tìm thấy trang yêu cầu");
            }
        }
    }

    private void sendRedirectError(HttpServletRequest request, HttpServletResponse response, String attribute, String message) throws ServletException, IOException {
        request.setAttribute(attribute, message);
        request.setAttribute("title", "Lỗi");
        request.getRequestDispatcher("/views/error.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
