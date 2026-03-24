package emby.pinyin.action;

import cn.hutool.http.server.HttpServerRequest;
import cn.hutool.http.server.HttpServerResponse;
import emby.pinyin.annotation.Path;
import emby.pinyin.entity.Status;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@Path("/status")
public class StatusAction implements BaseAction {
    public static Status STATUS = new Status();

    static {
        STATUS.setCurrent(0L)
                .setTotal(0L)
                .setLoading(false)
                .setStart(false);
    }

    @Override
    public void doAction(HttpServerRequest request, HttpServerResponse response) throws IOException {
        resultSuccess(STATUS);
    }
}
