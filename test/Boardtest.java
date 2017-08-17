import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
public class Boardtest {

    BoardManager manager=new BoardManager();
    String title="aaa";
    String content="bbb";
    String key;
    Map<String,String> tmpMap=new HashMap<>();

    @Before
    public void setUp(){
        key=manager.addPost(title,content);
    }

    @Test
    public void 게시글등록(){
        String title="ccc";
        String content="ddd";
        String key=manager.addPost(title,content);
        tmpMap=manager.getPost(key);
        assertEquals(title,tmpMap.get("title"));
        assertEquals(content,tmpMap.get("content"));
    }

    @Test
    public void 게시글읽기(){
        tmpMap=manager.getPost(key);
        assertEquals(title,tmpMap.get("title"));
        assertEquals(content,tmpMap.get("content"));
    }

    @Test
    public void 게시글수정(){
        tmpMap=manager.getPost(key);
        String title="111";
        String content="222";
        manager.modifyPost(key,title,content);
        assertEquals(title,tmpMap.get("title"));
        assertEquals(content,tmpMap.get("content"));
    }

    @Test
    public void 게시글리스트(){
        List<String> boardnumber=manager.getBoardnumber();
        for(int i=0;i<boardnumber.size();i++){
            String key=boardnumber.get(i);
            tmpMap=manager.getPost(key);
            assertEquals(title,tmpMap.get("title"));
            assertEquals(content,tmpMap.get("content"));
        }
    }

    @Test
    public void 게시글삭제(){
        assertEquals(1,manager.getNumberOfPost());
        manager.removePost(key);
        assertEquals(0,manager.getNumberOfPost());
    }

    @Test
    public void 댓글등록(){
        String comment="commenttttt";
        manager.addComment(key,comment);
        List<String> tmp_comment = manager.getComment(key);
        assertEquals(comment,tmp_comment.get(0));
    }

}
