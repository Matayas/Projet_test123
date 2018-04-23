package gilm10129104.laboratoire11;

/**
 * Created by gilm101291 on 2018-04-19.
 */
public class QuestionInvalideExeption extends Exception {

    private String fichier;
    private int noQuestion;

    public QuestionInvalideExeption(String fichier,int noQuestion,Exception e){
        this.fichier=fichier;
        this.noQuestion=noQuestion;
    }
    //Comment utiliser e pour avoir l'erreur et son message
    public String getMessage(){
        return "La question no : " + noQuestion + " Est invalide dans le fichier --> "+fichier ;
    }
}
