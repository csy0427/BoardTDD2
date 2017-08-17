import java.util.*;

public class Board {
    Calendar cal;
    Map<String,Map<String,String>> list=new HashMap<>();
    List<String> boardnumber=new ArrayList<>();
    Map<String,List<String>> comments=new HashMap<>();

    public String addPost(String title, String content) {
        String key=getKey();
        boardnumber.add(key);
        Map<String,String> tmpMap=new HashMap<>();
        tmpMap.put("title",title);
        tmpMap.put("content",content);
        List<String> s = new ArrayList<>();
        list.put(key,tmpMap);
        comments.put(key,s);
        return key;
    }

    private String getKey() {
        cal=Calendar.getInstance();
        String tmp_key=Integer.toString(cal.get(Calendar.YEAR)) + Integer.toString(cal.get(Calendar.MONTH)) +
                Integer.toString(cal.get(Calendar.DATE)) + Integer.toString(cal.get(Calendar.MILLISECOND));
        return tmp_key;
    }

    public List<String> getBoardnumber() {
        return boardnumber;
    }

    public void removePost(String key) {
        list.remove(key);
        System.out.println(boardnumber.indexOf(key));
        boardnumber.remove(boardnumber.indexOf(key));
    }

    public int getNumberOfPost() {
        return boardnumber.size();
    }

    public void modifyPost(String key, String title, String content) {
        list.get(key).put("title",title);
        list.get(key).put("content",content);
    }

    public void addComment(String key, String comment) {
        comments.get(key).add(comment);
    }

    public List<String> getComment(String key) {
        return comments.get(key);
    }

    public Map<String,String> getPost(String key) {
        return list.get(key);
    }
}
