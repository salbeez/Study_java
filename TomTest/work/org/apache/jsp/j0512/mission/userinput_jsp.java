/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.14
 * Generated at: 2017-05-12 09:46:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.j0512.mission;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userinput_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Users/kosta/git/Study_java/TomTest/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1494566406902L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\tfunction idCheck() {\r\n");
      out.write("\t\tvar setting = 'width=240, height=70, menubar=no, status=no, toolbar=no, location=no,resizable=no';\r\n");
      out.write("\t\twindow.open('duple.jsp', 'window팝업', setting);\r\n");
      out.write("\r\n");
      out.write("\t}\n");
      out.write("</script>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>사용자등록</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<center>\r\n");
      out.write("\t\t<form name=\"frm\" action=\"userprocess.jsp\" method=\"post\">\r\n");
      out.write("\t\t\t<table width=\"600\" border=\"0\" cellpadding=\"5\">\r\n");
      out.write("\t\t\t\t<tr bgcolor=\"#3399cc\">\r\n");
      out.write("\t\t\t\t\t<td><font size=\"4\" color=\"white\">사용자정보입력</font>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>안녕하세요. 이 페이지를 자유롭게 이용하려면 먼저 회원가입을 하셔야 합니다.<br> 아래의\r\n");
      out.write("\t\t\t\t\t\t사항들을 빠짐없이 기록해 주세요.\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<table border=\"1\" cellpadding=\"5\" width=\"600\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"100\" bgcolor=\"#ffcccc\">사용자ID<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"3\"><input type=\"text\" name=\"id\" readonly\r\n");
      out.write("\t\t\t\t\t\tonclick=\"idCheck()\"> <input type=\"button\" value=\"중복확인\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"idCheck()\"> <font color=\"blue\">(6자리~12자리)</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"100\" bgcolor=\"#ffcccc\">비밀번호<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"password\" name=\"pass\"></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"100\" bgcolor=\"#ffcccc\">비번확인</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"password\" name=\"pass2\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"100\" bgcolor=\"#ffcccc\">사용자이름<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"3\"><input type=\"text\" name=\"name\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"100\" bgcolor=\"#ffcccc\">주민번호<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"3\"><input type=\"text\" name=\"jumin1\" size=\"6\"\r\n");
      out.write("\t\t\t\t\t\tmaxlength=\"6\" style=\"height: 23px\"> - <input\r\n");
      out.write("\t\t\t\t\t\ttype=\"password\" name=\"jumin2\" size=\"7\" maxlength=\"7\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"height: 23px\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"100\" bgcolor=\"#ffcccc\">생년월일</td>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"3\"><input type=\"text\" name=\"year\" size=\"4\"\r\n");
      out.write("\t\t\t\t\t\tmaxlength=\"4\">년 <select name=\"month\">\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t</select> <select name=\"day\">\r\n");
      out.write("\t\t\t\t\t</select>일</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"100\" bgcolor=\"#ffcccc\">우편번호<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"3\"><input type=\"text\" name=\"zip1\" size=\"3\"\r\n");
      out.write("\t\t\t\t\t\tmaxlength=\"3\"> - <input type=\"text\" name=\"zip2\" size=\"3\"\r\n");
      out.write("\t\t\t\t\t\tmaxlength=\"3\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"100\" bgcolor=\"#ffcccc\">주소</td>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"3\"><input type=\"text\" name=\"addr\" size=\"50\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"100\" bgcolor=\"#ffcccc\">E-Mail<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"3\"><input type=\"text\" name=\"email\" size=\"30\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"100\" bgcolor=\"#ffcccc\">직업<font color=\"red\">*</font></td>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"3\"><select name=\"job\">\r\n");
      out.write("\t\t\t\t\t\t\t");

								String jobs[] = { "==선택==", "학생", "공무원", "언론/출판", "군인/경찰", "일반사무직", "영업직", "기술/전문직", "보건/의료", "자영업", "주부",
										"기타" };
								for (int i = 0; i < jobs.length; i++) {
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<option>");
      out.print(jobs[i]);
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t");

								}
							
      out.write("\r\n");
      out.write("\t\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t<td colspan=\"4\"><input type=\"submit\" value=\"등록\"> <input\r\n");
      out.write("\t\t\t\t\t\ttype=\"reset\" value=\"취소\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</center>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function aaa(){\r\n");
      out.write("\tvar job =  document.;\r\n");
      out.write("\talert(job);\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /j0512/mission/userinput.jsp(59,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("i");
      // /j0512/mission/userinput.jsp(59,6) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setBegin(1);
      // /j0512/mission/userinput.jsp(59,6) name = end type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setEnd(12);
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t<option>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${i }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write(" 월</option>\t\t\t\t\t\t\r\n");
            out.write("\t\t\t\t\t\t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fend_005fbegin.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}