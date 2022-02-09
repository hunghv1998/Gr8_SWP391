package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("  <title>Login</title>\n");
      out.write("  <meta charset=\"utf-8\" />\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n");
      out.write("  <link rel=\"stylesheet\" href=\"../css/style.css\" />\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\" />\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\"></script>\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body class=\"body-wrapper\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  <section>\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-md-12\">\n");
      out.write("          <nav class=\"navbar navbar-expand-lg navbar-light navigation\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"index.html\">\n");
      out.write("              <img src=\"../images/icon.png\" alt=\"\" width=\"100\" height=\"100\">\n");
      out.write("            </a>\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\n");
      out.write("              aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("              <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("              <ul class=\"navbar-nav ml-auto main-nav \">\n");
      out.write("                <li class=\"nav-item active\">\n");
      out.write("                  <a class=\"nav-link\" href=\"home.html\">Trang chủ</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item active\">\n");
      out.write("                  <a class=\"nav-link\" href=\"\">Hỗ Trợ Trực Tuyến</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item active\">\n");
      out.write("                  <a class=\"nav-link\" href=\"news.html\">Tin tức</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item active\">\n");
      out.write("                  <a class=\"nav-link\" href=\"\">Thời gian biểu</a>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("              </ul>\n");
      out.write("              <ul class=\"navbar-nav ml-auto mt-10\">\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                  <a class=\"nav-link login-button\" href=\"login.html\">Login</a>\n");
      out.write("                </li>\n");
      out.write("              </ul>\n");
      out.write("            </div>\n");
      out.write("          </nav>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </section>\n");
      out.write("\n");
      out.write("  <section class=\"hero-area bg-1 text-center overly\">\n");
      out.write("    <!-- Container Start -->\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-md-12\">\n");
      out.write("          <!-- Header Contetnt -->\n");
      out.write("          <div class=\"content-block\">\n");
      out.write("            <h1>Covid Care</h1>\n");
      out.write("            <p>Tư vấn và hướng dẫn sức khỏe cộng đồng mùa covid <br> Cập nhật diễn biến covid hàng ngày</p>\n");
      out.write("            <div class=\"short-popular-category-list text-center\">\n");
      out.write("              <h2>Danh mục phổ biến</h2>\n");
      out.write("              <ul class=\"list-inline\">\n");
      out.write("                <li class=\"list-inline-item\">\n");
      out.write("                  <a href=\"news.html\"><i class=\"fa fa-newspaper-o\"></i> Bản Tin Covid</a>\n");
      out.write("                </li>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"list-inline-item\">\n");
      out.write("                  <a href=\"\">Chat</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"list-inline-item\">\n");
      out.write("                  <a href=\"\">Thời Gian Biểu</a>\n");
      out.write("                </li>\n");
      out.write("              </ul>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- Container End -->\n");
      out.write("  </section>\n");
      out.write("\n");
      out.write("  <section class=\"login py-5 border-top-1\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"row justify-content-center\">\n");
      out.write("        <div class=\"col-lg-5 col-md-8 align-item-center\">\n");
      out.write("          <div class=\"border\">\n");
      out.write("            <h3 class=\"bg-gray p-4\">Đăng Nhập</h3>\n");
      out.write("            <form action=\"#\">\n");
      out.write("              <fieldset class=\"p-4\">\n");
      out.write("                <input type=\"text\" placeholder=\"Tài khoản\" class=\"border p-3 w-100 my-2\">\n");
      out.write("                <input type=\"password\" placeholder=\"Mật khẩu\" class=\"border p-3 w-100 my-2\">\n");
      out.write("                <div class=\"loggedin-forgot\">\n");
      out.write("                  <input type=\"checkbox\" id=\"keep-me-logged-in\">\n");
      out.write("                  <label for=\"keep-me-logged-in\" class=\"pt-3 pb-2\">Ghi nhớ</label>\n");
      out.write("                </div>\n");
      out.write("                <button type=\"submit\"\n");
      out.write("                  class=\"d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3\">Đăng\n");
      out.write("                  Nhập</button>\n");
      out.write("                <a class=\"mt-3 d-block  text-primary\" href=\"#\">Quên mật khẩu ?</a>\n");
      out.write("                <a class=\"mt-3 d-inline-block text-primary\" href=\"register.jsp\">Đăng ký ngay</a>\n");
      out.write("              </fieldset>\n");
      out.write("            </form>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </section>\n");
      out.write("\n");
      out.write("  <!--Footer-->\n");
      out.write("\n");
      out.write("  <footer class=\"footer section section-sm\">\n");
      out.write("    <!-- Container Start -->\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-lg-4 col-md-7 offset-md-1 offset-lg-0\">\n");
      out.write("          <!-- About -->\n");
      out.write("          <div class=\"block about\">\n");
      out.write("            <!-- footer logo -->\n");
      out.write("            <img src=\"../images/footer.png\" alt=\"\" width=\"250\">\n");
      out.write("            <!-- description -->\n");
      out.write("            <p class=\"alt-color\">Cuộc sống bận rộn có thể khiến bạn quên đi sức khỏe bản thân,\n");
      out.write("              đặc biệt là mùa covid. Nhưng đến khi bị bệnh, nhiều người lại không muốn đến bệnh viện\n");
      out.write("              vì quá đông và nguy cơ lây nhiễm cao.\n");
      out.write("              Hiểu được điều đó, COVID CARE có thể giúp bạn dễ dàng kết nối với\n");
      out.write("              bác sĩ và tư vấn cũng như hướng dẫn trực tuyến tại nhà.</p>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Link list -->\n");
      out.write("        <div class=\"col-lg-6 offset-lg-1 col-md-3\" style=\"text-align: right;\">\n");
      out.write("          <div class=\"block\">\n");
      out.write("            <h4>Mọi đóng góp ý kiến xin liên hệ</h4>\n");
      out.write("            <ul>\n");
      out.write("              <li><a href=\"#\">Đường dây nóng: 0123456789</a></li>\n");
      out.write("              <li><a href=\"#\">Email: group8@gmail.com</a></li>\n");
      out.write("              <li><a href=\"#\">Website: Covid Care</a></li>\n");
      out.write("              <li><a href=\"#\">Facebook: group8/facebook.com</a></li>\n");
      out.write("            </ul>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- Container End -->\n");
      out.write("  </footer>\n");
      out.write("  <!-- Footer Bottom -->\n");
      out.write("  <footer class=\"footer-bottom\">\n");
      out.write("    <!-- Container Start -->\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div>\n");
      out.write("          <!-- Copyright -->\n");
      out.write("          <div class=\"copyright\">\n");
      out.write("            <p style=\"text-align: center;\">Copyright © 2022</p>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </footer>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
