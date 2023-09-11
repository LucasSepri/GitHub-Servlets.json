/** @author lucas Sepriano **/
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loteria.json")
public class ApiLoteriaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        
        Date dataHoraAtual = new Date();
        
        int[] numerosLoteria = gerarNumerosLoteria(6);
        
        String json = "{\"data_hora\": \"" + dataHoraAtual.toString() + "\", \"numeros\": [";
        for (int i = 0; i < numerosLoteria.length; i++) {
            json += numerosLoteria[i];
            if (i < numerosLoteria.length - 1) {
                json += ", ";
            }
        }
        json += "]}";
        
        out.print(json);
    }
    
    private int[] gerarNumerosLoteria(int quantidade) {
        int[] numeros = new int[quantidade];
        Random rand = new Random();
        for (int i = 0; i < quantidade; i++) {
            numeros[i] = rand.nextInt(60) + 1; 
        }
        return numeros;
    }
}
