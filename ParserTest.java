interface Parseable{
    // = public abstract void parse(String fileName);
    void parse(String fileName);
}

class ParserManager{
    // return type = interface ---> return class instance which implments interface
    public static Parseable getParser(String type){
        if(type.equals("XML")){
            return new XMLParser();
        }
        else{
            // = return new HTMLParser();
            Parseable p = new HTMLParser();
            return p;
        }
    }
}

class XMLParser implements Parseable{
    public void parse(String fileName){
        System.out.println(fileName + "- XML parsing completed.");
    }
}

class HTMLParser implements Parseable{
    public void parse(String fileName){
        System.out.println(fileName + "- HTML parsing completed.");
    }
}

public class ParserTest {
    public static void main(String[] args) {
        Parseable parser = ParserManager.getParser("XML");
        parser.parse("documents.XML");
        parser = ParserManager.getParser("HTML");
        parser.parse("documents2.html");
    }
}
