package wint.mvc;

import junit.framework.TestCase;
import wint.core.config.Constants;
import wint.lang.magic.MagicMap;
import wint.mvc.servlet.mock.HttpServletRequestMock;
import wint.mvc.servlet.mock.HttpServletResponseMock;
import wint.mvc.servlet.mock.ServletConfigMock;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherTests extends TestCase {

    private DispatcherServlet dispatcherServlet;
    private ServletConfig servletConfigMock;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        dispatcherServlet = new DispatcherServlet();

        MagicMap initParameters = MagicMap.newMagicMap();
        initParameters.put(Constants.PropertyKeys.APP_PACKAGE, "wint.demo.app");
        initParameters.put(Constants.PropertyKeys.TEMPLATE_PATH, "test_template");
        initParameters.put(Constants.PropertyKeys.WINT_SESSION_USE, "true");
        initParameters.put(Constants.PropertyKeys.APP_ENV, "product");
        servletConfigMock = new ServletConfigMock(initParameters, initParameters);
        dispatcherServlet.init(servletConfigMock);
    }

    public void testForm() throws ServletException, IOException {
        MagicMap parameters = MagicMap.newMagicMap();
        HttpServletRequest request = new HttpServletRequestMock("/hello/doRegister", parameters, servletConfigMock.getServletContext());
        HttpServletResponseMock response = new HttpServletResponseMock();
        dispatcherServlet.service(request, response);
    }

    public void testSayWords() throws ServletException, IOException {
        MagicMap parameters = MagicMap.newMagicMap();
        HttpServletRequest request = new HttpServletRequestMock("hello/say-words/555-66--88", parameters, servletConfigMock.getServletContext());
        HttpServletResponse response = new HttpServletResponseMock();
        dispatcherServlet.service(request, response);
    }

    public void testToString() throws ServletException, IOException {
        MagicMap parameters = MagicMap.newMagicMap();
        HttpServletRequest request = new HttpServletRequestMock("hello/to-string", parameters, servletConfigMock.getServletContext());
        HttpServletResponse response = new HttpServletResponseMock();
        dispatcherServlet.service(request, response);
    }

    public void testDoRegister() throws ServletException, IOException {
        MagicMap parameters = MagicMap.newMagicMap();
        parameters.put("name", "测试2");
        parameters.put("password", "xxxyyzzzdd");
        HttpServletRequest request = new HttpServletRequestMock("hello/doRegister", parameters, servletConfigMock.getServletContext());
        HttpServletResponse response = new HttpServletResponseMock();
        dispatcherServlet.service(request, response);
    }

    public void testReg() throws ServletException, IOException {
        MagicMap parameters = MagicMap.newMagicMap();
        parameters.put("name", "测试3");
        HttpServletRequest request = new HttpServletRequestMock("hello/reg", parameters, servletConfigMock.getServletContext());
        HttpServletResponse response = new HttpServletResponseMock();
        dispatcherServlet.service(request, response);
    }

    public void testHelloResult() throws ServletException, IOException {
        MagicMap parameters = MagicMap.newMagicMap();
        HttpServletRequest request = new HttpServletRequestMock("hello/helloResult", parameters, servletConfigMock.getServletContext());
        HttpServletResponse response = new HttpServletResponseMock();
        dispatcherServlet.service(request, response);
    }

    public void testTheJson() throws ServletException, IOException {
        MagicMap parameters = MagicMap.newMagicMap();
        HttpServletRequest request = new HttpServletRequestMock("hello/theJson", parameters, servletConfigMock.getServletContext());
        HttpServletResponse response = new HttpServletResponseMock();
        dispatcherServlet.service(request, response);
    }

    public void testRawContent() throws ServletException, IOException {
        MagicMap parameters = MagicMap.newMagicMap();
        HttpServletRequest request = new HttpServletRequestMock("hello/theRawText", parameters, servletConfigMock.getServletContext());
        HttpServletResponse response = new HttpServletResponseMock();
        dispatcherServlet.service(request, response);
    }

    public void testHttl() throws ServletException, IOException {
        MagicMap parameters = MagicMap.newMagicMap();
        HttpServletRequest request = new HttpServletRequestMock("hello/hello2", parameters, servletConfigMock.getServletContext());
        HttpServletResponse response = new HttpServletResponseMock();
        dispatcherServlet.service(request, response);
    }

    public void testI18n() throws ServletException, IOException {
        MagicMap parameters = MagicMap.newMagicMap();
        HttpServletRequestMock request = new HttpServletRequestMock("hello/i18n", parameters, servletConfigMock.getServletContext());
        // request.getHeaders().put("Accept-Language", "en-US");
        HttpServletResponse response = new HttpServletResponseMock();
        dispatcherServlet.service(request, response);
    }

    public void testFileAsDefault() throws ServletException, IOException {
        for (int i = 0; i < 3; ++i) {
            MagicMap parameters = MagicMap.newMagicMap();
            HttpServletRequestMock request = new HttpServletRequestMock("user", parameters, servletConfigMock.getServletContext());
            HttpServletResponse response = new HttpServletResponseMock();
            dispatcherServlet.service(request, response);
        }
    }

    public void testUser() throws ServletException, IOException {
        MagicMap parameters = MagicMap.newMagicMap();
        HttpServletRequest request = new HttpServletRequestMock("user", parameters, servletConfigMock.getServletContext());
        HttpServletResponse response = new HttpServletResponseMock();
        dispatcherServlet.service(request, response);
    }


}
