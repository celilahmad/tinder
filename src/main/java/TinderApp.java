import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class TinderApp {

    public static void main(String[] args) throws Exception {

    Server server = new Server(9000);
    ServletContextHandler handler = new ServletContextHandler();

    handler.addServlet(new ServletHolder(new TestServlet()), "/users");
    handler.addServlet(new ServletHolder(new LoginServlet()), "/login");
    handler.addServlet(new ServletHolder(new LikeDislikeHandler()), "/handler");
    /*handler.addServlet(new ServletHolder(new StaticServlet("images")), "/images/*");
    handler.addServlet(new ServletHolder(new StaticServlet("js")), "/js/*");
    handler.addServlet(new ServletHolder(new StaticServlet("css")), "/css/*");
    handler.addServlet(new ServletHolder(new CalcServlet()), "/calc/*");
    handler.addServlet(new ServletHolder(new LoginServlet()), "/login/*");
    handler.addServlet(new ServletHolder(new RedirectServlet("/login")), "/*");*/

    server.setHandler(handler);

    server.start();
    server.join();

}
}
