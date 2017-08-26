package chapter3;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by zhangyue-k on 2017/8/23.
 * User:zhangyue-k
 * Date:2017/8/23
 */
public class MurmurMessager {
    @Inject
    @Named("murmur")
    private MurmurMessage murmurMessage;

    @Inject
    @Named("broadcast")
    private MurmurMessage broadcatMessage;
}
