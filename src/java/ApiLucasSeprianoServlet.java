/** @author lucas Sepriano **/
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/lucassepriano.json")
public class ApiLucasSeprianoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json");
        
        String ra = "1290482212002";
        String nome = "Lucas Sepriano";

        String[] disciplinas = {	
            "HSO003-Ética e Responsabilidade Profissional",
            "IBD002-Banco de Dados",
            "IES300-Engenharia de Software III",
            "ILP007-Programação Orientada a Objetos",
            "ILP512-Linguagem de Programação IV - INTERNET",
            "ISO200-Sistemas Operacionais II",
            "LIN400-Inglês IV",
            "TTG001-Metodologia da Pesquisa Científico-Tecnológica"
        };

        String json = "{\"RA\":\"" + ra + "\",\"Nome\":\"" + nome + "\",\"Disciplinas\":[";
        
        for (int i = 0; i < disciplinas.length; i++) {
            json += "\"" + disciplinas[i] + "\"";
            if (i < disciplinas.length - 1) {
                json += ",";
            }
        }
        
        json += "]}";


        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }
}
