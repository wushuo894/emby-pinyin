package emby.pinyin.action;

import cn.hutool.http.server.HttpServerRequest;
import cn.hutool.http.server.HttpServerResponse;
import emby.pinyin.annotation.Path;
import emby.pinyin.util.EmbyUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@Path("/views")
public class ViewsAction implements BaseAction {
    @Override
    public void doAction(HttpServerRequest request, HttpServerResponse response) throws IOException {
        resultSuccess(EmbyUtil.getViews());
    }
}
