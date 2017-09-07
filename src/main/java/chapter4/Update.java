package chapter4;

/**
 * Created by zhangyue-k on 2017/8/26.
 * User:zhangyue-k
 * Date:2017/8/26
 */
public class Update {

    private final String updateText;
    private final Author author;

    public Update(Builder b) {
        author = b.author;
        updateText = b.updateText;
    }



    public static class Builder implements ObjBuilder<Update>{
        private Author author;
        private String updateText;

        public Builder author(Author author1){
            author = author1;
            return this;
        }

        public Builder updateText(String updateText1){
            updateText = updateText1;
            return this;
        }

        public Update build(){
            return new Update(this);
        }
    }
    public String getUpdateText() {
        return updateText;
    }

    @Override
    public String toString() {
        return "Update{" +
                "updateText='" + updateText + '\'' +
                ", author=" + author +
                '}';
    }

    public static void main(String[] args) {
        Update.Builder ub = new Update.Builder();
        Author myAuthor = new Author("");
        Update u = ub.author(myAuthor).updateText("Hello").build();
    }


}
