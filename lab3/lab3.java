import java_cup.runtime.*;
import CPP.*;
import CPP.Absyn.*;
import java.io.*;

public class lab3 {
    public static void main(String args[]) {
        if (args.length != 1) {
            System.err.println("Usage: lab3 <SourceFile>");
            System.exit(1);
        }

        Yylex l = null;
        String filePath = args[0];
        try {
            l = new Yylex(new FileReader(filePath));
            parser p = new parser(l);
            CPP.Absyn.Program parse_tree = p.pProgram();
            new TypeChecker().typecheck(parse_tree);
            new Compiler().compile(stripSuffix(stripPath(filePath)), parse_tree);

        } catch (TypeException e) {
            System.out.println("TYPE ERROR");
            System.err.println(e.toString());
            System.exit(1);
        } catch (RuntimeException e) {
            //            System.out.println("RUNTIME ERROR");
            System.err.println(e.toString());
            System.exit(-1);
        } catch (IOException e) {
            System.err.println(e.toString());
            System.exit(1);
        } catch (Throwable e) {
            System.out.println("SYNTAX ERROR");
            System.out.println("At line " + String.valueOf(l.line_num())
                       + ", near \"" + l.buff() + "\" :");
            System.out.println("     " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    // Remove path from input file
    private static String stripPath(String name) {
        return new File(name).getName();
    }

    // Remove extension from input file
    private static String stripSuffix(String fileName) {
        int divider = fileName.lastIndefOf('.');
        if (divider <= 0) {
            return fileName;
        } else {
            return fileName.substring(0, divider);
        }
    }
}

