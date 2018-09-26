package fr.brucella.projects.libraryclients.webapp.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import fr.brucella.projects.libraryclients.webapp.actions.users.UserAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;

public class LoginInterceptor extends AbstractInterceptor implements StrutsStatics {

  /**
   * Login Interception logger.
   */
  private static final Log LOG = LogFactory.getLog(LoginInterceptor.class);

  /**
   * Name of the attribute in HttpSession which store the user.
   */
  private static final String USER_IN_SESSION = "userLog";

  /**
   * Initialization of the LoginInterceptor.
   */
  public void init() {
    LOG.info("Initializing LoginInterceptor");
  }

  /**
   * Destroy the LoginInterceptor.
   */
  public void destroy() {

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String intercept(final ActionInvocation invocation) throws Exception {

    final ActionContext context = invocation.getInvocationContext();
    HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
    HttpSession session = request.getSession(true);

    Object user = session.getAttribute(USER_IN_SESSION);
    if (user == null) {
      if (invocation.getAction().getClass().equals(UserAction.class)) {
        return invocation.invoke();
      }
      return "index";
    } else {
      return invocation.invoke();
    }
  }
}
