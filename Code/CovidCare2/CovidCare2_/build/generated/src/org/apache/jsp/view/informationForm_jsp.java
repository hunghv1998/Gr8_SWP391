package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.UserInfo;

public final class informationForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/view/../common/head.jsp");
    _jspx_dependants.add("/view/../common/nav.jsp");
    _jspx_dependants.add("/view/../common/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_c_when_test.release();
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</title>\r\n");
      out.write("    <meta charset=\"utf-8\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\" />\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("</head>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <body class=\"body-wrapper\">\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<section>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-12\">\r\n");
      out.write("                <nav class=\"navbar navbar-expand-lg navbar-light navigation\">\r\n");
      out.write("                    <a class=\"navbar-brand\" href=\".\">\r\n");
      out.write("                        <img src=\"images/icon.png\" alt=\"\" width=\"100\" height=\"100\">\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\r\n");
      out.write("                            aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                        <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("                        <ul class=\"navbar-nav ml-auto main-nav \">\r\n");
      out.write("                            <li class=\"nav-item active\">\r\n");
      out.write("                                <a class=\"nav-link\" href=\".\">Trang chủ</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"nav-item active\">\r\n");
      out.write("                                <a class=\"nav-link\" href=\"\">Hỗ Trợ Trực Tuyến</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"nav-item active\">\r\n");
      out.write("                                <a class=\"nav-link\" href=\"news.jsp\">Tin tức</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"nav-item active\">\r\n");
      out.write("                                <a class=\"nav-link\" href=\"timetable\">Thời gian biểu</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                        </ul>\r\n");
      out.write("                        <ul class=\"navbar-nav ml-auto mt-10\">\r\n");
      out.write("                            ");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </nav>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!--==================================\r\n");
      out.write("        =            User Profile            =\r\n");
      out.write("        ===================================-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <section class=\"dnx_content form-nguoidan\">\r\n");
      out.write("        <div class=\"dnx_content_inner\">\r\n");
      out.write("            <div class=\"dnx_content_box\">\r\n");
      out.write("                <h3>Thông tin liên hệ</h3>\r\n");
      out.write("                <div class=\"dnx_content_form\">\r\n");
      out.write("                    <div class=\"dnx_content_form_2col clearfix\">\r\n");
      out.write("                        <div class=\"dnx_content_form_item clearfix\">\r\n");
      out.write("                            <div class=\"dnx_content_form_item_lab\">\r\n");
      out.write("                                <div class=\"dnx_content_form_item_lab\">Họ và tên <span class=\"text-danger\">*</span>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"dnx_content_form_item_field\">\r\n");
      out.write("                                <input type=\"text\" id=\"ho_ten\" data-bind=\"value:ho_ten\"\r\n");
      out.write("                                    class=\"text-uppercase form-control\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"dnx_content_form_item clearfix\">\r\n");
      out.write("                            <div class=\"dnx_content_form_item_lab\">\r\n");
      out.write("                                Giới tính\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"dnx_content_form_item_field\">\r\n");
      out.write("                                <select id=\"gioi_tinh\" data-bind=\"value:gioi_tinh\" placeholder=\"Nhập nội dung\">\r\n");
      out.write("                                    <option class=\"default-selected\" value=\"1\" selected=\"\">Nam</option>\r\n");
      out.write("                                    <option value=\"2\">Nữ</option>\r\n");
      out.write("                                    <option value=\"3\">Khác</option>\r\n");
      out.write("                                </select>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"dnx_content_form_2col clearfix\">\r\n");
      out.write("                    <div class=\"dnx_content_form_item clearfix\">\r\n");
      out.write("                        <div class=\"dnx_content_form_item_lab\">\r\n");
      out.write("                            Ngày sinh <span class=\"text-danger\">*</span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"dnx_content_form_item_field\">\r\n");
      out.write("                            <input class=\"datetimepicker-input form-control\" type=\"DD/MM/YYYY\"\r\n");
      out.write("                                placeholder=\"DD/MM/YYYY\"><input type=\"text\" id=\"ngay_sinh\" data-bind=\"value:ngay_sinh\"\r\n");
      out.write("                                style=\"display: none;\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"dnx_content_form_item clearfix\">\r\n");
      out.write("                        <div class=\"dnx_content_form_item_lab\">\r\n");
      out.write("                            Số điện thoại <span class=\"text-danger\">*</span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"dnx_content_form_item_field\">\r\n");
      out.write("                            <input type=\"text\" id=\"so_dien_thoai\" data-bind=\"value:so_dien_thoai\" class=\"form-control\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <p class=\"mt-3\">Địa chỉ nơi đang ở:</p>\r\n");
      out.write("                <div class=\"dnx_content_form_2col clearfix\">\r\n");
      out.write("                    <div class=\"dnx_content_form_item clearfix\">\r\n");
      out.write("                        <div class=\"dnx_content_form_item_lab\">\r\n");
      out.write("                            Tỉnh /Thành\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"dnx_content_form_item_field\">\r\n");
      out.write("                            <!-- <select class=\"form-control input_ward\" placeholder=\"Xã phường\" id=\"selectize_tinhthanh\"\r\n");
      out.write("                    translate=\"xa_phuong\"></select> -->\r\n");
      out.write("                            <input id=\"default_tinhthanh\" type=\"text\" disabled=\"\" value=\"Thành phố Hà Nội\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"dnx_content_form_item clearfix\">\r\n");
      out.write("                        <div class=\"dnx_content_form_item_lab\">\r\n");
      out.write("                            Quận/Huyện\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"dnx_content_form_item_field\">\r\n");
      out.write("                            <select id=\"gioi_tinh\" data-bind=\"value:gioi_tinh\" placeholder=\"Nhập nội dung\">\r\n");
      out.write("                                <option class=\"default-selected\" value=\"1\" selected=\"\">Chọn quận huyện</option>\r\n");
      out.write("                                <option value=\"2\">Ba Vì</option>\r\n");
      out.write("                                <option value=\"3\">Chương Mĩ</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"dnx_content_form_2col clearfix\">\r\n");
      out.write("                    <div class=\"dnx_content_form_item clearfix\">\r\n");
      out.write("                        <div class=\"dnx_content_form_item_lab\">\r\n");
      out.write("                            Phường/Xã\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"dnx_content_form_item_field\">\r\n");
      out.write("                            <select id=\"gioi_tinh\" data-bind=\"value:gioi_tinh\" placeholder=\"Nhập nội dung\">\r\n");
      out.write("                                <option class=\"default-selected\" value=\"1\" selected=\"\">Chọn phường/xã</option>\r\n");
      out.write("                                <option value=\"2\">Thị trấn Xuân Mai</option>\r\n");
      out.write("                                <option value=\"3\">Xã Đông Sơn</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"dnx_content_form_item clearfix\">\r\n");
      out.write("                        <div class=\"dnx_content_form_item_lab\">\r\n");
      out.write("                            Thôn/Xóm/Tổ\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"dnx_content_form_item_field\">\r\n");
      out.write("                            <select id=\"gioi_tinh\" data-bind=\"value:gioi_tinh\" placeholder=\"Nhập nội dung\">\r\n");
      out.write("                                <option class=\"default-selected\" value=\"1\" selected=\"\">Chọn Thôn/Xóm/Tổ</option>\r\n");
      out.write("                                <option value=\"2\">Bùi Xá</option>\r\n");
      out.write("                                <option value=\"3\">Chiến Thắng</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"dnx_content_form_item clearfix\">\r\n");
      out.write("                    <div class=\"dnx_content_form_item_lab\" style=\"line-height: normal;\">\r\n");
      out.write("                        Số nhà, tên đường\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"dnx_content_form_item_field\">\r\n");
      out.write("                        <input type=\"text\" id=\"dia_chi\" data-bind=\"value:dia_chi\" class=\"form-control\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <h3>TÌNH TRẠNG SỨC KHỎE</h3>\r\n");
      out.write("                <div class=\"dnx_content_form\">\r\n");
      out.write("                    <div class=\"dnx_content_form_item clearfix\">\r\n");
      out.write("                        <div class=\"dnx_content_form_item_lab\" style=\"line-height: 17px !important;\">\r\n");
      out.write("                            Tình trạng tiêm vaccine?\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"dnx_content_form_item_field\">\r\n");
      out.write("                            <!-- <input  data-bind=\"value:so_mui_da_tiem\"/> -->\r\n");
      out.write("                            <select id=\"so_mui_da_tiem\" data-bind=\"value:so_mui_da_tiem\">\r\n");
      out.write("                                <!-- <option value=\"1\" selected=\"selected\">Đã tiêm 2 mũi trở lên, thời gian tiêm mũi 2 đã trên 2 tuần</option>\r\n");
      out.write("                    <option value=\"0\" selected=\"selected\">Lựa chọn khác</option> -->\r\n");
      out.write("                                <option value=\"0\" selected=\"selected\">Chưa tiêm</option>\r\n");
      out.write("                                <option value=\"2\" selected=\"selected\">Đã tiêm 1 mũi</option>\r\n");
      out.write("                                <option value=\"3\" selected=\"selected\">Đã tiêm 2 mũi, thời gian tiêm mũi 2 dưới 2 tuần\r\n");
      out.write("                                </option>\r\n");
      out.write("                                <option value=\"1\" selected=\"selected\">Đã tiêm 2 mũi, thời gian tiêm mũi 2 trên 2 tuần\r\n");
      out.write("                                </option>\r\n");
      out.write("                                <option value=\"4\" selected=\"selected\">Đã tiêm 3 mũi</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"dnx_content_form_item clearfix\">\r\n");
      out.write("                        <div class=\"dnx_content_form_item_lab\" style=\"line-height: normal;\">\r\n");
      out.write("                            Tên vắc xin\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"dnx_content_form_item_field\">\r\n");
      out.write("                            <ul class=\"loaivx\">\r\n");
      out.write("                                <li><input type=\"checkbox\" value=\"1\" id=\"vacxin-1\" name=\"vacxin\"><label\r\n");
      out.write("                                        for=\"vacxin-1\">AstraZeneca</label></li>\r\n");
      out.write("                                <li><input type=\"checkbox\" value=\"2\" id=\"vacxin-2\" name=\"vacxin\"><label\r\n");
      out.write("                                        for=\"vacxin-2\">Pfizer/BioTech</label></li>\r\n");
      out.write("                                <li><input type=\"checkbox\" value=\"3\" id=\"vacxin-3\" name=\"vacxin\"><label\r\n");
      out.write("                                        for=\"vacxin-3\">SPUTNIK V</label></li>\r\n");
      out.write("                                <li><input type=\"checkbox\" value=\"4\" id=\"vacxin-4\" name=\"vacxin\"><label\r\n");
      out.write("                                        for=\"vacxin-4\">Moderna</label></li>\r\n");
      out.write("                                <li><input type=\"checkbox\" value=\"5\" id=\"vacxin-5\" name=\"vacxin\"><label\r\n");
      out.write("                                        for=\"vacxin-5\">Vero Cell</label></li>\r\n");
      out.write("                                <li><input type=\"checkbox\" value=\"6\" id=\"vacxin-6\" name=\"vacxin\"><label\r\n");
      out.write("                                        for=\"vacxin-6\">Janssen</label></li>\r\n");
      out.write("                                <li><input type=\"checkbox\" value=\"7\" id=\"vacxin-7\" name=\"vacxin\"><label\r\n");
      out.write("                                        for=\"vacxin-7\">Abdala (Cuba)</label></li>\r\n");
      out.write("                                <li><input type=\"checkbox\" value=\"8\" id=\"vacxin-8\" name=\"vacxin\"><label\r\n");
      out.write("                                        for=\"vacxin-8\">Khác</label></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"dnx_content_form_item\">\r\n");
      out.write("                        <p>Phụ nữ có thai hoặc sinh con &lt;= 42 ngày tuổi không?</p>\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"radio\" id=\"co_thai\" name=\"co_thai\" value=\"1\"><label\r\n");
      out.write("                                    for=\"co_thai\">Có</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"radio\" id=\"khong_co_thai\" name=\"co_thai\" value=\"0\" checked=\"\"><label\r\n");
      out.write("                                    for=\"khong_co_thai\">Không</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"dnx_content_form_item clearfix\">\r\n");
      out.write("                        <p>Có tình trạng cấp cứu chuyên khoa</p>\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"radio\" id=\"co_capcuu\" name=\"co_capcuu\" value=\"1\"><label\r\n");
      out.write("                                    for=\"co_capcuu\">Có</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"radio\" id=\"khong_capcuu\" name=\"co_capcuu\" value=\"0\" checked=\"\"><label\r\n");
      out.write("                                    for=\"khong_capcuu\">Không</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"dnx_content_form_item clearfix\">\r\n");
      out.write("                        <div class=\"dnx_content_form_item_lab\" style=\"line-height: 17px !important;\">\r\n");
      out.write("                            Người bệnh thuộc nhóm tuổi\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"dnx_content_form_item_field\">                         \r\n");
      out.write("                            <select id=\"loai_do_tuoi\" data-bind=\"value:loai_do_tuoi\">\r\n");
      out.write("                    <option value=\"1\" selected=\"selected\">Bệnh nhi dưới 3 tháng tuổi</option>\r\n");
      out.write("                    <option value=\"2\" selected=\"selected\">Dưới 50 tuổi</option>\r\n");
      out.write("                    <option value=\"3\" selected=\"selected\">Từ 50 đến 64 tuổi</option>\r\n");
      out.write("                    <option value=\"4\" selected=\"selected\">Trên 65 tuổi</option>\r\n");
      out.write("                </select>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"dnx_content_form_item\">\r\n");
      out.write("                        <p>Người bệnh có đang điều trị một hay nhiều các bệnh nào trong số các bệnh sau đây?</p>\r\n");
      out.write("                        <ul class=\"check_lst danhsach-benhnen\">\r\n");
      out.write("                            <!--             \r\n");
      out.write("                  <li>\r\n");
      out.write("                    <input type=\"checkbox\" />\r\n");
      out.write("                    <label>\r\n");
      out.write("                      20. Có bệnh lý cấp tính kèm theo</label>\r\n");
      out.write("                  </li> -->\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" id=\"benhnen_1\" name=\"benh_nen_chi_tiet\"\r\n");
      out.write("                                    data-noidung=\"Đái tháo đường\" data-id=\"1\">\r\n");
      out.write("                                <label style=\"width: calc(100% - 20px) !important;\" for=\"benhnen_1\">1. Đái tháo\r\n");
      out.write("                                    đường</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" id=\"benhnen_2\" name=\"benh_nen_chi_tiet\"\r\n");
      out.write("                                    data-noidung=\"Bệnh phổi tắc nghẽn mãn tính và các bệnh phổi khác\" data-id=\"2\">\r\n");
      out.write("                                <label style=\"width: calc(100% - 20px) !important;\" for=\"benhnen_2\">2. Bệnh phổi tắc\r\n");
      out.write("                                    nghẽn mãn tính và các bệnh phổi khác</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" id=\"benhnen_3\" name=\"benh_nen_chi_tiet\"\r\n");
      out.write("                                    data-noidung=\"Ung thư đặc biệt là các khối u ác tính về huyết học, ung thư phổi và bệnh ung thư di căn khác\"\r\n");
      out.write("                                    data-id=\"3\">\r\n");
      out.write("                                <label style=\"width: calc(100% - 20px) !important;\" for=\"benhnen_3\">3. Ung thư đặc biệt\r\n");
      out.write("                                    là các khối u ác tính về huyết học, ung thư phổi và bệnh ung thư di căn khác</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" id=\"benhnen_4\" name=\"benh_nen_chi_tiet\"\r\n");
      out.write("                                    data-noidung=\"Bệnh thận mạn tính\" data-id=\"4\">\r\n");
      out.write("                                <label style=\"width: calc(100% - 20px) !important;\" for=\"benhnen_4\">4. Bệnh thận mạn\r\n");
      out.write("                                    tính</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" id=\"benhnen_5\" name=\"benh_nen_chi_tiet\"\r\n");
      out.write("                                    data-noidung=\"Ghép tạng hoặc cấy ghép tế bào gốc tạo máu\" data-id=\"5\">\r\n");
      out.write("                                <label style=\"width: calc(100% - 20px) !important;\" for=\"benhnen_5\">5. Ghép tạng hoặc\r\n");
      out.write("                                    cấy ghép tế bào gốc tạo máu</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" id=\"benhnen_6\" name=\"benh_nen_chi_tiet\"\r\n");
      out.write("                                    data-noidung=\"Béo phì, thừa cân\" data-id=\"6\">\r\n");
      out.write("                                <label style=\"width: calc(100% - 20px) !important;\" for=\"benhnen_6\">6. Béo phì, thừa\r\n");
      out.write("                                    cân</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" id=\"benhnen_7\" name=\"benh_nen_chi_tiet\"\r\n");
      out.write("                                    data-noidung=\"Bệnh tim mạch (suy tim, bệnh động mạch vành hoặc bệnh cơ tim)\"\r\n");
      out.write("                                    data-id=\"7\">\r\n");
      out.write("                                <label style=\"width: calc(100% - 20px) !important;\" for=\"benhnen_7\">7. Bệnh tim mạch\r\n");
      out.write("                                    (suy tim, bệnh động mạch vành hoặc bệnh cơ tim)</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" id=\"benhnen_8\" name=\"benh_nen_chi_tiet\"\r\n");
      out.write("                                    data-noidung=\"Bệnh lý mạch máu não\" data-id=\"8\">\r\n");
      out.write("                                <label style=\"width: calc(100% - 20px) !important;\" for=\"benhnen_8\">8. Bệnh lý mạch máu\r\n");
      out.write("                                    não</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" id=\"benhnen_9\" name=\"benh_nen_chi_tiet\"\r\n");
      out.write("                                    data-noidung=\"Hội chứng Down\" data-id=\"9\">\r\n");
      out.write("                                <label style=\"width: calc(100% - 20px) !important;\" for=\"benhnen_9\">9. Hội chứng\r\n");
      out.write("                                    Down</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" id=\"benhnen_10\" name=\"benh_nen_chi_tiet\" data-noidung=\"HIV/AIDS\"\r\n");
      out.write("                                    data-id=\"10\">\r\n");
      out.write("                                <label style=\"width: calc(100% - 20px) !important;\" for=\"benhnen_10\">10.\r\n");
      out.write("                                    HIV/AIDS</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" id=\"benhnen_11\" name=\"benh_nen_chi_tiet\"\r\n");
      out.write("                                    data-noidung=\"Bệnh lý thần kinh, bao gồm cả chứng sa sút trí tuệ\" data-id=\"11\">\r\n");
      out.write("                                <label style=\"width: calc(100% - 20px) !important;\" for=\"benhnen_11\">11. Bệnh lý thần\r\n");
      out.write("                                    kinh, bao gồm cả chứng sa sút trí tuệ</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" id=\"benhnen_12\" name=\"benh_nen_chi_tiet\"\r\n");
      out.write("                                    data-noidung=\"Bệnh hồng cầu hình liềm\" data-id=\"12\">\r\n");
      out.write("                                <label style=\"width: calc(100% - 20px) !important;\" for=\"benhnen_12\">12. Bệnh hồng cầu\r\n");
      out.write("                                    hình liềm</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" id=\"benhnen_13\" name=\"benh_nen_chi_tiet\"\r\n");
      out.write("                                    data-noidung=\"Bệnh hen suyễn\" data-id=\"13\">\r\n");
      out.write("                                <label style=\"width: calc(100% - 20px) !important;\" for=\"benhnen_13\">13. Bệnh hen\r\n");
      out.write("                                    suyễn</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" id=\"benhnen_14\" name=\"benh_nen_chi_tiet\"\r\n");
      out.write("                                    data-noidung=\"Tăng huyết áp\" data-id=\"14\">\r\n");
      out.write("                                <label style=\"width: calc(100% - 20px) !important;\" for=\"benhnen_14\">14. Tăng huyết\r\n");
      out.write("                                    áp</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" id=\"benhnen_15\" name=\"benh_nen_chi_tiet\"\r\n");
      out.write("                                    data-noidung=\"Thiếu hụt miễn dịch\" data-id=\"15\">\r\n");
      out.write("                                <label style=\"width: calc(100% - 20px) !important;\" for=\"benhnen_15\">15. Thiếu hụt miễn\r\n");
      out.write("                                    dịch</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" id=\"benhnen_16\" name=\"benh_nen_chi_tiet\" data-noidung=\"Bệnh gan\"\r\n");
      out.write("                                    data-id=\"16\">\r\n");
      out.write("                                <label style=\"width: calc(100% - 20px) !important;\" for=\"benhnen_16\">16. Bệnh\r\n");
      out.write("                                    gan</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" id=\"benhnen_17\" name=\"benh_nen_chi_tiet\"\r\n");
      out.write("                                    data-noidung=\"Rối loạn sử dụng chất gây nghiện\" data-id=\"17\">\r\n");
      out.write("                                <label style=\"width: calc(100% - 20px) !important;\" for=\"benhnen_17\">17. Rối loạn sử\r\n");
      out.write("                                    dụng chất gây nghiện</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" id=\"benhnen_18\" name=\"benh_nen_chi_tiet\"\r\n");
      out.write("                                    data-noidung=\"Sử dụng corticosteroid hoặc các thuốc ức chế miễn dịch khác\"\r\n");
      out.write("                                    data-id=\"18\">\r\n");
      out.write("                                <label style=\"width: calc(100% - 20px) !important;\" for=\"benhnen_18\">18. Sử dụng\r\n");
      out.write("                                    corticosteroid hoặc các thuốc ức chế miễn dịch khác</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" id=\"benhnen_19\" name=\"benh_nen_chi_tiet\"\r\n");
      out.write("                                    data-noidung=\"Các loại bệnh hệ thống\" data-id=\"19\">\r\n");
      out.write("                                <label style=\"width: calc(100% - 20px) !important;\" for=\"benhnen_19\">19. Các loại bệnh\r\n");
      out.write("                                    hệ thống</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <input type=\"checkbox\" id=\"benhnen_20\" name=\"benh_nen_chi_tiet\"\r\n");
      out.write("                                    data-noidung=\"Các bệnh nền của trẻ em theo hướng dẫn BYT (trẻ đẻ non, cân nặng thấp; trẻ béo phì, thừa cân; đái tháo đường, bệnh tim bẩm sinh, các bệnh lý gene và rối loạn chuyển hóa, hen phế quản; bệnh thalassemia, ung thư, bệnh nhân đang điều trị bằng thuốc corticoid hoặc các thuốc ức chế miễn dịch khác,...)\"\r\n");
      out.write("                                    data-id=\"20\">\r\n");
      out.write("                                <label style=\"width: calc(100% - 20px) !important;\" for=\"benhnen_20\">20. Các bệnh nền\r\n");
      out.write("                                    của trẻ em theo hướng dẫn BYT (trẻ đẻ non, cân nặng thấp; trẻ béo phì, thừa cân; đái\r\n");
      out.write("                                    tháo đường, bệnh tim bẩm sinh, các bệnh lý gene và rối loạn chuyển hóa, hen phế\r\n");
      out.write("                                    quản; bệnh thalassemia, ung thư, bệnh nhân đang điều trị bằng thuốc corticoid hoặc\r\n");
      out.write("                                    các thuốc ức chế miễn dịch khác,...)</label>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>                 \r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"dnx_content_bnt\">\r\n");
      out.write("                    <button type=\"button\" id=\"btn-continue\">Tiếp theo</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </section>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--Footer-->\r\n");
      out.write("<footer class=\"footer section section-sm\">\r\n");
      out.write("    <!-- Container Start -->\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-lg-4 col-md-7 offset-md-1 offset-lg-0\">\r\n");
      out.write("                <!-- About -->\r\n");
      out.write("                <div class=\"block about\">\r\n");
      out.write("                    <!-- footer logo -->\r\n");
      out.write("                    <img src=\"images/footer.png\" alt=\"\" width=\"250\">\r\n");
      out.write("                    <!-- description -->\r\n");
      out.write("                    <p class=\"alt-color\">Cuộc sống bận rộn có thể khiến bạn quên đi sức khỏe bản thân,\r\n");
      out.write("                        đặc biệt là mùa covid. Nhưng đến khi bị bệnh, nhiều người lại không muốn đến bệnh viện\r\n");
      out.write("                        vì quá đông và nguy cơ lây nhiễm cao.\r\n");
      out.write("                        Hiểu được điều đó, COVID CARE có thể giúp bạn dễ dàng kết nối với\r\n");
      out.write("                        bác sĩ và tư vấn cũng như hướng dẫn trực tuyến tại nhà.</p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Link list -->\r\n");
      out.write("            <div class=\"col-lg-6 offset-lg-1 col-md-3\" style=\"text-align: right;\">\r\n");
      out.write("                <div class=\"block\">\r\n");
      out.write("                    <h4>Mọi đóng góp ý kiến xin liên hệ</h4>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"#\">Đường dây nóng: 0123456789</a></li>\r\n");
      out.write("                        <li><a href=\"#\">Email: group8@gmail.com</a></li>\r\n");
      out.write("                        <li><a href=\"#\">Website: Covid Care</a></li>\r\n");
      out.write("                        <li><a href=\"#\">Facebook: group8/facebook.com</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Container End -->\r\n");
      out.write("</footer>\r\n");
      out.write("<!-- Footer Bottom -->\r\n");
      out.write("<footer class=\"footer-bottom\">\r\n");
      out.write("    <!-- Container Start -->\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div>\r\n");
      out.write("                <!-- Copyright -->\r\n");
      out.write("                <div class=\"copyright\">\r\n");
      out.write("                    <p style=\"text-align: center;\">Copyright © 2022</p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</footer>");
      out.write("\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.getGroupId() == 3}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                <li class=\"nav-item active\">\r\n");
        out.write("                                <a class=\"nav-link\" href=\"UserInfo\">Thông tin cá nhân</a>\r\n");
        out.write("                            </li>\r\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                                ");
        if (_jspx_meth_c_otherwise_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                    <li class=\"nav-item\">                                   \r\n");
        out.write("                                        <a class=\"nav-link login-button\" href=\"Login\">Đăng Nhập</a> \r\n");
        out.write("                                    </li>\r\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
    if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                    <li class=\"nav-item\">\r\n");
        out.write("                                     <a class=\"nav-link login-button\" href=\"Logout\">Đăng Xuất</a> \r\n");
        out.write("                                    </li>\r\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_otherwise_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
    return false;
  }
}
