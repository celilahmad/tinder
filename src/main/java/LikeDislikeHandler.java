import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LikeDislikeHandler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Map<String, Integer> value = new HashMap<>();
        value.put("liked",0);
        value.put("disliked", 0);

        PrintWriter out = resp.getWriter();

        if (req.getParameter("dislike") != null) {
            value.put("disliked", value.get("disliked") + 1);
            for (Map.Entry<String, Integer> entry : value.entrySet()) {
                out.write(entry.getKey()+" : "+entry.getValue() + "\n");
            }



        } else if (req.getParameter("like") != null) {
            value.put("liked", value.get("liked") + 1);
            for (Map.Entry<String, Integer> entry : value.entrySet()) {
                out.write(entry.getKey()+" : "+entry.getValue() + "\n");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req, resp);
    }
}
