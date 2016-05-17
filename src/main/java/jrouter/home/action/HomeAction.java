package jrouter.home.action;

import java.io.IOException;
import java.net.MalformedURLException;
import javax.servlet.http.HttpServletResponse;
import jrouter.annotation.Action;
import jrouter.framework.util.ResultUtil;
import jrouter.framework.util.ServletUtil;
import jrouter.servlet.ServletActionInvocation;
import org.springframework.util.StreamUtils;

/**
 * HomeAction.
 */
public class HomeAction {

    @Action(name = {"home", "index"})
    public String index(ServletActionInvocation invocation) {
        return ResultUtil.renderFreemarker("/template/home.ftlh");
    }

    @Action
    public String doc(ServletActionInvocation invocation) {
        return ResultUtil.renderFreemarker("/template/doc.ftlh");
    }

    @Action(name = {"download", "downloads"})
    public String downloads(ServletActionInvocation invocation) {
        return ResultUtil.renderFreemarker("/template/downloads.ftlh");
    }

    @Action
    public String about(ServletActionInvocation invocation) {
        return ResultUtil.renderFreemarker("/template/about.ftlh");
    }

    @Action
    public void showFactoryStatus(ServletActionInvocation invocation) throws MalformedURLException,
            IOException {
        HttpServletResponse response = invocation.getResponse();
        ServletUtil.setDownloadableHeader(response, "factory-status.jsp");
        StreamUtils.copy(invocation.getServletContext().getResourceAsStream("/factory-status.jsp"), response.getOutputStream());
    }

}
