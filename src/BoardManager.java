import java.util.List;
import java.util.Map;

public class BoardManager {
    Board board=new Board();

    public List<String> getBoardnumber(){
        return board.getBoardnumber();
    }

    public String addPost(String title, String content) {
        String key=board.addPost(title,content);
        return key;
    }

    public Map<String, String> getPost(String key) {
        return board.getPost(key);
    }

    public void removePost(String key){
        board.removePost(key);
    }

    public int getNumberOfPost(){
        return board.getNumberOfPost();
    }

    public void modifyPost(String key, String title, String content) {
        board.modifyPost(key,title,content);
    }

    public void addComment(String key,String comment) {
        board.addComment(key,comment);
    }

    public List<String> getComment(String key) {
        return board.getComment(key);
    }
}
