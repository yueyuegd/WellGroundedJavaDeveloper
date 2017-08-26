package chapter3;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by zhangyue-k on 2017/8/23.
 * User:zhangyue-k
 * Date:2017/8/23
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface MusicGenre {
    GENRE genre() default GENRE.TRANCE;
    public enum GENRE {CLASSICAL,METAL,ROCK,TRANCE}

}

