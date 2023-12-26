import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Usage {
    public static void main (String[] args) throws IOException {
        if(args[0] == null) return;
        InputStream is = new FileInputStream(args[0]);
        Analyzer analyzer = new Analyzer();
        String SQL = analyzer.DSLtoSQL(is);
        if(SQL.length()>0) System.out.println(SQL);
        else System.out.println("fail to convert...");
    }
}
